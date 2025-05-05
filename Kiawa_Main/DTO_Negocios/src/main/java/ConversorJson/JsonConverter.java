/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConversorJson;
import com.google.gson.Gson;
/**
 *
 * @author PC Gamer
 * @param <T>
 */


public class JsonConverter<T> {

    private final Class<T> tipo;
    private static final Gson gson = new Gson();

    public JsonConverter(Class<T> type) {
        this.tipo = type;
    }

    public String toJSON(T dto) {
        return gson.toJson(dto);
    }

    public T toDTO(String json) {
        return gson.fromJson(json, tipo);
    }
}

