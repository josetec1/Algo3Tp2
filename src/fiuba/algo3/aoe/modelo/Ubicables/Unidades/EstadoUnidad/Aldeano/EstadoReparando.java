package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.AldeanoOcupadoException;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;

public class EstadoReparando implements IEstadoUnidadAldeano {


        public EstadoReparando(Aldeano aldeano, Edificio unEdificio){
            unEdificio.comenzarReparacion(aldeano);

        }

    @Override
    public void construir(Aldeano unAldeano, EdificioConstruible unEdificio, Mapa mapa, PosicionReal posicionReal, Jugador jugador) {
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


    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unJugador){
        //no hacer nada lo libera el edificio
    }
}
