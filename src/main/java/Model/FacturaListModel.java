/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.Asiento;
import Pojo.Factura;
import Pojo.Pelicula;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    List<Factura> dataFacturas;
    
    public FacturaListModel(){
        this.dataPeliculas = new ArrayList<>();
        this.dataFacturas = new ArrayList<>();
    }
    
    public List<Pelicula> getListPelicula(){
        return dataPeliculas;
    }
    
    public List<Factura> getListFactura(){
        return dataFacturas;
    }
    
    public void OpenSalaJson(String sala){       
        asientoListModel = new AsientoListModel(sala);
        asientoListModel.loadFromJson();
    }
    
    public void saveSalaJson(){
        asientoListModel.writeToJson();
    }
    
    public List<Asiento> getListAsiento(){
        return asientoListModel.getList();
    }
    
    public void writeJsonFacturas(Factura f){
        FileWriter fw = null;
        try {
            Gson gson = new Gson();
            dataFacturas.add(f);
            fw = new FileWriter("./src/main/resources/Data/Facturas.json");
            fw.write(gson.toJson(dataFacturas));
            System.out.println("BOOOM 1");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FacturaListModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FacturaListModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
    }
    
    public boolean LoadFromJsonFacturas(){
        try {
            Gson gson = new Gson();
            BufferedReader br;
            
            br = new BufferedReader(new FileReader("./src/main/resources/Data/Facturas.json"));
            if (!(br.readLine() == null)){
                dataFacturas.addAll(Arrays.asList(gson.fromJson(new FileReader("./src/main/resources/Data/Facturas.json"), Factura[].class)));
                return true;
            }else{
                return false;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaListModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacturaListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void LoadFromJsonPeliculas(){
        Gson gson = new Gson();
        try {
            dataPeliculas.addAll(Arrays.asList(gson.fromJson(new FileReader("./src/main/resources/Data/PeliculasDisponibles.json"), Pelicula[].class)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public void getPeliculasObList(ObservableList<Pelicula> obList){
        for (Pelicula c: dataPeliculas) {
            obList.add(new MovieTableModel(index,c.getTitulo(),c.getDirector(),c.getDuracion(),c.getFuncion().toString(),c.getCalificacion(),"No"));
            ++index;
        }
    }*/

    /*public void getCarteleraObList(ObservableList<Pelicula> obList){
        for (Pelicula c: dataPeliculas) {
            obList.add(new MovieTableModel(index,c.getTitulo(),c.getDirector(),c.getDuracion(),c.getFuncion().toString(),c.getCalificacion()));
            ++index;
        }
    }*/
    
}
