/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AdministradorPedido;

import objetos_negocio.Pedido;
import excepciones.NegocioException;
import java.util.List;
import dto.PedidoDTO;
import dto.PlatillosDTO;
import dto.UbicacionDTO;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public interface IAdministradorPedido {
    public abstract Pedido RegistrarPedido(PedidoDTO nuevoPedido)throws NegocioException; 
    public abstract void pagar();
    public abstract List<PedidoDTO> consultarPedidos(List<PedidoDTO> listaPedido);
}
