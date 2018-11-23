package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruidoException;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

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

    public void construir ( Edificio edificio, Aldeano aldeano ) {
        aldeano.cambiarAContruyendo();
        //pasar la referencia esta.
        //este comportamiento de aca abajo hay que sacarlo
        this.turnos -= 1;
        if (this.turnos == 0) {
            throw new EdificioConstruidoException();
        }

    }

    public boolean puedoConstruirUnidad(){
        return false;
    }

    public void reparar ( Edificio edificio, Aldeano aldeano ) {
        throw new EdificioEnConstruccionException();
    }
}
