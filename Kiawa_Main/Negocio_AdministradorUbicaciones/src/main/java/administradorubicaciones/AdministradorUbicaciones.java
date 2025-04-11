/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministradorUbicaciones;

import objetos_negocio.Ubicacion;
import dto.UbicacionDTO;
import java.util.ArrayList;
import java.util.List;
import logica.LogicaUbicacion;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class AdministradorUbicaciones implements IAdministradorUbicaciones {
    private static AdministradorUbicaciones instancia;
    private LogicaUbicacion logicaUbicacion = new LogicaUbicacion();

    private AdministradorUbicaciones() {
    }

    public static AdministradorUbicaciones getInstance() {
        if (instancia==null) {
            instancia = new AdministradorUbicaciones();
        }
        return instancia;
    }

    @Override
    public Ubicacion nuevaUbicacion(UbicacionDTO nuevaUbicacion) {
        return new Ubicacion(nuevaUbicacion.getEdificio(), nuevaUbicacion.getAula());
    }

    @Override
    public List<UbicacionDTO> consultarUbicaciones() {
        return logicaUbicacion.obtenerUbicacionesDTO();
    }
}
