/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


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
    private List<PlatillosDTO> platillos;
    private UbicacionDTO ubicacion;

    public PedidoDTO(List<PlatillosDTO> platillos, UbicacionDTO ubicacion) {
        this.platillos = platillos;
        this.ubicacion = ubicacion;
    }

    public List<PlatillosDTO> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<PlatillosDTO> platillos) {
        this.platillos = platillos;
    }

    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }


    
    
}
