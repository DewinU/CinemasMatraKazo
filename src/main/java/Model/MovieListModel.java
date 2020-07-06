package Model;

import Pojo.Pelicula;
import com.google.gson.Gson;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieListModel {
    List<Pelicula> peliculasAll;
    List<Pelicula> peliculasCartelera;
    Gson gson;

    public MovieListModel() {
        peliculasAll = new ArrayList<>();
        peliculasCartelera = new ArrayList<>();
        gson = new Gson();
        loadAllFromJson();
        loadCarteleraFromJson();
    }

    public void updateJson(ObservableList<Pelicula> peliculas){
        try {
            FileWriter writer = new FileWriter("./src/main/resources/Data/PeliculasDisponibles.json");
            writer.write(gson.toJson(peliculas));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AsientoListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadAllFromJson(){
        try {
            peliculasAll.addAll(Arrays.asList(gson.fromJson(new FileReader("./src/main/resources/Data/PeliculasDisponibles.json"), Pelicula[].class)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadCarteleraFromJson(){
        for (Pelicula c : peliculasAll) {
            if(c.isCarteleraStatus()) {
                peliculasCartelera.add(c);
            }
        }
    }

    public List<Pelicula> getPeliculasAll() {
        return peliculasAll;
    }

    public List<Pelicula> getPeliculasCartelera() {
        return peliculasCartelera;
    }
}
