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
    ObservableList<MovieTableModel> carteleraList = FXCollections.observableArrayList();
    ObservableList<MovieTableModel> movieList = FXCollections.observableArrayList();

    @FXML
    private AnchorPane contentPane;

    @FXML
    private TableView<MovieTableModel> carteleraView;

    @FXML
    private TableColumn<MovieTableModel, Integer> cartelera_ID;

    @FXML
    private TableColumn<MovieTableModel, String> cartelera_TITULO;

    @FXML
    private TableColumn<MovieTableModel, String> cartelera_DIRECTOR;

    @FXML
    private TableColumn<MovieTableModel, String> cartelera_FUNCIONES;

    @FXML
    private TableColumn<MovieTableModel, String> cartelera_CLASIFICACION;

    @FXML
    private TableView<MovieTableModel> moviesView;

    @FXML
    private TableColumn<MovieTableModel, Integer> pelicula_ID;

    @FXML
    private TableColumn<MovieTableModel, String > pelicula_TITULO;

    @FXML
    private TableColumn<MovieTableModel, String > pelicula_DIRECTOR;

    @FXML
    private TableColumn<MovieTableModel, String > pelicula_DURACION;

    @FXML
    private TableColumn<MovieTableModel, String > pelicula_FUNCIONES;

    @FXML
    private TableColumn<MovieTableModel, String > pelicula_CLASIFICACION;

    @FXML
    private TableColumn<MovieTableModel, String > pelicula_CARTELERA;

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
        peliculas.getCarteleraObList(carteleraList);
        peliculas.getPeliculasObList(movieList);

        cartelera_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cartelera_TITULO.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        cartelera_DIRECTOR.setCellValueFactory(new PropertyValueFactory<>("director"));
        cartelera_FUNCIONES.setCellValueFactory(new PropertyValueFactory<>("funciones"));
        cartelera_CLASIFICACION.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
        carteleraView.setItems(carteleraList);

        pelicula_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        pelicula_TITULO.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        pelicula_DIRECTOR.setCellValueFactory(new PropertyValueFactory<>("director"));
        pelicula_DURACION.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        pelicula_FUNCIONES.setCellValueFactory(new PropertyValueFactory<>("funciones"));
        pelicula_CLASIFICACION.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
        pelicula_CARTELERA.setCellValueFactory(new PropertyValueFactory<>("cartelera"));
        moviesView.setItems(movieList);

    }
}
