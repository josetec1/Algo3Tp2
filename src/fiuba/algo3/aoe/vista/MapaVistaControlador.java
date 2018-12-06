package fiuba.algo3.aoe.vista;

import fiuba.algo3.aoe.modelo.Juego.Juego;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import fiuba.algo3.aoe.vista.color.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import fiuba.algo3.aoe.controlador.*;


//TODO ojo el obsvador juego....
public class MapaVistaControlador {

    private static String unidadSeleccionadaParaCrear;
    private static boolean unidadParaCrearEstaSeleccionada;
    private static Mapa mapa;
    private static GridPane tableroView;
    private static Juego juego;

    private static String edificioSeleccionadoParaConstruccion;
    private static boolean aldeanoSeleccionado;
    private static boolean arqueroSeleccionada;
    private static boolean espadachinSeleccionada;
    private static boolean castilloSeleccionada;
    private static boolean plazaSeleccionada;
    private static boolean cuartelSeleccionada;
    private static boolean armAsedioSeleccionada;


    private static Aldeano aldeano;
    private static Arquero arquero;
    private static Espadachin espadachin;
    private static PlazaCentral plaza;
    private static Cuartel cuartel;
    private static Castillo castillo;
    private static ArmaDeAsedio armaDeAsedio;
    private static PosicionReal posicionRealSeleccionada;
    private static boolean posicionEstaSeleccionada = false;
    private static boolean edificioParaConstruccionEstaSeleccionado = false;


    public MapaVistaControlador(Juego unJuego, GridPane unGrid) {
        tableroView = unGrid;
        mapa = unJuego.getMapa();
        juego = unJuego;
        this.desSeleccionarUnidades();
    }

    public static String getUnidadSeleccionadaParaCrear() {
        if (!tengoUnidadSeleccionadaParaCrear()) {
            throw new NoHayUnidadSeleccionadaException();
        }
        return unidadSeleccionadaParaCrear;
    }

    public static boolean tengoUnidadSeleccionadaParaCrear() {
        return unidadParaCrearEstaSeleccionada;
    }

    public static void seleccionarUnidadParaCreacion(String unidad) {
        unidadParaCrearEstaSeleccionada = true;
        unidadSeleccionadaParaCrear = unidad;
    }

    public static void desSeleccionarUnidadParaCrear() {
        unidadParaCrearEstaSeleccionada = false;
    }

    public static Mapa getMapa() {
        return mapa;
    }

    public static String getEdificioSeleccionadoParaConstruccion() {
        if (!edificioParaConstruccionEstaSeleccionado) {
            throw new NoHayEdificioSeleccionadoException();
        }
        return edificioSeleccionadoParaConstruccion;
    }

    public static PosicionReal getPosicionSeleccionada() {
        if (!posicionEstaSeleccionada) {
            throw new NoHayPoscionSeleccionadaException();
        }
        return posicionRealSeleccionada;
    }

    public static void desSeleccionarPosicion() {
        posicionEstaSeleccionada = false;
    }

    public static void desSeleccionarEdificio() {
        edificioParaConstruccionEstaSeleccionado = false;
    }

    public static boolean tengoEdificioParaConstruccionSeleccionado() {
        return edificioParaConstruccionEstaSeleccionado;
    }

    public static boolean tengoPosicionSeleccionada() {
        return posicionEstaSeleccionada;
    }

    public static void seleccionarEdificioParaConstruir(String edificio) {
        edificioSeleccionadoParaConstruccion = edificio;
        edificioParaConstruccionEstaSeleccionado = true;
    }

    public static void seleccionarPosicion(PosicionReal posicionReal) {
        posicionEstaSeleccionada = true;
        posicionRealSeleccionada = posicionReal;
    }

    public static boolean tengoAlgunEdificioSeleccionado() {
        return castilloSeleccionada == true || plazaSeleccionada == true || cuartelSeleccionada == true;
    }

    public void dibujarTablero() {
        tableroView.setOnMousePressed(null);
        for (int i = 0; i < (mapa.getAncho()); i++) {
            tableroView.getColumnConstraints().add(new ColumnConstraints(18));
        }
        for (int j = 0; j < (mapa.getAlto()); j++) {
            tableroView.getRowConstraints().add(new RowConstraints(17));
        }
        crearBotones();
        tableroView.setAlignment(Pos.CENTER);
    }

    private void crearBotones() {

        for (int i = 1; i <= mapa.getAncho(); i++) {
            for (int j = 1; j <= mapa.getAlto(); j++) {

                Button boton = new Button("");
                boton.setAlignment(Pos.CENTER);
                boton.setTranslateX(0);
                boton.setPrefWidth(20);
                boton.setPrefHeight(20);
                Cuadrante cuadrante = new Cuadrante(i, mapa.getAlto() + 1 - j);
                SeleccionVacioHandler seleccionVacioHandler = new SeleccionVacioHandler(cuadrante);
                boton.setOnMouseClicked(seleccionVacioHandler);
                boton.setId(i + "," + (mapa.getAlto() + 1 - j));
                tableroView.add(boton, i - 1, j - 1);

            }
        }
    }

    public static boolean tengoAlgunaUnidadSeleccionada() {
        return (aldeanoSeleccionado == true || espadachinSeleccionada == true || armAsedioSeleccionada == true || arqueroSeleccionada == true || castilloSeleccionada == true);
    }

    public static void desSeleccionarUnidades() {
        cuartelSeleccionada = false;
        plazaSeleccionada = false;
        aldeanoSeleccionado = false;
        espadachinSeleccionada = false;
        armAsedioSeleccionada = false;
        arqueroSeleccionada = false;
        castilloSeleccionada = false;
    }

    public static void seleccionarAldeano(Aldeano unidad) {
        aldeano = unidad;
        aldeanoSeleccionado = true;
    }

    public static void seleccionarArquero(Arquero unidad) {
        arquero = unidad;
        arqueroSeleccionada = true;
    }

    public static void seleccionarEspadachin(Espadachin unidad) {
        espadachin = unidad;
        espadachinSeleccionada = true;
    }

    public static void seleccionarArmaAsedio(ArmaDeAsedio unidad) {
        armaDeAsedio = unidad;
        armAsedioSeleccionada = true;
    }

    public static void seleccionarPlaza(PlazaCentral unidad) {
        plaza = unidad;
        plazaSeleccionada = true;
    }

    public static void seleccionarCastillo(Castillo unidad) {
        castillo = unidad;
        castilloSeleccionada = true;
    }

    public static void seleccionarCuartel(Cuartel unidad) {
        cuartel = unidad;
        cuartelSeleccionada = true;
    }

    public static boolean tengoAldeanoSeleccionado() {
        return aldeanoSeleccionado;
    }

    public static boolean tengoArqueroSeleccionado() {
        return arqueroSeleccionada;
    }

    public static boolean tengoEspadachinSeleccionado() {
        return espadachinSeleccionada;
    }

    public static boolean tengoArmaAsedioSeleccionado() {
        return armAsedioSeleccionada;
    }

    public static boolean tengoCuartelSeleccionado() {
        return cuartelSeleccionada;
    }

    public static boolean tengoPlazaSeleccionado() {
        return plazaSeleccionada;
    }

    public static boolean tengoCastilloSeleccionado() {
        return castilloSeleccionada;
    }

    public static Castillo getCastilloSeleccionado() {
        if (castilloSeleccionada) {
            return castillo;
        }
        throw new NoHayUnidadSeleccionadaException();
    }

    public static ArmaDeAsedio getArmaDeAsedioSeleccionado() {
        if (armAsedioSeleccionada) {
            return armaDeAsedio;
        }
        throw new NoHayUnidadSeleccionadaException();
    }

    public static Espadachin getEspadachinSeleccionado() {
        if (espadachinSeleccionada) {
            return espadachin;
        }
        throw new NoHayUnidadSeleccionadaException();
    }

    public static Arquero getArqueroSeleccionado() {
        if (arqueroSeleccionada) {
            return arquero;
        }
        throw new NoHayUnidadSeleccionadaException();
    }

    public static PlazaCentral getPlazaSeleccionado() {
        if (plazaSeleccionada) {
            return plaza;
        }
        throw new NoHayUnidadSeleccionadaException();
    }

    public static Cuartel getCuartelSeleccionado() {
        if (cuartelSeleccionada) {
            return cuartel;
        }
        throw new NoHayUnidadSeleccionadaException();
    }

    public static Aldeano getAldeanoSeleccionado() {
        if (aldeanoSeleccionado) {
            return aldeano;
        }
        throw new NoHayUnidadSeleccionadaException();
    }
    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html

    public void ubicarAldeano(Aldeano aldeano, int x, int y, Color color) {

        Button botonAldeano = (Button) tableroView.getChildren().get((mapa.getAlto() * x - (y - 1)));
        botonAldeano.setText("A");
        botonAldeano.setStyle("-fx-background-color: LIGHTBLUE; -fx-border-color: " + color.getColor() + "; -fx-border-width: 1px;");
        SeleccionAldeanoHandler seleccionAldeanoHandler = new SeleccionAldeanoHandler(aldeano);
        botonAldeano.setOnMouseClicked(seleccionAldeanoHandler);
    }

    public void ubicarArquero(Arquero arquero, int x, int y, Color color) {
        Button botonArquero;
        botonArquero = (Button) tableroView.getChildren().get((mapa.getAlto() * x - (y - 1)));
        botonArquero.setText("A");
        botonArquero.setStyle("-fx-background-color: GREEN; -fx-border-color: " + color.getColor() + "; -fx-border-width: 1px;");
        SeleccionArqueroHandler seleccionArqueroHandler = new SeleccionArqueroHandler(arquero);
        botonArquero.setOnMouseClicked(seleccionArqueroHandler);
    }

    public void ubicarEspadachin(Espadachin espadachin, int x, int y, Color color) {
        Button botonEspadachin;
        botonEspadachin = (Button) tableroView.getChildren().get((mapa.getAlto() * x - (y - 1)));
        botonEspadachin.setText("E");
        botonEspadachin.setStyle("-fx-background-color: BROWN; -fx-border-color: " + color.getColor() + "; -fx-border-width: 1px;");
        SeleccionEspadachinHandler seleccionEspadachinHandler = new SeleccionEspadachinHandler(espadachin);
        botonEspadachin.setOnMouseClicked(seleccionEspadachinHandler);
    }

    public void ubicarCastillo(Castillo castillo, Color color) {
        Button botonCastillo;
        Posicion posicionReal = castillo.getPosicion();
        int x;
        int y;
        for (Cuadrante cuadrante : posicionReal.getCasilleros()) {
            x = cuadrante.getX();
            y = cuadrante.getY();
            botonCastillo = (Button) tableroView.getChildren().get((mapa.getAlto() * x - (y - 1)));
            botonCastillo.setText("C");
            botonCastillo.setStyle("-fx-background-color: #1E90FF; -fx-border-color: " + color.getColor() + "; -fx-border-width: 1px;");
            SeleccionCastilloHandler seleccionCastilloHandler = new SeleccionCastilloHandler(castillo);
            botonCastillo.setOnMouseClicked(seleccionCastilloHandler);
        }
    }

    public void ubicarPlaza(PlazaCentral plaza, Color color) {
        Button botonPlaza;
        Posicion posicionReal = plaza.getPosicion();
        int x;
        int y;
        for (Cuadrante cuadrante : posicionReal.getCasilleros()) {
            x = cuadrante.getX();
            y = cuadrante.getY();
            botonPlaza = (Button) tableroView.getChildren().get((mapa.getAlto() * x - (y - 1)));
            botonPlaza.setText("P");

            botonPlaza.setStyle("-fx-background-color: RED; -fx-border-color: " + color.getColor() + "; -fx-border-width: 1px;");
            SeleccionPlazaHandler seleccionPlazaHandler = new SeleccionPlazaHandler(plaza);
            botonPlaza.setOnMouseClicked(seleccionPlazaHandler);
        }
    }

    public void ubicarCuartel(Cuartel cuartel, Color color) {
        Button botonPlaza;
        Posicion posicionReal = cuartel.getPosicion();
        int x;
        int y;
        for (Cuadrante cuadrante : posicionReal.getCasilleros()) {
            x = cuadrante.getX();
            y = cuadrante.getY();
            botonPlaza = (Button) tableroView.getChildren().get((mapa.getAlto() * x - (y - 1)));
            ;
            botonPlaza.setText("C");

            botonPlaza.setStyle("-fx-background-color: YELLOW; -fx-border-color: " + color.getColor() + "; -fx-border-width: 1px;");
            SeleccionCuartelHandler seleccionCuartelHandler = new SeleccionCuartelHandler(cuartel);
            botonPlaza.setOnMouseClicked(seleccionCuartelHandler);
        }
    }


    public void finalizoJuego(Jugador playerWin) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de Partida");
        alert.setHeaderText(null);
        alert.setContentText("Victoria de " + playerWin.getNombre() + "!");
        ButtonType ok = alert.getButtonTypes().get(0);
        if (alert.showAndWait().get() == ok) {
            System.exit(0);
        }
    }
}
