/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CIA.Fachada_CIA;
import dto.AlumnoDTO;

/**
 *
 * @author PC Gamer
 */
public class AlumnoDAO {
                     
            //solo como apoyo para crear el pedido (confirmar mas que nada), pero no es un dao ya que no estamos accediendo a mongo, es al sistema Externo CIA
    public AlumnoDTO recuperarAlumnoPorId(String id) throws Exception {
    Fachada_CIA fachadaCIA = new Fachada_CIA();
    return fachadaCIA.recuperarAlumnoExternoPorId(id);
}

}
