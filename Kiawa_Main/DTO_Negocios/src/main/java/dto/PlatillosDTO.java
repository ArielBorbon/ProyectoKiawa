/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import fabrica.FabricaObjetosNegocio;
import java.util.ArrayList;
import java.util.List;
import objetos_negocio.Platillo;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class PlatillosDTO {
    private int id;
    private String platillo;
    private Double precio;
    private Integer existencias;
    private Integer cantidad;

    public PlatillosDTO() {
    }

    public PlatillosDTO(int id,String platillo, Double precio, Integer existencias, Integer cantidad) {
        this.id=id;
        this.platillo = platillo;
        this.precio = precio;
        this.existencias = existencias;
        this.cantidad = cantidad;
    }

    public PlatillosDTO(int id,String platillo, Double precio, Integer existencias) {
        this.id=id;
        this.platillo = platillo;
        this.precio = precio;
        this.existencias = existencias;
    }
    
    public String getPlatillo() {
        return platillo;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }
    
    
}
