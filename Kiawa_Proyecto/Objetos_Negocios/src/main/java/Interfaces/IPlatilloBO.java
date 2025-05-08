/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.DetallePedido;
import Entidades.Platillo;
import dto.PlatilloDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface IPlatilloBO {

    List<PlatilloDTO> obtenerListaPlatillosDisponiblesBO();

    List<PlatilloDTO> obtenerListaPlatillosTodosBO();

    boolean actualizarExistenciasPlatilloBO(Platillo platillo, int nuevaCantidad);

    Platillo obtenerPlatilloPorNombreBO(String nombrePlatillo);

    boolean agregarPlatilloBO(PlatilloDTO platilloDTO) throws Exception;

    boolean deshabilitarPlatilloBO(String nombrePlatillo) throws Exception;

    boolean habilitarPlatilloBO(String nombrePlatillo) throws Exception;

    boolean modificarPlatilloBO(String nombreOriginal, PlatilloDTO platilloDTO);

    boolean hayExistenciasSuficientesSBBO(List<DetallePedido> detalles, StringBuilder mensajeError);

    public List<PlatilloDTO> buscarPorCategoriaBO(String categoria);

    public List<PlatilloDTO> buscarPorNombreBO(String nombre);

    public List<PlatilloDTO> buscarPorCategoriaYNombreBO(String categoria, String nombre);
}
