package Controller;

import static Main.App.loadFXML;
import Model.FacturaListModel;
import Pojo.Asiento;
import Pojo.Factura;
import Pojo.Reporte;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
    Reporte reporte;
    
    @FXML
    private ListView<String> listViewAsientos;
    @FXML
    private AnchorPane anchorPaneDetalle;
    @FXML
    private TextField txtSala1;
    @FXML
    private AnchorPane anchorPaneComidaBotones;
    @FXML
    private Button btnCombo1;
    @FXML
    private Button btnPalomitaGrande;
    @FXML
    private Button btnPalomitaPequenia;
    @FXML
    private Button btnBebidaGrande;
    @FXML
    private Button btnBebidaPequenia;
    @FXML
    private Button btnNachos;
    @FXML
    private Button btnHotDog;
    @FXML
    private Button btnCombo2;
    @FXML
    private Button btnCombo3;
    @FXML
    private Button btnCombo4;
    @FXML
    private Button btnCombo5;
    @FXML
    private Button btnCombo6;
    @FXML
    private Button btnCombo7;
    @FXML
    private Button btnCombo8;
    @FXML
    private Button cancelarFacturaButtom;
    @FXML
    private Button btnCancelar;
    @FXML
    private ListView<String> listViewDescripcion;
    @FXML
    private TextField txtTotalDescripcion;
    
    ObservableList<String> obListComida;
    @FXML
    private ListView<String> listViewComidaSelec;
    @FXML
    private ListView<String> listViewPrecioComidaSelec;
    @FXML
    private TextField txtTotalComidaSelec;
    
    private ContextMenu context = new ContextMenu();
    private MenuItem itemContext;
    
    private int indexStageContinue;
    @FXML
    private AnchorPane anchorPaneDescripcionFactura;
    @FXML
    private TextField txtSala11;
    @FXML
    private TextField txtNombreDePeliculaFinal;
    @FXML
    private TextField txtHoraFunsionFinal;
    @FXML
    private TextField txtSalaFinal;
    @FXML
    private ListView<String> listViewAsientosSeleccionadosFinal;
    @FXML
    private ListView<String> listViewAlimentosFinal;
    @FXML
    private TextField txtTotalFinal;
    @FXML
    private Pane pnlReporte;
    @FXML
    private ImageView imgFacturando;
    @FXML
    private Label lblNumeroFactura;
    @FXML
    private Label lblNumeroFacturaFinal;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contentPane.setStyle("-fx-border-color: #000000");
        facturaList = new FacturaListModel();
        reporte = new Reporte();
        
        //CREANDO LA NUEVA FACTURA
        nuevaFactura = new Factura();
        indexStageContinue = 0;
        
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
        
        if(facturaList.LoadFromJsonFacturas()){
            int i = (facturaList.getListFactura().size() + 1);
            nuevaFactura.setId(i);
            if(i < 10){
                lblNumeroFactura.setText("F#000" + i);
                lblNumeroFacturaFinal.setText("F#000" + i);
                nuevaFactura.setNumeroFactura("F#000" + i);
            }else if(i >= 10 && i < 100){
                lblNumeroFactura.setText("F#00" +  i);
                lblNumeroFacturaFinal.setText("F#00" + i);
                nuevaFactura.setNumeroFactura("F#00" + i);
            }else if (i >= 100 && i < 1000){
                lblNumeroFactura.setText("F#0" + i);
                lblNumeroFacturaFinal.setText("F#0" + i);
                nuevaFactura.setNumeroFactura("F#0" + i);
            }else if(i >= 1000 && i < 10000){
                lblNumeroFactura.setText("F#" + i);
                lblNumeroFacturaFinal.setText("F#" + i);
                nuevaFactura.setNumeroFactura("F#" + i);
            }
            
        }else{
            lblNumeroFactura.setText("F#0001");
            lblNumeroFacturaFinal.setText("F#0001");
            nuevaFactura.setNumeroFactura("F#0001");
            nuevaFactura.setId(1);
        }
        
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

                    if (!( nuevaFactura.getHoraFuncion() == null )) {
                        
                        listViewAsientos.getItems().clear();
                        listViewComidaSelec.getItems().clear();
                        listViewAlimentosFinal.getItems().clear();
                        listViewAsientosSeleccionadosFinal.getItems().clear();
                        listViewDescripcion.getItems().clear();
                        listViewPrecioComidaSelec.getItems().clear();

                        txtHoraFunsionFinal.setText("");
                        txtNombreDePeliculaFinal.setText("");
                        txtSalaFinal.setText("");
                        txtSalaSelector.setText("");
                        txtTotalComidaSelec.setText("");
                        txtTotalDescripcion.setText("");
                        txtTotalFinal.setText("");

                        nuevaFactura.setAsientos(null);
                        nuevaFactura.setHoraFuncion(null);
                        nuevaFactura.setPreciosComida(null);
                        nuevaFactura.setSala(null);
                        nuevaFactura.setTipoComida(null);
                        nuevaFactura.setTotal(0);

                        loadAsiento();
                    }
                    break;
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
        
        // --- Inicializacion del ContextMenu ---
        itemContext = new MenuItem(" Eliminar ");
        context.getItems().addAll(itemContext);
        listViewComidaSelec.setContextMenu(context);
        
        itemContext.setOnAction((event) -> {
            int index = listViewComidaSelec.getSelectionModel().getSelectedIndex();
            String s = listViewComidaSelec.getSelectionModel().getSelectedItem();
            
            nuevaFactura.getTipoComida().remove(s);
            nuevaFactura.getPreciosComida().remove(index);
            
            listViewPrecioComidaSelec.getItems().remove(index);
            listViewComidaSelec.getItems().remove(s);
            
            listViewAlimentosFinal.getItems().remove(s);
            
            sumatoriaDePreciosDeComida();
        });
        
        listViewComidaSelec.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            if(event.getButton() == MouseButton.SECONDARY){
                context.show(listViewComidaSelec, event.getScreenX(), event.getScreenY());
            }
        });
    }
    //-----------------------------------------------------------------------------------
    //  ALGUNOS METODOS
    
        public void sumatoriaDePreciosDeComida(){
            int suma = 0;
            for(Float f : nuevaFactura.getPreciosComida()){
                suma += f;
            }
            txtTotalComidaSelec.setText("C$ " + suma);
        }
        
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
                        A1.setDisable(false);
                        break;
                    case 1:
                        imgA2.setImage(imgDeso);
                        A2.setDisable(false);
                        break;
                    case 2:
                        imgA3.setImage(imgDeso);
                        A3.setDisable(false);
                        break;
                    case 3:
                        imgA4.setImage(imgDeso);
                        A4.setDisable(false);
                        break;
                    case 4:
                        imgA5.setImage(imgDeso);
                        A5.setDisable(false);
                        break;
                    case 5:
                        imgA6.setImage(imgDeso);
                        A6.setDisable(false);
                        break;
                    case 6:
                        imgB1.setImage(imgDeso);
                        B1.setDisable(false);
                        break;
                    case 7:
                        imgB2.setImage(imgDeso);
                        B2.setDisable(false);
                        break;
                    case 8:
                        imgB3.setImage(imgDeso);
                        B3.setDisable(false);
                        break;
                    case 9:
                        imgB4.setImage(imgDeso);
                        B4.setDisable(false);
                        break;
                    case 10:
                        imgB5.setImage(imgDeso);
                        B5.setDisable(false);
                        break;
                    case 11:
                        imgB6.setImage(imgDeso);
                        B6.setDisable(false);
                        break;
                    case 12:
                        imgC1.setImage(imgDeso);
                        C1.setDisable(false);
                        break;
                    case 13:
                        imgC2.setImage(imgDeso);
                        C2.setDisable(false);
                        break;
                    case 14:
                        imgC3.setImage(imgDeso);
                        C3.setDisable(false);
                        break;
                    case 15:
                        imgC4.setImage(imgDeso);
                        C4.setDisable(false);
                        break;
                    case 16:
                        imgC5.setImage(imgDeso);
                        C5.setDisable(false);
                        break;
                    case 17:
                        imgC6.setImage(imgDeso);
                        C6.setDisable(false);
                        break;
                    case 18:
                        imgD1.setImage(imgDeso);
                        D1.setDisable(false);
                        break;
                    case 19:
                        imgD2.setImage(imgDeso);
                        D2.setDisable(false);
                        break;
                    case 20:
                        imgD3.setImage(imgDeso);
                        D3.setDisable(false);
                        break;
                    case 21:
                        imgD4.setImage(imgDeso);
                        D4.setDisable(false);
                        break;
                    case 22:
                        imgD5.setImage(imgDeso);
                        D5.setDisable(false);
                        break;
                    case 23:
                        imgD6.setImage(imgDeso);
                        D6.setDisable(false);
                        break;
                    case 24:
                        imgE1.setImage(imgDeso);
                        E1.setDisable(false);
                        break;
                    case 25:
                        imgE2.setImage(imgDeso);
                        E2.setDisable(false);
                        break;
                    case 26:
                        imgE3.setImage(imgDeso);
                        E3.setDisable(false);
                        break;
                    case 27:
                        imgE4.setImage(imgDeso);
                        E4.setDisable(false);
                        break;
                    case 28:
                        imgE5.setImage(imgDeso);
                        E5.setDisable(false);
                        break;
                    case 29:
                        imgE6.setImage(imgDeso);
                        E6.setDisable(false);
                        break;
                    case 30:
                        imgF0.setImage(imgDeso);
                        F0.setDisable(false);
                        break;
                    case 31:
                        imgF1.setImage(imgDeso);
                        F1.setDisable(false);
                        break;
                    case 32:
                        imgF2.setImage(imgDeso);
                        F2.setDisable(false);
                        break;
                    case 33:
                        imgF3.setImage(imgDeso);
                        F3.setDisable(false);
                        break;
                    case 34:
                        imgF4.setImage(imgDeso);
                        F4.setDisable(false);
                        break;
                    case 35:
                        imgF5.setImage(imgDeso);
                        F5.setDisable(false);
                        break;
                    case 36:
                        imgF6.setImage(imgDeso);
                        F6.setDisable(false);
                        break;
                    case 37:
                        imgF7.setImage(imgDeso);
                        F7.setDisable(false);
                        break;
                    case 38:
                        imgG0.setImage(imgDeso);
                        G0.setDisable(false);
                        break;
                    case 39:
                        imgG1.setImage(imgDeso);
                        G1.setDisable(false);
                        break;
                    case 40:
                        imgG2.setImage(imgDeso);
                        G2.setDisable(false);
                        break;
                    case 41:
                        imgG3.setImage(imgDeso);
                        G3.setDisable(false);
                        break;
                    case 42:
                        imgG4.setImage(imgDeso);
                        G4.setDisable(false);
                        break;
                    case 43:
                        imgG5.setImage(imgDeso);
                        G5.setDisable(false);
                        break;
                    case 44:
                        imgG6.setImage(imgDeso);
                        G6.setDisable(false);
                        break;
                    case 45:
                        imgG7.setImage(imgDeso);
                        G7.setDisable(false);
                        break;
                    default:
                        System.out.println("Error en el switch");
                        break;
                    }
            }
        }
        
        
    //-----------------------------------------------------------------------------------
  
    @FXML
    private void btnCancelarOnAction(ActionEvent event) {
        
        switch(indexStageContinue){
            case 0:
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("CONFIRMACIÓN");
                alert.setContentText("¿ESTA SEGURO DE CANCELAR FACTURA?");
                Optional<ButtonType> action = alert.showAndWait();

                if (action.get() == ButtonType.OK) {
                    
                    mainStageController.threadPool.execute(mainStageController.task2);

                    try {
                        // REGRESAR AL INICIO (CANCELAR FACTURA)
                        Node child = loadFXML("dashboardStage");
                        contentPane.getChildren().clear();
                        contentPane.getChildren().add(child);
                    } catch (IOException ex) {
                        Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 1:
                //REGRESAR AL SELECTOR DE ASIENTOS Y PELICULAS
                if (btnCancelar.getText().equals("Regresar")) {
                    anchorPaneComidaBotones.setVisible(false);
                    anchorPaneDetalle.setVisible(false);
                    pnlBotonesAsientos.setVisible(true);
                    btnCancelar.setText("Cancelar Factura");
                }
                indexStageContinue = 0;
                break;
            case 2:
                //REGRESAR AL SELECTOR DE COMIDA
                anchorPaneDescripcionFactura.setVisible(false);
                imgFacturando.setVisible(false);
                imgSelectorAsientosPrincipal.setVisible(false);
                pnlBotonesAsientos.setVisible(false);
                anchorPaneComidaBotones.setVisible(true);
                anchorPaneDetalle.setVisible(true);
                btnCancelar.setText("Regresar");
                btnContinuar.setText("Continuar");
                indexStageContinue = 1;
                break;
            case 3:
                mainStageController.threadPool.execute(mainStageController.task2);

                    try {
                        // REGRESAR AL INICIO (CANCELAR FACTURA)
                        Node child = loadFXML("dashboardStage");
                        contentPane.getChildren().clear();
                        contentPane.getChildren().add(child);
                    } catch (IOException ex) {
                        Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                indexStageContinue = 0;
            default:
                break;
        }
    }
    
    @FXML
    private void btnContinuarOnAction(ActionEvent event) {     
        switch(indexStageContinue){
            case 0:
                // SELECCIONAR COMIDA
                if (nuevaFactura.getNombrePelicula() == null || nuevaFactura.getHoraFuncion() == null || nuevaFactura.getAsientos().isEmpty()) {
                    if (nuevaFactura.getNombrePelicula() == null) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("¡ALERTA!");
                        alert.setContentText("¡DEBE SELECCIONAR UNA PELICULA!");
                        alert.showAndWait();
                    }else if(nuevaFactura.getHoraFuncion() == null){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("¡ALERTA!");
                        alert.setContentText("¡DEBE SELECCIONAR UNA HORA DE FUNCION!");
                        alert.showAndWait();
                    }else if(nuevaFactura.getAsientos().isEmpty()){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("¡ALERTA!");
                        alert.setContentText("¡DEBE SELECCIONAR AL MENOS UN ASIENTO!");
                        alert.showAndWait();
                    }
                } else {
                    imgSelectorAsientosPrincipal.setVisible(false);
                    pnlBotonesAsientos.setVisible(false);
                    anchorPaneComidaBotones.setVisible(true);
                    anchorPaneDetalle.setVisible(true);
                    btnCancelar.setText("Regresar");
                    btnContinuar.setText("Continuar");
                    indexStageContinue = 1;
                }
                break;
            case 1:
                // TERMINAR FACTURA - REPORTE
                imgFacturando.setVisible(true);
                imgSelectorAsientosPrincipal.setVisible(false);
                anchorPaneComidaBotones.setVisible(false);
                anchorPaneDetalle.setVisible(false);
                anchorPaneDescripcionFactura.setVisible(true);
                
                txtHoraFunsionFinal.setText(nuevaFactura.getHoraFuncion());
                txtSalaFinal.setText(nuevaFactura.getSala());
                txtNombreDePeliculaFinal.setText(nuevaFactura.getNombrePelicula());
                
                //calculo del total final
                
                int suma = 0;
                for (Float f : nuevaFactura.getPreciosComida()) {
                    suma += f;
                }
                txtTotalFinal.setText("C$ " + (suma + (nuevaFactura.getAsientos().size())*100));
                nuevaFactura.setSubTotal((suma + (nuevaFactura.getAsientos().size())*100));
                nuevaFactura.setIva((nuevaFactura.getSubTotal()) * ((float)0.15));
                nuevaFactura.setTotal(nuevaFactura.getIva() + nuevaFactura.getSubTotal());
                
                //-----------------------------------------------------------------------------
                
                listViewAsientosSeleccionadosFinal.getItems().clear();
                listViewAsientosSeleccionadosFinal.getItems().addAll(nuevaFactura.getAsientos());
                listViewAlimentosFinal.getItems().clear();
                listViewAlimentosFinal.getItems().addAll(nuevaFactura.getTipoComida());
                
                btnContinuar.setText("Facturar");
                indexStageContinue = 2;
                break;
            case 2:
                imgFacturando.setVisible(true);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("CONFIRMACIÓN");
                alert.setContentText("¿DESEA GUARDAR LOS CAMBIOS?");
                Optional<ButtonType> action = alert.showAndWait();

                if (action.get() == ButtonType.OK) {
                    
                    
                    // LO GUARDAMOS EN EL ARCHIVO
                    facturaList.writeJsonFacturas(nuevaFactura);
                    facturaList.saveSalaJson();
         
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("INFORMACION");
                    alert1.setContentText("\nIMPRIMIENDO EL REPORTE POR FAVOR ESPERE (OK PARA CONTINUAR)");
                    alert1.showAndWait();
                    
                    //  SE MUESTRA EL REPORTE
                    nuevaFactura.setAsientosFactura(nuevaFactura.toStringAsientos());
                    nuevaFactura.setTipoComidaFactura(nuevaFactura.toStringComida());
                    nuevaFactura.setPreciosComidaFactura(nuevaFactura.toStringPrecios());
                    
                    List<Factura> listReport = new ArrayList<>();
                    listReport.add(nuevaFactura);
                    
                    reporte.generarReporte(listReport);
                    
                    // VOLVEMOS AL STAGE PRINCIPAL
                    indexStageContinue = 3;
                    btnContinuar.setText("Nueva Factura");
                    btnCancelar.setText("Volver al Inicio");
                }
            
                break;
            case 3:
                // Nueva Factura

                    try {
                        // Nueva Factura
                        Node child = loadFXML("facturaStage");
                        contentPane.getChildren().clear();
                        contentPane.getChildren().add(child);
                    } catch (IOException ex) {
                        Logger.getLogger(facturaStageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
            default :
                System.out.println("DEFAULT BTNCONTINUAR");
                break;
        }
    }
    
    //-----------------------------------------------------------------------------
    
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
    //-------COMIDA---------
    
    /*
    
        Palomitas Grandes ----- C$ 50
        Palomitas Pequenias --- C$ 35
        Bebidas Grandes ------- C$ 40
        bebidas Pequeñas ------ C$ 25
        Nachos ---------------- C$ 70
        Hot-Dog --------------- C$ 60
    
    */

    @FXML
    private void cmbxPeliculaOnAction(ActionEvent event) {
    }



    @FXML
    private void btnCombo1OnMouseClicked(MouseEvent event) {
      
        nuevaFactura.getTipoComida().add("COMBO 1");
        nuevaFactura.getPreciosComida().add(Float.valueOf(35+25));
        
        listViewComidaSelec.getItems().add("- COMBO 1");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (35 + 25));
        
        txtTotalComidaSelec.setText("C$ "+ 60);
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo1OnMouseMoved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo1.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 1 PALOMITAS PEQUEÑAS");
        listViewDescripcion.getItems().add("- 1 BEBIDA PEQUEÑA");
        txtTotalDescripcion.setText("C$ " + (35 + 25));
    }
    
    @FXML
    private void btnCombo1OnMouseExited(MouseEvent event) {
        btnCombo1.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

     @FXML
    private void btnCombo2Exited(MouseEvent event) {
        btnCombo2.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnCombo2Clicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("COMBO 2");
        nuevaFactura.getPreciosComida().add(Float.valueOf(50 + 25 + 25));
        
        listViewComidaSelec.getItems().add("- COMBO 2");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (50 + 25 + 25));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo2Moved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo2.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 1 PALOMITAS GRANDES");
        listViewDescripcion.getItems().add("- 2 BEBIDAS PEQUEÑAS");
        txtTotalDescripcion.setText("C$ " + (50 + 25 + 25));
    }

    @FXML
    private void btnCombo3Exited(MouseEvent event) {
        btnCombo3.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnCombo3Clicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("COMBO 3");
        nuevaFactura.getPreciosComida().add(Float.valueOf(35 + 25 + 60));
        
        listViewComidaSelec.getItems().add("- COMBO 3");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (35 + 25 + 60));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo3Moved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo3.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 1 PALOMITAS PEQUEÑAS");
        listViewDescripcion.getItems().add("- 1 BEBIDA PEQUEÑA");
        listViewDescripcion.getItems().add("- 1 HOT-DOG");
        txtTotalDescripcion.setText("C$ " + (35 + 25 + 60));
    }

    @FXML
    private void btnCombo4Exited(MouseEvent event) {
        btnCombo4.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnCombo4Clicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("COMBO 4");
        nuevaFactura.getPreciosComida().add(Float.valueOf(35 + 25 + 70));
        
        listViewComidaSelec.getItems().add("- COMBO 4");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (35 + 25 + 70));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo4Moved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo4.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 1 PALOMITAS PEQUEÑAS");
        listViewDescripcion.getItems().add("- 1 BEBIDA PEQUEÑA");
        listViewDescripcion.getItems().add("- 1 NACHOS");
        txtTotalDescripcion.setText("C$ " + (35 + 25 + 70));
    }

    @FXML
    private void btnCombo5Exited(MouseEvent event) {
        btnCombo5.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnCombo5Clicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("COMBO 5");
        nuevaFactura.getPreciosComida().add(Float.valueOf(50 + 40 + 40 + 60 + 60));
        
        listViewComidaSelec.getItems().add("- COMBO 5");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (50 + 40 + 40 + 60 + 60));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo5Moved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo5.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 1 PALOMITAS GRANDES");
        listViewDescripcion.getItems().add("- 2 BEBIDAS GRANDES");
        listViewDescripcion.getItems().add("- 2 HOT-DOGS");
        txtTotalDescripcion.setText("C$ " + (50 + 40 + 40 + 60 + 60));
    }

    @FXML
    private void btnCombo6Exited(MouseEvent event) {
        btnCombo6.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnCombo6Clicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("COMBO 6");
        nuevaFactura.getPreciosComida().add(Float.valueOf(50 + 40 + 40 + 70));
        
        listViewComidaSelec.getItems().add("- COMBO 6");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (50 + 40 + 40 + 70));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo6Moved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo6.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 1 PALOMITA GRANDE");
        listViewDescripcion.getItems().add("- 2 BEBIDAS GRANDES");
        listViewDescripcion.getItems().add("- 1 NACHO");
        txtTotalDescripcion.setText("C$ " + (50 + 40 + 40 + 70));
    }

    @FXML
    private void btnCombo7Exited(MouseEvent event) {
        btnCombo7.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnCombo7Clicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("COMBO 7");
        nuevaFactura.getPreciosComida().add(Float.valueOf(60 + 60 + 40 + 40 + 70));
        
        listViewComidaSelec.getItems().add("- COMBO 7");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (60 + 60 + 40 + 40 + 70));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo7Moved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo7.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 2 HOT-DOG");
        listViewDescripcion.getItems().add("- 2 BEBIDAS GRANDES");
        listViewDescripcion.getItems().add("- 1 NACHO");
        txtTotalDescripcion.setText("C$ " + (60 + 60 + 40 + 40 + 70));
    }

    @FXML
    private void btnCombo8Exited(MouseEvent event) {
        btnCombo8.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnCombo8Clicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("COMBO 8");
        nuevaFactura.getPreciosComida().add(Float.valueOf(50 + 60 + 60 + 40 + 40 + 70));
        
        listViewComidaSelec.getItems().add("- COMBO 8");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (50 + 60 + 60 + 40 + 40 + 70));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnCombo8moved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnCombo8.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- 1 PALOMITA GRANDE");
        listViewDescripcion.getItems().add("- 2 HOT-DOG");
        listViewDescripcion.getItems().add("- 2 BEBIDAS GRANDES");
        listViewDescripcion.getItems().add("- 1 NACHO");
        txtTotalDescripcion.setText("C$ " + (50 + 60 + 60 + 40 + 40 + 70));
    }
    
    @FXML
    private void btnPalomitaGrandeExited(MouseEvent event) {
        btnPalomitaGrande.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnPalomitaGrandeClicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("PALOMITA GRANDE");
        nuevaFactura.getPreciosComida().add(Float.valueOf(50));
        
        listViewComidaSelec.getItems().add("- PALOMITA GRANDE");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (50));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnPalomitaGrandeMoved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnPalomitaGrande.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- PALOMITA GRANDE");
        txtTotalDescripcion.setText("C$ " + (50));
    }

    @FXML
    private void btnPalomitaPequeExited(MouseEvent event) {
        btnPalomitaPequenia.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ " );
    }

    @FXML
    private void btnPalomitaPequeClicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("PALOMITA PEQUEÑA");
        nuevaFactura.getPreciosComida().add(Float.valueOf(35));
        
        listViewComidaSelec.getItems().add("- PALOMITA PEQUEÑA");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (35));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnPalomitaPequeMoved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnPalomitaPequenia.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- PALOMITA PEQUEÑA");
        txtTotalDescripcion.setText("C$ " + (35));
    }

    @FXML
    private void btnBebidaGrandeExited(MouseEvent event) {
        btnBebidaGrande.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnBebidaGrandeClicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("BEBIDA GRANDE");
        nuevaFactura.getPreciosComida().add(Float.valueOf(40));
        
        listViewComidaSelec.getItems().add("- BEBIDA GRANDE");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (40));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnBebidaGrandeMoved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnBebidaGrande.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- BEBIDA GRANDE");
        txtTotalDescripcion.setText("C$ " + (40));
    }

    @FXML
    private void btnBebidaPequeExited(MouseEvent event) {
        btnBebidaPequenia.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnBebidaPequeClicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("BEBIDA PEQUEÑA");
        nuevaFactura.getPreciosComida().add(Float.valueOf(25));
        
        listViewComidaSelec.getItems().add("- BEBIDA PEQUEÑA");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (25));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnBebidaPequeMoved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnBebidaPequenia.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- BEBIDA PEQUEÑA");
        txtTotalDescripcion.setText("C$ " + (25));
    }

    @FXML
    private void btnNachosExited(MouseEvent event) {
        btnNachos.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnNachosClicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("NACHOS");
        nuevaFactura.getPreciosComida().add(Float.valueOf(70));
        
        listViewComidaSelec.getItems().add(" NACHOS");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (70));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnNachosMoved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnNachos.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- NACHOS");
        txtTotalDescripcion.setText("C$ " + (70));
    }

    @FXML
    private void btnHotDogExited(MouseEvent event) {
        btnHotDog.setEffect(null);
        listViewDescripcion.getItems().clear();
        txtTotalDescripcion.setText("C$ ");
    }

    @FXML
    private void btnHotDogClicked(MouseEvent event) {
        nuevaFactura.getTipoComida().add("HOT - DOG");
        nuevaFactura.getPreciosComida().add(Float.valueOf(60));
        
        listViewComidaSelec.getItems().add("- HOT - DOG");
        listViewPrecioComidaSelec.getItems().add(("C$ ") + (60));
        sumatoriaDePreciosDeComida();
    }

    @FXML
    private void btnHotDogMoved(MouseEvent event) {
        listViewDescripcion.getItems().clear();
        btnHotDog.setEffect(new Bloom());
        listViewDescripcion.getItems().add("- HOT-DOG");
        txtTotalDescripcion.setText("C$ " + 60);
    }
}
