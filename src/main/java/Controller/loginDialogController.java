package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginDialogController implements Initializable {

    private File selectedImage;
    @FXML
    private ImageView uploadedImage;

    ObservableList<String> funcionesSala1 = FXCollections.observableArrayList("8:00","10:00","12:00");
    ObservableList<String> funcionesSala2 = FXCollections.observableArrayList("14:00","16:00","18:00");
    ObservableList<String> funcionesSala3 = FXCollections.observableArrayList("20:00","22:00","24:00");
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
    private Text lblHaste;

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
                lblYear.setText(txtYear.getText());
                break;
        }


    }

    @FXML
    void uploadImageClick(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        selectedImage = fc.showOpenDialog(null);
        if (selectedImage == null)
            return;
        else if (ImageIO.read(selectedImage) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please upload an image in JPG or PNG format!",
                    ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                return;
            }
        } else {
            Image img = SwingFXUtils.toFXImage(ImageIO.read(selectedImage), null);
            uploadedImage.setImage(img);
        }
        txtURL.setText(selectedImage.getName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtSala1.setItems(funcionesSala1);
        txtSala2.setItems(funcionesSala2);
        txtSala3.setItems(funcionesSala3);
        cmbGenero.setItems(generos);
        cmbRestriccion.setItems(restricciones);

    }
}
