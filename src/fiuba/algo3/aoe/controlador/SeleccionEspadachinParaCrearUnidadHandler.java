package fiuba.algo3.aoe.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;

public class SeleccionEspadachinParaCrearUnidadHandler implements EventHandler<MouseEvent> {


    private ContenedorPrincipal contenedor;

    public void handle(MouseEvent event) {
        MapaVistaControlador.seleccionarUnidadParaCreacion("Espadachin");
        MenuInferior.getLog().appendText("\nEspadachin nuevo seleccionado");
    }

}