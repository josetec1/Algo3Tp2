package fiuba.algo3.aoe.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;

public class SeleccionUpdateHandler implements EventHandler<MouseEvent>{

   private ContenedorPrincipal contenedor;
    public SeleccionUpdateHandler (ContenedorPrincipal contenedor){this.contenedor = contenedor;}

    @Override
    public void handle(MouseEvent event) {
        contenedor.actualizar();
        MenuInferior.getLog().appendText("\n Se actualiza el Mapa");}
    }



