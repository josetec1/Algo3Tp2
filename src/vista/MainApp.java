package vista;


import Eventos.RestrictiveTextField;
import Eventos.SilenciadorEventHandler;
import Eventos.TextoEventHandler;
import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Jugadores.Jugador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class MainApp extends Application {



    static MediaPlayer mediaPlayer;
    private static Stage stage;
    static boolean musicaPausada = false;
    String nombreJugadorUno;
    String nombreJugadorDos;
    Jugador jugadorUno;
    Jugador jugadorDos;


    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage){
        stage = primaryStage;
        reproducirMusica();
        Scene scene = pantallaInicio();
        primaryStage.setTitle("Age of Champions");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();


          primaryStage.setScene(scene);

        primaryStage.show();








    }

    public static void reproducirMusica(){
        String path = new File("src/media/musicatp.mp3").getAbsolutePath();
        Media musicFile = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(musicFile);
        mediaPlayer.setAutoPlay(true);
    }

    public Scene pantallaInicio(){
        Pane root = new Pane();

        Button botonComenzar = new Button();
        Button botonEnter1 = new Button();
        Button botonEnter2 = new Button();
        Button silenciarMusica = new Button();
        silenciarMusica.setStyle("-fx-font: 10 arial; -fx-base: #000000;");
        silenciarMusica.setText("Silenciar/ Reproducir musica");


        RestrictiveTextField textoJugadorUno = new RestrictiveTextField();
        RestrictiveTextField textoJugadorDos = new RestrictiveTextField();

        textoJugadorUno.setMaxLength(10);
        textoJugadorDos.setMaxLength(10);

        Label errorIngreso = new Label("Debe ingresar un nombre");
        Label errorNombresIguales = new Label("Debe ingresar nombres distintos");

        botonComenzar.setText("Nueva Partida");
        botonComenzar.setTextFill(Color.WHITE);
        botonEnter1.setText("Ingresar Nombre");
        botonEnter1.setTextFill(Color.WHITE);
        botonEnter2.setText("Ingresar Nombre");
        botonEnter2.setTextFill(Color.WHITE);

        textoJugadorUno.setPromptText("nombre jugador 1");
        textoJugadorDos.setPromptText("nombre jugador 2");

        Image imagenFondo = new Image("file:src/media/guerra.png");
        ImageView imageView = new ImageView();
        imageView.setImage(imagenFondo);

        botonComenzar.setStyle("-fx-font: 22 arial; -fx-base: #000000;");
        botonEnter1.setStyle("-fx-base: #000000;");
        botonEnter2.setStyle("-fx-base: #000000;");

        errorIngreso.setFont(Font.font("arial",15));
        errorIngreso.setTextFill(Color.CRIMSON);
        errorNombresIguales.setFont(Font.font("arial",15));
        errorNombresIguales.setTextFill(Color.CRIMSON);

        textoJugadorUno.setMinSize(210, 10);
        textoJugadorDos.setMinSize(210, 10);

        imageView.setFitHeight(800);
        imageView.setFitWidth(1400);

        Label jugadorUnoLabel = new Label("Jugador 1: ");
        jugadorUnoLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        jugadorUnoLabel.setTextFill(Color.WHITE);
        Label jugadorDosLabel = new Label("Jugador 2: ");
        jugadorDosLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        jugadorDosLabel.setTextFill(Color.WHITE);
        this.ubicarNodo(botonComenzar, 600, 350);
        this.ubicarNodo(silenciarMusica, 630, 250);
        this.ubicarNodo(botonEnter1, 640, 200);
        this.ubicarNodo(botonEnter2, 640, 200);
        this.ubicarNodo(textoJugadorUno, 670, 150);
        this.ubicarNodo(textoJugadorDos, 670, 150);
        this.ubicarNodo(errorIngreso, 588, 178);
        this.ubicarNodo(errorNombresIguales, 570, 178);
        this.ubicarNodo(jugadorUnoLabel, 500, 153);
        this.ubicarNodo(jugadorDosLabel, 475, 153);



        root.getChildren().addAll(imageView, textoJugadorUno, botonEnter1, jugadorUnoLabel, silenciarMusica);

        silenciarMusica.setOnMouseClicked(new SilenciadorEventHandler());

        botonComenzar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent evento){
                Juego juego = new Juego(nombreJugadorUno,nombreJugadorDos,40,30);
                ContenedorPrincipal contenedor = new ContenedorPrincipal(stage,juego);
                stage.setScene(new Scene(contenedor));
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("");
            }
        });

        botonEnter1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent evento){
                if (! textoJugadorUno.getText().trim().equals("")){
                    if (root.getChildren().contains(errorIngreso)){
                        root.getChildren().remove(errorIngreso);
                    }
                    nombreJugadorUno = textoJugadorUno.getText();
                    root.getChildren().remove(textoJugadorUno);
                    root.getChildren().remove(botonEnter1);
                    root.getChildren().remove(jugadorUnoLabel);
                    root.getChildren().add(textoJugadorDos);
                    root.getChildren().add(botonEnter2);
                    root.getChildren().add(jugadorDosLabel);
                    textoJugadorDos.requestFocus();
                }
                else{
                    if (! root.getChildren().contains(errorIngreso)){
                        root.getChildren().add(errorIngreso);
                    }
                }
            }
        });

        botonEnter2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent evento){
                if (! textoEstaVacio(textoJugadorDos) && ! textosSonIguales(textoJugadorUno, textoJugadorDos)){
                    if (root.getChildren().contains(errorIngreso)){
                        root.getChildren().remove(errorIngreso);
                    }
                    if (root.getChildren().contains(errorNombresIguales)){
                        root.getChildren().remove(errorNombresIguales);
                    }
                    nombreJugadorDos = textoJugadorDos.getText();
                    root.getChildren().remove(textoJugadorDos);
                    root.getChildren().remove(botonEnter2);
                    root.getChildren().remove(jugadorDosLabel);
                    root.getChildren().add(botonComenzar);
                    botonComenzar.requestFocus();
                }
                else if (textosSonIguales(textoJugadorUno, textoJugadorDos)){
                    if (root.getChildren().contains(errorIngreso)){
                        root.getChildren().remove(errorIngreso);
                    }
                    if (! root.getChildren().contains(errorNombresIguales)){
                        root.getChildren().add(errorNombresIguales);
                    }
                }
                else{
                    if (root.getChildren().contains(errorNombresIguales)){
                        root.getChildren().remove(errorNombresIguales);
                    }
                    if (! root.getChildren().contains(errorIngreso)){
                        root.getChildren().add(errorIngreso);
                    }
                }
            }
        });

        DropShadow shadow = new DropShadow();
        botonComenzar.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        botonComenzar.setEffect(shadow);
                    }
                });
        botonComenzar.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        botonComenzar.setEffect(null);
                    }
                });

        TextoEventHandler texto1EventHandler = new TextoEventHandler(botonEnter1);
        textoJugadorUno.setOnKeyPressed(texto1EventHandler);

        TextoEventHandler texto2EventHandler = new TextoEventHandler(botonEnter2);
        textoJugadorDos.setOnKeyPressed(texto2EventHandler);

        TextoEventHandler botonEnter1EventHandler = new TextoEventHandler(botonEnter1);
        botonEnter1.setOnKeyPressed(botonEnter1EventHandler);

        TextoEventHandler botonEnter2EventHandler = new TextoEventHandler(botonEnter2);
        botonEnter2.setOnKeyPressed(botonEnter2EventHandler);

        TextoEventHandler botonComenzarEventHandler = new TextoEventHandler(botonComenzar);
        botonComenzar.setOnKeyPressed(botonComenzarEventHandler);

        return new Scene(root);

    }

    private static boolean textoEstaVacio(TextField texto){
        return texto.getText().trim().equals("");
    }

    private static boolean textosSonIguales(TextField texto1, TextField texto2){
        return texto1.getText().equalsIgnoreCase(texto2.getText());
    }

    private void ubicarNodo(Node nodo, int x, int y){
        nodo.setLayoutX(x);
        nodo.setLayoutY(y);
    }

    public static void ganoAlguien(String ganador){
        Stage popUp = new Stage();
        popUp.initModality(Modality.WINDOW_MODAL);
        //Botones y texto
        Label label = new Label();
        label.setText("El ganador es " + ganador);
        Button botonCerrar = new Button();
        botonCerrar.setText("Cerrar");
        botonCerrar.setOnAction(e -> cerrarPrograma());
        Button botonSeguir = new Button();
        botonSeguir.setText("Seguir jugando");
        botonSeguir.setOnAction(e -> popUp.close());
        //Contenedor
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,botonCerrar,botonSeguir);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(5);
        popUp.setFullScreen(false);
        popUp.initOwner(stage);
        HBox cont = new HBox(layout);
        cont.setSpacing(5);

        Scene scene = new Scene(cont);
        popUp.setScene(scene);
        popUp.showAndWait();
    }
    private static void cerrarPrograma(){
        stage.close();
    }

    public static void silenciarMusica(){
        if (musicaPausada){
            mediaPlayer.play();
            musicaPausada = false;
        }
        else{
            mediaPlayer.pause();
            musicaPausada = true;
        }
    }

}
