package fiuba.algo3.aoe.modelo.Juego;
import fiuba.algo3.aoe.modelo.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.modelo.Juego.Turno.Turno;
import fiuba.algo3.aoe.modelo.Juego.estadoJuego.EnCurso;
import fiuba.algo3.aoe.modelo.Juego.estadoJuego.Finalizado;
import fiuba.algo3.aoe.modelo.Juego.estadoJuego.Ijuego;

import fiuba.algo3.aoe.modelo.Juego.estadoJuego.JuegoFinalizadoException;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Jugadores.ObservadorCastillo;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;

import java.util.ArrayList;
import java.util.Observable;

public class Juego extends Observable implements ObservadorCastillo {

    private final int ANCHO_MINIMO=13;
    private final int ALTO_MINIMO=12;
    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa mapa;
    private Turno turno;
    private Ijuego juego;

    public Juego(String jugador1, String jugador2, int anchoMapa, int altoMapa) {

        if (anchoMapa<ANCHO_MINIMO || altoMapa<ALTO_MINIMO) {throw new TamanioJuegoInvalidoException();}
        this.inicializar(jugador1, jugador2,anchoMapa,altoMapa) ;
    }

    private void inicializar ( String jugador1, String jugador2, int anchoMapa, int altoMapa) {
        Mapa mapa= new Mapa(anchoMapa, altoMapa);

        //Variables auxiliares
        ArrayList<Jugador> jugadores= new ArrayList<>();
        ArrayList<Aldeano> aldeanos ;
        Aldeano aldeano;
        Castillo castillo;
        PlazaCentral plazaCentral;
        Jugador j1;
        Jugador j2;

        //Inicializo jugador 1
        castillo = new Castillo();
        mapa.colocar(castillo,new PosicionReal(1,1));
        castillo.agregarObservador(this);

        //agrego plaza central
        plazaCentral = new PlazaCentral();
        plazaCentral.finalizarConstruccion();
        mapa.colocar(plazaCentral,new PosicionReal(5,1));


        //agrego aldeanos
        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            mapa.colocar(aldeano,new PosicionReal(7 + (i*3), (i*2+3)));
            aldeanos.add(aldeano);
        }



        j1= new Jugador(jugador1,castillo, plazaCentral, aldeanos);
        this.jugador1 = j1;
        jugadores.add (j1);

        //Inicializo jugador 2
        castillo = new Castillo();
        castillo.agregarObservador(this);
        mapa.colocar(castillo,new PosicionReal(anchoMapa- 4, altoMapa - 4));


        plazaCentral = new PlazaCentral();
        plazaCentral.finalizarConstruccion();
        mapa.colocar(plazaCentral,new PosicionReal(anchoMapa -7, altoMapa - 4));


        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            mapa.colocar(aldeano,new PosicionReal(anchoMapa - (10 + i), altoMapa -(4+i)));
            aldeanos.add(aldeano);

        }

        j2= new Jugador(jugador2,castillo, plazaCentral,aldeanos);
        this.jugador2=j2;
        jugadores.add (j2);

        this.mapa = mapa;
        this.turno = new Turno(jugadores, new ModoInicioRandom());
        this.juego = new EnCurso();


    }

    public void pasarJugada() {

        if (this.juego.juegoTerminado()) { throw new JuegoFinalizadoException();}

        //1) paso turno y cada unidad del jugador activo hace lo que tiene que hacer
        this.juego.cambiarTurno(this.turno);

        //el castillo que ataque
        this.turno.getJugadorActual().getCastillo().atacarAlJugador(this.turno.getJugadorActual(),this.turno.getJugadorInactivo(),this.mapa);

        this.setChanged();
        this.notifyObservers();

    }

    public Jugador getJugadorActual() {
        return this.juego.getJugadorActivo(this.turno);
    }
    public Jugador getJugadorInactivo() {
        return this.juego.getJugadorInactivo(this.turno);
    }
    public Jugador getJugadorUno (){return this.jugador1;}  //TODO ELIMINAR
    public   Jugador getJugadorDos (){return this.jugador2;}//TODO ELIMINAR
    public Mapa getMapa(){
        return mapa;
    }


    public boolean finalizo(){
        return this.juego.juegoTerminado();
    }



    @Override
    public void castilloEliminado() {
        //aca me avisa el castillo que murio
        //tengo que cambiar a estado finalizado.
        this.juego= new Finalizado(this.getJugadorActual());

        //notificar a observadores.
        this.setChanged();
        this.notifyObservers();

    }

    public Jugador getWinner(){return this.juego.getGanador();}
}
