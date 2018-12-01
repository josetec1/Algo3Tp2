package Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;

public class SeleccionUpdateHandler implements EventHandler<MouseEvent>{

   private ContenedorPrincipal contenedor;
    public SeleccionUpdateHandler (ContenedorPrincipal contenedor){this.contenedor = contenedor;}

    @Override
    public void handle(MouseEvent event) {
        contenedor.update(null,null);
        MenuInferior.log.appendText("\n Se actualiza el Mapa");}
    }



