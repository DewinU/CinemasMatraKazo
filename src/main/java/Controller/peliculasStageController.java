package Controller;

import Model.UserTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class peliculasStageController implements Initializable {
    @FXML
    private AnchorPane contentPane;

    ObservableList<UserTableModel> obList = FXCollections.observableArrayList();

    @FXML
    private TableView<?> carteleraView;

    @FXML
    private TableView<?> moviesView;

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
        contentPane.setStyle("-fx-border-color: #000000");
    }
}
