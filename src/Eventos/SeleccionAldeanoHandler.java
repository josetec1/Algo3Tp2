package Eventos;


import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadFueraDeRangoDeAtaqueException;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.MenuInferior;
import vista.TableroVistaControlador;

public class SeleccionAldeanoHandler implements EventHandler<MouseEvent> {

	Aldeano aldeano;

	public SeleccionAldeanoHandler(Aldeano unAldeano) {
		aldeano = unAldeano;
	}

	@Override
	public void handle(MouseEvent event) {
		
		MouseButton button = event.getButton();
		if(button==MouseButton.SECONDARY){ //Observar
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Observar aldeano");
			alert.setHeaderText(aldeano.getPosicion() + " (Forma " + aldeano.getTamanio() + ")");
			alert.setContentText("Vida actual: " + aldeano.getVidaActual() + "\nPoder: " + aldeano.getVidaActual()
					+ " (Poder Base: " + aldeano.getCosto() + ")\nVelocidad: " + aldeano.getCosto()
					+ " (Velocidad Base: " + aldeano.getVidaMaxima() + ")\nRango de ataque: "
					+ aldeano.getCosto());
			alert.showAndWait();
		}
		else {
			
		if ("Mover" == MenuInferior.selecOpciones.getSelectionModel().getSelectedItem().toString()) {
			if (TableroVistaControlador.seleccionado == false) {
				//XXSentinelaif (aldeano.getJugador().getEstado() == "activo") {
				//XXSentinela	aldeano.getJugador().seleccionarPersonaje(aldeano.getNombre());
				//XXSentinela	MenuInferior.log.appendText("\naldeano seleccionado! Elija la posicion objetivo");
				//XXSentinela	TableroVistaControlador.seleccionado = true;
				//XXSentinela	TableroVistaControlador.aldeanoSeleccionado = aldeano;
				//XXSentinela} else {
				//XXSentinela		MenuInferior.log.appendText("\nEste aldeano no es tuyo");
				//XXSentinela	}

			} else {

				MenuInferior.log.appendText("\nHay otro aldeano en esta ubicacion, movimiento no valido");
				TableroVistaControlador.seleccionado = false;

			} //el movimiento se realiza cuando hay un aldeano seleccionado y se hace click en un boton vacio
			//TODO MOVIMIENTO
		}
		if ("Atacar" == MenuInferior.selecOpciones.getSelectionModel().getSelectedItem().toString()) {
			//TODO ATAQUE
			if (TableroVistaControlador.seleccionado == false) {
				//XXSentinela if (aldeano.getJugador().getEstado() == "activo") {

				//XXSentinela		MenuInferior.log.appendText("\naldeano seleccionado! Elija blanco de ataque");
				//XXSentinela		TableroVistaControlador.seleccionado = true;
				//XXSentinela	aldeano.getJugador().seleccionarPersonaje(aldeano.getNombre());
				//XXSentinela	TableroVistaControlador.aldeanoSeleccionado = aldeano;

				} else {

					MenuInferior.log.appendText("\nEste aldeano no es tuyo");
				}

			} else { //Seleccionado=true
				//ATACAR
				try {
					//XXSentinela	TableroVistaControlador.aldeanoSeleccionado.getJugador().atacar(aldeano.getPosicion(), ContenedorPrincipal.juego.getTablero());
//XXSentinela
					//XXSentinela	MenuInferior.log.appendText("\n" + TableroVistaControlador.aldeanoSeleccionado.getNombre() + " ataca a " + aldeano.getNombre());
					//XXSentinela	ContenedorPrincipal.juego.pasarTurno();
					//XXSentinela		TableroVistaControlador.seleccionado = false;
					//XXSentinela	} catch (FuegoAmigoException e) {
					MenuInferior.log.appendText("\nEntro en ataque!");

				}catch (UnidadFueraDeRangoDeAtaqueException e) {

					//XXSentinela		MenuInferior.log.appendText("\nAtaque fuera de rango");
					//XXSentinela	}

					//XXSentinela	TableroVistaControlador.seleccionado = false;
					//atrapar excepciones DONE
				}
			}
		}





	}
}

