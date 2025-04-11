/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos_negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * Ariel Eduardo Borbón Izaguirre    252116 
 * Freddy Ali Castro Román           252191 
 * Jesús Adrián Luzanilla Tapia      252699
 * Alberto Jiménez García            252595 
 * 
 */
public class Platillo {
    private int id;
    private String platillo;
    private Double precio;
    private Integer existencias;
    private Integer cantidad;
    private List<Platillo> menu=new ArrayList();

    public Platillo(int id,String platillo, Double precio, Integer existencias, Integer cantidad) {
        this.id=id;
        this.platillo = platillo;
        this.precio = precio;
        this.existencias = existencias;
        this.cantidad = cantidad;
    }

    public Platillo(int id,String platillo, Double precio, Integer existencias) {
        this.id=id;
        this.platillo = platillo;
        this.precio = precio;
        this.existencias = existencias;
    }

    public Platillo() {
    }
    
    public List<Platillo> obtenerMenuPlatillos(){
        //Estos datos podrian ser recuperados de una base de datos con una DAO
        this.menu.add(new Platillo(1,"Burritos",35.0, 31));
        this.menu.add(new Platillo(2,"Coca cola", 18.0, 10));
        this.menu.add(new Platillo(3,"Torta", 40.0, 5));
        this.menu.add(new Platillo(4,"Galletas", 20.0, 20));
        this.menu.add(new Platillo(5,"Sabritas", 21.0, 15));

        return this.menu;
    }
    
    public void eliminarPlatillo(int platilloEliminar){
        this.menu.remove(platilloEliminar-1);
    }
    
    public void actualizarPlatillo(Platillo platilloActualizar){
        
        if (this.menu.contains(platilloActualizar.getId())) {
            this.menu.set(platilloActualizar.getId()-1, platilloActualizar);
        } 
    }
    
    public List<Platillo> getMenu() {
        return menu;
    }

    public void setMenu(List<Platillo> menu) {
        this.menu = menu;
    }

    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer inventario) {
        this.cantidad = inventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
