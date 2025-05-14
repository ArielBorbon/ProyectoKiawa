/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import DAO.Interfaces.IRepartidorDAO;
import Entidades.Repartidor;
import Mappers.RepartidorMapper;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import dto.RepartidorDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PC Gamer
 */
public class RepartidorDAO implements IRepartidorDAO {

    @Override
    public boolean crearRepartidor(RepartidorDTO dto, String contrasena) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            String nuevoID = crearIDFriendly();

            dto.setIdRepartidor(nuevoID);
            Repartidor repartidor = RepartidorMapper.toEntity(dto, contrasena);

            Document doc = new Document("idRepartidor", repartidor.getIdRepartidor())
                    .append("nombreCompleto", repartidor.getNombreCompleto())
                    .append("telefono", repartidor.getTelefono())
                    .append("disponible", repartidor.getDisponible())
                    .append("contrasena", repartidor.getContrasena())
                    .append("domicilio", repartidor.getDomicilio())
                    .append("apodo", repartidor.getApodo())
                    .append("salarioDiario", repartidor.getSalarioDiario())
                    .append("diasTrabajo", repartidor.getDiasTrabajo())
                    .append("Horario", repartidor.getHorario())
                    .append("consideracionesExtras", repartidor.getConsideracionesExtras())
                    .append("curp", repartidor.getCurp());

            coleccion.insertOne(doc);
            return true;

        } catch (MongoException e) {
            System.err.println("Error al crear repartidor: " + e.getMessage());
            return false;
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public String crearIDFriendly() {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        int contador = 1;

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            long total = coleccion.countDocuments();
            contador = (int) total + 1;

        } catch (MongoException e) {
            System.err.println("Error al generar ID friendly: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return String.format("%06d", contador);
    }

    @Override
    public Repartidor buscarRepartidorPorIdFriendly(String idFriendly) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            Document filtro = new Document("idRepartidor", idFriendly);
            Document resultado = coleccion.find(filtro).first();

            if (resultado != null) {
                Repartidor repartidor = new Repartidor();
                repartidor.setIdRepartidor(resultado.getString("idRepartidor"));
                repartidor.setNombreCompleto(resultado.getString("nombreCompleto"));
                repartidor.setTelefono(resultado.getString("telefono"));
                repartidor.setDisponible(resultado.getBoolean("disponible"));
                repartidor.setContrasena(resultado.getString("contrasena"));
                repartidor.setDomicilio(resultado.getString("domicilio"));
                repartidor.setApodo(resultado.getString("apodo"));
                repartidor.setSalarioDiario(resultado.getDouble("salarioDiario"));
                repartidor.setDiasTrabajo(resultado.getString("diasTrabajo"));
                repartidor.setHorario(resultado.getString("Horario"));
                repartidor.setConsideracionesExtras(resultado.getString("consideracionesExtras"));
                return repartidor;
            }

        } catch (MongoException e) {
            System.err.println("Error al buscar repartidor: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return null;
    }

    @Override
    public boolean deshabilitarRepartidor(String idFriendly) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            Repartidor repartidor = buscarRepartidorPorIdFriendly(idFriendly);
            if (repartidor == null) {
                return false;
            }

            Document filtro = new Document("idRepartidor", idFriendly);
            Document actualizacion = new Document("$set", new Document("disponible", false));
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            System.err.println("Error al deshabilitar repartidor: " + e.getMessage());
            return false;
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public boolean habilitarRepartidor(String idFriendly) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            Repartidor repartidor = buscarRepartidorPorIdFriendly(idFriendly);
            if (repartidor == null) {
                return false;
            }

            Document filtro = new Document("idRepartidor", idFriendly);
            Document actualizacion = new Document("$set", new Document("disponible", true));
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            System.err.println("Error al habilitar repartidor: " + e.getMessage());
            return false;
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public List<RepartidorDTO> obtenerTrabajadoresHabilitados() {
        return obtenerRepartidoresPorDisponibilidad(true);
    }

    @Override
    public List<RepartidorDTO> obtenerTrabajadoresDeshabilitados() {
        return obtenerRepartidoresPorDisponibilidad(false);
    }

    private List<RepartidorDTO> obtenerRepartidoresPorDisponibilidad(boolean disponibilidad) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        List<RepartidorDTO> repartidores = new ArrayList<>();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            Bson filtro = Filters.eq("disponible", disponibilidad);
            FindIterable<Document> resultados = coleccion.find(filtro);

            for (Document doc : resultados) {
                RepartidorDTO dto = new RepartidorDTO();
                dto.setIdRepartidor(doc.getString("idRepartidor"));
                dto.setNombreCompleto(doc.getString("nombreCompleto"));
                dto.setTelefono(doc.getString("telefono"));
                dto.setDisponible(doc.getBoolean("disponible"));
                dto.setDomicilio(doc.getString("domicilio"));
                dto.setApodo(doc.getString("apodo"));
                dto.setSalarioDiario(doc.getDouble("salarioDiario"));
                dto.setDiasTrabajo(doc.getString("diasTrabajo"));
                dto.setHorario(doc.getString("Horario"));
                dto.setConsideracionesExtras(doc.getString("consideracionesExtras"));
                dto.setCurp(doc.getString("curp"));
                repartidores.add(dto);
            }

        } catch (MongoException e) {
            System.err.println("Error al obtener repartidores: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return repartidores;
    }

    @Override
    public List<RepartidorDTO> obtenerTodosLosRepartidores() {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        List<RepartidorDTO> repartidores = new ArrayList<>();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            FindIterable<Document> resultados = coleccion.find();

            for (Document doc : resultados) {
                RepartidorDTO dto = new RepartidorDTO();
                dto.setIdRepartidor(doc.getString("idRepartidor"));
                dto.setNombreCompleto(doc.getString("nombreCompleto"));
                dto.setTelefono(doc.getString("telefono"));
                dto.setDisponible(doc.getBoolean("disponible"));
                dto.setDomicilio(doc.getString("domicilio"));
                dto.setApodo(doc.getString("apodo"));
                dto.setSalarioDiario(doc.getDouble("salarioDiario"));
                dto.setDiasTrabajo(doc.getString("diasTrabajo"));
                dto.setHorario(doc.getString("Horario"));
                dto.setConsideracionesExtras(doc.getString("consideracionesExtras"));
                dto.setCurp(doc.getString("curp"));
                repartidores.add(dto);
            }

        } catch (MongoException e) {
            System.err.println("Error al obtener repartidores: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return repartidores;
    }

    @Override
    public RepartidorDTO iniciarSesionRepartidor(String idRepartidor, String contrasena) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");

            Document filtro = new Document("idRepartidor", idRepartidor);
            Document resultado = coleccion.find(filtro).first();

            if (resultado != null) {
                String contrasenaAlmacenada = resultado.getString("contrasena");
                if (contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contrasena)) {
                    RepartidorDTO repartidorDTO = new RepartidorDTO(
                            resultado.getString("idRepartidor"),
                            resultado.getString("nombreCompleto"),
                            resultado.getString("telefono"),
                            resultado.getBoolean("disponible"),
                            resultado.getString("domicilio"),
                            resultado.getString("apodo"),
                            resultado.getDouble("salarioDiario"),
                            resultado.getString("diasTrabajo"),
                            resultado.getString("horario"),
                            resultado.getString("consideracionesExtras"),
                            resultado.getString("curp")
                    );
                    return repartidorDTO;
                }
            }

        } catch (MongoException e) {
            System.err.println("Error al iniciar sesión: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return null;
    }

    @Override
    public Repartidor obtenerRepartidorPorCurp(String curp) throws Exception {
        MongoClient cliente = null;
        try {
            cliente = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(cliente);
            MongoCollection<Document> col = db.getCollection("Repartidores");

            Document filtro = new Document("curp", curp);
            Document doc = col.find(filtro).first();
            if (doc == null) {
                return null;
            }

            Repartidor r = new Repartidor();
            r.setIdRepartidor(doc.getString("idRepartidor"));
            r.setNombreCompleto(doc.getString("nombreCompleto"));
            r.setTelefono(doc.getString("telefono"));
            r.setDisponible(doc.getBoolean("disponible"));
            r.setContrasena(doc.getString("contrasena"));
            r.setDomicilio(doc.getString("domicilio"));
            r.setApodo(doc.getString("apodo"));
            r.setSalarioDiario(doc.getDouble("salarioDiario"));
            r.setDiasTrabajo(doc.getString("diasTrabajo"));
            r.setHorario(doc.getString("Horario"));
            r.setConsideracionesExtras(doc.getString("consideracionesExtras"));
            r.setCurp(doc.getString("curp"));
            return r;
        } catch (MongoException e) {
            throw new Exception("Error al buscar repartidor por CURP: " + e.getMessage());
        } finally {
            if (cliente != null) {
                Conexion.getInstancia().cerrarConexion(cliente);
            }
        }
    }

    /**
     * Actualiza un repartidor. Solo sobreescribe en Mongo los campos no-vacíos
     * del DTO; el resto se deja igual que en la entidad original.
     *
     * @param dto
     * @param contrasena
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public boolean actualizarRepartidor(RepartidorDTO dto, String contrasena) throws Exception {
        if (dto == null || dto.getIdRepartidor() == null || dto.getIdRepartidor().trim().isEmpty()) {
            throw new IllegalArgumentException("El DTO o su idRepartidor no pueden estar vacíos.");
        }

        Repartidor orig = buscarRepartidorPorIdFriendly(dto.getIdRepartidor());
        if (orig == null) {
            return false;
        }

        String nombre = isBlank(dto.getNombreCompleto()) ? orig.getNombreCompleto() : dto.getNombreCompleto();
        String telefono = isBlank(dto.getTelefono()) ? orig.getTelefono() : dto.getTelefono();
        String domicilio = isBlank(dto.getDomicilio()) ? orig.getDomicilio() : dto.getDomicilio();
        String apodo = isBlank(dto.getApodo()) ? orig.getApodo() : dto.getApodo();
        String dias = isBlank(dto.getDiasTrabajo()) ? orig.getDiasTrabajo() : dto.getDiasTrabajo();
        String horario = isBlank(dto.getHorario()) ? orig.getHorario() : dto.getHorario();
        Double salarioDto = dto.getSalarioDiario();
        double salario = (salarioDto == null) ? orig.getSalarioDiario() : salarioDto;

        //  double salario = isBlank (dto.getSalarioDiario()) ? orig.getSalarioDiario() : dto.getSalarioDiario();
        String extras = isBlank(dto.getConsideracionesExtras())
                ? orig.getConsideracionesExtras()
                : dto.getConsideracionesExtras();
        String curp = isBlank(dto.getCurp()) ? orig.getCurp() : dto.getCurp();

        MongoClient cliente = null;
        try {
            cliente = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(cliente);
            MongoCollection<Document> col = db.getCollection("Repartidores");

            Bson filtro = Filters.eq("idRepartidor", orig.getIdRepartidor());
            Document campos = new Document()
                    .append("nombreCompleto", nombre)
                    .append("telefono", telefono)
                    .append("domicilio", domicilio)
                    .append("apodo", apodo)
                    .append("diasTrabajo", dias)
                    .append("Horario", horario)
                    .append("consideracionesExtras", extras)
                    .append("salarioDiario", salario)
                    .append("curp", curp);
            if (contrasena != null && !contrasena.isBlank()) {
                campos.append("contrasena", contrasena);
            }

            UpdateResult res = col.updateOne(filtro, new Document("$set", campos));
            return res.getModifiedCount() > 0;
        } catch (MongoException e) {
            throw new Exception("Error al actualizar repartidor: " + e.getMessage());
        } finally {
            if (cliente != null) {
                Conexion.getInstancia().cerrarConexion(cliente);
            }
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
