package Eventos;


import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;
import vista.MapaVistaControlador;

public class SeleccionArqueroHandler implements EventHandler<MouseEvent> {

    Arquero arquero;

    public SeleccionArqueroHandler(Arquero unArquero) {
        arquero = unArquero;
    }

    @Override
    public void handle(MouseEvent event) {

        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar arquero");
            Cuadrante cuadrante = arquero.getPosicion().getCasilleros().get(0); // esto lo uso para que veamos que cambio de posicion
            alert.setHeaderText( "Arquero ");
            alert.setContentText("Vida actual: " + arquero.getVidaActual() + "\nPoder: " + arquero.getVidaActual()
                    + " (Costo: " + arquero.getCosto() + ")\nVelocidad: " + arquero.getCosto()
                    + " (Posicion: X: " + cuadrante.getX() +" Y :"+ cuadrante.getY() +")\nRango de ataque: "
                    + arquero.getCosto());
            alert.showAndWait();
        } else {

            if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                if (!MapaVistaControlador.tengoArqueroSeleccionado()) {
                    //si no esta seleccionado, entonces lo selecciono
                    if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(this.arquero)){
                        MenuInferior.getLog().appendText("\nNo es tuyo");
                    }else{
                        MenuInferior.getLog().appendText("\nArqueroSeleccionado Seleccionado");
                        MapaVistaControlador.seleccionarArquero(arquero);
                    }
                } else {

                    MenuInferior.getLog().appendText("\nHay otro aldeano en esta ubicacion, movimiento no valido");
                    MapaVistaControlador.desSeleccionarUnidades();

                } //el movimiento se realiza cuando hay un aldeano seleccionado y se hace click en un boton vacio
                //TODO MOVIMIENTO
            }
            if ("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                //TODO ATAQUE
                if (!MapaVistaControlador.tengoAlgunaUnidadSeleccionada()) {
                    //si no esta seleccionado, entonces lo selecciono
                    MenuInferior.getLog().appendText("\nArquero Seleccionado, ahora elegi que atacar!!!!");
                    MapaVistaControlador.seleccionarArquero(arquero);
                } /*else { //Seleccionado=true

                    //ATACAR
                    try {

                        MenuInferior.getLog().appendText("\n Ya seleccionaste antes una unidad y ahora se ataca a arquero!");

                        if(MapaVistaControlador.tengoEspadachinSeleccionado()){
                           // Ataco
                            // MapaVistaControlador.getEspadachinSeleccionado().atacar(arquero,Atacante,atacado,MapaVistaControlador.getMapa());
                        }
                    } catch (UnidadFueraDeRangoDeAtaqueException e) {


                    }
                }*/

            }
        }
    }
}

//XXSENTINELA
	/*
if ("Mover" == MenuInferior.selecOpciones.getSelectionModel().getSelectedItem().toString()) {
		if (TableroVistaControlador.seleccionado == false) {
			//si no esta seleccionado, entonces lo selecciono
			MenuInferior.log.appendText("\nAldeano Seleccionado!!!!, ahora hace algo");
			TableroVistaControlador.seleccionado = true;
			TableroVistaControlador.AldeanoSeleccionado = aldeano;

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
			//si no esta seleccionado, entonces lo selecciono
			MenuInferior.log.appendText("\nAldeano Seleccionado, ahora elegi que atacar!!!!");
			TableroVistaControlador.seleccionado = true;
			TableroVistaControlador.AldeanoSeleccionado = aldeano;
			//XXSentinela if (aldeano.getJugador().getEstado() == "activo") {
			//XXSentinela		MenuInferior.log.appendText("\naldeano seleccionado! Elija blanco de ataque");
			//XXSentinela		TableroVistaControlador.seleccionado = true;
			//XXSentinela	aldeano.getJugador().seleccionarPersonaje(aldeano.getNombre());
			//XXSentinela	TableroVistaControlador.aldeanoSeleccionado = aldeano;

		} else {

			//XXSentinela		MenuInferior.log.appendText("\nEste aldeano no es tuyo");
			MenuInferior.log.appendText("\nEste aldeano no es tuyo");
		}

	}else { //Seleccionado=true
		//ATACAR
		try {
			//XXSentinela	TableroVistaControlador.aldeanoSeleccionado.getJugador().atacar(aldeano.getPosicion(), ContenedorPrincipal.juego.getTablero());

			//XXSentinela	MenuInferior.log.appendText("\n" + TableroVistaControlador.aldeanoSeleccionado.getNombre() + " ataca a " + aldeano.getNombre());
			//XXSentinela	ContenedorPrincipal.juego.pasarTurno();
			//XXSentinela		TableroVistaControlador.seleccionado = false;
			//XXSentinela	} catch (FuegoAmigoException e) {
			MenuInferior.log.appendText("\n Ya seleccionaste antes un aldeano y ahora Entro en ataque!");

		}catch (UnidadFueraDeRangoDeAtaqueException e) {

			//XXSentinela		MenuInferior.log.appendText("\nAtaque fuera de rango");
			//XXSentinela	}

			//XXSentinela	TableroVistaControlador.seleccionado = false;
			//atrapar excepciones DONE
		}
	}


*/