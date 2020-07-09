package Controller;

import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.loadFXML;

public class menuStageController implements Initializable {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private ImageView combo1;

    @FXML
    private AnchorPane optionsCombo1;

    @FXML
    private ImageView cancelar1;

    @FXML
    private Button informacion1;

    @FXML
    private ImageView combo2;

    @FXML
    private AnchorPane optionsCombo2;

    @FXML
    private Button informacion2;

    @FXML
    private ImageView cancelar2;

    @FXML
    private ImageView combo3;

    @FXML
    private AnchorPane optionsCombo3;

    @FXML
    private Button informacion3;

    @FXML
    private ImageView cancelar3;

    @FXML
    private ImageView combo4;

    @FXML
    private AnchorPane optionsCombo4;

    @FXML
    private Button informacion4;

    @FXML
    private ImageView cancelar4;

    @FXML
    private ImageView combo5;

    @FXML
    private AnchorPane optionsCombo5;

    @FXML
    private Button informacion5;

    @FXML
    private ImageView cancelar5;

    @FXML
    private ImageView combo6;

    @FXML
    private AnchorPane optionsCombo6;

    @FXML
    private Button informacion6;

    @FXML
    private ImageView cancelar6;

    @FXML
    private ImageView combo7;

    @FXML
    private AnchorPane optionsCombo7;

    @FXML
    private ImageView cancelar7;

    @FXML
    private Button informacion7;

    @FXML
    private ImageView combo8;

    @FXML
    private AnchorPane optionsCombo8;

    @FXML
    private ImageView cancelar8;

    @FXML
    private Button informacion8;

    @FXML
    private HBox datosCombo;

    @FXML
    private Label precio;

    @FXML
    private Label nombreCombo;

    @FXML
    private Label contenidoCombo;

    @FXML
    private ImageView comboSelectedImg;

    @FXML
    private ImageView comeBack;

    @FXML
    private Label txtCombos;

    @FXML
    private ImageView ind1;

    @FXML
    private ImageView ind2;

    @FXML
    private ImageView ind3;

    @FXML
    private ImageView ind4;

    @FXML
    private ImageView ind5;

    @FXML
    private ImageView ind6;

    @FXML
    private AnchorPane opcionesInd1;

    @FXML
    private AnchorPane opcionesInd2;

    @FXML
    private AnchorPane opcionesInd3;

    @FXML
    private AnchorPane opcionesInd4;

    @FXML
    private AnchorPane opcionesInd5;

    @FXML
    private AnchorPane opcionesInd6;

    @FXML
    private Label txtPalomitas;

    @FXML
    private Label txtBebidas;

    @FXML
    private Label txtVarios;

    private List<AnchorPane> opciones = new ArrayList<>();
    private List<ImageView> combosImg = new ArrayList<>();
    private List<AnchorPane> opcInd = new ArrayList<>();
    private List<ImageView> individuales = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hideElements(optionsCombo1);
        hideElements(optionsCombo2);
        hideElements(optionsCombo3);
        hideElements(optionsCombo4);
        hideElements(optionsCombo5);
        hideElements(optionsCombo6);
        hideElements(optionsCombo7);
        hideElements(optionsCombo8);
        hideElements(opcionesInd1);
        hideElements(opcionesInd2);
        hideElements(opcionesInd3);
        hideElements(opcionesInd4);
        hideElements(opcionesInd5);
        hideElements(opcionesInd6);

        opciones.add(optionsCombo1);
        opciones.add(optionsCombo2);
        opciones.add(optionsCombo3);
        opciones.add(optionsCombo4);
        opciones.add(optionsCombo5);
        opciones.add(optionsCombo6);
        opciones.add(optionsCombo7);
        opciones.add(optionsCombo8);

        combosImg.add(combo1);
        combosImg.add(combo2);
        combosImg.add(combo3);
        combosImg.add(combo4);
        combosImg.add(combo5);
        combosImg.add(combo6);
        combosImg.add(combo7);
        combosImg.add(combo8);

        individuales.add(ind1);
        individuales.add(ind2);
        individuales.add(ind3);
        individuales.add(ind4);
        individuales.add(ind5);
        individuales.add(ind6);

        opcInd.add(opcionesInd1);
        opcInd.add(opcionesInd2);
        opcInd.add(opcionesInd3);
        opcInd.add(opcionesInd4);
        opcInd.add(opcionesInd5);
        opcInd.add(opcionesInd6);

        hideElements(comeBack);
        hideElements(datosCombo);
    }

    @FXML
    public void seeOptions(MouseEvent e) {
        String comboSeleccionado = e.getTarget().toString().substring(13, 19);
        String individualSeleccionado = e.getTarget().toString().substring(13,17);
        if (comboSeleccionado.equals(combo1.getId())) {
            showElements(optionsCombo1);
            return;
        } else if (comboSeleccionado.equals(combo2.getId())) {
            showElements(optionsCombo2);
            return;
        } else if (comboSeleccionado.equals(combo3.getId())) {
            showElements(optionsCombo3);
            return;
        } else if (comboSeleccionado.equals(combo4.getId())) {
            showElements(optionsCombo4);
            return;
        } else if (comboSeleccionado.equals(combo5.getId())) {
            showElements(optionsCombo5);
            return;
        } else if (comboSeleccionado.equals(combo6.getId())) {
            showElements(optionsCombo6);
            return;
        } else if (comboSeleccionado.equals(combo7.getId())) {
            showElements(optionsCombo7);
            return;
        } else if (comboSeleccionado.equals(combo8.getId())) {
            showElements(optionsCombo8);
            return;
        }

        if (individualSeleccionado.equals(ind1.getId())) {
            showElements(opcionesInd1);
        } else if (individualSeleccionado.equals(ind2.getId())) {
            showElements(opcionesInd2);
        } else if (individualSeleccionado.equals(ind3.getId())) {
            showElements(opcionesInd3);
        } else if (individualSeleccionado.equals(ind4.getId())) {
            showElements(opcionesInd4);
        } else if (individualSeleccionado.equals(ind5.getId())) {
            showElements(opcionesInd5);
        } else if (individualSeleccionado.equals(ind6.getId())) {
            showElements(opcionesInd6);
        }
    }

    @FXML
    public void unSeeOptions(MouseEvent e) {
        String comboSeleccionado = e.getTarget().toString().substring(14, 27);
        String indSeleccionado = e.getTarget().toString().substring(14, 26);
        if (comboSeleccionado.equals(optionsCombo1.getId())) {
            hideElements(optionsCombo1);
            return;
        } else if (comboSeleccionado.equals(optionsCombo2.getId())) {
            hideElements(optionsCombo2);
            return;
        } else if (comboSeleccionado.equals(optionsCombo3.getId())) {
            hideElements(optionsCombo3);
            return;
        } else if (comboSeleccionado.equals(optionsCombo4.getId())) {
            hideElements(optionsCombo4);
            return;
        } else if (comboSeleccionado.equals(optionsCombo5.getId())) {
            hideElements(optionsCombo5);
            return;
        } else if (comboSeleccionado.equals(optionsCombo6.getId())) {
            hideElements(optionsCombo6);
            return;
        } else if (comboSeleccionado.equals(optionsCombo7.getId())) {
            hideElements(optionsCombo7);
            return;
        } else if (comboSeleccionado.equals(optionsCombo8.getId())) {
            hideElements(optionsCombo8);
            return;
        }

        if (indSeleccionado.equals(opcionesInd1.getId())) {
            hideElements(opcionesInd1);
        } else if (indSeleccionado.equals(opcionesInd2.getId())) {
            hideElements(opcionesInd2);
        } else if (indSeleccionado.equals(opcionesInd3.getId())) {
            hideElements(opcionesInd3);
        } else if (indSeleccionado.equals(opcionesInd4.getId())) {
            hideElements(opcionesInd4);
        } else if (indSeleccionado.equals(opcionesInd5.getId())) {
            hideElements(opcionesInd5);
        } else if (indSeleccionado.equals(opcionesInd6.getId())) {
            hideElements(opcionesInd6);
        }
    }

    @FXML
    public void showOffOptions(MouseEvent e) {
        String botonSeleccionado = e.getTarget().toString().substring(13, 22);
        if (botonSeleccionado.equals(cancelar1.getId()) && !(botonSeleccionado.equals(cancelar1.getId()))) {
            hideElements(optionsCombo1);
        } else if (botonSeleccionado.equals(cancelar2.getId()) && !(botonSeleccionado.equals(cancelar2.getId()))) {
            hideElements(optionsCombo2);
        } else if (botonSeleccionado.equals(cancelar3.getId()) && !(botonSeleccionado.equals(cancelar3.getId()))) {
            hideElements(optionsCombo3);
        } else if (botonSeleccionado.equals(cancelar4.getId()) && !(botonSeleccionado.equals(cancelar4.getId()))) {
            hideElements(optionsCombo4);
        } else if (botonSeleccionado.equals(cancelar5.getId()) && !(botonSeleccionado.equals(cancelar5.getId()))) {
            hideElements(optionsCombo5);
        } else if (botonSeleccionado.equals(cancelar6.getId()) && !(botonSeleccionado.equals(cancelar6.getId()))) {
            hideElements(optionsCombo6);
        } else if (botonSeleccionado.equals(cancelar7.getId()) && !(botonSeleccionado.equals(cancelar7.getId()))) {
            hideElements(optionsCombo7);
        } else if (botonSeleccionado.equals(cancelar8.getId()) && !(botonSeleccionado.equals(cancelar8.getId()))) {
            hideElements(optionsCombo8);
        }
    }

    public void hideElements(Node element) {
        element.setDisable(true);
        element.setVisible(false);
    }

    public void showElements(Node element) {
        element.setDisable(false);
        element.setVisible(true);
    }

    @FXML
    public void showInfo(MouseEvent e) {
        showElements(comeBack);
        showElements(datosCombo);
        new ZoomIn(comeBack).play();
        new ZoomIn(datosCombo).play();
        comeBack.getStyleClass().add("util-buttons");

        opcInd.forEach(o -> {
            hideElements(o);
        });

        individuales.forEach(i -> {
            new ZoomOut(i).play();
            hideElements(i);
        });

        combosImg.forEach(c -> {
            new ZoomOut(c).play();
            hideElements(c);
        });

        new ZoomOut(txtCombos).play();
        new ZoomOut(txtPalomitas).play();
        new ZoomOut(txtBebidas).play();
        new ZoomOut(txtVarios).play();
        opciones.forEach(o -> {
            hideElements(o);
        });



        String contenido = "";
        InputStream urlFoto;
        String comboSeleccionado = e.getSource().toString().substring(10,22);

        if (comboSeleccionado.equals(informacion1.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo1.png");
            contenido = "1 - Palomita pequeña" + "\n" +
                         "1 - Bebida pequeña";
            setInfo("C$ 60.00", "Combo 1", contenido, urlFoto);
        } else if (comboSeleccionado.equals(informacion2.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo2.png");
            contenido = "1 - Palomita grande" + "\n" +
                    "2 - Bebidas pequeñas";
            setInfo("C$ 100.00", "Combo 2", contenido, urlFoto);
        } else if (comboSeleccionado.equals(informacion3.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo3.png");
            contenido = "1 - Palomita pequeña" + "\n" +
                    "1 Bebida pequeña" + "\n" +
                    "1 - Hotdog";
            setInfo("C$ 120.00", "Combo 3", contenido, urlFoto);
        } else if (comboSeleccionado.equals(informacion4.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo4.png");
            contenido = "1 - Palomita pequeña" + "\n" +
                    "1 - Bebida pequeña" + "\n" +
                    "1 - Nacho";
            setInfo("C$ 130.00", "Combo 4", contenido, urlFoto);
        } else if (comboSeleccionado.equals(informacion5.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo5.png");
            contenido = "1 - Palomita grande" + "\n" +
                    "2 - Bebidas grandes" + "\n" +
                    "2 - Hotdogs";
            setInfo("C$ 250.00", "Combo 5", contenido, urlFoto);
        } else if (comboSeleccionado.equals(informacion6.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo6.png");
            contenido = "1 - Palomita grande" + "\n" +
                    "2 - Bebidas grandes" + "\n" +
                    "1 - Nacho";
            setInfo("C$ 200.00", "Combo 6", contenido, urlFoto);
        } else if (comboSeleccionado.equals(informacion7.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo7.png");
            contenido = "2 - Hotdogs" + "\n" +
                    "2 - Bebidas grandes" + "\n" +
                    "1 -  Nacho";
            setInfo("C$ 270.00", "Combo 7", contenido, urlFoto);
        } else if (comboSeleccionado.equals(informacion8.getId())) {
            urlFoto = getClass().getResourceAsStream("/Images/combo8.png");
            contenido = "1 - Palomita grande" + "\n" +
                    "2 - Hotdogs" + "\n" +
                    "2 - Bebidas grandes" + "\n" +
                    "1 - Nacho";
            setInfo("C$ 320.00", "Combo 8", contenido, urlFoto);
        }
    }

    @FXML
    public void goToFactura() {
        Node child = null;
        try {
            child = loadFXML("facturaStage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentPane.getChildren().clear();
        contentPane.getChildren().add(child);
    }

    @FXML
    public void goBackToOptions() {
        hideElements(datosCombo);
        hideElements(comeBack);
        new ZoomIn(txtCombos).play();
        new ZoomIn(txtPalomitas).play();
        new ZoomIn(txtBebidas).play();
        new ZoomIn(txtVarios).play();

        opciones.forEach(o -> {
            hideElements(o);
        });

        opcInd.forEach(o -> {
            hideElements(o);
        });

        individuales.forEach(i -> {
            showElements(i);
            new ZoomIn(i).play();
        });

        combosImg.forEach(c -> {
            showElements(c);
            new ZoomIn(c).play();
        });

    }

    public void setInfo(String cantidad, String combo, String descripcion, InputStream url) {
        precio.setText(cantidad);
        nombreCombo.setText(combo);
        contenidoCombo.setText(descripcion);
        comboSelectedImg.setImage(new Image(url));
    }
}