/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import dto.RepartidorDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC Gamer
 */
public class RepartidorDAOTest {
    

    /**
     * Test of crearRepartidor method, of class RepartidorDAO.
     */
    @Test
    public void testCrearRepartidor() throws Exception {

        RepartidorDTO repartidor = new RepartidorDTO();

        repartidor.setNombreCompleto("Juan Pérez");
        repartidor.setTelefono("555-123-4567");
        repartidor.setDisponible(true);
        repartidor.setDomicilio("Calle Falsa 123, Ciudad Ejemplo");
        repartidor.setApodo("El Rayo");
        repartidor.setSalarioDiario(500.75);
        repartidor.setDiasTrabajo("Lunes a Viernes");
        repartidor.setHorario("9:00 AM - 6:00 PM");
        repartidor.setConsideracionesExtras("Tiene motocicleta propia y licencia vigente");   
        
        
        RepartidorDAO repartidorDAO = new RepartidorDAO();
        boolean exito = repartidorDAO.crearRepartidor(repartidor);
        assertEquals(exito , true);
        
        
    }
    
}
