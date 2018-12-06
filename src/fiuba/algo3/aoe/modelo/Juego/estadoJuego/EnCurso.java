package fiuba.algo3.aoe.modelo.Juego.estadoJuego;

import fiuba.algo3.aoe.modelo.Juego.Turno.Turno;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;

public class EnCurso implements Ijuego {


    @Override
    public void cambiarTurno(Turno turno) {
        turno.pasarTurno();

    }

    @Override
    public Jugador getGanador() {
        throw new JuegoEnCursoException();
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
