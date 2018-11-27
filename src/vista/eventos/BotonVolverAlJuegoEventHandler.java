package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class BotonVolverAlJuegoEventHandler implements EventHandler<ActionEvent>{

	Stage stage;
	Stage stagePrincipal;
	
	public BotonVolverAlJuegoEventHandler (Stage stage,Stage stagePrincipal){
				this.stage = stage;
				this.stagePrincipal = stagePrincipal;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		AudioClip audioBoton = new AudioClip("vista/sonidos/boton2.mp3");
        audioBoton.play();
		stage.close();
		stagePrincipal.setFullScreen(true);
	}

}
