/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class Pedido {

    private String idPedido;
    private String nombreAlumno;
    private String idAlumno;
    private Ubicacion ubicacionEntrega;
    private String telefonoContacto;
    private String instruccionesEntrega;
    private Date fechaPedido;
    private String estado;
    private String nombreCocinero;
    private String nombreRepartidor;
    private List<DetallePedido> platillos;
    private Double total;
    private Boolean pagado;
    private String idCocinero;
    private String idRepartidor;
    private String folio;

    public Pedido() {
    }

    public Pedido(String idPedido, String nombreAlumno, String idAlumno, Ubicacion ubicacionEntrega, String telefonoContacto, String instruccionesEntrega, Date fechaPedido, String estado, String nombreCocinero, String nombreRepartidor, List<DetallePedido> platillos, Double total, Boolean pagado, String idCocinero, String idRepartidor) {
        this.idPedido = idPedido;
        this.nombreAlumno = nombreAlumno;
        this.idAlumno = idAlumno;
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
        this.idCocinero = idCocinero;
        this.idRepartidor = idRepartidor;
    }

    public Pedido(String idPedido, String nombreAlumno, String idAlumno, Ubicacion ubicacionEntrega, String telefonoContacto, String instruccionesEntrega, Date fechaPedido, String estado, String nombreCocinero, String nombreRepartidor, List<DetallePedido> platillos, Double total, Boolean pagado, String idCocinero, String idRepartidor, String folio) {
        this.idPedido = idPedido;
        this.nombreAlumno = nombreAlumno;
        this.idAlumno = idAlumno;
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
        this.idCocinero = idCocinero;
        this.idRepartidor = idRepartidor;
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

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Ubicacion getUbicacionEntrega() {
        return ubicacionEntrega;
    }

    public void setUbicacionEntrega(Ubicacion ubicacionEntrega) {
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

    public List<DetallePedido> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<DetallePedido> platillos) {
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

    public String getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(String idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

}
