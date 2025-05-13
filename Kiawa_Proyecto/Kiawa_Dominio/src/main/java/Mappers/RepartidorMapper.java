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
        if (repartidor == null) {
            return null;
        }

        RepartidorDTO dto = new RepartidorDTO();
        dto.setIdRepartidor(repartidor.getIdRepartidor());
        dto.setNombreCompleto(repartidor.getNombreCompleto());
        dto.setTelefono(repartidor.getTelefono());
        dto.setDisponible(repartidor.getDisponible());
        dto.setDomicilio(repartidor.getDomicilio());
        dto.setApodo(repartidor.getApodo());
        dto.setSalarioDiario(repartidor.getSalarioDiario());
        dto.setDiasTrabajo(repartidor.getDiasTrabajo());
        dto.setHorario(repartidor.getHorario());
        dto.setConsideracionesExtras(repartidor.getConsideracionesExtras());
        dto.setCurp(repartidor.getCurp());

        return dto;
    }

    public static Repartidor toEntity(RepartidorDTO dto, String contrasena) {
        if (dto == null) {
            return null;
        }

        Repartidor repartidor = new Repartidor();
        repartidor.setIdRepartidor(dto.getIdRepartidor());
        repartidor.setNombreCompleto(dto.getNombreCompleto());
        repartidor.setTelefono(dto.getTelefono());
        repartidor.setDisponible(dto.getDisponible());
        repartidor.setDomicilio(dto.getDomicilio());
        repartidor.setApodo(dto.getApodo());
        repartidor.setSalarioDiario(dto.getSalarioDiario());
        repartidor.setDiasTrabajo(dto.getDiasTrabajo());
        repartidor.setHorario(dto.getHorario());
        repartidor.setConsideracionesExtras(dto.getConsideracionesExtras());
        repartidor.setContrasena(contrasena);
        repartidor.setCurp(dto.getCurp());

        return repartidor;
    }
}

