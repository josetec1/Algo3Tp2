package fiuba.algo3.aoe.Ubicables;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;

public interface Atacante {

    int getDanioGeneradoAUnidad();

    int getDanioGeneradoAEdificio();
    int getDistanciaAtaque();

    void atacar(Atacable objetivoEnemigo, Jugador miJugador,Jugador jugadorEnemigo, Mapa mapa);
    boolean puedoAtacar(Atacable objetivoEnemigo, Jugador miJugador,Jugador jugadorEnemigo, Mapa mapa);

}
