package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;

public interface EstadoEdificio {

    boolean enConstruccion();

    boolean enReparacion();

    void construir( Edificio edificio);

    void reparar (Edificio edificio);

    boolean puedoConstruirUnidad();
}
