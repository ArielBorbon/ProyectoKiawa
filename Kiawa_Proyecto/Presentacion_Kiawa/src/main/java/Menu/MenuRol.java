/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menu;

import BO.LlenarBaseDeDatos;
import CasosDeUso.CU.DarDeAlta.ControlAdministrador;
import Control.ControlAlumno;
import Control.ControlRepartidor;
import Subsistema.FSubsistema_Cocinero;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rayoa
 */
public class MenuRol extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuRol() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0xc4c4c4));
        FSubsistema_Cocinero subCocinero = new FSubsistema_Cocinero();

        try {
            LlenarBaseDeDatos.rellenarBD();
        } catch (Exception ex) {

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

        jLabel5 = new javax.swing.JLabel();
        btnEstudiante = new javax.swing.JButton();
        btnCocinero = new javax.swing.JButton();
        btnRepartidor = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 3, 24)); // NOI18N
        jLabel5.setText("Selecciona Tu Rol");

        btnEstudiante.setBackground(new java.awt.Color(255, 255, 204));
        btnEstudiante.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        btnEstudiante.setText("Estudiante");
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });

        btnCocinero.setBackground(new java.awt.Color(204, 255, 204));
        btnCocinero.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnCocinero.setText("Cocinero");
        btnCocinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocineroActionPerformed(evt);
            }
        });

        btnRepartidor.setBackground(new java.awt.Color(153, 255, 255));
        btnRepartidor.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnRepartidor.setText("Repartidor");
        btnRepartidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepartidorActionPerformed(evt);
            }
        });

        btnAdministrador.setBackground(new java.awt.Color(0, 0, 0));
        btnAdministrador.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministrador.setText("Adminstrador");
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("French Script MT", 3, 72)); // NOI18N
        jLabel1.setText("Kiawa Systems");

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCocinero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRepartidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdministrador)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEstudiante)
                    .addComponent(btnCocinero)
                    .addComponent(btnRepartidor)
                    .addComponent(btnAdministrador))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        this.dispose();
        ControlAdministrador.getInstancia().iniciarFlujo();

    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed

        ControlAlumno.getInstancia().iniciarFlujo();
        this.dispose();
    }//GEN-LAST:event_btnEstudianteActionPerformed

    private void btnCocineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCocineroActionPerformed
        this.dispose();
        new Logins.LoginCocinero().setVisible(true);
    }//GEN-LAST:event_btnCocineroActionPerformed

    private void btnRepartidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepartidorActionPerformed

        ControlRepartidor.getInstancia().iniciarFlujo();
        this.dispose();
    }//GEN-LAST:event_btnRepartidorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnCocinero;
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnRepartidor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
