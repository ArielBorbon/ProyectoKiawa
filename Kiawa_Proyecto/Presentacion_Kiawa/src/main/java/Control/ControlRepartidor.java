/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Fabricas.FactoryBO;
import Logins.LoginRepartidor;
import Menu.MenuRepartidor;
import control.ControlPresentacion;
import dto.DetallePedidoDTO;
import dto.RepartidorDTO;
import dto.UbicacionDTO;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;
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
    
    public void cerrarSesion(){
        this.repartidor = null;
        
        ControlPresentacion.getInstancia().limpiarDetalles();
    }
    
    public void iniciarFlujo(){
        LoginRepartidor login = new LoginRepartidor();
        
        login.getBtnLoginRepartidor().addActionListener(e -> {
            
            try{
                String id = login.getTxtId().getText().trim();
                String pwd = new String(login.getTxtContrasena().getPassword());
                RepartidorDTO r = FactoryBO.crearRepartidorBO().iniciarSesionRepartidorBO(id,pwd);
                
                if(r == null){
                    JOptionPane.showMessageDialog(login, "Credenciales Invalidas");
                    throw new Exception();
                }
               ControlRepartidor.getInstancia().setRepartidor(r);
               
               login.dispose();
               mostrarMenuRepartidor();
                
            } catch(Exception ex){
                
            }
            
        });
        login.setVisible(true);
    }
    
    public void mostrarMenuRepartidor(){
        MenuRepartidor menu = new MenuRepartidor();
        
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
}
