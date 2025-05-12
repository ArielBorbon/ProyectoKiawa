/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import CasosDeUso.CU.TomarPedido.AsignarPedido;
import CasosDeUso.CU.TomarPedido.PedidosAsignar;
import Subsistema.FSubsistema_Pedidos;
import Subsistema.FSubsistema_Repartidor;
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
    private FSubsistema_Pedidos fSubsitema_pedido = new FSubsistema_Pedidos();
    private FSubsistema_Repartidor fSubsitema_repartidor =  new FSubsistema_Repartidor();
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
        fSubsitema_pedido.asignarPedidoRepartidor(folioPedido, nombreRepartidor);
    }
    
    public List<RepartidorDTO> recuperarRepartidoresDisponibles(){
        return fSubsitema_repartidor.obtenerTrabajadoresHabilitados();
    }
}
