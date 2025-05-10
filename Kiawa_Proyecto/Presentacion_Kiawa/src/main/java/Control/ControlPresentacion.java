package control;

import dto.DetallePedidoDTO;
import java.util.ArrayList;
import java.util.List;

public class ControlPresentacion {

    private static ControlPresentacion instancia;
    private List<DetallePedidoDTO> detallesSeleccionados;
    private Double total;

    private ControlPresentacion() {
        detallesSeleccionados = new ArrayList<>();
    }

    public static ControlPresentacion getInstancia() {
        if (instancia == null) {
            instancia = new ControlPresentacion();
        }
        return instancia;
    }

    public List<DetallePedidoDTO> getDetallesSeleccionados() {
        return detallesSeleccionados;
    }

    public void agregarDetalle(DetallePedidoDTO detalle) {
        detallesSeleccionados.add(detalle);
    }

    public void eliminarDetalle(DetallePedidoDTO detalle) {
        detallesSeleccionados.remove(detalle);
    }

    public void limpiarDetalles() {
        detallesSeleccionados.clear();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
    
}
