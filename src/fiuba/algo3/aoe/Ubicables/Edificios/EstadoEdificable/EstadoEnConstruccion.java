package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruidoException;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;

public class EstadoEnConstruccion implements EstadoEdificio {

    private int turnos;

    public EstadoEnConstruccion ( int turnos ) {
        this.turnos = turnos;
    }


    public boolean enReparacion () {
        return false;
    }

    public boolean enConstruccion () {
        return true;
    }

    public void construir ( Edificio edificio ) {

        this.turnos -= 1;
        if (this.turnos == 0) {
            throw new EdificioConstruidoException();
        }
    }

    public boolean puedoConstruirUnidad(){
        return false;
    }

    public void reparar ( Edificio edificio ) {
        throw new EdificioEnConstruccionException();
    }
}
