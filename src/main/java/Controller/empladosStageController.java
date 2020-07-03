package Controller;

import Model.UserTableModel;
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

    ObservableList<UserTableModel> obList = FXCollections.observableArrayList();

    @FXML
    private AnchorPane contentPane;

    @FXML
    private TableView<UserTableModel> table_Emplados;

    @FXML
    private TableColumn<UserTableModel, Integer> column_ID;

    @FXML
    private TableColumn<UserTableModel, String> column_COD;

    @FXML
    private TableColumn<UserTableModel, String> column_USERNAME;

    @FXML
    private TableColumn<UserTableModel, String> column_FIRSTNAME;

    @FXML
    private TableColumn<UserTableModel, String> column_LASTNAME;

    @FXML
    private TableColumn<UserTableModel, String> column_CEDULA;

    @FXML
    private TableColumn<UserTableModel, String> column_TELEFONO;

    @FXML
    private TableColumn<UserTableModel, String> column_EMAIL;

    @FXML
    private TableColumn<UserTableModel, Date> column_HIREDATE;

    @FXML
    private TableColumn<UserTableModel, String> column_CARGO;

    @FXML
    private TableColumn<UserTableModel, String> column_TURNO;





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
