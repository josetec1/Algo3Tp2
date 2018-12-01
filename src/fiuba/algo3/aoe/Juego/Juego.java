package fiuba.algo3.aoe.Juego;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Juego.estadoJuego.EnCurso;
import fiuba.algo3.aoe.Juego.estadoJuego.Ijuego;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;
import java.util.Observable;

public class Juego extends Observable {

    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa mapa;
    private Turno turno;
    private Ijuego juego;

    public Juego(String jugador1, String jugador2, int anchoMapa, int altoMapa) {
                //chequear minimos
        this.inicializar(jugador1, jugador2,anchoMapa,altoMapa) ;


    }



    public void inicializar ( String jugador1, String jugador2, int anchoMapa, int altoMapa) {
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
        mapa.colocar(castillo,new Posicion(1,1));
        j1= new Jugador(jugador1,castillo);

        //agrego plaza central
        plazaCentral = new PlazaCentral();
        mapa.colocar(plazaCentral,new Posicion(5,1));


        //agrego aldeanos
        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            mapa.colocar(aldeano,new Posicion(7 + (i*3), (i*2+3)));
            aldeanos.add(aldeano);
        }
        j1.inicializar(plazaCentral,aldeanos);
        this.jugador1 = j1;
        jugadores.add (j1);

        //Inicializo jugador 2

        castillo = new Castillo();

        mapa.colocar(castillo,new Posicion (anchoMapa- 4, altoMapa - 4));
        j2= new Jugador(jugador2,castillo);

        plazaCentral = new PlazaCentral();
        mapa.colocar(plazaCentral,new Posicion(anchoMapa -7, altoMapa - 4));


        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            mapa.colocar(aldeano,new Posicion(anchoMapa - (10 + i), altoMapa -(4+i)));
            aldeanos.add(aldeano);

        }
        j2.inicializar(plazaCentral,aldeanos);
        this.jugador2=j2;
        jugadores.add (j2);


        this.mapa = mapa;
        this.turno = new Turno(jugadores, new ModoInicioRandom());
        this.juego = new EnCurso();


    }


    public void pasarJugada() {

        if (this.juego.juegoTerminado()) {      } //excepcion
        this.juego.cambiarTurno(this.turno);
        this.setChanged();
        this.notifyObservers();

    }

    public Jugador getJugadorActual() {
        return this.juego.getJugadorActivo(this.turno);
    }
    public Jugador getJugadorUno (){return this.jugador1;}
    public   Jugador getJugadorDos (){return this.jugador2;}
    public Mapa getMapa(){
        return mapa;
    }


}
