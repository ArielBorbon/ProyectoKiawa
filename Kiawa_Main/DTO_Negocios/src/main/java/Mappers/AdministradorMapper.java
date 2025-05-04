/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Administrador;
import dto.AdministradorDTO;

/**
 *
 * @author PC Gamer
 */
public class AdministradorMapper {

    public static AdministradorDTO toDTO(Administrador administrador) {
        if (administrador == null) return null;

        AdministradorDTO dto = new AdministradorDTO();
        dto.setIdAdministrador(administrador.getIdAdministrador());
        dto.setNombreCompleto(administrador.getNombreCompleto());
        dto.setTelefono(administrador.getTelefono());

        return dto;
    }

    public static Administrador toEntity(AdministradorDTO dto, String contrasena) {
        if (dto == null) return null;

        Administrador admin = new Administrador();
        admin.setIdAdministrador(dto.getIdAdministrador());
        admin.setNombreCompleto(dto.getNombreCompleto());
        admin.setTelefono(dto.getTelefono());
        admin.setContrasena(contrasena);

        return admin;
    }
}

