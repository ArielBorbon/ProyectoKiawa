/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dto.PlatillosDTO;
import fabrica.FabricaObjetosNegocio;
import java.util.ArrayList;
import java.util.List;
import objetos_negocio.Platillo;

/**
 *
 * @author jalt2
 */
public class LogicaPlatillos {

    public LogicaPlatillos() {
    }
    
    public List<PlatillosDTO> obtenerPlatillosDTO(){
        Platillo platillo = FabricaObjetosNegocio.crearPlatilloBO();
        List<Platillo> listaPlatillos=platillo.obtenerMenuPlatillos();
        List<PlatillosDTO> listaPlatillosDTO=new ArrayList();
        for(Platillo platillos:listaPlatillos){
            listaPlatillosDTO.add(new PlatillosDTO(platillos.getId(), platillos.getPlatillo(),platillos.getPrecio(),platillos.getExistencias()));
        }
        return listaPlatillosDTO;
    }
}
