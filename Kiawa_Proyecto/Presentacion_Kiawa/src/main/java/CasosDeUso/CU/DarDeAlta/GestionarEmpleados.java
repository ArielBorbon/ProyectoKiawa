/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CasosDeUso.CU.DarDeAlta;

import Subsistema.FSubsistema_Cocinero;
import Subsistema.FSubsistema_Repartidor;
import dto.CocineroDTO;
import dto.RepartidorDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC Gamer
 */
public class GestionarEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form GestionarEmpleados
     */
    public GestionarEmpleados() {
        initComponents();
        cmbFiltrar.setSelectedItem("NINGUNO");
        llenarTablaConEmpleados("NINGUNO");
        agregarMouseListenerTabla();
    }

    private void agregarMouseListenerTabla() {
        tblEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    int viewRow = tblEmpleados.rowAtPoint(e.getPoint());
                    if (viewRow < 0) {
                        return;
                    }
                    // convert to model index if usas sorting/filtering
                    int modelRow = tblEmpleados.convertRowIndexToModel(viewRow);
                    DefaultTableModel m = (DefaultTableModel) tblEmpleados.getModel();
                    String rol = (String) m.getValueAt(modelRow, 11);
                    String idFriendly = (String) m.getValueAt(modelRow, 10);
                    String nombre = (String) m.getValueAt(modelRow, 0);
                    String curp = (String) m.getValueAt(modelRow, 1);
                    double salario = (Double) m.getValueAt(modelRow, 2);
                    String telefono = (String) m.getValueAt(modelRow, 3);
                    String apodo = (String) m.getValueAt(modelRow, 4);
                    String domicilio = (String) m.getValueAt(modelRow, 5);
                    String horario = (String) m.getValueAt(modelRow, 6);
                    String diasTrabajo = (String) m.getValueAt(modelRow, 7);
                    String extras = (String) m.getValueAt(modelRow, 8);
                    Boolean disponible = (Boolean) m.getValueAt(modelRow, 9);

                    if ("REPARTIDOR".equalsIgnoreCase(rol)) {
                        RepartidorDTO dto = new RepartidorDTO();
                        dto.setIdRepartidor(idFriendly);
                        dto.setNombreCompleto(nombre);
                        dto.setCurp(curp);
                        dto.setSalarioDiario(salario);
                        dto.setTelefono(telefono);
                        dto.setApodo(apodo);
                        dto.setDomicilio(domicilio);
                        dto.setHorario(horario);
                        dto.setDiasTrabajo(diasTrabajo);
                        dto.setConsideracionesExtras(extras);
                        dto.setDisponible(disponible);
                        ControlAdministrador.getInstancia().setEmpleadoSeleccionado(dto);
                    } else {
                        CocineroDTO dto = new CocineroDTO();
                        dto.setIdCocinero(idFriendly);
                        dto.setNombreCompleto(nombre);
                        dto.setCurp(curp);
                        dto.setSalarioDiario(salario);
                        dto.setTelefono(telefono);
                        dto.setApodo(apodo);
                        dto.setDomicilio(domicilio);
                        dto.setHorario(horario);
                        dto.setDiasTrabajo(diasTrabajo);
                        dto.setConsideracionesExtras(extras);
                        dto.setDisponible(disponible);
                        ControlAdministrador.getInstancia().setEmpleadoSeleccionado(dto);
                    }

                    // Abrimos el frame de edición
                    EditarEmpleado editar = new EditarEmpleado();
                    editar.acomodarCampos(); // método que lee de ControlAdministrador
                    editar.setVisible(true);
                    GestionarEmpleados.this.dispose();
                }
            }
        });}
    
    
        
        

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnHabilitarEmpleado = new javax.swing.JButton();
        btnDeshabilitarEmpleado = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbFiltrar = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("Gestion Empleados");

        btnHabilitarEmpleado.setBackground(new java.awt.Color(153, 255, 153));
        btnHabilitarEmpleado.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnHabilitarEmpleado.setText("Habilitar Empleado");
        btnHabilitarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarEmpleadoActionPerformed(evt);
            }
        });

        btnDeshabilitarEmpleado.setBackground(new java.awt.Color(255, 102, 102));
        btnDeshabilitarEmpleado.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnDeshabilitarEmpleado.setText("Deshabilitar Empleado");
        btnDeshabilitarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarEmpleadoActionPerformed(evt);
            }
        });

        btnFiltrar.setBackground(new java.awt.Color(255, 255, 153));
        btnFiltrar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setText("Opciones:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setText("ROL:");

        cmbFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO", "REPARTIDOR", "COCINERO" }));

        btnRegresar.setBackground(new java.awt.Color(255, 51, 51));
        btnRegresar.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel4.setText("Doble Click para Abrir Edicion de empleados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnDeshabilitarEmpleado)
                            .addComponent(btnHabilitarEmpleado)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(cmbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFiltrar)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnHabilitarEmpleado)
                .addGap(18, 18, 18)
                .addComponent(btnDeshabilitarEmpleado)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String rolSeleccionado = (String) cmbFiltrar.getSelectedItem();
        llenarTablaConEmpleados(rolSeleccionado);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnHabilitarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarEmpleadoActionPerformed
        int fila = tblEmpleados.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona primero un empleado");
            return;
        }

        String idFriendly = tblEmpleados.getModel().getValueAt(fila, 10).toString();
        String rol = tblEmpleados.getModel().getValueAt(fila, 11).toString();

        try {
            boolean ok;
            if ("REPARTIDOR".equalsIgnoreCase(rol)) {
                FSubsistema_Repartidor subsR = new FSubsistema_Repartidor();
                ok = subsR.habilitarRepartidor(idFriendly);
            } else {
                FSubsistema_Cocinero subsC = new FSubsistema_Cocinero();
                ok = subsC.habilitarCocinero(idFriendly);
            }

            if (ok) {
                JOptionPane.showMessageDialog(this, rol + " habilitado exitosamente.");
                llenarTablaConEmpleados(cmbFiltrar.getSelectedItem().toString());
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo habilitar al " + rol);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnHabilitarEmpleadoActionPerformed

    private void btnDeshabilitarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarEmpleadoActionPerformed
        int fila = tblEmpleados.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona primero un empleado");
            return;
        }

        // Obtenemos del modelo el idFriendly y el rol; 
        // suponiendo que están en las columnas 10 y 11 (índices base 0)
        String idFriendly = tblEmpleados.getModel().getValueAt(fila, 10).toString();
        String rol = tblEmpleados.getModel().getValueAt(fila, 11).toString();

        try {
            boolean ok;
            if ("REPARTIDOR".equalsIgnoreCase(rol)) {
                FSubsistema_Repartidor subsR = new FSubsistema_Repartidor();
                ok = subsR.deshabilitarRepartidor(idFriendly);
            } else {
                FSubsistema_Cocinero subsC = new FSubsistema_Cocinero();
                ok = subsC.deshabilitarCocinero(idFriendly);
            }

            if (ok) {
                JOptionPane.showMessageDialog(this, rol + " deshabilitado exitosamente.");
                llenarTablaConEmpleados(cmbFiltrar.getSelectedItem().toString());
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo deshabilitar al " + rol);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnDeshabilitarEmpleadoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
              this.dispose();
        ControlAdministrador.getInstancia().regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void llenarTablaConEmpleados(String rolFiltro) {
        NonEditableTableModel m = new NonEditableTableModel();
        m.setColumnIdentifiers(new String[]{
            "Nombre", "CURP", "Salario", "Teléfono", "Apodo", "Domicilio",
            "Horario", "Días Trabajo", "Extras", "Disponible",
            "_idFriendly", "_rol"
        });

        FSubsistema_Repartidor subsR = new FSubsistema_Repartidor();
        FSubsistema_Cocinero subsC = new FSubsistema_Cocinero();

        if ("NINGUNO".equalsIgnoreCase(rolFiltro) || rolFiltro.isBlank()) {
            subsR.obtenerTodosLosRepartidores().forEach(rep
                    -> m.addRow(new Object[]{
                rep.getNombreCompleto(), rep.getCurp(), rep.getSalarioDiario(), rep.getTelefono(),
                rep.getApodo(), rep.getDomicilio(), rep.getHorario(), rep.getDiasTrabajo(),
                rep.getConsideracionesExtras(), rep.getDisponible(),
                rep.getIdRepartidor(), "REPARTIDOR"
            })
            );
            subsC.obtenerTodosLosCocineros().forEach(coc
                    -> m.addRow(new Object[]{
                coc.getNombreCompleto(), coc.getCurp(), coc.getSalarioDiario(), coc.getTelefono(),
                coc.getApodo(), coc.getDomicilio(), coc.getHorario(), coc.getDiasTrabajo(),
                coc.getConsideracionesExtras(), coc.getDisponible(),
                coc.getIdCocinero(), "COCINERO"
            })
            );

        } else if ("REPARTIDOR".equalsIgnoreCase(rolFiltro)) {
            subsR.obtenerTodosLosRepartidores().forEach(rep
                    -> m.addRow(new Object[]{
                rep.getNombreCompleto(), rep.getCurp(), rep.getSalarioDiario(), rep.getTelefono(),
                rep.getApodo(), rep.getDomicilio(), rep.getHorario(), rep.getDiasTrabajo(),
                rep.getConsideracionesExtras(), rep.getDisponible(),
                rep.getIdRepartidor(), "REPARTIDOR"
            })
            );
        } else {
            subsC.obtenerTodosLosCocineros().forEach(coc
                    -> m.addRow(new Object[]{
                coc.getNombreCompleto(), coc.getCurp(), coc.getSalarioDiario(), coc.getTelefono(),
                coc.getApodo(), coc.getDomicilio(), coc.getHorario(), coc.getDiasTrabajo(),
                coc.getConsideracionesExtras(), coc.getDisponible(),
                coc.getIdCocinero(), "COCINERO"
            })
            );
        }

        tblEmpleados.setModel(m);
        tblEmpleados.removeColumn(tblEmpleados.getColumnModel().getColumn(11));

    }

    class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshabilitarEmpleado;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnHabilitarEmpleado;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbFiltrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    // End of variables declaration//GEN-END:variables
}
