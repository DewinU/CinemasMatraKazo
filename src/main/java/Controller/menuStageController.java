package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class menuStageController implements Initializable {
    @FXML
    private AnchorPane contentPane;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contentPane.setStyle("-fx-border-color: #000000");

    }
}
