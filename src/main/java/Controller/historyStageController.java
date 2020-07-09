package Controller;

import Model.FacturaListModel;
import Pojo.Factura;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class historyStageController implements Initializable {

    @FXML
    private AnchorPane contentPane;
    @FXML
    private TableColumn<Factura, Integer> tbColID;
    @FXML
    private TableColumn<Factura, String> tblColPelicula;
    @FXML
    private TableColumn<Factura, String> tblColumFuncion;
    @FXML
    private TableColumn<Factura, String> tblColumSala;
    @FXML
    private TableColumn<Factura, String> tblColumAsientos;
    @FXML
    private TableColumn<Factura, String> tblColumComida;
    @FXML
    private TableColumn<Factura, String> tblColumPrecio;
    @FXML
    private TableColumn<Factura, String> tblColumCarnet;
    @FXML
    private TableColumn<Factura, Float> tblColumTotal;

    private ObservableList<Factura> facturaList;
    
    private FacturaListModel facturaModel;
    @FXML
    private TableView<Factura> tableViewPrincipal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contentPane.setStyle("-fx-border-color: #000000");
        
        facturaModel = new FacturaListModel();
        facturaModel.LoadFromJsonFacturas();
        facturaList = FXCollections.observableArrayList(facturaModel.getListFactura());
        
        
        tbColID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblColPelicula.setCellValueFactory(new PropertyValueFactory<>("nombrePelicula"));
        tblColumFuncion.setCellValueFactory(new PropertyValueFactory<>("horaFuncion"));
        tblColumSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
        tblColumAsientos.setCellValueFactory(new PropertyValueFactory<>("asientos"));
        tblColumComida.setCellValueFactory(new PropertyValueFactory<>("tipoComida"));
        tblColumPrecio.setCellValueFactory(new PropertyValueFactory<>("preciosComida"));
        tblColumCarnet.setCellValueFactory(new PropertyValueFactory<>("carnetEmpleado"));
        tblColumTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        tableViewPrincipal.setItems(facturaList);
    }
}
