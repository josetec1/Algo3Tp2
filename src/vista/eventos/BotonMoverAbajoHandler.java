package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Celda;
import vista.VistaCasillero;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {

    private final VistaCasillero vista;
    private final Celda celda;

    public BotonMoverAbajoHandler(VistaCasillero vista, Celda celda) {
        this.vista = vista;
        this.celda = celda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.celda.moverAbajo();
        this.vista.update();
    }
}