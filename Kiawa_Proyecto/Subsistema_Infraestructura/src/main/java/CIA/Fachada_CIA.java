/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CIA;

import com.google.gson.Gson;
import dto.AlumnoDTO;
import dto.LoginRequestDTO;

/**
 *
 * @author PC Gamer
 */


public class Fachada_CIA {

    private final Control_CIA controlCIA;
    private final Gson gson;

    public Fachada_CIA() {
        this.controlCIA = new Control_CIA();
        this.gson = new Gson();
    }

    public AlumnoDTO recuperarAlumnoExterno(LoginRequestDTO loginRequest) throws Exception {
        String jsonEntrada = gson.toJson(loginRequest);

        // Enviar JSON a control y recibir respuesta JSON
        String jsonRespuesta = controlCIA.obtenerDatosAlumno(jsonEntrada);

        // Convertir JSON a AlumnoDTO
        AlumnoDTO alumno = gson.fromJson(jsonRespuesta, AlumnoDTO.class);

        return alumno;
    }
}
