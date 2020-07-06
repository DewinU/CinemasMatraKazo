/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silencraft26
 */
public class Factura {
    
    private int numeroFactura;
    private String nombrePelicula;
    private String horaFuncion;
    private String sala;
    private List<String> asientos;
    private String carnetEmpleado;
    private List<String> tipoComida;
    private List<Float> preciosComida;
    private float total;

    public Factura() {
        asientos = new ArrayList<>();
        tipoComida = new ArrayList<>();
        preciosComida = new ArrayList<>();
    }

    public Factura(int numeroFactura, String nombrePelicula, String horaFuncion, String sala, List<String> asientos, String carnetEmpleado, float total, List<String> nombreComida, List<Float> preciosComida) {
        this.numeroFactura = numeroFactura;
        this.nombrePelicula = nombrePelicula;
        this.horaFuncion = horaFuncion;
        this.sala = sala;
        this.asientos = asientos;
        this.carnetEmpleado = carnetEmpleado;
        this.total = total;
        this.tipoComida = nombreComida;
        this.preciosComida = preciosComida;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public void setHoraFuncion(String horaFuncion) {
        this.horaFuncion = horaFuncion;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public List<String> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<String> asientos) {
        this.asientos = asientos;
    }

    public String getCarnetEmpleado() {
        return carnetEmpleado;
    }

    public void setCarnetEmpleado(String carnetEmpleado) {
        this.carnetEmpleado = carnetEmpleado;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<String> getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(List<String> nombreComida) {
        this.tipoComida = nombreComida;
    }

    public List<Float> getPreciosComida() {
        return preciosComida;
    }

    public void setPreciosComida(List<Float> preciosComida) {
        this.preciosComida = preciosComida;
    }
}
