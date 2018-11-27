package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import vista.eventos.*;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    MenuItem opcionVentana = new MenuItem("Vista Ventana");
    MenuItem opcionReproducir = new MenuItem("Reproducir");
    MenuItem opcionSilenciar = new MenuItem("Silenciar");
    AudioClip musica;


    /*public BarraDeMenu(Stage stage) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionAbrir, new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }
*/
    public BarraDeMenu(Stage stage, AudioClip musica){
        Menu menuArchivo = crearMenuArchivo(stage);
        Menu menuVer = crearMenuVer(stage);
        Menu menuMusica = crearMenuMusica(stage, musica);
        Menu menuInformacion = crearMenuInformacion(stage);
        this.musica = musica;

        this.getMenus().addAll(menuArchivo, menuVer, menuMusica, menuInformacion);
    }

    private Menu crearMenuArchivo(Stage stage){
        Menu menu = new Menu("Archivo");
        MenuItem opcionSalir = new MenuItem("Salir");
        menu.getItems().addAll(opcionSalir);

        EventHandler<ActionEvent> opcionSalirHandler = new BotonSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        return menu;
    }

    private Menu crearMenuVer(Stage stage){
        Menu menu = new Menu("Ver");
        menu.getItems().addAll(opcionPantallaCompleta, opcionVentana);

        EventHandler<ActionEvent> opcionPantallaCompletaHandler =
                new OpcionPantallaCompletaHandler(stage, opcionPantallaCompleta, this);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        opcionPantallaCompleta.setDisable(true);

        EventHandler<ActionEvent> opcionVentanaHandler =
                new OpcionVentanaHandler(stage, opcionVentana, this);
        opcionVentana.setOnAction(opcionVentanaHandler);
        opcionVentana.setDisable(false);

        return menu;
    }

    private Menu crearMenuInformacion(Stage stage){
        Menu menu = new Menu("Informacion");
        MenuItem opcionInformacion = new MenuItem("Ver reglas");
        menu.getItems().addAll(opcionInformacion);

        EventHandler<ActionEvent> opcionInformacionHandler =
                new OpcionInformacionEventHandler(stage);
        opcionInformacion.setOnAction(opcionInformacionHandler);

        return menu;
    }

    private Menu crearMenuMusica(Stage stage, AudioClip musica){
        Menu menu = new Menu("Reproducir/Silenciar");
        menu.getItems().addAll(opcionReproducir, opcionSilenciar);

        EventHandler<ActionEvent> opcionReproducirHandler =
                new OpcionReproducirHandler(this, musica);
        opcionReproducir.setOnAction(opcionReproducirHandler);
        opcionReproducir.setDisable(true);

        EventHandler<ActionEvent> opcionSilenciarHandler =
                new OpcionSilenciarHandler(this, musica);
        opcionSilenciar.setOnAction(opcionSilenciarHandler);
        opcionSilenciar.setDisable(false);

        return menu;
    }

    public void aplicacionMaximizada(Boolean estaMaximizada) {
        opcionPantallaCompleta.setDisable(estaMaximizada);
        opcionVentana.setDisable(!estaMaximizada);
    }

    public void reproduciendoMusica(Boolean estaReproduciendo){
        opcionReproducir.setDisable(estaReproduciendo);
        opcionSilenciar.setDisable(!estaReproduciendo);
    }
}

