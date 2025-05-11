/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import CasosDeUso.CU.TomarPedido.AsignarPedido;
import CasosDeUso.CU.TomarPedido.PedidosAsignar;

/**
 *
 * @author jalt2
 */
public class ControlPedido {
    private static ControlPedido instancia = new ControlPedido();
    private AsignarPedido frmAsignarPedido;
    private PedidosAsignar frmPedidosAsignar;
    
    
    public static ControlPedido getInstance(){
        return instancia;
    }
    
    public void iniciarFrmAsignarPedido(){
        frmAsignarPedido = new AsignarPedido();
        frmAsignarPedido.setVisible(true);
        frmPedidosAsignar.setVisible(false);
        
    }
}
