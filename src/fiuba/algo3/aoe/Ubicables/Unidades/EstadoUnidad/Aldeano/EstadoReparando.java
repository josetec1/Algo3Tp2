package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

public class EstadoReparando implements EstadoUnidadAldeano {


    @Override
    public Edificio construir(Aldeano unAldeano, Edificio unEdificio) {
        return null; //TODO
    }

    @Override
    public Boolean puedoConstruirOReparar() {
        return false;
    }

    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unJugador){

    }
}