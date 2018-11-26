package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitarTropa;

public class EstadoMoviendoseTropa implements IEstadoUnidadMilitarTropa
{
    @Override
    public void pasarTurno(UnidadMilitar unidad) {

    }

    @Override
    public void mover(UnidadMilitarTropa unidad, Mapa mapa, Direccionable direccion) {

    }

    @Override
    public boolean estasDisponible() {
        return false;
    }
}
