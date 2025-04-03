/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos_negocio;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class Ubicacion {
    private String edificio;
    private String aula;
    private String telefono;
    private String instruccionesEntrega;

    public Ubicacion(String edificio, String aula, String telefono, String instruccionesEntrega) {
        this.edificio = edificio;
        this.aula = aula;
        this.telefono = telefono;
        this.instruccionesEntrega = instruccionesEntrega;
    }

    public Ubicacion(String edificio, String aula) {
        this.edificio = edificio;
        this.aula = aula;
    }

    public Ubicacion() {
    }
    
    
    
    
    
    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInstruccionesEntrega() {
        return instruccionesEntrega;
    }

    public void setInstruccionesEntrega(String instruccionesEntrega) {
        this.instruccionesEntrega = instruccionesEntrega;
    }
    
    
}
