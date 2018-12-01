package Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;

public class SeleccionPasarTurnoHandler  implements EventHandler<MouseEvent> {

    private ContenedorPrincipal contenedor;
    public SeleccionPasarTurnoHandler (ContenedorPrincipal contenedor){this.contenedor = contenedor;}

    @Override
    public void handle(MouseEvent event) {
        contenedor.getJuego().pasarJugada();
        MenuInferior.getLog().appendText("\n Se pasa turno");
    }
}

