package fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoDaniado implements EstadoEdificioConstruible {

    public boolean puedoConstruir() {
        return false;
    }

    public boolean puedoReparar() {
        return true;
    }


    public void construir(EdificioConstruible edificio, Aldeano aldeano, Jugador jugador) {
        throw new EdificioYaConstruidoException();
    }

    public void reparar(Edificio edificio, Aldeano aldeano) {
        edificio.comenzarReparacion(aldeano);
    }

    @Override
    public void nuevoTurno(EdificioConstruible edificio, int curacion) {
        //no hacer nada
    }

    public boolean puedoCrearUnidad() {
        return false;
    }

    public void liberarAldeano() {
        throw new EdificioNoEstaSiendoConstruidoOReparadoException();
    }

}
