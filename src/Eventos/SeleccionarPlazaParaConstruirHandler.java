package Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MapaVistaControlador;
import vista.MenuInferior;

public class SeleccionarPlazaParaConstruirHandler implements EventHandler<MouseEvent> {
    private ContenedorPrincipal contenedor;

    public void handle(MouseEvent event) {
        MapaVistaControlador.seleccionarEdificioParaConstruir("Plaza Central");
        MenuInferior.getLog().appendText("\n Plaza Central nueva seleccionada");
    }
}
