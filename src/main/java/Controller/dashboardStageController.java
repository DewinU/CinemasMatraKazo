package Controller;

import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class dashboardStageController implements Initializable {

    @FXML
    private AnchorPane contentPane;
    @FXML
    private AnchorPane selectedMovie;

    //Instanciando los posters de peliculas
    @FXML
    private VBox peliculas1;
    @FXML
    private VBox peliculas2;
    @FXML
    private VBox peliculas3;
    @FXML
    private VBox peliculas4;
    @FXML
    private VBox peliculas5;
    @FXML
    private VBox peliculas6;
    @FXML
    private VBox peliculas7;
    @FXML
    private VBox peliculas8;
    @FXML
    private VBox movieSelected;

    @FXML
    private ImageView movieImage;
    @FXML
    private ImageView poster1;
    @FXML
    private ImageView poster2;
    @FXML
    private ImageView poster3;
    @FXML
    private ImageView poster4;
    @FXML
    private ImageView poster5;
    @FXML
    private ImageView poster6;
    @FXML
    private ImageView poster7;
    @FXML
    private ImageView poster8;
    @FXML
    private ImageView filterImage;


    private List<VBox> peliculas = new ArrayList<VBox>();
    public static ExecutorService threadpool;
    public Runnable task1;
    boolean state = false;

    //Creando 2 listas para peliculas pares e impares
    private List<VBox> peliculasP = new ArrayList<VBox>();
    private List<VBox> peliculasI = new ArrayList<VBox>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedMovie.setDisable(true);
        peliculasP.add(peliculas1);
        peliculasP.add(peliculas3);
        peliculasP.add(peliculas5);
        peliculasP.add(peliculas7);
        peliculasI.add(peliculas2);
        peliculasI.add(peliculas4);
        peliculasI.add(peliculas6);
        peliculasI.add(peliculas8);



        threadpool = Executors.newCachedThreadPool();

        task1 = () -> {
            if (state) {
                //Ejecuntando la funcion y dandole distintos delays para que se ejecuten en distintos momentos
                setTimeout(() -> peliculasP.forEach(p -> { new Pulse(p).setCycleCount(AnimationFX.INDEFINITE).play(); }), 1000);
                setTimeout(() -> peliculasI.forEach(p -> { new Pulse(p).setCycleCount(AnimationFX.INDEFINITE).play(); }), 500);
            } else {
                peliculasP.forEach(p ->  new Pulse(p).stop());
                peliculasI.forEach(p ->  new Pulse(p).stop());
                System.out.println("Se paro xd");
            }
        };

        for (int i = 0; i < peliculasP.size(); i++)
            peliculas.add(peliculasP.get(i));

        for (int i = 0; i < peliculasI.size(); i++)
            peliculas.add(peliculasI.get(i));


        threadpool.execute(task1);
        state = true;
    }



    /*Creando un metodo que sirve para ejecutar una accion en un cierto periodo de tiempo
    emulando al de javaScript*/
    public void setTimeout(Runnable runnable, int delay) {
        try {
            Thread.sleep(delay);
            runnable.run();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    public void selectingMovie(MouseEvent e) {
        state = false;

        peliculas.forEach(p -> {
            new ZoomOut(p).play();
        });
        disablePanels();
        if (e.getSource().toString().substring(8, 18).equals(peliculas1.getId()))
            showInfo(poster1);
        else if (e.getSource().toString().substring(8, 18).equals(peliculas2.getId()))
            showInfo(poster2);
        else if (e.getSource().toString().substring(8, 18).equals(peliculas3.getId()))
            showInfo(poster3);
        else if (e.getSource().toString().substring(8, 18).equals(peliculas4.getId()))
            showInfo(poster4);
        else if (e.getSource().toString().substring(8, 18).equals(peliculas5.getId()))
            showInfo(poster5);
        else if (e.getSource().toString().substring(8, 18).equals(peliculas6.getId()))
            showInfo(poster6);
        else if (e.getSource().toString().substring(8, 18).equals(peliculas7.getId()))
            showInfo(poster7);
        else
            showInfo(poster8);
    }

    public void showInfo(ImageView movieAsked) {
        new ZoomIn(selectedMovie).play();
        movieAsked.resize(627,317);
        movieImage.setImage(movieAsked.getImage());
        new Pulse(selectedMovie).setSpeed(0.2).setCycleCount(AnimationFX.INDEFINITE).play();

    }

    public void disablePanels() {
        peliculas1.setDisable(true);
        peliculas2.setDisable(true);
        peliculas3.setDisable(true);
        peliculas4.setDisable(true);
        peliculas5.setDisable(true);
        peliculas6.setDisable(true);
        peliculas7.setDisable(true);
        peliculas8.setDisable(true);
    }
}

