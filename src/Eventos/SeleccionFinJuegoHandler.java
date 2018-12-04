package Eventos;

import fiuba.algo3.aoe.Juego.Juego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;




    public class SeleccionFinJuegoHandler  implements EventHandler<MouseEvent> {

        private ContenedorPrincipal contenedor;

        public SeleccionFinJuegoHandler (ContenedorPrincipal contenedor){this.contenedor = contenedor;}
        @Override
        public void handle(MouseEvent event) {
            MenuInferior.getLog().appendText("\n simulo fin");
            contenedor.getJuego().castilloEliminado();

        }
    }


