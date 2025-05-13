/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO.RellenoBD;

import BO.AdministradorBO;
import BO.CocineroBO;
import BO.PedidoBO;
import BO.PlatilloBO;
import BO.RepartidorBO;
import BO.UbicacionBO;
import Fabricas.FactoryBO;
import dto.CocineroDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author rayoa
 */
public class LlenarBD {
    
    
    @Test
    public void rellenarBD() throws Exception{
        CocineroBO cocineroBO = FactoryBO.crearCocineroBO();
        RepartidorBO repartidorBO = FactoryBO.crearRepartidorBO();
        AdministradorBO administradorBO = FactoryBO.crearAdministradorBO();
        UbicacionBO ubicacionBO = FactoryBO.crearUbicacionBO();
        PlatilloBO platilloBO = FactoryBO.crearPlatilloBO();
        PedidoBO pedidoBO = FactoryBO.crearPedidoBO();
        
        cocineroBO.buscarCocineroPorIdFriendlyBO("000001");
        if (true) { //buscar un cocinero (el cual se debe crear Abajo), basicamente condicion para que no se llene 2 veces con lo mismo
            //todos los new entidades para rellenar la BD
            
            CocineroDTO cocineroDTO = new CocineroDTO();
                    cocineroDTO.setApodo("Freddys");
        cocineroDTO.setConsideracionesExtras("Alergico al 1800");
        cocineroDTO.setDiasTrabajo("LMMiJV");
        cocineroDTO.setDisponible(true);
        cocineroDTO.setDomicilio("Calle de la A 567");
        cocineroDTO.setHorario("de 9 a 5PM");
        cocineroDTO.setNombreCompleto("Freddy Ali Castro Roman");
        cocineroDTO.setSalarioDiario(250.10);
        cocineroDTO.setTelefono("5931458501");
        boolean exito = cocineroBO.crearCocineroBO(cocineroDTO, "Contraseña123");
        assertEquals(exito , true);
        cocineroBO.deshabilitarCocineroBO("000001");
        
        
        
        
        
            
            
        }
    }
}
