/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Entidades.DetallePedido;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import dto.UbicacionDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC Gamer
 */
public class PedidoDAOTest {
//    
//    public PedidoDAOTest() {
//    }
//
//
//    /**
//     * Test of existePedidoConFolio method, of class PedidoDAO.
//     */
//    @Test
//    public void testExistePedidoConFolio() {
//        PedidoDAO pedidoDAO = new PedidoDAO();
//        boolean existe = pedidoDAO.existePedidoConFolio("KWA-06/05/2025-000");
//        assertEquals(existe , true);
//        
//        
//        boolean existe2 = pedidoDAO.existePedidoConFolio("KWA-06/05/2025-005");
//        assertEquals(existe2, false);
//    }
//
//    /**
//     * Test of crearFolioPedido method, of class PedidoDAO.
//     */
//    @Test
//    public void testCrearFolioPedido() {
//        
//        PedidoDAO pedidoDAO = new PedidoDAO();
//        String folio = pedidoDAO.crearFolioPedido();
//        System.out.println(folio);
//    }
//
//
//    @Test
//    public void testConvertirADetallePedidoEntity() {
//        //pendiente pero ya funciono como tal el metodo grande
//    }
//
//    /**
//     * Test of mapearPedidoCompleto method, of class PedidoDAO.
//     */
//    @Test
//    public void testMapearPedidoCompleto() throws Exception {
//        //pendiente pero ya funciono como tal el metodo grande
//    }
//
//    /**
//     * Test of crearPedido method, of class PedidoDAO.
//     */
//    @Test
//    public void testCrearPedido() {
//
//        PedidoDTO pedido = new PedidoDTO();
//        
//                pedido.setIdPedido("12345");                         
//        pedido.setNombreAlumno("Juan Pérez");                
//        pedido.setUbicacionEntrega(new UbicacionDTO("1800", "1821"));
//        pedido.setTelefonoContacto("555-1234");              
//        pedido.setInstruccionesEntrega("Dejar en la puerta"); 
//        pedido.setFechaPedido(new Date());                                          
//        pedido.setTotal(350.75);                                                         
//        pedido.setFolio("FOLIO12345");                         
//        
//        PedidoDAO pedidoDAO = new PedidoDAO();
//        
//        DetallePedidoDTO platillo2 = new DetallePedidoDTO("Taco", 3, 45.75, "Con extra de salsa");
//        DetallePedidoDTO platillo3 = new DetallePedidoDTO("Roll Roll", 2, 90.00, "Sin aderezo");
//
//        List<DetallePedidoDTO> platillos = new ArrayList<>();
//        
//        platillos.add(platillo2);
//        platillos.add(platillo3);
//        
//        
//        boolean exito = pedidoDAO.crearPedido(pedido, platillos, "000001");
//        
//        assertEquals(exito , true);
//        
//    }
//    
//
//    @Test
//    public void testObtenerHistorialPlatillosPorAlumno() {
//        PedidoDAO dao = new PedidoDAO();
//
//        String idAlumno = "Ariel Borbon"; 
//        int CANTIDAD_ESPERADA = 12;
//        
//        List<DetallePedido> historial = dao.obtenerHistorialPlatillosPorAlumno(idAlumno);
//
//        assertNotNull(historial);
//        assertTrue(historial.size() >= 0); 
//        assertEquals(CANTIDAD_ESPERADA, historial.size());
//        
//        for (DetallePedido detalle : historial) {
//            System.out.println(detalle.getNombrePlatillo() + " x" + detalle.getCantidad());
//        }
//    }
//    
//    @Test
//    public void testObtenerPedidosAsignadosARepartidor_existentes() {
//        String idRepartidorExistente = "000001";
//        PedidoDAO pedidoDAO = new PedidoDAO();
//        List<PedidoDTO> pedidos = pedidoDAO.obtenerPedidosAsignadosARepartidor(idRepartidorExistente);
//
//        assertNotNull(pedidos, "La lista de pedidos no debe ser null");
//        assertFalse(pedidos.isEmpty(), "Debe haber al menos un pedido asignado");
//        
//    }
}
