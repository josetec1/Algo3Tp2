package Eventos;

import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.MenuInferior;

public class SeleccionPlazaHandler implements EventHandler<MouseEvent> {

    private PlazaCentral plaza;

    public SeleccionPlazaHandler(PlazaCentral plaza){this.plaza=plaza;}
    @Override
    public void handle(MouseEvent event) {
        if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nPlaza Seleccionada");

        }
    }
}