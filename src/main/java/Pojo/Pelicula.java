/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import Enums.Categoria;
import Enums.Genero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silencraft26
 */
public class Pelicula {
    
    private String titulo;
    private String anio;
    private Categoria categoria;
    private String fechaEstreno;
    private String duracion;
    private Genero genero;
    private String director;
    private String descripcion;
    private String fotoUrl;
    private String calificacion;
    private List<String> sala;
    private List<String> funcion;
    
    public Pelicula() {
        funcion = new ArrayList<>();
    }

    
    public Pelicula(String titulo, String anio, Categoria categoria, String fechaEstreno, String duracion, Genero genero, String director, String descripcion, String fotoUrl, String calificacion, List<String> sala, List<String> funcion) {
        this.titulo = titulo;
        this.anio = anio;
        this.categoria = categoria;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
        this.descripcion = descripcion;
        this.fotoUrl = fotoUrl;
        this.calificacion = calificacion;
        this.sala = sala;
        this.funcion = funcion;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public List<String> getFuncion() {
        return funcion;
    }

    public void setFuncion(List<String> funcion) {
        this.funcion = funcion;
    }

    public List<String> getSala() {
        return sala;
    }

    public void setSala(List<String> sala) {
        this.sala = sala;
    }
    
}
