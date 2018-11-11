package fiuba.algo3.aoe.Juego;
import fiuba.algo3.aoe.Jugadores.*;

import java.util.ArrayList;
import java.util.List;
import fiuba.algo3.aoe.Juego.*;

public class Turno {
    private int numeroDeTurno;
    private List <Jugador> jugadores = new ArrayList <Jugador>();
    private Jugador jugadorActual;

    public Turno ( List <Jugador> unosJugadores ) {
        this.numeroDeTurno = 1;
        if (unosJugadores.isEmpty() || unosJugadores.size() == 1) throw new JugadoresInvalidosException();
        this.jugadores = unosJugadores;
        this.jugadorActual = this.jugadores.get(0);
    }

    public void pasarTurno () {
        this.numeroDeTurno += 1;
        int indiceDeJugador = this.jugadores.indexOf(this.jugadorActual);

        if (indiceDeJugador == (this.jugadores.size() - 1)) {
            this.jugadorActual = this.jugadores.get(0);
        } else
            this.jugadorActual = this.jugadores.get(indiceDeJugador + 1);
    }

    public Jugador getJugadorActual () {
        return this.jugadorActual;
    }

    public int getNumeroDeTurno () {
        return this.numeroDeTurno;
    }

}