/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionMongo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class Conexion {

    private static final Conexion instancia = new Conexion();
    private final String nombreBase = "KiawaBD";
    private final String connectionString = "mongodb://localhost:27017";

    private Conexion() {
    }

    public static Conexion getInstancia() {
        return instancia;
    }

    public MongoClient crearConexion() throws MongoException {
        MongoClient conexionMongo = null;
        try {
            conexionMongo = MongoClients.create(connectionString);
        } catch (MongoException e) {
            throw new MongoException("Hubo un error al conectarse a MongoDB: " + e.getMessage());
        }
        return conexionMongo;
    }

    public MongoDatabase obtenerBaseDatos(MongoClient conexion) throws MongoException {
        MongoDatabase baseDatos = null;
        try {
            List<String> nombresBaseDatos = new ArrayList<>();
            conexion.listDatabaseNames().into(nombresBaseDatos);

            if (nombresBaseDatos.contains(nombreBase)) {
                baseDatos = conexion.getDatabase(nombreBase);
            } else {
                throw new MongoException("La base de datos '" + nombreBase + "' no existe.");
            }
        } catch (MongoException e) {
            throw new MongoException("Error al obtener la base de datos: " + e.getMessage());
        }
        return baseDatos;
    }

    public void cerrarConexion(MongoClient conexion) {
        if (conexion != null) {
            conexion.close();
        }
    }
}

