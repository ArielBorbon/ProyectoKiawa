/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

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

//    public void iniciarFlujo() {
//        LoginCocinero login = new LoginCocinero();
//
//        login.getBtnLoginEstudiante().addActionListener(e -> {
//            try {
//                String id = login.getTxtId().getText().trim();
//                String pwd = new String(login.getTxtContrasena().getPassword());
//                CocineroDTO c = FactoryBO.crearCocineroBO().loginCocineroBO(id, pwd);
//
//                if (c == null) {
//                    JOptionPane.showMessageDialog(login, "Credenciales inválidas");
//                    return;
//                }
//
//                ControlCocinero.getInstancia().setCocinero(c);
//                login.dispose();
//                mostrarMenuCocinero();
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(login, "Error: " + ex.getMessage());
//            }
//        });
//
//        login.setVisible(true);
//    }

//    public void mostrarMenuCocinero() {
//        MenuCocinero menu = new MenuCocinero();
//
//        menu.getBtnVerPedidos().addActionListener(e -> {
//            historialFrames.push(menu);
//            menu.dispose();
//            mostrarPedidosCocinero();
//        });
//
//        menu.getBtnCerrarSesion().addActionListener(e -> {
//            menu.dispose();
//            historialFrames.clear();
//            ControlCocinero.getInstancia().cerrarSesion();
//            iniciarFlujo();
//        });
//
//        menu.setVisible(true);
//    }

//    public void mostrarPedidosCocinero() {
//        PedidosCocinero pedidosCocinero = new PedidosCocinero();
//        pedidosCocinero.cargarPedidosPendientes();
//        
//        pedidosCocinero.getBtnRegresar().addActionListener(e -> regresar());
//        pedidosCocinero.getBtnVerPedido().addActionListener(e -> {
//            String folio = pedidosCocinero.getFolioPedidoSeleccionado();
//            if (folio == null) {
//                JOptionPane.showMessageDialog(pedidosCocinero, "Seleccione un pedido primero");
//                return;
//            }
//            
//            try {
//                FSubsistema_Pedidos subsistemaPedidos = new FSubsistema_Pedidos();
//                PedidoDTO pedido = subsistemaPedidos.obtenerPedidoPorFolio(folio);
//                
//                if (pedido == null) {
//                    JOptionPane.showMessageDialog(pedidosCocinero, "No se pudo cargar el pedido");
//                    return;
//                }
//                
//                setPedidoActual(pedido);
//                historialFrames.push(pedidosCocinero);
//                pedidosCocinero.dispose();
//                mostrarDetallePedidoCocinero();
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(pedidosCocinero, "Error: " + ex.getMessage());
//            }
//        });
//        
//        pedidosCocinero.setVisible(true);
//    }
//
//    public void mostrarDetallePedidoCocinero() {
//        DetallePedidoCocinero detallePedido = new DetallePedidoCocinero(pedidoActual);
//        
//        detallePedido.getBtnRegresar().addActionListener(e -> regresar());
//        detallePedido.getBtnPreparar().addActionListener(e -> {
//            try {
//                FSubsistema_Pedidos subsistemaPedidos = new FSubsistema_Pedidos();
//                boolean exito = subsistemaPedidos.asignarCocineroAPedido(
//                    pedidoActual.getFolio(), 
//                    cocinero.getIdCocinero(), 
//                    cocinero.getNombreCompleto()
//                );
//                
//                if (!exito) {
//                    JOptionPane.showMessageDialog(detallePedido, "No se pudo asignar el pedido");
//                    return;
//                }
//                
//                // Actualizamos el estado del pedido en memoria
//                pedidoActual.setEstado("EN_PREPARACION");
//                pedidoActual.setIdCocinero(cocinero.getIdCocinero());
//                pedidoActual.setNombreCocinero(cocinero.getNombreCompleto());
//                
//                historialFrames.push(detallePedido);
//                detallePedido.dispose();
//                mostrarPreparacionPedido();
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(detallePedido, "Error: " + ex.getMessage());
//            }
//        });
//        
//        detallePedido.setVisible(true);
//    }
//
//    public void mostrarPreparacionPedido() {
//        PreparacionPedido preparacionPedido = new PreparacionPedido(pedidoActual);
//        
//        preparacionPedido.getBtnRegresar().addActionListener(e -> regresar());
//        preparacionPedido.getBtnTerminar().addActionListener(e -> {
//            try {
//                FSubsistema_Pedidos subsistemaPedidos = new FSubsistema_Pedidos();
//                boolean exito = subsistemaPedidos.cambiarEstadoPedido(pedidoActual.getFolio(), "LISTO");
//                
//                if (!exito) {
//                    JOptionPane.showMessageDialog(preparacionPedido, "No se pudo terminar el pedido");
//                    return;
//                }
//                
//                historialFrames.push(preparacionPedido);
//                preparacionPedido.dispose();
//                mostrarConfirmacionPreparacion();
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(preparacionPedido, "Error: " + ex.getMessage());
//            }
//        });
//        
//        preparacionPedido.setVisible(true);
//    }
//
//    public void mostrarConfirmacionPreparacion() {
//        ConfirmacionPreparacion confirmacion = new ConfirmacionPreparacion();
//        
//        confirmacion.getBtnRegresar().addActionListener(e -> {
//            confirmacion.dispose();
//            historialFrames.clear(); // Limpiamos para volver al inicio
//            mostrarMenuCocinero();
//        });
//        
//        confirmacion.setVisible(true);
//    }
//
//    public void regresar() {
//        if (!historialFrames.isEmpty()) {
//            JFrame actual = historialFrames.peek();
//            actual.setVisible(true);
//            historialFrames.pop();
//        } else {
//            mostrarMenuCocinero();
//        }
}
