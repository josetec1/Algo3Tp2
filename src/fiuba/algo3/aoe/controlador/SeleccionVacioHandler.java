package fiuba.algo3.aoe.controlador;


import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;

public class SeleccionVacioHandler implements EventHandler<MouseEvent>{
	
	Cuadrante cuadrante;
	public SeleccionVacioHandler(Cuadrante unCuadrante){
		cuadrante=unCuadrante;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		MouseButton button = event.getButton();
		if (button == MouseButton.SECONDARY) { //Observar
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Observar Espadachin");
			Cuadrante cuadrante = this.cuadrante;
			alert.setHeaderText( "Posicion Vacia ");
			alert.setContentText(" \nPosicion: (X: " + cuadrante.getX() +" Y :"+ cuadrante.getY() +")\n");
			alert.showAndWait();
		}else if ("Mover"==MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			if (MapaVistaControlador.tengoAlgunaUnidadSeleccionada()){
				MapaVistaControlador.desSeleccionarUnidades();
			}
			MenuInferior.getLog().appendText("\nSoy una posicion");
		}else if ("Atacar"==MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){

			MenuInferior.getLog().appendText("\nPor favor, seleccione una unidad");
		}else if("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			if(!MapaVistaControlador.tengoEdificioParaConstruccionSeleccionado()){
				MenuInferior.getLog().appendText("\nPrimero Seleccione un edificio para construir");
				MapaVistaControlador.desSeleccionarEdificio();
			}
			else if(!MapaVistaControlador.tengoAldeanoSeleccionado()){
				MenuInferior.getLog().appendText("\nPrimero Seleccione un Aldeano");
				MapaVistaControlador.desSeleccionarUnidades();
			}
			else if(!MapaVistaControlador.getAldeanoSeleccionado().estasDisponible()){
				MenuInferior.getLog().appendText("\nSeleccione otro aldeano, este esta ocupado");
				MapaVistaControlador.desSeleccionarUnidades();
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
					}else if (! ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new PlazaCentral())) {
						MenuInferior.getLog().appendText("\n no se puede construir, revise oro y poblacion");
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarPosicion();
					}else if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())) {
						MenuInferior.getLog().appendText("\n Aldeano no es tuyo");
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarPosicion();
					}else{
						MapaVistaControlador.getAldeanoSeleccionado().construirEdificio(new PlazaCentral(),MapaVistaControlador.getMapa(),ContenedorPrincipal.getJuego().getJugadorActual(), posicionReal);
						MenuInferior.getLog().appendText("\nConstruyendo,el edificio terminara de construirse en 3 turnos");
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarPosicion();
					}

				}
				else if ("Cuartel" == edificioParaConstruccion){
					PosicionReal posicionReal = new PosicionReal(cuadrante);
					if(!MapaVistaControlador.getMapa().puedoColocar(posicionReal,2)){
						MenuInferior.getLog().appendText("\nPosicion Ocupada, seleccione otra posicion vacia");
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarUnidades();
					}else if (! ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new Cuartel())) {
						MenuInferior.getLog().appendText("\n no se puede construir, revise oro y poblacion");
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarPosicion();
					}else if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())) {
						MenuInferior.getLog().appendText("\n Aldeano no es tuyo");
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarPosicion();
					}else{
						MapaVistaControlador.getAldeanoSeleccionado().construirEdificio(new Cuartel(),MapaVistaControlador.getMapa(),ContenedorPrincipal.getJuego().getJugadorActual(), posicionReal);
						MenuInferior.getLog().appendText("\nConstruyendo,el edificio terminara de construirse en 3 turnos");
						MapaVistaControlador.desSeleccionarUnidades();
						MapaVistaControlador.desSeleccionarEdificio();
						MapaVistaControlador.desSeleccionarPosicion();
					}
				}

			}
		}else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			if(!MapaVistaControlador.tengoAlgunEdificioSeleccionado()){
				MenuInferior.getLog().appendText("\nPor favor Seleccione un edificio en donde puedan ser creadas unidades, y elija la posicion para su creacion nuevamente");
			}else if (!MapaVistaControlador.getMapa().puedoColocar(new PosicionReal(cuadrante),1)){
				MenuInferior.getLog().appendText("\n Posicion Invalida, seleccine nuevamente");
				MapaVistaControlador.desSeleccionarEdificio();
				MapaVistaControlador.desSeleccionarUnidadParaCrear();
			}else if (!MapaVistaControlador.tengoUnidadSeleccionadaParaCrear()) {
				MenuInferior.getLog().appendText("\nPor favor Seleccione una unidad nueva para crear");
			}else if (MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Aldeano" && MapaVistaControlador.tengoCuartelSeleccionado() ){
				MenuInferior.getLog().appendText("\n Cuartel no puede crear aldeano, elija nuevamente la unidad y el edificio y posicion");
				MapaVistaControlador.desSeleccionarEdificio();
				MapaVistaControlador.desSeleccionarUnidadParaCrear();
			}else if (MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Aldeano" && MapaVistaControlador.tengoCastilloSeleccionado()){
				MenuInferior.getLog().appendText("\n Castillo no puede crear aldeano, elija nuevamente la unidad y el edificio y posicion");
				MapaVistaControlador.desSeleccionarEdificio();
				MapaVistaControlador.desSeleccionarUnidadParaCrear();
			}else if (MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Aldeano" && MapaVistaControlador.tengoPlazaSeleccionado()  && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getPlazaSeleccionado())){
				if (! MapaVistaControlador.getPlazaSeleccionado().puedocrearUnidad()){
					MenuInferior.getLog().appendText("\n Debe esperar que termine la reparacion/construccion ,haga su seleccion nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}
				else if(ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new Aldeano()) && MapaVistaControlador.getMapa().puedoColocar(new PosicionReal(cuadrante),1)) {
					MapaVistaControlador.getPlazaSeleccionado().crearAldeano(ContenedorPrincipal.getJuego().getJugadorActual(), MapaVistaControlador.getMapa(), new PosicionReal(cuadrante));
				}else	if(!ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new Aldeano())){
					MenuInferior.getLog().appendText("\n Jugador no puede agregar un Aldeano, revisar Oro y poblacion, y haga su seleccion nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}else{
					MenuInferior.getLog().appendText("\n Posicion del mapa ocupada o invalida, seleccione nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}
			}else if (MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Arquero" && MapaVistaControlador.tengoPlazaSeleccionado()) {
				MenuInferior.getLog().appendText("\n Plaza central no puede crear arquero, haga su seleccion de nuevo");
				MapaVistaControlador.desSeleccionarUnidadParaCrear();
				MapaVistaControlador.desSeleccionarEdificio();
			}else if(MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Arquero" && MapaVistaControlador.tengoCastilloSeleccionado()){
				MenuInferior.getLog().appendText("\n Castillo no puede crear arquero, haga su seleccion de nuevo");
				MapaVistaControlador.desSeleccionarUnidadParaCrear();
				MapaVistaControlador.desSeleccionarEdificio();
			}else if (MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Arquero" && MapaVistaControlador.tengoCuartelSeleccionado()  && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getCuartelSeleccionado())){
				if (! MapaVistaControlador.getCuartelSeleccionado().puedocrearUnidad()){
					MenuInferior.getLog().appendText("\n Debe esperar que termine la reparacion/construccion ,haga su seleccion nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}else if(ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new Arquero()) && MapaVistaControlador.getMapa().puedoColocar(new PosicionReal(cuadrante),1)) {
					MapaVistaControlador.getCuartelSeleccionado().crearArquero(ContenedorPrincipal.getJuego().getJugadorActual(), MapaVistaControlador.getMapa(), new PosicionReal(cuadrante));
				}else	if(!ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new Arquero())){
					MenuInferior.getLog().appendText("\n Jugador no puede agregar un arquero, revisar Oro y poblacion, y haga su seleccion nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}else{
					MenuInferior.getLog().appendText("\n Posicion del mapa ocupada o invalida, seleccione nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}
			}else if (MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Espadachin" && MapaVistaControlador.tengoPlazaSeleccionado()) {
				MenuInferior.getLog().appendText("\n Plaza central no puede crear espadachin, haga su seleccion de nuevo");
				MapaVistaControlador.desSeleccionarUnidadParaCrear();
				MapaVistaControlador.desSeleccionarEdificio();
			}else if(MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Espadachin" && MapaVistaControlador.tengoCastilloSeleccionado()){
				MenuInferior.getLog().appendText("\n Castillo no puede crear espadachin, haga su seleccion de nuevo");
				MapaVistaControlador.desSeleccionarUnidadParaCrear();
				MapaVistaControlador.desSeleccionarEdificio();
			}else if (MapaVistaControlador.getUnidadSeleccionadaParaCrear() == "Espadachin" && MapaVistaControlador.tengoCuartelSeleccionado()  &&
					ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getCuartelSeleccionado()) ){
				if (! MapaVistaControlador.getCuartelSeleccionado().puedocrearUnidad()){
					MenuInferior.getLog().appendText("\n Debe esperar que termine la reparacion/construccion ,haga su seleccion nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}else if(ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new Espadachin()) && MapaVistaControlador.getMapa().puedoColocar(new PosicionReal(cuadrante),1)) {
					MapaVistaControlador.getCuartelSeleccionado().crearEspadachin(ContenedorPrincipal.getJuego().getJugadorActual(), MapaVistaControlador.getMapa(), new PosicionReal(cuadrante));
				}else	if(!ContenedorPrincipal.getJuego().getJugadorActual().puedoAgregar(new Espadachin())){
					MenuInferior.getLog().appendText("\n Jugador no puede agregar un espadachin, revisar Oro y poblacion, y haga su seleccion nuevamente");
					MapaVistaControlador.desSeleccionarUnidadParaCrear();
					MapaVistaControlador.desSeleccionarEdificio();
				}
			}
		}else if("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			MenuInferior.getLog().appendText("\n En esta posicion no hay una unidad, selecciona al atacante y al blanco nuevamente");
			MapaVistaControlador.desSeleccionarEdificio();
			MapaVistaControlador.desSeleccionarUnidades();
		} else if("Reparar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
			MenuInferior.getLog().appendText("\n En esta posicion no hayEdificio para reparar ni unidad que pueda reparar, selecciona nuevamente");
			MapaVistaControlador.desSeleccionarEdificio();
			MapaVistaControlador.desSeleccionarUnidades();
		}
	}
}

