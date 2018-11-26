package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.IEstadoUnidadMilitarTropa;

public class UnidadMilitarTropa extends UnidadMilitar{

    protected IEstadoUnidadMilitarTropa estado;

    @Override
    public void mover(Mapa mapa, Direccionable direccion) {

    }

    public boolean estasDisponible() {
        return false;
    }

    @Override
    public void huboUnCambioDeTurno(Jugador jugador) {

    }
}
