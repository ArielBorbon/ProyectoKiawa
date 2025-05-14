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

    /**
     * Busca un cocinero por su CURP.
     * @param curp
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public Cocinero obtenerCocineroPorCurpBO(String curp) throws Exception {
        if (curp == null || curp.trim().isEmpty()) {
            throw new IllegalArgumentException("La CURP no puede estar vacía.");
        }
        Cocinero c = cocineroDAO.obtenerCocineroPorCurp(curp);
        if (c == null) {
            throw new Exception("No se encontró un cocinero con CURP " + curp);
        }
        return c;
    }

    /**
     * Actualiza un cocinero. Se conserva cada campo original si el DTO viene
     * nulo o vacío.
     * @param dto
     * @param contrasena
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    public boolean actualizarCocineroBO(CocineroDTO dto,String contrasena) throws Exception {
        if (dto == null || dto.getIdCocinero() == null || dto.getIdCocinero().trim().isEmpty()) {
            throw new IllegalArgumentException("El DTO o su idCocinero no pueden estar vacíos.");
        }
        // opcion: verificar que existe primero
        Cocinero original = cocineroDAO.buscarCocineroPorIdFriendly(dto.getIdCocinero());
        if (original == null) {
            throw new Exception("No existe cocinero con id " + dto.getIdCocinero());
        }
        return cocineroDAO.actualizarCocinero(dto, contrasena);
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

    @Override
    public CocineroDTO loginCocineroBO(String idFriendly, String contrasena) throws Exception {
        if (idFriendly == null || idFriendly.trim().isEmpty()) {
            throw new Exception("El ID del cocinero no puede estar vacío.");
        }

        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new Exception("La contraseña no puede estar vacía.");
        }

        CocineroDTO dto = cocineroDAO.loginCocinero(idFriendly, contrasena);

        if (dto == null) {
            throw new Exception("ID o contraseña incorrectos.");
        }

        return dto;
    }

}
