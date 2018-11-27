package vista;

import fiuba.algo3.aoe.Juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import vista.eventos.AplicacionOnKeyPressEventHandler;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        AudioClip audioIntro = new AudioClip("vista/sonidos/musicaFondo.mp3");
        audioIntro.setCycleCount(2);
        audioIntro.play();

        BarraDeMenu barraMenu = new BarraDeMenu(stage, audioIntro);

        Juego juego = new Juego();
        stage.setTitle("Juego AOE ALGORITMOS 3 FIUBA");

        ContenedorVictoria contenedorVictoria = new ContenedorVictoria(stage, audioIntro);
        Scene escenaVictoria = new Scene(contenedorVictoria, 640, 480);

        ContenedorPrincipal contenedorPrincipal =
                new ContenedorPrincipal(stage, escenaVictoria, juego, barraMenu);
        Scene escenaJuego =
                new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler =
                new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorEleccionJugador contenedorEleccion =
                new ContenedorEleccionJugador(stage, escenaJuego, juego, contenedorPrincipal);
        Scene escenaEleccion =
                new Scene(contenedorEleccion, 640, 480);
        escenaEleccion.setOnKeyPressed(AplicacionOnKeyPressEventHandler);


        ContenedorBienvenida contenedorBienvenidos =
                new ContenedorBienvenida(stage, barraMenu, audioIntro,escenaEleccion);
        Scene escenaBienvenidos =
                new Scene(contenedorBienvenidos, 640, 480);
        escenaBienvenidos.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");

        stage.show();

    }

    /*public String string = "lalala";

    private Celda crearModelo() {
        Terreno terreno = new Terreno(460, 250);
        Celda casillero = new Celda(terreno, new Posicion(10, 10), string);
        return casillero;
    }*/
}
