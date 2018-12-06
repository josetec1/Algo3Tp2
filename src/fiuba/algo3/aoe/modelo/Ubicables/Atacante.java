package fiuba.algo3.aoe.modelo.Ubicables;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;

public interface Atacante {

    int getDanioGeneradoAUnidad();

    int getDanioGeneradoAEdificio();
    int getDistanciaAtaque();

    void atacar(Atacable objetivoEnemigo, Jugador miJugador,Jugador jugadorEnemigo, Mapa mapa);
    boolean puedoAtacar(Atacable objetivoEnemigo, Jugador miJugador,Jugador jugadorEnemigo, Mapa mapa);

}
