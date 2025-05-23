/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CasosDeUso.CU.TomarPedido;

import Control.ControlCocinero;
import Control.ControlPedido;
import Subsistema.FSubsistema_Pedidos;
import dto.PedidoDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jalt2
 */
public class PedidosAsignar extends javax.swing.JFrame {
    
    private PedidoDTO pedidoSeleccionado;
    private List<PedidoDTO> pedidosAsignar;
    private ControlPedido controlPedido;
    private ControlCocinero controlCocinero;
    /**
     * Creates new form PedidosRepartidor
     */
    public PedidosAsignar() {
        initComponents();
        llenarTabla();
        controlPedido = ControlPedido.getInstance();
        controlCocinero = ControlCocinero.getInstancia();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidosAsignar = new javax.swing.JTable();
        btnSeleccionarPedido = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.orange);

        tblPedidosAsignar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pedido", "Estado", "Fecha y Hora"
            }
        ));
        jScrollPane1.setViewportView(tblPedidosAsignar);

        btnSeleccionarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSeleccionarPedido.setText("Seleccionar Pedido");
        btnSeleccionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPedidoActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSeleccionarPedido)
                        .addGap(62, 62, 62)
                        .addComponent(btnRegresar)
                        .addGap(71, 71, 71)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarPedido)
                    .addComponent(btnRegresar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPedidoActionPerformed
        try {
            // TODO add your handling code here:
            seleccionarPedido();
            controlPedido.iniciarFrmAsignarPedido();
            this.dispose();
        } catch (ParseException ex) {
            Logger.getLogger(PedidosAsignar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSeleccionarPedidoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        controlCocinero.mostrarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    private void llenarTabla(){
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblPedidosAsignar.getModel();
            modelo.setRowCount(0);
            FSubsistema_Pedidos subsistema = new FSubsistema_Pedidos();
            pedidosAsignar = subsistema.obtenerPedidosPreparados();
                    
            for (PedidoDTO pedido : pedidosAsignar) {
                modelo.addRow(new Object[]{
                    pedido.getFolio(),
                    pedido.getEstado(),
                    pedido.getFechaPedido().toString(),
                    pedido.getNombreRepartidor()
                });
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(PedidosAsignar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void seleccionarPedido() throws ParseException{
        int filaSeleccionada = tblPedidosAsignar.getSelectedRow();
        
        if (filaSeleccionada >= 0) {
            String folio = tblPedidosAsignar.getValueAt(filaSeleccionada, 0).toString();
            String estado = tblPedidosAsignar.getValueAt(filaSeleccionada, 1).toString();
            String fechaTexto = tblPedidosAsignar.getValueAt(filaSeleccionada, 2).toString();
            

            
            SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date fecha = parser.parse(fechaTexto);
            
            pedidoSeleccionado = new PedidoDTO(folio, fecha, estado);
            controlPedido.setPedidoSeleccionado(pedidoSeleccionado);
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeleccionarPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPedidosAsignar;
    // End of variables declaration//GEN-END:variables
}
