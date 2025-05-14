/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Repartidor;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IRepartidorBO {

    boolean crearRepartidorBO(RepartidorDTO dto , String contrasena) throws Exception;

    String crearIDFriendlyBO();

    Repartidor buscarRepartidorPorIdFriendlyBO(String idFriendly);

    boolean deshabilitarRepartidorBO(String idFriendly);

    boolean habilitarRepartidorBO(String idFriendly);

    List<RepartidorDTO> obtenerTrabajadoresHabilitadosBO();

    List<RepartidorDTO> obtenerTrabajadoresDeshabilitadosBO();

    List<RepartidorDTO> obtenerTodosLosRepartidoresBO();
    
     RepartidorDTO iniciarSesionRepartidorBO(String idRepartidor, String contrasena);
    
     boolean actualizarRepartidorBO(RepartidorDTO dto, String contrasena) throws Exception;
     
      Repartidor obtenerRepartidorPorCurpBO(String curp) throws Exception;
}
