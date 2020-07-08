package Model;

import Pojo.Pelicula;
import com.google.gson.Gson;
import javafx.collections.ObservableList;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieListModel {

    private List<Pelicula> peliculasAll;
    private List<Pelicula> peliculasCartelera;
    private Gson gson;
    private final String PATH = "./src/main/resources/Data/Dewin.json";

    public MovieListModel() {
        peliculasAll = new ArrayList<>();
        peliculasCartelera = new ArrayList<>();
        gson = new Gson();
        loadAllFromJson();
        loadCarteleraFromJson();
    }

    public void updateJson(ObservableList<Pelicula> peliculas){
        try {
            FileWriter writer = new FileWriter(PATH);
            writer.write(gson.toJson(peliculas));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AsientoListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadAllFromJson(){
        try {
            File archivo = new File(PATH);
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            else if(archivo.length() > 0){
                LocalDate thisDate = LocalDate.now();
                peliculasAll.addAll(Arrays.asList(gson.fromJson(new FileReader(PATH), Pelicula[].class)));
                for (Pelicula c : peliculasAll) {
                    if(thisDate.isAfter(c.getHasta()) || thisDate.isBefore(c.getDesde())){
                        c.setCarteleraStatus(false);
                    }
                }
                Collections.sort(peliculasAll);
            }

        } catch (IOException ex) { }
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
