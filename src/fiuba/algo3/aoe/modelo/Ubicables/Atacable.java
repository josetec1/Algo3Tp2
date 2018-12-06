package fiuba.algo3.aoe.modelo.Ubicables;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;


public interface Atacable  extends Ubicable{

    int getVidaActual();
    int getVidaMaxima();

    void disminuirVida( int vida, Jugador miJugador, Mapa mapa );
    void serAtacadoPor(Atacante unAtacante,Jugador miJugador, Mapa mapa);



}
