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
    public boolean crearRepartidorBO(RepartidorDTO dto) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO del repartidor no puede ser nulo.");
        }
        if (dto.getNombreCompleto() == null || dto.getNombreCompleto().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del repartidor no puede estar vacío.");
        }
        if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del repartidor no puede estar vacío.");
        }
        return repartidorDAO.crearRepartidor(dto);
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
}

