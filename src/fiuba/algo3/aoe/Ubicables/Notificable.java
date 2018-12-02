package fiuba.algo3.aoe.Ubicables;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;

public interface Notificable {

     void huboUnCambioDeTurno (Jugador jugador);
     void eliminarMuerto (Jugador jugador, Jugador enemigo, Mapa mapa);
}
