/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.Asiento;
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
public class AsientoListModel {
    
    List<Asiento> data;

    public AsientoListModel() {
        this.data = new ArrayList<>();
    }

    public List<Asiento> getList() {
        return data;
    }
    
    public void writeToJson() {
        Gson gson = new Gson();
        
        try {
            FileWriter writer = new FileWriter("./src/main/resources/Data/SalaDefault.json");
            writer.write(gson.toJson(data));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AsientoListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void createDataJson(){
        // hay 46 asientos
        int  A = 1, B = 1, C = 1, D = 1, E = 1, F = 0, G = 0;
        for(int i = 0; i < 45; i++ ){
            Asiento asiento = new Asiento();
            
            if(i <= 5){
                asiento.setNombre("Asiento A" + A);
                asiento.setId(i);
                asiento.setOcupado(false);
                A++;
            }else if(i > 5 && i <= 11){
                asiento.setNombre("Asiento B" + B);
                asiento.setId(i);
                asiento.setOcupado(false);
                B++;
            }else if(i > 11 && i <= 17){
                asiento.setNombre("Asiento C" + C);
                asiento.setId(i);
                asiento.setOcupado(false);
                C++;
            }else if(i > 17 && i <= 23){
                asiento.setNombre("Asiento D" + D);
                asiento.setId(i);
                asiento.setOcupado(false);
                D++;
            }else if(i > 23 && i <= 29){
                asiento.setNombre("Asiento E" + E);
                asiento.setId(i);
                asiento.setOcupado(false);
                E++;
            }else if(i > 29 && i <= 37){
                asiento.setNombre("Asiento F" + F);
                asiento.setId(i);
                asiento.setOcupado(false);
                F++;
            }else if(i > 37 && i <= 45){
                asiento.setNombre("Asiento G" + G);
                asiento.setId(i);
                asiento.setOcupado(false);
                G++;
            }
            
            data.add(asiento);
        }
        writeToJson();
    }
    public void loadFromJson(){
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/Data/SalaDefault.json"));
            if(!(br.readLine() == null)){
                data.addAll(Arrays.asList(gson.fromJson(new FileReader("./src/main/resources/Data/SalaDefault.json"), Asiento[].class)));
            }else{
                createDataJson();
                loadFromJson();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error con el loadFromJson");
        } catch (IOException ex) {
            Logger.getLogger(AsientoListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
