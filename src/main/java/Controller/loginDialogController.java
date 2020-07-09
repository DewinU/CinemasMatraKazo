package Controller;

import Model.MovieListModel;
import Pojo.Pelicula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class loginDialogController implements Initializable {

    private Pelicula pelicula;
    private boolean editState;
    private double x;
    private double y;
    private Stage stage;
    private int peliculaIndex;
    private MovieListModel movieListModel;

    @FXML
    private ImageView uploadedImage;

    ObservableList<String> funcionesSala1 = FXCollections.observableArrayList("-","8:00","10:00","12:00");
    ObservableList<String> funcionesSala2 = FXCollections.observableArrayList("-","14:00","16:00","18:00");
    ObservableList<String> funcionesSala3 = FXCollections.observableArrayList("-","20:00","22:00","24:00");
    ObservableList<String> generos = FXCollections.observableArrayList("Acción","Adventura","Suspenso","Romance","Comedia");
    ObservableList<String> restricciones = FXCollections.observableArrayList("G","PG","PG-13","R","NC-17");
    @FXML
    private Text lblTitulo;

    @FXML
    private Text lblDescripcion;

    @FXML
    private Text lblGenero;

    @FXML
    private Text lblYear;

    @FXML
    private Text lblRestriccion;

    @FXML
    private Text lblDirector;

    @FXML
    private Text lblFuncion1;

    @FXML
    private Text lblFuncion2;

    @FXML
    private Text lblFuncion3;

    @FXML
    private Text lblDesde;

    @FXML
    private Text lblHasta;

    @FXML
    private Text lblCalificacion;

    @FXML
    private TextField txtURL;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtDirector;

    @FXML
    private TextField txtYear;

    @FXML
    private ComboBox<String> cmbRestriccion;

    @FXML
    private ComboBox<String> cmbGenero;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private DatePicker txtDesde;

    @FXML
    private DatePicker txtHasta;

    @FXML
    private TextField txtCalificacion;

    @FXML
    private ComboBox<String> txtSala1;

    @FXML
    private ComboBox<String> txtSala2;

    @FXML
    private ComboBox<String> txtSala3;

    @FXML
    void updateText(KeyEvent e) {
        switch (((Node) e.getSource()).getId()) {
            case "txtTitulo":
                lblTitulo.setText(txtTitulo.getText());
                break;
            case "txtDescripcion":
                lblDescripcion.setText(txtDescripcion.getText());
                break;
            case "txtDirector":
                lblDirector.setText(txtDirector.getText());
                break;
            case "txtYear":
                lblYear.setText("(" + txtYear.getText() + ")");
                break;
            case "cmbRestriccion":
                lblRestriccion.setText(cmbRestriccion.getValue());
                break;
            case "cmbGenero":
                lblGenero.setText(cmbGenero.getValue());
                break;

            case "txtCalificacion":
                lblCalificacion.setText("(" + txtCalificacion.getText() + "%)");
        }


    }



    @FXML
    void dragged(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void exit(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void updateDateAndTime(ActionEvent e) {
        switch (((Node) e.getSource()).getId()) {
            case "cmbRestriccion":
                lblRestriccion.setText(cmbRestriccion.getValue());
                break;
            case "cmbGenero":
                lblGenero.setText(cmbGenero.getValue());
                break;
            case "txtDesde":
                lblDesde.setText(txtDesde.getValue().toString());
                break;

            case "txtHasta":
                lblHasta.setText(txtHasta.getValue().toString());
                break;
            case "txtSala1":
                lblFuncion1.setText(txtSala1.getValue());
                break;
            case "txtSala2":
                lblFuncion2.setText(txtSala2.getValue());
                break;
            case "txtSala3":
                lblFuncion3.setText(txtSala3.getValue());
        }
    }



    public  void isEdit(Pelicula pelicula,boolean state, int index){
        txtURL.setText(pelicula.getFotoUrl());
        txtTitulo.setText(pelicula.getTitulo());
        txtDirector.setText(pelicula.getDirector());
        txtYear.setText(pelicula.getAnio());
        cmbRestriccion.setValue(pelicula.getCategoria());
        cmbGenero.setValue(pelicula.getGenero());
        txtDescripcion.setText(pelicula.getDirector());
        txtCalificacion.setText(pelicula.getCalificacion());
        txtSala1.setValue(pelicula.getFuncion().get(0));
        txtSala2.setValue(pelicula.getFuncion().get(1));
        txtSala3.setValue(pelicula.getFuncion().get(2));
        txtDesde.setValue(pelicula.getDesde());
        txtHasta.setValue(pelicula.getHasta());
        editState = state;
        peliculaIndex = index;
        uploadedImage.setImage(new Image(new File(pelicula.getFotoUrl()).toURI().toString()));
        lblTitulo.setText(pelicula.getTitulo());
        lblDirector.setText(pelicula.getDirector());
        lblYear.setText("(" + pelicula.getAnio() + ")");
        lblRestriccion.setText(pelicula.getCategoria());
        lblGenero.setText(pelicula.getGenero());
        lblDescripcion.setText(pelicula.getDescripcion());
        lblCalificacion.setText("(" + pelicula.getCalificacion() + "%)");
        lblFuncion1.setText(pelicula.getFuncion().get(0));
        lblFuncion2.setText(pelicula.getFuncion().get(1));
        lblFuncion3.setText(pelicula.getFuncion().get(2));
        lblDesde.setText(pelicula.getDesde().toString());
        lblHasta.setText(pelicula.getHasta().toString());
    }

    private List<String> getTxtSala(){
        List<String> salas = new ArrayList<>();
        for(int i = 0; i < getFunciones().size(); i++){
            {
                salas.add("Sala " + (i+1) );
            }
        }
        return salas;
    }

    private List<String> getFunciones(){
        List<String> funciones = new ArrayList<>();
        funciones.add(txtSala1.getValue());
        funciones.add(txtSala2.getValue());
        funciones.add(txtSala3.getValue());
        return  funciones;
    }



    @FXML
    void addButton(MouseEvent event) throws IOException{
        try {
            saveToFile(uploadedImage);
            pelicula = new Pelicula(txtTitulo.getText(),txtYear.getText(),cmbRestriccion.getValue(),cmbGenero.getValue(),
                    txtDirector.getText(),txtDescripcion.getText(),getImagePath(),txtCalificacion.getText()
                    ,getTxtSala(),getFunciones(),true,txtDesde.getValue(),txtHasta.getValue());

            if(editState){
                peliculasStageController.movieList.set(peliculaIndex,pelicula);
            }
            else{
                validatePelicula();
                peliculasStageController.movieList.add(pelicula);
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            movieListModel.updateJson(peliculasStageController.movieList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "La operación se ha hecho con exito", ButtonType.OK);
            alert.showAndWait();
        }
        catch (InvalidFilmInputException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }
    }

    public void saveToFile(ImageView image) throws IOException {
        String folderPath = "./src/main/resources/Movies/";
        File imageFile = new File(folderPath, txtTitulo.getText() + ".png");
        BufferedImage bImage = SwingFXUtils.fromFXImage(image.getImage(), null);
        ImageIO.write(bImage, "png", imageFile);
    }

    public String getImagePath(){
        return "./src/main/resources/Movies/" + txtTitulo.getText() + ".png";
    }

    @FXML
    void cancelButton(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.WARNING, "¿Esta seguro que desea cancelar?", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            alert.close();
            stage.close();
        }
    }

    @FXML
    void imageFromWeb(MouseEvent event) {
        try{
            Image internetImage = new Image(txtURL.getText());
            uploadedImage.setImage(internetImage);
        }
        catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(),
                    ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                return;
            }
        }
    }


    @FXML
    void uploadImageClick(MouseEvent event) throws IllegalArgumentException, IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter
                        ("Image files (*.jpg, *.jpeg,  *.png)", "*.png", "*.jpg", "*.jpeg"));
        File selectedImage = fc.showOpenDialog(null);
        if (selectedImage == null)
            return;
        Image img = SwingFXUtils.toFXImage(ImageIO.read(selectedImage), null);
        uploadedImage.setImage(img);
        txtURL.setText(selectedImage.getPath());
    }


    private void validatePelicula() throws InvalidFilmInputException {
        try {
            if (txtURL.getText().equals("") || txtTitulo.getText().equals("")
                    || txtDirector.equals("") || txtYear.getText().equals("")
                    || cmbRestriccion.getValue().equals("") || cmbGenero.getValue().equals("")
                    || txtDescripcion.getText().equals("") || txtCalificacion.getText().equals("")
                    || txtSala1.getValue().equals("HH:MM") || txtSala2.getValue().equals("HH:MM")
                    || txtSala3.getValue().equals("HH:MM")
                    || txtDesde.getValue().equals("YYYY-MM-DD")
                    || txtHasta.getValue().equals("YYYY-MM-DD"))
                throw new InvalidFilmInputException("Porfavor llene todos los campos!");
            else if (txtDesde.getValue().compareTo(LocalDate.now()) < 0)
                throw new InvalidFilmInputException("Fecha de inicio no puede ser antes de ahora!");
            else if (txtDesde.getValue().compareTo(txtHasta.getValue()) == 0)
                throw new InvalidFilmInputException("El tiempo de una película en cartelera no puede terminar en el mismo día!");
            else if (txtDesde.getValue().compareTo(txtHasta.getValue()) > 0)
                throw new InvalidFilmInputException("La fecha de culminación no puede ser antes de la fecha de incion");

            // checking that the title of the movie is unique
            for (Pelicula c : movieListModel.getPeliculasAll()) {
                if (c.getTitulo().equals(txtTitulo.getText()))
                    throw new InvalidFilmInputException(
                            "The title " + txtTitulo.getText() + " belongs to another scheduled movie!");

                if(!(txtDesde.getValue().compareTo(c.getHasta()) > 0 ||
                        txtHasta.getValue().compareTo(c.getHasta()) > 0 ))
                {
                    if((c.getFuncion().contains(txtSala1.getValue()) && !txtSala1.getValue().equals("-")) ||
                            (c.getFuncion().contains(txtSala2.getValue()) && !txtSala2.getValue().equals("-"))  ||
                            (c.getFuncion().contains(txtSala3.getValue()) && !txtSala3.getValue().equals("-"))){
                        throw new InvalidFilmInputException("The screening time(s) of your film: " + txtTitulo.getText()
                                + " overlap(s) with the film: " + c.getTitulo() + "!");

                    }
                }
            }
        } catch (NullPointerException e) {
            throw new InvalidFilmInputException("Porfavor llena todos los campos!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        movieListModel = new MovieListModel();
        txtSala1.setItems(funcionesSala1);
        txtSala2.setItems(funcionesSala2);
        txtSala3.setItems(funcionesSala3);
        cmbGenero.setItems(generos);
        cmbRestriccion.setItems(restricciones);
    }


}

class InvalidFilmInputException extends Exception {

    private static final long serialVersionUID = 1L;

    InvalidFilmInputException(String s) {
        super(s);
    }
}
