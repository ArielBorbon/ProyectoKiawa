/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos_negocio;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class Platillo {
    
    private String platillo;
    private Double precio;
    private Integer existencias;
    private Integer cantidad;

    public Platillo(String platillo, Double precio, Integer existencias, Integer cantidad) {
        this.platillo = platillo;
        this.precio = precio;
        this.existencias = existencias;
        this.cantidad = cantidad;
    }

    public Platillo(String platillo, Double precio, Integer existencias) {
        this.platillo = platillo;
        this.precio = precio;
        this.existencias = existencias;
    }

    public Platillo() {
    }




    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer inventario) {
        this.cantidad = inventario;
    }
    
    
}
