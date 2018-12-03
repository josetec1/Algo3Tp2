package Eventos;


import fiuba.algo3.aoe.Jugadores.RecursoInsuficienteException;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;
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
			if (MapaVistaControlador.tengoAlgunaUnidadSeleccionada()){
				MapaVistaControlador.desSeleccionarUnidades();
			}
			MenuInferior.getLog().appendText("\nSoy una posicion");
		}
		if ("Atacar"==MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){

			MenuInferior.getLog().appendText("\nPor favor, seleccione una unidad");
		}
		if("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			if(!MapaVistaControlador.tengoEdificioParaConstruccionSeleccionado()){
				MenuInferior.getLog().appendText("\nPrimero Seleccione un edificio para construir");
			}
			else if(!MapaVistaControlador.tengoAldeanoSeleccionado()){
				MenuInferior.getLog().appendText("\nPrimero Seleccione un Aldeano");
			}
			else if(!MapaVistaControlador.getAldeanoSeleccionado().estasDisponible()){
				MenuInferior.getLog().appendText("\nSeleccione otro aldeano, este esta ocupado");
			}
			else{
				String edificioParaConstruccion = MapaVistaControlador.getEdificioSeleccionadoParaConstruccion();
				if("Plaza Central" == edificioParaConstruccion){
					PosicionReal posicionReal = new PosicionReal(cuadrante);
					if(!MapaVistaControlador.getMapa().puedoColocar(posicionReal,2)){
						MenuInferior.getLog().appendText("\nPosicion Ocupada, seleccione otra posicion vacia");
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarUnidades();
					}else{
						try {
							MapaVistaControlador.getAldeanoSeleccionado().construirEdificio(new PlazaCentral(),MapaVistaControlador.getMapa(),ContenedorPrincipal.getJuego().getJugadorActual(), posicionReal);
							MenuInferior.getLog().appendText("\nConstruyendo,el edificio terminara de construirse en 3 turnos");
							MapaVistaControlador.desSeleccionarUnidades();
							MapaVistaControlador.desSeleccionarEdificio();
							MapaVistaControlador.desSeleccionarPosicion();
						}catch (RecursoInsuficienteException e){
							MenuInferior.getLog().appendText("\nNo hay oro suficiente");
						}catch (Error e){
							MenuInferior.getLog().appendText("\nNo se puede construir en este Momento");
						}
					}

				}
				else if ("Cuartel" == edificioParaConstruccion){
					PosicionReal posicionReal = new PosicionReal(cuadrante);
					if(!MapaVistaControlador.getMapa().puedoColocar(posicionReal,2)){
						MenuInferior.getLog().appendText("\nPosicion Ocupada, seleccione otra posicion vacia");
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarPosicion();
					}else{
						try {
							MapaVistaControlador.getAldeanoSeleccionado().construirEdificio(new Cuartel(),MapaVistaControlador.getMapa(),ContenedorPrincipal.getJuego().getJugadorActual(), posicionReal);
							MenuInferior.getLog().appendText("\nConstruyendo,el edificio terminara de construirse en 3 turnos");
							MapaVistaControlador.desSeleccionarUnidades();
							MapaVistaControlador.desSeleccionarEdificio();
							MapaVistaControlador.desSeleccionarPosicion();
						}catch (RecursoInsuficienteException e){
							MenuInferior.getLog().appendText("\nNo hay oro suficiente");
						}catch (Error e){
							MenuInferior.getLog().appendText("\nNo se puede construir en este Momento");
						}
					}
				}

			}
		}
	}
}

