package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.AldeanoOcupadoException;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class EstadoMoviendoseYRecolectando implements IEstadoUnidadAldeano {
    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unjugador) {
        aldeano.cambiarARecolectando();
    }

    @Override
    public void construir(Aldeano unAldeano, Edificio unEdificio, Mapa mapa, Posicion posicion, Jugador jugador) {
        throw new AldeanoOcupadoException();
    }

    @Override
    public void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion) {
        throw new AldeanoOcupadoException();
    }

    @Override
    public boolean estasDisponible() {
        return false;
    }

    @Override
    public void reparar(Aldeano unidad, Edificio unEdificio) {
        throw new AldeanoOcupadoException();
    }
}
