/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.UbicacionDAO;
import Entidades.Ubicacion;
import Interfaces.IUbicacionBO;
import dto.UbicacionDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class UbicacionBO implements IUbicacionBO {

    private UbicacionDAO ubicacionDAO;

    public UbicacionBO(UbicacionDAO ubicacionDAO) {
        this.ubicacionDAO = ubicacionDAO;
    }
    
    

    @Override
    public Ubicacion buscarUbicacionPorEdificioYSalonBO(UbicacionDTO dto) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO de ubicación no puede ser nulo.");
        }
        if (dto.getEdificio() == null || dto.getEdificio().trim().isEmpty()) {
            throw new IllegalArgumentException("El edificio no puede ser nulo o vacío.");
        }
        if (dto.getSalon() == null || dto.getSalon().trim().isEmpty()) {
            throw new IllegalArgumentException("El salón no puede ser nulo o vacío.");
        }

        return ubicacionDAO.buscarUbicacionPorEdificioYSalon(dto);
    }

    @Override
    public boolean crearUbicacionBO(UbicacionDTO ubicacionDTO) throws Exception {
        if (ubicacionDTO == null) {
            throw new IllegalArgumentException("El DTO de ubicación no puede ser nulo.");
        }
        if (ubicacionDTO.getEdificio() == null || ubicacionDTO.getEdificio().trim().isEmpty()) {
            throw new IllegalArgumentException("El edificio no puede ser nulo o vacío.");
        }
        if (ubicacionDTO.getSalon() == null || ubicacionDTO.getSalon().trim().isEmpty()) {
            throw new IllegalArgumentException("El salón no puede ser nulo o vacío.");
        }

        return ubicacionDAO.crearUbicacion(ubicacionDTO);
    }

    @Override
    public List<UbicacionDTO> obtenerListaUbicacionesBO() throws Exception {
        return ubicacionDAO.obtenerListaUbicaciones();
    }

    @Override
    public List<UbicacionDTO> filtrarPorEdificioBO(String edificio) throws Exception {
        if (edificio == null || edificio.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del edificio no puede ser nulo o vacío.");
        }

        return ubicacionDAO.filtrarPorEdificio(edificio);
    }

    @Override
    public boolean validarUbicacionExistenteBO(UbicacionDTO dto) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO de ubicación no puede ser nulo.");
        }
        if (dto.getEdificio() == null || dto.getEdificio().trim().isEmpty()) {
            throw new IllegalArgumentException("El edificio no puede ser nulo o vacío.");
        }
        if (dto.getSalon() == null || dto.getSalon().trim().isEmpty()) {
            throw new IllegalArgumentException("El salón no puede ser nulo o vacío.");
        }

        return ubicacionDAO.validarUbicacionExistente(dto);
    }
}

