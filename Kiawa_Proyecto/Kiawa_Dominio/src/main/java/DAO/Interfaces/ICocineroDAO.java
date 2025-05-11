/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interfaces;

import Entidades.Cocinero;
import dto.CocineroDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface ICocineroDAO {
    
    String crearIDFriendly() throws Exception;
    
    boolean crearCocinero(CocineroDTO dto, String contrasena) throws Exception;
    
    boolean habilitarCocinero(String idFriendly) throws Exception;
    
    boolean deshabilitarCocinero(String idFriendly);
    
    List<CocineroDTO> obtenerTrabajadoresHabilitados();
    
    List<CocineroDTO> obtenerTrabajadoresDeshabilitados();
    
    List<CocineroDTO> obtenerTodosLosCocineros();
    
    Cocinero buscarCocineroPorIdFriendly(String idFriendly);
    
    public CocineroDTO loginCocinero(String idFriendly, String contrasena) throws Exception;
}

