/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Entidades.Platillo;
import Mappers.DetallePedidoMapper;
import Mappers.PedidoMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PC Gamer
 */
public class PedidoDAO {

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

}
