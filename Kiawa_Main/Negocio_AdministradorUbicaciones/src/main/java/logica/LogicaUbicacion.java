/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dto.UbicacionDTO;
import fabrica.FabricaObjetosNegocio;
import java.util.ArrayList;
import java.util.List;
import objetos_negocio.Ubicacion;

/**
 *
 * @author jalt2
 */
public class LogicaUbicacion {
    private UbicacionDTO ubicacionDTO = new UbicacionDTO();

    public LogicaUbicacion() {
    }
    
    
    
    public List<UbicacionDTO> obtenerUbicacionesDTO(){
        Ubicacion ubicacion = FabricaObjetosNegocio.crearUbicacionBO();
        List<Ubicacion> listaUbicaciones=ubicacion.obtenerUbicaciones();
        List<UbicacionDTO> listaUbicacionesDTO=new ArrayList();
        for(Ubicacion ubicaciones : listaUbicaciones){
            listaUbicacionesDTO.add(new UbicacionDTO(ubicaciones.getEdificio(), ubicaciones.getAula(),ubicaciones.getTelefono(),ubicaciones.getInstruccionesEntrega()));
        }
        return listaUbicacionesDTO;
    }
}
