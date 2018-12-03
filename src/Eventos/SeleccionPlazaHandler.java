package Eventos;

import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MapaVistaControlador;
import vista.MenuInferior;

public class SeleccionPlazaHandler implements EventHandler<MouseEvent> {

    private PlazaCentral plaza;

    public SeleccionPlazaHandler(PlazaCentral plaza){this.plaza=plaza;}
    @Override
    public void handle(MouseEvent event) {

        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar Plaza");
            Posicion posicion = plaza.getPosicion();
            String casillerosOcupados ="Posicion ocupada por casilleros: \n";
            for (Cuadrante cuadrante: posicion.getCasilleros()){
                casillerosOcupados+=  "Casillero: (X: " + cuadrante.getX() +" Y:" + cuadrante.getY()+" )\n";
            }
            alert.setHeaderText( "Plaza Central ");
            alert.setContentText(casillerosOcupados +
                    "Vida actual: " + plaza.getVidaActual() + "\nCosto: " + plaza.getCosto());
            alert.showAndWait();
        }else if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nPlaza plaza central no puede moverse");
        }else if ("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            //TODO MenuInferior.getLog().appendText("\nPlaza Seleccionada");
        }else if ("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nPlaza ya esta creada");
        }else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            MapaVistaControlador.seleccionarPlaza(plaza);
            MenuInferior.getLog().appendText("\nPlaza seleccionada");
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
                   MapaVistaControlador.getEspadachinSeleccionado().atacar(plaza, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
               }catch (Error e){
                   MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por este espadachim, seleccione nuevamente atacante y blanco");
                   MapaVistaControlador.desSeleccionarEdificio();
                   MapaVistaControlador.desSeleccionarUnidades();
               }
           }else if (MapaVistaControlador.tengoArqueroSeleccionado()){
               try {
                   MapaVistaControlador.getArqueroSeleccionado().atacar(plaza, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
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