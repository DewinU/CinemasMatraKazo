package Controller;

import Model.*;
import Pojo.Pelicula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class peliculasStageController implements Initializable {
    FacturaListModel peliculas = new FacturaListModel();
    ObservableList<Pelicula> movieList;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private TableView<Pelicula> carteleraView;

    @FXML
    private TableColumn<Pelicula, Integer> cartelera_ID;

    @FXML
    private TableColumn<Pelicula, String> cartelera_TITULO;

    @FXML
    private TableColumn<Pelicula, String> cartelera_DIRECTOR;

    @FXML
    private TableColumn<Pelicula, String> cartelera_DURACION;

    @FXML
    private TableColumn<Pelicula, String> cartelera_FUNCIONES;

    @FXML
    private TableColumn<Pelicula, String> cartelera_CLASIFICACION;

    @FXML
    private TableView<Pelicula> moviesView;

    @FXML
    private TableColumn<Pelicula, Integer> pelicula_ID;

    @FXML
    private TableColumn<Pelicula, String > pelicula_TITULO;

    @FXML
    private TableColumn<Pelicula, String > pelicula_DIRECTOR;

    @FXML
    private TableColumn<Pelicula, String > pelicula_DURACION;

    @FXML
    private TableColumn<Pelicula, String > pelicula_FUNCIONES;

    @FXML
    private TableColumn<Pelicula, String > pelicula_CLASIFICACION;

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

        Bind(cartelera_ID, cartelera_TITULO, cartelera_DIRECTOR, cartelera_DURACION, cartelera_FUNCIONES, cartelera_CLASIFICACION);
        carteleraView.setItems(movieList);

        Bind(pelicula_ID, pelicula_TITULO, pelicula_DIRECTOR, pelicula_DURACION, pelicula_FUNCIONES, pelicula_CLASIFICACION);
        pelicula_CARTELERA.setCellValueFactory(new PropertyValueFactory<>("carteleraStatus"));
        moviesView.setItems(movieList);

    }

    private void Bind(TableColumn<Pelicula, Integer> cartelera_id, TableColumn<Pelicula, String> cartelera_titulo, TableColumn<Pelicula, String> cartelera_director, TableColumn<Pelicula, String> cartelera_duracion, TableColumn<Pelicula, String> cartelera_funciones, TableColumn<Pelicula, String> cartelera_clasificacion) {
        cartelera_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cartelera_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        cartelera_director.setCellValueFactory(new PropertyValueFactory<>("director"));
        cartelera_duracion.setCellValueFactory(new PropertyValueFactory<>("genero"));
        cartelera_funciones.setCellValueFactory(new PropertyValueFactory<>("funcion"));
        cartelera_clasificacion.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    }
}
