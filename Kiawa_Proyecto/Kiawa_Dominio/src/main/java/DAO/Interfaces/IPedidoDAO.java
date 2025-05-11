/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import Entidades.DetallePedido;
import Entidades.Pedido;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IPedidoDAO {
    
    boolean existePedidoConFolio(String folio);
    
    String crearFolioPedido();
    
    List<DetallePedido> convertirADetallePedidoEntity(List<DetallePedidoDTO> detalleDTOs);
    
    Pedido mapearPedidoCompleto(
            PedidoDTO pedidoDTO,
            List<DetallePedidoDTO> listaDetalleDTO,
            String idAlumno,
            String idCocinero,
            String idRepartidor
    ) throws Exception;
    
    boolean crearPedido(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTOs, String idAlumno);
    
    boolean cambiarEstadoPedido(String folio, String nuevoEstado);
    
    public List<PedidoDTO> obtenerHistorialPlatillosPorAlumno(String nombreAlumno);
    
    public List<PedidoDTO> recuperarPedidos();
}

