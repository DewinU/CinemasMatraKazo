/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.util.List;

/**
 *
 * @author Silencraft26
 */
public class Factura {
    
    private int numeroFactura;
    private List<String> nombrePeliculas;
    private String horaFuncion;
    private String sala;
    private List<String> asientos;
    private String carnetEmpleado;
//    private List<String> comida;

    public Factura() {
    }

    public Factura(int numeroFactura, List<String> nombrePeliculas, String horaFuncion, String sala, List<String> asientos, String carnetEmpleado) {
        this.numeroFactura = numeroFactura;
        this.nombrePeliculas = nombrePeliculas;
        this.horaFuncion = horaFuncion;
        this.sala = sala;
        this.asientos = asientos;
        this.carnetEmpleado = carnetEmpleado;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public List<String> getNombrePeliculas() {
        return nombrePeliculas;
    }

    public void setNombrePeliculas(List<String> nombrePeliculas) {
        this.nombrePeliculas = nombrePeliculas;
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
     
    
     
}
