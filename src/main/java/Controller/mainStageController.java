package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.loadFXML;

public class mainStageController implements Initializable {
    double x;
    double y;
    Stage stage;
    @FXML
    private AnchorPane contentPane;

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
    void inicioButton(MouseEvent event) throws IOException {
        Node child = loadFXML("dashboardStage");
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }

    @FXML
    void historyButton(MouseEvent event) throws IOException {
        Node child = loadFXML("historyStage");
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }

    @FXML
    void facturaButton(MouseEvent event) throws IOException {
        Node child = loadFXML("facturaStage");
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }

    @FXML
    void menuButton(MouseEvent event) throws IOException {
        Node child = loadFXML("menuStage");
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }

    @FXML
    void empleadosButton(MouseEvent event) throws IOException {
        Node child = loadFXML("empleadosStage");
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }

    @FXML
    void peliculasButton(MouseEvent event) throws IOException {
        Node child = loadFXML("peliculasStage");
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }

    @FXML
    void logoutButton(MouseEvent event) throws IOException {
        close(event);
        stage = new Stage();
        stage.setScene(new Scene(loadFXML("loginStage")));
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node child = null;
        try {
            child = loadFXML("dashboardStage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }
}
