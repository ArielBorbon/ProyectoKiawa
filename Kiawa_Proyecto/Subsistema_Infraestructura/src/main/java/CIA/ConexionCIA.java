/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CIA;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author PC Gamer
 */

public class ConexionCIA implements IConexion {

    private static final String HOST = "localhost";
    private static final int PORT = 5050;

    @Override
    public String obtenerDatos(String jsonEntrada) throws Exception {
        try (Socket socket = new Socket(HOST, PORT); PrintWriter out = new PrintWriter(socket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

         
            out.println(jsonEntrada);

       
            StringBuilder respuesta = new StringBuilder();
            String linea;
            while ((linea = in.readLine()) != null) {
                respuesta.append(linea);
            }

            return respuesta.toString().isEmpty() ? null : respuesta.toString();
        } catch (IOException e) {
            throw new Exception("Error al conectar con el sistema CIA: " + e.getMessage());
        }
    }
}
