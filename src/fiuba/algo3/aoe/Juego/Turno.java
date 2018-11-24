package fiuba.algo3.aoe.Juego;
import fiuba.algo3.aoe.Jugadores.*;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;


import java.util.Iterator;
import java.util.List;

public class Turno {

    private List <Jugador> jugadores;
    private Jugador jugadorActual;
    private Iterator<Jugador> it;
    private final int JUGADORES_ADMITIDOS = 2;

    public Turno ( List <Jugador> unosJugadores , ModoInicio semilla) {


        if (unosJugadores.size() != JUGADORES_ADMITIDOS) throw new JugadoresInvalidosException();
        this.jugadores = unosJugadores;
        this.it = unosJugadores.iterator();

        this.inicializarTurno(semilla);

        //  this.jugadorActual.habilitar();


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
       // this.jugadorActual.habilitar();
     }


    public Jugador getJugadorActual () {  //Todo este metodo es necesario?
        return this.jugadorActual;
    }

}