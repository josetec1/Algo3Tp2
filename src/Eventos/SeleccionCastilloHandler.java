package Eventos;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MapaVistaControlador;
import vista.MenuInferior;

public class SeleccionCastilloHandler implements EventHandler<MouseEvent> {

    private Castillo castillo;

    public SeleccionCastilloHandler(Castillo castillo){this.castillo=castillo;}
    @Override
    public void handle(MouseEvent event) {

        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar Castillo");
            Posicion posicion = castillo.getPosicion();
            String casillerosOcupados = "Posicion ocupada por casilleros: \n";
            for (Cuadrante cuadrante : posicion.getCasilleros()) {
                casillerosOcupados += "Casillero: (X: " + cuadrante.getX() + " Y:" + cuadrante.getY() + " )\n";
            }
            alert.setHeaderText("Castillo ");
            alert.setContentText(casillerosOcupados +
                    "Vida actual: " + castillo.getVidaActual());
            alert.showAndWait();
        }else if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

                    MenuInferior.getLog().appendText("\nCastillo Seleccionado");

        }else if ("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCastillo ya esta creado");
        }else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            MapaVistaControlador.seleccionarCastillo(castillo);
            MenuInferior.getLog().appendText("\nCastillo Seleccionado");
        }else if("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            if(!MapaVistaControlador.tengoAlgunaUnidadSeleccionada()){
                MenuInferior.getLog().appendText("\n Primero seleccione una unidad Atacante y luego el blanco nuevamente");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado()){
                MenuInferior.getLog().appendText("\n Aldeano no puede atacar, seleccione blanco y atacante nuevamente");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if (MapaVistaControlador.tengoEspadachinSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getEspadachinSeleccionado()) &&
                    !ContenedorPrincipal.getJuego().getJugadorActual().esMio(castillo) && MapaVistaControlador.getEspadachinSeleccionado().getPosicion().distancia(castillo.getPosicion()) < 2 && MapaVistaControlador.getEspadachinSeleccionado().estasDisponible()){
                MenuInferior.getLog().appendText("\n Atacando castillo con espadachin");
                MapaVistaControlador.getEspadachinSeleccionado().atacar(castillo, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();

            }else if (MapaVistaControlador.tengoArqueroSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getArqueroSeleccionado()) &&
                    !ContenedorPrincipal.getJuego().getJugadorActual().esMio(castillo) && MapaVistaControlador.getArqueroSeleccionado().getPosicion().distancia(castillo.getPosicion()) < 4 && MapaVistaControlador.getArqueroSeleccionado().estasDisponible()){
                MenuInferior.getLog().appendText("\n Atacando castillo con arquero");
                MapaVistaControlador.getArqueroSeleccionado().atacar(castillo, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else{
                MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por esta Unidad, seleccione nuevamente atacante y blanco");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }
        }else if("Reparar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            if(!MapaVistaControlador.tengoAldeanoSeleccionado()){
                MenuInferior.getLog().appendText("\n Primero debe seleccionar el aldeano para reparar,realice nuevamente la seleccion de unidad y edificio");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado() && !ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())){
                MenuInferior.getLog().appendText("\nEl aldeano seleccionado no es tuyo");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado() && !ContenedorPrincipal.getJuego().getJugadorActual().esMio(castillo) && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())){
                MenuInferior.getLog().appendText("\nEl castillo seleccionada no es tuya");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
            }else if(MapaVistaControlador.tengoAldeanoSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(castillo) && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getAldeanoSeleccionado())){
                if(!MapaVistaControlador.getAldeanoSeleccionado().estasDisponible()){
                    MenuInferior.getLog().appendText("\nEl aldeano seleccionado esta ocupado este turno,repita seleccion");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
                }else{
                    MapaVistaControlador.getAldeanoSeleccionado().reparar(castillo,ContenedorPrincipal.getJuego().getJugadorActual());
                    MenuInferior.getLog().appendText("\nReparando Castillo");
                }
            }
        }else{
            MenuInferior.getLog().appendText("\n Elija una accion, y las piezas correctas nuevamente");
            MapaVistaControlador.desSeleccionarEdificio();
            MapaVistaControlador.desSeleccionarUnidades();
            MapaVistaControlador.desSeleccionarUnidadParaCrear();
            MapaVistaControlador.desSeleccionarPosicion();
        }
    }
}
