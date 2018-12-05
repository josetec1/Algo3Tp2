package Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.MainApp;

public class SilenciadorEventHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		MainApp.silenciarMusica();
	}

}
