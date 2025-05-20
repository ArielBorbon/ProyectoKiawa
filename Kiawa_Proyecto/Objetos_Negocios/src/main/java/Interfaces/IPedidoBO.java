/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.DetallePedido;
import Entidades.Pedido;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IPedidoBO {

    boolean existePedidoConFolioBO(String folio);

    String crearFolioPedidoBO();

    List<DetallePedido> convertirADetallePedidoEntityBO(List<DetallePedidoDTO> detalleDTOs);

    Pedido mapearPedidoCompletoBO(
            PedidoDTO pedidoDTO,
            List<DetallePedidoDTO> listaDetalleDTO,
            String idAlumno,
            String idCocinero,
            String idRepartidor
    ) throws Exception;

    boolean crearPedidoBO(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTOs, String idAlumno);
    
    boolean cambiarEstadoPedidoBO(String folio, String nuevoEstado);
    
    List<PedidoDTO> obtenerHistorialPorNombreAlumnoBO(String nombreAlumno);
    
    public List<PedidoDTO> recuperarPedidos();
    
    List<PedidoDTO> obtenerPedidosAsignadosARepartidorBO(String idRepartidor);
    public boolean asignarPedidoRepartidor(String folioPedido, String nombreRepartidor, String idRepartidor);
    public boolean asignarCocineroAPedidoBO(String folioPedido, String idCocinero, String nombreCocinero);
    public List<PedidoDTO> obtenerPedidosPreparados();
}
