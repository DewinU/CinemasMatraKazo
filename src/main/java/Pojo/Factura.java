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

    private float subTotal;
    private float iva;
    
    private String asientosFactura;
    private String tipoComidaFactura;
    private String preciosComidaFactura;
    
    public Factura() {
        asientos = new ArrayList<>();
        tipoComida = new ArrayList<>();
        preciosComida = new ArrayList<>();
    }

    public Factura(int numeroFactura, String nombrePelicula, String horaFuncion, String sala, List<String> asientos, String carnetEmpleado, List<String> tipoComida, List<Float> preciosComida, float total, String asientosFactura, String tipoComidaFactura, String preciosComidaFactura) {
        this.numeroFactura = numeroFactura;
        this.nombrePelicula = nombrePelicula;
        this.horaFuncion = horaFuncion;
        this.sala = sala;
        this.asientos = asientos;
        this.carnetEmpleado = carnetEmpleado;
        this.tipoComida = tipoComida;
        this.preciosComida = preciosComida;
        this.total = total;
        this.asientosFactura = asientosFactura;
        this.tipoComidaFactura = tipoComidaFactura;
        this.preciosComidaFactura = preciosComidaFactura;
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

    public String getAsientosFactura() {
        return asientosFactura;
    }

    public void setAsientosFactura(String asientosFactura) {
        this.asientosFactura = asientosFactura;
    }

    public String getTipoComidaFactura() {
        return tipoComidaFactura;
    }

    public void setTipoComidaFactura(String tipoComidaFactura) {
        this.tipoComidaFactura = tipoComidaFactura;
    }

    public String getPreciosComidaFactura() {
        return preciosComidaFactura;
    }

    public void setPreciosComidaFactura(String preciosComidaFactura) {
        this.preciosComidaFactura = preciosComidaFactura;
    }
    
    
    public String toStringAsientos(){
        String lis = "";
        for (String s : this.asientos){
            lis = lis + "\n" + s;
        }
        return lis;
    }
    public String toStringComida(){
        String lis = "";
        for (String s : this.tipoComida){
            lis = lis + "\n" + s;
        }
        return lis;
    }
    public String toStringPrecios(){
        String lis = "";
        for (Float s : this.preciosComida){
            lis = lis + "\n" + s;
        }
        return lis;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }
    
    
    
}
