/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CIA;

/**
 *
 * @author PC Gamer
 */
public class ConexionesFactory {
        public static IConexion obtenerConexion(String tipoSistema) {
        if (tipoSistema.equalsIgnoreCase("CIA")) {
            return new ConexionCIA(); 
        }
        
        return null;
    }
}
