/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


import java.util.Date;
import java.util.List;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class PedidoDTO {
    private String idPedido;
    private String nombreAlumno;
    private UbicacionDTO ubicacionEntrega;
    private String telefonoContacto;
    private String instruccionesEntrega;
    private Date fechaPedido;
    private String estado;
    private String nombreCocinero;
    private String nombreRepartidor;
    private List<DetallePedidoDTO> platillos;
    private Double total;
    private Boolean pagado;
}

