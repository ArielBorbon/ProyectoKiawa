/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministradorUbicaciones;

import objetos_negocio.Ubicacion;
import dto.UbicacionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class AdministradorUbicaciones implements IAdministradorUbicaciones {
    private static final AdministradorUbicaciones instancia = new AdministradorUbicaciones();

    private AdministradorUbicaciones() {
    }

    public static AdministradorUbicaciones getInstance() {
        return instancia;
    }

    @Override
    public Ubicacion nuevaUbicacion(UbicacionDTO nuevaUbicacion) {
        return new Ubicacion(nuevaUbicacion.getEdificio(), nuevaUbicacion.getAula());
    }

    @Override
    public List<UbicacionDTO> consultarUbicaciones() {
        List<UbicacionDTO> listaUbicaciones = new ArrayList<>();
        listaUbicaciones.add(new UbicacionDTO("1800", "LV1821"));
        listaUbicaciones.add(new UbicacionDTO("1800", "LV1822"));
        listaUbicaciones.add(new UbicacionDTO("1800", "LV1823"));
        listaUbicaciones.add(new UbicacionDTO("1800", "AV1823"));
        listaUbicaciones.add(new UbicacionDTO("1800", "AV1824"));
        listaUbicaciones.add(new UbicacionDTO("1800", "AV1831"));
        listaUbicaciones.add(new UbicacionDTO("1400", "AV1421"));
        listaUbicaciones.add(new UbicacionDTO("1400", "AV1422"));
        listaUbicaciones.add(new UbicacionDTO("1400", "AV1423"));
        listaUbicaciones.add(new UbicacionDTO("1400", "AV1424"));
        
        return listaUbicaciones;
    }
}
