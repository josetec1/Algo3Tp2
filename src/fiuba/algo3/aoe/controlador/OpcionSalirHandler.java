package fiuba.algo3.aoe.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionSalirHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {

		System.exit(0);
	}

}
