package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Casillero;
import modelo.Terreno;
import vista.VistaCasillero;

public class BotonCasilleroHandler implements EventHandler<ActionEvent> {

    private final VistaCasillero vista;
    private final Casillero casillero;

    public BotonCasilleroHandler(Casillero casillero) {
        this.casillero = casillero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.casillero.getMensaje();
    }
}
