/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import BO.AdministradorBO;
import DAO.AdministradorDAO;
import Entidades.Administrador;
import Fabricas.FactoryBO;
import dto.AdministradorDTO;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class FSubsistema_Administrador {
    private  AdministradorBO administradorBO;

    public FSubsistema_Administrador() {
        this.administradorBO = FactoryBO.crearAdministradorBO();
    }

    public Administrador buscarAdministradorPorIdFriendly(String idFriendly) throws Exception {
        return administradorBO.buscarAdministradorPorIdFriendlyBO(idFriendly);
    }

    public boolean crearAdministrador(AdministradorDTO dto, String contrasena) throws Exception {
        return administradorBO.crearAdministradorBO(dto, contrasena);
    }

    public String crearIDFriendly() throws Exception {
        return administradorBO.crearIDFriendlyBO();
    }

    public boolean actualizarAdministrador(AdministradorDTO dto, String nuevaContrasena) throws Exception {
        return administradorBO.actualizarAdministradorBO(dto, nuevaContrasena);
    }

    public List<RepartidorDTO> obtenerTodosLosEmpleados() {
        return administradorBO.obtenerTodosLosEmpleadosBO();
    }

    public List<RepartidorDTO> obtenerTodosLosEmpleadosPorDisponibilidad(boolean disponibilidad) {
        return administradorBO.obtenerTodosLosEmpleadosPorDisponibilidadBO(disponibilidad);
    }

    public AdministradorDTO loginAdministrador(String idFriendly, String contrasena) throws Exception {
        return administradorBO.loginAdministradorBO(idFriendly, contrasena);
    }
}

