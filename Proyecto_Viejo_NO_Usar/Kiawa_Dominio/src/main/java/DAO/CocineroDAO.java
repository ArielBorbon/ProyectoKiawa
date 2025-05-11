/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import Entidades.Cocinero;
import Mappers.CocineroMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import dto.CocineroDTO;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PC Gamer
 */
public class CocineroDAO {

    public Cocinero buscarPorIdFriendly(String idFriendly) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

            Bson filtro = Filters.eq("idCocinero", idFriendly);
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
                return cocinero;
            }

        } catch (MongoException e) {
            throw new Exception("Error al buscar cocinero por ID friendly: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return null;
    }

    public String crearIDFriendly() throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

        
            Document doc = coleccion
                    .find()
                    .sort(Sorts.descending("idCocinero"))
                    .limit(1)
                    .first();

            if (doc != null) {
                String ultimoID = doc.getString("idCocinero"); 
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

    public boolean crearCocinero(CocineroDTO dto , String contrasena) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Cocineros");

          
            if (buscarPorIdFriendly(dto.getIdCocinero()) != null) {
                return false; // Ya existe
            }

         
            String nuevoID = crearIDFriendly();
            dto.setIdCocinero(nuevoID);

         
            Cocinero cocinero = CocineroMapper.toEntity(dto , contrasena);

           
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

}
