package Controller;

import Model.TableModel;
import Pojo.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class empladosStageController implements Initializable {

    Database database;

    ObservableList<TableModel> obList = FXCollections.observableArrayList();

    @FXML
    private AnchorPane contentPane;

    @FXML
    private TableView<TableModel> table_Emplados;

    @FXML
    private TableColumn<TableModel, Integer> column_ID;

    @FXML
    private TableColumn<TableModel, String> column_COD;

    @FXML
    private TableColumn<TableModel, String> column_USERNAME;

    @FXML
    private TableColumn<TableModel, String> column_FIRSTNAME;

    @FXML
    private TableColumn<TableModel, String> column_LASTNAME;

    @FXML
    private TableColumn<TableModel, String> column_CEDULA;

    @FXML
    private TableColumn<TableModel, String> column_TELEFONO;

    @FXML
    private TableColumn<TableModel, String> column_EMAIL;

    @FXML
    private TableColumn<TableModel, Date> column_HIREDATE;

    @FXML
    private TableColumn<TableModel, String> column_CARGO;

    @FXML
    private TableColumn<TableModel, String> column_TURNO;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            database = new Database();
            database.showAll(obList);
            column_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            column_COD.setCellValueFactory(new PropertyValueFactory<>("cod"));
            column_USERNAME.setCellValueFactory(new PropertyValueFactory<>("username"));
            column_FIRSTNAME.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            column_LASTNAME.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            column_CEDULA.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            column_TELEFONO.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            column_EMAIL.setCellValueFactory(new PropertyValueFactory<>("email"));
            column_HIREDATE.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
            column_CARGO.setCellValueFactory(new PropertyValueFactory<>("cargo"));
            column_TURNO.setCellValueFactory(new PropertyValueFactory<>("turno"));
            table_Emplados.setItems(obList);
        } catch (SQLException e) { }
    }
}
