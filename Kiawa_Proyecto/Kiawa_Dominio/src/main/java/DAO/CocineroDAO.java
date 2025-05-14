/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import DAO.Interfaces.ICocineroDAO;
import Entidades.Cocinero;
import Mappers.CocineroMapper;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import dto.CocineroDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PC Gamer
 */
public class CocineroDAO implements ICocineroDAO {

    @Override
    public Cocinero buscarCocineroPorIdFriendly(String idFriendly) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        Cocinero cocinero = null;

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            Document filtro = new Document("idCocinero", idFriendly);
            Document doc = coleccion.find(filtro).first();

            if (doc != null) {
                cocinero = new Cocinero();
                cocinero.setIdCocinero(doc.getString("idCocinero"));
                cocinero.setNombreCompleto(doc.getString("nombreCompleto"));
                cocinero.setTelefono(doc.getString("telefono"));
                cocinero.setDisponible(doc.getBoolean("disponible"));
                cocinero.setContrasena(doc.getString("contrasena"));
                cocinero.setDomicilio(doc.getString("domicilio"));
                cocinero.setApodo(doc.getString("apodo"));
                cocinero.setSalarioDiario(doc.getDouble("salarioDiario"));
                cocinero.setDiasTrabajo(doc.getString("diasTrabajo"));
                cocinero.setHorario(doc.getString("Horario"));
                cocinero.setConsideracionesExtras(doc.getString("consideracionesExtras"));
                cocinero.setCurp(doc.getString("curp"));
            }

        } catch (MongoException e) {
            System.err.println("Error al buscar cocinero por ID: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return cocinero;
    }

    @Override
    public String crearIDFriendly() throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            List<Document> documentos = coleccion.find().into(new ArrayList<>());

            int max = 0;
            for (Document doc : documentos) {
                String id = doc.getString("idCocinero");
                if (id != null && id.matches("\\d+")) {
                    int valor = Integer.parseInt(id);
                    if (valor > max) {
                        max = valor;
                    }
                }
            }

            int siguiente = max + 1;
            return String.format("%06d", siguiente);

        } catch (MongoException e) {
            throw new Exception("Error al generar ID friendly: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public boolean crearCocinero(CocineroDTO dto, String contrasena) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            if (buscarCocineroPorIdFriendly(dto.getIdCocinero()) != null) {
                return false; // Ya existe
            }

            String nuevoID = crearIDFriendly();
            dto.setIdCocinero(nuevoID);

            Cocinero cocinero = CocineroMapper.toEntity(dto, contrasena);

            Document doc = new Document();
            doc.append("idCocinero", cocinero.getIdCocinero());
            doc.append("nombreCompleto", cocinero.getNombreCompleto());
            doc.append("telefono", cocinero.getTelefono());
            doc.append("disponible", cocinero.getDisponible());
            doc.append("contrasena", cocinero.getContrasena());
            doc.append("domicilio", cocinero.getDomicilio());
            doc.append("apodo", cocinero.getApodo());
            doc.append("salarioDiario", cocinero.getSalarioDiario());
            doc.append("diasTrabajo", cocinero.getDiasTrabajo());
            doc.append("Horario", cocinero.getHorario());
            doc.append("consideracionesExtras", cocinero.getConsideracionesExtras());
            doc.append("curp", cocinero.getCurp());

            coleccion.insertOne(doc);

            return true;

        } catch (MongoException e) {
            throw new Exception("Error al crear cocinero: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public boolean habilitarCocinero(String idFriendly) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            Cocinero cocinero = buscarCocineroPorIdFriendly(idFriendly);
            if (cocinero == null) {
                return false;
            }

            Document filtro = new Document("idCocinero", idFriendly);
            Document actualizacion = new Document("$set", new Document("disponible", true));
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            System.err.println("Error al habilitar cocinero: " + e.getMessage());
            return false;
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public boolean deshabilitarCocinero(String idFriendly) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            Cocinero cocinero = buscarCocineroPorIdFriendly(idFriendly);
            if (cocinero == null) {
                return false;
            }

            Document filtro = new Document("idCocinero", idFriendly);
            Document actualizacion = new Document("$set", new Document("disponible", false));
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            System.err.println("Error al deshabilitar cocinero: " + e.getMessage());
            return false;
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public List<CocineroDTO> obtenerTrabajadoresHabilitados() {
        return obtenerCocinerosPorDisponibilidad(true);
    }

    @Override
    public List<CocineroDTO> obtenerTrabajadoresDeshabilitados() {
        return obtenerCocinerosPorDisponibilidad(false);
    }

    private List<CocineroDTO> obtenerCocinerosPorDisponibilidad(boolean disponibilidad) {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        List<CocineroDTO> cocineros = new ArrayList<>();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            Bson filtro = Filters.eq("disponible", disponibilidad);
            FindIterable<Document> resultados = coleccion.find(filtro);

            for (Document doc : resultados) {
                CocineroDTO dto = new CocineroDTO();
                dto.setIdCocinero(doc.getString("idCocinero"));
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
                cocineros.add(dto);
            }

        } catch (MongoException e) {
            System.err.println("Error al obtener cocineros: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return cocineros;
    }

    @Override
    public List<CocineroDTO> obtenerTodosLosCocineros() {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        List<CocineroDTO> cocineros = new ArrayList<>();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            FindIterable<Document> resultados = coleccion.find();

            for (Document doc : resultados) {
                CocineroDTO dto = new CocineroDTO();
                dto.setIdCocinero(doc.getString("idCocinero"));
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
                cocineros.add(dto);
            }

        } catch (MongoException e) {
            System.err.println("Error al obtener cocineros: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return cocineros;
    }

    @Override
    public CocineroDTO loginCocinero(String idFriendly, String contrasena) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            Document filtro = new Document("idCocinero", idFriendly).append("contrasena", contrasena);
            Document doc = coleccion.find(filtro).first();

            if (doc != null) {
                Cocinero cocinero = new Cocinero();
                cocinero.setIdCocinero(doc.getString("idCocinero"));
                cocinero.setNombreCompleto(doc.getString("nombreCompleto"));
                cocinero.setTelefono(doc.getString("telefono"));
                cocinero.setDisponible(doc.getBoolean("disponible"));
                cocinero.setContrasena(doc.getString("contrasena"));
                cocinero.setDomicilio(doc.getString("domicilio"));
                cocinero.setApodo(doc.getString("apodo"));
                cocinero.setSalarioDiario(doc.getDouble("salarioDiario"));
                cocinero.setDiasTrabajo(doc.getString("diasTrabajo"));
                cocinero.setHorario(doc.getString("Horario"));
                cocinero.setConsideracionesExtras(doc.getString("consideracionesExtras"));
                cocinero.setCurp(doc.getString("curp"));

                return CocineroMapper.toDTO(cocinero);
            } else {
                return null;
            }

        } catch (MongoException e) {
            throw new Exception("Error al intentar login: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    /**
     * Auxiliar: obtiene la entidad completa de un cocinero buscando por su
     * CURP.
     */
    public Cocinero obtenerCocineroPorCurp(String curp) throws Exception {
        MongoClient cliente = null;
        try {
            cliente = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(cliente);
            MongoCollection<Document> col = db.getCollection("Cocineros");

            Document filtro = new Document("curp", curp);
            Document doc = col.find(filtro).first();
            if (doc == null) {
                return null;
            }

            Cocinero c = new Cocinero();
            c.setIdCocinero(doc.getString("idCocinero"));
            c.setNombreCompleto(doc.getString("nombreCompleto"));
            c.setTelefono(doc.getString("telefono"));
            c.setDisponible(doc.getBoolean("disponible"));
            c.setContrasena(doc.getString("contrasena"));
            c.setDomicilio(doc.getString("domicilio"));
            c.setApodo(doc.getString("apodo"));
            c.setSalarioDiario(doc.getDouble("salarioDiario"));
            c.setDiasTrabajo(doc.getString("diasTrabajo"));
            c.setHorario(doc.getString("Horario"));
            c.setConsideracionesExtras(doc.getString("consideracionesExtras"));
            c.setCurp(doc.getString("curp"));
            return c;
        } catch (MongoException e) {
            throw new Exception("Error al buscar cocinero por CURP: " + e.getMessage());
        } finally {
            if (cliente != null) {
                Conexion.getInstancia().cerrarConexion(cliente);
            }
        }
    }

    /**
     * Actualiza los datos de un cocinero. Solo sobreescribe los campos que el
     * DTO trae no-nulos y no-vacíos; el resto se conserva tal cual.
     */
    public boolean actualizarCocinero(CocineroDTO dto, String contrasena) throws Exception {
        if (dto == null || dto.getIdCocinero() == null) {
            throw new IllegalArgumentException("DTO o su idCocinero no puede ser nulo");
        }

        Cocinero orig = buscarCocineroPorIdFriendly(dto.getIdCocinero());
        if (orig == null) {
            return false;
        }

        String nombre = isBlank(dto.getNombreCompleto()) ? orig.getNombreCompleto() : dto.getNombreCompleto();
        String telefono = isBlank(dto.getTelefono()) ? orig.getTelefono() : dto.getTelefono();
        String domicilio = isBlank(dto.getDomicilio()) ? orig.getDomicilio() : dto.getDomicilio();
        String apodo = isBlank(dto.getApodo()) ? orig.getApodo() : dto.getApodo();
        String dias = isBlank(dto.getDiasTrabajo()) ? orig.getDiasTrabajo() : dto.getDiasTrabajo();
        String horario = isBlank(dto.getHorario()) ? orig.getHorario() : dto.getHorario();
        String extras = isBlank(dto.getConsideracionesExtras())
                ? orig.getConsideracionesExtras()
                : dto.getConsideracionesExtras();
        String curp = isBlank(dto.getCurp()) ? orig.getCurp() : dto.getCurp();
                Double salarioDto = dto.getSalarioDiario();
        double salario = (salarioDto == null) ? orig.getSalarioDiario() : salarioDto;
        MongoClient cliente = null;
        try {
            cliente = Conexion.getInstancia().crearConexion();
            MongoDatabase db = Conexion.getInstancia().obtenerBaseDatos(cliente);
            MongoCollection<Document> col = db.getCollection("Cocineros");

            Bson filtro = Filters.eq("idCocinero", orig.getIdCocinero());
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
            throw new Exception("Error al actualizar cocinero: " + e.getMessage());
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
