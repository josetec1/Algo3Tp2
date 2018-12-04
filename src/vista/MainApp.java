package vista;


import fiuba.algo3.aoe.Juego.Juego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.borrar.BotonEnviarEventHandler;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;




    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Age Of Campeones");



/****************************************************************************************************/
        Label titulo = new Label("Ingrese Nombre J1");

        //Definimos fuente y tamaño.
        titulo.setFont(Font.font("Tahoma", FontWeight.BLACK, 25));

        Label etiqueta = new Label();
        etiqueta.setText("Nombre: ");


        TextField campoNombre = new TextField();

        //Seteo el texto de fondo del campo.
        campoNombre.setPromptText("Ingrese su nombre");
        //Dejo el campo fuera de foco, con esto deberia verse el texto seteado.
        campoNombre.setFocusTraversable(false);


        Label nombreJ1 = new Label();
        nombreJ1.setFont(Font.font("Times New Roman", 20));
        //Hacemos invisible el saludo, se hara visible al accionarse el boton enviar.
        nombreJ1.setVisible(false);

        Label nombreJ2 = new Label();
        nombreJ1.setFont(Font.font("Times New Roman", 20));
        //Hacemos invisible el saludo, se hara visible al accionarse el boton enviar.
        nombreJ1.setVisible(false);

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");



        //Creamos instancia para el evento del boton enviar y lo seteamos.
        BotonEnviarEventHandler botonEnviarEvento = new BotonEnviarEventHandler(campoNombre, nombreJ1,nombreJ2,titulo, this );
        botonEnviar.setOnAction(botonEnviarEvento);

        HBox contenedorHorizontal = new HBox();
        //10 pixeles de separación entre componentes.
        contenedorHorizontal.setSpacing(10);
        //Agrego los dos botones.
        contenedorHorizontal.getChildren().addAll(botonEnviar);


        GridPane contenedorMatriz = new GridPane();

        //Separacion vertical y horizontal entre elementos.
        contenedorMatriz.setVgap(5);
        contenedorMatriz.setHgap(10);

        //Agregamos en columna 0 y fila 0.
        contenedorMatriz.add(etiqueta, 0, 0);
        //Agregamos en columna 1 y fila 0.
        contenedorMatriz.add(campoNombre, 1, 0);
        //Agregamos en columna 1 y fila 1.
        contenedorMatriz.add(contenedorHorizontal, 1, 1);


        //Inicializamos con 20 pixeles de separacion entre nodos.
        VBox contenedorPrincipal = new VBox(20);

        //Espacio de separacion del contenedor con el borde de la ventana.
        contenedorPrincipal.setPadding(new Insets(20));

        //Termino de agregar todos los elementos al contenedor principal.
        contenedorPrincipal.getChildren().addAll(titulo, contenedorMatriz);

        //Creamos la escena con el contenedor raíz, el ancho y alto.
        Scene scene = new Scene(contenedorPrincipal, 350, 250);

        //Seteamos la escena a la ventana.
        primaryStage.setScene(scene);

        primaryStage.show();






    }

    public void llamar(Label nombreJ1, Label nombreJ2){
    Juego unJuego = new Juego( nombreJ1.getText(), nombreJ2.getText(),40,30);
    ContenedorPrincipal contenedorPrincipal22 = new ContenedorPrincipal(primaryStage, unJuego);
    Scene scene2 = new Scene(contenedorPrincipal22,1440,900);

        primaryStage.setScene(scene2);
        primaryStage.show();

    }




















    /*
	@Override
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Age Of Campeones");


        Juego unJuego = new Juego("Diego","Maradona",40,30);
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage, unJuego);
        Scene scene = new Scene(contenedorPrincipal,1440,900);



        primaryStage.setScene(scene);
        primaryStage.show();


	}
*/
	public static void main(String[] args) {


		launch(args);
	}
}
