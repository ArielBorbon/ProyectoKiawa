///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package objetos_negocio;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author
// * Ariel Eduardo Borbón Izaguirre    252116 
// * Freddy Ali Castro Román           252191 
// * Jesús Adrián Luzanilla Tapia      252699
// * Alberto Jiménez García            252595 
// * 
// */
//public class Ubicacion {
//    private String edificio;
//    private String aula;
//    private String telefono;
//    private String instruccionesEntrega;
//    private List<Ubicacion> listaUbicaciones=new ArrayList();
//
//    public Ubicacion(String edificio, String aula, String telefono, String instruccionesEntrega) {
//        this.edificio = edificio;
//        this.aula = aula;
//        this.telefono = telefono;
//        this.instruccionesEntrega = instruccionesEntrega;
//    }
//
//    public Ubicacion(String edificio, String aula) {
//        this.edificio = edificio;
//        this.aula = aula;
//    }
//
//    public Ubicacion() {
//    }
//    
//    
//    public List<Ubicacion> obtenerUbicaciones(){
//        this.listaUbicaciones.add(new Ubicacion("1800", "LV1822"));
//        this.listaUbicaciones.add(new Ubicacion("1800", "LV1821"));
//        this.listaUbicaciones.add(new Ubicacion("1800", "LV1823"));
//        this.listaUbicaciones.add(new Ubicacion("1800", "AV1823"));
//        this.listaUbicaciones.add(new Ubicacion("1800", "AV1824"));
//        this.listaUbicaciones.add(new Ubicacion("1800", "AV1831"));
//        this.listaUbicaciones.add(new Ubicacion("1400", "AV1421"));
//        this.listaUbicaciones.add(new Ubicacion("1400", "AV1422"));
//        this.listaUbicaciones.add(new Ubicacion("1400", "AV1423"));
//        this.listaUbicaciones.add(new Ubicacion("1400", "AV1424"));
//
//        return this.listaUbicaciones;
//    }
//    
//    
//    
//    public String getEdificio() {
//        return edificio;
//    }
//
//    public void setEdificio(String edificio) {
//        this.edificio = edificio;
//    }
//
//    public String getAula() {
//        return aula;
//    }
//
//    public void setAula(String aula) {
//        this.aula = aula;
//    }
//
//    public String getTelefono() {
//        return telefono;
//    }
//
//    public void setTelefono(String telefono) {
//        this.telefono = telefono;
//    }
//
//    public String getInstruccionesEntrega() {
//        return instruccionesEntrega;
//    }
//
//    public void setInstruccionesEntrega(String instruccionesEntrega) {
//        this.instruccionesEntrega = instruccionesEntrega;
//    }
//    
//    
//}
