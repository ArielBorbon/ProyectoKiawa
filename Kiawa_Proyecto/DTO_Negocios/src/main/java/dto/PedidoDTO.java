/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;
import java.util.List;

/**
 * @author Ariel Eduardo Borbón Izaguirre 252116 Freddy Ali Castro Román 252191
 * Jesús Adrián Luzanilla Tapia 252699 Alberto Jiménez García 252595
 *
 */
public class PedidoDTO {

    private String idPedido;
    private String nombreAlumno;
    private UbicacionDTO ubicacionEntrega;
    private String telefonoContacto;
    private String instruccionesEntrega;
    private Date fechaPedido;
    private String estado;
    private String nombreCocinero;
    private String nombreRepartidor;
    private List<DetallePedidoDTO> platillos;
    private Double total;
    private Boolean pagado;
    private String folio;

    public PedidoDTO() {
    }

    public PedidoDTO(String idPedido, String nombreAlumno, UbicacionDTO ubicacionEntrega, String telefonoContacto, String instruccionesEntrega, Date fechaPedido, String estado, String nombreCocinero, String nombreRepartidor, List<DetallePedidoDTO> platillos, Double total, Boolean pagado, String folio) {
        this.idPedido = idPedido;
        this.nombreAlumno = nombreAlumno;
        this.ubicacionEntrega = ubicacionEntrega;
        this.telefonoContacto = telefonoContacto;
        this.instruccionesEntrega = instruccionesEntrega;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.nombreCocinero = nombreCocinero;
        this.nombreRepartidor = nombreRepartidor;
        this.platillos = platillos;
        this.total = total;
        this.pagado = pagado;
        this.folio = folio;
    }

    
    
    
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public UbicacionDTO getUbicacionEntrega() {
        return ubicacionEntrega;
    }

    public void setUbicacionEntrega(UbicacionDTO ubicacionEntrega) {
        this.ubicacionEntrega = ubicacionEntrega;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getInstruccionesEntrega() {
        return instruccionesEntrega;
    }

    public void setInstruccionesEntrega(String instruccionesEntrega) {
        this.instruccionesEntrega = instruccionesEntrega;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCocinero() {
        return nombreCocinero;
    }

    public void setNombreCocinero(String nombreCocinero) {
        this.nombreCocinero = nombreCocinero;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public List<DetallePedidoDTO> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<DetallePedidoDTO> platillos) {
        this.platillos = platillos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

}
