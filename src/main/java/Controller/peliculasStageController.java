package Controller;

import Model.*;
import Pojo.Pelicula;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class peliculasStageController implements Initializable {
    FacturaListModel peliculas = new FacturaListModel();
    ObservableList<Pelicula> movieList;

    @FXML
    private ImageView movieImageView;

    @FXML
    private Text txtTitulo;

    @FXML
    private Text txtDuracion;

    @FXML
    private Text txtGenero;

    @FXML
    private Text txtDesde;

    @FXML
    private Text txtFuncion;

    @FXML
    private Text txtHasta;

    @FXML
    private Text txtDirector;

    @FXML
    private Text txtDescripcion;

    @FXML
    private JFXTextField txtBuscar;


    @FXML
    private TableView<Pelicula> moviesView;

    @FXML
    private TableColumn<Pelicula, Integer> pelicula_ID;

    @FXML
    private TableColumn<Pelicula, String > pelicula_TITULO;

    @FXML
    private TableColumn<Pelicula, String > pelicula_DIRECTOR;

    @FXML
    private TableColumn<Pelicula, String > pelicula_GENERO;

    @FXML
    private TableColumn<Pelicula, String > pelicula_FUNCIONES;

    @FXML
    private TableColumn<Pelicula, String > pelicula_CATEGORIA;

    @FXML
    private TableColumn<Pelicula, String > pelicula_CARTELERA;

    @FXML
    void buttonDelete(MouseEvent event) {

    }

    @FXML
    void buttonEdit(MouseEvent event) {

    }

    @FXML
    void buttonNew(MouseEvent event) {
        List<String> salas = new ArrayList<>();
        salas.add("Sala 1");
        salas.add("Sala 2");
        Pelicula newPelicuala = new Pelicula("Dewin","2019","PG-13","2020-05-30","124 Min","Accion","Prueba de Agregar","Esta es una prueba","/src/main/reources/image/Combo.png","100%",salas,salas,false,
                LocalDate.now(), LocalDate.now());
        movieList.add(newPelicuala);
        moviesView.setItems(movieList);

        Gson gson = new Gson();

        try {
            FileWriter writer = new FileWriter("./src/main/resources/Data/PeliculasDisponibles.json");
            writer.write(gson.toJson(movieList));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AsientoListModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void showMovie(MouseEvent event) {
        Pelicula pelicula = moviesView.getSelectionModel().getSelectedItem();
        movieImageView.setImage(new Image(pelicula.getFotoUrl()));
        txtTitulo.setText(pelicula.getTitulo());
        txtDirector.setText(pelicula.getDirector());
        txtDescripcion.setText(pelicula.getDescripcion());
        txtDuracion.setText(pelicula.getDuracion());
        txtGenero.setText(pelicula.getGenero());
        String funciones = "";
        for(int i = 0; i < pelicula.getFuncion().size() - 1; i++){
            funciones += pelicula.getFuncion().get(i) + "\n";
        }
        funciones +=  pelicula.getFuncion().get(pelicula.getFuncion().size() - 1);
        txtFuncion.setText(funciones);
        /*txtDesde.setText(pelicula.getDesde().toString());
        txtHasta.setText(pelicula.getHasta().toString());*/


    }

    public void filterTextField() {

        FilteredList<Pelicula> filteredPeliculas = new FilteredList<>(movieList);
        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPeliculas.setPredicate((Predicate<? super Pelicula>) pelicula -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCase = newValue.toLowerCase();

                if (pelicula.getTitulo().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (pelicula.getDirector().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (pelicula.getGenero().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (pelicula.getFuncion().toString().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (pelicula.getCategoria().toLowerCase().contains(lowerCase)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Pelicula> sortedList = new SortedList<>(filteredPeliculas);
        sortedList.comparatorProperty().bind(moviesView.comparatorProperty());
        moviesView.setItems(sortedList);


    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        peliculas.LoadFromJsonPeliculas();
        movieList = FXCollections.observableArrayList(peliculas.getListPelicula());


        pelicula_ID.setCellValueFactory(data -> {
            int index = movieList.indexOf(data.getValue());
            return new SimpleIntegerProperty(++index).asObject();
        });
        pelicula_TITULO.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        pelicula_DIRECTOR.setCellValueFactory(new PropertyValueFactory<>("director"));
        pelicula_GENERO.setCellValueFactory(new PropertyValueFactory<>("genero"));
        pelicula_FUNCIONES.setCellValueFactory(new PropertyValueFactory<>("funcion"));
        pelicula_CATEGORIA.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        pelicula_CARTELERA.setCellValueFactory(data -> {
            boolean isCartelera = data.getValue().isCarteleraStatus();
            if(isCartelera){
                return new SimpleStringProperty("Sí");
            }
            else{
                return new SimpleStringProperty("No");
            }
        });
        moviesView.setItems(movieList);
        filterTextField();

    }
}
