package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;


public interface
EstadoUnidadAldeano  {

    void pasarTurno (Aldeano unidad);
    Edificio construir (Aldeano unAldeano, Edificio unEdificio);

    Boolean puedoConstruirOReparar ();
}
