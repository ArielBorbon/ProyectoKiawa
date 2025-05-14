/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interfaces;

import Entidades.Repartidor;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IRepartidorDAO {
    
    boolean crearRepartidor(RepartidorDTO dto, String contrasena) throws Exception;
    
    boolean deshabilitarRepartidor(String idFriendly);
    
    boolean habilitarRepartidor(String idFriendly);
    
    List<RepartidorDTO> obtenerTrabajadoresHabilitados();
    
    List<RepartidorDTO> obtenerTrabajadoresDeshabilitados();
    
    List<RepartidorDTO> obtenerTodosLosRepartidores();
    
    Repartidor buscarRepartidorPorIdFriendly(String idFriendly);
    
    String crearIDFriendly();
    
    RepartidorDTO iniciarSesionRepartidor(String idRepartidor, String contrasena);
}

