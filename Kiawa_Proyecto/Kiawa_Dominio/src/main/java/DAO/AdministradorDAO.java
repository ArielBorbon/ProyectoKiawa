/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import DAO.Interfaces.IAdministradorDAO;
import Entidades.Administrador;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import dto.AdministradorDTO;
import dto.CocineroDTO;
import dto.RepartidorDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author PC Gamer
 */
public class AdministradorDAO implements IAdministradorDAO {

    @Override
    public Administrador buscarAdministradorPorIdFriendly(String idFriendly) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Administradores");

            Document filtro = new Document("idAdministrador", idFriendly);
            Document resultado = coleccion.find(filtro).first();

            if (resultado != null) {
                Administrador admin = new Administrador();
                admin.setIdAdministrador(resultado.getString("idAdministrador"));
                admin.setNombreCompleto(resultado.getString("nombreCompleto"));
                admin.setTelefono(resultado.getString("telefono"));
                admin.setContrasena(resultado.getString("contrasena"));
                return admin;
            } else {
                return null;
            }

        } catch (MongoException e) {
            throw new Exception("Error al buscar administrador: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public boolean crearAdministrador(AdministradorDTO dto, String contrasena) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Administradores");

            // Generar ID friendly
            String nuevoId = crearIDFriendly();
            dto.setIdAdministrador(nuevoId);

            Document nuevoAdmin = new Document("idAdministrador", dto.getIdAdministrador())
                    .append("nombreCompleto", dto.getNombreCompleto())
                    .append("telefono", dto.getTelefono())
                    .append("contrasena", contrasena);

            coleccion.insertOne(nuevoAdmin);
            return true;

        } catch (MongoException e) {
            throw new Exception("Error al crear el administrador: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public String crearIDFriendly() throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Administradores");

            Document doc = coleccion
                    .find()
                    .sort(Sorts.descending("idAdministrador"))
                    .limit(1)
                    .first();

            if (doc != null) {
                String ultimoID = doc.getString("idAdministrador");
                int siguiente = Integer.parseInt(ultimoID) + 1;
                return String.format("%06d", siguiente);
            } else {
                return "000001";
            }

        } catch (MongoException e) {
            throw new Exception("Error al generar ID friendly: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public boolean actualizarAdministrador(AdministradorDTO dto, String nuevaContrasena) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Administradores");

            Document filtro = new Document("idAdministrador", dto.getIdAdministrador());
            Document existente = coleccion.find(filtro).first();

            if (existente == null) {
                return false; // No existe el administrador
            }

            Document actualizacion = new Document("$set", new Document()
                    .append("nombreCompleto", dto.getNombreCompleto())
                    .append("telefono", dto.getTelefono())
                    .append("contrasena", nuevaContrasena));

            coleccion.updateOne(filtro, actualizacion);
            return true;

        } catch (MongoException e) {
            throw new Exception("Error al actualizar el administrador: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    @Override
    public List<RepartidorDTO> obtenerTodosLosEmpleados() {
        List<RepartidorDTO> empleados = new ArrayList<>();

        RepartidorDAO repartidorDAO = new RepartidorDAO();
        CocineroDAO cocineroDAO = new CocineroDAO();

        empleados.addAll(repartidorDAO.obtenerTodosLosRepartidores());
        empleados.addAll(convertirCocinerosARepartidores(cocineroDAO.obtenerTodosLosCocineros()));

        return empleados;
    }

    @Override
    public List<RepartidorDTO> obtenerTodosLosEmpleadosPorDisponibilidad(boolean disponibilidad) {
        List<RepartidorDTO> empleados = new ArrayList<>();

        RepartidorDAO repartidorDAO = new RepartidorDAO();
        CocineroDAO cocineroDAO = new CocineroDAO();

        if (disponibilidad) {
            empleados.addAll(repartidorDAO.obtenerTrabajadoresHabilitados());
            empleados.addAll(convertirCocinerosARepartidores(cocineroDAO.obtenerTrabajadoresHabilitados()));
        } else {
            empleados.addAll(repartidorDAO.obtenerTrabajadoresDeshabilitados());
            empleados.addAll(convertirCocinerosARepartidores(cocineroDAO.obtenerTrabajadoresDeshabilitados()));
        }

        return empleados;
    }

    private List<RepartidorDTO> convertirCocinerosARepartidores(List<CocineroDTO> cocineros) {
        List<RepartidorDTO> lista = new ArrayList<>();
        for (CocineroDTO c : cocineros) {
            RepartidorDTO r = new RepartidorDTO();
            r.setIdRepartidor(c.getIdCocinero());
            r.setNombreCompleto(c.getNombreCompleto());
            r.setTelefono(c.getTelefono());
            r.setDisponible(c.getDisponible());
            r.setDomicilio(c.getDomicilio());
            r.setApodo(c.getApodo());
            r.setSalarioDiario(c.getSalarioDiario());
            r.setDiasTrabajo(c.getDiasTrabajo());
            r.setHorario(c.getHorario());
            r.setConsideracionesExtras(c.getConsideracionesExtras());
            lista.add(r);
        }
        return lista;
    }

    
    
    
    
    
    
    
    
    @Override
public AdministradorDTO loginAdministrador(String idFriendly, String contrasena) throws Exception {
    MongoClient clienteMongo = null;
    Conexion conexion = Conexion.getInstancia();

    try {
        clienteMongo = conexion.crearConexion();
        MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
        MongoCollection<Document> coleccion = baseDatos.getCollection("Administradores");

        Document filtro = new Document("idAdministrador", idFriendly)
                .append("contrasena", contrasena);

        Document resultado = coleccion.find(filtro).first();

        if (resultado != null) {
            AdministradorDTO dto = new AdministradorDTO();
            dto.setIdAdministrador(resultado.getString("idAdministrador"));
            dto.setNombreCompleto(resultado.getString("nombreCompleto"));
            dto.setTelefono(resultado.getString("telefono"));
            return dto;
        } else {
            return null; 
        }

    } catch (MongoException e) {
        throw new Exception("Error al iniciar sesión del administrador: " + e.getMessage());
    } finally {
        if (clienteMongo != null) {
            conexion.cerrarConexion(clienteMongo);
        }
    }
}

}
