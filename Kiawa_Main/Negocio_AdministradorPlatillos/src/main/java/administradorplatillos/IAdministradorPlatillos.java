/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AdministradorPlatillos;

import objetos_negocio.Platillo;
import java.util.List;
import dto.PlatillosDTO;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public interface IAdministradorPlatillos {
    
    public abstract PlatillosDTO nuevoPlatillo(PlatillosDTO nuevoPlatillo);
    public abstract List<PlatillosDTO> consultarPlatillos();
    public abstract void ActualizarExistencias(String platilloActualizar,Integer cantidadActualizar);
}
