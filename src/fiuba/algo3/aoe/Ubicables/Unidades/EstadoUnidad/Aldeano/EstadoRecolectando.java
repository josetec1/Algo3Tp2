package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;

public class EstadoRecolectando implements EstadoUnidadAldeano {


    @Override
    public Edificio construir(Aldeano unAldeano, Edificio unEdificio) {
        unEdificio.construir();
        unAldeano.cambiarAContruyendo();
        return unEdificio;


    }

    @Override
    public Boolean puedoConstruirOReparar() {
        return true;
    }

    @Override
    public void pasarTurno(UnidadMovil unidad) {
            //Todo polemico
        // este tipo suma 20 de oro.
        ((Aldeano)unidad).entregarElOro();
    }
}
