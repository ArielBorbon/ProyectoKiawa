/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.PedidoDAO;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Interfaces.IPedidoBO;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC Gamer
 */
public class PedidoBO implements IPedidoBO {

    private PedidoDAO pedidoDAO;

    public PedidoBO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    @Override
    public boolean existePedidoConFolioBO(String folio) {
        if (folio == null || folio.trim().isEmpty()) {
            throw new IllegalArgumentException("El folio no puede ser nulo o vacío.");
        }
        return pedidoDAO.existePedidoConFolio(folio);
    }

    @Override
    public String crearFolioPedidoBO() {
        return pedidoDAO.crearFolioPedido();
    }

    @Override
    public List<DetallePedido> convertirADetallePedidoEntityBO(List<DetallePedidoDTO> detalleDTOs) {
        if (detalleDTOs == null || detalleDTOs.isEmpty()) {
            throw new IllegalArgumentException("La lista de detalles del pedido no puede ser nula o vacía.");
        }
        return pedidoDAO.convertirADetallePedidoEntity(detalleDTOs);
    }

    @Override
    public Pedido mapearPedidoCompletoBO(
            PedidoDTO pedidoDTO,
            List<DetallePedidoDTO> listaDetalleDTO,
            String idAlumno,
            String idCocinero,
            String idRepartidor
    ) throws Exception {

        if (pedidoDTO == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        if (listaDetalleDTO == null || listaDetalleDTO.isEmpty()) {
            throw new IllegalArgumentException("La lista de detalles del pedido no puede ser nula o vacía.");
        }
        if (idAlumno == null || idAlumno.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del alumno no puede ser nulo o vacío.");
        }

        return pedidoDAO.mapearPedidoCompleto(pedidoDTO, listaDetalleDTO, idAlumno, idCocinero, idRepartidor);
    }

    @Override
    public boolean crearPedidoBO(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTOs, String idAlumno) {
        if (pedidoDTO == null || detalleDTOs == null || detalleDTOs.isEmpty() || idAlumno == null || idAlumno.trim().isEmpty()) {
            throw new IllegalArgumentException("Parámetros inválidos para crear el pedido.");
        }

        List<DetallePedido> detalles = convertirADetallePedidoEntityBO(detalleDTOs);

        StringBuilder mensajeError = new StringBuilder();
        if (!pedidoDAO.revisarExistenciasPlatillo(detalles, mensajeError)) {
            try {
                throw new Exception(mensajeError.toString());
            } catch (Exception ex) {
                Logger.getLogger(PedidoBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return pedidoDAO.crearPedido(pedidoDTO, detalleDTOs, idAlumno);
    }
    
    @Override
    public boolean cambiarEstadoPedidoBO(String folio, String nuevoEstado) {
        return pedidoDAO.cambiarEstadoPedido(folio, nuevoEstado);
    }

    @Override
    public List<PedidoDTO> obtenerHistorialPorNombreAlumnoBO(String nombreAlumno) {
        if (nombreAlumno == null || nombreAlumno.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del alumno no puede ser nulo o vacío.");
        }

        return pedidoDAO.obtenerHistorialPlatillosPorAlumno(nombreAlumno);
    }

    @Override
    public List<PedidoDTO> recuperarPedidos() {
        return pedidoDAO.recuperarPedidos();
    }
    
    public List<PedidoDTO> obtenerPedidosPendientesBO() {
        return pedidoDAO.obtenerPedidosPendientes();
    }

    @Override
    public boolean asignarCocineroAPedidoBO(String folioPedido, String idCocinero, String nombreCocinero) {
        if (folioPedido == null || folioPedido.trim().isEmpty()) {
            throw new IllegalArgumentException("El folio del pedido no puede estar vacío");
        }
        if (idCocinero == null || idCocinero.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del cocinero no puede estar vacío");
        }
        if (nombreCocinero == null || nombreCocinero.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cocinero no puede estar vacío");
        }

        return pedidoDAO.asignarCocineroAPedido(folioPedido, idCocinero, nombreCocinero);
    }

    public PedidoDTO obtenerPedidoPorFolioBO(String folio) {
        if (folio == null || folio.trim().isEmpty()) {
            throw new IllegalArgumentException("El folio no puede estar vacío");
        }

        return pedidoDAO.obtenerPedidoPorFolio(folio);
    }

    @Override
    public List<PedidoDTO> obtenerPedidosAsignadosARepartidorBO(String idRepartidor) {
        if (idRepartidor == null || idRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del repartidor no puede ser nulo o vacío.");
        }
        return pedidoDAO.obtenerPedidosAsignadosARepartidor(idRepartidor);
    }

    @Override
    public boolean asignarPedidoRepartidor(String folioPedido, String nombreRepartidor, String idRepartidor) {
        if (folioPedido == null || folioPedido.trim().isEmpty()) {
            throw new IllegalArgumentException("El folio no puede estar vacío");
        }
            
        if (idRepartidor == null || idRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("El id del repartidor no puede estar vacío");
        }
        
        if (nombreRepartidor == null || nombreRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del Repartidor no puede estar vacío");
        }
        
        return pedidoDAO.asignarPedidoRepartidor(folioPedido, nombreRepartidor, idRepartidor);
    }

    @Override
    public List<PedidoDTO> obtenerPedidosPreparados() {
        return pedidoDAO.obtenerPedidosPreparados();
    }
}
