package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;


public interface
EstadoUnidadAldeano  {

    void pasarTurno ( Aldeano unidad, Jugador unjugador);
    Edificio construir ( Aldeano unAldeano, Edificio unEdificio);

    Boolean puedoConstruirOReparar ();
}
