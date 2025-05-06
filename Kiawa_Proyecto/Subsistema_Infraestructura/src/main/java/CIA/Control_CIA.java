/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CIA;

/**
 *
 * @author PC Gamer
 */
public class Control_CIA {

    public String obtenerDatosAlumno(String jsonEntrada) throws Exception {
        IConexion sistemaCIA = ConexionesFactory.obtenerConexion("CIA");

        if (sistemaCIA == null) {
            throw new Exception("No se pudo obtener una conexión con el sistema CIA.");
        }

        return sistemaCIA.obtenerDatos(jsonEntrada);
    }
}

