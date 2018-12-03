package fiuba.algo3.aoe.Ubicables.Edificios.EstadoCastillo;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoNormalCastillo implements IEstadoCastillo {
    @Override
    public void nuevoTurno(Castillo castillo, int CURACION) {

    }

    @Override
    public boolean puedoReparar() {
        return false;
    }

    @Override
    public void reparar(Edificio edificio, Aldeano aldeano) {

    }

    @Override
    public boolean puedoCrearUnidad() {
        return false;
    }

    @Override
    public void liberarAldeano() {

    }
}
