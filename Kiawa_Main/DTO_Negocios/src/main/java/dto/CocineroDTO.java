/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author PC Gamer
 */
public class CocineroDTO {
    private String idCocinero;
    private String nombreCompleto;
    private String telefono;
    private Boolean disponible;

    public CocineroDTO() {
    }

    
    
    
    public CocineroDTO(String idCocinero, String nombreCompleto, String telefono, Boolean disponible) {
        this.idCocinero = idCocinero;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.disponible = disponible;
    }

    public String getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(String idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
    
}

