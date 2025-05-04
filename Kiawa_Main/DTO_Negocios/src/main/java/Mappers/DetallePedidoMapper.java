/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.DetallePedido;
import dto.DetallePedidoDTO;

/**
 *
 * @author PC Gamer
 */
public class DetallePedidoMapper {

    public static DetallePedidoDTO toDTO(DetallePedido detalle) {
        if (detalle == null) return null;

        DetallePedidoDTO dto = new DetallePedidoDTO();
        dto.setNombrePlatillo(detalle.getNombrePlatillo());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setNota(detalle.getNota());
        return dto;
    }

    public static DetallePedido toEntity(DetallePedidoDTO dto, String idPlatillo) {
        if (dto == null) return null;

        DetallePedido detalle = new DetallePedido();
        detalle.setIdPlatillo(idPlatillo); // Esto ocupa venir de la lógica que convierte el nombre del platillo a su ID.
        detalle.setNombrePlatillo(dto.getNombrePlatillo());
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());
        detalle.setNota(dto.getNota());
        return detalle;
    }
}

