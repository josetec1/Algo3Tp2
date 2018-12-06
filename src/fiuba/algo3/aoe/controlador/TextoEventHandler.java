package fiuba.algo3.aoe.controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent>{
	
	private Button botonEnter;
	
	public TextoEventHandler(Button botonEnter){
		this.botonEnter = botonEnter;
	}
	
    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(botonEnter, new ActionEvent());
        }

    }
}
