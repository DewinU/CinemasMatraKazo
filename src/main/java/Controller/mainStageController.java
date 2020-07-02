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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class mainStageController implements Initializable {
    double x;
    double y;
    Stage stage;
    
    
    
    @FXML
    private AnchorPane contentPane;
    @FXML
    private HBox windowsBar;
    @FXML
    public Button inicioButton;
    @FXML
    private Button menuButton;
    @FXML
    private Button facturaButton;
    @FXML
    private Button historyButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button peliculasButton;
    @FXML
    private Button empleadosButton;
    @FXML
    private Text welcomeText;

    public static boolean activoHilo;
    
    static ExecutorService threadPool;
    static Runnable task1;
    static Runnable task2;
    
    
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
        

        threadPool = Executors.newCachedThreadPool();
        task1 = () -> {
            
            inicioButton.setVisible(false);
            menuButton.setVisible(false);
            historyButton.setVisible(false);
            logoutButton.setVisible(false);
            peliculasButton.setVisible(false);
            empleadosButton.setVisible(false);
            welcomeText.setVisible(false);

            facturaButton.setLayoutY(100);
        };
        

        task2 = () -> {

            facturaButton.setLayoutY(340);

            inicioButton.setVisible(true);
            menuButton.setVisible(true);
            historyButton.setVisible(true);
            logoutButton.setVisible(true);
            peliculasButton.setVisible(true);
            empleadosButton.setVisible(true);
            welcomeText.setVisible(true);
        };
    }
    
    public static void NuevaFacturaMainStageEvent(boolean a){
        if(a){
            if(activoHilo){
               threadPool.execute(task1); 
               activoHilo = false;
            }
        }
    }


    @FXML
    void close(MouseEvent event) {
        threadPool.shutdown();
        facturaStageController.threadPool.shutdown();
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

}
