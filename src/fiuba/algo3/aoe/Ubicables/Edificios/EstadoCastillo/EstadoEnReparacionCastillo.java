package fiuba.algo3.aoe.Ubicables.Edificios.EstadoCastillo;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EdificioEnReparacionException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoEnReparacionCastillo implements IEstadoCastillo {

    private Aldeano aldeano;

    public EstadoEnReparacionCastillo(Aldeano aldeano){
        this.aldeano = aldeano;
    }

    @Override
    public void nuevoTurno(Castillo castillo, int CURACION) {
        castillo.aumentarVida (CURACION);
        if(castillo.getVidaActual () >=castillo.getVidaMaxima ()){
            this.liberarAldeano ();
        }
    }

    @Override
    public boolean puedoReparar() {
        return false;
    }

    @Override
    public void reparar(Edificio edificio, Aldeano aldeano) {
        throw new EdificioEnReparacionException();
    }

    @Override
    public boolean puedoCrearUnidad() {
        return true;
    }

    @Override
    public void liberarAldeano() {
        this.aldeano.cambiarARecolectando ();
    }
}
