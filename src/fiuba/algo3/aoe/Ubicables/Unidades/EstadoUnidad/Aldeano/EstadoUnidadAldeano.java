package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.EstadoUnidad;

public interface
EstadoUnidadAldeano extends EstadoUnidad {

    Edificio construir (Aldeano unAldeano, Edificio unEdificio);

    Boolean puedoConstruirOReparar ();
}
