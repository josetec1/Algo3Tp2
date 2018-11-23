package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

public interface EstadoEdificio {

    boolean enConstruccion();

    boolean enReparacion();

    void construir( Edificio edificio, Aldeano aldeano);

    void reparar (Edificio edificio, Aldeano aldeano);

    boolean puedoConstruirUnidad();
}
