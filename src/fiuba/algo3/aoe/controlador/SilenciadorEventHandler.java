package fiuba.algo3.aoe.controlador;

import fiuba.algo3.aoe.vista.MainApp;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class SilenciadorEventHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		MainApp.silenciarMusica();
	}

}
