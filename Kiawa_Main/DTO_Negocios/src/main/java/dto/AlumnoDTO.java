/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class AlumnoDTO {
    private Long id;
    private String password;
    private String nombre;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AlumnoDTO() {
    }

    public AlumnoDTO(String nombre) {
        this.nombre = nombre;
    }

    public AlumnoDTO(Long id, String password, String nombre) {
        this.id = id;
        this.password = password;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    
}
