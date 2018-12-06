package fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

public interface EstadoEdificioConstruible {
     boolean puedoConstruir();
     boolean puedoReparar();
     void construir(EdificioConstruible edificio , Aldeano aldeano, Jugador jugador);
     void reparar( Edificio edificio , Aldeano aldeano );
     void nuevoTurno(EdificioConstruible edificio,int curacion);
     boolean puedoCrearUnidad();
     void liberarAldeano();

}
