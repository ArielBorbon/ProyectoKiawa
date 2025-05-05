/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Platillo;

/**
 *
 * @author PC Gamer
 */
public class MainDAO {
    
    
    public static void main(String[] args) throws Exception {
        Platillo platillo = new Platillo();
        platillo.setCategoria("Entrada");
        platillo.setDescripcion("Platillo para comenzar el dia");
        platillo.setDisponible(true);
        platillo.setExistencias(32);
        platillo.setNombre("Burrito T1");
        platillo.setPrecio(50.50);
        
        PlatilloDAO platilloDAO = new PlatilloDAO();
        platilloDAO.agregarPlatillo(platillo); //ya revento porque la puse como platilloDTO
        
        //es una prueba por encimita nomas luego la voy a borrar
    }
}
