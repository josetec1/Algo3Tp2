package fiuba.algo3.aoe.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.aoe.vista.ContenedorPrincipal;
import fiuba.algo3.aoe.vista.MapaVistaControlador;
import fiuba.algo3.aoe.vista.MenuInferior;




    public class SeleccionFinJuegoHandler  implements EventHandler<MouseEvent> {

        private ContenedorPrincipal contenedor;

        public SeleccionFinJuegoHandler (ContenedorPrincipal contenedor){this.contenedor = contenedor;}
        @Override
        public void handle(MouseEvent event) {
            MenuInferior.getLog().appendText("\n simulo fin");
            contenedor.getJuego().castilloEliminado();

        }
    }


