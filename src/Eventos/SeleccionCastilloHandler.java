package Eventos;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.MenuInferior;

public class SeleccionCastilloHandler implements EventHandler<MouseEvent> {

    private Castillo castillo;

    public SeleccionCastilloHandler(Castillo castillo){this.castillo=castillo;}
    @Override
    public void handle(MouseEvent event) {

        if ("Mover" == MenuInferior.selecOpciones.getSelectionModel().getSelectedItem().toString()) {

                    MenuInferior.getLog().appendText("\nCastillo Seleccionado");

        }

    }
}
