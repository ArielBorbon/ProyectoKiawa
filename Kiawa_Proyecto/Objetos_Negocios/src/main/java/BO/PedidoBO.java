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

/**
 *
 * @author PC Gamer
 */
public class PedidoBO implements IPedidoBO{

    private PedidoDAO pedidoDAO = new PedidoDAO();

    @Override
    public boolean existePedidoConFolioBO(String folio) {
        if (folio == null || folio.trim().isEmpty()) {
            throw new IllegalArgumentException("El folio no puede ser nulo o vacío.");
        }
        return pedidoDAO.existePedidoConFolio(folio);
    }

    @Override
    public String crearFolioPedidoBO() {
        return pedidoDAO.crearFolioPedido(); // No necesita validación
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

        // Id del cocinero y repartidor pueden ser null si aún no se han asignado
        return pedidoDAO.mapearPedidoCompleto(pedidoDTO, listaDetalleDTO, idAlumno, idCocinero, idRepartidor);
    }

    @Override
    public boolean crearPedidoBO(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTOs, String idAlumno) {
        if (pedidoDTO == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        if (detalleDTOs == null || detalleDTOs.isEmpty()) {
            throw new IllegalArgumentException("Los detalles del pedido no pueden ser nulos o vacíos.");
        }
        if (idAlumno == null || idAlumno.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del alumno no puede ser nulo o vacío.");
        }

        return pedidoDAO.crearPedido(pedidoDTO, detalleDTOs, idAlumno);
    }
}
