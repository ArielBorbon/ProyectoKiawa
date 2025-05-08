package Subsistema;

import BO.PlatilloBO;
import Entidades.DetallePedido;
import Fabricas.FactoryBO;
import dto.PlatilloDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class FSubsistema_Platillos {

    private PlatilloBO platilloBO;

    public FSubsistema_Platillos() {
        this.platilloBO = FactoryBO.crearPlatilloBO();
    }

    public List<PlatilloDTO> obtenerPlatillosDisponibles() {
        return platilloBO.obtenerListaPlatillosDisponiblesBO();
    }

    public List<PlatilloDTO> obtenerTodosLosPlatillos() {
        return platilloBO.obtenerListaPlatillosTodosBO();
    }

    public boolean registrarPlatillo(PlatilloDTO dto) throws Exception {
        return platilloBO.agregarPlatilloBO(dto);
    }

    public boolean editarPlatillo(String nombreOriginal, PlatilloDTO dto) {
        return platilloBO.modificarPlatilloBO(nombreOriginal, dto);
    }

    public boolean habilitarPlatillo(String nombre) throws Exception {
        return platilloBO.habilitarPlatilloBO(nombre);
    }

    public boolean deshabilitarPlatillo(String nombre) throws Exception {
        return platilloBO.deshabilitarPlatilloBO(nombre);
    }

    public boolean validarExistenciasParaPedido(List<DetallePedido> detalles, StringBuilder mensajeError) {
        return platilloBO.hayExistenciasSuficientesSBBO(detalles, mensajeError);
    }

    // public Platillo buscarPlatilloPorNombre(String nombre) {
    //     return platilloBO.obtenerPlatilloPorNombreBO(nombre); //posiblemente mala practica asi que clausurado por mientras
    // }
    public List<PlatilloDTO> buscarPorCategoria(String categoria) {
        return platilloBO.buscarPorCategoriaBO(categoria);
    }

    public List<PlatilloDTO> buscarPorNombre(String nombre) {
        return platilloBO.buscarPorNombreBO(nombre);
    }

    public List<PlatilloDTO> buscarPorCategoriaYNombre(String categoria, String nombre) {
        return platilloBO.buscarPorCategoriaYNombreBO(categoria, nombre);
    }
}
