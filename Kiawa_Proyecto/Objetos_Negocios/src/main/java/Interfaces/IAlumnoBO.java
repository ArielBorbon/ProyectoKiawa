/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dto.AlumnoDTO;
import dto.LoginRequestDTO;

/**
 *
 * @author PC Gamer
 */
public interface IAlumnoBO {

    public AlumnoDTO recuperarAlumno(LoginRequestDTO loginRequest) throws Exception;

    public AlumnoDTO recuperarAlumnoPorId(String id) throws Exception;
}
