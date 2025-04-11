/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministradorPlatillos;

import objetos_negocio.Platillo;
import java.util.List;
import dto.PlatillosDTO;
import fabrica.FabricaObjetosNegocio;
import java.util.ArrayList;
import logica.LogicaPlatillos;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class AdministradorPlatillos implements IAdministradorPlatillos {
    private static AdministradorPlatillos instancia;
    private List<PlatillosDTO> listaPlatillosDisponibles = new ArrayList<>();
    private LogicaPlatillos logicaplatillos=new LogicaPlatillos();

    private AdministradorPlatillos() {
        this.listaPlatillosDisponibles = this.logicaplatillos.obtenerPlatillosDTO();
    }

    public static AdministradorPlatillos getInstance() {
        if (instancia==null) {
            instancia = new AdministradorPlatillos();
        }
        return instancia; 
        
    }

    @Override
    public PlatillosDTO nuevoPlatillo(PlatillosDTO nuevoPlatillo) {
        return new PlatillosDTO(
            nuevoPlatillo.getId(),
            nuevoPlatillo.getPlatillo(), 
            nuevoPlatillo.getPrecio(), 
            nuevoPlatillo.getExistencias()
        );
    }

    @Override
    public void ActualizarExistencias(String platilloActualizar, Integer cantidadActualizar) {
        for (PlatillosDTO platillo : listaPlatillosDisponibles) {
            if (platillo.getPlatillo().equalsIgnoreCase(platilloActualizar)) {
                platillo.setExistencias(platillo.getExistencias() - cantidadActualizar);
            }
        }
    }

    @Override
    public List<PlatillosDTO> consultarPlatillos() {
        return this.listaPlatillosDisponibles;
    }
}
