/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import Entidades.Platillo;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC Gamer
 */
public class PlatilloDAO {
    

    public PlatilloDAO() {
    }
    
    
    
    
    
    public Platillo agregarPlatillo(Platillo platillo) throws Exception{
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();
        try {
            clienteMongo = conexion.crearConexion();
            
            ObjectId platilloId = new ObjectId();
            Document PlatilloRegistrar = new Document()
                    .append("nombrePlatillo", platillo.getNombre())
                    .append("descripcion", platillo.getDescripcion())                  
                    .append("precio", platillo.getPrecio())
                    .append("existencias", platillo.getExistencias())
                    .append("categoria", platillo.getCategoria())
                    .append("disponible", platillo.getDisponible());
            
            
            MongoCollection<Document> coleccionPlatillos = clienteMongo.getDatabase("KiawaBD").getCollection("Platillos");
            coleccionPlatillos.insertOne(PlatilloRegistrar);
        
                 return platillo;   
                    
                } catch (MongoException e) {
            throw new Exception("Error al registrar el cliente: " + e.getMessage());
        } finally {
            if (clienteMongo != null) {
                conexion.cerrarConexion(clienteMongo);
            }
        }
                     
    
    
}
}