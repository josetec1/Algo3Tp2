package Eventos;


import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionInvalidaException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;
import vista.MapaVistaControlador;

public class SeleccionVacioHandler implements EventHandler<MouseEvent>{
	
	Cuadrante cuadrante;
	public SeleccionVacioHandler(Cuadrante unCuadrante){
		cuadrante=unCuadrante;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		if ("Observar"== MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			MenuInferior.getLog().appendText("\nCasillero: "+cuadrante.getX() +"," + cuadrante.getY());
		}
		if ("Mover"==MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			if (MapaVistaControlador.seleccionado==false){
				MenuInferior.getLog().appendText("\nSoy una posicion");
				}
				else{
					//Mover y terminar turno
					try{
						//XXSentinela	TableroVistaControlador.AldeanoSeleccionado.mover(coordenada, ContenedorPrincipal.juego.getMapa());
						//XXSentinela	MenuInferior.log.appendText("\naldeano: mover a posicion " + coordenada.getX() + " , " + coordenada.getY());
						ContenedorPrincipal.getJuego().pasarJugada();
					}
					catch (PosicionInvalidaException e){
						MenuInferior.getLog().appendText("\nMovimiento fuera de rango");
					}

					
					MapaVistaControlador.seleccionado=false;
					
					
				}
		}
		if ("Atacar"==MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			if (MapaVistaControlador.seleccionado==false){
				
				MenuInferior.getLog().appendText("\nPor favor, seleccione un aldeano");
			}
			else{
				//TableroVistaControlador.aldeanoSeleccionado.getJugador().atacar(coordenada, ContenedorPrincipal.juego.getTablero());
				//XXSentinela MenuInferior.log.appendText("\n" + TableroVistaControlador.aldeanoSeleccionado.getNombre()+" :ataque fallido!");
				ContenedorPrincipal.getJuego().pasarJugada();
				MapaVistaControlador.seleccionado=false;
				//Atacar a lugar vacio
			}
		}
	}
}

