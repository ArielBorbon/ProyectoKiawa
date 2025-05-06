/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionMongo.Conexion;
import Entidades.Repartidor;
import Mappers.RepartidorMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dto.RepartidorDTO;
import org.bson.Document;

/**
 *
 * @author PC Gamer
 */
public class RepartidorDAO {

    public boolean crearRepartidor(RepartidorDTO dto) throws Exception {
        MongoClient clienteMongo = null;
        Conexion conexion = Conexion.getInstancia();

        try {
            clienteMongo = conexion.crearConexion();
            MongoDatabase baseDatos = conexion.obtenerBaseDatos(clienteMongo);
            MongoCollection<Document> coleccion = baseDatos.getCollection("Repartidores");


            String nuevoID = crearIDFriendly();


            String contrasenaDummy = "1234";

            dto.setIdRepartidor(nuevoID);
            Repartidor repartidor = RepartidorMapper.toEntity(dto, contrasenaDummy);

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
                    .append("consideracionesExtras", repartidor.getConsideracionesExtras());

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

    private String crearIDFriendly() {
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
}

