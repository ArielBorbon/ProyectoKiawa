/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import CasosDeUso.CU.Equipo.ConfirmarPedido;
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
import javax.swing.JOptionPane;

/**
 *
 * @author PC Gamer
 */
public class ControlAlumno {

    private static ControlAlumno instancia = new ControlAlumno();
    private AlumnoDTO alumno;
    private List<DetallePedidoDTO> detallesSeleccionados;
    private UbicacionDTO ubicacionSeleccionada;
    private String instruccionesEntrega;

    private ControlAlumno() {
        detallesSeleccionados = new ArrayList<>();
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

    public void iniciarFlujo() {
        LoginEstudiante login = new LoginEstudiante();
        login.getBtnLoginEstudiante().addActionListener(e -> {
            try {
                String id = login.getTxtId().getText().trim();
                String pwd = new String(login.getTxtContrasena().getPassword());
                AlumnoDTO a = FactoryBO.crearAlumnoBO().recuperarAlumno(new LoginRequestDTO(id, pwd));
                ControlAlumno.getInstancia().setAlumno(a);
                login.dispose();
                mostrarMenuEstudiante();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(login, "Credenciales inválidas");
            }
        });
        login.setVisible(true);
    }

    private void mostrarMenuEstudiante() {
        MenuEstudiante menu = new MenuEstudiante();
        menu.getBtnOrdenarPlatillos().addActionListener(e -> {
            menu.dispose();
            mostrarSeleccionarPlatillos();
        });
        menu.setVisible(true);
    }

    private void mostrarSeleccionarPlatillos() {
        SeleccionarPlatillos sel = new SeleccionarPlatillos();
        // Cuando el usuario hace click en “Continuar”:
        sel.getBtnContinuar().addActionListener(e -> {
            // Refrescar la tabla destino por si cambió
            sel.actualizarTablaSeleccionados();
            // Guardar la lista global en el control
            ControlAlumno.getInstancia().setDetallesSeleccionados(
                    ControlPresentacion.getInstancia().getDetallesSeleccionados()
            );
            sel.dispose();
            mostrarSeleccionarUbicacion();
        });
        sel.setVisible(true);
    }

private SeleccionarUbicacion seleccionarUbicacion;

private void mostrarSeleccionarUbicacion() {
    seleccionarUbicacion = new SeleccionarUbicacion();
    seleccionarUbicacion.getBtnContinuar().addActionListener(e -> {
        String ed = seleccionarUbicacion.getTxtEdificio().getText();
        String au = seleccionarUbicacion.getTxtAula().getText();
        String ins = seleccionarUbicacion.getTxtInstruccionesEntrega().getText();
        ControlAlumno.getInstancia().setUbicacionSeleccionada(new UbicacionDTO(ed, au));
        ControlAlumno.getInstancia().setInstruccionesEntrega(ins);
        seleccionarUbicacion.dispose();
        mostrarConfirmarPedido();
    });
    seleccionarUbicacion.setVisible(true);
}

    
    
    
private ConfirmarPedido confirmarPedido;

public void mostrarConfirmarPedido() {
    if (confirmarPedido == null) {
        confirmarPedido = new ConfirmarPedido();
    }
    confirmarPedido.acomodarTodo(); 
    confirmarPedido.setVisible(true);
    seleccionarUbicacion.setVisible(false);
}



}
