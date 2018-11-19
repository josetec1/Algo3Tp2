package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.AldeanoOcupadoException;

public class EstadoMoviendoseYRecolectando implements IEstadoUnidadAldeano {
    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unjugador) {
        aldeano.cambiarARecolectando();
    }

    @Override
    public Edificio construir(Aldeano unAldeano, Edificio unEdificio) {
        return null;
    }

    @Override
    public Boolean puedoConstruirOReparar() {
        return false;
    }

    @Override
    public void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion) {
        throw new AldeanoOcupadoException();
    }



    @Override
    public Boolean podesMoverte() {
        return false;
    }
}
