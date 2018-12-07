package fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoCastillo;

import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoDaniadoCastillo implements EstadoCastillo {
    @Override
    public void nuevoTurno(Castillo castillo, int CURACION) {
        //no hacer nada
    }

    @Override
    public boolean puedoReparar() {
        return true;
    }

    @Override
    public void reparar(Edificio edificio, Aldeano aldeano) {
        edificio.comenzarReparacion ( aldeano );
    }

    @Override
    public boolean puedoCrearUnidad() {
        return false;
    }

    @Override
    public void liberarAldeano() {
        //no hacer nada
    }
}
