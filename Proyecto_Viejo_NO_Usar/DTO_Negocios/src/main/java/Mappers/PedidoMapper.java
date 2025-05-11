/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.DetallePedido;
import Entidades.Pedido;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class PedidoMapper {

    public static PedidoDTO toDTO(Pedido pedido) {
        if (pedido == null) {
            return null;
        }

        PedidoDTO dto = new PedidoDTO();
        dto.setIdPedido(pedido.getIdPedido());
        dto.setNombreAlumno(pedido.getNombreAlumno());
        dto.setUbicacionEntrega(UbicacionMapper.toDTO(pedido.getUbicacionEntrega()));
        dto.setTelefonoContacto(pedido.getTelefonoContacto());
        dto.setInstruccionesEntrega(pedido.getInstruccionesEntrega());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setEstado(pedido.getEstado());
        dto.setNombreCocinero(pedido.getNombreCocinero());
        dto.setNombreRepartidor(pedido.getNombreRepartidor());
        dto.setTotal(pedido.getTotal());
        dto.setPagado(pedido.getPagado());
        dto.setFolio(pedido.getFolio());

        List<DetallePedidoDTO> detalleDTOs = new ArrayList<>();
        for (DetallePedido detalle : pedido.getPlatillos()) {
            detalleDTOs.add(DetallePedidoMapper.toDTO(detalle));
        }
        dto.setPlatillos(detalleDTOs);

        return dto;
    }

    public static Pedido toEntity(PedidoDTO dto, String idAlumno, String idCocinero, String idRepartidor, List<DetallePedido> detalles) {
        if (dto == null) {
            return null;
        }

        Pedido pedido = new Pedido();
        pedido.setIdPedido(dto.getIdPedido());
        pedido.setNombreAlumno(dto.getNombreAlumno());
        pedido.setIdAlumno(idAlumno);
        pedido.setUbicacionEntrega(UbicacionMapper.toEntity(dto.getUbicacionEntrega()));
        pedido.setTelefonoContacto(dto.getTelefonoContacto());
        pedido.setInstruccionesEntrega(dto.getInstruccionesEntrega());
        pedido.setFechaPedido(dto.getFechaPedido());
        pedido.setEstado(dto.getEstado());
        pedido.setNombreCocinero(dto.getNombreCocinero());
        pedido.setNombreRepartidor(dto.getNombreRepartidor());
        pedido.setPlatillos(detalles); // Esta lista ya mapeada antes con los ID de cada platillo
        pedido.setTotal(dto.getTotal());
        pedido.setPagado(dto.getPagado());
        pedido.setIdCocinero(idCocinero);
        pedido.setIdRepartidor(idRepartidor);
        pedido.setFolio(dto.getFolio());

        return pedido;
    }
}

