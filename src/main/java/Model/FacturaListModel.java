/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.Pelicula;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silencraft26
 */
public class FacturaListModel {
    
    List<Pelicula>  dataPeliculas;
    
    public FacturaListModel(){
        this.dataPeliculas = new ArrayList<>();
    }
    
    public List<Pelicula> getListPelicula(){
        return dataPeliculas;
    }
    
    public void LoadFromJsonPeliculas(){
        Gson gson = new Gson();
        try {
            dataPeliculas.addAll(Arrays.asList(gson.fromJson(new FileReader("./src/main/resources/Data/PeliculasDisponibles.json"), Pelicula[].class)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}