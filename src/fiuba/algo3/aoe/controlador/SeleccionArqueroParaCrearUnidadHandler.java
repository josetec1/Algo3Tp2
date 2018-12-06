package fiuba.algo3.aoe.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;

public class SeleccionArqueroParaCrearUnidadHandler implements EventHandler<MouseEvent> {


    private ContenedorPrincipal contenedor;

    public void handle(MouseEvent event) {
        MapaVistaControlador.seleccionarUnidadParaCreacion("Arquero");
        MenuInferior.getLog().appendText("\nArquero nuevo seleccionado");
    }

}