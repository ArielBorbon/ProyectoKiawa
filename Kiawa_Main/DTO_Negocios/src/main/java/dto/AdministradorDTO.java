/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author PC Gamer
 */
public class AdministradorDTO {
    private String idAdministrador;
    private String nombreCompleto;
    private String telefono;

    public AdministradorDTO(String idAdministrador, String nombreCompleto, String telefono) {
        this.idAdministrador = idAdministrador;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public AdministradorDTO() {
    }

    
    
    
    
    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
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
    
    
    
    
}

