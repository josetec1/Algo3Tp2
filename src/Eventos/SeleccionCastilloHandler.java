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
            }else if (MapaVistaControlador.tengoEspadachinSeleccionado()){
                try {
                    MapaVistaControlador.getEspadachinSeleccionado().atacar(castillo, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                }catch (Error e){
                    MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por este espadachim, seleccione nuevamente atacante y blanco");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
                }
            }else if (MapaVistaControlador.tengoArqueroSeleccionado()){
                try {
                    MapaVistaControlador.getArqueroSeleccionado().atacar(castillo, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                }catch (Error e){
                    MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por este espadachim, seleccione nuevamente atacante y blanco");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
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
