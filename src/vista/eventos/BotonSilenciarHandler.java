package vista.eventos;

import vista.ContenedorBienvenida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonSilenciarHandler implements EventHandler<ActionEvent>{

	public AudioClip musica;
	public ContenedorBienvenida contenedorOrigen;
		
	
	public BotonSilenciarHandler(AudioClip musica,ContenedorBienvenida contenedorBienvenida) {
		this.musica = musica;
		this.contenedorOrigen = contenedorBienvenida;
	}
	

	@Override
	public void handle(ActionEvent event) {
		AudioClip audioBoton = new AudioClip("vista/sonidos/boton.mp3");
        audioBoton.play();
		musica.stop();
		contenedorOrigen.musicaEstaReproduciendo(false);
	}

}
