/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Ubicacion;
import dto.UbicacionDTO;

/**
 *
 * @author PC Gamer
 */
public class UbicacionMapper {

    public static UbicacionDTO toDTO(Ubicacion ubicacion) {
        if (ubicacion == null) return null;

        UbicacionDTO dto = new UbicacionDTO();
        dto.setEdificio(ubicacion.getEdificio());
        dto.setSalon(ubicacion.getSalon());
        return dto;
    }

    public static Ubicacion toEntity(UbicacionDTO dto) {
        if (dto == null) return null;

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setEdificio(dto.getEdificio());
        ubicacion.setSalon(dto.getSalon());
        return ubicacion;
    }
}

