/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * @author Ariel Eduardo Borbón Izaguirre 252116 Freddy Ali Castro Román 252191
 * Jesús Adrián Luzanilla Tapia 252699 Alberto Jiménez García 252595
 *
 */
public class PlatilloDTO {

    private String idPlatillo;
    private String nombre;
    private Double precio;
    private String descripcion;
    private Integer existencias;
    private String categoria;
    private boolean disponible;

    public PlatilloDTO() {
    }

    public PlatilloDTO(String idPlatillo, String nombre, Double precio, String descripcion, Integer existencias, String categoria, boolean disponible) {
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(String idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
