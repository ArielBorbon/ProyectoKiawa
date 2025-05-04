/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author PC Gamer
 */
public class RepartidorDTO {
    private String idRepartidor;
    private String nombreCompleto;
    private String telefono;
    private Boolean disponible;

    public RepartidorDTO() {
    }

    public RepartidorDTO(String idRepartidor, String nombreCompleto, String telefono, Boolean disponible) {
        this.idRepartidor = idRepartidor;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.disponible = disponible;
    }

    
    
    
    
    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
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

