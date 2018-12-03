package Eventos;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

        }else if ("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
            //TODO
        }else if ("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCastillo ya esta creado");
        }else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            MapaVistaControlador.seleccionarCastillo(castillo);
            MenuInferior.getLog().appendText("\nCastillo Seleccionado");
        }
    }
}
