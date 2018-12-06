package fiuba.algo3.aoe.modelo.Juego.estadoJuego;

import fiuba.algo3.aoe.modelo.Juego.Turno.Turno;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;

public interface Ijuego {


    void cambiarTurno(Turno turno);
    Jugador getGanador();
    boolean juegoTerminado();

}
