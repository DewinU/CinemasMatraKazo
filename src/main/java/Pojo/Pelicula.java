/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Silencraft26
 */
public class Pelicula implements Comparable<Pelicula>{
    
    private String titulo;
    private String anio;
    private String categoria;
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

    public Pelicula()
    {
        funcion = new ArrayList<>();
        sala = new ArrayList<>();
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

    public Pelicula(String titulo, String anio, String categoria, String genero, String director, String descripcion, String fotoUrl, String calificacion, List<String> sala, List<String> funcion, boolean carteleraStatus, LocalDate desde, LocalDate hasta) {
        this.titulo = titulo;
        this.anio = anio;
        this.categoria = categoria;
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

    @Override
    public int compareTo(Pelicula o) {
        return Boolean.compare(o.isCarteleraStatus(),this.isCarteleraStatus());
    }

    public String getFuncionesAsString(){
        return getString(funcion);
    }

    public String getSalasAsString(){
        return getString(sala);
    }

    private String getString(List<String> listToAppend) {
        String append = "";
        for(int i = 0; i < listToAppend.size() - 1 ; i++){
            append += listToAppend.get(i) + ", ";
        }
        append += listToAppend.get(listToAppend.size() - 1);
        return append;
    }
}
