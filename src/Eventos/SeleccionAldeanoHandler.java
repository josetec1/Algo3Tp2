package Eventos;


import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;
import vista.MapaVistaControlador;

public class SeleccionAldeanoHandler implements EventHandler<MouseEvent> {

	Aldeano aldeano;

	public SeleccionAldeanoHandler(Aldeano unAldeano) {
		aldeano = unAldeano;
	}

	@Override
	public void handle(MouseEvent event) {

		MouseButton button = event.getButton();
		if (button == MouseButton.SECONDARY) { //Observar
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Observar aldeano");
			Cuadrante cuadrante = aldeano.getPosicion().getCasilleros().get(0); // esto lo uso para que veamos que cambio de posicion
			alert.setHeaderText( "Aldeano ");
			String estaDisponible = "no";
			if (aldeano.estasDisponible()){
				estaDisponible="si";
			}
			alert.setContentText("Vida actual: " + aldeano.getVidaActual()+ "\nCosto: " + aldeano.getCosto() + "\nPosicion: ( X: " + cuadrante.getX() +" Y :"+ cuadrante.getY() +")\n"
			+ "Esta disponible:" + estaDisponible + "\n"  );
			alert.showAndWait();
		} else {

			if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
				if (!MapaVistaControlador.tengoAldeanoSeleccionado()) {
					//si no esta seleccionado, entonces lo selecciono
					if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(this.aldeano)){
						MenuInferior.getLog().appendText("\nNo es tuyo");
					}else{
						MenuInferior.getLog().appendText("\nAldeano Seleccionado");
						MapaVistaControlador.seleccionarAldeano(aldeano);
					}
				} else {

					MenuInferior.getLog().appendText("\nHay un aldeano ya seleccionado, movimiento no valido");
					MapaVistaControlador.desSeleccionarUnidades();

				} //el movimiento se realiza cuando hay un aldeano seleccionado y se hace click en un boton vacio
				//TODO MOVIMIENTO
			}
			if("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
				//TODO ATAQUE
				MenuInferior.getLog().appendText("\nAldeano no puede Atacar");
			}
			if("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
				if (!MapaVistaControlador.tengoAldeanoSeleccionado()) {
					//si no esta seleccionado, entonces lo selecciono
					if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(this.aldeano)){
						MenuInferior.getLog().appendText("\nNo es tuyo");
					}else{
						MenuInferior.getLog().appendText("\nAldeano Seleccionado");
						MapaVistaControlador.seleccionarAldeano(aldeano);
					}
				}
			}if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
				//TODO ATAQUE
				MenuInferior.getLog().appendText("\nAldeano no puede crear Unidad");
			}
		}
	}
}

