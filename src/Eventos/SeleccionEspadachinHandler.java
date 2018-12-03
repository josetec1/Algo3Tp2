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
            }
            if ("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                //TODO ATAQUE
                if (!MapaVistaControlador.tengoAlgunaUnidadSeleccionada()) {
                    //si no esta seleccionado, entonces lo selecciono
                    MenuInferior.getLog().appendText("\nEspadachin Seleccionado, ahora elegi que atacar!!!!");
                    MapaVistaControlador.seleccionarEspadachin(espadachin);
                } else{

                }
            }if("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                //TODO ATAQUE
                MenuInferior.getLog().appendText("\nEspadachin no puede crear edificio");
            }if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
                //TODO ATAQUE
                MenuInferior.getLog().appendText("\nEspadachin no puede crear Unidad");
            }
        }
    }
}