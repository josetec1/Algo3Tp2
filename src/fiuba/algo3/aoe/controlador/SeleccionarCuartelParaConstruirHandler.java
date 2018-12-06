package fiuba.algo3.aoe.controlador;

import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class SeleccionarCuartelParaConstruirHandler implements EventHandler<MouseEvent> {


    private ContenedorPrincipal contenedor;

    public void handle(MouseEvent event) {
        MapaVistaControlador.seleccionarEdificioParaConstruir("Cuartel");
        MenuInferior.getLog().appendText("\nCuartel nuevo seleccionado");
    }

}
