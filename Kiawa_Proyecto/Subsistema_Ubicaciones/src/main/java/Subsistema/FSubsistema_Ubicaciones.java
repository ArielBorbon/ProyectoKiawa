/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subsistema;

import BO.UbicacionBO;
import Entidades.Ubicacion;
import Fabricas.FactoryBO;
import dto.UbicacionDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class FSubsistema_Ubicaciones {

    private final UbicacionBO ubicacionBO;

    public FSubsistema_Ubicaciones() throws Exception {
        this.ubicacionBO = FactoryBO.crearUbicacionBO();
    }

    public Ubicacion buscarUbicacionPorEdificioYSalon(UbicacionDTO dto) throws Exception {
        return ubicacionBO.buscarUbicacionPorEdificioYSalonBO(dto);
    }

    public boolean crearUbicacion(UbicacionDTO ubicacionDTO) throws Exception {
        return ubicacionBO.crearUbicacionBO(ubicacionDTO);
    }

    public List<UbicacionDTO> obtenerListaUbicaciones() throws Exception {
        return ubicacionBO.obtenerListaUbicacionesBO();
    }

    public List<UbicacionDTO> filtrarPorEdificio(String edificio) throws Exception {
        return ubicacionBO.filtrarPorEdificioBO(edificio);
    }

    public boolean validarUbicacionExistente(UbicacionDTO dto) throws Exception {
        return ubicacionBO.validarUbicacionExistenteBO(dto);
    }
}

