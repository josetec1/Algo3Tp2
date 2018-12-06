package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;


public interface IEstadoUnidadAldeano {

    void pasarTurno (Aldeano unidad, Jugador unjugador);


    void construir (Aldeano unAldeano, EdificioConstruible unEdificio, Mapa mapa, PosicionReal posicionReal, Jugador jugador);


    void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion);


        boolean estasDisponible ();

    void reparar (Aldeano unidad, Edificio unEdificio);



}
