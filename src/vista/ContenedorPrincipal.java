package vista;


import fiuba.algo3.aoe.Juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Celda;
import modelo.Posicion;
import modelo.Tablero;
import modelo.Terreno;
import vista.eventos.BotonMoverAbajoHandler;
import vista.eventos.BotonMoverArribaHandler;
import vista.eventos.BotonMoverDerechaHandler;
import vista.eventos.BotonMoverIzquierdaHandler;

import java.util.ArrayList;
import java.util.List;

public class ContenedorPrincipal extends BorderPane
{
    BarraDeMenu barraMenu;
    Juego juego;
    Stage stage;
    VistaTablero vistaTablero;
    ScrollPane scrollPane;
    Scene siguienteEscena;
    public Consola consola;
    public HBox botonera;
    public VBox imagenEquipoActual;
    private int posicionPorDefectoAlto=0;
    private int posicionPorDefectoAncho=0;
	public VBox imagenAlgoformersJugadorActual;

    public ContenedorPrincipal(Stage stage, Scene siguienteEscena, Juego juego, BarraDeMenu barraMenu)
    {
        this.juego = juego;
        this.stage = stage;
        this.barraMenu = barraMenu;
        this.siguienteEscena = siguienteEscena;
        this.consola = new Consola();
        this.botonera = new HBox();
        this.imagenEquipoActual= new VBox();
        this.vistaTablero = new VistaTablero();
        this.imagenAlgoformersJugadorActual= new VBox();
        Tablero tablero=Tablero.getInstance();
        posicionPorDefectoAlto=tablero.altura()/2;
    }

    public void inicializar()
    {
        inicializarContenedorDerecha();
        inicializarContenedorIzquierdo();
        inicializarContenedorAbajo();
        setMenu();
        setCentro();
        setBotoneraAcciones(new Celda(new Terreno(640,480),new Posicion(0,0), "nothing"));

    }

    private void inicializarContenedorDerecha()
    {
        VBox contenedorDerecha = new VBox();
        contenedorDerecha.setSpacing(15);
        contenedorDerecha.setBackground(
                new Background(
                        new BackgroundImage(
                            new Image("vista/imagenes/fondo-negro.jpg"),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        contenedorDerecha.getChildren().add(imagenAlgoformersJugadorActual);
        setRight(contenedorDerecha);
    }

    private void inicializarContenedorIzquierdo()
    {
        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(10));
        contenedor.setMinHeight(100);
        contenedor.getChildren().add(imagenEquipoActual);
       	contenedor.setBackground(
                new Background(
                        new BackgroundImage(
                            new Image("vista/imagenes/stars.jpg",this.getPrefWidth(),this.getPrefHeight(),true,true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
       	VistaConsola vistaConsola = new VistaConsola(consola);
       	vistaConsola.setAlignment(Pos.TOP_LEFT);
       	vistaConsola.setMinSize(100, 200);
       	contenedor.getChildren().add(vistaConsola);
        setLeft(contenedor);
    }
    

    private void inicializarContenedorAbajo(){
    	HBox contenedor = new HBox();
    	contenedor.setPadding(new Insets(20,0,20,0));
        contenedor.setBackground(
                new Background(
                        new BackgroundImage(
                            new Image("vista/imagenes/fondo-negro.jpg"),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        contenedor.setPrefHeight(100);
        contenedor.getChildren().add(botonera);
        contenedor.setAlignment(Pos.CENTER);
        setBottom(contenedor);
    }

    private void setMenu()
    {
        this.setTop(barraMenu);
    }


    VistaCasillero vistaCasillero;


    public void setBotoneraAcciones(Celda celda)
    {
        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Arriba");

        BotonMoverArribaHandler moveButtonHandler = new BotonMoverArribaHandler(vistaCasillero, celda);
        botonMoverArriba.setOnAction(moveButtonHandler);

        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Abajo");

        BotonMoverAbajoHandler moveButtonHandler2 = new BotonMoverAbajoHandler(vistaCasillero, celda);
        botonMoverAbajo.setOnAction(moveButtonHandler2);

        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setText("Derecha");

        BotonMoverDerechaHandler moveButtonHandler3 = new BotonMoverDerechaHandler(vistaCasillero, celda);
        botonMoverDerecha.setOnAction(moveButtonHandler3);

        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setText("Izquierda");

        BotonMoverIzquierdaHandler moveButtonHandler4 = new BotonMoverIzquierdaHandler(vistaCasillero, celda);
        botonMoverIzquierda.setOnAction(moveButtonHandler4);

        VBox contenedorVertical = new VBox(botonMoverArriba, botonMoverIzquierda, botonMoverDerecha, botonMoverAbajo);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(30));

        this.setLeft(contenedorVertical);


    }



    private void setCentro()
    {
        vistaTablero.dibujar();

        // ScrollPane permite ver el tablero aunque no entre en la pantalla.
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vistaTablero);
        this.scrollPane = scrollPane;

        this.setCenter(scrollPane);
    }

    public BarraDeMenu getBarraDeMenu()
    {
        return barraMenu;
    }

    public Stage getStage(){
        return stage;
    }

    public Scene getSiguienteEscena(){
        return siguienteEscena;
    }


}

