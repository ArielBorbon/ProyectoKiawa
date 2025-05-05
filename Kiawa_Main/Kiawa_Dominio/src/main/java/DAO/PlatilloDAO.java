/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import Entidades.Platillo;
import Mappers.PlatilloMapper;
import com.mongodb.MongoException;
import dto.PlatilloDTO;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.and;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author PC Gamer
 */
public class PlatilloDAO {
    

    public PlatilloDAO() {
    }
    
    
    
    public List<PlatilloDTO> obtenerListaPlatillosDisponibles() {
        List<PlatilloDTO> listaDTO = new ArrayList<>();
        MongoClient conexion = null;

        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase baseDatos = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Platillos");

            Bson filtro = and(
                eq("disponible", true),
                gt("existencias", 0)
            );

            try (MongoCursor<Document> cursor = coleccion.find(filtro).iterator()) {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    Platillo platillo = new Platillo();

                    platillo.setIdPlatillo(doc.getObjectId("_id").toHexString());
                    platillo.setNombre(doc.getString("nombre"));
                    platillo.setDescripcion(doc.getString("descripcion"));
                    platillo.setPrecio(doc.getDouble("precio"));
                    platillo.setExistencias(doc.getInteger("existencias"));
                    platillo.setCategoria(doc.getString("categoria"));
                    platillo.setDisponible(doc.getBoolean("disponible"));

                    PlatilloDTO dto = PlatilloMapper.toDTO(platillo);
                    listaDTO.add(dto);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al obtener platillos disponibles: " + e.getMessage());
        } finally {
            Conexion.getInstancia().cerrarConexion(conexion);
        }

        return listaDTO;
    }
    
    
    public List<PlatilloDTO> obtenerListaPlatillosTodos() {
        List<PlatilloDTO> listaDTO = new ArrayList<>();
        MongoClient conexion = null;
    
        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase baseDatos = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Platillos");
        
            try (MongoCursor<Document> cursor = coleccion.find().iterator()) {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    Platillo platillo = new Platillo();
                
                    platillo.setIdPlatillo(doc.getObjectId("_id").toHexString());
                    platillo.setNombre(doc.getString("nombre"));
                    platillo.setDescripcion(doc.getString("descripcion"));
                    platillo.setPrecio(doc.getDouble("precio"));
                    platillo.setExistencias(doc.getInteger("existencias"));
                    platillo.setCategoria(doc.getString("categoria"));
                    platillo.setDisponible(doc.getBoolean("disponible"));
                
                    PlatilloDTO dto = PlatilloMapper.toDTO(platillo);
                    listaDTO.add(dto);
                }
            }
        
        } catch (Exception e) {
            System.err.println("Error al obtener todos los platillos: " + e.getMessage());
        } finally {
            Conexion.getInstancia().cerrarConexion(conexion);
        }
    
        return listaDTO;
    }   

    
    
    
    
    
    
    public boolean actualizarExistenciasPlatillo(Platillo platillo, int nuevaCantidad) {
        MongoClient conexion = null;
        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase baseDatos = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Platillos");
        
            Bson filtro = eq("_id", new ObjectId(platillo.getIdPlatillo()));
            Bson actualizacion = set("existencias", nuevaCantidad);
        
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
            return resultado.getModifiedCount() > 0;
        
        } catch (Exception e) {
            System.err.println("Error al actualizar existencias del platillo: " + e.getMessage());
            return false;
        } finally {
            Conexion.getInstancia().cerrarConexion(conexion);
        }
    }

    
    
    
    public Platillo obtenerPlatilloPorNombre(String nombrePlatillo) {
    MongoClient conexion = null;
    try {
        conexion = Conexion.getInstancia().crearConexion();
        MongoDatabase baseDatos = Conexion.getInstancia().obtenerBaseDatos(conexion);
        MongoCollection<Document> coleccion = baseDatos.getCollection("Platillos");

        Bson filtro = eq("nombre", nombrePlatillo);
        Document documento = coleccion.find(filtro).first();

        if (documento != null) {
            Platillo platillo = new Platillo();
            platillo.setIdPlatillo(documento.getObjectId("_id").toHexString());
            platillo.setNombre(documento.getString("nombre"));
            platillo.setDescripcion(documento.getString("descripcion"));
            platillo.setPrecio(documento.getDouble("precio"));
            platillo.setExistencias(documento.getInteger("existencias"));
            platillo.setCategoria(documento.getString("categoria"));
            platillo.setDisponible(documento.getBoolean("disponible"));
            return platillo;
        }

        return null;

    } catch (Exception e) {
        System.err.println("Error al obtener platillo por nombre: " + e.getMessage());
        return null;
    } finally {
        Conexion.getInstancia().cerrarConexion(conexion);
    }
}

    
    
    public boolean agregarPlatillo(PlatilloDTO platilloDTO) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        try {
            clienteMongo = conexion.crearConexion();
        
            Document platilloDoc = new Document()
                    .append("nombre", platilloDTO.getNombre())
                    .append("descripcion", platilloDTO.getDescripcion()) 
                    .append("precio", platilloDTO.getPrecio())
                    .append("existencias", platilloDTO.getExistencias())
                    .append("categoria", platilloDTO.getCategoria()) 
                    .append("disponible", true); //si se añade pues obviamente va a estar disponible, si no no se añadiera en primer lugar
        
            MongoCollection<Document> coleccionPlatillos = clienteMongo
                    .getDatabase("KiawaBD")
                    .getCollection("Platillos");
        
            coleccionPlatillos.insertOne(platilloDoc);
        
            return true; // Insertado correctamente
        
        } catch (MongoException e) {
            throw new Exception("Error al registrar el platillo: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }
    
    
    
    public boolean deshabilitarPlatillo(String nombrePlatillo) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        
        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Platillos");
            
            // Filtro por nombre del platillo
            Bson filtro = Filters.eq("nombre", nombrePlatillo);
            
            // Operación de actualización
            Bson actualizacion = Updates.set("disponible", false);
            
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
            
            return resultado.getModifiedCount() > 0;
            
        } catch (MongoException e) {
            throw new Exception("Error al deshabilitar el platillo: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }

    
    public boolean habilitarPlatillo(String nombrePlatillo) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        
        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Platillos");
            
            // Filtro por nombre
            Bson filtro = Filters.eq("nombre", nombrePlatillo);
            
            // Actualización: disponible = true
            Bson actualizacion = Updates.set("disponible", true);
            
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
            
            return resultado.getModifiedCount() > 0;
            
        } catch (MongoException e) {
            throw new Exception("Error al habilitar el platillo: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
    }
    
    
    
    
    public boolean modificarPlatillo(String nombreOriginal, PlatilloDTO platilloDTO) {
        MongoClient conexion = null;

        try {
            conexion = Conexion.getInstancia().crearConexion();
            MongoDatabase baseDatos = Conexion.getInstancia().obtenerBaseDatos(conexion);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Platillos");
        
            // Buscar usando el nombre original
            Platillo platilloExistente = obtenerPlatilloPorNombre(nombreOriginal);
            if (platilloExistente == null) {
                return false;
            }
        
            Bson filtro = eq("_id", new ObjectId(platilloExistente.getIdPlatillo()));
        
            Bson actualizacion = combine(
                set("nombre", platilloDTO.getNombre()),
                set("precio", platilloDTO.getPrecio()),
                set("descripcion", platilloDTO.getDescripcion()),
                set("categoria", platilloDTO.getCategoria())
            );
        
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
        
            return resultado.getModifiedCount() == 1;
        
        } catch (Exception e) {
            System.err.println("Error al modificar el platillo: " + e.getMessage());
            return false;
        } finally {
            Conexion.getInstancia().cerrarConexion(conexion);
        }
    }


    

    
    

    
}