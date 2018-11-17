package fiuba.algo3.aoe.Juego;
import fiuba.algo3.aoe.Jugadores.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import fiuba.algo3.aoe.Juego.*;

public class Turno {
  //  private int numeroDeTurno;  //TODO es necesario este atributo?
    private List <Jugador> jugadores;
    private Jugador jugadorActual;
    private Iterator<Jugador> it;
    private final int JUGADORES_ADMITIDOS = 2;

    //TODO hay que implementar para que arranque con un jugador al azar.  new turno (semilla)
     // con que turno arrancar le diria desde afuera, sino va a ser dificil hacer un test que compruebe que arranca al azar
    public Turno ( List <Jugador> unosJugadores ) {
      //  this.numeroDeTurno = 1;

        if (unosJugadores.size() != JUGADORES_ADMITIDOS) throw new JugadoresInvalidosException();
        this.jugadores = unosJugadores;
        this.it = unosJugadores.iterator();
        this.jugadorActual = it.next();

    }

    public void pasarTurno () {


       // this.numeroDeTurno += 1;
        if (!this.it.hasNext()) {this.it = jugadores.iterator();}
        this.jugadorActual= this.it.next();
       this.jugadorActual.setActivo();
     }


    public Jugador getJugadorActual () {
        return this.jugadorActual;
    }
/*
    public int getNumeroDeTurno () {
        return this.numeroDeTurno;
    }
*/
}