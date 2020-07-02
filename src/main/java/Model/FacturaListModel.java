/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.Asiento;
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
    AsientoListModel asientoListModel;
    
    public FacturaListModel(){
        this.dataPeliculas = new ArrayList<>();
    }
    
    public List<Pelicula> getListPelicula(){
        return dataPeliculas;
    }
    
    public void OpenSalaJson(String sala){
        
        switch (sala){
            case "Sala 1":
                asientoListModel = new AsientoListModel("./src/main/resources/Data/Salas/Sala1.json");
                asientoListModel.loadFromJson();
                break;
            case "Sala 2":
                asientoListModel = new AsientoListModel("./src/main/resources/Data/Salas/Sala2.json");
                asientoListModel.loadFromJson();
                break;
            case "Sala 3":
                asientoListModel = new AsientoListModel("./src/main/resources/Data/Salas/Sala3.json");
                asientoListModel.loadFromJson();
                break;
            case "Sala 4":
                asientoListModel = new AsientoListModel("./src/main/resources/Data/Salas/Sala4.json");
                asientoListModel.loadFromJson();
                break;
            case "Sala 5":
                asientoListModel = new AsientoListModel("./src/main/resources/Data/Salas/Sala5.json");
                asientoListModel.loadFromJson();
                break;
            case "Sala 6":
                asientoListModel = new AsientoListModel("./src/main/resources/Data/Salas/Sala6.json");
                asientoListModel.loadFromJson();
                break;
            default:
                System.out.println("default");
                break;
        }
        
    }
    
    public List<Asiento> getListAsiento(){
        return asientoListModel.getList();
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
