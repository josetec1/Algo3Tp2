package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.UnidadYaRealizoMovimientoEsteTurnoException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitarTropa;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class EstadoLibreTropa implements IEstadoUnidadMilitarTropa {


    @Override
    public void pasarTurno(UnidadMilitar unidad) {
        //no hacer nada
    }

    @Override
    public void mover(UnidadMilitarTropa unidad, Mapa mapa, Direccionable direccion) {
        Posicion destino = unidad.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino,unidad.getTamanio())) {
            mapa.moverElemento(unidad, destino);
            unidad.setMoviendose();
            unidad.setCambio();
            unidad.notifyObservers(unidad);

        }
    }

    public void atacar(){}

    @Override
    public boolean estasDisponible() {
        return true;
    }
}
