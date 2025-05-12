/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import BO.PedidoBO;
import BO.RepartidorBO;
import CasosDeUso.CU.TomarPedido.AsignarPedido;
import CasosDeUso.CU.TomarPedido.PedidosAsignar;
import dto.PedidoDTO;
import dto.RepartidorDTO;
import java.util.List;

/**
 *
 * @author jalt2
 */
public class ControlPedido {
    private static ControlPedido instancia = new ControlPedido();
    private AsignarPedido frmAsignarPedido;
    private PedidosAsignar frmPedidosAsignar;
    private PedidoBO pedidoBO = Fabricas.FactoryBO.crearPedidoBO();
    private RepartidorBO repartidorBO = Fabricas.FactoryBO.crearRepartidorBO();
    private PedidoDTO pedidoSeleccionado = this.frmPedidosAsignar.guardarPedidoSeleccionado();
    
    
    public static ControlPedido getInstance(){
        return instancia;
    }
    
    public void iniciarFrmAsignarPedido(){
        frmAsignarPedido = new AsignarPedido();
        frmAsignarPedido.setVisible(true);
        frmPedidosAsignar.setVisible(false);
        
    }
    
    public void iniciarFrmPedidosAsignar(){
        frmPedidosAsignar = new PedidosAsignar();
        frmAsignarPedido.setVisible(false);
        frmPedidosAsignar.setVisible(true);
    }
    
    public PedidoDTO recuperarPedidoSeleccionado(){
        return pedidoSeleccionado;
    }
    
    public void asignarPedidoRepartidor(String folioPedido, String nombreRepartidor){
        pedidoBO.asignarPedidoRepartidor(folioPedido, nombreRepartidor);
    }
    
    public List<RepartidorDTO> recuperarRepartidoresDisponibles(){
        return repartidorBO.obtenerTrabajadoresHabilitadosBO();
    }
}
