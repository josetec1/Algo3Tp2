package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Posicion;
import modelo.Casillero;
import modelo.Terreno;
import vista.eventos.AplicacionOnKeyPressEventHandler;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Juego AOE ALGORITMOS 3 UBA");

        Casillero casillero = crearModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, casillero);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();

    }

    public String string = "lalalal";

    private Casillero crearModelo() {
        Terreno terreno = new Terreno(460, 250);
        Casillero casillero = new Casillero(terreno, new Posicion(10, 10), string);
        return casillero;
    }
}
