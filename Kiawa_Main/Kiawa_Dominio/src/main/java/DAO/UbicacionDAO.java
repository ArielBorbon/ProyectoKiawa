/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import Entidades.Ubicacion;
import Mappers.UbicacionMapper;
import com.mongodb.MongoException;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dto.UbicacionDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PC Gamer
 */
public class UbicacionDAO {
    
    public Ubicacion buscarUbicacionPorEdificioYSalon(UbicacionDTO dto) throws Exception {
    MongoClient clienteMongo = null;
    Conexion conexion = Conexion.getInstancia();
    try {
        clienteMongo = conexion.crearConexion();
        MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
        MongoCollection<Document> coleccion = baseDatos.getCollection("Ubicaciones");

        Bson filtro = and(
            eq("edificio", dto.getEdificio()),
            eq("salon", dto.getSalon())
        );

        Document doc = coleccion.find(filtro).first();
        if (doc != null) {
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setEdificio(doc.getString("edificio"));
            ubicacion.setSalon(doc.getString("salon"));
            return ubicacion;
        }

        return null;
    } catch (MongoException e) {
        throw new Exception("Error al buscar la ubicación: " + e.getMessage());
    } finally {
        if (clienteMongo != null) {
            conexion.cerrarConexion(clienteMongo);
        }
    }
}

    
    
    public boolean crearUbicacion(UbicacionDTO ubicacionDTO) throws Exception {
        if (ubicacionDTO == null) {
            throw new IllegalArgumentException("Ubicación no puede ser null");
        }
        
        // Verifica si ya existe
        Ubicacion yaExiste = buscarUbicacionPorEdificioYSalon(ubicacionDTO);
        if (yaExiste != null) {
            throw new Exception("Ya existe una ubicación con ese edificio y salón");
        }
        
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Ubicaciones");
            
            Document ubicacionDoc = new Document()
                .append("edificio", ubicacionDTO.getEdificio())
                .append("salon", ubicacionDTO.getSalon());
            
            coleccion.insertOne(ubicacionDoc);
            return true;
            
        } catch (MongoException e) {
        throw new Exception("Error al crear la ubicación: " + e.getMessage());
    } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }
    
    
    
    
    
    public List<UbicacionDTO> obtenerListaUbicaciones() throws Exception {
        List<UbicacionDTO> listaUbicaciones = new ArrayList<>();
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        
        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Ubicaciones");
            
            try (MongoCursor<Document> cursor = coleccion.find().iterator()) {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    Ubicacion ubicacion = new Ubicacion();
                    ubicacion.setEdificio(doc.getString("edificio"));
                    ubicacion.setSalon(doc.getString("salon"));
                    
                    UbicacionDTO dto = UbicacionMapper.toDTO(ubicacion);
                    listaUbicaciones.add(dto);
                }
            }
            
        } catch (MongoException e) {
            throw new Exception("Error al obtener la lista de ubicaciones: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

        return listaUbicaciones;
}
    
    
    
    public List<UbicacionDTO> filtrarPorEdificio(String edificio) throws Exception {
        List<UbicacionDTO> listaFiltrada = new ArrayList<>();
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        
        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Ubicaciones");
            
            Bson filtro = Filters.eq("edificio", edificio);
            
            try (MongoCursor<Document> cursor = coleccion.find(filtro).iterator()) {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    Ubicacion ubicacion = new Ubicacion();
                    ubicacion.setEdificio(doc.getString("edificio"));
                    ubicacion.setSalon(doc.getString("salon"));
                    
                    UbicacionDTO dto = UbicacionMapper.toDTO(ubicacion);
                    listaFiltrada.add(dto);
                }
            }
            
        } catch (MongoException e) {
            throw new Exception("Error al filtrar ubicaciones por edificio: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }

    return listaFiltrada;
}



    
    
}
