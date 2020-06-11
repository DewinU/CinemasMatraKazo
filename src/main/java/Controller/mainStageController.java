package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class mainStageController {
    Stage stage;

    @FXML
    ComboBox<String> funciones;

    @FXML
    private TextField salaTxt;

    @FXML
    private TextField cantidadTxt;



    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void minus(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void movieSelection(ActionEvent e) {

        String tanda = funciones.getValue();

        switch (tanda) {
            case "Funcion 10:00 AM - 11:30 PM":
            case "Funcion 3:00 AM - 4:30 PM":
                salaTxt.setText("Sala A");
                break;
            case "Funcion 11:30 AM - 1:30 PM":
                salaTxt.setText("Sala F");
                break;
            case "Funcion 1:30 AM - 3:00 PM":
            case "Funcion 4:30 AM - 6:00 PM":
                salaTxt.setText("Sala B");
                break;
            default:
                salaTxt.setText("Sala D");
                break;
        }
    }
}

