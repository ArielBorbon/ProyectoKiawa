/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import BO.CocineroBO;
import DAO.CocineroDAO;
import Entidades.Cocinero;
import Fabricas.FactoryBO;
import dto.CocineroDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class FSubsistema_Cocinero {

    private final CocineroBO cocineroBO;

    public FSubsistema_Cocinero() {
        this.cocineroBO = FactoryBO.crearCocineroBO();
    }
    
    
    
    /**
     * Exposición del nuevo método de búsqueda por CURP.
     */
    public Cocinero obtenerCocineroPorCurp(String curp) throws Exception {
        return cocineroBO.obtenerCocineroPorCurpBO(curp);
    }

    /**
     * Exposición del nuevo método de actualización parcial.
     */
    public boolean actualizarCocinero(CocineroDTO dto, String contrasena) throws Exception {
        return cocineroBO.actualizarCocineroBO(dto, contrasena);
    }

    public CocineroDTO login(String idFriendly, String contrasena) throws Exception {
        return cocineroBO.loginCocineroBO(idFriendly, contrasena);
    }

    public Cocinero buscarCocineroPorIdFriendly(String idFriendly) {
        return cocineroBO.buscarCocineroPorIdFriendlyBO(idFriendly);
    }

    public String generarNuevoIDCocinero() throws Exception {
        return cocineroBO.crearIDFriendlyBO();
    }

    public boolean registrarCocinero(CocineroDTO dto, String contrasena) throws Exception {
        return cocineroBO.crearCocineroBO(dto, contrasena);
    }

    public boolean habilitarCocinero(String idFriendly) throws Exception {
        return cocineroBO.habilitarCocineroBO(idFriendly);
    }

    public boolean deshabilitarCocinero(String idFriendly) {
        return cocineroBO.deshabilitarCocineroBO(idFriendly);
    }

    public List<CocineroDTO> obtenerCocinerosHabilitados() {
        return cocineroBO.obtenerTrabajadoresHabilitadosBO();
    }

    public List<CocineroDTO> obtenerCocinerosDeshabilitados() {
        return cocineroBO.obtenerTrabajadoresDeshabilitadosBO();
    }

    public List<CocineroDTO> obtenerTodosLosCocineros() {
        return cocineroBO.obtenerTodosLosCocinerosBO();
    }
}

