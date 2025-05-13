/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasosDeUso.CU.DarDeAlta;

import Logins.LoginAdministrador;
import Menu.MenuAdministrador;
import Subsistema.FSubsistema_Administrador;
import dto.AdministradorDTO;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rayoa
 */
public class ControlAdministrador {
    private static ControlAdministrador instancia = new ControlAdministrador();
    private final Stack<JFrame> historial = new Stack<>();
    private AdministradorDTO admin;

    private ControlAdministrador() {}

    public static ControlAdministrador getInstancia() {
        return instancia;
    }

    public void iniciarFlujo() {
        LoginAdministrador login = new LoginAdministrador();
        login.getBtnLoginAdministrador().addActionListener(e -> {
            String id = login.getTxtId().getText().trim();
            String pwd = new String(login.getTxtContrasena().getPassword());
            try {
                AdministradorDTO dto = new FSubsistema_Administrador().loginAdministrador(id, pwd);
                this.admin = dto;
                login.dispose();
                mostrarMenu();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(login,
                    "Usuario o contraseña incorrectos",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

  
    private void mostrarDarAlta() {
        DarDeAltaEmpleado alta = new DarDeAltaEmpleado();
        historial.push(alta);

        alta.getBtnRegresar().addActionListener(e -> {
            alta.dispose();
            regresar();
        });

        alta.setLocationRelativeTo(null);
        alta.setVisible(true);
    }

    /** 4) Navegar atrás */
    private void regresar() {
        if (!historial.isEmpty()) {
            JFrame actual = historial.pop();
            actual.dispose();
        }
        if (!historial.isEmpty()) {
            historial.peek().setVisible(true);
        }
    }

    public AdministradorDTO getAdministrador() {
        return admin;
    }
    
    
    

    /** Desde el menú, invoca esto para abrir la gestión de empleados */
    private void mostrarGestionarEmpleados() {
        GestionarEmpleados gestion = new GestionarEmpleados();
        historial.push(gestion);

        // Al pulsar Regresar, vuelve al menú
        gestion.getBtnRegresar().addActionListener(e -> {
            gestion.dispose();
            regresar();
        });

        gestion.setLocationRelativeTo(null);
        gestion.setVisible(true);
    }

    /** 2) Muestra el menú principal */
    private void mostrarMenu() {
        MenuAdministrador menu = new MenuAdministrador();
        historial.push(menu);

        menu.getBtnDarDeAltaEmpleado().addActionListener(e -> {
            menu.dispose();
            mostrarDarAlta();
        });
        menu.getBtnVerHistorial().addActionListener(e -> {
            menu.dispose();
            mostrarGestionarEmpleados();
        });
        menu.getBtnCerrarSesion().addActionListener(e -> {
            menu.dispose();
            historial.clear();
            admin = null;
            iniciarFlujo();
        });

        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}