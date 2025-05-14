/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import CasosDeUso.CU.PrepararPedido.HistorialPedido;
import CasosDeUso.CU.PrepararPedido.PedidosCocinero;
import Fabricas.FactoryBO;
import Logins.LoginCocinero;
import Menu.MenuCocinero;
import Subsistema.FSubsistema_Pedidos;
import control.ControlPresentacion;
import dto.CocineroDTO;
import dto.PedidoDTO;

import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlCocinero {

    private static ControlCocinero instancia = new ControlCocinero();
    private CocineroDTO cocinero;
    private PedidoDTO pedidoActual;
    private Stack<JFrame> historialFrames = new Stack<>();

    private ControlCocinero() {
    }

    public static ControlCocinero getInstancia() {
        return instancia;
    }

    public CocineroDTO getCocinero() {
        return cocinero;
    }

    public void setCocinero(CocineroDTO cocinero) {
        this.cocinero = cocinero;
    }

    public PedidoDTO getPedidoActual() {
        return pedidoActual;
    }

    public void setPedidoActual(PedidoDTO pedidoActual) {
        this.pedidoActual = pedidoActual;
    }

    public void cerrarSesion() {
        this.cocinero = null;
        this.pedidoActual = null;
        this.historialFrames.clear();
    }

    public void mostrarMenu() {
        MenuCocinero menu = new MenuCocinero();
        historialFrames.push(menu);
        menu.setVisible(true);
    }

    public void mostrarPedidosCocinero() {
        PedidosCocinero pedidos = new PedidosCocinero();
        historialFrames.push(pedidos);
        pedidos.setVisible(true);
    }

    public void mostrarHistorialPedidos() {
        try {
            HistorialPedido historial = new HistorialPedido();
            historialFrames.push(historial);
            historial.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar historial: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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

}
