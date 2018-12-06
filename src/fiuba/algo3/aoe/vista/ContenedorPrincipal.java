package fiuba.algo3.aoe.vista;

import fiuba.algo3.aoe.controlador.*;
import fiuba.algo3.aoe.modelo.Juego.Juego;
import fiuba.algo3.aoe.modelo.Observadores.ObservadorJuego;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Observadores.ObservadorJugador;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.*;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane implements ObservadorJuego, ObservadorJugador {

    private BarraDeMenu menuBar;
    private static MenuInferior menuInferior;
    private MapaVistaControlador vistaMapa;
    private Jugador jugadorUno;
    private Jugador jugadorDos;

    private static Juego juego;  //OJO

	public ContenedorPrincipal(Stage unStage, Juego unJuego){
        final VBox vbox1=new VBox();
        this.setLeft(vbox1);
        vbox1.setTranslateX(5);
        vbox1.setTranslateY(10);

        this.setMenu(unStage,vbox1);
        this.juego = unJuego;
        this.jugadorUno= unJuego.getJugadores().get(0);
        this.jugadorDos= unJuego.getJugadores().get(1);


        //dibuja el mapa
        this.setMapa(unJuego);

        // dibujar nombres en pantalla, obtener y presentar Piezas,
        this.setJugadores ();

        //suscribir observadores que tiene que ser la
        this.jugadorUno.agregarObservadores(this);
        this.jugadorDos.agregarObservadores(this);
        juego.agregarObservador(this);

	}

	public static Juego getJuego(){
	    return juego;
    }

    private void setJugadores() {

        this.actualizarPiezas(this.jugadorUno,"VIOLET");
        this.actualizarPiezas(this.jugadorDos, "GREEN");

        VBox vbox2=new VBox();
        this.setRight(vbox2);
	    JugadorVista vistaJugador1 = new JugadorVista(vbox2,this.jugadorUno, Color.VIOLET);
    	JugadorVista vistaJugador2 = new JugadorVista(vbox2,this.jugadorDos,Color.GREEN);
    	
    	vistaJugador1.dibujarJugador(this.juego.getJugadorActual(),"VIOLET");
    	vistaJugador1.dibujarIformacionJugador("VIOLET");
        vistaJugador2.dibujarJugador(this.juego.getJugadorActual(),"GREEN");
        vistaJugador2.dibujarIformacionJugador("GREEN");
        vistaJugador2.dibujarInfoUnidades();
        vistaJugador2.dibujarInfoEdificios();



    }
    private void setMapa(Juego unJuego) {
        // TODO Auto-generated method stub
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);
        vistaMapa = new MapaVistaControlador(unJuego,grid);
        //esto lo cambie de orden
        this.vistaMapa.dibujarTablero();
        this.setCenter(grid);

    }

    private void setMenu(Stage stage,VBox vbox1) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);

        this.menuInferior = new MenuInferior(stage);
        this.setBottom(menuInferior);

        this.crearBotonesDireccion(vbox1);
        this.crearBotonPasarTurno(vbox1);
        this.crearBotonActualizar(vbox1);
        this.crearBotonesEdificiosConstruccion(vbox1);
        this.crearBotonesCreacionUnidades(vbox1);
        this.crearBotonDesseleccionar(vbox1);
        this.crearBotonPasarFinJuego(vbox1); //todo sacar
    }

    private void crearBotonDesseleccionar(VBox vBox){
        Button desseleccion = new Button ( "Deshacer seleccion" );
        DesHacerSeleccionHandler desHacerSeleccionHandler= new DesHacerSeleccionHandler();
        desseleccion.setOnMouseClicked(desHacerSeleccionHandler);
        vBox.getChildren ().add ( desseleccion );
    }

    private void crearBotonesCreacionUnidades(VBox vBox){
        Button aldeano = new Button ( "Aldeano" );
        SeleccionAldeanoParaCrearUnidadHandler aldeanoCrearHandler= new SeleccionAldeanoParaCrearUnidadHandler();
        aldeano.setOnMouseClicked(aldeanoCrearHandler);
        vBox.getChildren ().add ( aldeano );

        Button arquero = new Button ( "Arquero" );
        SeleccionArqueroParaCrearUnidadHandler arqueroCrearHandler= new SeleccionArqueroParaCrearUnidadHandler();
        arquero.setOnMouseClicked(arqueroCrearHandler);
        vBox.getChildren ().add ( arquero );

        Button espadachin = new Button ( "Espadachin" );
        SeleccionEspadachinParaCrearUnidadHandler espadachinCrearHandler= new SeleccionEspadachinParaCrearUnidadHandler();
        espadachin.setOnMouseClicked(espadachinCrearHandler);
        vBox.getChildren ().add ( espadachin );
    }

    private void crearBotonesEdificiosConstruccion(VBox vBox){
        Button plazaCentral = new Button ( "Plaza Central" );
        SeleccionarPlazaParaConstruirHandler plazaHandler= new SeleccionarPlazaParaConstruirHandler();
        plazaCentral.setOnMouseClicked(plazaHandler);
        vBox.getChildren ().add ( plazaCentral );

        Button cuartel = new Button ( "Cuartel" );
        SeleccionarCuartelParaConstruirHandler cuartelHandler= new SeleccionarCuartelParaConstruirHandler();
        cuartel.setOnMouseClicked(cuartelHandler);
        vBox.getChildren ().add ( cuartel );
    }

    private void crearBotonActualizar(VBox vbox1){
        Button actualizarButton = new Button ( "Altualizar" );
        SeleccionUpdateHandler seleccionUpdateHandler = new SeleccionUpdateHandler(this);
        actualizarButton.setOnMouseClicked(seleccionUpdateHandler);
        vbox1.getChildren ().add ( actualizarButton );
    }

    private void crearBotonPasarTurno(VBox vbox1){
        Button pasarTurnoButton = new Button ( "Pasar Turno" );
        SeleccionPasarTurnoHandler seleccionPasarTurnoHandler = new SeleccionPasarTurnoHandler(this);

        pasarTurnoButton.setOnMouseClicked(seleccionPasarTurnoHandler);
        vbox1.getChildren ().add ( pasarTurnoButton );
    }

    //borrar TODO
    private void crearBotonPasarFinJuego(VBox vbox1){
        Button FinButton = new Button ( "Simular Fin" );
        SeleccionFinJuegoHandler seleccionFinJuegoHandler = new SeleccionFinJuegoHandler (this);
        FinButton.setOnMouseClicked(seleccionFinJuegoHandler);
        vbox1.getChildren ().add ( FinButton );
    }

    private void crearBotonesDireccion(VBox vbox1){
        //Arriba


        Image imagen = new Image("file:src/fiuba/algo3/aoe/recurso/arriba.png");
        ImageView imageView = new ImageView(imagen);
        imageView.setFitHeight(10);
        imageView.setFitWidth(20);


        Button arribaButton = new Button ( "Arriba" ,imageView);

        SeleccionDireccionHandler seleccionDireccionHandlerArriba = new SeleccionDireccionHandler(new DireccionArriba(), this);
        arribaButton.setOnMouseClicked(seleccionDireccionHandlerArriba);
        arribaButton.setAlignment(Pos.BASELINE_CENTER);
        vbox1.getChildren ().add ( arribaButton );

        //Abajo
        Button abajoButton = new Button ( "Abajo" );
        SeleccionDireccionHandler seleccionDireccionHandlerAbajo = new SeleccionDireccionHandler(new DireccionAbajo(), this);
        abajoButton.setOnMouseClicked(seleccionDireccionHandlerAbajo);
        abajoButton.setAlignment(Pos.BASELINE_CENTER);
        vbox1.getChildren ().add ( abajoButton );

        //Derecha
        Button derechaButton = new Button ( "Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandler = new SeleccionDireccionHandler(new DireccionDerecha(), this);
        derechaButton.setOnMouseClicked(seleccionDireccionHandler);
        derechaButton.setAlignment(Pos.TOP_CENTER);
        vbox1.getChildren ().add ( derechaButton );

        //Izquierda
        Button izquierdaButton = new Button ( "Izquierda" );
        SeleccionDireccionHandler seleccionDireccionHandlerIzquierda = new SeleccionDireccionHandler(new DireccionIzquierda(), this);
        izquierdaButton.setOnMouseClicked(seleccionDireccionHandlerIzquierda);
        izquierdaButton.setAlignment(Pos.TOP_CENTER);
        vbox1.getChildren ().add ( izquierdaButton);

        //Arriba Derecha
        Button arribaYDerechaButton = new Button ( "Arriba Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandlerArribaDerecha = new SeleccionDireccionHandler(new DireccionArribaDerecha(), this);
        arribaYDerechaButton.setOnMouseClicked(seleccionDireccionHandlerArribaDerecha);
        vbox1.getChildren ().add ( arribaYDerechaButton );

        //Arriba Izquierda
        Button arribaIzquierdaButton = new Button ( "Arriba Izquierda" );
        SeleccionDireccionHandler seleccionDireccionHandlerArribaIzquierda = new SeleccionDireccionHandler(new DireccionArribaIzquierda(), this);
        arribaIzquierdaButton.setOnMouseClicked(seleccionDireccionHandlerArribaIzquierda);
        vbox1.getChildren ().add ( arribaIzquierdaButton );

        //Abajo Derecha
        Button abajoDerechaButton = new Button ( "Abajo Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandlerAbajoDerecha = new SeleccionDireccionHandler(new DireccionAbajoDerecha(), this);
        abajoDerechaButton.setOnMouseClicked(seleccionDireccionHandlerAbajoDerecha);
        vbox1.getChildren ().add ( abajoDerechaButton );

        //Abajo Izquierda
        Button abajoIzquierdaButton = new Button ( "Abajo Izquierda" );
        SeleccionDireccionHandler seleccionDireccionHandlerAbajoIzquierda = new SeleccionDireccionHandler(new DireccionAbajoIzquierda(), this);
        abajoIzquierdaButton.setOnMouseClicked(seleccionDireccionHandlerAbajoIzquierda);
        vbox1.getChildren ().add ( abajoIzquierdaButton );


    }
    private void actualizarPiezas (Jugador jugador, String color){

        for(Aldeano value: jugador.getAldeanos()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaMapa.ubicarAldeano(value, casilla.getX(), casilla.getY(),color);
            }
        }
        //Espadachin
        for(Espadachin value: jugador.getEspadachines()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaMapa.ubicarEspadachin(value, casilla.getX(), casilla.getY(),color);
            }
        }


        //castillo
        vistaMapa.ubicarCastillo (jugador.getCastillo(),color);

        //Plazas
        for (PlazaCentral plaza : jugador.getPlazas()){ vistaMapa.ubicarPlaza(plaza,color);}
        for (Cuartel cuartel : jugador.getCuarteles()){vistaMapa.ubicarCuartel(cuartel,color);}

        //Arqueros
        for (Arquero arquero : jugador.getArqueros()){

           int x = arquero.getPosicion().getCasilleros().get(0).getX();
           int y = arquero.getPosicion().getCasilleros().get(0).getY();
            vistaMapa.ubicarArquero(arquero,x,y,color);

        }

    }
    private void actualizarMapa(){ //regenero el tablero
        this.setMapa(this.juego);

    }


    @Override
    public void actualizar() {

        this.actualizarMapa();
        this.setJugadores();

        if (this.juego.finalizo()){
            this.vistaMapa.finalizoJuego(this.juego.getWinner());
        }
    }
}
