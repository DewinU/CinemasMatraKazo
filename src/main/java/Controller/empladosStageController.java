package Controller;

import Model.UserTableModel;
import Pojo.Database;
import Pojo.Pelicula;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class empladosStageController implements Initializable {

    private Alert alerta;

    private Database database;

    public static ObservableList<UserTableModel> obList;

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
    private TableColumn<UserTableModel, String> column_HIREDATE;

    @FXML
    private TableColumn<UserTableModel, String> column_CARGO;

    @FXML
    private TableColumn<UserTableModel, String> column_TURNO;

    @FXML
    private JFXTextField txtBuscar;

    @FXML
    private ImageView uploadedImage;

    @FXML
    private Text txtNombre;

    @FXML
    private Text txtCargo;

    @FXML
    private Text txtNumero;

    @FXML
    private Text txtDireccion;

    @FXML
    void showEmpleado(MouseEvent event) {
        UserTableModel user = table_Emplados.getSelectionModel().getSelectedItem();
        if(user != null) {
            uploadedImage.setImage(new Image(new File(user.getFotoUrl()).toURI().toString()));
            txtNombre.setText(user.getFirstname() + " " + user.getLastname());
            txtCargo.setText(user.getCargo());
            txtNumero.setText(user.getTelefono());
            txtDireccion.setText(user.getEmail());
        }
    }

    @FXML
    void buttonDelete(MouseEvent event) throws SQLException {
        UserTableModel user = table_Emplados.getSelectionModel().getSelectedItem();
        if(user == null){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Vaya!");
            alerta.setContentText("Debes elegir un empleado a eliminar! ");
            alerta.show();
        }
        else{
            alerta = new Alert(Alert.AlertType.CONFIRMATION,"¿Seguro que desea eliminar esta pelicula?", ButtonType.YES,ButtonType.NO);
            alerta.showAndWait();
            if(alerta.getResult() == ButtonType.YES){
                obList.remove(user);
                database.deleteEmpleado(user.getId());
            }
        }

    }

    @FXML
    void buttonEdit(MouseEvent event) throws IOException {
        UserTableModel user = table_Emplados.getSelectionModel().getSelectedItem();
        if(user == null){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Vaya!");
            alerta.setContentText("Debes elegir un empleado a editar! ");
            alerta.show();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/empleadoDialog.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.APPLICATION_MODAL);
            empleadoDialogController empleadoDlg = fxmlLoader.getController();
            empleadoDlg.isEdit(user,true,obList.indexOf(user));
            stage.show();
            table_Emplados.refresh();
        }

    }

    @FXML
    void buttonNew(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/empleadoDialog.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void filterTextField() {
        FilteredList<UserTableModel> filteredUsers = new FilteredList<>(obList);
        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredUsers.setPredicate((Predicate<? super UserTableModel>) user -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCase = newValue.toLowerCase();

                if (user.getFirstname().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (user.getLastname().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (user.getEmail().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (user.getCedula().toLowerCase().contains(lowerCase)) {
                    return true;
                } else if (user.getTelefono().toLowerCase().contains(lowerCase)) {
                    return true;
                }else if (user.getUsername().toLowerCase().contains(lowerCase)) {
                    return true;
                }else if (user.getTurno().toLowerCase().contains(lowerCase)) {
                    return true;
                }else if (user.getHiredate().toString().toLowerCase().contains(lowerCase)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<UserTableModel> sortedList = new SortedList<>(filteredUsers);
        sortedList.comparatorProperty().bind(table_Emplados.comparatorProperty());
        table_Emplados.setItems(sortedList);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            obList = FXCollections.observableArrayList();
            database = new Database();
            database.showAll(obList);
            column_ID.setCellValueFactory(data -> {
                int index = obList.indexOf(data.getValue());
                return new SimpleIntegerProperty(++index).asObject();
            });
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
            filterTextField();
        } catch (SQLException e) { }
    }
}
