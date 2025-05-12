/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import CasosDeUso.CU.EntregarPedido.ConfirmarEntrega;
import CasosDeUso.CU.EntregarPedido.DetallesPedido;
import CasosDeUso.CU.EntregarPedido.HistorialEntregas;
import CasosDeUso.CU.EntregarPedido.PedidosRepartidor;
import Fabricas.FactoryBO;
import Logins.LoginRepartidor;
import Menu.MenuRepartidor;
import Subsistema.FSubsistema_Pedidos;
import control.ControlPresentacion;
import dto.PedidoDTO;
import dto.RepartidorDTO;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto Jimenez
 */
public class ControlRepartidor {

    private Stack<JFrame> historialFrames = new Stack<>();

    private static ControlRepartidor instancia = new ControlRepartidor();
    private RepartidorDTO repartidor;
    private PedidoDTO pedidoSeleccionado;

    public Stack<JFrame> getHistorialFrames() {
        return historialFrames;
    }

    public void setHistorialFrames(Stack<JFrame> historialFrames) {
        this.historialFrames = historialFrames;
    }

    public static ControlRepartidor getInstancia() {
        return instancia;
    }

    public static void setInstancia(ControlRepartidor instancia) {
        ControlRepartidor.instancia = instancia;
    }

    public RepartidorDTO getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(RepartidorDTO repartidor) {
        this.repartidor = repartidor;
    }

    public PedidoDTO getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(PedidoDTO pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }

    public void cerrarSesion() {
        this.repartidor = null;

        ControlPresentacion.getInstancia().limpiarDetalles();
    }

    public void iniciarFlujo() {
        LoginRepartidor login = new LoginRepartidor();

        login.getBtnLoginRepartidor().addActionListener(e -> {

            try {
                String id = login.getTxtId().getText().trim();
                String pwd = new String(login.getTxtContrasena().getPassword());
                RepartidorDTO r = FactoryBO.crearRepartidorBO().iniciarSesionRepartidorBO(id, pwd);

                if (r == null) {
                    JOptionPane.showMessageDialog(login, "Credenciales Invalidas");
                    throw new Exception();
                }
                ControlRepartidor.getInstancia().setRepartidor(r);

                login.dispose();
                mostrarMenuRepartidor();

            } catch (Exception ex) {

            }

        });
        login.setVisible(true);
    }

    public void mostrarMenuRepartidor() {
        MenuRepartidor menu = new MenuRepartidor();

        menu.getBtnSeleccionarPedido().addActionListener(e -> {
            historialFrames.push(menu);
            menu.dispose();
            mostrarSeleccionarPedidos();
        });
        
        menu.getBtnHistorialEntregas().addActionListener(e -> {
            historialFrames.push(menu);
            menu.dispose();
            mostrarHistorialEntregas();
        });
        
        menu.getBtnCerrarSesion().addActionListener(e -> {
            menu.dispose();
            historialFrames.clear();
            ControlRepartidor.getInstancia().cerrarSesion();
            iniciarFlujo();
        });

        menu.setVisible(true);
    }

    public void regresar() {
        if (!historialFrames.isEmpty()) {
            JFrame actual = historialFrames.pop();
            actual.dispose();
        }

        if (!historialFrames.isEmpty()) {
            JFrame anterior = historialFrames.peek();
            anterior.setVisible(true);
        } else {
            mostrarMenuRepartidor();
        }
    }

    private void mostrarSeleccionarPedidos() {
        PedidosRepartidor seleccionarPedido = new PedidosRepartidor();

        seleccionarPedido.getBtnSeleccionarPedido().addActionListener(e -> {
            if (seleccionarPedido.seleccionarPedido()) {
                mostrarDetallesPedido();
                seleccionarPedido.dispose();
            }
        });

        seleccionarPedido.getBtnRegresar().addActionListener(e -> {
            regresar();
        });
        seleccionarPedido.setVisible(true);
    }

    private void mostrarHistorialEntregas(){
        HistorialEntregas historialEntregas = new HistorialEntregas();
        
        historialEntregas.getBtnRegresar().addActionListener(e -> {
            regresar();
            historialEntregas.dispose();
        });
        
        historialEntregas.setVisible(true);
    }
    
    private void mostrarDetallesPedido() {
        DetallesPedido detallesPedido = new DetallesPedido();

        detallesPedido.getBtnEntregarPedido().addActionListener(e -> {
            mostrarConfirmarEntrega();
            detallesPedido.dispose();
        });
        detallesPedido.getBtnDevolverPedido().addActionListener(e -> {
            String folio = pedidoSeleccionado.getFolio();
            JOptionPane.showMessageDialog(
                    null,
                    "No se ha encontrado al alumno, se devolverá el producto.",
                    "Devolución de pedido",
                    JOptionPane.WARNING_MESSAGE
            );
            String devuelto = "DEVUELTO";
            actualizarEstado(folio, devuelto, detallesPedido);
            regresar();
            detallesPedido.dispose();
        });
        detallesPedido.setVisible(true);
    }

    private void mostrarConfirmarEntrega() {
        ConfirmarEntrega confirmarEntrega = new ConfirmarEntrega();
        String folio = pedidoSeleccionado.getFolio();
        confirmarEntrega.getBtnConfirmarPago().addActionListener(e -> {
            String entregado = "ENTREGADO";
            actualizarEstado(folio, entregado, confirmarEntrega);
            regresar();
            confirmarEntrega.dispose();
        });
        confirmarEntrega.getBtnNegarPago().addActionListener(e -> {
            String devuelto = "DEVUELTO";
            actualizarEstado(folio, devuelto, confirmarEntrega);
            regresar();
            confirmarEntrega.dispose();
        });
        confirmarEntrega.setVisible(true);
    }

    private void actualizarEstado(String folio, String estado, JFrame ventanaActual) {
        FSubsistema_Pedidos subsistema = new FSubsistema_Pedidos();
        boolean actualizado = subsistema.cambiarEstadoPedido(folio, estado);

        if (actualizado) {
            JOptionPane.showMessageDialog(ventanaActual, "Estado actulizado.");
            ventanaActual.dispose();
        } else {
            JOptionPane.showMessageDialog(ventanaActual, "No se pudo actualizar el estado del pedido.");
        }
    }
}
