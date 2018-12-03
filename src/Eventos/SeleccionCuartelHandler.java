package Eventos;

import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import vista.MapaVistaControlador;
import vista.MenuInferior;

public class SeleccionCuartelHandler implements EventHandler<MouseEvent> {
    private Cuartel cuartel;

    public SeleccionCuartelHandler(Cuartel cuartel){this.cuartel=cuartel;}

    public void handle(MouseEvent event) {
        MouseButton button = event.getButton();
        if (button == MouseButton.SECONDARY) { //Observar
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Observar Cuartel");
            Posicion posicion = cuartel.getPosicion();
            String casillerosOcupados = "Posicion ocupada por casilleros: \n";
            for (Cuadrante cuadrante : posicion.getCasilleros()) {
                casillerosOcupados += "Casillero: (X: " + cuadrante.getX() + " Y:" + cuadrante.getY() + " )\n";
            }
            alert.setHeaderText("Cuartel ");
            alert.setContentText(casillerosOcupados +
                    "Vida actual: " + cuartel.getVidaActual() + "\nCosto: " + cuartel.getCosto());
            alert.showAndWait();
        }else if ("Mover" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCuartel no puede moverse");
        }else if ("Atacar" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {
            //TODO
        }else if ("Crear Edificio" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()) {

            MenuInferior.getLog().appendText("\nCuartel ya esta creado");
        }else if("Crear Unidad" == MenuInferior.getSelecOpciones().getSelectionModel().getSelectedItem().toString()){
            MapaVistaControlador.seleccionarCuartel(cuartel);
            MenuInferior.getLog().appendText("\nCuartel Seleccionado");
        }

    }
}
