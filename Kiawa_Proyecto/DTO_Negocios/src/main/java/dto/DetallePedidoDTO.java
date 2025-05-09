/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author PC Gamer
 */
public class DetallePedidoDTO {

    private String nombrePlatillo;
    private Integer cantidad;
    private Double precioUnitario;
    private String nota; //la entidad tiene subtotal que se saca con cantidad * precio unitario, pero el DTO no tiene 
    private double subtotal;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(String nombrePlatillo, Integer cantidad, Double precioUnitario, String nota) {
        this.nombrePlatillo = nombrePlatillo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nota = nota;
    }

    public DetallePedidoDTO(String nombrePlatillo, Integer cantidad, Double precioUnitario, String nota, double subtotal) {
        this.nombrePlatillo = nombrePlatillo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nota = nota;
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

}
