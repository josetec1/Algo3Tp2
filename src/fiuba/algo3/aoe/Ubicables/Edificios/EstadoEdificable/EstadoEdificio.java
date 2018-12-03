package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public interface EstadoEdificio {
     boolean puedoConstruir();
     boolean puedoReparar();
     void construir(Edificio edificio , Aldeano aldeano, Jugador jugador);
     void reparar( Edificio edificio , Aldeano aldeano );
     void nuevoTurno(Edificio edificio,int curacion);
     boolean puedoCrearUnidad();
     void liberarAldeano();

}
