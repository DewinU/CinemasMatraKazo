package Controller;

import Model.FacturaListModel;
import Pojo.Factura;
import Pojo.Reporte;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    @FXML
    private Button btnVerReporte;
    @FXML
    private Button btnEliminar;
    
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

    @FXML
    private void btnVerReporteOnAction(ActionEvent event) {
        Reporte report = new Reporte();
        report.generarReportes(facturaModel.getListFactura());
    }

    @FXML
    private void btnEliminarOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("CONFIRMACIÓN");
                alert.setContentText("¿DESEA ELIMINAR LA FACTURA?");
                Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {

            if (!(tableViewPrincipal.getSelectionModel().getSelectedItem() == null)) {
                Factura f = tableViewPrincipal.getSelectionModel().getSelectedItem();

                facturaModel.getListFactura().remove(f);
                int i = 0;
                for (Factura fac : facturaModel.getListFactura()) {
                    fac.setId(i);
                    i++;
                }
                
                facturaModel.writeJsonFacturas();
                facturaList = FXCollections.observableArrayList(facturaModel.getListFactura());
                tableViewPrincipal.getItems().clear();
                tableViewPrincipal.setItems(facturaList);
            }
            
        }

        
    }
}
