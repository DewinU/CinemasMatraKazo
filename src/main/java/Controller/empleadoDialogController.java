package Controller;

import Model.UserTableModel;
import Pojo.Database;
import Pojo.Pelicula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class empleadoDialogController implements Initializable {
    private ObservableList<String> cargo = FXCollections.observableArrayList("Gerente","Cajero","Administrador");
    private ObservableList<String> turno = FXCollections.observableArrayList("Matutino","Vespertirno","Nocturno","No Aplica");

    private Database database;

    private UserTableModel usuario;

    private Stage stage;

    private double x;

    private double y;

    private Boolean isEdit = false;

    private int index;

    private int idDb;

    @FXML
    private ImageView uploadedImage;

    @FXML
    private TextField txtCod;

    @FXML
    private TextField txtUrl;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtCedula;

    @FXML
    private ComboBox<String> cmbCargo;

    @FXML
    private ComboBox<String> cmbTurno;

    @FXML
    void btnImageFromSystem(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter
                        ("Image files (*.jpg, *.jpeg,  *.png)", "*.png", "*.jpg", "*.jpeg"));
        File selectedImage = fc.showOpenDialog(null);
        if (selectedImage == null)
            return;
        Image img = SwingFXUtils.toFXImage(ImageIO.read(selectedImage), null);
        uploadedImage.setImage(img);
        txtUrl.setText(selectedImage.getPath());

    }

    @FXML
    void btnImageFromWeb(MouseEvent event) {
        try{
            Image internetImage = new Image(txtUrl.getText());
            uploadedImage.setImage(internetImage);
        }
        catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(),
                    ButtonType.OK);
            alert.showAndWait();
        }

    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
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
    void btnAdd(MouseEvent event) throws IOException, SQLException {
        saveToFile(uploadedImage);
        if(isEdit){
            usuario = new UserTableModel(txtCod.getText(),txtUsuario.getText(),txtPassword.getText(),txtFirstName.getText(),
                    txtLastName.getText(),txtCedula.getText(),txtPhoneNumber.getText(),txtEmail.getText(),txtAddress.getText(),LocalDate.now().toString(),
                    cmbCargo.getValue(),cmbTurno.getValue(),getImagePath());
            database.updateEmpleado(idDb,txtCod.getText(),txtUsuario.getText(),txtFirstName.getText(),txtLastName.getText(),txtCedula.getText(),
                    txtPhoneNumber.getText(),txtEmail.getText(),txtAddress.getText(),cmbCargo.getValue(),cmbTurno.getValue(),
                    getImagePath());
            System.out.println(index);
            empladosStageController.obList.set(index,usuario);
        }
        else{
            usuario = new UserTableModel(txtCod.getText(),txtUsuario.getText(),txtPassword.getText(),txtFirstName.getText(),
                    txtLastName.getText(),txtCedula.getText(),txtPhoneNumber.getText(),txtEmail.getText(),txtAddress.getText(),LocalDate.now().toString(),
                    cmbCargo.getValue(),cmbTurno.getValue(),getImagePath());
            database.addEmpleado(usuario.getCod(),usuario.getUsername(),usuario.getPassword(),usuario.getFirstname(),usuario.getLastname(),usuario.getCedula(),usuario.getTelefono(),usuario.getEmail(),usuario.getDireccion(),LocalDate.now().toString(),usuario.getCargo(),usuario.getTurno(),usuario.getFotoUrl());
            empladosStageController.obList.add(usuario);

        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "La operación se ha hecho con exito", ButtonType.OK);
        alert.show();
    }

    @FXML
    void btnCancel(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.WARNING, "¿Esta seguro que desea cancelar?", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            alert.close();
            stage.close();
        }
    }


    public void saveToFile(ImageView image) throws IOException {
        String folderPath = "./src/main/resources/Empleados/";
        File imageFile = new File(folderPath, txtUsuario.getText() + ".png");
        BufferedImage bImage = SwingFXUtils.fromFXImage(image.getImage(), null);
        ImageIO.write(bImage, "png", imageFile);
    }

    public String getImagePath(){
        return "./src/main/resources/Empleados/" + txtUsuario.getText() + ".png";
    }

    public  void isEdit(UserTableModel usuario, boolean state, int id){
        uploadedImage.setImage(new Image(new File(usuario.getFotoUrl()).toURI().toString()));
        txtUsuario.setText(usuario.getUsername());
        txtPassword.setEditable(false);
        txtFirstName.setText(usuario.getFirstname());
        txtLastName.setText(usuario.getLastname());
        txtPhoneNumber.setText(usuario.getTelefono());
        txtEmail.setText(usuario.getEmail());
        txtCedula.setText(usuario.getCedula());
        txtAddress.setText(usuario.getDireccion());
        cmbCargo.setValue(usuario.getCargo());
        cmbTurno.setValue(usuario.getTurno());
        txtCod.setText(usuario.getCod());
        txtUrl.setText(usuario.getFotoUrl());
        isEdit = state;
        index = id;
        idDb = usuario.getId();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            database = new Database();
            cmbTurno.setItems(turno);
            cmbCargo.setItems(cargo);
        } catch (SQLException throwables) { }

    }
}
