package Eventos;


import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadFueraDeRangoDeAtaqueException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;
import vista.MapaVistaControlador;

import java.util.ArrayList;

public class SeleccionEspadachinHandler implements EventHandler<MouseEvent> {

    Espadachin espadachin;

    public SeleccionEspadachinHandler(Espadachin unEspadachin) {
        espadachin = unEspadachin;
    }

    @Override
    public void handle(MouseEvent event) {

        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar arquero");
            Cuadrante cuadrante = espadachin.getPosicion().getCasilleros().get(0); // esto lo uso para que veamos que cambio de posicion
            alert.setHeaderText( "Arquero ");
            alert.setContentText("Vida actual: " + espadachin.getVidaActual() + "\nPoder: " + espadachin.getVidaActual()
                    + " (Costo: " + espadachin.getCosto() + ")\nVelocidad: " + espadachin.getCosto()
                    + " (Posicion: X: " + cuadrante.getX() +" Y :"+ cuadrante.getY() +")\nRango de ataque: "
                    + espadachin.getCosto());
            alert.showAndWait();
        } else {

            if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                if (!MapaVistaControlador.tengoArqueroSeleccionado()) {
                    //si no esta seleccionado, entonces lo selecciono
                    if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(this.espadachin)){
                        MenuInferior.getLog().appendText("\nNo es tuyo");
                    }else{
                        MenuInferior.getLog().appendText("\nArqueroSeleccionado Seleccionado");
                        MapaVistaControlador.seleccionarEspadachin(espadachin);
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
                    MapaVistaControlador.seleccionarEspadachin(espadachin);
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