package Controller;

import Model.*;
import Pojo.Pelicula;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class peliculasStageController implements Initializable {
    FacturaListModel peliculas = new FacturaListModel();
    ObservableList<Pelicula> movieList;


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
    private TableColumn<Pelicula, Boolean > pelicula_CARTELERA;

    @FXML
    void buttonDelete(MouseEvent event) {

    }

    @FXML
    void buttonEdit(MouseEvent event) {

    }

    @FXML
    void buttonNew(MouseEvent event) {

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
        pelicula_CARTELERA.setCellValueFactory(new PropertyValueFactory<>("peliculaStatus"));
        moviesView.setItems(movieList);

    }
}
