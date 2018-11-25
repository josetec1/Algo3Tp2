package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Juego.estadoJuego.EnCurso;
import fiuba.algo3.aoe.Juego.estadoJuego.Ijuego;
import fiuba.algo3.aoe.Juego.estadoJuego.SinIniciar;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;

import java.util.ArrayList;

public class JuegoAOE {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Mapa mapa;
    private Turno turno;
    private Ijuego juego;

    public JuegoAOE() {
        this.juego= new SinIniciar();
    }



    public void empezar (String jugador1, String jugador2, int anchoMapa, int altoMapa ) {

        this.juego.iniciar(jugador1, jugador2,anchoMapa,altoMapa, this) ;

    }

    //NO USAR ESTE METO DESDE AFUERA
    public void inicializarCon (ArrayList<Jugador> jugadores, Mapa mapa){
        this.mapa = mapa;
        this.jugadores = jugadores;
        this.turno = new Turno(jugadores, new ModoInicioRandom());
        this.juego = new EnCurso();
    }

    public Jugador getJugadorActivo() {
        return turno.getJugadorActual();
    }

    public void pasarJugada() {
        this.juego.cambiarTurno();

    }
}
