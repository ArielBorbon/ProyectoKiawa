/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Platillo;
import dto.PlatilloDTO;

/**
 *
 * @author PC Gamer
 */
public class PlatilloMapper {

    public static PlatilloDTO toDTO(Platillo platillo) {
        if (platillo == null) {
            return null;
        }
        PlatilloDTO dto = new PlatilloDTO();
        dto.setIdPlatillo(platillo.getIdPlatillo());
        dto.setNombre(platillo.getNombre());
        dto.setPrecio(platillo.getPrecio());
        dto.setExistencias(platillo.getExistencias());
        dto.setCategoria(platillo.getCategoria());
        dto.setDescripcion(platillo.getDescripcion());
        dto.setDisponible(platillo.getDisponible());
        
        return dto;
    }

    public static Platillo toEntity(PlatilloDTO dto) {
        if (dto == null) {
            return null;
        }
        Platillo platillo = new Platillo();
        platillo.setIdPlatillo(dto.getIdPlatillo());
        platillo.setNombre(dto.getNombre());
        platillo.setPrecio(dto.getPrecio());
        platillo.setDescripcion(dto.getDescripcion());
        platillo.setExistencias(dto.getExistencias());
        platillo.setDisponible(dto.isDisponible());
        platillo.setCategoria(dto.getCategoria());
        return platillo;
    }
}
