package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoEnReparacion implements EstadoEdificio {
    private Aldeano aldeano;

    public EstadoEnReparacion( Aldeano aldeano){
        this.aldeano = aldeano;
    }

    public boolean puedoConstruir(){
        return false;
    }

    public boolean puedoReparar(){
        return false;
    }


    public void construir( Edificio edificio, Aldeano aldeano, Jugador jugador ){
        throw new EdificioYaConstruidoException ();
    }

    public void reparar(Edificio edificio,Aldeano aldeano){
        throw new EdificioEnReparacionException();
    }

    public void nuevoTurno (Edificio edificio,int curacion) {
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
