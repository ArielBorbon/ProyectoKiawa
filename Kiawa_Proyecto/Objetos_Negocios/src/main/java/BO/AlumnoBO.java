/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import CIA.Fachada_CIA;
import Interfaces.IAlumnoBO;
import dto.AlumnoDTO;
import dto.LoginRequestDTO;

/**
 *
 * @author PC Gamer
 */
public class AlumnoBO implements IAlumnoBO {

    @Override
    public AlumnoDTO recuperarAlumno(LoginRequestDTO loginRequest) throws Exception {
        Fachada_CIA fachadaCIA = new Fachada_CIA();
        return fachadaCIA.recuperarAlumnoExterno(loginRequest);

    }

    @Override
    public AlumnoDTO recuperarAlumnoPorId(String id) throws Exception {
        Fachada_CIA fachadaCIA = new Fachada_CIA();
        return fachadaCIA.recuperarAlumnoExternoPorId(id);

    }
}
