/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import DAO.Interfaces.IPedidoDAO;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Entidades.Platillo;
import Entidades.Ubicacion;
import Mappers.DetallePedidoMapper;
import Mappers.PedidoMapper;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import dto.AlumnoDTO;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import dto.UbicacionDTO;
import java.util.logging.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PC Gamer
 */
public class PedidoDAO implements IPedidoDAO {

    @Override
    public boolean existePedidoConFolio(String folio) {
        MongoClient conexion = null;

        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase baseDatos = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Pedidos");

            Bson filtro = Filters.eq("folio", folio);
            Document documento = coleccion.find(filtro).first();

            return documento != null;

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    @Override
    public String crearFolioPedido() {
        MongoClient conexion = null;

        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase baseDatos = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Pedidos");

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaHoy = sdf.format(new Date());

            String patron = "KWA-" + fechaHoy + "-";
            Pattern regex = Pattern.compile("^" + Pattern.quote(patron));

            Bson filtro = Filters.regex("folio", regex);

            int maxConsecutivo = -1;

            try (MongoCursor<Document> cursor = coleccion.find(filtro).iterator()) {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    String folio = doc.getString("folio");

                    if (folio != null && folio.startsWith(patron)) {
                        String[] partes = folio.split("-");
                        if (partes.length == 3) {
                            try {
                                int consecutivo = Integer.parseInt(partes[2]);
                                if (consecutivo > maxConsecutivo) {
                                    maxConsecutivo = consecutivo;
                                }
                            } catch (NumberFormatException ignored) {
                            }
                        }
                    }
                }
            }

            int siguiente = maxConsecutivo + 1;
            String consecutivoStr = String.format("%03d", siguiente);
            String nuevoFolio = patron + consecutivoStr;

            if (existePedidoConFolio(nuevoFolio)) {
                throw new RuntimeException("Ya existe un pedido con el folio generado: " + nuevoFolio);
            }

            return nuevoFolio;

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    @Override
    public List<DetallePedido> convertirADetallePedidoEntity(List<DetallePedidoDTO> detalleDTOs) {
        List<DetallePedido> detalles = new ArrayList<>();
        PlatilloDAO platilloDAO = new PlatilloDAO();

        for (DetallePedidoDTO dto : detalleDTOs) {

            Platillo platillo = platilloDAO.obtenerPlatilloPorNombre(dto.getNombrePlatillo());

            if (platillo == null) {
                throw new RuntimeException("No se encontró el platillo con nombre: " + dto.getNombrePlatillo());
            }

            DetallePedido detalle = DetallePedidoMapper.toEntity(dto, platillo.getIdPlatillo()); // El ID hexadecimal de Mongo
            detalles.add(detalle);
        }

        return detalles;
    }

    @Override
    public Pedido mapearPedidoCompleto(
            PedidoDTO pedidoDTO,
            List<DetallePedidoDTO> listaDetalleDTO,
            String idAlumno,
            String idCocinero,
            String idRepartidor
    ) throws Exception {

        List<DetallePedido> detalles = convertirADetallePedidoEntity(listaDetalleDTO);

        double total = detalles.stream().mapToDouble(DetallePedido::getSubtotal).sum();
        pedidoDTO.setTotal(total);

        if (pedidoDTO.getFolio() == null) {
            pedidoDTO.setFolio(crearFolioPedido());

        }

        Pedido pedido = PedidoMapper.toEntity(
                pedidoDTO,
                idAlumno,
                idCocinero,
                idRepartidor,
                detalles
        );

        return pedido;
    }

    @Override
    public boolean crearPedido(PedidoDTO pedidoDTO,
            List<DetallePedidoDTO> detalleDTOs,
            String idAlumno) {
        MongoClient conexion = null;
        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = db.getCollection("Pedidos");

            AlumnoDAO alumnoDAO = new AlumnoDAO();

            AlumnoDTO alumnoNombre = alumnoDAO.recuperarAlumnoPorId(idAlumno);
            pedidoDTO.setNombreAlumno(alumnoNombre.getNombreCompleto());

            UbicacionDAO ubicacionDAO = new UbicacionDAO();
            Ubicacion ubicacion = ubicacionDAO.buscarUbicacionPorEdificioYSalon(pedidoDTO.getUbicacionEntrega());
            pedidoDTO.setNombreCocinero(null);
            pedidoDTO.setNombreRepartidor(null);
            pedidoDTO.setPagado(false);
            pedidoDTO.setEstado("PENDIENTE");
            pedidoDTO.setFolio(crearFolioPedido());
            if (ubicacion == null) {
                throw new Exception("La ubicacion No Existe");
            }

            Pedido pedidoEntity = mapearPedidoCompleto(
                    pedidoDTO,
                    detalleDTOs,
                    idAlumno,
                    null,
                    null
            );

            List<Document> detallesDocs = new ArrayList<>();
            for (DetallePedido det : pedidoEntity.getPlatillos()) {
                detallesDocs.add(new Document()
                        .append("idPlatillo", det.getIdPlatillo())
                        .append("nombrePlatillo", det.getNombrePlatillo())
                        .append("cantidad", det.getCantidad())
                        .append("precioUnitario", det.getPrecioUnitario())
                        .append("subtotal", det.getSubtotal())
                        .append("nota", det.getNota())
                );
            }

            Document pedidoDoc = new Document()
                    .append("folio", pedidoEntity.getFolio())
                    .append("idAlumno", pedidoEntity.getIdAlumno())
                    .append("nombreAlumno", pedidoEntity.getNombreAlumno())
                    .append("ubicacionEntrega", new Document()
                            .append("edificio", pedidoEntity.getUbicacionEntrega().getEdificio())
                            .append("salon", pedidoEntity.getUbicacionEntrega().getSalon())
                    )
                    .append("telefonoContacto", pedidoEntity.getTelefonoContacto())
                    .append("instruccionesEntrega", pedidoEntity.getInstruccionesEntrega())
                    .append("fechaPedido", pedidoEntity.getFechaPedido())
                    .append("estado", pedidoEntity.getEstado())
                    .append("nombreCocinero", pedidoEntity.getNombreCocinero())
                    .append("nombreRepartidor", pedidoEntity.getNombreRepartidor())
                    .append("platillos", detallesDocs)
                    .append("total", pedidoEntity.getTotal())
                    .append("pagado", pedidoEntity.getPagado())
                    .append("idCocinero", pedidoEntity.getIdCocinero())
                    .append("idRepartidor", pedidoEntity.getIdRepartidor());

            PlatilloDAO platilloDAO = new PlatilloDAO();
            StringBuilder mensajeError = new StringBuilder();
            if (!platilloDAO.hayExistenciasSuficientesSB(pedidoEntity.getPlatillos(), mensajeError)) {
                throw new Exception(mensajeError.toString());
            }

            coleccion.insertOne(pedidoDoc);

            for (DetallePedido det : pedidoEntity.getPlatillos()) {
                Platillo platillo = platilloDAO.obtenerPlatilloPorNombre(det.getNombrePlatillo());
                int nuevasExistencias = platillo.getExistencias() - det.getCantidad();
                platilloDAO.actualizarExistenciasPlatillo(platillo, nuevasExistencias);
            }

            return true;

        } catch (Exception e) {
            System.err.println("Error al crear pedido: " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Error al crear pedido", e);
            return false;
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    private static final Logger LOGGER = Logger.getLogger(PedidoDAO.class.getName());

    public boolean revisarExistenciasPlatillo(List<DetallePedido> detalles, StringBuilder mensajeError) {
        PlatilloDAO platilloDAO = new PlatilloDAO();
        for (DetallePedido detalle : detalles) {
            Platillo platillo = platilloDAO.obtenerPlatilloPorNombre(detalle.getNombrePlatillo());
            if (platillo == null) {
                mensajeError.append("No se encontró el platillo: ").append(detalle.getNombrePlatillo()).append("\n");
                return false;
            }
            if (detalle.getCantidad() > platillo.getExistencias()) {
                mensajeError.append("No hay suficientes existencias para: ")
                        .append(detalle.getNombrePlatillo())
                        .append(" (disponible: ").append(platillo.getExistencias())
                        .append(", solicitado: ").append(detalle.getCantidad()).append(")\n");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean cambiarEstadoPedido(String folio, String nuevoEstado) {
        MongoClient conexion = null;
        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = db.getCollection("Pedidos");

            Bson filtro = Filters.eq("folio", folio);
            Bson actualizacion = Updates.set("estado", nuevoEstado);

            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            System.err.println("Error al cambiar el estado del pedido: " + e.getMessage());
            return false;
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    @Override
    public List<PedidoDTO> obtenerHistorialPlatillosPorAlumno(String nombreAlumno) {
        MongoClient conexion = null;
        List<PedidoDTO> historial = new ArrayList<>();

        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = db.getCollection("Pedidos");

            // Filtro por nombre del alumno
            Bson filtro = Filters.eq("nombreAlumno", nombreAlumno);
            FindIterable<Document> documentos = coleccion.find(filtro);

            for (Document doc : documentos) {
                PedidoDTO pedido = new PedidoDTO();
                pedido.setFolio(doc.getString("folio"));
                pedido.setNombreAlumno(doc.getString("nombreAlumno"));
                pedido.setTelefonoContacto(doc.getString("telefonoContacto"));
                pedido.setInstruccionesEntrega(doc.getString("instruccionesEntrega"));
                pedido.setFechaPedido(doc.getDate("fechaPedido"));
                pedido.setEstado(doc.getString("estado"));
                pedido.setNombreCocinero(doc.getString("nombreCocinero"));
                pedido.setNombreRepartidor(doc.getString("nombreRepartidor"));
                pedido.setTotal(doc.getDouble("total"));
                pedido.setPagado(doc.getBoolean("pagado"));

                // Ubicación
                Document ubicacionDoc = (Document) doc.get("ubicacionEntrega");
                if (ubicacionDoc != null) {
                    UbicacionDTO ubicacionDTO = new UbicacionDTO();
                    ubicacionDTO.setEdificio(ubicacionDoc.getString("edificio"));
                    ubicacionDTO.setSalon(ubicacionDoc.getString("salon"));
                    pedido.setUbicacionEntrega(ubicacionDTO);
                }

                // Lista de platillos
                List<DetallePedidoDTO> detalles = new ArrayList<>();
                List<Document> platillosDocs = (List<Document>) doc.get("platillos");
                if (platillosDocs != null) {
                    for (Document detDoc : platillosDocs) {
                        DetallePedidoDTO detalle = new DetallePedidoDTO();
                        detalle.setNombrePlatillo(detDoc.getString("nombrePlatillo"));
                        detalle.setCantidad(detDoc.getInteger("cantidad"));
                        detalle.setPrecioUnitario(detDoc.getDouble("precioUnitario"));
                        detalle.setSubtotal(detDoc.getDouble("subtotal"));
                        detalle.setNota(detDoc.getString("nota"));
                        detalles.add(detalle);
                    }
                }

                pedido.setPlatillos(detalles);

                historial.add(pedido);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener historial: " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Error al obtener historial de pedidos por alumno", e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return historial;
    }

    
    
    
    
    
    public List<PedidoDTO> obtenerPedidosPendientes() {
        MongoClient conexion = null;
        List<PedidoDTO> pedidosPendientes = new ArrayList<>();

        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = db.getCollection("Pedidos");

            Bson filtro = Filters.eq("estado", "PENDIENTE");
            FindIterable<Document> documentos = coleccion.find(filtro);

            for (Document doc : documentos) {
                PedidoDTO pedido = construirPedidoDesdeDocumento(doc);
                pedidosPendientes.add(pedido);
            }
        } catch (MongoException e) {
            System.err.println("Error al obtener pedidos pendientes: " + e.getMessage());
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return pedidosPendientes;
    }

    public boolean asignarCocineroAPedido(String folioPedido, String idCocinero, String nombreCocinero) {
        MongoClient conexion = null;
        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = db.getCollection("Pedidos");

            Bson filtro = Filters.eq("folio", folioPedido);
            Bson actualizacion = Updates.combine(
                    Updates.set("idCocinero", idCocinero),
                    Updates.set("nombreCocinero", nombreCocinero),
                    Updates.set("estado", "EN_PREPARACION")
            );

            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            System.err.println("Error al asignar cocinero al pedido: " + e.getMessage());
            return false;
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private PedidoDTO construirPedidoDesdeDocumento(Document doc) {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setFolio(doc.getString("folio"));
        pedido.setNombreAlumno(doc.getString("nombreAlumno"));

        Document ubicacionDoc = (Document) doc.get("ubicacionEntrega");
        UbicacionDTO ubicacion = new UbicacionDTO();
        ubicacion.setEdificio(ubicacionDoc.getString("edificio"));
        ubicacion.setSalon(ubicacionDoc.getString("salon"));
        pedido.setUbicacionEntrega(ubicacion);

        pedido.setTotal(doc.getDouble("total"));
        pedido.setFechaPedido(doc.getDate("fechaPedido"));
        pedido.setEstado(doc.getString("estado"));

        List<DetallePedidoDTO> detalles = new ArrayList<>();
        List<Document> platillosDocs = (List<Document>) doc.get("platillos");

        for (Document detDoc : platillosDocs) {
            DetallePedidoDTO detalle = new DetallePedidoDTO();
            detalle.setNombrePlatillo(detDoc.getString("nombrePlatillo"));
            detalle.setCantidad(detDoc.getInteger("cantidad"));
            detalle.setPrecioUnitario(detDoc.getDouble("precioUnitario"));
            detalle.setSubtotal(detDoc.getDouble("subtotal"));
            detalle.setNota(detDoc.getString("nota"));
            detalles.add(detalle);
        }

        pedido.setPlatillos(detalles);
        return pedido;
    }

    public PedidoDTO obtenerPedidoPorFolio(String folio) {
        MongoClient conexion = null;
        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = db.getCollection("Pedidos");

            Bson filtro = Filters.eq("folio", folio);
            Document documento = coleccion.find(filtro).first();

            if (documento != null) {
                return construirPedidoDesdeDocumento(documento);
            }

            return null;
        } catch (MongoException e) {
            System.err.println("Error al obtener pedido por folio: " + e.getMessage());
            return null;
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

    }
}
