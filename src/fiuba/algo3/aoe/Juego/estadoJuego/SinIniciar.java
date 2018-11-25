package fiuba.algo3.aoe.Juego.estadoJuego;

import fiuba.algo3.aoe.Juego.JuegoAOE;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;

public class SinIniciar implements Ijuego {
    @Override
    public void iniciar(String jugador1, String jugador2, int anchoMapa, int altoMapa, JuegoAOE juego) {

        Mapa mapa= new Mapa(anchoMapa, altoMapa);
        ArrayList<Jugador>jugadores = new ArrayList<>();

        //Variables auxiliares
        ArrayList<Aldeano> aldeanos ;
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

        //agrego aldeanos
        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            aldeano.colocarEn(new Posicion(2 + i, 6));
            aldeanos.add(aldeano);
        }
        j1.inicializar(plazaCentral,aldeanos);
        jugadores.add(j1);

        //Inicializo jugador 2

        castillo = new Castillo();
        castillo.colocarEn(new Posicion (anchoMapa- 6, altoMapa - 6));
        j2= new Jugador(jugador2,castillo);

        plazaCentral = new PlazaCentral();
        plazaCentral.colocarEn(new Posicion(anchoMapa -2, altoMapa - 2));

        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            aldeano.colocarEn(new Posicion(anchoMapa - (2 + i), altoMapa -6));
            aldeanos.add(aldeano);

        }
        j2.inicializar(plazaCentral,aldeanos);
        jugadores.add(j2);

        juego.inicializarCon(jugadores,mapa);


    }

    @Override
    public void cambiarTurno() {
        throw new JuegoNoIniciadoException();
    }

    @Override
    public Jugador getGanador() {
        return null;
    }

    @Override
    public Jugador getJugadorActivo() {
        return null;
    }
}
