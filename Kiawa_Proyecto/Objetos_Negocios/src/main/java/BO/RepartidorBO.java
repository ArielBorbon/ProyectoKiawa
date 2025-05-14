/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.RepartidorDAO;
import Entidades.Repartidor;
import Interfaces.IRepartidorBO;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class RepartidorBO implements IRepartidorBO {

    private RepartidorDAO repartidorDAO;

    public RepartidorBO(RepartidorDAO repartidorDAO) {
        this.repartidorDAO = repartidorDAO;
    }

    @Override
    public boolean crearRepartidorBO(RepartidorDTO dto, String contrasena) throws Exception {
        if (contrasena == null) {
            throw new IllegalArgumentException("La contrasena no puede venir vacia");
        }
        if (dto == null) {
            throw new IllegalArgumentException("El DTO del repartidor no puede ser nulo.");
        }
        if (dto.getNombreCompleto() == null || dto.getNombreCompleto().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del repartidor no puede estar vacío.");
        }
        if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del repartidor no puede estar vacío.");
        }
        return repartidorDAO.crearRepartidor(dto, contrasena);
    }

    @Override
    public String crearIDFriendlyBO() {
        return repartidorDAO.crearIDFriendly();
    }

    @Override
    public Repartidor buscarRepartidorPorIdFriendlyBO(String idFriendly) {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del repartidor no puede ser nulo o vacío.");
        }
        return repartidorDAO.buscarRepartidorPorIdFriendly(idFriendly);
    }

    @Override
    public boolean deshabilitarRepartidorBO(String idFriendly) {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del repartidor no puede ser nulo o vacío.");
        }
        return repartidorDAO.deshabilitarRepartidor(idFriendly);
    }

    @Override
    public boolean habilitarRepartidorBO(String idFriendly) {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del repartidor no puede ser nulo o vacío.");
        }
        return repartidorDAO.habilitarRepartidor(idFriendly);
    }

    @Override
    public List<RepartidorDTO> obtenerTrabajadoresHabilitadosBO() {
        return repartidorDAO.obtenerTrabajadoresHabilitados();
    }

    @Override
    public List<RepartidorDTO> obtenerTrabajadoresDeshabilitadosBO() {
        return repartidorDAO.obtenerTrabajadoresDeshabilitados();
    }

    @Override
    public List<RepartidorDTO> obtenerTodosLosRepartidoresBO() {
        return repartidorDAO.obtenerTodosLosRepartidores();
    }

    @Override
    public RepartidorDTO iniciarSesionRepartidorBO(String idRepartidor, String contrasena) {
        if (idRepartidor == null || idRepartidor.isBlank() || contrasena == null || contrasena.isBlank()) {
            return null;
        }

        return repartidorDAO.iniciarSesionRepartidor(idRepartidor, contrasena);
    }

    public Repartidor obtenerRepartidorPorCurpBO(String curp) throws Exception {
        if (curp == null || curp.trim().isEmpty()) {
            throw new IllegalArgumentException("La CURP no puede estar vacía.");
        }
        Repartidor r = repartidorDAO.obtenerRepartidorPorCurp(curp);
        if (r == null) {
            throw new Exception("No se encontró repartidor con CURP " + curp);
        }
        return r;
    }

    /**
     * Actualiza un repartidor, respetando campos nulos/vacíos.
     * @param dto
     * @param contrasena
     * @return 
     * @throws java.lang.Exception 
     */
    @Override
    public boolean actualizarRepartidorBO(RepartidorDTO dto, String contrasena) throws Exception {
        if (dto == null || dto.getIdRepartidor() == null || dto.getIdRepartidor().trim().isEmpty()) {
            throw new IllegalArgumentException("El DTO o su idRepartidor no pueden estar vacíos.");
        }
        // verificar existencia
        Repartidor orig = repartidorDAO.buscarRepartidorPorIdFriendly(dto.getIdRepartidor());
        if (orig == null) {
            throw new Exception("No existe repartidor con id " + dto.getIdRepartidor());
        }
        return repartidorDAO.actualizarRepartidor(dto, contrasena);
    }

}
