/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import BO.RepartidorBO;
import Entidades.Repartidor;
import Fabricas.FactoryBO;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author Alberto Jimenez
 */
public class FSubsistema_Repartidor {

    private final RepartidorBO repartidorBO;

    public FSubsistema_Repartidor() throws Exception {
        this.repartidorBO = FactoryBO.crearRepartidorBO();
    }

    public FSubsistema_Repartidor(RepartidorBO repartidorBO) {
        this.repartidorBO = repartidorBO;
    }

    public boolean crearRepartidor(RepartidorDTO dto) throws Exception {
        return repartidorBO.crearRepartidorBO(dto);
    }

    public String crearIDFriendlyRepartidor() {
        return repartidorBO.crearIDFriendlyBO();
    }

    public Repartidor buscarRepartidorPorIdFriendly(String idFriendly) {
        return repartidorBO.buscarRepartidorPorIdFriendlyBO(idFriendly);
    }

    public boolean deshabilitarRepartidor(String idFriendly) {
        return repartidorBO.deshabilitarRepartidorBO(idFriendly);
    }

    public boolean habilitarRepartidor(String idFriendly) {
        return repartidorBO.habilitarRepartidorBO(idFriendly);
    }

    public List<RepartidorDTO> obtenerTrabajadoresHabilitados() {
        return repartidorBO.obtenerTrabajadoresHabilitadosBO();
    }

    public List<RepartidorDTO> obtenerTrabajadoresDeshabilitados() {
        return repartidorBO.obtenerTrabajadoresDeshabilitadosBO();
    }

    public List<RepartidorDTO> obtenerTodosLosRepartidores() {
        return repartidorBO.obtenerTodosLosRepartidoresBO();
    }

    public RepartidorDTO iniciarSesion(String id, String contrasena) {
        return repartidorBO.iniciarSesionRepartidorBO(id, contrasena);
    }
}
