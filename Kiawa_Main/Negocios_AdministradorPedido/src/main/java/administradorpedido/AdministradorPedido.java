/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministradorPedido;

import excepciones.NegocioException;
import objetos_negocio.Pedido;
import java.util.List;
import dto.PedidoDTO;
import dto.PlatillosDTO;
import java.util.ArrayList;
import objetos_negocio.Platillo;
import objetos_negocio.Ubicacion;
import dto.UbicacionDTO;


/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class AdministradorPedido implements IAdministradorPedido {
    private static final AdministradorPedido instancia = new AdministradorPedido();

    private AdministradorPedido() {}

    public static AdministradorPedido getInstance() {
        return instancia;
    }

    @Override
    public void pagar() {
        throw new UnsupportedOperationException("Método no implementado");
    }

@Override
public Pedido RegistrarPedido(PedidoDTO nuevoPedido) throws NegocioException { 
    // Validación: Verificar si la lista de platillos o la ubicación es nula
    if (nuevoPedido.getPlatillos() == null || nuevoPedido.getPlatillos().isEmpty()) {
        throw new NegocioException("El pedido requiere al menos un platillo");
    }

    if (nuevoPedido.getUbicacion() == null) {
        throw new NegocioException("Se debe especificar una ubicación");
    }

    // Convertir el PedidoDTO en Pedido
    Pedido pedido = convertirPedidoDTOaPedido(nuevoPedido);

    // Aquí puedes agregar cualquier otra lógica que sea necesaria para procesar el pedido
    // Por ejemplo, podrías guardar el pedido en una base de datos o realizar más validaciones

    // Devolver el objeto Pedido convertido
    return pedido;
}

// Método para convertir PedidoDTO a Pedido (como se explicó anteriormente)
private Pedido convertirPedidoDTOaPedido(PedidoDTO pedidoDTO) {
    // Convertir la lista de PlatillosDTO a una lista de Platillos
    List<Platillo> platillos = new ArrayList<>();
    for (PlatillosDTO platilloDTO : pedidoDTO.getPlatillos()) {
        Platillo platillo = new Platillo();
        platillo.setPlatillo(platilloDTO.getPlatillo());
        platillo.setPrecio(platilloDTO.getPrecio());
        platillo.setExistencias(platilloDTO.getExistencias());
        platillo.setCantidad(platilloDTO.getCantidad());
        platillos.add(platillo);
    }
    
    // Convertir UbicacionDTO a Ubicacion
    Ubicacion ubicacion = convertirUbicacionDTOaUbicacion(pedidoDTO.getUbicacion());

    // Crear y devolver el objeto Pedido
    Pedido pedido = new Pedido();
    pedido.setPlatillos(platillos);
    pedido.setUbicacion(ubicacion);
    
    return pedido;
}

// Método para convertir UbicacionDTO a Ubicacion (puedes hacer algo similar con tu clase de Ubicacion)
private Ubicacion convertirUbicacionDTOaUbicacion(UbicacionDTO ubicacionDTO) {
    // Crear una nueva instancia de Ubicacion
    Ubicacion ubicacion = new Ubicacion();

    // Mapear los campos de UbicacionDTO a Ubicacion
    ubicacion.setEdificio(ubicacionDTO.getEdificio());
    ubicacion.setAula(ubicacionDTO.getAula());
    ubicacion.setTelefono(ubicacionDTO.getTelefono());
    ubicacion.setInstruccionesEntrega(ubicacionDTO.getInstruccionesEntrega());

    // Retornar la nueva instancia de Ubicacion
    return ubicacion;
}



    @Override
    public List<PedidoDTO> consultarPedidos(List<PedidoDTO> listaPedido) {
        return new ArrayList<>(listaPedido); // Devuelve copia de la lista
    }
}
