package Controller;

import Model.*;
import Pojo.Pelicula;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static Main.App.loadFXML;

public class peliculasStageController implements Initializable {
    private MovieListModel moviesListModel;
    public static ObservableList<Pelicula> movieList;

    Alert alerta;
    File imageFile;
    @FXML
    private ImageView movieImageView;

    @FXML
    private Text txtTitulo;

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
    private TableColumn<Pelicula, LocalDate> pelicula_DESDE;

    @FXML
    private TableColumn<Pelicula, LocalDate> pelicula_HASTA;

    @FXML
    void buttonDelete(MouseEvent event) {
        Pelicula pelicula = moviesView.getSelectionModel().getSelectedItem();
        if(pelicula == null){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Vaya!");
            alerta.setContentText("Debes elegir una película a eliminar! ");
            alerta.show();
        }

        else{
            alerta = new Alert(Alert.AlertType.CONFIRMATION,"¿Seguro que desea eliminar esta pelicula?",ButtonType.YES,ButtonType.NO);
            alerta.showAndWait();
            if(alerta.getResult() == ButtonType.YES){
                movieList.remove(pelicula);
                moviesListModel.updateJson(movieList);
            }

        }
    }

    @FXML
    void buttonEdit(MouseEvent event) throws IOException {
        Pelicula pelicula = moviesView.getSelectionModel().getSelectedItem();
        if(pelicula == null){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Vaya!");
            alerta.setContentText("Debes elegir una película a eliminar! ");
            alerta.show();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/loginDialog.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            fxmlLoader.setLocation(getClass().getResource("/Views/loginDialog.fxml"));
            loginDialogController loginDlg = fxmlLoader.getController();
            loginDlg.isEdit(moviesView.getSelectionModel().getSelectedItem(),true,moviesView.getSelectionModel().getSelectedIndex());
            moviesListModel.updateJson(movieList);
            moviesView.refresh();
        }
    }


    @FXML
    void buttonNew(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/loginDialog.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        fxmlLoader.setLocation(getClass().getResource("/Views/loginDialog.fxml"));
    }

    @FXML
    void showMovie(MouseEvent event){
        Pelicula pelicula = moviesView.getSelectionModel().getSelectedItem();
        if(pelicula != null){
            imageFile = new File(pelicula.getFotoUrl());
            movieImageView.setImage(new Image(imageFile.toURI().toString()));
            txtTitulo.setText(pelicula.getTitulo());
            txtDirector.setText(pelicula.getDirector());
            txtDescripcion.setText(pelicula.getDescripcion());
            txtGenero.setText(pelicula.getGenero());
            String funciones = "";
            for(int i = 0; i < pelicula.getFuncion().size() - 1; i++){
                funciones += pelicula.getFuncion().get(i) + "\n";
            }
            funciones +=  pelicula.getFuncion().get(pelicula.getFuncion().size() - 1);
            txtFuncion.setText(funciones);
            txtDesde.setText(pelicula.getDesde().toString());
            txtHasta.setText(pelicula.getHasta().toString());
        }

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
        moviesListModel = new MovieListModel();
        movieList = FXCollections.observableArrayList(moviesListModel.getPeliculasAll());
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
        pelicula_DESDE.setCellValueFactory(new PropertyValueFactory<>("desde"));
        pelicula_HASTA.setCellValueFactory(new PropertyValueFactory<>("hasta"));
        moviesView.setItems(movieList);
        filterTextField();
    }
}
