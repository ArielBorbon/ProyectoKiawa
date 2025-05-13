/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Cocinero;
import dto.CocineroDTO;

/**
 *
 * @author PC Gamer
 */
public class CocineroMapper {

    public static CocineroDTO toDTO(Cocinero cocinero) {
        if (cocinero == null) return null;

        CocineroDTO dto = new CocineroDTO();
        dto.setIdCocinero(cocinero.getIdCocinero());
        dto.setNombreCompleto(cocinero.getNombreCompleto());
        dto.setTelefono(cocinero.getTelefono());
        dto.setDisponible(cocinero.getDisponible());
        dto.setDomicilio(cocinero.getDomicilio());
        dto.setApodo(cocinero.getApodo());
        dto.setSalarioDiario(cocinero.getSalarioDiario());
        dto.setDiasTrabajo(cocinero.getDiasTrabajo());
        dto.setHorario(cocinero.getHorario());
        dto.setConsideracionesExtras(cocinero.getConsideracionesExtras());
        dto.setCurp(cocinero.getCurp());

        

        return dto;
    }

    public static Cocinero toEntity(CocineroDTO dto, String contrasena) {
        if (dto == null) return null;

        Cocinero cocinero = new Cocinero();
        cocinero.setIdCocinero(dto.getIdCocinero());
        cocinero.setNombreCompleto(dto.getNombreCompleto());
        cocinero.setTelefono(dto.getTelefono());
        cocinero.setDisponible(dto.getDisponible());
        cocinero.setContrasena(contrasena);
        cocinero.setDomicilio(dto.getDomicilio());
        cocinero.setApodo(dto.getApodo());
        cocinero.setSalarioDiario(dto.getSalarioDiario());
        cocinero.setDiasTrabajo(dto.getDiasTrabajo());
        cocinero.setHorario(dto.getHorario());
        cocinero.setConsideracionesExtras(dto.getConsideracionesExtras());
        cocinero.setCurp(dto.getCurp());

        return cocinero;
    }
}

