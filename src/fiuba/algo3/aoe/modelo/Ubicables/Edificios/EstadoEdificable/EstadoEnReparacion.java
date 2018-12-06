package fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoEnReparacion implements EstadoEdificioConstruible {
    private Aldeano aldeano;

    public EstadoEnReparacion(Aldeano aldeano){
        this.aldeano = aldeano;
    }

    public boolean puedoConstruir(){
        return false;
    }

    public boolean puedoReparar(){
        return false;
    }


    public void construir(EdificioConstruible edificio, Aldeano aldeano, Jugador jugador ){
        throw new EdificioYaConstruidoException ();
    }

    public void reparar(Edificio edificio,Aldeano aldeano){
        throw new EdificioEnReparacionException();
    }

    public void nuevoTurno (EdificioConstruible edificio,int curacion) {
        edificio.aumentarVida (curacion);
        if(edificio.getVidaActual () >=edificio.getVidaMaxima ()){
            this.liberarAldeano ();
        }
    }

    public boolean puedoCrearUnidad(){
        return false;
    }

    public void liberarAldeano(){
        this.aldeano.cambiarARecolectando ();
    }
}
