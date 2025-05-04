/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Repartidor;
import dto.RepartidorDTO;

/**
 *
 * @author PC Gamer
 */
public class RepartidorMapper {

    public static RepartidorDTO toDTO(Repartidor repartidor) {
        if (repartidor == null) return null;

        RepartidorDTO dto = new RepartidorDTO();
        dto.setIdRepartidor(repartidor.getIdRepartidor());
        dto.setNombreCompleto(repartidor.getNombreCompleto());
        dto.setTelefono(repartidor.getTelefono());
        dto.setDisponible(repartidor.getDisponible());

        return dto;
    }

    public static Repartidor toEntity(RepartidorDTO dto, String contrasena) {
        if (dto == null) return null;

        Repartidor repartidor = new Repartidor();
        repartidor.setIdRepartidor(dto.getIdRepartidor());
        repartidor.setNombreCompleto(dto.getNombreCompleto());
        repartidor.setTelefono(dto.getTelefono());
        repartidor.setDisponible(dto.getDisponible());
        repartidor.setContrasena(contrasena); // Se pasa como argumento externo

        return repartidor;
    }
}

