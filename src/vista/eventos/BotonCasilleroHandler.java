package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Celda;

public class BotonCasilleroHandler implements EventHandler<ActionEvent> {

    private final Celda celda;

    public BotonCasilleroHandler(Celda celda) {
        this.celda = celda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.celda.getMensaje();
    }
}
