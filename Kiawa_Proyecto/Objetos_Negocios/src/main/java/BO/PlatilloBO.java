/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.PlatilloDAO;
import Entidades.DetallePedido;
import Entidades.Platillo;
import Interfaces.IPlatilloBO;
import dto.PlatilloDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class PlatilloBO implements IPlatilloBO {

    private PlatilloDAO platilloDAO;

    public PlatilloBO(PlatilloDAO platilloDAO) {
        this.platilloDAO = new PlatilloDAO();
    }

    @Override
    public List<PlatilloDTO> obtenerListaPlatillosDisponiblesBO() {
        return platilloDAO.obtenerListaPlatillosDisponibles();
    }

    @Override
    public List<PlatilloDTO> obtenerListaPlatillosTodosBO() {
        return platilloDAO.obtenerListaPlatillosTodos();
    }

    @Override
    public boolean actualizarExistenciasPlatilloBO(Platillo platillo, int nuevaCantidad) {
        if (platillo == null) {
            throw new IllegalArgumentException("El platillo no puede ser nulo.");
        }
        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException("La nueva cantidad de existencias no puede ser negativa.");
        }
        return platilloDAO.actualizarExistenciasPlatillo(platillo, nuevaCantidad);
    }

    @Override
    public Platillo obtenerPlatilloPorNombreBO(String nombrePlatillo) {
        if (nombrePlatillo == null || nombrePlatillo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del platillo no puede ser nulo o vacío.");
        }
        return platilloDAO.obtenerPlatilloPorNombre(nombrePlatillo);
    }

    @Override
    public boolean agregarPlatilloBO(PlatilloDTO platilloDTO) throws Exception {
        if (platilloDTO == null) {
            throw new IllegalArgumentException("El DTO del platillo no puede ser nulo.");
        }
        if (platilloDTO.getNombre() == null || platilloDTO.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del platillo no puede estar vacío.");
        }
        if (platilloDTO.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del platillo debe ser mayor a 0.");
        }
        if (platilloDTO.getExistencias() < 0) {
            throw new Exception("Las Existencias del Platillo no pueden ser negativas");
        }

        if (platilloDTO.getCategoria() == null) {
            throw new Exception("El platillo Necesita una Categoria.");
        }

        return platilloDAO.agregarPlatillo(platilloDTO);
    }

    @Override
    public boolean deshabilitarPlatilloBO(String nombrePlatillo) throws Exception {
        if (nombrePlatillo == null || nombrePlatillo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del platillo no puede ser nulo o vacío.");
        }

        return platilloDAO.deshabilitarPlatillo(nombrePlatillo);
    }

    @Override
    public boolean habilitarPlatilloBO(String nombrePlatillo) throws Exception {
        if (nombrePlatillo == null || nombrePlatillo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del platillo no puede ser nulo o vacío.");
        }

        return platilloDAO.habilitarPlatillo(nombrePlatillo);
    }

    @Override
    public boolean modificarPlatilloBO(String nombreOriginal, PlatilloDTO platilloDTO) {
        if (nombreOriginal == null || nombreOriginal.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre original del platillo no puede ser nulo o vacío.");
        }
        if (platilloDTO == null) {
            throw new IllegalArgumentException("El objeto PlatilloDTO no puede ser nulo.");
        }
        if (platilloDTO.getNombre() == null || platilloDTO.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del nuevo platillo no puede ser nulo o vacío.");
        }
        if (platilloDTO.getPrecio() == null || platilloDTO.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio del platillo debe ser mayor o igual a cero.");
        }
        if (platilloDTO.getExistencias() == null || platilloDTO.getExistencias() < 0) {
            throw new IllegalArgumentException("Las existencias del platillo deben ser mayor o igual a cero.");
        }

        return platilloDAO.modificarPlatillo(nombreOriginal, platilloDTO);
    }

    @Override
    public boolean hayExistenciasSuficientesSBBO(List<DetallePedido> detalles, StringBuilder mensajeError) {
        if (detalles == null || detalles.isEmpty()) {
            throw new IllegalArgumentException("La lista de detalles no puede ser nula ni vacía.");
        }

        return platilloDAO.hayExistenciasSuficientesSB(detalles, mensajeError);
    }

    @Override
    public List<PlatilloDTO> buscarPorCategoriaBO(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return platilloDAO.buscarPorCategoria(categoria.trim());
    }

    @Override
    public List<PlatilloDTO> buscarPorNombreBO(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return platilloDAO.buscarPorNombre(nombre.trim());
    }

    @Override
    public List<PlatilloDTO> buscarPorCategoriaYNombreBO(String categoria, String nombre) {
        if ((categoria == null || categoria.trim().isEmpty())
                && (nombre == null || nombre.trim().isEmpty())) {
            return new ArrayList<>();
        }

        return platilloDAO.buscarPorCategoriaYNombre(
                categoria != null ? categoria.trim() : "",
                nombre != null ? nombre.trim() : ""
        );
    }
}
