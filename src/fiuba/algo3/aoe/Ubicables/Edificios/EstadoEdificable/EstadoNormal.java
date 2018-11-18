package fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable;

import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruidoException;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;

public class EstadoNormal implements EstadoEdificio {

    public boolean enConstruccion(){
        return false;
    }

    public boolean enReparacion(){
        return false;
    }

    public void reparar( Edificio edificio){
        throw new EdificioSinDaniarException();
    }

    public  void construir(Edificio edificio){
        throw new EdificioConstruidoException();
    }

    public boolean puedoConstruirUnidad(){
        return true;
    }
}
