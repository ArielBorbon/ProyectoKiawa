/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Ubicacion;
import dto.UbicacionDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IUbicacionBO {

    Ubicacion buscarUbicacionPorEdificioYSalonBO(UbicacionDTO dto) throws Exception;

    boolean crearUbicacionBO(UbicacionDTO ubicacionDTO) throws Exception;

    List<UbicacionDTO> obtenerListaUbicacionesBO() throws Exception;

    List<UbicacionDTO> filtrarPorEdificioBO(String edificio) throws Exception;

    boolean validarUbicacionExistenteBO(UbicacionDTO dto) throws Exception;
}
