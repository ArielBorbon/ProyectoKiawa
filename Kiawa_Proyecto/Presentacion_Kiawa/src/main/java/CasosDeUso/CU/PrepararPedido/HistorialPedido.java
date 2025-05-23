/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CasosDeUso.CU.PrepararPedido;

import CasosDeUso.CU.Equipo.*;
import CasosDeUso.CU.PrepararPedido.DetallesPedidosHistorial;
import Control.ControlAlumno;
import Control.ControlCocinero;
import Subsistema.FSubsistema_Pedidos;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import dto.UbicacionDTO;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freddy
 */
public class HistorialPedido extends javax.swing.JFrame {

    public HistorialPedido() throws Exception {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0xffff90));
        cargarPedidos();
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }

    private void cargarPedidos() {
        try {
            FSubsistema_Pedidos subsistema = new FSubsistema_Pedidos();
            List<PedidoDTO> historial = subsistema.recuperarPedidos();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Folio");
            modelo.addColumn("Fecha");
            modelo.addColumn("Estado");
            modelo.addColumn("Total");

            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            for (PedidoDTO p : historial) {
                modelo.addRow(new Object[]{
                    p.getFolio(),
                    fmt.format(p.getFechaPedido()),
                    p.getEstado(),
                    p.getTotal()
                });
            }

            tblHistorialPedidos.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar historial: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorialPedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnVerPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblHistorialPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Folio", "Fecha", "Estado", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHistorialPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHistorialPedidos);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("Historial de Pedidos");

        btnRegresar.setBackground(new java.awt.Color(255, 102, 102));
        btnRegresar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnVerPedido.setBackground(new java.awt.Color(153, 255, 153));
        btnVerPedido.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnVerPedido.setText("Ver Pedido");
        btnVerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnVerPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVerPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        ControlCocinero.getInstancia().mostrarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnVerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidoActionPerformed
        int fila = tblHistorialPedidos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un pedido.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String folio = tblHistorialPedidos.getValueAt(fila, 0).toString();
            List<PedidoDTO> historial = new FSubsistema_Pedidos().recuperarPedidos();
            for (PedidoDTO pedido : historial) {
                if (pedido.getFolio().equals(folio)) {
                    ControlCocinero.getInstancia().setPedidoActual(pedido);
                    this.dispose();
                    new DetallesPedidosHistorial().setVisible(true);
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "No se encontró el pedido seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir el pedido: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistorialPedidos;
    // End of variables declaration//GEN-END:variables
}
