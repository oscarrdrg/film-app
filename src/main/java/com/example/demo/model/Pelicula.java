package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;


@Document(collection = "peliculas")
public class Pelicula {
    @Id
    private String id;
    private String titulo;
    private ArrayList<String> actores;
    private String genero;
    private int añoEstreno;

    public Pelicula(String titulo, ArrayList<String> actores, String genero, int añoEstreno) {
        this.titulo = titulo;
        this.actores = actores;
        this.genero = genero;
        this.añoEstreno = añoEstreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAñoEstreno() {
        return añoEstreno;
    }

    public void setAñoEstreno(int añoEstreno) {
        this.añoEstreno = añoEstreno;
    }
}
