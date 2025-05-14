/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Buscadores;

import Subsistema.FSubsistema_Platillos;
import dto.DetallePedidoDTO;
import dto.PlatilloDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC Gamer
 */
public class BuscadorPlatillos extends javax.swing.JPanel {

    private Runnable onPlatilloAgregado;
    private Consumer<PlatilloDTO> onPlatilloDoubleClick;

    public void setOnPlatilloDoubleClick(Consumer<PlatilloDTO> callback) {
        this.onPlatilloDoubleClick = callback;
    }

    private void initDoubleClickListener() {
        tblPlatillos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila = tblPlatillos.rowAtPoint(e.getPoint());
                    if (fila < 0) {
                        return;
                    }

                    // Extraigo datos de la fila:
                    String nombre = tblPlatillos.getValueAt(fila, 0).toString();
                    double precio = Double.parseDouble(tblPlatillos.getValueAt(fila, 1).toString());
                    int existencias = Integer.parseInt(tblPlatillos.getValueAt(fila, 3).toString());

                    // Creo el DTO mínimo:
                    PlatilloDTO dto = new PlatilloDTO();
                    dto.setNombre(nombre);
                    dto.setPrecio(precio);
                    dto.setExistencias(existencias);

                    // Llamo al callback si existe
                    if (onPlatilloDoubleClick != null) {
                        onPlatilloDoubleClick.accept(dto);
                    }
                }
            }
        });
    }

    /**
     * Creates new form BuscadorPlatillos
     */
    public BuscadorPlatillos() {
        initComponents();
        llenarTablaPlatillos();
        initDoubleClickListener();

        this.cmbDisponible.setEnabled(false);

    }

    public void setOnPlatilloAgregado(Runnable callback) {
        this.onPlatilloAgregado = callback;
    }

    public JComboBox<String> getCmbDisponible() {
        return cmbDisponible;
    }

    public void setCmbDisponible(JComboBox<String> cmbDisponible) {
        this.cmbDisponible = cmbDisponible;
    }

    public JLabel getLblDisponible() {
        return lblDisponible;
    }

    public void setLblDisponible(JLabel lblDisponible) {
        this.lblDisponible = lblDisponible;
    }

    private void llenarTablaPlatillos() {
        try {
            String nombre = txtNombreFiltro.getText().trim();
            String categoria = cmbCategoriasFiltro.getSelectedItem().toString();
            String disponible = cmbDisponible.getSelectedItem().toString();

            if (categoria.equalsIgnoreCase("Todos")) {
                categoria = null;
            }

            Boolean estaDisponible = null;
            if (disponible.equalsIgnoreCase("Sí")) {
                estaDisponible = true;                                                  //pendiente
            } else if (disponible.equalsIgnoreCase("No")) {
                estaDisponible = false;
            }

            if (nombre.isEmpty()) {
                nombre = null;
            }
            FSubsistema_Platillos subsistemaP = new FSubsistema_Platillos();
            List<PlatilloDTO> platillos;

            if (nombre == null && categoria == null) {
                platillos = subsistemaP.obtenerPlatillosDisponibles();
            } else if (nombre == null) {
                platillos = subsistemaP.buscarPorCategoria(categoria);
            } else if (categoria == null) {
                platillos = subsistemaP.buscarPorNombre(nombre);
            } else {
                platillos = subsistemaP.buscarPorCategoriaYNombre(categoria, nombre);
            }

            NonEditableTableModel modelo = new NonEditableTableModel();
            tblPlatillos.setModel(modelo);
            modelo.setRowCount(0);
            modelo.setColumnCount(0);
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Descripción");
            modelo.addColumn("Existencias");
            modelo.addColumn("Categoria");

            for (PlatilloDTO p : platillos) {
                modelo.addRow(new Object[]{
                    p.getNombre(),
                    p.getPrecio(),
                    p.getDescripcion(),
                    p.getExistencias(),
                    p.getCategoria()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar la tabla de platillos: " + e.getMessage());
        }
    }

    class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void agregarListenerDobleClick() {
        tblPlatillos.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                if (e.getClickCount() == 2) {
                    int fila = tblPlatillos.getSelectedRow();
                    if (fila >= 0) {
                        String nombre = tblPlatillos.getValueAt(fila, 0).toString();
                        double precio = Double.parseDouble(tblPlatillos.getValueAt(fila, 1).toString());
                        int existencias = Integer.parseInt(tblPlatillos.getValueAt(fila, 3).toString());

                        String input = JOptionPane.showInputDialog(BuscadorPlatillos.this, "¿Cuántas unidades deseas?");
                        if (input != null) {
                            try {
                                int cantidad = Integer.parseInt(input);
                                if (cantidad > 0 && cantidad <= existencias) {

                                    DetallePedidoDTO detalle = new DetallePedidoDTO(nombre, cantidad, precio, "", precio * cantidad);
                                    control.ControlPresentacion.getInstancia().agregarDetalle(detalle);
                                    JOptionPane.showMessageDialog(BuscadorPlatillos.this, "Platillo agregado.");
                                    if (onPlatilloAgregado != null) {
                                        onPlatilloAgregado.run();
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(BuscadorPlatillos.this, "Cantidad no válida (mayor a existencias o negativa).");
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(BuscadorPlatillos.this, "Debes ingresar un número válido.");
                            }
                        }
                    }
                }
            }
        }
        );

    }

    ;
    
    
    public void llenarTablaPlatillosExterno(){
        llenarTablaPlatillos();
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
        tblPlatillos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbCategoriasFiltro = new javax.swing.JComboBox<>();
        txtNombreFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        lblDisponible = new javax.swing.JLabel();
        cmbDisponible = new javax.swing.JComboBox<>();

        tblPlatillos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPlatillos);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        cmbCategoriasFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCategoriasFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ENTRADA", "PLATO_FUERTE", "POSTRE", "SNACK", "BEBIDA" }));
        cmbCategoriasFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriasFiltroActionPerformed(evt);
            }
        });

        txtNombreFiltro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombreFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreFiltroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("Categorias");

        btnFiltrar.setBackground(new java.awt.Color(199, 184, 148));
        btnFiltrar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        lblDisponible.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblDisponible.setText("Disponible");

        cmbDisponible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Si", "No" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCategoriasFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDisponible)
                    .addComponent(cmbDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(lblDisponible))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCategoriasFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriasFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriasFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriasFiltroActionPerformed

    private void txtNombreFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFiltroActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        llenarTablaPlatillos();
    }//GEN-LAST:event_btnFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cmbCategoriasFiltro;
    private javax.swing.JComboBox<String> cmbDisponible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDisponible;
    private javax.swing.JTable tblPlatillos;
    private javax.swing.JTextField txtNombreFiltro;
    // End of variables declaration//GEN-END:variables
}
