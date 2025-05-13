/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interfaces;

import Entidades.Administrador;
import dto.AdministradorDTO;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IAdministradorDAO {
    
    Administrador buscarAdministradorPorIdFriendly(String idFriendly) throws Exception;
    
    boolean crearAdministrador(AdministradorDTO dto, String contrasena) throws Exception;
    
    String crearIDFriendly() throws Exception;
    
    boolean actualizarAdministrador(AdministradorDTO dto, String nuevaContrasena) throws Exception;
    
    List<RepartidorDTO> obtenerTodosLosEmpleados();
    
    List<RepartidorDTO> obtenerTodosLosEmpleadosPorDisponibilidad(boolean disponibilidad);
    
    public AdministradorDTO loginAdministrador(String idFriendly, String contrasena) throws Exception;
    
    public boolean existeEmpleadoConCurp(String curp) throws Exception;
}

