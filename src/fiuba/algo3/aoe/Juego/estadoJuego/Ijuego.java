package fiuba.algo3.aoe.Juego.estadoJuego;

import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Jugadores.Jugador;

public interface Ijuego {


    void cambiarTurno(Turno turno);
    Jugador getGanador();
    Jugador getJugadorActivo(Turno turno);
    Jugador getJugadorInactivo(Turno turno);
    boolean juegoTerminado();

}
