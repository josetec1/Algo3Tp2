package fiuba.algo3.aoe.Juego.Turno;
import fiuba.algo3.aoe.Juego.JugadoresInvalidosException;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicio;
import fiuba.algo3.aoe.Jugadores.*;


import java.util.Iterator;
import java.util.List;

public class Turno {

    private List <Jugador> jugadores;
    private Jugador jugadorActual;
    private Iterator<Jugador> it;
    private final int JUGADORES_ADMITIDOS = 2;


    public Turno ( List <Jugador> unosJugadores , ModoInicio semilla) {

        if (unosJugadores.size() != JUGADORES_ADMITIDOS) throw new JugadoresInvalidosException();
        if (unosJugadores.get(0) == unosJugadores.get(1))throw new JugadoresInvalidosException();
        this.jugadores = unosJugadores;
        this.it = unosJugadores.iterator();
        this.inicializarTurno(semilla);
    }

    private void inicializarTurno(ModoInicio semilla){
        this.jugadorActual = this.it.next();
        for (int i = 0; i < (semilla.getOrden()); i++) {
            if (!this.it.hasNext()) {this.it = jugadores.iterator();}
            this.jugadorActual= this.it.next();
        }
    }

    public void pasarTurno () {
        if (!this.it.hasNext()) {this.it = jugadores.iterator();}
     //   this.jugadorActual.deshabilitar();
        this.jugadorActual= this.it.next();
       this.jugadorActual.esTuTurno();
     }

    public Jugador getJugadorActual () {
        return this.jugadorActual;
    }

}