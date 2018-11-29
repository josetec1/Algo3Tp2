package vista;


import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    public static MenuInferior menuInferior;
    TableroVistaControlador vistaTablero;
    public static Juego juego;  //OJO
    Canvas canvasCentral;
    
	public ContenedorPrincipal(Stage unStage, Juego unJuego){
		this.setMenu(unStage);
		this.juego = unJuego;

        this.setTablero(unJuego); //dibuja el mapa
        this.setJugadores (unJuego.getJugadorUno(),unJuego.getJugadorDos()); // dibujar nombres en pantalla, obtener y presentar Piezas, suscribir observadores que tiene que ser la vista



         /*
           Falta
         juego.agregarobservadores (this)     // este me va a avisar cuando el juego termina


         */
        //XXSentinela juego.suscribir(vistaTablero);
	}



    //TODO
    private void setJugadores(Jugador jugadorUno, Jugador jugadorDos) {
    	
    	VBox vbox1=new VBox(); VBox vbox2=new VBox();
    	
    	JugadorVista vistaJugador1 = new JugadorVista(vbox1,jugadorUno);
    	JugadorVista vistaJugador2 = new JugadorVista(vbox2,jugadorDos);
    	
    	vistaJugador1.dibujarJugador();
    	vistaJugador2.dibujarJugador();
    	vistaJugador1.dibujarInfoTerreno();
    	vistaJugador2.dibujarInfoBonus();
    	this.setLeft(vbox1);
    	this.setRight(vbox2);
    	vbox1.setTranslateX(20);
    	vbox2.setTranslateX(-20);

        //XXSentinelavalue.suscribir(vistaTablero);  aca suscribis una vista al aldeano
       /*
    	for(Aldeano value: jugadorUno.getAldeanos()){
    		vistaTablero.ubicarAldeano(value,value.getPosicion().getX(),value.getPosicion().getY());
            //XXSentinelavalue.suscribir(vistaTablero);  aca suscribis una vista al aldeano
    	}
    	for(Aldeano value: jugadorDos.getAldeanos()){
    		vistaTablero.ubicarAldeano(value,value.getPosicion().getX(),value.getPosicion().getY());
            //XXSentinela  value.suscribir(vistaTablero);
    	}
    	*/
        for(Aldeano value: jugadorUno.getAldeanos()){
            ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaTablero.ubicarAldeano(value, casilla.getX(), casilla.getY());
            }

        }
        for(Aldeano value: jugadorDos.getAldeanos()){
           ArrayList<Cuadrante> cuadrantes= value.getPosicion().getCasilleros();
            for (Cuadrante casilla : cuadrantes ) {
                vistaTablero.ubicarAldeano(value, casilla.getX(), casilla.getY());
            }

        }

        /******************************************************************************************
         *            XXSentinela*/////////

        /*
        // poner los nombres de los jugadores en pantalla DONE
        // obtener los aldeanos de cada uno y ponerlos en pantalla DONE
        // jugador.getaldeanos..........
        // subscribir los observadores
        //  aldeanos.subscribirobservador
        */
    }



    private void setTablero(Juego unJuego) {
		// TODO Auto-generated method stub
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);
        vistaTablero = new TableroVistaControlador(unJuego,grid);
        vistaTablero.dibujarTablero();
        this.setCenter(grid);

	}

	private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
        
        this.menuInferior = new MenuInferior(stage);
    	this.setBottom(menuInferior);
    	
    }
}
