package Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MapaVistaControlador;
import vista.MenuInferior;

public class SeleccionEspadachinParaCrearUnidadHandler implements EventHandler<MouseEvent> {


    private ContenedorPrincipal contenedor;

    public void handle(MouseEvent event) {
        MapaVistaControlador.seleccionarUnidadParaCreacion("Espadachin");
        MenuInferior.getLog().appendText("\nEspadachin nuevo seleccionado");
    }

}