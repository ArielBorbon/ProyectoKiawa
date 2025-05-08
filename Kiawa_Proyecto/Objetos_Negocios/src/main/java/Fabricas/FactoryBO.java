/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import BO.AdministradorBO;
import BO.AlumnoBO;
import BO.CocineroBO;
import BO.PedidoBO;
import BO.PlatilloBO;
import BO.RepartidorBO;
import BO.UbicacionBO;
import DAO.AdministradorDAO;
import DAO.CocineroDAO;
import DAO.PedidoDAO;
import DAO.PlatilloDAO;
import DAO.RepartidorDAO;
import DAO.UbicacionDAO;

/**
 *
 * @author PC Gamer
 */
public class FactoryBO {

    public static PlatilloBO crearPlatilloBO() {
        PlatilloDAO dao = new PlatilloDAO();
        return new PlatilloBO(dao);
    }

    public static PedidoBO crearPedidoBO() {
        PedidoDAO dao = new PedidoDAO();
        return new PedidoBO(dao);
    }

    public static UbicacionBO crearUbicacionBO() {
        UbicacionDAO dao = new UbicacionDAO();
        return new UbicacionBO(dao);
    }

    public static RepartidorBO crearRepartidorBO() {
        RepartidorDAO dao = new RepartidorDAO();
        return new RepartidorBO(dao);
    }

    public static CocineroBO crearCocineroBO() {
        CocineroDAO dao = new CocineroDAO();
        return new CocineroBO(dao);
    }

    public static AdministradorBO crearAdministradorBO() {
        AdministradorDAO dao = new AdministradorDAO();
        return new AdministradorBO(dao);
    }

    public static AlumnoBO crearAlumnoBO() {
        return new AlumnoBO();
    }

}
