/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.AdministradorDAO;
import Entidades.Administrador;
import Interfaces.IAdministradorBO;
import dto.AdministradorDTO;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class AdministradorBO implements IAdministradorBO{

    private AdministradorDAO administradorDAO;

    public AdministradorBO(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }


    @Override
    public Administrador buscarAdministradorPorIdFriendlyBO(String idFriendly) throws Exception {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del administrador no puede ser nulo o vacío.");
        }
        return administradorDAO.buscarAdministradorPorIdFriendly(idFriendly);
    }

    @Override
    public boolean crearAdministradorBO(AdministradorDTO dto, String contrasena) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO del administrador no puede ser nulo.");
        }
        if (dto.getNombreCompleto() == null || dto.getNombreCompleto().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del administrador no puede estar vacío.");
        }
        if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del administrador no puede estar vacío.");
        }
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        return administradorDAO.crearAdministrador(dto, contrasena);
    }

    @Override
    public String crearIDFriendlyBO() throws Exception {
        return administradorDAO.crearIDFriendly();
    }

    @Override
    public boolean actualizarAdministradorBO(AdministradorDTO dto, String nuevaContrasena) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO del administrador no puede ser nulo.");
        }
        if (dto.getIdAdministrador() == null || dto.getIdAdministrador().trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del administrador no puede estar vacío.");
        }
        if (dto.getNombreCompleto() == null || dto.getNombreCompleto().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del administrador no puede estar vacío.");
        }
        if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del administrador no puede estar vacío.");
        }
        if (nuevaContrasena == null || nuevaContrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("La nueva contraseña no puede estar vacía.");
        }
        return administradorDAO.actualizarAdministrador(dto, nuevaContrasena);
    }

    @Override
    public List<RepartidorDTO> obtenerTodosLosEmpleadosBO() {
        return administradorDAO.obtenerTodosLosEmpleados();
    }

    @Override
    public List<RepartidorDTO> obtenerTodosLosEmpleadosPorDisponibilidadBO(boolean disponibilidad) {
        return administradorDAO.obtenerTodosLosEmpleadosPorDisponibilidad(disponibilidad);
    }
}

