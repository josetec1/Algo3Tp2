package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import vista.BarraDeMenu;

public class OpcionReproducirHandler implements EventHandler<ActionEvent>{

    BarraDeMenu barraMenu;
    AudioClip musica;

    public OpcionReproducirHandler(BarraDeMenu barraMenu, AudioClip musica) {
        this.barraMenu = barraMenu;
        this.musica = musica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	if(!musica.isPlaying()){
    		musica.play();
    		barraMenu.reproduciendoMusica(true);
    	}
    }
}
