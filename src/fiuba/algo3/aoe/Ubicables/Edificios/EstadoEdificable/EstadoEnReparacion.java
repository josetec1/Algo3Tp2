package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruidoException;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

public class EstadoEnReparacion implements EstadoEdificio {
    private int cantidad;

    public EstadoEnReparacion(int unaCantidad){
        this.cantidad = unaCantidad;
    }

    public boolean enReparacion () {
        return true;
    }

    public boolean enConstruccion () {
        return false;
    }

    public void construir ( Edificio edificio, Aldeano aldeano ) {
        throw new EdificioConstruidoException();
    }

    public boolean puedoConstruirUnidad () {
        return false;
    }

    public void reparar ( Edificio edificio, Aldeano aldeano ) {
        edificio.aumentarVida(this.cantidad);
    }

}