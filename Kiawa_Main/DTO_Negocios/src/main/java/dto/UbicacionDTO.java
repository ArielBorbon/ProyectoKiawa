
package dto;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class UbicacionDTO {
    private String edificio;
    private String aula;
    private String telefono;
    private String instruccionesEntrega;

    public UbicacionDTO() {
    }

    public UbicacionDTO(String edificio, String aula, String telefono, String instruccionesEntrega) {
        this.edificio = edificio;
        this.aula = aula;
        this.telefono = telefono;
        this.instruccionesEntrega = instruccionesEntrega;
    }

    public UbicacionDTO(String edificio, String aula) {
        this.edificio = edificio;
        this.aula = aula;
    }
    
    

    public String getEdificio() {
        return edificio;
    }

    public String getAula() {
        return aula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getInstruccionesEntrega() {
        return instruccionesEntrega;
    }
    
    
}
