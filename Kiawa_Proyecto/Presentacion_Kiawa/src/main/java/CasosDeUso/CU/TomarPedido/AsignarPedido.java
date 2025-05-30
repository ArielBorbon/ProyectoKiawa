/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CasosDeUso.CU.TomarPedido;

import Control.ControlPedido;
import dto.PedidoDTO;
import dto.RepartidorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jalt2
 */
public class AsignarPedido extends javax.swing.JFrame {
    
    private ControlPedido control;
    private PedidoDTO pedidoSeleccionado;
    private List<String> idRepartidores = new ArrayList<>();
    
    /**
     * Creates new form AsignarPedido
     */
    public AsignarPedido() {
        initComponents();
        control = ControlPedido.getInstance();
        pedidoSeleccionado = control.getPedidoSeleccionado();
        llenarComboBoxRepartidores();
        this.txtPedidoSeleccionado.setText(control.getPedidoSeleccionado().getFolio());
    }
    
    private void llenarComboBoxRepartidores(){
        List<RepartidorDTO> listaRepartidores = control.recuperarRepartidoresDisponibles();
        
        
        for(RepartidorDTO r : listaRepartidores){
            this.cmbRepartidores.addItem(r.getNombreCompleto());
            idRepartidores.add(r.getIdRepartidor());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPedidoSeleccionado = new javax.swing.JTextField();
        cmbRepartidores = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnAsignarPedido = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));
        setForeground(java.awt.Color.orange);

        jLabel1.setText("Pedido Seleccionado");

        txtPedidoSeleccionado.setEditable(false);

        jLabel2.setText("Repartidores Disponibles");

        btnAsignarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAsignarPedido.setText("Asignar Pedido");
        btnAsignarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarPedidoActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtPedidoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(cmbRepartidores, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnAsignarPedido)
                .addGap(44, 44, 44)
                .addComponent(btnRegresar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPedidoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRepartidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(179, 179, 179)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAsignarPedido)
                    .addComponent(btnRegresar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarPedidoActionPerformed
        // TODO add your handling code here:
        String idRepartidor = idRepartidores.get(this.cmbRepartidores.getSelectedIndex());
        JOptionPane.showMessageDialog(rootPane, "El pedido fue asignado a "+cmbRepartidores.getSelectedItem().toString(), "Pedido asignado", JOptionPane.INFORMATION_MESSAGE);
        control.asignarPedidoRepartidor(pedidoSeleccionado.getFolio(), this.cmbRepartidores.getSelectedItem().toString(), idRepartidor);
        this.dispose();
        control.iniciarFrmPedidosAsignar();
    }//GEN-LAST:event_btnAsignarPedidoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        control.regresar();
        control.iniciarFrmPedidosAsignar();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarPedido;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbRepartidores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtPedidoSeleccionado;
    // End of variables declaration//GEN-END:variables
}
