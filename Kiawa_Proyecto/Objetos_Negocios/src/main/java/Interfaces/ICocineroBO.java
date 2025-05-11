/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.Cocinero;
import dto.CocineroDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface ICocineroBO {

    Cocinero buscarCocineroPorIdFriendlyBO(String idFriendly);

    String crearIDFriendlyBO() throws Exception;

    boolean crearCocineroBO(CocineroDTO dto, String contrasena) throws Exception;

    boolean habilitarCocineroBO(String idFriendly) throws Exception;

    boolean deshabilitarCocineroBO(String idFriendly);

    List<CocineroDTO> obtenerTrabajadoresHabilitadosBO();

    List<CocineroDTO> obtenerTrabajadoresDeshabilitadosBO();

    List<CocineroDTO> obtenerTodosLosCocinerosBO();
    
    public CocineroDTO loginCocineroBO(String idFriendly, String contrasena) throws Exception;
}
