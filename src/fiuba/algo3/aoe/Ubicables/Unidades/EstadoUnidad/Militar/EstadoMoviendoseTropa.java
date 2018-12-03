package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.UnidadYaRealizoMovimientoEsteTurnoException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadMilitarTropa;

public class EstadoMoviendoseTropa implements IEstadoUnidadMilitarTropa
{
    @Override
    public void pasarTurno(UnidadMilitar unidad) {

    }

    @Override
    public void mover(UnidadMilitarTropa unidad, Mapa mapa, Direccionable direccion) {
        throw new UnidadYaRealizoMovimientoEsteTurnoException ();

    }

    public void atacar(){throw new UnidadYaRealizoMovimientoEsteTurnoException ();}

    @Override
    public boolean estasDisponible() {
        return false;
    }
}
