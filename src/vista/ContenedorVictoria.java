package vista;

import vista.eventos.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorVictoria extends VBox{
	
        private static Label etiqueta = new Label("");
        private static AudioClip audioViejo;

        public ContenedorVictoria(Stage stage, AudioClip audio) {

            super();
            audioViejo = audio;

            this.setAlignment(Pos.CENTER);
            this.setSpacing(20);
            this.setPadding(new Insets(480, 50, 50, 50));
           	Image imagen = new Image("vista/imagenes/victoria.jpg");
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            this.setBackground(new Background(imagenDeFondo));

            Button botonAceptar = new Button();
            botonAceptar.setText("Aceptar Victoria!");
            botonAceptar.setMinSize(300, 170);
            botonAceptar.setFont(Font.font("Courier New",FontWeight.BOLD, 72));
            botonAceptar.setStyle("-fx-base: #123400");
            
            etiqueta.setFont(Font.font("Courier New",FontWeight.BOLD, 60));
            etiqueta.setTextFill(Color.ORANGE);
            
            BotonSalirEventHandler botonVictoria = new BotonSalirEventHandler();
            botonAceptar.setOnAction(botonVictoria);
	        
            this.getChildren().addAll(etiqueta, botonAceptar);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
            stage.show();
        }
        
        public static void recibirGanador(String ganador){
        	etiqueta.setText("Ganador: " + ganador);
        	audioViejo.stop();
        	AudioClip audioVictoria = new AudioClip("vista/sonidos/victoria.mp3");
    	    audioVictoria.play();
        }
}