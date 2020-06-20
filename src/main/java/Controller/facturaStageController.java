package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableView;
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
    @FXML
    private Button btnNuevaFactura;

    static ExecutorService threadPool;
    static Runnable task1;
    static Runnable task2;
    @FXML
    private TreeTableView<String> TreeTableViewPeliculas;
    @FXML
    private Pane pnlBotonesAsientos;
    @FXML
    private ImageView imgSelectorAsientosPrincipal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contentPane.setStyle("-fx-border-color: #000000");
        
        threadPool = Executors.newCachedThreadPool();
        //Animacion de la tabla y el boton
        task1 = () ->{
            //hacemos invisible el boton
            btnNuevaFactura.setVisible(false);
            
            //hacemos crecer la tabla
            double i = TreeTableViewPeliculas.getHeight();
            double j = TreeTableViewPeliculas.getLayoutY();
            for(; j > 14 || i <= 656 ; j--, i++ ){
                TreeTableViewPeliculas.setLayoutY(j);
                TreeTableViewPeliculas.setPrefHeight(i);
                try {
                    Thread.sleep(3);
                } catch (InterruptedException ex) {
                    Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pnlBotonesAsientos.setVisible(true);
            //Aparecemos los botones y el img
            for (double a = 0, b = 1; a <= 1 && b>= 0; a+= 0.1, b-= 0.1 ){
                pnlBotonesAsientos.setOpacity(a);
                imgSelectorAsientosPrincipal.setOpacity(b);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            imgSelectorAsientosPrincipal.setVisible(false);
            
        };
        task2 = () ->{
            imgSelectorAsientosPrincipal.setVisible(true);
            //desaparecemos los botones y el img
            for (double b = 1, a = 0; b <= 1 || a >= 1; b+= 0.1, a-= 0.1){
                pnlBotonesAsientos.setOpacity(a);
                imgSelectorAsientosPrincipal.setOpacity(b);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pnlBotonesAsientos.setVisible(false);
            //hacemos encojer la tabla
            double i = TreeTableViewPeliculas.getHeight();
            double j = TreeTableViewPeliculas.getLayoutY();
            for(; j < 55 || i >= 615 ; j++, i-- ){
                TreeTableViewPeliculas.setLayoutY(j);
                TreeTableViewPeliculas.setPrefHeight(i);
                try {
                    Thread.sleep(3);
                } catch (InterruptedException ex) {
                    Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //hacemos visible el boton
            btnNuevaFactura.setVisible(true);
            
        };
    }
    
    @FXML
    private void btnNuevaFacturaOnAction(ActionEvent event) throws IOException {
             mainStageController.NuevaFacturaMainStageEvent(true);  
             threadPool.submit(task1);
    }
    
    public static void cancelarMainEvent(boolean a){
        if(a){
            threadPool.submit(task2);
        }
    }
    
    
    //ASIENTOS BOTONES
    //A1    0
    @FXML
    private void A1Exited(MouseEvent event) {
        A1.setStyle("-fx-background-color: darkred");
    }

    @FXML
    private void A1Clicked(MouseEvent event) {
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
    }

    @FXML
    private void G0Moved(MouseEvent event) {
        G0.setStyle("-fx-background-color: red");
    }
    
    //G1    39
    @FXML
    private void G1Exited(MouseEvent event) {
        G1.setStyle("-fx-background-color: dakred");
    }

    @FXML
    private void G1Clicked(MouseEvent event) {
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
    }

    @FXML
    private void G7Moved(MouseEvent event) {
        G7.setStyle("-fx-background-color: red");
    }

    




}
