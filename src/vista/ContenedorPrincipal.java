package vista;


import Eventos.*;
import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Direccion.*;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ContenedorPrincipal extends BorderPane implements Observer {

    private BarraDeMenu menuBar;
    private static MenuInferior menuInferior;
    private MapaVistaControlador vistaMapa;
    private static Juego juego;  //OJO

   // Canvas canvasCentral;

    
	public ContenedorPrincipal(Stage unStage, Juego unJuego){
        final VBox vbox1=new VBox(); VBox vbox2=new VBox();
        this.setRight(vbox2);
        this.setLeft(vbox1);
        vbox1.setTranslateX(5);
        vbox1.setTranslateY(10);

        this.setMenu(unStage,vbox1);
        this.juego = unJuego;

        //dibuja el mapa
        this.setMapa(unJuego);

        // dibujar nombres en pantalla, obtener y presentar Piezas,
        this.setJugadores (unJuego.getJugadorUno(),unJuego.getJugadorDos(),vbox1,vbox2);

        //suscribir observadores que tiene que ser la vista
        unJuego.getJugadorUno().addObserver(this);
        unJuego.getJugadorDos().addObserver(this);
        juego.addObserver(this);
	}

	public static Juego getJuego(){
	    return juego;
    }

    private void setJugadores(Jugador jugadorUno, Jugador jugadorDos,VBox vbox1,VBox vbox2) {
    	JugadorVista vistaJugador1 = new JugadorVista(vbox2,jugadorUno);
    	JugadorVista vistaJugador2 = new JugadorVista(vbox2,jugadorDos);
    	
    	vistaJugador1.dibujarJugador(this.juego.getJugadorActual());
    	vistaJugador1.dibujarIformacionJugador();
        vistaJugador1.dibujarInfoUnidades();
        vistaJugador1.dibujarInfoEdificios();
        vistaJugador2.dibujarJugador(this.juego.getJugadorActual());
        vistaJugador2.dibujarIformacionJugador();
        vistaJugador2.dibujarInfoUnidades();
        vistaJugador2.dibujarInfoEdificios();


    	this.actualizarPiezas(jugadorUno);
        this.actualizarPiezas(jugadorDos);
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

        // ojo aca quizas tengamos que tener un metodo en esta clase o en otra. "dibuajarBotones" algo asi
        //fijate que se estan dibujando los botones del tablero en dibajarTablero de TableroVistaControlador

        this.crearBotonesDireccion(vbox1);
        this.crearBotonPasarTurno(vbox1);
        this.crearBotonActualizar(vbox1);
        this.crearBotonesEdificiosConstruccion(vbox1);
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

    private void crearBotonesDireccion(VBox vbox1){
        //Arriba
        Button arribaButton = new Button ( "Arriba" );
        SeleccionDireccionHandler seleccionDireccionHandlerArriba = new SeleccionDireccionHandler(new DireccionArriba());
        arribaButton.setOnMouseClicked(seleccionDireccionHandlerArriba);
        arribaButton.setAlignment(Pos.BASELINE_CENTER);
        vbox1.getChildren ().add ( arribaButton );

        //Abajo
        Button abajoButton = new Button ( "Abajo" );
        SeleccionDireccionHandler seleccionDireccionHandlerAbajo = new SeleccionDireccionHandler(new DireccionAbajo());
        abajoButton.setOnMouseClicked(seleccionDireccionHandlerAbajo);
        abajoButton.setAlignment(Pos.BASELINE_CENTER);
        vbox1.getChildren ().add ( abajoButton );

        //Derecha
        Button derechaButton = new Button ( "Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandler = new SeleccionDireccionHandler(new DireccionDerecha());
        derechaButton.setOnMouseClicked(seleccionDireccionHandler);
        derechaButton.setAlignment(Pos.TOP_CENTER);
        vbox1.getChildren ().add ( derechaButton );

        //Izquierda
        Button izquierdaButton = new Button ( "Izquierda" );
        SeleccionDireccionHandler seleccionDireccionHandlerIzquierda = new SeleccionDireccionHandler(new DireccionIzquierda());
        izquierdaButton.setOnMouseClicked(seleccionDireccionHandlerIzquierda);
        izquierdaButton.setAlignment(Pos.TOP_CENTER);
        vbox1.getChildren ().add ( izquierdaButton);

        //Arriba Derecha
        Button arribaYDerechaButton = new Button ( "Arriba Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandlerArribaDerecha = new SeleccionDireccionHandler(new DireccionArribaDerecha());
        arribaYDerechaButton.setOnMouseClicked(seleccionDireccionHandlerArribaDerecha);
        vbox1.getChildren ().add ( arribaYDerechaButton );

        //Arriba Izquierda
        Button arribaIzquierdaButton = new Button ( "Arriba Izquierda" );
        SeleccionDireccionHandler seleccionDireccionHandlerArribaIzquierda = new SeleccionDireccionHandler(new DireccionArribaIzquierda());
        arribaIzquierdaButton.setOnMouseClicked(seleccionDireccionHandlerArribaIzquierda);
        vbox1.getChildren ().add ( arribaIzquierdaButton );

        //Abajo Derecha
        Button abajoDerechaButton = new Button ( "Abajo Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandlerAbajoDerecha = new SeleccionDireccionHandler(new DireccionAbajoDerecha());
        abajoDerechaButton.setOnMouseClicked(seleccionDireccionHandlerAbajoDerecha);
        vbox1.getChildren ().add ( abajoDerechaButton );

        //Abajo Izquierda
        Button abajoIzquierdaButton = new Button ( "Abajo Izquierda" );
        SeleccionDireccionHandler seleccionDireccionHandlerAbajoIzquierda = new SeleccionDireccionHandler(new DireccionAbajoIzquierda());
        abajoIzquierdaButton.setOnMouseClicked(seleccionDireccionHandlerAbajoIzquierda);
        vbox1.getChildren ().add ( abajoIzquierdaButton );


    }
    private void actualizarPiezas (Jugador jugador){

        for(Aldeano value: jugador.getAldeanos()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaMapa.ubicarAldeano(value, casilla.getX(), casilla.getY());
            }
        }


        //castillo
        vistaMapa.ubicarCastillo (jugador.getCastillo());

        //Plazas
        for (PlazaCentral plaza : jugador.getPlazas()){ vistaMapa.ubicarPlaza(plaza);}
        for (Cuartel cuartel : jugador.getCuarteles()){vistaMapa.ubicarCuartel(cuartel);}

        //Arqueros
        for (Arquero arquero : jugador.getArqueros()){

           int x = arquero.getPosicion().getCasilleros().get(0).getX();
           int y = arquero.getPosicion().getCasilleros().get(0).getY();
            vistaMapa.ubicarArquero(arquero,x,y);

        }

    }
    private void actualizarMapa(){ //regenero el tablero
        this.setMapa(this.juego);

    }

    @Override
    public void update(Observable o, Object arg) {

	    //1 hay que preguntarle siempre al juego si finalizo
      //   if (this.juego.finalizo()) {mostrar al ganador}
      // recargar el mapa y deshabilitar to do que no se pueda hacer mas nada o nose, lo que sea.

      //2 si el juego no termino, actualizar la vista, osea estas cosas de aca abajo

        this.actualizarMapa();
        this.actualizarPiezas(this.juego.getJugadorUno());
        this.actualizarPiezas(this.juego.getJugadorDos());
    }
}
