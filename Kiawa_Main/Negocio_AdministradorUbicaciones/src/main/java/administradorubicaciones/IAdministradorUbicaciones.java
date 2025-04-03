/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AdministradorUbicaciones;

import objetos_negocio.Ubicacion;
import dto.UbicacionDTO;
import java.util.List;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public interface IAdministradorUbicaciones {
    public abstract Ubicacion nuevaUbicacion(UbicacionDTO nuevaUbicacion);
    public abstract List<UbicacionDTO> consultarUbicaciones();
}
