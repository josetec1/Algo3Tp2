package fiuba.algo3.aoe.controlador;

import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class SeleccionAldeanoParaCrearUnidadHandler implements EventHandler<MouseEvent> {


    private ContenedorPrincipal contenedor;

    public void handle(MouseEvent event) {
        MapaVistaControlador.seleccionarUnidadParaCreacion("Aldeano");
        MenuInferior.getLog().appendText("\nAldeano nuevo seleccionado");
    }

}