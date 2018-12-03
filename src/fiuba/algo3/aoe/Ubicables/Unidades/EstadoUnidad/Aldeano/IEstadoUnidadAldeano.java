package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;


public interface IEstadoUnidadAldeano {

    void pasarTurno (Aldeano unidad, Jugador unjugador);


    void construir (Aldeano unAldeano, Edificio unEdificio, Mapa mapa, PosicionReal posicionReal, Jugador jugador);


    void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion);


        boolean estasDisponible ();

    void reparar (Aldeano unidad, Edificio unEdificio);



}
