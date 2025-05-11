/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.PlatilloDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class SeleccionarPlatillos extends javax.swing.JFrame {

    private final ControlOrdenarPlatillo controlOrdenarPlatillo;
    private List<PlatilloDTO> listaPlatillosSeleccionados;
    private List<PlatilloDTO> listaPlatillos;
    
    
    /**
     * Creates new form SeleccionarPlatillos
     */
    public SeleccionarPlatillos(ControlOrdenarPlatillo controlOrdenarPlatillo) {
        initComponents();
        this.controlOrdenarPlatillo = controlOrdenarPlatillo;
        this.listaPlatillosSeleccionados = new ArrayList<>();
        this.listaPlatillos = controlOrdenarPlatillo.consultarPlatillos();
        this.lblUsuario.setText("Bienvenid@ " + controlOrdenarPlatillo.obtenerAlumnoActual().getNombre());
        this.llenarTablaPlatillos();
        this.seleccionarPlatillos();
    }
    
    /*Se utiliza para obtener los platillos seleccionados y poder usarla en otros form a traves de control*/
    public List<PlatilloDTO> getListaPlatillosSeleccionados() {
        return listaPlatillosSeleccionados;
    }
    
    
    private void llenarCarritoCompra(){
        this.txtCarrito.setText(this.controlOrdenarPlatillo.escribirCarritoCompra(this.listaPlatillosSeleccionados));
    }
    
    private void llenarTablaPlatillos(){

        DefaultTableModel modelo = (DefaultTableModel)this.tblPlatillos.getModel();
        modelo.setRowCount(0);
        for(PlatilloDTO platillo : this.listaPlatillos){
            Object[] filaTabla = {
                platillo.getId(),
                platillo.getPlatillo(),
                platillo.getPrecio(),
                platillo.getExistencias()
            };
            
            modelo.addRow(filaTabla);
        }
        
    }

    private void calcularTotal(){
        
        Double sumaPrecio=0.0;
        
        for(PlatilloDTO platillo : this.listaPlatillosSeleccionados){
            sumaPrecio += platillo.getPrecio()*platillo.getCantidad();
        }
        
        this.txtTotal.setText(String.valueOf(sumaPrecio));
    }
    
    private void seleccionarPlatillos(){
         /*Listener para cuando seleccionamos un platillo*/
        this.tblPlatillos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = this.tblPlatillos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    /*Se recuperan los valores de los campos de la tabla*/
                    int id = Integer.parseInt(this.tblPlatillos.getValueAt(filaSeleccionada, 0).toString());

                    String nombrePlatillo = this.tblPlatillos.getValueAt(filaSeleccionada, 1).toString();
                    Double precio = Double.valueOf(this.tblPlatillos.getValueAt(filaSeleccionada, 2).toString());
                    Integer existencias = Integer.valueOf(this.tblPlatillos.getValueAt(filaSeleccionada, 3).toString());
                    
                    /*Por simplicidad se pedira la cantidad de un producto que selecciones con un InputDialog*/
                    String cantidadString = JOptionPane.showInputDialog(this, "Ingrese la cantidad de " + nombrePlatillo + ":", "Cantidad", JOptionPane.QUESTION_MESSAGE);

                    if (cantidadString != null && !cantidadString.trim().isEmpty()) {
                        int cantidad = Integer.parseInt(cantidadString);
                        /*Validacion para que no ingresen una cantidad mayor a las existencias o negativos*/
                        try{
                            if (cantidad > 0 && cantidad <= existencias) {
                                this.listaPlatillosSeleccionados.add(new PlatilloDTO(id,nombrePlatillo, precio, existencias, cantidad));
                                this.calcularTotal();
                                
                                
                                //Sout para ver si efectivamente selecciona platillos
                                System.out.println("Platillos seleccionados:");
                                listaPlatillosSeleccionados.forEach(p -> {
                                    System.out.println(p.getCantidad()+" "+p.getPlatillo());
                                });
                                
                            this.llenarCarritoCompra();
                            
                            /*Cantidad invalida*/
                            } else {
                                JOptionPane.showMessageDialog(this, "Cantidad inválida o mayor a las existencias.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException ex){
                            System.out.println(ex.getMessage());
                        }
                        
                    }
                }
            }
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlatillos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnSalirPlatillos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCarrito = new javax.swing.JTextPane();
        lblUsuario = new javax.swing.JLabel();
        btnQuitarPlatillo = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Platillo", "Precio", "Existencias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlatillos.setToolTipText("");
        tblPlatillos.setCellSelectionEnabled(true);
        tblPlatillos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblPlatillos.setShowGrid(false);
        jScrollPane1.setViewportView(tblPlatillos);
        tblPlatillos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("SELECCIONAR PLATILLOS");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnSalirPlatillos.setText("Salir");
        btnSalirPlatillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPlatillosActionPerformed(evt);
            }
        });

        jLabel2.setText("Carrito de compras");

        txtCarrito.setEditable(false);
        jScrollPane2.setViewportView(txtCarrito);

        lblUsuario.setText("Bienvenido");

        btnQuitarPlatillo.setText("Quitar Platillo");
        btnQuitarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarPlatilloActionPerformed(evt);
            }
        });

        lblTotal.setText("Total");

        txtTotal.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblUsuario)
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalirPlatillos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnQuitarPlatillo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSeleccionar)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalirPlatillos)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnQuitarPlatillo))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        if (listaPlatillosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún platillo.", "Error", JOptionPane.WARNING_MESSAGE);  
        }else{
            controlOrdenarPlatillo.iniciarFrmSeleccionarUbicacion();
            dispose();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnSalirPlatillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPlatillosActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirPlatillosActionPerformed

    private void btnQuitarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarPlatilloActionPerformed
        // TODO add your handling code here:
        String platilloAEliminar = JOptionPane.showInputDialog(this,"Ingrese el id del platillo a quitar:", "Quitar platillo", JOptionPane.QUESTION_MESSAGE);
    
        if (platilloAEliminar != null && !platilloAEliminar.trim().isEmpty()) {
            Optional<PlatilloDTO> platilloEncontrado = listaPlatillosSeleccionados.stream()
                .filter(p -> Integer.parseInt(platilloAEliminar) == p.getId())  // Convertir platilloAEliminar a int
                .findFirst();


            if (platilloEncontrado.isPresent()) {
                PlatilloDTO platillo = platilloEncontrado.get();

                String cantidadEliminarString = JOptionPane.showInputDialog(this, "Ingrese la cantidad a quitar de " + platilloEncontrado.get().getPlatillo() + " (Máx: " + platillo.getCantidad() + "):", "Cantidad a quitar", JOptionPane.QUESTION_MESSAGE);

                if (cantidadEliminarString != null && !cantidadEliminarString.trim().isEmpty()) {
                    int cantidadAQuitar;

                    try {
                        cantidadAQuitar = Integer.parseInt(cantidadEliminarString);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (cantidadAQuitar > 0 && cantidadAQuitar <= platillo.getCantidad()) {
                        platillo.setCantidad(platillo.getCantidad() - cantidadAQuitar);
                        this.calcularTotal();

                        // Si la cantidad llega a 0, eliminar el platillo de la lista
                        if (platillo.getCantidad() == 0) {
                            listaPlatillosSeleccionados.remove(platillo);
                            JOptionPane.showMessageDialog(this, "Se ha eliminado completamente el platillo del carrito.", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Se ha reducido la cantidad del platillo.", "Actualizado", JOptionPane.INFORMATION_MESSAGE);
                        }

                        llenarCarritoCompra(); // Actualizar el carrito
                    } else {
                        JOptionPane.showMessageDialog(this, "Cantidad inválida. Debe ser un número entre 1 y " + platillo.getCantidad() + ".", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "El platillo no está en el carrito.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnQuitarPlatilloActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuitarPlatillo;
    private javax.swing.JButton btnSalirPlatillos;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblPlatillos;
    private javax.swing.JTextPane txtCarrito;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
