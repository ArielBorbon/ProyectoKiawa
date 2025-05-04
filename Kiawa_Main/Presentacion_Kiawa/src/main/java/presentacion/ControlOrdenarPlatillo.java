package presentacion;

import AdministradorPedido.AdministradorPedido;
import AdministradorPlatillos.AdministradorPlatillos;
import AdministradorUbicaciones.AdministradorUbicaciones;
import dto.AlumnoDTO;
import dto.PedidoDTO;
import dto.PlatilloDTO;
import dto.UbicacionDTO;
import java.util.ArrayList;
import java.util.List;
import negocio_administradoralumnos.AdministradorAlumnos;



/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class ControlOrdenarPlatillo {
    private ConfirmarPedido frmConfirmarPedido;
    private MedioPago frmMedioPago;
    private MensajePedidoExitoso frmMensajePedidoExitoso;
    private MensajePedidoFallido frmMensajePedidoFallido;
    private SeleccionarPlatillos frmSeleccionarPlatillos;
    private SeleccionarUbicacion frmSeleccionarUbicacion;
    

    
    
    public ControlOrdenarPlatillo() {
    }

    
    public void iniciarCasoUsoPedido(){
        this.frmSeleccionarPlatillos = new SeleccionarPlatillos(this);
        this.frmSeleccionarPlatillos.setVisible(true);
        this.frmSeleccionarPlatillos.setLocationRelativeTo(null);
    }
    
    public void iniciarFrmSeleccionarUbicacion(){
        this.frmSeleccionarUbicacion = new SeleccionarUbicacion(this);
        this.frmSeleccionarUbicacion.setVisible(true);
        this.frmSeleccionarUbicacion.setLocationRelativeTo(null);
    }
    
    public void iniciarFrmConfirmarPedido(){
        this.frmConfirmarPedido = new ConfirmarPedido(this);
        this.frmConfirmarPedido.setVisible(true);
        this.frmConfirmarPedido.setLocationRelativeTo(null);
    }
    
    public void iniciarFrmMedioPago(){
        this.frmMedioPago = new MedioPago(this);
        this.frmMedioPago.setVisible(true);
        this.frmMedioPago.setLocationRelativeTo(null);
    }
    
    public void iniciarFrmMensajePedidoExitoso(){
        this.frmMensajePedidoExitoso = new MensajePedidoExitoso(this);
        this.frmMensajePedidoExitoso.setVisible(true);
        this.frmMensajePedidoExitoso.setLocationRelativeTo(null);
    
    }
    
    public void iniciarFrmMensajePedidoFallido(){
        this.frmMensajePedidoFallido = new MensajePedidoFallido(this);
        this.frmMensajePedidoFallido.setVisible(true);
        this.frmMensajePedidoFallido.setLocationRelativeTo(null);
    }
    
    /*Este metodo recupera los platillos desde administrador de platillos simulando una base de datos*/
    public List<PlatilloDTO> consultarPlatillos(){
        return AdministradorPlatillos.getInstance().consultarPlatillos();
    }
    
    /*Este metodo recupera las ubicaciones desde administrador de ubicaciones simulando una base de datos*/
    public List<UbicacionDTO> consultarUbicaciones(){
        return AdministradorUbicaciones.getInstance().consultarUbicaciones();
    }
    
    /*En este metodo se construye el pedido con una lista de platillosSeleccionados y una lista de ubicacion con edificio, aula, etc*/
    public List<PedidoDTO> consultarPedidos(){
        PedidoDTO pedidoNuevo = new PedidoDTO(
            this.recuperarPlatillosSeleccionados(),
            this.recuperarUbicacionSeleccionada()
        );
        
        List<PedidoDTO> listaPedido = new ArrayList<>();
        listaPedido.add(pedidoNuevo);
        
        return AdministradorPedido.getInstance().consultarPedidos(listaPedido);
    }
    
    /*Este metodo recibe una lista de platilloDTO y con el stringBuilder se juntan la cantidad y el platillo dejando un 
    salto de linea entre ellos, escribe el carrito de compra falta agregarle los precios*/
    public String escribirCarritoCompra(List<PlatilloDTO> listaPlatillosSeleccionados){
        StringBuilder contenidoCarrito = new StringBuilder();
        for (PlatilloDTO p : listaPlatillosSeleccionados) {
            contenidoCarrito.append(p.getCantidad()).append(" ").append(p.getPlatillo()).append("\n");
        }
        return contenidoCarrito.toString();
    }
    
    /*Este metodo se trae del form una lista sacada de la JTable con los platillos que se seleccionaron*/
    public List<PlatilloDTO> recuperarPlatillosSeleccionados(){
        return this.frmSeleccionarPlatillos.getListaPlatillosSeleccionados();
    }
    
    /*Este metodo se trae del form una lista sacada de la JTable con los platillos que se seleccionaron*/
    public UbicacionDTO recuperarUbicacionSeleccionada(){
        return this.frmSeleccionarUbicacion.getUbicacionSeleccionada();
    }
    
    
    /*Este metodo obtiene el alumno actual que tiene la sesion iniciada (Si quieres cambiar de alumno cambia la instancia en administradorAlumnos)*/
    public AlumnoDTO obtenerAlumnoActual(){
        return AdministradorAlumnos.getInstance().usuarioActual();
    }
    
    /*Este metodo lo que hace es actualizar las existencias de los platillos seleccionados cuando se confirma el pago*/
    public void actualizarExistencias(PlatilloDTO platilloActualizar){
        AdministradorPlatillos.getInstance().ActualizarExistencias(platilloActualizar.getPlatillo(),platilloActualizar.getCantidad());
    }
    
    
    public Double calcularTotalPedido(List<PedidoDTO> listaPedido){
        Double sumaPrecio=0.0;
        
        for(PedidoDTO pedido : listaPedido){
            for(PlatilloDTO platillo : pedido.getPlatillos()){
                sumaPrecio += platillo.getPrecio()*platillo.getCantidad();
            }
        }
        
        return sumaPrecio;
    }
    
    /*Guarda el medio de pago actual*/
    public String medioPagoSeleccionado(){
        return this.frmConfirmarPedido.getMedioPagoSeleccionado();
    }
    
}
