package fiuba.algo3.aoe.Ubicables.Edificios.EstadoCastillo;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoNormalCastillo implements IEstadoCastillo {
    @Override
    public void nuevoTurno(Castillo castillo, int CURACION) {
        //no hacer nada
    }

    @Override
    public boolean puedoReparar() {
        return false;
    }

    @Override
    public void reparar(Edificio edificio, Aldeano aldeano) {
        throw new EdificioSinDaniarException();
    }

    @Override
    public boolean puedoCrearUnidad() {
        return true;
    }

    @Override
    public void liberarAldeano() {
        throw new CastilloNoEstaSiendoReparadoException();
    }
}
