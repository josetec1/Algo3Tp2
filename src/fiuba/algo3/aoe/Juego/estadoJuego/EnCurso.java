package fiuba.algo3.aoe.Juego.estadoJuego;

import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Jugadores.Jugador;

public class EnCurso implements Ijuego {


    @Override
    public void cambiarTurno(Turno turno) {
        turno.pasarTurno();

    }

    @Override
    public Jugador getGanador() {
        return null;
    }

    @Override
    public Jugador getJugadorActivo(Turno turno) {
        return turno.getJugadorActual();
    }

    @Override
    public Jugador getJugadorInactivo(Turno turno) {
        return turno.getJugadorInactivo();
    }

    @Override
    public boolean juegoTerminado() {
        return false;
    }
}
