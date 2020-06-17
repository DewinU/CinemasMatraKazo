package Controller;

import static Main.App.loadFXML;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Pojo.Database;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginStageController implements Initializable {
    double x,y;
    Stage stage;
    Database database;  
    @FXML
    private MaterialDesignIconView account;
    @FXML
    TextField userTxtField;
    @FXML
    PasswordField passwordTxtField;

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
    void minus(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void checkLogin(MouseEvent event) throws SQLException, IOException {
        String username = userTxtField.getText();
        String password = passwordTxtField.getText();
        if(database.is_register(username, password)){
            close(event);
            stage = new Stage();
            stage.setScene(new Scene(loadFXML("mainStage")));
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        }
        else{
            userTxtField.getStyleClass().add("error-text-field");
            passwordTxtField.getStyleClass().add("error-text-field");
            userTxtField.clear();
            passwordTxtField.clear();
            account.setStyle("-fx-fill: #ffbbbb");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            database = new Database();
        } catch (SQLException e) {}
    }
}
