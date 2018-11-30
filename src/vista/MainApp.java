package vista;


import fiuba.algo3.aoe.Juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    
	@Override
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Age Of Empires");


        Juego unJuego = new Juego("mario","Diego",70,40);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage, unJuego); //

        Scene scene = new Scene(contenedorPrincipal,1280,720);
        
        primaryStage.setScene(scene);
        primaryStage.show();


	}

	public static void main(String[] args) {


		launch(args);
	}
}
