package fiuba.algo3.aoe.modelo.Juego.estadoJuego;

import fiuba.algo3.aoe.modelo.Juego.Turno.Turno;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;

public class Finalizado  implements Ijuego{

    private Jugador win;

    public Finalizado (Jugador win){

        this.win = win;

    }
    @Override
    public void cambiarTurno(Turno turno) {
        throw new JuegoFinalizadoException();
    }

    @Override
    public Jugador getGanador() {
        return this.win;
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
        return true;
    }
}
