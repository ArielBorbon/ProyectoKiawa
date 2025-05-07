/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interfaces;

import Entidades.Ubicacion;
import dto.UbicacionDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IUbicacionDAO {
    
    Ubicacion buscarUbicacionPorEdificioYSalon(UbicacionDTO dto) throws Exception;
    
    boolean crearUbicacion(UbicacionDTO ubicacionDTO) throws Exception;
    
    List<UbicacionDTO> obtenerListaUbicaciones() throws Exception;
    
    List<UbicacionDTO> filtrarPorEdificio(String edificio) throws Exception;
    
    boolean validarUbicacionExistente(UbicacionDTO dto) throws Exception;
}
