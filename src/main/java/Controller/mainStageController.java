package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.loadFXML;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
    @FXML
    private AnchorPane AnchorPaneNUevaFactura;

    public static boolean activoHilo;
    
    static ExecutorService threadPool;
    static Runnable task1;
    static Runnable task2;
    
    @FXML
    private Button cancelarFacturaButtom;
    
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
        
        activoHilo = true;
        
//Tarea 1, animacion de nueva factura
        threadPool = Executors.newFixedThreadPool(1);
        task1 = () -> {

            //Ponemos invisibles los componentes del main
            inicioButton.setVisible(false);
            menuButton.setVisible(false);
            historyButton.setVisible(false);
            logoutButton.setVisible(false);
            peliculasButton.setVisible(false);
            empleadosButton.setVisible(false);
            welcomeText.setVisible(false);

            //Movemos hacia arriba el boton
            double i = facturaButton.getLayoutY(); 
            for (; i > 100; i--) {
                facturaButton.setLayoutY(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    System.out.println("Hilo interrumpido");
                }
            }
            //hacemos visible el anchorpane con los componentes
            AnchorPaneNUevaFactura.setVisible(true);
        };
        
//Tarea 2, animacion de cancelar factura
        task2 = () -> {
            //hacemos invisible el anchorpane
            AnchorPaneNUevaFactura.setVisible(false);
            //MOvemos hacia abajo el boton
            double i = facturaButton.getLayoutY();
            for(; i <= 340; i++ ){
                facturaButton.setLayoutY(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(mainStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Ponemos invisibles los componentes del main
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
    private void cancelarFacturaButtomOnAction(ActionEvent event) {
        if(!activoHilo){
            threadPool.execute(task2);
            facturaStageController.cancelarMainEvent(true);
            activoHilo = true;
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
        class AnimacionGustabito extends Thread{
        
        public AnimacionGustabito(){
            
        }

        @Override
        public void run() {
            if(activoHilo){
                
            }else{
                
            }
        }
        
        
    }

}
