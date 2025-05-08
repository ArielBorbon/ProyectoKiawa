/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.CocineroDAO;
import Entidades.Cocinero;
import Interfaces.ICocineroBO;
import dto.CocineroDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class CocineroBO implements ICocineroBO {

    private CocineroDAO cocineroDAO;

    public CocineroBO(CocineroDAO cocineroDAO) {
        this.cocineroDAO = cocineroDAO;
    }
    
    

    @Override
    public Cocinero buscarCocineroPorIdFriendlyBO(String idFriendly) {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del cocinero no puede ser nulo o vacío.");
        }
        return cocineroDAO.buscarCocineroPorIdFriendly(idFriendly);
    }

    @Override
    public String crearIDFriendlyBO() throws Exception {
        return cocineroDAO.crearIDFriendly(); 
    }

    @Override
    public boolean crearCocineroBO(CocineroDTO dto, String contrasena) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO del cocinero no puede ser nulo.");
        }
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía.");
        }
        return cocineroDAO.crearCocinero(dto, contrasena);
    }

    @Override
    public boolean habilitarCocineroBO(String idFriendly) throws Exception {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del cocinero no puede ser nulo o vacío.");
        }
        return cocineroDAO.habilitarCocinero(idFriendly);
    }

    @Override
    public boolean deshabilitarCocineroBO(String idFriendly) {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del cocinero no puede ser nulo o vacío.");
        }
        return cocineroDAO.deshabilitarCocinero(idFriendly);
    }

    @Override
    public List<CocineroDTO> obtenerTrabajadoresHabilitadosBO() {
        return cocineroDAO.obtenerTrabajadoresHabilitados();
    }

    @Override
    public List<CocineroDTO> obtenerTrabajadoresDeshabilitadosBO() {
        return cocineroDAO.obtenerTrabajadoresDeshabilitados();
    }


    @Override
    public List<CocineroDTO> obtenerTodosLosCocinerosBO() {
        return cocineroDAO.obtenerTodosLosCocineros();
    }
}

