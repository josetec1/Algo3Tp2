package vista;


import Eventos.SeleccionDireccionHandler;
import Eventos.SeleccionPasarTurnoHandler;
import Eventos.SeleccionUpdateHandler;
import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
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

    BarraDeMenu menuBar;
    public static MenuInferior menuInferior;
    MapaVistaControlador vistaMapa;
    public static Juego juego;  //OJO

   // Canvas canvasCentral;

    
	public ContenedorPrincipal(Stage unStage, Juego unJuego){
        final VBox vbox1=new VBox(); VBox vbox2=new VBox();

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

    private void setJugadores(Jugador jugadorUno, Jugador jugadorDos,VBox vbox1,VBox vbox2) {

    	JugadorVista vistaJugador1 = new JugadorVista(vbox1,jugadorUno);
    	JugadorVista vistaJugador2 = new JugadorVista(vbox2,jugadorDos);
    	
    	vistaJugador1.dibujarJugador(this.juego.getJugadorActual());
    	vistaJugador2.dibujarJugador(this.juego.getJugadorActual());
    	vistaJugador1.dibujarInfoUnidades();
    	vistaJugador2.dibujarInfoEdificios();
    	this.setLeft(vbox1);
    	this.setRight(vbox2);
    	vbox1.setTranslateX(20);
    	vbox2.setTranslateX(-20);

    	this.actualizarPiezas(jugadorUno,jugadorDos);
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
        Button derechaButton = new Button ( "Derecha" );
        SeleccionDireccionHandler seleccionDireccionHandler = new SeleccionDireccionHandler(new DireccionDerecha());

        derechaButton.setOnMouseClicked(seleccionDireccionHandler);

        vbox1.getChildren ().add ( derechaButton );


        Button actualizarButton = new Button ( "Altualizar" );
        SeleccionUpdateHandler seleccionUpdateHandler = new SeleccionUpdateHandler(this);
        actualizarButton.setOnMouseClicked(seleccionUpdateHandler);
        vbox1.getChildren ().add ( actualizarButton );


        Button pasarTurnoButton = new Button ( "Pasar Turno" );
        SeleccionPasarTurnoHandler seleccionPasarTurnoHandler = new SeleccionPasarTurnoHandler(this);
        pasarTurnoButton.setOnMouseClicked(seleccionPasarTurnoHandler);
        vbox1.getChildren ().add ( pasarTurnoButton );



    }

    private void actualizarPiezas (Jugador jugadorUno, Jugador jugadorDos){



        for(Aldeano value: jugadorUno.getAldeanos()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaMapa.ubicarAldeano(value, casilla.getX(), casilla.getY());
            }
        }

        for(Aldeano value: jugadorDos.getAldeanos()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaMapa.ubicarAldeano(value, casilla.getX(), casilla.getY());
            }
        }

        //castillo
        vistaMapa.ubicarCastillo (jugadorUno.getCastillo());
        vistaMapa.ubicarCastillo (jugadorDos.getCastillo());

        vistaMapa.ubicarPlaza(jugadorUno.getPlaza());
        vistaMapa.ubicarPlaza (jugadorDos.getPlaza());
    }
    private void actualizarMapa(){ //regenero el tablero
        this.setMapa(this.juego);

    }


    @Override
    public void update(Observable o, Object arg) {
        this.actualizarMapa();
        this.actualizarPiezas(this.juego.getJugadorUno(),this.juego.getJugadorDos());



    }
}
