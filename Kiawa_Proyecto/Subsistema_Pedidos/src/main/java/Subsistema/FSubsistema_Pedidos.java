/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import BO.PedidoBO;
import BO.PlatilloBO;
import BO.UbicacionBO;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Fabricas.FactoryBO;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class FSubsistema_Pedidos {

    private final PedidoBO pedidoBO;
    private final PlatilloBO platilloBO;
    private final UbicacionBO ubicacionBO;

    public FSubsistema_Pedidos(){
        this.pedidoBO = FactoryBO.crearPedidoBO();
        this.platilloBO = FactoryBO.crearPlatilloBO();
        this.ubicacionBO = FactoryBO.crearUbicacionBO();
    }

    public FSubsistema_Pedidos(PedidoBO pedidoBO, PlatilloBO platilloBO, UbicacionBO ubicacionBO) {
        this.pedidoBO = pedidoBO;
        this.platilloBO = platilloBO;
        this.ubicacionBO = ubicacionBO;
    }

    /**
     * 1. Verificar si un folio ya existe
     *
     * @param folio
     * @return
     */
    public boolean existePedidoConFolio(String folio) {
        return pedidoBO.existePedidoConFolioBO(folio);
    }

    public String crearFolioPedido() {
        return pedidoBO.crearFolioPedidoBO();
    }

    public List<DetallePedido> convertirADetallePedidoEntity(List<DetallePedidoDTO> detalleDTOs) {
        return pedidoBO.convertirADetallePedidoEntityBO(detalleDTOs);
    }

    public Pedido mapearPedidoCompleto(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTOs, String idAlumno, String idCocinero, String idRepartidor) throws Exception {
        ubicacionBO.buscarUbicacionPorEdificioYSalonBO(pedidoDTO.getUbicacionEntrega());
        List<DetallePedido> detalles = pedidoBO.convertirADetallePedidoEntityBO(detalleDTOs);
        StringBuilder msgErr = new StringBuilder();
        if (!platilloBO.hayExistenciasSuficientesSBBO(detalles, msgErr)) {
            throw new Exception(msgErr.toString());
        }
        return pedidoBO.mapearPedidoCompletoBO(pedidoDTO, detalleDTOs, idAlumno, idCocinero, idRepartidor);
    }

    public boolean crearPedido(PedidoDTO pedidoDTO, List<DetallePedidoDTO> detalleDTOs, String idAlumno) throws Exception {
        ubicacionBO.buscarUbicacionPorEdificioYSalonBO(pedidoDTO.getUbicacionEntrega());
        List<DetallePedido> detalles = pedidoBO.convertirADetallePedidoEntityBO(detalleDTOs);
        StringBuilder msgErr = new StringBuilder();
        if (!platilloBO.hayExistenciasSuficientesSBBO(detalles, msgErr)) {
            throw new Exception(msgErr.toString());
        }
        return pedidoBO.crearPedidoBO(pedidoDTO, detalleDTOs, idAlumno);
    }

    public boolean cambiarEstadoPedido(String folio, String nuevoEstado) {
        return pedidoBO.cambiarEstadoPedidoBO(folio, nuevoEstado);
    }

    public List<PedidoDTO> obtenerHistorialPorNombreAlumno(String nombreAlumno) {
        return pedidoBO.obtenerHistorialPorNombreAlumnoBO(nombreAlumno);
    }
    
    public List<PedidoDTO> recuperarPedidos(){
        return pedidoBO.recuperarPedidos();
    }
    
    public List<PedidoDTO> obtenerPedidosPendientes() {
        return pedidoBO.obtenerPedidosPendientesBO();
    }

    public boolean asignarCocineroAPedido(String folioPedido, String idCocinero, String nombreCocinero) {
        return pedidoBO.asignarCocineroAPedidoBO(folioPedido, idCocinero, nombreCocinero);
    }

    public PedidoDTO obtenerPedidoPorFolio(String folio) {
        return pedidoBO.obtenerPedidoPorFolioBO(folio);
    }
    
    public boolean asignarPedidoRepartidor(String folioPedido, String nombreRepartidor){
        return pedidoBO.asignarPedidoRepartidor(folioPedido, nombreRepartidor);
    }
}
