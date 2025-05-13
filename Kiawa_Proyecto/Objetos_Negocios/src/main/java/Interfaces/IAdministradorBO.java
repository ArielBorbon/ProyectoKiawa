/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Administrador;
import dto.AdministradorDTO;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IAdministradorBO {

    Administrador buscarAdministradorPorIdFriendlyBO(String idFriendly) throws Exception;

    boolean crearAdministradorBO(AdministradorDTO dto, String contrasena) throws Exception;

    String crearIDFriendlyBO() throws Exception;

    boolean actualizarAdministradorBO(AdministradorDTO dto, String nuevaContrasena) throws Exception;

    List<RepartidorDTO> obtenerTodosLosEmpleadosBO();

    List<RepartidorDTO> obtenerTodosLosEmpleadosPorDisponibilidadBO(boolean disponibilidad);
    
    public AdministradorDTO loginAdministradorBO(String idFriendly, String contrasena) throws Exception;
    
    public boolean existeEmpleadoConCurpBO(String curp) throws Exception;
}
