package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar;


import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadMilitarTropa;

public interface IEstadoUnidadMilitarTropa {

    void pasarTurno (UnidadMilitar unidad);

    void mover(UnidadMilitarTropa unidad, Mapa mapa, Direccionable direccion);

    void atacar();

    boolean estasDisponible ();
}
