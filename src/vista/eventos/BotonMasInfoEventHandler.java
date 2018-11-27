package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BotonMasInfoEventHandler implements EventHandler<ActionEvent> {

	BotonVolverAlJuegoEventHandler eventHandlerSalir;
	Stage stagePrincipal;
	
	
	BotonMasInfoEventHandler(BotonVolverAlJuegoEventHandler salir,Stage stagePrincipal){
		this.stagePrincipal= stagePrincipal;
		this.eventHandlerSalir = salir;
	}
	
	@Override
	public void handle(ActionEvent event) {
		eventHandlerSalir.handle(event);
		Stage stage= new Stage();
		VBox root = new VBox();

		//PONER MAS REGLAS:
		Image imagen = new Image("vista/imagenes/fondo-negro.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Button volverAlJuego = new Button("Volver al juego");
        BotonVolverAlJuegoEventHandler salir = new BotonVolverAlJuegoEventHandler(stage,stagePrincipal);
        volverAlJuego.setMinSize(100, 50);
        volverAlJuego.setFont(Font.font("Courier New",FontWeight.BOLD, 20));
        volverAlJuego.setStyle("-fx-base: #123400");
        volverAlJuego.setOnAction(salir);
        root.setPadding(new Insets(50,0,100,50));
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().addAll(volverAlJuego);
        root.setBackground(new Background(imagenDeFondo));
        stage.setFullScreen(true);
        stage.setScene(new Scene(root));
        stage.setFullScreenExitHint("");
        stage.show();    
	}
}
