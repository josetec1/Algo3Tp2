package vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import vista.BarraDeMenu;

public class OpcionMinimizarHandler implements EventHandler<ActionEvent> {


    Stage stage;
    MenuItem opcionMinimizar;
    BarraDeMenu barraMenu;
    
    public OpcionMinimizarHandler(Stage stage, MenuItem opcionMinimizar,BarraDeMenu barraMenu) {
        this.stage = stage;
        this.opcionMinimizar = opcionMinimizar;
        this.barraMenu = barraMenu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(false);
            opcionMinimizar.setDisable(true);
            stage.setMaximized(true);
            stage.show();
            barraMenu.aplicacionMaximizada(false);
        }
    }
}
