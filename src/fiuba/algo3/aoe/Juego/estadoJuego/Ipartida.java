package fiuba.algo3.aoe.Juego.estadoJuego;

import fiuba.algo3.aoe.Jugadores.Jugador;

public interface Ipartida {

    void iniciar(String jugador1, String jugador2, int anchoMapa, int altoMapa);
    void cambiarTurno();
    Jugador getGanador();
    Jugador getJugadorActivo();

}
