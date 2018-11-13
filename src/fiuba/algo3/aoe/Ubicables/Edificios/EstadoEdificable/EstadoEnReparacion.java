package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruidoException;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;

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

    public void construir ( Edificio edificio ) {
        throw new EdificioConstruidoException();
    }

    public void reparar ( Edificio edificio ) {
        edificio.aumentarVida(this.cantidad);
    }

}