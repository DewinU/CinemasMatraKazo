/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silencraft26
 */
public class Pelicula {
    
    private String titulo;
    private String anio;
    private String categoria;
    private String fechaEstreno;
    private String duracion;
    private String genero;
    private String director;
    private String descripcion;
    private String fotoUrl;
    private String calificacion;
    private List<String> sala;
    private List<String> funcion;
    private boolean carteleraStatus;
    private LocalDate desde;
    private LocalDate hasta;

    public Pelicula() {
        funcion = new ArrayList<>();
        sala = new ArrayList<>();
    }

    public Pelicula(String titulo, String anio, String categoria, String fechaEstreno, String duracion, String genero, String director, String descripcion, String fotoUrl, String calificacion, List<String> sala, List<String> funcion, boolean carteleraStatus, LocalDate desde, LocalDate hasta) {
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
        this.carteleraStatus = carteleraStatus;
        this.desde = desde;
        this.hasta = hasta;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
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

    public List<String> getSala() {
        return sala;
    }

    public void setSala(List<String> sala) {
        this.sala = sala;
    }

    public List<String> getFuncion() {
        return funcion;
    }

    public void setFuncion(List<String> funcion) {
        this.funcion = funcion;
    }

    public boolean isCarteleraStatus() {
        return carteleraStatus;
    }

    public void setCarteleraStatus(boolean carteleraStatus) {
        this.carteleraStatus = carteleraStatus;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta = hasta;
    }
}
