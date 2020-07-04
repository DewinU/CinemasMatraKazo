package Controller;

import Model.FacturaListModel;
import Pojo.Asiento;
import Pojo.Factura;
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
import javafx.scene.control.ListView;
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
    
    private final Image imgOcup = new Image(getClass().getResourceAsStream("/Images/SillaCineSelec.png"));
    private final Image imgDeso = new Image(getClass().getResourceAsStream("/Images/SillaCine.png"));
    
    //Creando la Nueva Factura
    Factura nuevaFactura;
    @FXML
    private ListView<String> listViewAsientos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contentPane.setStyle("-fx-border-color: #000000");
        facturaList = new FacturaListModel();
        
        //CREANDO LA NUEVA FACTURA (DEWIN NO LO BORRES POR FACVOR)
        nuevaFactura = new Factura();
        
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
                    nuevaFactura.setNombrePelicula(newValue);
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
                            loadAsiento();
                            loadAsientoModel();
                            txtSalaSelector.setText(facturaList.getListPelicula().get(i).getSala().get(j));
                            imgSelectorAsientosPrincipal.setVisible(false);
                            nuevaFactura.setSala(facturaList.getListPelicula().get(i).getSala().get(j));
                            nuevaFactura.setHoraFuncion(facturaList.getListPelicula().get(i).getFuncion().get(j));
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
                        imgC3.setImage(imagen);
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
        
        public void loadAsiento(){
            for(Asiento a : facturaList.getListAsiento()){
                int i = a.getId();
                    switch(i){
                         case 0:
                        imgA1.setImage(imgDeso);
                        break;
                    case 1:
                        imgA2.setImage(imgDeso);
                        break;
                    case 2:
                        imgA3.setImage(imgDeso);
                        break;
                    case 3:
                        imgA4.setImage(imgDeso);
                        break;
                    case 4:
                        imgA5.setImage(imgDeso);
                        break;
                    case 5:
                        imgA6.setImage(imgDeso);
                        break;
                    case 6:
                        imgB1.setImage(imgDeso);
                        break;
                    case 7:
                        imgB2.setImage(imgDeso);
                        break;
                    case 8:
                        imgB3.setImage(imgDeso);
                        break;
                    case 9:
                        imgB4.setImage(imgDeso);
                        break;
                    case 10:
                        imgB5.setImage(imgDeso);
                        break;
                    case 11:
                        imgB6.setImage(imgDeso);
                        break;
                    case 12:
                        imgC1.setImage(imgDeso);
                        break;
                    case 13:
                        imgC2.setImage(imgDeso);
                        break;
                    case 14:
                        imgC3.setImage(imgDeso);
                        break;
                    case 15:
                        imgC4.setImage(imgDeso);
                        break;
                    case 16:
                        imgC5.setImage(imgDeso);
                        break;
                    case 17:
                        imgC6.setImage(imgDeso);
                        break;
                    case 18:
                        imgD1.setImage(imgDeso);
                        break;
                    case 19:
                        imgD2.setImage(imgDeso);
                        break;
                    case 20:
                        imgD3.setImage(imgDeso);
                        break;
                    case 21:
                        imgD4.setImage(imgDeso);
                        break;
                    case 22:
                        imgD5.setImage(imgDeso);
                        break;
                    case 23:
                        imgD6.setImage(imgDeso);
                        break;
                    case 24:
                        imgE1.setImage(imgDeso);
                        break;
                    case 25:
                        imgE2.setImage(imgDeso);
                        break;
                    case 26:
                        imgE3.setImage(imgDeso);
                        break;
                    case 27:
                        imgE4.setImage(imgDeso);
                        break;
                    case 28:
                        imgE5.setImage(imgDeso);
                        break;
                    case 29:
                        imgE6.setImage(imgDeso);
                        break;
                    case 30:
                        imgF0.setImage(imgDeso);
                        break;
                    case 31:
                        imgF1.setImage(imgDeso);
                        break;
                    case 32:
                        imgF2.setImage(imgDeso);
                        break;
                    case 33:
                        imgF3.setImage(imgDeso);
                        break;
                    case 34:
                        imgF4.setImage(imgDeso);
                        break;
                    case 35:
                        imgF5.setImage(imgDeso);
                        break;
                    case 36:
                        imgF6.setImage(imgDeso);
                        break;
                    case 37:
                        imgF7.setImage(imgDeso);
                        break;
                    case 38:
                        imgG0.setImage(imgDeso);
                        break;
                    case 39:
                        imgG1.setImage(imgDeso);
                        break;
                    case 40:
                        imgG2.setImage(imgDeso);
                        break;
                    case 41:
                        imgG3.setImage(imgDeso);
                        break;
                    case 42:
                        imgG4.setImage(imgDeso);
                        break;
                    case 43:
                        imgG5.setImage(imgDeso);
                        break;
                    case 44:
                        imgG6.setImage(imgDeso);
                        break;
                    case 45:
                        imgG7.setImage(imgDeso);
                        break;
                    default:
                        System.out.println("Error en el switch");
                        break;
                    }
            }
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
        String nombreAsiento = facturaList.getListAsiento().get(0).getNombre();
        if(imgA1.getImage().equals(imgDeso)){
            imgA1.setImage(imgOcup);
            facturaList.getListAsiento().get(0).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgA1.setImage(imgDeso);
            facturaList.getListAsiento().get(0).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }   
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
        String nombreAsiento = facturaList.getListAsiento().get(1).getNombre();
        if(imgA2.getImage().equals(imgDeso)){
            imgA2.setImage(imgOcup);
            facturaList.getListAsiento().get(1).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgA2.setImage(imgDeso);
            facturaList.getListAsiento().get(1).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(2).getNombre();
        if(imgA3.getImage().equals(imgDeso)){
            imgA3.setImage(imgOcup);
            facturaList.getListAsiento().get(2).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgA3.setImage(imgDeso);
            facturaList.getListAsiento().get(2).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(3).getNombre();
        if(imgA4.getImage().equals(imgDeso)){
            imgA4.setImage(imgOcup);
            facturaList.getListAsiento().get(3).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgA4.setImage(imgDeso);
            facturaList.getListAsiento().get(3).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(4).getNombre();
        if(imgA5.getImage().equals(imgDeso)){
            imgA5.setImage(imgOcup);
            facturaList.getListAsiento().get(4).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgA5.setImage(imgDeso);
            facturaList.getListAsiento().get(4).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(5).getNombre();
        if(imgA6.getImage().equals(imgDeso)){
            imgA6.setImage(imgOcup);
            facturaList.getListAsiento().get(5).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgA6.setImage(imgDeso);
            facturaList.getListAsiento().get(5).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(6).getNombre();
        if(imgB1.getImage().equals(imgDeso)){
            imgB1.setImage(imgOcup);
            facturaList.getListAsiento().get(6).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgB1.setImage(imgDeso);
            facturaList.getListAsiento().get(6).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(7).getNombre();
        if(imgB2.getImage().equals(imgDeso)){
            imgB2.setImage(imgOcup);
            facturaList.getListAsiento().get(7).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgB2.setImage(imgDeso);
            facturaList.getListAsiento().get(7).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(8).getNombre();
        if(imgB3.getImage().equals(imgDeso)){
            imgB3.setImage(imgOcup);
            facturaList.getListAsiento().get(8).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgB3.setImage(imgDeso);
            facturaList.getListAsiento().get(8).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(9).getNombre();
        if(imgB4.getImage().equals(imgDeso)){
            imgB4.setImage(imgOcup);
            facturaList.getListAsiento().get(9).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgB4.setImage(imgDeso);
            facturaList.getListAsiento().get(9).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(10).getNombre();
        if(imgB5.getImage().equals(imgDeso)){
            imgB5.setImage(imgOcup);
            facturaList.getListAsiento().get(10).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgB5.setImage(imgDeso);
            facturaList.getListAsiento().get(10).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(11).getNombre();
        if(imgB6.getImage().equals(imgDeso)){
            imgB6.setImage(imgOcup);
            facturaList.getListAsiento().get(11).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgB6.setImage(imgDeso);
            facturaList.getListAsiento().get(11).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(12).getNombre();
        if(imgC1.getImage().equals(imgDeso)){
            imgC1.setImage(imgOcup);
            facturaList.getListAsiento().get(12).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgC1.setImage(imgDeso);
            facturaList.getListAsiento().get(12).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(13).getNombre();
        if(imgC2.getImage().equals(imgDeso)){
            imgC2.setImage(imgOcup);
            facturaList.getListAsiento().get(13).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgC2.setImage(imgDeso);
            facturaList.getListAsiento().get(13).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(14).getNombre();
        if(imgC3.getImage().equals(imgDeso)){
            imgC3.setImage(imgOcup);
            facturaList.getListAsiento().get(14).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgC3.setImage(imgDeso);
            facturaList.getListAsiento().get(14).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(15).getNombre();
        if(imgC4.getImage().equals(imgDeso)){
            imgC4.setImage(imgOcup);
            facturaList.getListAsiento().get(15).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgC4.setImage(imgDeso);
            facturaList.getListAsiento().get(15).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(16).getNombre();
        if(imgC5.getImage().equals(imgDeso)){
            imgC5.setImage(imgOcup);
            facturaList.getListAsiento().get(16).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgC5.setImage(imgDeso);
            facturaList.getListAsiento().get(16).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(17).getNombre();
        if(imgC6.getImage().equals(imgDeso)){
            imgC6.setImage(imgOcup);
            facturaList.getListAsiento().get(17).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgC6.setImage(imgDeso);
            facturaList.getListAsiento().get(17).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(18).getNombre();
        if(imgD1.getImage().equals(imgDeso)){
            imgD1.setImage(imgOcup);
            facturaList.getListAsiento().get(18).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgD1.setImage(imgDeso);
            facturaList.getListAsiento().get(18).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(19).getNombre();
        if(imgD2.getImage().equals(imgDeso)){
            imgD2.setImage(imgOcup);
            facturaList.getListAsiento().get(19).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgD2.setImage(imgDeso);
            facturaList.getListAsiento().get(19).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(20).getNombre();
        if(imgD3.getImage().equals(imgDeso)){
            imgD3.setImage(imgOcup);
            facturaList.getListAsiento().get(20).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgD3.setImage(imgDeso);
            facturaList.getListAsiento().get(20).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(21).getNombre();
        if(imgD4.getImage().equals(imgDeso)){
            imgD4.setImage(imgOcup);
            facturaList.getListAsiento().get(21).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgD4.setImage(imgDeso);
            facturaList.getListAsiento().get(21).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(22).getNombre();
        if(imgD5.getImage().equals(imgDeso)){
            imgD5.setImage(imgOcup);
            facturaList.getListAsiento().get(22).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgD5.setImage(imgDeso);
            facturaList.getListAsiento().get(22).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(23).getNombre();
        if(imgD6.getImage().equals(imgDeso)){
            imgD6.setImage(imgOcup);
            facturaList.getListAsiento().get(23).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgD6.setImage(imgDeso);
            facturaList.getListAsiento().get(23).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(24).getNombre();
        if(imgE1.getImage().equals(imgDeso)){
            imgE1.setImage(imgOcup);
            facturaList.getListAsiento().get(24).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgE1.setImage(imgDeso);
            facturaList.getListAsiento().get(24).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(25).getNombre();
        if(imgE2.getImage().equals(imgDeso)){
            imgE2.setImage(imgOcup);
            facturaList.getListAsiento().get(25).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgE2.setImage(imgDeso);
            facturaList.getListAsiento().get(25).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(26).getNombre();
        if(imgE3.getImage().equals(imgDeso)){
            imgE3.setImage(imgOcup);
            facturaList.getListAsiento().get(26).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgE3.setImage(imgDeso);
            facturaList.getListAsiento().get(26).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(27).getNombre();
        if(imgE4.getImage().equals(imgDeso)){
            imgE4.setImage(imgOcup);
            facturaList.getListAsiento().get(27).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgE4.setImage(imgDeso);
            facturaList.getListAsiento().get(27).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(28).getNombre();
        if(imgE5.getImage().equals(imgDeso)){
            imgE5.setImage(imgOcup);
            facturaList.getListAsiento().get(28).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgE5.setImage(imgDeso);
            facturaList.getListAsiento().get(28).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(29).getNombre();
        if(imgE6.getImage().equals(imgDeso)){
            imgE6.setImage(imgOcup);
            facturaList.getListAsiento().get(29).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgE6.setImage(imgDeso);
            facturaList.getListAsiento().get(29).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(30).getNombre();
        if(imgF0.getImage().equals(imgDeso)){
            imgF0.setImage(imgOcup);
            facturaList.getListAsiento().get(30).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF0.setImage(imgDeso);
            facturaList.getListAsiento().get(30).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(31).getNombre();
        if(imgF1.getImage().equals(imgDeso)){
            imgF1.setImage(imgOcup);
            facturaList.getListAsiento().get(31).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF1.setImage(imgDeso);
            facturaList.getListAsiento().get(31).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(32).getNombre();
        if(imgF2.getImage().equals(imgDeso)){
            imgF2.setImage(imgOcup);
            facturaList.getListAsiento().get(32).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF2.setImage(imgDeso);
            facturaList.getListAsiento().get(32).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(33).getNombre();
        if(imgF3.getImage().equals(imgDeso)){
            imgF3.setImage(imgOcup);
            facturaList.getListAsiento().get(33).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF3.setImage(imgDeso);
            facturaList.getListAsiento().get(33).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(34).getNombre();
        if(imgF4.getImage().equals(imgDeso)){
            imgF4.setImage(imgOcup);
            facturaList.getListAsiento().get(34).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF4.setImage(imgDeso);
            facturaList.getListAsiento().get(34).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(35).getNombre();
        if(imgF5.getImage().equals(imgDeso)){
            imgF5.setImage(imgOcup);
            facturaList.getListAsiento().get(35).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF5.setImage(imgDeso);
            facturaList.getListAsiento().get(35).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(36).getNombre();
        if(imgF6.getImage().equals(imgDeso)){
            imgF6.setImage(imgOcup);
            facturaList.getListAsiento().get(36).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF6.setImage(imgDeso);
            facturaList.getListAsiento().get(36).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(37).getNombre();
        if(imgF7.getImage().equals(imgDeso)){
            imgF7.setImage(imgOcup);
            facturaList.getListAsiento().get(37).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgF7.setImage(imgDeso);
            facturaList.getListAsiento().get(37).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(38).getNombre();
        if(imgG0.getImage().equals(imgDeso)){
            imgG0.setImage(imgOcup);
            facturaList.getListAsiento().get(38).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG0.setImage(imgDeso);
            facturaList.getListAsiento().get(38).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(39).getNombre();
        if(imgG1.getImage().equals(imgDeso)){
            imgG1.setImage(imgOcup);
            facturaList.getListAsiento().get(39).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG1.setImage(imgDeso);
            facturaList.getListAsiento().get(39).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(40).getNombre();
        if(imgG2.getImage().equals(imgDeso)){
            imgG2.setImage(imgOcup);
            facturaList.getListAsiento().get(40).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG2.setImage(imgDeso);
            facturaList.getListAsiento().get(40).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(41).getNombre();
        if(imgG3.getImage().equals(imgDeso)){
            imgG3.setImage(imgOcup);
            facturaList.getListAsiento().get(41).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG3.setImage(imgDeso);
            facturaList.getListAsiento().get(41).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(42).getNombre();
        if(imgG4.getImage().equals(imgDeso)){
            imgG4.setImage(imgOcup);
            facturaList.getListAsiento().get(42).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG4.setImage(imgDeso);
            facturaList.getListAsiento().get(42).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(43).getNombre();
        if(imgG5.getImage().equals(imgDeso)){
            imgG5.setImage(imgOcup);
            facturaList.getListAsiento().get(43).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG5.setImage(imgDeso);
            facturaList.getListAsiento().get(43).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(44).getNombre();
        if(imgG6.getImage().equals(imgDeso)){
            imgG6.setImage(imgOcup);
            facturaList.getListAsiento().get(44).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG6.setImage(imgDeso);
            facturaList.getListAsiento().get(44).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
        String nombreAsiento = facturaList.getListAsiento().get(45).getNombre();
        if(imgG7.getImage().equals(imgDeso)){
            imgG7.setImage(imgOcup);
            facturaList.getListAsiento().get(45).setOcupado(true);
            nuevaFactura.getAsientos().add(nombreAsiento);
            listViewAsientos.getItems().add("     <---"+nombreAsiento+"--->");
        }else{
            imgG7.setImage(imgDeso);
            facturaList.getListAsiento().get(45).setOcupado(false);
            nuevaFactura.getAsientos().remove(nombreAsiento);
            listViewAsientos.getItems().remove("     <---"+nombreAsiento+"--->");
        }
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
