package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.IEstadoMaquinariaMilitar;

public class UnidadMilitarMaquinaria extends UnidadMilitar {

    protected IEstadoMaquinariaMilitar estado;

    @Override
    public void mover(Mapa mapa, Direccionable direccion) {

    }

    @Override
    public boolean estasDisponible() {
        return false;
    }

    @Override
    public void huboUnCambioDeTurno(Jugador jugador) {

    }
}
