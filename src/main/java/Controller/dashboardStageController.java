package Controller;

import animatefx.animation.AnimationFX;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDownBig;
import animatefx.animation.Pulse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import sun.applet.Main;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class dashboardStageController implements Initializable {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private ImageView peliculas1;
    @FXML
    private ImageView peliculas2;
    @FXML
    private ImageView peliculas3;
    @FXML
    private ImageView peliculas4;
    @FXML
    private ImageView peliculas5;
    @FXML
    private ImageView peliculas6;
    @FXML
    private ImageView peliculas7;
    @FXML
    private ImageView peliculas8;

    private List<ImageView> peliculas = new ArrayList<ImageView>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        peliculas.add(peliculas1);
        peliculas.add(peliculas2);
        peliculas.add(peliculas3);
        peliculas.add(peliculas4);
        peliculas.add(peliculas5);
        peliculas.add(peliculas6);
        peliculas.add(peliculas7);
        peliculas.add(peliculas8);
        peliculas.forEach((p) -> {{
            new Pulse(p).setCycleCount(AnimationFX.INDEFINITE).play();
        }
        });

    }

    @FXML
    public void selectingMovie(MouseEvent e) {

    }
}
