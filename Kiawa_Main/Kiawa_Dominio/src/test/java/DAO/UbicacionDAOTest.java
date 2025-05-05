/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import dto.UbicacionDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC Gamer
 */
public class UbicacionDAOTest {
    
    public UbicacionDAOTest() {
    }
    
//
//    /**
//     * Test of buscarUbicacionPorEdificioYSalon method, of class UbicacionDAO.
//     * @throws java.lang.Exception
//     */
//    @Test
//    public void testBuscarUbicacionPorEdificioYSalon() throws Exception {
//        UbicacionDAO ubicacionDAO = new UbicacionDAO();
//        UbicacionDTO ubicacionDTO = new UbicacionDTO();
//        ubicacionDTO.setEdificio("1500");
//        ubicacionDTO.setSalon("1502");
//        
//
//        Ubicacion ubicacion = ubicacionDAO.buscarUbicacionPorEdificioYSalon(ubicacionDTO);
//        assertEquals(ubicacionDTO.getEdificio() , ubicacion.getEdificio());
//        assertEquals(ubicacionDTO.getSalon() , ubicacion.getSalon());
//        
//    }
//
//    /**
//     * Test of crearUbicacion method, of class UbicacionDAO.
//     */
//    @Test
//    public void testCrearUbicacion() throws Exception {
//        
//        
//        UbicacionDAO ubicacionDAO = new UbicacionDAO();
//        UbicacionDTO ubicacionDTO = new UbicacionDTO();
//        ubicacionDTO.setEdificio("1500");
//        ubicacionDTO.setSalon("1502");
//        boolean exito = ubicacionDAO.crearUbicacion(ubicacionDTO);
//        
//        assertEquals(true , exito);
//        Ubicacion ubicacion = ubicacionDAO.buscarUbicacionPorEdificioYSalon(ubicacionDTO);
//        assertEquals(ubicacionDTO.getEdificio() , ubicacion.getEdificio());
//        assertEquals(ubicacionDTO.getSalon() , ubicacion.getSalon());
//        
//        
//        
//        
//    }
//
//    /**
//     * Test of obtenerListaUbicaciones method, of class UbicacionDAO.
//     */
//    @Test
//    public void testObtenerListaUbicaciones() throws Exception {
//
//        UbicacionDAO ubicacionDAO = new UbicacionDAO();
//        List<UbicacionDTO> ubicaciones = ubicacionDAO.obtenerListaUbicaciones();
//        
//        assertEquals(5, ubicaciones.size());
//        
//        for (UbicacionDTO ubicacione : ubicaciones) {
//            System.out.println(ubicacione.getEdificio() + "//" + ubicacione.getSalon());
//        }
//        
//        
//        
//    }
//
//    /**
//     * Test of filtrarPorEdificio method, of class UbicacionDAO.
//     */
//    @Test
//    public void testFiltrarPorEdificio() throws Exception {
//        
//        UbicacionDAO ubicacionDAO = new UbicacionDAO();
//        List<UbicacionDTO> ubicaciones = ubicacionDAO.filtrarPorEdificio("1500");
//        
//        assertEquals (2 , ubicaciones.size());
//        
//        for (UbicacionDTO ubicacione : ubicaciones) {
//            System.out.println(ubicacione.getEdificio() + "//"  + ubicacione.getSalon());
//        }
//        
//        
//        
//        
//    }
    
    
//    @Test
//    public void validarUbicacionExistente() throws Exception{
//        UbicacionDAO ubicacionDAO = new UbicacionDAO();
//        UbicacionDTO dto = new UbicacionDTO();
//        dto.setEdificio("1800");
//        dto.setSalon("1821");
//        boolean exito = ubicacionDAO.validarUbicacionExistente(dto);
//        
//        assertEquals(true , exito);
//    }
    
    
    
    
    
    
    
}
