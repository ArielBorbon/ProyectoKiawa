/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministradorPlatillos;

import objetos_negocio.Platillo;
import java.util.List;
import dto.PlatillosDTO;
import java.util.ArrayList;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class AdministradorPlatillos implements IAdministradorPlatillos {
    private static final AdministradorPlatillos instancia = new AdministradorPlatillos();
    private List<PlatillosDTO> listaPlatillosDisponibles = new ArrayList<>();
    
    private PlatillosDTO platillo1 = new PlatillosDTO(1,"Burritos",35.0, 3);
    private PlatillosDTO platillo2 = new PlatillosDTO(2,"Coca cola", 18.0, 10);
    private PlatillosDTO platillo3 = new PlatillosDTO(3,"Torta", 40.0, 5);
    private PlatillosDTO platillo4 = new PlatillosDTO(4,"Galletas", 20.0, 20);
    private PlatillosDTO platillo5 = new PlatillosDTO(5,"Sabritas", 21.0, 15);

    private AdministradorPlatillos() {
        listaPlatillosDisponibles.add(platillo1); 
        listaPlatillosDisponibles.add(platillo2);
        listaPlatillosDisponibles.add(platillo3);
        listaPlatillosDisponibles.add(platillo4);
        listaPlatillosDisponibles.add(platillo5);
    }

    public static AdministradorPlatillos getInstance() {
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
        return listaPlatillosDisponibles;
    }
}
