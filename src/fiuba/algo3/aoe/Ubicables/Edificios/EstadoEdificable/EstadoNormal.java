package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;

public class EstadoNormal implements EstadoEdificioConstruible {
    public boolean puedoConstruir(){
        return false;
    }

    public boolean puedoReparar(){
        return false;
    }


    public void construir( EdificioConstruible edificio, Aldeano aldeano, Jugador jugador ){
        throw new EdificioYaConstruidoException();
    }

    public void reparar(Edificio edificio,Aldeano aldeano){
        throw new EdificioSinDaniarException();
    }

    @Override
    public void nuevoTurno (EdificioConstruible edificio, int curacion) {
            //no hacer nada
    }

    public boolean puedoCrearUnidad(){
        return true;
    }

    public void liberarAldeano(){
        throw new EdificioNoEstaSiendoConstruidoOReparadoException();
    }
}
