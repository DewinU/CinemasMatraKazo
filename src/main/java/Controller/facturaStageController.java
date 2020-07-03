package Controller;

import Model.FacturaListModel;
import Pojo.Asiento;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class facturaStageController implements Initializable {

    @FXML
    private AnchorPane contentPane;
    @FXML
    private Button A1;
    @FXML
    private ImageView imgA1;
    @FXML
    private ImageView imgA2;
    @FXML
    private Button A3;
    @FXML
    private ImageView imgA3;
    @FXML
    private Button A4;
    @FXML
    private ImageView imgA4;
    @FXML
    private ImageView imgA5;
    @FXML
    private ImageView imgB1;
    @FXML
    private Button A6;
    @FXML
    private ImageView imgA6;
    @FXML
    private ImageView imgB2;
    @FXML
    private ImageView imgB3;
    @FXML
    private ImageView imgB4;
    @FXML
    private ImageView imgB5;
    @FXML
    private ImageView imgB6;
    @FXML
    private ImageView imgC1;
    @FXML
    private Button C2;
    @FXML
    private ImageView imgC2;
    @FXML
    private Button C3;
    @FXML
    private ImageView imgC3;
    @FXML
    private ImageView imgC4;
    @FXML
    private Button A2;
    @FXML
    private Button A5;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button B4;
    @FXML
    private Button B5;
    @FXML
    private Button B6;
    @FXML
    private Button C1;
    @FXML
    private Button C4;
    @FXML
    private Button C5;
    @FXML
    private ImageView imgC5;
    @FXML
    private Button C6;
    @FXML
    private ImageView imgC6;
    @FXML
    private Button D1;
    @FXML
    private ImageView imgD1;
    @FXML
    private Button D2;
    @FXML
    private ImageView imgD2;
    @FXML
    private Button D3;
    @FXML
    private ImageView imgD3;
    @FXML
    private Button D4;
    @FXML
    private ImageView imgD4;
    @FXML
    private Button D5;
    @FXML
    private ImageView imgD5;
    @FXML
    private Button D6;
    @FXML
    private ImageView imgD6;
    @FXML
    private Button E1;
    @FXML
    private ImageView imgE1;
    @FXML
    private Button E2;
    @FXML
    private ImageView imgE2;
    @FXML
    private Button E3;
    @FXML
    private ImageView imgE3;
    @FXML
    private Button E4;
    @FXML
    private ImageView imgE4;
    @FXML
    private Button F1;
    @FXML
    private ImageView imgF1;
    @FXML
    private Button G1;
    @FXML
    private ImageView imgG1;
    @FXML
    private Button G0;
    @FXML
    private ImageView imgG0;
    @FXML
    private Button F2;
    @FXML
    private ImageView imgF2;
    @FXML
    private Button F3;
    @FXML
    private ImageView imgF3;
    @FXML
    private Button F4;
    @FXML
    private ImageView imgF4;
    @FXML
    private Button G2;
    @FXML
    private ImageView imgG2;
    @FXML
    private Button F0;
    @FXML
    private ImageView imgF0;
    @FXML
    private Button G3;
    @FXML
    private ImageView imgG3;
    @FXML
    private Button G4;
    @FXML
    private ImageView imgG4;
    @FXML
    private Button E5;
    @FXML
    private ImageView imgE5;
    @FXML
    private Button F5;
    @FXML
    private ImageView imgF5;
    @FXML
    private Button G5;
    @FXML
    private ImageView imgG5;
    @FXML
    private Button G6;
    @FXML
    private ImageView imgG6;
    @FXML
    private Button F6;
    @FXML
    private ImageView imgF6;
    @FXML
    private Button E6;
    @FXML
    private ImageView imgE6;
    @FXML
    private Button G7;
    @FXML
    private ImageView imgG7;
    @FXML
    private Button F7;
    @FXML
    private ImageView imgF7;

    static ExecutorService threadPool;
    static Runnable task1;
    static Runnable task2;
    
    @FXML
    private Pane pnlBotonesAsientos;
    @FXML
    private ImageView imgSelectorAsientosPrincipal;
    @FXML
    private Button cancelarFacturaButtom;
    @FXML
    private Button btnContinuar;
    @FXML
    private AnchorPane AnchorPaneNuevaFactura;

    @FXML
    private ComboBox<String> cmbxPelicula;
    
    
    private FacturaListModel facturaList;
    @FXML
    private ComboBox<String> cmbxHoraFunsion;
    @FXML
    private TextField txtSala;
    String titulo = "";
    @FXML
    private Label txtSalaSelector;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contentPane.setStyle("-fx-border-color: #000000");
        facturaList = new FacturaListModel();
        
        
        threadPool = Executors.newCachedThreadPool();

        task1 = () ->{
            
            AnchorPaneNuevaFactura.setVisible(true);
            pnlBotonesAsientos.setVisible(true);
            

        };
        task2 = () ->{
            imgSelectorAsientosPrincipal.setVisible(true);
            //desaparecemos los botones y el img
            for (double b = 1, a = 0; b <= 1 || a >= 1; b+= 0.1, a-= 0.1){
                pnlBotonesAsientos.setOpacity(a);
                imgSelectorAsientosPrincipal.setOpacity(b);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pnlBotonesAsientos.setVisible(false);
            AnchorPaneNuevaFactura.setVisible(false);
            
        };
        
        facturaList.LoadFromJsonPeliculas();
        System.out.println("Pue, no dio error");
        
        threadPool.submit(task1);
        
        facturaList.getListPelicula().forEach((p) -> {
            cmbxPelicula.getItems().add(p.getTitulo());
        });
        
        
        cmbxPelicula.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            for (int i = 0; i < facturaList.getListPelicula().size(); i++){
                if(facturaList.getListPelicula().get(i).getTitulo().equals(newValue)){
                    titulo = newValue;
                    cmbxHoraFunsion.getItems().clear();
                    cmbxHoraFunsion.getItems().addAll(facturaList.getListPelicula().get(i).getFuncion());
                }
            }
        });
        cmbxHoraFunsion.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            for (int i = 0; i < facturaList.getListPelicula().size(); i++) {
                if (facturaList.getListPelicula().get(i).getTitulo().equals(titulo)) {
                    for (int j = 0; j < facturaList.getListPelicula().get(i).getFuncion().size(); j++) {
                        if (facturaList.getListPelicula().get(i).getFuncion().get(j).equals(newValue)) {
                            txtSala.setText(facturaList.getListPelicula().get(i).getSala().get(j));
                            facturaList.OpenSalaJson(titulo + " Funcion " + (j+1) + " " + facturaList.getListPelicula().get(i).getSala().get(j) + ".json");
                            loadAsientoModel();
                            txtSalaSelector.setText(facturaList.getListPelicula().get(i).getSala().get(j));
                            imgSelectorAsientosPrincipal.setVisible(false);
                            break;
                        }
                    }
                }
            }
        });
    }
    //-----------------------------------------------------------------------------------
    
        public void loadAsientoModel(){
            for(Asiento a : facturaList.getListAsiento()){
                if(a.isOcupado()){
                    Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
                    switch(a.getId()){
                         case 0:
                        imgA1.setImage(imagen);
                        A1.setDisable(true);
                        break;
                    case 1:
                        imgA2.setImage(imagen);
                        A2.setDisable(true);
                        break;
                    case 2:
                        imgA3.setImage(imagen);
                        A3.setDisable(true);
                        break;
                    case 3:
                        imgA4.setImage(imagen);
                        A4.setDisable(true);
                        break;
                    case 4:
                        imgA5.setImage(imagen);
                        A5.setDisable(true);
                        break;
                    case 5:
                        imgA6.setImage(imagen);
                        A6.setDisable(true);
                        break;
                    case 6:
                        imgB1.setImage(imagen);
                        B1.setDisable(true);
                        break;
                    case 7:
                        imgB2.setImage(imagen);
                        B2.setDisable(true);
                        break;
                    case 8:
                        imgB3.setImage(imagen);
                        B3.setDisable(true);
                        break;
                    case 9:
                        imgB4.setImage(imagen);
                        B4.setDisable(true);
                        break;
                    case 10:
                        imgB5.setImage(imagen);
                        B5.setDisable(true);
                        break;
                    case 11:
                        imgB6.setImage(imagen);
                        B6.setDisable(true);
                        break;
                    case 12:
                        imgC1.setImage(imagen);
                        C1.setDisable(true);
                        break;
                    case 13:
                        imgC2.setImage(imagen);
                        C2.setDisable(true);
                        break;
                    case 14:
                        imgC4.setImage(imagen);
                        C3.setDisable(true);
                        break;
                    case 15:
                        imgC4.setImage(imagen);
                        C4.setDisable(true);
                        break;
                    case 16:
                        imgC5.setImage(imagen);
                        C5.setDisable(true);
                        break;
                    case 17:
                        imgC6.setImage(imagen);
                        C6.setDisable(true);
                        break;
                    case 18:
                        imgD1.setImage(imagen);
                        D1.setDisable(true);
                        break;
                    case 19:
                        imgD2.setImage(imagen);
                        D2.setDisable(true);
                        break;
                    case 20:
                        imgD3.setImage(imagen);
                        D3.setDisable(true);
                        break;
                    case 21:
                        imgD4.setImage(imagen);
                        D4.setDisable(true);
                        break;
                    case 22:
                        imgD5.setImage(imagen);
                        D5.setDisable(true);
                        break;
                    case 23:
                        imgD6.setImage(imagen);
                        D6.setDisable(true);
                        break;
                    case 24:
                        imgE1.setImage(imagen);
                        E1.setDisable(true);
                        break;
                    case 25:
                        imgE2.setImage(imagen);
                        E2.setDisable(true);
                        break;
                    case 26:
                        imgE3.setImage(imagen);
                        E3.setDisable(true);
                        break;
                    case 27:
                        imgE4.setImage(imagen);
                        E4.setDisable(true);
                        break;
                    case 28:
                        imgE5.setImage(imagen);
                        E5.setDisable(true);
                        break;
                    case 29:
                        imgE6.setImage(imagen);
                        E6.setDisable(true);
                        break;
                    case 30:
                        imgF0.setImage(imagen);
                        F0.setDisable(true);
                        break;
                    case 31:
                        imgF1.setImage(imagen);
                        F1.setDisable(true);
                        break;
                    case 32:
                        imgF2.setImage(imagen);
                        F2.setDisable(true);
                        break;
                    case 33:
                        imgF3.setImage(imagen);
                        F3.setDisable(true);
                        break;
                    case 34:
                        imgF4.setImage(imagen);
                        F4.setDisable(true);
                        break;
                    case 35:
                        imgF5.setImage(imagen);
                        F5.setDisable(true);
                        break;
                    case 36:
                        imgF6.setImage(imagen);
                        F6.setDisable(true);
                        break;
                    case 37:
                        imgF7.setImage(imagen);
                        F7.setDisable(true);
                        break;
                    case 38:
                        imgG0.setImage(imagen);
                        G0.setDisable(true);
                        break;
                    case 39:
                        imgG1.setImage(imagen);
                        G1.setDisable(true);
                        break;
                    case 40:
                        imgG2.setImage(imagen);
                        G2.setDisable(true);
                        break;
                    case 41:
                        imgG3.setImage(imagen);
                        G3.setDisable(true);
                        break;
                    case 42:
                        imgG4.setImage(imagen);
                        G4.setDisable(true);
                        break;
                    case 43:
                        imgG5.setImage(imagen);
                        G5.setDisable(true);
                        break;
                    case 44:
                        imgG6.setImage(imagen);
                        G6.setDisable(true);
                        break;
                    case 45:
                        imgG7.setImage(imagen);
                        G7.setDisable(true);
                        break;
                    default:
                        System.out.println("Error en el switch");
                        break;
                    }
                }
            }
            //            Aparecemos los botones y el img
            for (double a = 0, b = 1; a <= 1 && b>= 0; a+= 0.1, b-= 0.1 ){
                pnlBotonesAsientos.setOpacity(a);
                imgSelectorAsientosPrincipal.setOpacity(b);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            imgSelectorAsientosPrincipal.setVisible(false);
        }
    
    //-----------------------------------------------------------------------------------
    @FXML
    private void cancelarFacturaButtomOnAction(ActionEvent event) {
        threadPool.submit(task2);
    }
  
    //ASIENTOS BOTONES
    //A1    0
    @FXML
    private void A1Exited(MouseEvent event) {
        A1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void A1Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgA1.setImage(imagen);
        facturaList.getListAsiento().get(0).setOcupado(true);
    }

    @FXML
    private void A1Moved(MouseEvent event) {
        A1.setStyle("-fx-background-color: red");
    }

    //A2    1
    @FXML
    private void A2Exited(MouseEvent event) {
        A2.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void A2Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgA2.setImage(imagen);
        facturaList.getListAsiento().get(1).setOcupado(true);
    }

    @FXML
    private void A2Moved(MouseEvent event) {
        A2.setStyle("-fx-background-color: red");
    }

    //A3    2
    @FXML
    private void A3Exited(MouseEvent event) {
        A3.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void A3Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgA3.setImage(imagen);
        facturaList.getListAsiento().get(2).setOcupado(true);
    }

    @FXML
    private void A3Moved(MouseEvent event) {
        A3.setStyle("-fx-background-color: red");
    }

    //A4    3
    @FXML
    private void A4Exited(MouseEvent event) {
        A4.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void A4Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgA4.setImage(imagen);
        facturaList.getListAsiento().get(3).setOcupado(true);
    }

    @FXML
    private void A4Moved(MouseEvent event) {
        A4.setStyle("-fx-background-color: red");
    }

    //A5    4
    @FXML
    private void A5Exited(MouseEvent event) {
        A5.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void A5Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgA5.setImage(imagen);
        facturaList.getListAsiento().get(4).setOcupado(true);
    }

    @FXML
    private void A5Moved(MouseEvent event) {
        A5.setStyle("-fx-background-color: red");
    }

    //A6    5
    @FXML
    private void A6Exited(MouseEvent event) {
        A6.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void A6Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgA6.setImage(imagen);
        facturaList.getListAsiento().get(5).setOcupado(true);
    }

    @FXML
    private void A6Moved(MouseEvent event) {
        A6.setStyle("-fx-background-color: red");
    }
    
    //B1    6
    @FXML
    private void B1Exited(MouseEvent event) {
        B1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void B1Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgB1.setImage(imagen);
        facturaList.getListAsiento().get(6).setOcupado(true);
    }

    @FXML
    private void B1Moved(MouseEvent event) {
        B1.setStyle("-fx-background-color: red");
    }

    //B2    7
    @FXML
    private void B2Exited(MouseEvent event) {
        B2.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void B2Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgB2.setImage(imagen);
        facturaList.getListAsiento().get(7).setOcupado(true);
    }

    @FXML
    private void B2Moved(MouseEvent event) {
        B2.setStyle("-fx-background-color: red");
    }
    
    //B3    8
    @FXML
    private void B3Exited(MouseEvent event) {
        B3.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void B3clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgB3.setImage(imagen);
        facturaList.getListAsiento().get(8).setOcupado(true);
    }

    @FXML
    private void B3Moved(MouseEvent event) {
        B3.setStyle("-fx-background-color: red");
    }

    //B4    9
    @FXML
    private void B4Exited(MouseEvent event) {
        B4.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void B4clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgB4.setImage(imagen);
        facturaList.getListAsiento().get(9).setOcupado(true);
    }

    @FXML
    private void B4Moved(MouseEvent event) {
        B4.setStyle("-fx-background-color: red");
    }

    //B5    10
    @FXML
    private void B5Exited(MouseEvent event) {
       B5.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void B5Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgB5.setImage(imagen);
        facturaList.getListAsiento().get(10).setOcupado(true);
    }

    @FXML
    private void B5Moved(MouseEvent event) {
        B5.setStyle("-fx-background-color: red");
    }

    //B6    11
    @FXML
    private void B6Exited(MouseEvent event) {
        B6.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void B6Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgB6.setImage(imagen);
        facturaList.getListAsiento().get(11).setOcupado(true);
    }

    @FXML
    private void B6Moved(MouseEvent event) {
        B6.setStyle("-fx-background-color: red");
    }
    
    //C1    12
    @FXML
    private void C1Exited(MouseEvent event) {
        C1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void C1Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgC1.setImage(imagen);
        facturaList.getListAsiento().get(12).setOcupado(true);
    }

    @FXML
    private void C1Moved(MouseEvent event) {
        C1.setStyle("-fx-background-color: red");
    }

    //C2    13
    @FXML
    private void C2Exited(MouseEvent event) {
        C2.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void C2clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgC2.setImage(imagen);
        facturaList.getListAsiento().get(13).setOcupado(true);
    }

    @FXML
    private void C2Moved(MouseEvent event) {
        C2.setStyle("-fx-background-color: red");
    }

    //C3    14
    @FXML
    private void C3Exited(MouseEvent event) {
        C3.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void C3Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgC3.setImage(imagen);
        facturaList.getListAsiento().get(14).setOcupado(true);
    }

    @FXML
    private void C3Moved(MouseEvent event) {
        C3.setStyle("-fx-background-color: red");
    }

    //C4    15
    @FXML
    private void C4Exited(MouseEvent event) {
        C4.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void C4Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgC4.setImage(imagen);
        facturaList.getListAsiento().get(15).setOcupado(true);
    }

    @FXML
    private void C4Moved(MouseEvent event) {
        C4.setStyle("-fx-background-color: red");
    }

    //C5    16
    @FXML
    private void C5Exited(MouseEvent event) {
        C5.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void C5Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgC5.setImage(imagen);
        facturaList.getListAsiento().get(16).setOcupado(true);
    }

    @FXML
    private void C5Moved(MouseEvent event) {
        C5.setStyle("-fx-background-color: red");
    }

    //C6    17
    @FXML
    private void C6Exited(MouseEvent event) {
        C6.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void C6Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgC6.setImage(imagen);
        facturaList.getListAsiento().get(17).setOcupado(true);
    }

    @FXML
    private void C6Moved(MouseEvent event) {
        C6.setStyle("-fx-background-color: red");
    }

    //D1    18
    @FXML
    private void D1Exited(MouseEvent event) {
        D1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void D1Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgD1.setImage(imagen);
        facturaList.getListAsiento().get(18).setOcupado(true);
    }

    @FXML
    private void D1Moved(MouseEvent event) {
        D1.setStyle("-fx-background-color: red");
    }

    //D2    19
    @FXML
    private void D2Exited(MouseEvent event) {
        D2.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void D2Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgD2.setImage(imagen);
        facturaList.getListAsiento().get(19).setOcupado(true);
    }

    @FXML
    private void D2Moved(MouseEvent event) {
        D2.setStyle("-fx-background-color: red");
    }

    //D3    20
    @FXML
    private void D3Exited(MouseEvent event) {
        D3.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void D3Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgD3.setImage(imagen);
        facturaList.getListAsiento().get(20).setOcupado(true);
    }

    @FXML
    private void D3Moved(MouseEvent event) {
        D3.setStyle("-fx-background-color: red");
    }

    //D4    21
    @FXML
    private void D4Exited(MouseEvent event) {
        D4.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void D4clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgD4.setImage(imagen);
        facturaList.getListAsiento().get(21).setOcupado(true);
    }

    @FXML
    private void D4Moved(MouseEvent event) {
        D4.setStyle("-fx-background-color: red");
    }

    //D5    22
    @FXML
    private void D5Exited(MouseEvent event) {
        D5.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void D5Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgD5.setImage(imagen);
        facturaList.getListAsiento().get(22).setOcupado(true);
    }

    @FXML
    private void D5Moved(MouseEvent event) {
        D5.setStyle("-fx-background-color: red");
    }

    //D6    23
    @FXML
    private void D6Exited(MouseEvent event) {
        D6.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void D6Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgD6.setImage(imagen);
        facturaList.getListAsiento().get(23).setOcupado(true);
    }

    @FXML
    private void D6Moved(MouseEvent event) {
        D6.setStyle("-fx-background-color: red");
    }

    //E1    24
    @FXML
    private void E1Exited(MouseEvent event) {
        E1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void E1Clicked(MouseEvent event) {
        Image imagen = new Image(facturaStageController.class.getResourceAsStream("/Images/SillaCineSelec.png"));
        imgE1.setImage(imagen);
        facturaList.getListAsiento().get(24).setOcupado(true);
    }

    @FXML
    private void E1Moved(MouseEvent event) {
        E1.setStyle("-fx-background-color: red");
    }

    //E2    25
    @FXML
    private void E2Exited(MouseEvent event) {
        E2.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void E2Clicked(MouseEvent event) {
        Image imagen = new Image("/Images/SillaCineSelec.png");
        imgE2.setImage(imagen);
        facturaList.getListAsiento().get(25).setOcupado(true);
    }

    @FXML
    private void E2Moved(MouseEvent event) {
        E2.setStyle("-fx-background-color: red");
    }

    //E3    26
    @FXML
    private void E3Exited(MouseEvent event) {
        E3.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void E3clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgE3.setImage(imagen);
        facturaList.getListAsiento().get(26).setOcupado(true);
    }

    @FXML
    private void E3Moved(MouseEvent event) {
        E3.setStyle("-fx-background-color: red");
    }

    //E4    27
    @FXML
    private void E4Exited(MouseEvent event) {
        E4.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void E4Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgE4.setImage(imagen);
        facturaList.getListAsiento().get(27).setOcupado(true);
    }

    @FXML
    private void E4Moved(MouseEvent event) {
        E4.setStyle("-fx-background-color: red");
    }
    
    //E5    28
    @FXML
    private void E5Exited(MouseEvent event) {
        E5.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void E5Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgE5.setImage(imagen);
        facturaList.getListAsiento().get(28).setOcupado(true);
    }

    @FXML
    private void E5Moved(MouseEvent event) {
        E5.setStyle("-fx-background-color: red");
    }
    
    //E6    29
    @FXML
    private void E6Exited(MouseEvent event) {
        E6.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void E6Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgE6.setImage(imagen);
        facturaList.getListAsiento().get(29).setOcupado(true);
    }

    @FXML
    private void E6Moved(MouseEvent event) {
        E6.setStyle("-fx-background-color: red");
    }

    //F0    30
    @FXML
    private void F0Exited(MouseEvent event) {
        F0.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F0Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF0.setImage(imagen);
        facturaList.getListAsiento().get(30).setOcupado(true);
    }

    @FXML
    private void F0Moved(MouseEvent event) {
        F0.setStyle("-fx-background-color: red");
    }
    
    //F1    31
    @FXML
    private void F1Exited(MouseEvent event) {
        F1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F1Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF1.setImage(imagen);
        facturaList.getListAsiento().get(31).setOcupado(true);
    }

    @FXML
    private void F1Moved(MouseEvent event) {
        F1.setStyle("-fx-background-color: red");
    }

    //F2    32
    @FXML
    private void F2Exited(MouseEvent event) {
        F2.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F2Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF2.setImage(imagen);
        facturaList.getListAsiento().get(32).setOcupado(true);
    }

    @FXML
    private void F2Moved(MouseEvent event) {
        F2.setStyle("-fx-background-color: red");
    }

    //F3    33
    @FXML
    private void F3Exited(MouseEvent event) {
        F3.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F3Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF3.setImage(imagen);
        facturaList.getListAsiento().get(33).setOcupado(true);
    }

    @FXML
    private void F3Moved(MouseEvent event) {
        F3.setStyle("-fx-background-color: red");
    }

    //F4    34
    @FXML
    private void F4Exited(MouseEvent event) {
        F4.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F4Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF4.setImage(imagen);
        facturaList.getListAsiento().get(34).setOcupado(true);
    }

    @FXML
    private void F4Moved(MouseEvent event) {
        F4.setStyle("-fx-background-color: red");
    }

    //F5    35
    @FXML
    private void F5Exited(MouseEvent event) {
        F5.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F5Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF5.setImage(imagen);
        facturaList.getListAsiento().get(35).setOcupado(true);
    }

    @FXML
    private void F5Moved(MouseEvent event) {
        F5.setStyle("-fx-background-color: red");
    }

    //F6    36
    @FXML
    private void F6Exited(MouseEvent event) {
        F6.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F6Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF6.setImage(imagen);
        facturaList.getListAsiento().get(36).setOcupado(true);
    }

    @FXML
    private void F6Moved(MouseEvent event) {
        F6.setStyle("-fx-background-color: red");
    }
    
    //F7    37
    @FXML
    private void F7Exited(MouseEvent event) {
        F7.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void F7Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgF7.setImage(imagen);
        facturaList.getListAsiento().get(37).setOcupado(true);
    }

    @FXML
    private void F7Moved(MouseEvent event) {
        F7.setStyle("-fx-background-color: red");
    }
    
    //G0    38
    @FXML
    private void G0Exited(MouseEvent event) {
        G0.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G0Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG0.setImage(imagen);
        facturaList.getListAsiento().get(38).setOcupado(true);
    }

    @FXML
    private void G0Moved(MouseEvent event) {
        G0.setStyle("-fx-background-color: red");
    }
    
    //G1    39
    @FXML
    private void G1Exited(MouseEvent event) {
        G1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G1Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG1.setImage(imagen);
        facturaList.getListAsiento().get(39).setOcupado(true);
    }

    @FXML
    private void G1Moved(MouseEvent event) {
        G1.setStyle("-fx-background-color: red");
    }
    
    //G2    40
    @FXML
    private void G2Exited(MouseEvent event) {
        G2.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G2Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG2.setImage(imagen);
        facturaList.getListAsiento().get(40).setOcupado(true);
    }

    @FXML
    private void G2Moved(MouseEvent event) {
        G2.setStyle("-fx-background-color: red");
    }

    //G3    41
    @FXML
    private void G3Exited(MouseEvent event) {
        G3.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G3Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG3.setImage(imagen);
        facturaList.getListAsiento().get(41).setOcupado(true);
    }

    @FXML
    private void G3Moved(MouseEvent event) {
        G3.setStyle("-fx-background-color: red");
    }

    //G4    42
    @FXML
    private void G4Exited(MouseEvent event) {
        G4.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G4Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG4.setImage(imagen);
        facturaList.getListAsiento().get(42).setOcupado(true);
    }

    @FXML
    private void G4Moved(MouseEvent event) {
        G4.setStyle("-fx-background-color: red");
    }

    //G5    43
    @FXML
    private void G5Exited(MouseEvent event) {
        G5.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G5Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG5.setImage(imagen);
        facturaList.getListAsiento().get(43).setOcupado(true);
    }

    @FXML
    private void G5Moved(MouseEvent event) {
        G5.setStyle("-fx-background-color: red");
    }

    //G6    44
    @FXML
    private void G6Exited(MouseEvent event) {
        G6.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G6Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG6.setImage(imagen);
        facturaList.getListAsiento().get(44).setOcupado(true);
    }

    @FXML
    private void G6Moved(MouseEvent event) {
        G6.setStyle("-fx-background-color: red");
    }

    //G7    45
    @FXML
    private void G7Exited(MouseEvent event) {
        G7.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void G7Clicked(MouseEvent event) {
        Image imagen = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
        imgG7.setImage(imagen);
        facturaList.getListAsiento().get(45).setOcupado(true);
    }

    @FXML
    private void G7Moved(MouseEvent event) {
        G7.setStyle("-fx-background-color: red");
    }




    //-----------------------------------------------------------------------------------------------------

    @FXML
    private void cmbxPeliculaOnAction(ActionEvent event) {
 
       
    }


}
