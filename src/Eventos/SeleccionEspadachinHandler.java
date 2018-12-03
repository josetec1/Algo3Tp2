package Eventos;


import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;
import vista.MapaVistaControlador;

public class SeleccionEspadachinHandler implements EventHandler<MouseEvent> {

    Espadachin espadachin;

    public SeleccionEspadachinHandler(Espadachin unEspadachin) {
        espadachin = unEspadachin;
    }

    @Override
    public void handle(MouseEvent event) {

        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar Espadachin");
            Cuadrante cuadrante = espadachin.getPosicion().getCasilleros().get(0); // esto lo uso para que veamos que cambio de posicion
            alert.setHeaderText( "Espadachin ");
            alert.setContentText("Vida actual: " + espadachin.getVidaActual() + "\nDanio contra unidad: " + espadachin.getDanioGeneradoAUnidad()
                    + "\n Danio contra edificios "+ espadachin.getDanioGeneradoAEdificio()+ "\nCosto: " + espadachin.getCosto()
                    + " \nPosicion: (X: " + cuadrante.getX() +" Y :"+ cuadrante.getY() +")\n");
            alert.showAndWait();
        } else {
            if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                if (!MapaVistaControlador.tengoArqueroSeleccionado()) {
                    //si no esta seleccionado, entonces lo selecciono
                    if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(this.espadachin)){
                        MenuInferior.getLog().appendText("\nNo es tuyo");
                    }else{
                        MenuInferior.getLog().appendText("\nEspadachin Seleccionado Seleccionado");
                        MapaVistaControlador.seleccionarEspadachin(espadachin);
                    }
                } else {

                    MenuInferior.getLog().appendText("\nHay otra unidad en esta ubicacion, movimiento no valido");
                    MapaVistaControlador.desSeleccionarUnidades();

                } //el movimiento se realiza cuando hay un aldeano seleccionado y se hace click en un boton vacio
                //TODO MOVIMIENTO
            }else if("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                //TODO ATAQUE
                MenuInferior.getLog().appendText("\nEspadachin no puede crear edificio");
            }else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                //TODO ATAQUE
                MenuInferior.getLog().appendText("\nEspadachin no puede crear Unidad");
            }else if("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
                if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(espadachin) && !MapaVistaControlador.tengoAlgunaUnidadSeleccionada() ){
                    MenuInferior.getLog().appendText("\n No es tuyo");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();

                }else if(!MapaVistaControlador.tengoAlgunaUnidadSeleccionada() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(espadachin) ){
                    MapaVistaControlador.seleccionarEspadachin(espadachin);
                    MenuInferior.getLog().appendText("\n espadachin Seleccionado");
                }else if(MapaVistaControlador.tengoAldeanoSeleccionado()){
                    MenuInferior.getLog().appendText("\n Aldeano no puede atacar, seleccione blanco y atacante nuevamente");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
                }else if (MapaVistaControlador.tengoEspadachinSeleccionado()){
                    try {
                        MapaVistaControlador.getEspadachinSeleccionado().atacar(espadachin, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                        MenuInferior.getLog().appendText("\nEspadachin ataca Espadachin");

                        MapaVistaControlador.desSeleccionarEdificio();
                        MapaVistaControlador.desSeleccionarUnidades();
                    }catch (Error e){
                        MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por este espadachim, seleccione nuevamente atacante y blanco");
                        MapaVistaControlador.desSeleccionarEdificio();
                        MapaVistaControlador.desSeleccionarUnidades();
                    }
                }else if (MapaVistaControlador.tengoArqueroSeleccionado()){
                    try {
                        MapaVistaControlador.getArqueroSeleccionado().atacar(espadachin, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                        MenuInferior.getLog().appendText("\nArquero ataca espadachin");

                        MapaVistaControlador.desSeleccionarEdificio();
                        MapaVistaControlador.desSeleccionarUnidades();
                    }catch (Error e){
                        MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por este arquero, seleccione nuevamente atacante y blanco");
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
}