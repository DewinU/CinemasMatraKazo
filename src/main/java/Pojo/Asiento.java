/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Silencraft26
 */
public class Asiento {
    
    private boolean ocupado;
    private int id;
    private String nombre;
    
    public Asiento(){
        
    }

    public Asiento(boolean ocupado, int id, String nombre) {
        this.ocupado = ocupado;
        this.id = id;
        this.nombre = nombre;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Asiento{" + "ocupado: " + ocupado + ", id: " + id + ", nombre: " + nombre + '}';
    }
    
    
    
}
