package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

public interface EstadoEdificio {
     boolean puedoConstruir();
     boolean puedoReparar();
     void construir( Edificio edificio , Aldeano aldeano );
     void reparar( Edificio edificio , Aldeano aldeano );
     void nuevoTurno(Edificio edificio,int curacion);
     boolean puedoCrearUnidad();
     void liberarAldeano();

}
