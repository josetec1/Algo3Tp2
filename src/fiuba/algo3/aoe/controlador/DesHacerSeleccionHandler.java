package fiuba.algo3.aoe.controlador;

import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class DesHacerSeleccionHandler implements EventHandler<MouseEvent>{


    public void handle(MouseEvent event) {
        MapaVistaControlador.desSeleccionarPosicion();
        MapaVistaControlador.desSeleccionarUnidadParaCrear();
        MapaVistaControlador.desSeleccionarUnidades();
        MapaVistaControlador.desSeleccionarEdificio();
        MenuInferior.getLog().appendText("\nSeleccion desecha, seleccione nuevamente unidades o edificios correctos");
    }

}
