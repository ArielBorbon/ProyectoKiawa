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

    public FSubsistema_Cocinero(CocineroDAO cocineroDAO) {
        this.cocineroBO = FactoryBO.crearCocineroBO();
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

