/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author PC Gamer
 */
public class RepartidorDTO {

    private String idRepartidor;
    private String nombreCompleto;
    private String telefono;
    private Boolean disponible;
    private String domicilio;
    private String apodo;
    private double salarioDiario;
    private String diasTrabajo;
    private String Horario;
    private String consideracionesExtras;
    private String curp;    

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public RepartidorDTO(String idRepartidor, String nombreCompleto, String telefono, Boolean disponible, String domicilio, String apodo, double salarioDiario, String diasTrabajo, String Horario, String consideracionesExtras, String curp) {
        this.idRepartidor = idRepartidor;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.disponible = disponible;
        this.domicilio = domicilio;
        this.apodo = apodo;
        this.salarioDiario = salarioDiario;
        this.diasTrabajo = diasTrabajo;
        this.Horario = Horario;
        this.consideracionesExtras = consideracionesExtras;
        this.curp = curp;
    }
    
    

    public RepartidorDTO() {
    }

    public RepartidorDTO(String idRepartidor, String nombreCompleto, String telefono, Boolean disponible, String domicilio, String apodo, double salarioDiario, String diasTrabajo, String Horario, String consideracionesExtras) {
        this.idRepartidor = idRepartidor;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.disponible = disponible;
        this.domicilio = domicilio;
        this.apodo = apodo;
        this.salarioDiario = salarioDiario;
        this.diasTrabajo = diasTrabajo;
        this.Horario = Horario;
        this.consideracionesExtras = consideracionesExtras;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public double getSalarioDiario() {
        return salarioDiario;
    }

    public void setSalarioDiario(double salarioDiario) {
        this.salarioDiario = salarioDiario;
    }

    public String getDiasTrabajo() {
        return diasTrabajo;
    }

    public void setDiasTrabajo(String diasTrabajo) {
        this.diasTrabajo = diasTrabajo;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public String getConsideracionesExtras() {
        return consideracionesExtras;
    }

    public void setConsideracionesExtras(String consideracionesExtras) {
        this.consideracionesExtras = consideracionesExtras;
    }



    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

}
