/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Entidades.Platillo;
import dto.PlatilloDTO;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC Gamer
 */
public class PlatilloDAOTest {
//    
//    public PlatilloDAOTest() {
//    }
//
//    /**
//     * Test of obtenerListaPlatillosDisponibles method, of class PlatilloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testObtenerListaPlatillosDisponibles() {
//        
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        List<PlatilloDTO> platillos = platilloDAO.obtenerListaPlatillosDisponibles();
//        assertEquals(1 ,    platillos.size());
//        for (PlatilloDTO platillo : platillos) {
//            System.out.println(platillo.getNombre());
//        }
//        
//        
//    }
//
//    /**
//     * Test of obtenerListaPlatillosTodos method, of class PlatilloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testObtenerListaPlatillosTodos() {
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        List<PlatilloDTO> platillos = platilloDAO.obtenerListaPlatillosTodos();
//        assertEquals(3 ,    platillos.size());
//        for (PlatilloDTO platillo : platillos) {
//            System.out.println(platillo.getNombre());
//        }
//    }
//
//    /**
//     * Test of actualizarExistenciasPlatillo method, of class PlatilloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testActualizarExistenciasPlatillo() {
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        
//        Platillo platillo = platilloDAO.obtenerPlatilloPorNombre("Burro");
//        platilloDAO.actualizarExistenciasPlatillo(platillo, 999);
//        
//        platillo = platilloDAO.obtenerPlatilloPorNombre("Burro");
//        assertEquals(999 , platillo.getExistencias());
//        
//        
//        
//        
//        
//    }
//
//    /** 
//     * Test of obtenerPlatilloPorNombre method, of class PlatilloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testObtenerPlatilloPorNombre() {
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        Platillo platillo = platilloDAO.obtenerPlatilloPorNombre("Quesadillas");
//        assertEquals("Quesadillas" , platillo.getNombre());
//    }
//
//    /**
//     * Test of agregarPlatillo method, of class PlatilloDAO.
//     * @throws java.lang.Exception
//     */
//    @org.junit.jupiter.api.Test
//    public void testAgregarPlatillo() throws Exception {
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        PlatilloDTO platilloDTO = new PlatilloDTO();
//        platilloDTO.setCategoria("Entrada");
//        platilloDTO.setDescripcion("2 Quesadillas Picosas");
//        platilloDTO.setExistencias(50);
//        platilloDTO.setNombre("Quesadillas");
//        platilloDTO.setPrecio(70.50);
//        platilloDAO.agregarPlatillo(platilloDTO);
//        
//        
//        
//        
//        
//        Platillo platilloPorNombre = platilloDAO.obtenerPlatilloPorNombre(platilloDTO.getNombre());
//        
//        assertEquals(platilloDTO.getNombre() , platilloPorNombre.getNombre());
//               
//        
//        
//        
//    }
//
//    /**
//     * Test of deshabilitarPlatillo method, of class PlatilloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testDeshabilitarPlatillo() throws Exception {
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        platilloDAO.deshabilitarPlatillo("Taco");
//        //si se dio false
//        
//        
//        
//    }
//
//    /**
//     * Test of habilitarPlatillo method, of class PlatilloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testHabilitarPlatillo() throws Exception {
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        platilloDAO.habilitarPlatillo("Taco");
//        //si se dio true
//        
//        
//        
//        
//        
//    }
//
//    /**
//     * Test of modificarPlatillo method, of class PlatilloDAO.
//     */
//    @org.junit.jupiter.api.Test
//    public void testModificarPlatillo() {
//        PlatilloDAO platilloDAO = new PlatilloDAO();
//        PlatilloDTO platilloDTO = new PlatilloDTO();
//        
//        platilloDTO.setNombre("Roll Roll");
//        platilloDTO.setPrecio(777.77);
//        platilloDTO.setDescripcion("El Rollo mas Sabroso que Existe");
//        platilloDTO.setCategoria("Postre");
//        
//        platilloDAO.modificarPlatillo("Taco", platilloDTO);
//        
//        Platillo platilloEliminado = platilloDAO.obtenerPlatilloPorNombre("Taco");
//        assertEquals(null , platilloEliminado);
//        
//        Platillo platilloActualizado = platilloDAO.obtenerPlatilloPorNombre("Roll Roll");
//        assertEquals("Roll Roll" , platilloActualizado.getNombre());
//        
//        
//        
//    }
//    
}
