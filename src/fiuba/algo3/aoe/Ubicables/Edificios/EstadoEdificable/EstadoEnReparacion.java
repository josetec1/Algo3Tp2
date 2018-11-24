package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

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


    public void construir( Edificio edificio, Aldeano aldeano ){
        throw new EdificioEnConstruccionException();
    }

    public void reparar(Edificio edificio,Aldeano aldeano){
        throw new EdificioEnReparacionException();
    }

    public void nuevoTurno (Edificio edificio,int curacion) {
        edificio.aumentarVida (curacion);
    }

    public boolean puedoCrearUnidad(){
        return false;
    }
}
