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
import java.util.Stack;
import javax.swing.JFrame;

/**
 *
 * @author jalt2
 */
public class ControlPedido {
    private static ControlPedido instancia = new ControlPedido();
    private FSubsistema_Pedidos fSubsitema_pedido = new FSubsistema_Pedidos();
    private FSubsistema_Repartidor fSubsitema_repartidor =  new FSubsistema_Repartidor();
    private PedidoDTO pedidoSeleccionado;
    private RepartidorDTO repartidorAsignar;
    private Stack<JFrame> historialFrames = new Stack<>();
    
    
    public static ControlPedido getInstance(){
        if (instancia == null) {
            instancia = new ControlPedido();
        }
        return instancia;
    }
    
    public void iniciarFrmAsignarPedido(){
        AsignarPedido asignarPedido = new AsignarPedido();
        historialFrames.push(asignarPedido);
        asignarPedido.setLocationRelativeTo(null);
        asignarPedido.setVisible(true);
        
        
    }
    
    public List<PedidoDTO> recuperarPedidos(){
        return fSubsitema_pedido.recuperarPedidos();
    }
    
    public void iniciarFrmPedidosAsignar(){
        PedidosAsignar pedidosAsignar = new PedidosAsignar();
        historialFrames.push(pedidosAsignar);
        pedidosAsignar.setLocationRelativeTo(null);
        pedidosAsignar.setVisible(true);
    }
    
    public void asignarPedidoRepartidor(String folioPedido, String nombreRepartidor, String idRepartidor){
        fSubsitema_pedido.asignarPedidoRepartidor(folioPedido, nombreRepartidor, idRepartidor);
    }
    
    public void asignarPedidoCocinero(String folioPedido, String nombreCocinero, String idCocinero){
        fSubsitema_pedido.asignarCocineroAPedido(folioPedido, idCocinero, nombreCocinero);
    }
    
    public List<RepartidorDTO> recuperarRepartidoresDisponibles(){
        return fSubsitema_repartidor.obtenerTrabajadoresHabilitados();
    }

    public PedidoDTO getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(PedidoDTO pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }

    public RepartidorDTO getRepartidorAsignar() {
        return repartidorAsignar;
    }

    public void setRepartidorAsignar(RepartidorDTO repartidorAsignar) {
        this.repartidorAsignar = repartidorAsignar;
    }
    
    public void regresar() {
        if (!historialFrames.isEmpty()) {
            JFrame anterior = historialFrames.pop();
            anterior.dispose();
            if (!historialFrames.isEmpty()) {
                historialFrames.peek().setVisible(true);
            }
        }
    }
    
    public void cerrarSesion() {
        this.pedidoSeleccionado = null;
        this.repartidorAsignar = null;
        this.historialFrames.clear();
    }
}
