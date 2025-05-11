/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import CasosDeUso.CU.Equipo.ConfirmarPedido;
import CasosDeUso.CU.Equipo.HistorialPedidos;
import CasosDeUso.CU.Equipo.SeleccionarPlatillos;
import CasosDeUso.CU.Equipo.SeleccionarUbicacion;
import Fabricas.FactoryBO;
import Logins.LoginEstudiante;
import Menu.MenuEstudiante;
import control.ControlPresentacion;
import dto.AlumnoDTO;
import dto.DetallePedidoDTO;
import dto.LoginRequestDTO;
import dto.UbicacionDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PC Gamer
 */
public class ControlAlumno {

    private Stack<JFrame> historialFrames = new Stack<>();

    private static ControlAlumno instancia = new ControlAlumno();
    private AlumnoDTO alumno;
    private List<DetallePedidoDTO> detallesSeleccionados;
    private UbicacionDTO ubicacionSeleccionada;
    private String instruccionesEntrega;
    private Double total;

    private ControlAlumno() {
        detallesSeleccionados = new ArrayList<>();
    }

    public Stack<JFrame> getHistorialFrames() {
        return historialFrames;
    }

    public void setHistorialFrames(Stack<JFrame> historialFrames) {
        this.historialFrames = historialFrames;
    }

    public static ControlAlumno getInstancia() {
        return instancia;
    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    public List<DetallePedidoDTO> getDetallesSeleccionados() {
        return detallesSeleccionados;
    }

    public void setDetallesSeleccionados(List<DetallePedidoDTO> detallesSeleccionados) {
        this.detallesSeleccionados = detallesSeleccionados;
    }

    public UbicacionDTO getUbicacionSeleccionada() {
        return ubicacionSeleccionada;
    }

    public void setUbicacionSeleccionada(UbicacionDTO ubicacionSeleccionada) {
        this.ubicacionSeleccionada = ubicacionSeleccionada;
    }

    public String getInstruccionesEntrega() {
        return instruccionesEntrega;
    }

    public void setInstruccionesEntrega(String instruccionesEntrega) {
        this.instruccionesEntrega = instruccionesEntrega;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void cerrarSesion() {
        this.alumno = null;
        this.detallesSeleccionados.clear();
        this.ubicacionSeleccionada = null;
        this.instruccionesEntrega = null;
        this.total = null;

        ControlPresentacion.getInstancia().limpiarDetalles();
    }

    public void iniciarFlujo() {
        LoginEstudiante login = new LoginEstudiante();

        login.getBtnLoginEstudiante().addActionListener(e -> {

            try {
                String id = login.getTxtId().getText().trim();
                String pwd = new String(login.getTxtContrasena().getPassword());
                AlumnoDTO a = FactoryBO.crearAlumnoBO().recuperarAlumno(new LoginRequestDTO(id, pwd));

                if (a == null) {
                    JOptionPane.showMessageDialog(login, "Credenciales inválidas");
                    throw new Exception();
                }

                ControlAlumno.getInstancia().setAlumno(a);

                login.dispose();
                mostrarMenuEstudiante();
            } catch (Exception ex) {

            }

        });

        login.setVisible(true);
    }

    private void mostrarMenuEstudiante() {
        MenuEstudiante menu = new MenuEstudiante();

        menu.getBtnOrdenarPlatillos().addActionListener(e -> {
            historialFrames.push(menu);
            menu.dispose();
            mostrarSeleccionarPlatillos();
        });

        menu.getBtnCerrarSesion().addActionListener(e -> {
            menu.dispose();
            historialFrames.clear();
            ControlAlumno.getInstancia().cerrarSesion();
            iniciarFlujo();
        });

        menu.getBtnVerHistorial().addActionListener(e -> {
            historialFrames.push(menu);
            menu.dispose();
            try {
                mostrarHistorialPedidos();
            } catch (Exception ex) {
                Logger.getLogger(ControlAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        menu.setVisible(true);
    }

    private HistorialPedidos historialPedidosFrame;

    public void mostrarHistorialPedidos() throws Exception {
        historialPedidosFrame = new HistorialPedidos();

        historialFrames.push(historialPedidosFrame);

        historialPedidosFrame.getBtnRegresar().addActionListener(e -> regresar());

        historialPedidosFrame.setVisible(true);
    }

    public void mostrarMenuEstudianteP() {
        mostrarMenuEstudiante();
    }

    private void mostrarSeleccionarPlatillos() {
        SeleccionarPlatillos sel = new SeleccionarPlatillos();

        sel.getBtnContinuar().addActionListener(e -> {
            if (ControlPresentacion.getInstancia().getDetallesSeleccionados().isEmpty()) {
                JOptionPane.showMessageDialog(sel, "Por favor, selecciona al menos un platillo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            sel.actualizarTablaSeleccionados();
            ControlAlumno.getInstancia().setDetallesSeleccionados(
                    ControlPresentacion.getInstancia().getDetallesSeleccionados()
            );
            ControlAlumno.getInstancia().setTotal(ControlPresentacion.getInstancia().getTotal());

            historialFrames.push(sel);
            sel.dispose();

            mostrarSeleccionarUbicacion();
        });

        sel.getBtnRegresar().addActionListener(e -> regresar());

        sel.setVisible(true);
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
            mostrarMenuEstudiante();
        }
    }

    private SeleccionarUbicacion seleccionarUbicacion;

    private void mostrarSeleccionarUbicacion() {
        seleccionarUbicacion = new SeleccionarUbicacion();
        if (ubicacionSeleccionada != null) {
            seleccionarUbicacion.getTxtAula().setText(ubicacionSeleccionada.getSalon());
            seleccionarUbicacion.getTxtEdificio().setText(ubicacionSeleccionada.getEdificio());
            seleccionarUbicacion.getTxtInstruccionesEntrega().setText(instruccionesEntrega);
        }

        historialFrames.push(seleccionarUbicacion);

        seleccionarUbicacion.getBtnContinuar().addActionListener(e -> {
            if (seleccionarUbicacion.getTxtAula().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(seleccionarUbicacion, "Por favor, selecciona ubicación.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Guardar datos y avanzar
            String ed = seleccionarUbicacion.getTxtEdificio().getText();
            String au = seleccionarUbicacion.getTxtAula().getText();
            String ins = seleccionarUbicacion.getTxtInstruccionesEntrega().getText();

            ControlAlumno.getInstancia().setUbicacionSeleccionada(new UbicacionDTO(ed, au));
            ControlAlumno.getInstancia().setInstruccionesEntrega(ins);

            seleccionarUbicacion.dispose();
            mostrarConfirmarPedido();
        });

        seleccionarUbicacion.getBtnRegresar().addActionListener(e -> regresar());

        seleccionarUbicacion.setVisible(true);
    }

    private ConfirmarPedido confirmarPedido;

    public void mostrarConfirmarPedido() {
        if (confirmarPedido == null) {
            confirmarPedido = new ConfirmarPedido();
        }

        historialFrames.push(confirmarPedido);

        confirmarPedido.acomodarTodo();

        confirmarPedido.getBtnRegresar().addActionListener(e -> regresar());

        confirmarPedido.setVisible(true);
    }

}
