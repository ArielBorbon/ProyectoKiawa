/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import objetos_negocio.Alumno;
import objetos_negocio.Pedido;
import objetos_negocio.Platillo;
import objetos_negocio.Ubicacion;

/**
 *
 * @author jalt2
 */
public class FabricaObjetosNegocio {
    private static Platillo instanciaPlatillo;
    private static Alumno instanciaAlumno;
    private static Pedido instanciaPedido;
    private static Ubicacion instanciaUbicacion;

    private FabricaObjetosNegocio() {
        
    }
    
    
    
    public static Platillo crearPlatilloBO(){
        if (instanciaPlatillo==null) {
            instanciaPlatillo = new Platillo();
        }
        return instanciaPlatillo;
    }
    
    public static Alumno crearAlumnoBO(){
        if (instanciaAlumno==null) {
            instanciaAlumno=new Alumno();
        }
        return instanciaAlumno;
    }
    
    public static Ubicacion crearUbicacionBO(){
        if (instanciaUbicacion==null) {
            instanciaUbicacion = new Ubicacion();
        }
        return instanciaUbicacion;
    }
    
    public static Pedido crearPedidoBO(){
        if (instanciaPedido==null) {
            instanciaPedido=new Pedido();
        }
        return instanciaPedido;
    }
}
