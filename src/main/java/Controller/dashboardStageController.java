package Controller;

import Model.FacturaListModel;
import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Label nombrePelicula1;
    @FXML
    private Label nombrePelicula2;
    @FXML
    private Label nombrePelicula3;
    @FXML
    private Label nombrePelicula4;
    @FXML
    private Label nombrePelicula5;
    @FXML
    private Label nombrePelicula6;

    @FXML
    private Label calificacion1;
    @FXML
    private Label calificacion2;
    @FXML
    private Label calificacion3;
    @FXML
    private Label calificacion4;
    @FXML
    private Label calificacion5;
    @FXML
    private Label calificacion6;

    @FXML
    private Label genero;


    private List<VBox> peliculasFiltro = new ArrayList<VBox>();
    private List<ImageView> posters = new ArrayList<>();
    private List<Label> titulos = new ArrayList<>();
    private List<Label> calificaciones = new ArrayList<>();
    private FacturaListModel peliculas = new FacturaListModel();
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
        peliculasI.add(peliculas2);
        peliculasI.add(peliculas4);
        peliculasI.add(peliculas6);
        peliculasFiltro.addAll(peliculasP);
        peliculasFiltro.addAll(peliculasI);

        posters.add(poster1);
        posters.add(poster2);
        posters.add(poster3);
        posters.add(poster4);
        posters.add(poster5);
        posters.add(poster6);

        titulos.add(nombrePelicula1);
        titulos.add(nombrePelicula2);
        titulos.add(nombrePelicula3);
        titulos.add(nombrePelicula4);
        titulos.add(nombrePelicula5);
        titulos.add(nombrePelicula6);

        calificaciones.add(calificacion1);
        calificaciones.add(calificacion2);
        calificaciones.add(calificacion3);
        calificaciones.add(calificacion4);
        calificaciones.add(calificacion5);
        calificaciones.add(calificacion6);

        peliculas.LoadFromJsonPeliculas();
        loadPostersFromJson();


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

        peliculasFiltro.forEach(p -> {
            new ZoomOut(p).play();
        });
        disablePanels();
        if (e.getSource().toString().substring(8, 18).equals(peliculas1.getId()))
//            showInfo(poster1, peliculas.getListPelicula().get(0).getGenero().toString());
            peliculas.getListPelicula().forEach(p -> System.out.println(p.getGenero()));
        else if (e.getSource().toString().substring(8, 18).equals(peliculas2.getId()))
            showInfo(poster2, peliculas.getListPelicula().get(1).getGenero().toString());
        else if (e.getSource().toString().substring(8, 18).equals(peliculas3.getId()))
            showInfo(poster3, peliculas.getListPelicula().get(2).getGenero().toString());
        else if (e.getSource().toString().substring(8, 18).equals(peliculas4.getId()))
            showInfo(poster4, peliculas.getListPelicula().get(3).getGenero().toString());
        else if (e.getSource().toString().substring(8, 18).equals(peliculas5.getId()))
            showInfo(poster5, peliculas.getListPelicula().get(4).getGenero().toString());
        else
            showInfo(poster6, peliculas.getListPelicula().get(5).getGenero().toString());
    }

    public void showInfo(ImageView movieAsked, String generoAux) {
        new ZoomIn(selectedMovie).play();
        movieAsked.resize(627,317);
        movieImage.setImage(movieAsked.getImage());
        new Pulse(selectedMovie).setSpeed(0.2).setCycleCount(AnimationFX.INDEFINITE).play();
        genero.setText(generoAux);
    }

    public void disablePanels() {
        peliculas1.setDisable(true);
        peliculas2.setDisable(true);
        peliculas3.setDisable(true);
        peliculas4.setDisable(true);
        peliculas5.setDisable(true);
        peliculas6.setDisable(true);
    }

    public void loadPostersFromJson() {
        for (int i = 0; i < peliculas.getListPelicula().size(); i++) {
            String urlImage = peliculas.getListPelicula().get(i).getFotoUrl();
            String titulo = peliculas.getListPelicula().get(i).getTitulo();
            String calificacion = peliculas.getListPelicula().get(i).getCalificacion();

            posters.get(i).setImage(new Image(urlImage));
            titulos.get(i).setText(titulo);
            calificaciones.get(i).setText(calificacion);
        }
    }
}

