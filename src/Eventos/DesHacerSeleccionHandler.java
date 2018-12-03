package Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.MapaVistaControlador;
import vista.MenuInferior;

public class DesHacerSeleccionHandler implements EventHandler<MouseEvent>{


    public void handle(MouseEvent event) {
        MapaVistaControlador.desSeleccionarPosicion();
        MapaVistaControlador.desSeleccionarUnidadParaCrear();
        MapaVistaControlador.desSeleccionarUnidades();
        MapaVistaControlador.desSeleccionarEdificio();
        MenuInferior.getLog().appendText("\nSeleccion desecha, seleccione nuevamente unidades o edificios correctos");
    }

}
