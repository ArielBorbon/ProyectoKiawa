package dto;

/**
 * @author Ariel Eduardo Borbón Izaguirre 252116 Freddy Ali Castro Román 252191
 * Jesús Adrián Luzanilla Tapia 252699 Alberto Jiménez García 252595
 *
 */
public class UbicacionDTO {

    private String edificio;
    private String salon;

    public UbicacionDTO() {
    }

    public UbicacionDTO(String edificio, String salon) {
        this.edificio = edificio;
        this.salon = salon;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

}
