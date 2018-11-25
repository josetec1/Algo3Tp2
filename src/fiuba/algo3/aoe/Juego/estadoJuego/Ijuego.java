package fiuba.algo3.aoe.Juego.estadoJuego;

import fiuba.algo3.aoe.Juego.JuegoAOE;
import fiuba.algo3.aoe.Jugadores.Jugador;

public interface Ijuego {

    void iniciar(String jugador1, String jugador2, int anchoMapa, int altoMapa, JuegoAOE juego);
    void cambiarTurno();
    Jugador getGanador();
    Jugador getJugadorActivo();

}
