package Eventos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaHandler implements EventHandler<ActionEvent>{

    Stage stage;
    MenuItem opcionPantallaCompleta;
    
    public OpcionPantallaCompletaHandler(Stage stage, MenuItem opcionPantallaCompleta) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
        if (!stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
	}
}
}
