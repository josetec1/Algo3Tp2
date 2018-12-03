package vista;

import Eventos.*;
import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

//TODO ojo el obsvador juego....
public class MapaVistaControlador {

    private static Mapa mapa;
	private static GridPane tableroView;
	private static Juego juego;

	private static String edificioSeleccionadoParaConstruccion;
	private static boolean aldeanoSeleccionado;
	private static boolean arqueroSeleccionada;
	private static boolean espadachinSeleccionada;
	private static boolean castilloSeleccionada;
	private static boolean plazaSeleccionada;
	private static boolean cuartelSeleccionada;
	private static boolean armAsedioSeleccionada;


	private static Aldeano aldeano;
	private static Arquero arquero;
	private static Espadachin espadachin;
	private static PlazaCentral plaza;
	private static Cuartel cuartel;
	private static Castillo castillo;
	private static ArmaDeAsedio armaDeAsedio;
	private static Posicion posicionSeleccionada;
	private static boolean posicionEstaSeleccionada = false;
	private static boolean edificioParaConstruccionEstaSeleccionado= false;


	public  MapaVistaControlador(Juego unJuego, GridPane unGrid){
		tableroView=unGrid;
		mapa =unJuego.getMapa();
		juego=unJuego;
		this.desSeleccionarUnidades();
	}

	public static Mapa getMapa(){
		return mapa;
	}

	public static String getEdificioSeleccionadoParaConstruccion() {
		if(!edificioParaConstruccionEstaSeleccionado){
			throw new NoHayEdificioSeleccionadoException();
		}
		return edificioSeleccionadoParaConstruccion;
	}

	public static Posicion getPosicionSeleccionada() {
		if(!posicionEstaSeleccionada){
			throw new NoHayPoscionSeleccionadaException();
		}
		return posicionSeleccionada;
	}

	public static void desSeleccionarPosicion() {
		posicionEstaSeleccionada = false;
	}

	public static void desSeleccionarEdificio() {
		edificioParaConstruccionEstaSeleccionado = false;
	}

	public static boolean tengoEdificioParaConstruccionSeleccionado() {
		return edificioParaConstruccionEstaSeleccionado;
	}

	public static boolean tengoPosicionSeleccionada() {
		return posicionEstaSeleccionada;
	}

	public static void seleccionarEdificioParaConstruir(String edificio) {
		edificioSeleccionadoParaConstruccion= edificio;
		edificioParaConstruccionEstaSeleccionado = true;
	}

	public static void seleccionarPosicion(Posicion posicion) {
		posicionEstaSeleccionada=true;
		posicionSeleccionada = posicion;
	}

	public void dibujarTablero() {
		tableroView.setOnMousePressed(null);
		for (int i = 0; i<(mapa.getAncho()); i++){
			tableroView.getColumnConstraints().add(new ColumnConstraints(18));
		}
		for (int j = 0; j<(mapa.getAlto()); j++){
			tableroView.getRowConstraints().add(new RowConstraints(17));
		}
		crearBotones();
		tableroView.setAlignment(Pos.CENTER);
	}

	private void crearBotones(){
		
		for (int i = 1; i<= mapa.getAncho(); i++){
			for (int j = 1; j<= mapa.getAlto(); j++){

				Button boton=new Button("");
				boton.setAlignment(Pos.CENTER);
				boton.setTranslateX(0);
				boton.setPrefWidth(20);
				boton.setPrefHeight(20);
				Cuadrante cuadrante=new Cuadrante(i, mapa.getAlto()+1-j);
				SeleccionVacioHandler seleccionVacioHandler = new SeleccionVacioHandler(cuadrante);
				boton.setOnMouseClicked(seleccionVacioHandler);
				boton.setId( i+","+(mapa.getAlto()+1-j));
				tableroView.add(boton, i-1, j-1);
				
			}
		}
	}

	public static boolean tengoAlgunaUnidadSeleccionada(){
		return (cuartelSeleccionada == true || plazaSeleccionada == true || aldeanoSeleccionado== true ||
		espadachinSeleccionada== true || armAsedioSeleccionada==true ||	arqueroSeleccionada==true ||castilloSeleccionada==true);
	}
	public static void desSeleccionarUnidades(){
		cuartelSeleccionada=false;
		plazaSeleccionada=false;
		aldeanoSeleccionado=false;
		espadachinSeleccionada=false;
		armAsedioSeleccionada=false;
		arqueroSeleccionada=false;
		castilloSeleccionada=false;
	}

	public static void seleccionarAldeano(Aldeano unidad){
		aldeano = unidad;
		aldeanoSeleccionado=true;
	}
	public static void seleccionarArquero(Arquero unidad){
		arquero = unidad;
		arqueroSeleccionada=true;
	}
	public static void seleccionarEspadachin(Espadachin unidad){
		espadachin = unidad;
		espadachinSeleccionada=true;
	}
	public static void seleccionarArmaAsedio(ArmaDeAsedio unidad){
		armaDeAsedio = unidad;
		armAsedioSeleccionada=true;
	}
	public static void seleccionarPlaza(PlazaCentral unidad){
		plaza = unidad;
		plazaSeleccionada=true;
	}
	public static void seleccionarCastillo(Castillo unidad){
		castillo = unidad;
		castilloSeleccionada=true;
	}
	public static void seleccionarCuartel(Cuartel unidad){
		cuartel = unidad;
		cuartelSeleccionada=true;
	}

	public static boolean tengoAldeanoSeleccionado(){
		return aldeanoSeleccionado;
	}
	public static boolean tengoArqueroSeleccionado(){
		return arqueroSeleccionada;
	}
	public static boolean tengoEspadachinSeleccionado(){
		return espadachinSeleccionada;
	}
	public static boolean tengoArmaAsedioSeleccionado(){
		return armAsedioSeleccionada;
	}
	public static boolean tengoCuartelSeleccionado(){
		return cuartelSeleccionada;
	}
	public static boolean tengoPlazaSeleccionado(){
		return plazaSeleccionada;
	}
	public static boolean tengoCastilloSeleccionado(){
		return castilloSeleccionada;
	}

	public static Castillo getCastilloSeleccionado(){
		if(castilloSeleccionada){
			return castillo;
		}
		throw new NoHayUnidadSeleccionadaException();
	}
	public static ArmaDeAsedio getArmaDeAsedioSeleccionado(){
		if(armAsedioSeleccionada){
			return armaDeAsedio;
		}
		throw new NoHayUnidadSeleccionadaException();
	}
	public static Espadachin getEspadachinSeleccionado(){
		if(espadachinSeleccionada){
			return espadachin;
		}
		throw new NoHayUnidadSeleccionadaException();
	}
	public static Arquero getArqueroSeleccionado(){
		if(arqueroSeleccionada){
			return arquero;
		}
		throw new NoHayUnidadSeleccionadaException();
	}
	public static PlazaCentral getPlazaSeleccionado(){
		if(plazaSeleccionada){
			return plaza;
		}
		throw new NoHayUnidadSeleccionadaException();
	}
	public static Cuartel getCuartelSeleccionado(){
		if(cuartelSeleccionada){
			return cuartel;
		}
		throw new NoHayUnidadSeleccionadaException();
	}
	public static Aldeano getAldeanoSeleccionado(){
		if(aldeanoSeleccionado){
			return aldeano;
		}
		throw new NoHayUnidadSeleccionadaException();
	}
	//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
	//TODO XXSentinela  explota esto de aca abajo
	public void ubicarAldeano(Aldeano aldeano, int x, int y){

		Button botonAldeano = (Button) tableroView.getChildren().get((mapa.getAlto()*x-(y-1)));

		botonAldeano.setText("A");
		botonAldeano.setStyle("-fx-background-color: BLUE");
		SeleccionAldeanoHandler seleccionAldeanoHandler = new SeleccionAldeanoHandler(aldeano);
		botonAldeano.setOnMouseClicked(seleccionAldeanoHandler);

	}

	public void ubicarArquero(Arquero arquero, int x, int y){
		Button botonArquero;

		//XXSentinelabotonAlgo = (Button) tableroView.getChildren().get((mapa.getAlto()*x) + y + (mapa.getAlto()* mapa.getAncho())+1);
		//XXSentinelabotonAlgo.setText(unaldeano.getNombre());
		//	botonAlgo = (Button) tableroView.getChildren().get((mapa.getAlto()*x) + y + (mapa.getAlto()* mapa.getAncho())+1);
		//	botonAlgo.setText("tester");

		//XXSentinela	SeleccionAldeanoHandler seleccionaldeanoHandler = new SeleccionAldeanoHandler(aldeano);
		//XXSentinela botonAlgo.setOnMouseClicked(seleccionaldeanoHandler);


		//int a = (mapa.getAlto()*x) + y + (mapa.getAlto()* mapa.getAncho())+1;
		botonArquero = (Button) tableroView.getChildren().get((mapa.getAlto()*x-(y-1)));
		//	botonAlgo = (Button) tableroView.getChildren().get()
		botonArquero.setText("A");
		botonArquero.setStyle("-fx-background-color: GREEN");
		SeleccionArqueroHandler seleccionArqueroHandler = new SeleccionArqueroHandler(arquero);
		botonArquero.setOnMouseClicked(seleccionArqueroHandler);
	}

	public void ubicarEspadachin (Espadachin espadachin, int x, int y){
		Button botonArquero;

		//XXSentinelabotonAlgo = (Button) tableroView.getChildren().get((mapa.getAlto()*x) + y + (mapa.getAlto()* mapa.getAncho())+1);
		//XXSentinelabotonAlgo.setText(unaldeano.getNombre());
		//	botonAlgo = (Button) tableroView.getChildren().get((mapa.getAlto()*x) + y + (mapa.getAlto()* mapa.getAncho())+1);
		//	botonAlgo.setText("tester");

		//XXSentinela	SeleccionAldeanoHandler seleccionaldeanoHandler = new SeleccionAldeanoHandler(aldeano);
		//XXSentinela botonAlgo.setOnMouseClicked(seleccionaldeanoHandler);


		//int a = (mapa.getAlto()*x) + y + (mapa.getAlto()* mapa.getAncho())+1;
		botonArquero = (Button) tableroView.getChildren().get((mapa.getAlto()*x-(y-1)));
		//	botonAlgo = (Button) tableroView.getChildren().get()
		botonArquero.setText("A");
		botonArquero.setStyle("-fx-background-color: GREEN");
		SeleccionArqueroHandler seleccionArqueroHandler = new SeleccionArqueroHandler(arquero);
		botonArquero.setOnMouseClicked(seleccionArqueroHandler);
	}

	public void ubicarCastillo (Castillo castillo){
		Button botonCastillo;
		Posicion posicion = castillo.getPosicion();
		int x;
		int y;
		for (Cuadrante cuadrante : posicion.getCasilleros()){
			x = cuadrante.getX();
			y= cuadrante.getY();
			botonCastillo = (Button) tableroView.getChildren().get((mapa.getAlto()*x-(y-1)));
			botonCastillo.setText("C");
			botonCastillo.setStyle("-fx-background-color: #1E90FF");
			SeleccionCastilloHandler seleccionCastilloHandler = new SeleccionCastilloHandler(castillo);
			botonCastillo.setOnMouseClicked(seleccionCastilloHandler);
		}
	}

	public void ubicarPlaza (PlazaCentral plaza){
		Button botonPlaza ;
		Posicion posicion = plaza.getPosicion();
		int x;
		int y;
		for (Cuadrante cuadrante : posicion.getCasilleros()){
			x = cuadrante.getX();
			y= cuadrante.getY();
			botonPlaza  = (Button) tableroView.getChildren().get((mapa.getAlto()*x-(y-1)));
			botonPlaza.setText("P");
			botonPlaza.setStyle("-fx-background-color: RED");
			SeleccionPlazaHandler seleccionPlazaHandler = new SeleccionPlazaHandler(plaza);
			botonPlaza.setOnMouseClicked(seleccionPlazaHandler);
		}
	}

	public void ubicarCuartel (Cuartel cuartel){
		Button botonPlaza ;
		Posicion posicion = cuartel.getPosicion();
		int x;
		int y;
		for (Cuadrante cuadrante : posicion.getCasilleros()){
			x = cuadrante.getX();
			y= cuadrante.getY();
			botonPlaza  = (Button) tableroView.getChildren().get((mapa.getAlto()*x-(y-1)));;
			botonPlaza.setText("C");
			botonPlaza.setStyle("-fx-background-color: YELLOW");
			SeleccionCuartelHandler seleccionCuartelHandler = new SeleccionCuartelHandler(cuartel);
			botonPlaza.setOnMouseClicked(seleccionCuartelHandler);
		}
	}

	/*
	public void quitarAldeano(int x, int y){
		Button botonAlgo=new Button();

		Cuadrante cuadrante=new Cuadrante(x,y);
		botonAlgo = (Button) tableroView.getChildren().get((mapa.getAlto()*x) + y + (mapa.getAlto()* mapa.getAncho())+1);
		botonAlgo.setText("");
		
		SeleccionVacioHandler seleccionVacioHandler = new SeleccionVacioHandler(cuadrante);
		botonAlgo.setOnMouseClicked(seleccionVacioHandler);
	}
*/

	//XXSentinela
	/*
	public void dibujarTerrenos(){
	for (int i = 0; i< mapa.getAncho(); i++){
		for (int j = 0; j< mapa.getAlto(); j++){
			Coordenada coordenada = new Coordenada (i,j);
			Pane r = new Pane();
			switch (mapa.getTerreno(coordenada).getClass().toString()){
				case "class fiuba.algo3.Eventos.terreno.Rocoso":
					r.setStyle("-fx-background-color: #f2e6d9;");break;
				case "class fiuba.algo3.Eventos.terreno.Pantano":
					r.setStyle("-fx-background-color: #714e28");break;
				case "class fiuba.algo3.Eventos.terreno.Espinas":
					r.setStyle("-fx-background-color: #008000");break;
				case "class fiuba.algo3.Eventos.terreno.Nube":
					r.setStyle("-fx-background-color: #b3ffff");break;
				case "class fiuba.algo3.Eventos.terreno.NebulosaDeAndromeda":
					r.setStyle("-fx-background-color: #990099");break;
				case "class fiuba.algo3.Eventos.terreno.TormentaPsionica":
					r.setStyle("-fx-background-color: #0047b3");break;
				default:
					r.setStyle("-fx-background-color: #ffffff;");break;
					
			}
			
			r.prefHeight(70);
			r.prefWidth(70);
			tableroView.add(r, i, j);
		}
	}
	}
	*///XXSentinela
/*
	//XXSentinela@Override
	public void notificartableroCreado(int ancho, int alto) {
		// TODO Auto-generated method stub
		
	}

	public void fallecioAldeano(Aldeano unAldeanoFallecido) {
			//retirar el aldeano del mapa
		//XXSentinelaMenuInferior.log.appendText("\n" + unAldeanoFallecido.getNombre() + " ha muerto!");
		//XXSentinelathis.quitarAldeano(unAldeanoFallecido.getPosicion().getX(), unAldeanoFallecido.getPosicion().getY());
	}

	//XXSentinela@Override
	public void huboUnMovimiento(Aldeano unAldeano, Posicion original) {


		//actualizar el movimiento

		//TODO PARCHE Arreglar!!!
		// esto pincha por que cuando el Eventos coloca al fusionado, este metodo intenta sacarlo de su posicion que la vista no lo tiene
		// por que nuenva fue agregado
		//XXSentinela this.quitarAldeano(original.getX(), original.getY());

		//XXSentinelathis.ubicarAldeano(unAldeano, unAldeano.getPosicion().getX(), unaldeano.getPosicion().getY());
		


	}
	//XXSentinela
	/*
	@Override
	public void huboUnAtaque(Aldeano Aldeano) {
          //actualizzar vista
		this.juego.pasarTurno();
		MenuInferior.log.appendText("\n ataque"  );
	}

	@Override
	public void huboUnaTransformacion(aldeano unaldeano) {
		//actualizzar vista
		MenuInferior.log.appendText("\n transformacion"  );
		this.juego.pasarTurno();
	}

	@Override
	public void huboUnaFusion(Algofusion unaldeano) {


		//retiro las 3 partes
		for (aldeano unaParte : unaldeano.getPartes()){this.quitarAldeano(unaParte.getPosicion().getX(), unaParte.getPosicion().getY());}
		//ubico al fusionado
		this.ubicarAldeano(unaldeano, unaldeano.getPosicion().getX(), unaldeano.getPosicion().getY());

		//actualizzar vista
		MenuInferior.log.appendText("\n Se completo la Fusion"  );
		//this.juego.pasarTurno();

*/





	//}



	//XXSentinela@Override
	public void finalizoJuego(Jugador playerWin) {
		//actualizar vista, mostrar al ganador
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Fin de Partida");
		alert.setHeaderText(null);
		alert.setContentText("Victoria de " + playerWin.getNombre() + "!");
		ButtonType ok = alert.getButtonTypes().get(0);
		if (alert.showAndWait().get()==ok){
			System.exit(0);
		}
	}




	//XXSentinela
	/*
	@Override
	public void esElTurnoDelJugador(Jugador unJugador) {
		//MenuInferior.log.insertText(0, "\nEs turno de: " + unJugador.obtenerNombre());
		MenuInferior.log.appendText("\nEs turno de: " + unJugador.obtenerNombre());
		//TODO te va a pasar el jugador activo que es el que tiene el turno para jugar
	}


	@Override
	public void seConsumioUnBonus(Coordenada coordenada) {
		// TODO Auto-generated method stub
		this.quitarBonus(coordenada.getX(), coordenada.getY());
		MenuInferior.log.appendText("\nSe consumio un bonus"  );
		
	}
	*///XXSentinela



}
