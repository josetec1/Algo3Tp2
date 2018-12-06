package fiuba.algo3.aoe.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;

public class SeleccionPasarTurnoHandler  implements EventHandler<MouseEvent> {

    private ContenedorPrincipal contenedor;
    public SeleccionPasarTurnoHandler (ContenedorPrincipal contenedor){this.contenedor = contenedor;}

    @Override
    public void handle(MouseEvent event) {
        MenuInferior.getLog().appendText("\n Se pasa turno");
        contenedor.getJuego().pasarJugada();
    }
}

