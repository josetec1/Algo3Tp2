package fiuba.algo3.aoe.Juego.estadoJuego;

import fiuba.algo3.aoe.Jugadores.Jugador;

public class SinIniciar implements Ipartida{
    @Override
    public void iniciar(String jugador1, String jugador2, int anchoMapa, int altoMapa) {

    }

    @Override
    public void cambiarTurno() {

    }

    @Override
    public Jugador getGanador() {
        return null;
    }

    @Override
    public Jugador getJugadorActivo() {
        return null;
    }
}
