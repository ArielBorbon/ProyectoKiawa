/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import Entidades.DetallePedido;
import Entidades.Platillo;
import dto.PlatilloDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IPlatilloDAO {
    
    List<PlatilloDTO> obtenerListaPlatillosDisponibles();
    
    List<PlatilloDTO> obtenerListaPlatillosTodos();
    
    boolean actualizarExistenciasPlatillo(Platillo platillo, int nuevaCantidad);
    
    Platillo obtenerPlatilloPorNombre(String nombrePlatillo);
    
    boolean agregarPlatillo(PlatilloDTO platilloDTO) throws Exception;
    
    boolean deshabilitarPlatillo(String nombrePlatillo) throws Exception;
    
    boolean habilitarPlatillo(String nombrePlatillo) throws Exception;
    
    boolean modificarPlatillo(String nombreOriginal, PlatilloDTO platilloDTO);
    
    boolean hayExistenciasSuficientes(List<DetallePedido> detalles);
    
    boolean hayExistenciasSuficientesSB(List<DetallePedido> detalles, StringBuilder mensajeError);
}
