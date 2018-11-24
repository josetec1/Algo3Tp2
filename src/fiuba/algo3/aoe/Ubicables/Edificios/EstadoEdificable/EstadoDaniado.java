package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

public class EstadoDaniado implements EstadoEdificio {

    public boolean puedoConstruir(){
        return false;
    }

    public boolean puedoReparar(){
        return true;
    }


    public void construir( Edificio edificio, Aldeano aldeano ){
        throw new EdificioYaConstruidoException();
    }

    public void reparar(Edificio edificio,Aldeano aldeano){
        edificio.comenzarReparacion ( aldeano );
    }

    @Override
    public void nuevoTurno (Edificio edificio,int curacion) {

    }

    public boolean puedoCrearUnidad(){
        return true;
    }

    public void liberarAldeano(){
        throw new EdificioNoEstaSiendoConstruidoOReparadoException();
    }
}
