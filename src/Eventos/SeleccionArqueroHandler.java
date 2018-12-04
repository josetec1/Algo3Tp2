package Eventos;


import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.ContenedorPrincipal;
import vista.MenuInferior;
import vista.MapaVistaControlador;

public class SeleccionArqueroHandler implements EventHandler<MouseEvent> {

    Arquero arquero;

    public SeleccionArqueroHandler(Arquero unArquero) {
        arquero = unArquero;
    }

    @Override
    public void handle(MouseEvent event) {

        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar arquero");
            Cuadrante cuadrante = arquero.getPosicion().getCasilleros().get(0); // esto lo uso para que veamos que cambio de posicion
            alert.setHeaderText( "Arquero ");
            alert.setContentText("Vida actual: " + arquero.getVidaActual() + "\nDanio contra unidad: " + arquero.getDanioGeneradoAUnidad()
                    + "\n Danio contra edificios "+ arquero.getDanioGeneradoAEdificio()+ "\nCosto: " + arquero.getCosto()
                    + " \nPosicion: (X: " + cuadrante.getX() +" Y :"+ cuadrante.getY() +")\n");
            alert.showAndWait();
        } else {

            if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                if (!MapaVistaControlador.tengoArqueroSeleccionado()) {
                    //si no esta seleccionado, entonces lo selecciono
                    if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(this.arquero)){
                        MenuInferior.getLog().appendText("\nNo es tuyo");
                    }else{
                        MenuInferior.getLog().appendText("\nArqueroSeleccionado Seleccionado");
                        MapaVistaControlador.seleccionarArquero(arquero);
                    }
                } else {

                    MenuInferior.getLog().appendText("\nHay otro aldeano en esta ubicacion, movimiento no valido");
                    MapaVistaControlador.desSeleccionarUnidades();

                } //el movimiento se realiza cuando hay un aldeano seleccionado y se hace click en un boton vacio
                //TODO MOVIMIENTO
            }else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                MenuInferior.getLog().appendText("\nAldeano no puede crear Unidad");
            }else if("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                //TODO ATAQUE
                MenuInferior.getLog().appendText("\nAldeano no puede crear edificio");
            }else if("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
                if (!ContenedorPrincipal.getJuego().getJugadorActual().esMio(arquero) && !MapaVistaControlador.tengoAlgunaUnidadSeleccionada() ){
                    MenuInferior.getLog().appendText("\n No tenes unidad seleccionada");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();

                }else if(!MapaVistaControlador.tengoAlgunaUnidadSeleccionada() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(arquero) ){
                    MapaVistaControlador.seleccionarArquero(arquero);
                    MenuInferior.getLog().appendText("\n arquero Seleccionado");
                }else if(MapaVistaControlador.tengoAldeanoSeleccionado()){
                    MenuInferior.getLog().appendText("\n Aldeano no puede atacar, seleccione blanco y atacante nuevamente");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
                }else if (MapaVistaControlador.tengoEspadachinSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getEspadachinSeleccionado()) &&
                        !ContenedorPrincipal.getJuego().getJugadorActual().esMio(arquero) && MapaVistaControlador.getEspadachinSeleccionado().getPosicion().distancia(arquero.getPosicion()) < 2 && MapaVistaControlador.getEspadachinSeleccionado().estasDisponible()){
                    MenuInferior.getLog().appendText("\n Atacando plaza con espadachin");
                    MapaVistaControlador.getEspadachinSeleccionado().atacar(arquero, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();

                }else if (MapaVistaControlador.tengoArqueroSeleccionado() && ContenedorPrincipal.getJuego().getJugadorActual().esMio(MapaVistaControlador.getArqueroSeleccionado()) &&
                        !ContenedorPrincipal.getJuego().getJugadorActual().esMio(arquero) && MapaVistaControlador.getArqueroSeleccionado().getPosicion().distancia(arquero.getPosicion()) < 4 && MapaVistaControlador.getArqueroSeleccionado().estasDisponible()){
                    MenuInferior.getLog().appendText("\n Atacando arquero con arquero");
                    MapaVistaControlador.getArqueroSeleccionado().atacar(arquero, ContenedorPrincipal.getJuego().getJugadorActual(),ContenedorPrincipal.getJuego().getJugadorInactivo(),MapaVistaControlador.getMapa());
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
                }else{
                    MenuInferior.getLog().appendText("\nEl blanco seleccionado no puede ser atacado por esta Unidad, seleccione nuevamente atacante y blanco");
                    MapaVistaControlador.desSeleccionarEdificio();
                    MapaVistaControlador.desSeleccionarUnidades();
                }
            }else if("Reparar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
                MenuInferior.getLog().appendText("\n Espadachin no puede reparar ni ser reparado, seleccione nuevamente");
                MapaVistaControlador.desSeleccionarEdificio();
                MapaVistaControlador.desSeleccionarUnidades();
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