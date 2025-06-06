/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CasosDeUso.CU.EntregarPedido;

import Control.ControlRepartidor;
import dto.PedidoDTO;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Alberto Jimenez
 */
public class ConfirmarEntrega extends javax.swing.JFrame {
    
    private double totalPedido;
    /**
     * Creates new form ConfirmarEntrega
     */
    public ConfirmarEntrega() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x22EEE5));
        cargarDatos();
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
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnConfirmarPago = new javax.swing.JButton();
        btnNegarPago = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        btnCalculaCambio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confirmación pago");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmar Pago");

        txtTotal.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total a Pagar = $");
        jLabel8.setPreferredSize(new java.awt.Dimension(42, 16));

        btnConfirmarPago.setBackground(new java.awt.Color(153, 255, 153));
        btnConfirmarPago.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnConfirmarPago.setText("Confirmar Pago");

        btnNegarPago.setBackground(new java.awt.Color(255, 153, 153));
        btnNegarPago.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnNegarPago.setText("Negar Pago");
        btnNegarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegarPagoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText(" Efectivo = $");
        jLabel9.setPreferredSize(new java.awt.Dimension(42, 16));

        txtEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText(" Cambio = $");
        jLabel10.setPreferredSize(new java.awt.Dimension(42, 16));

        txtCambio.setEditable(false);

        btnCalculaCambio.setBackground(new java.awt.Color(255, 153, 102));
        btnCalculaCambio.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnCalculaCambio.setText("Calcular cambio");
        btnCalculaCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculaCambioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmarPago)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnNegarPago))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnCalculaCambio)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEfectivo)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalculaCambio)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarPago)
                .addGap(18, 18, 18)
                .addComponent(btnNegarPago)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNegarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNegarPagoActionPerformed

    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void btnCalculaCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculaCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalculaCambioActionPerformed

    public void setDatosPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }
    
    private void cargarDatos() {
        PedidoDTO pedido = ControlRepartidor.getInstancia().getPedidoSeleccionado();

        if (pedido != null) {
            txtTotal.setText(String.format("%.2f", pedido.getTotal()));
        }
    }

    public JButton getBtnConfirmarPago() {
        return btnConfirmarPago;
    }

    public void setBtnConfirmarPago(JButton btnConfirmarPago) {
        this.btnConfirmarPago = btnConfirmarPago;
    }

    public JButton getBtnNegarPago() {
        return btnNegarPago;
    }

    public void setBtnNegarPago(JButton btnNegarPago) {
        this.btnNegarPago = btnNegarPago;
    }

    public JButton getBtnCalculaCambio() {
        return btnCalculaCambio;
    }

    public void setBtnCalculaCambio(JButton btnCalculaCambio) {
        this.btnCalculaCambio = btnCalculaCambio;
    }

    public JTextField getTxtCambio() {
        return txtCambio;
    }

    public void setTxtCambio(JTextField txtCambio) {
        this.txtCambio = txtCambio;
    }

    public JTextField getTxtEfectivo() {
        return txtEfectivo;
    }

    public void setTxtEfectivo(JTextField txtEfectivo) {
        this.txtEfectivo = txtEfectivo;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(JTextField txtTotal) {
        this.txtTotal = txtTotal;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculaCambio;
    private javax.swing.JButton btnConfirmarPago;
    private javax.swing.JButton btnNegarPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
