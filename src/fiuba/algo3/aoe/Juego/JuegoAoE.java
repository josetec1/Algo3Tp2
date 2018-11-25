package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Juego.estadoJuego.Ipartida;
import fiuba.algo3.aoe.Juego.estadoJuego.SinIniciar;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;

public class JuegoAoE {
/*
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Mapa mapa;
    private Turno turno;
    private Ipartida partida;

    public JuegoAoE() {
        this.partida= new SinIniciar();
    }



    public void inicializar(String jugador1, String jugador2, int anchoMapa, int altoMapa) {

        mapa = new Mapa(anchoMapa, altoMapa);

        //Variables auxiliares
        Aldeano aldeano;
        Castillo castillo;
        PlazaCentral plazaCentral;
        Jugador j1;
        Jugador j2;

        //Inicializo jugador 1
        castillo = new Castillo();
        castillo.colocarEn(new Posicion(7,7));
        j1= new Jugador(jugador1,castillo);
        //agrego plaza central
        plazaCentral = new PlazaCentral();
        plazaCentral.colocarEn(new Posicion(3,3));
        j1.agregarPieza(plazaCentral);
        //agrego aldeanos
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            aldeano.colocarEn(new Posicion(2 + i, 6));
            j1.agregarPieza(aldeano);
        }

        this.jugadores.add(j1);








        this.jugadores.add(jugador2);
        this.turno = new Turno(jugadores, new ModoInicioRandom());











        castillo = new Castillo();
        castillo.colocarEn(new Posicion (anchoMapa- 6, altoMapa - 6));
        jugador2.agregarPieza(castillo);

        plazaCentral = new PlazaCentral();
        plazaCentral.colocarEn(new Posicion(anchoMapa -2, altoMapa - 2));
        jugador2.agregarPieza(plazaCentral);

        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            aldeano.colocarEn(new Posicion(anchoMapa - (2 + i), altoMapa -6));
            jugador2.agregarPieza(aldeano);

        }

    }

    public Jugador getJugadorActivo() {
        return turno.getJugadorActual();
    }

    public void pasarJugada() {

        turno.pasarTurno();
    }*/
}
