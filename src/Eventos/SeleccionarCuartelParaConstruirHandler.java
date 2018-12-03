package Eventos;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MapaVistaControlador;
import vista.MenuInferior;

public class SeleccionarCuartelParaConstruirHandler implements EventHandler<MouseEvent> {


    private ContenedorPrincipal contenedor;

    public void handle(MouseEvent event) {
        MapaVistaControlador.seleccionarEdificioParaConstruir("Cuartel");
        MenuInferior.getLog().appendText("\nCuartel nuevo seleccionado");
    }

}
