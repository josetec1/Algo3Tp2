package fiuba.algo3.aoe.Ubicables;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;


public interface Atacable  extends Ubicable{

    int getVidaActual();
    int getVidaMaxima(); // para que???

    void disminuirVida( int vida, Jugador miJugador, Mapa mapa );
    void serAtacadoPor(Atacante unAtacante,Jugador miJugador, Mapa mapa);



}
