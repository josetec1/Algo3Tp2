package Eventos;

import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.MenuInferior;

public class SeleccionCuartelHandler implements EventHandler<MouseEvent> {
    private Cuartel cuartel;

    public SeleccionCuartelHandler(Cuartel cuartel){this.cuartel=cuartel;}

    public void handle(MouseEvent event) {
        if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCuartel Seleccionado");
        }
        if ("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\n Cuartel Seleccionado");
        }
        if ("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCuartel Seleccionado");
        }

    }
}
