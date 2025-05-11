/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dto.AlumnoDTO;
import fabrica.FabricaObjetosNegocio;
import objetos_negocio.Alumno;

/**
 *
 * @author jalt2
 */
public class LogicaAlumnos {

    public LogicaAlumnos() {
    }
    
        public AlumnoDTO obtenerAlumnoDTO(){
        Alumno alumno = FabricaObjetosNegocio.crearAlumnoBO();
        AlumnoDTO alumnoActualDTO = new AlumnoDTO();
        
        alumnoActualDTO.setId(alumno.getId());
        alumnoActualDTO.setNombre(alumno.getNombre());
        alumnoActualDTO.setPassword(alumno.getPassword());
        
        return alumnoActualDTO;
    }
}
