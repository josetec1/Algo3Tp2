package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoDaniado implements EstadoEdificio {

    public boolean puedoConstruir(){
        return false;
    }

    public boolean puedoReparar(){
        return true;
    }


    public void construir(Edificio edificio, Aldeano aldeano, Jugador jugador){
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
