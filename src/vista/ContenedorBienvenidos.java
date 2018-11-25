package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.eventos.BotonEntrarEventHandler;

public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(70);
        this.setPadding(new Insets(100));
        Image imagen = new Image("file:src/vista/imagenes/stars.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 32));

        etiqueta.setText("      Bienvenidos al juego \n         AGE OF EMPIRES\n de Algoritmos y Programación III.\n" +
                "        Haga click en entrar");
        etiqueta.setTextFill(Color.web("#C0C0C0"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEntrar);
    }

}
