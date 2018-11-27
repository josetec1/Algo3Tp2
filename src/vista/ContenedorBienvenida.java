package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.eventos.*;

public class ContenedorBienvenida extends VBox {

    Stage stage;
    private Button botonSilenciar;
    private Button botonReproducir;
    private BarraDeMenu barraDeMenu;


    public ContenedorBienvenida(Stage stage, BarraDeMenu barraMenu, AudioClip musica, Scene proximaEscena)
    {
        super();
        this.stage = stage;
        this.barraDeMenu = barraMenu;
        this.setAlignment(Pos.BOTTOM_LEFT);
        this.setSpacing(50);

        Image imagen = new Image("vista/imagenes/AOE.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 80));
        etiqueta.setPadding(new Insets(40, 0, 0, 0));

        etiqueta.setText("AGE OF EMPIRES ALGO3");
        etiqueta.setTextFill(Color.web("#0000ff"));

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar!");
        botonEntrar.setMinSize(200, 120);
        botonEntrar.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
        botonEntrar.setStyle("-fx-base: #1234");
        botonEntrar.defaultButtonProperty().bind(botonEntrar.focusedProperty());

        Button botonReglas = new Button();
        botonReglas.setText("Reglas de juego");
        botonReglas.setFont(Font.font("", 20));
        botonReglas.setStyle("-fx-base: #1234");
        botonReglas.defaultButtonProperty().bind(botonReglas.focusedProperty());
        botonReglas.setMinSize(180, 40);

        Button botonSalir = new Button();
        botonSalir.setText("Salir :(");
        botonSalir.setFont(Font.font("", 20));
        botonSalir.setStyle("-fx-base: #1234");
        botonSalir.defaultButtonProperty().bind(botonSalir.focusedProperty());
        botonSalir.setMinSize(180, 40);

        Button botonSilenciar = new Button();
        botonSilenciar.setText("Silenciar musica");
        botonSilenciar.setFont(Font.font("", 16));
        botonSilenciar.setStyle("-fx-base: #1234");
        botonSilenciar.defaultButtonProperty().bind(botonSilenciar.focusedProperty());
        botonSilenciar.setMinSize(180, 40);
        this.botonSilenciar =botonSilenciar;

        Button botonReproducir = new Button();
        botonReproducir.setText("Reproducir musica");
        botonReproducir.setFont(Font.font("", 16));
        botonReproducir.setStyle("-fx-base: #1234");
        botonReproducir.defaultButtonProperty().bind(botonReproducir.focusedProperty());
        botonReproducir.setMinSize(180, 40);
        botonReproducir.setDisable(true);
        this.botonReproducir = botonReproducir;

        BotonEntrarEventHandler botonEntrarHandler =
                new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        BotonReglasEventHandler botonReglasHandler =
                new BotonReglasEventHandler(stage);
        botonReglas.setOnAction(botonReglasHandler);

        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        BotonSilenciarHandler botonSilenciarHandler = new BotonSilenciarHandler(musica,this);
        botonSilenciar.setOnAction(botonSilenciarHandler);

        BotonReproducirHandler botonReproducirHandler = new BotonReproducirHandler(musica,this);
        botonReproducir.setOnAction(botonReproducirHandler);

        this.getChildren().addAll(etiqueta,botonEntrar, botonSilenciar,botonReproducir, botonReglas, botonSalir);
        this.setPadding(new Insets(30));
        this.setSpacing(20);
    }

    public void musicaEstaReproduciendo(boolean estaReproduciendo) {
        this.botonSilenciar.setDisable(!estaReproduciendo);
        this.botonReproducir.setDisable(estaReproduciendo);
        barraDeMenu.reproduciendoMusica(estaReproduciendo);
    }

    /*Stage stage;

    public ContenedorBienvenida(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);
        this.setPadding(new Insets(100));
        Image imagen = new Image("file:src/vista/imagenes/stars.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 32));

        etiqueta.setText("      Bienvenidos al juego \n         AGE OF EMPIRES\n de Algoritmos y Programación III.\n" +
                "\n\n        Haga click en entrar");
        etiqueta.setTextFill(Color.web("#C0C0C0"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEntrar);
    }*/

}
