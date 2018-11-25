package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;

public class JuegoAoE {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Mapa mapa;
    private Turno turno;

    public JuegoAoE(Jugador jugador1, Jugador jugador2) {

        jugadores.add(jugador1);
        jugadores.add(jugador2);

        turno = new Turno(jugadores, new ModoInicioRandom());

    }

    public boolean contieneJugadores() {

        if(jugadores.size() == 2) return true;
        return false;
    }

    public void inicializar(int anchoMapa, int altoMapa) {

        mapa = new Mapa(anchoMapa, altoMapa);

        Aldeano aldeano;
        Castillo castillo;
        PlazaCentral plazaCentral;

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        jugador1.sumarOro(275);
        jugador2.sumarOro(275);
        castillo = new Castillo();
        castillo.colocarEn(new Posicion(7,7));
        jugador1.agregarPieza(castillo);

        plazaCentral = new PlazaCentral();
        plazaCentral.colocarEn(new Posicion(3,3));
        jugador1.agregarPieza(plazaCentral);

        for(int i = 0; i<3; i++){
             aldeano= new Aldeano();
             aldeano.colocarEn(new Posicion(2 + i, 6));
             jugador1.agregarPieza(aldeano);

        }

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

    public Jugador jugadorActual() {
        return turno.getJugadorActual();
    }

    public void pasarJugada() {
        turno.pasarTurno();
    }
}
