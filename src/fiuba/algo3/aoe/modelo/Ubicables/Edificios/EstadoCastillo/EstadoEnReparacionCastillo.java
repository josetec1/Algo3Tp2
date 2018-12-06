package fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoCastillo;

import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable.EdificioEnReparacionException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

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
        return false;
    }

    @Override
    public void liberarAldeano() {
        this.aldeano.cambiarARecolectando ();
    }
}
