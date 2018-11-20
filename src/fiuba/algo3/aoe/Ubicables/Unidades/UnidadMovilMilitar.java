package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.IEstadoUnidadMilitar;

public abstract class UnidadMovilMilitar extends UnidadMovil implements Atacante {
//Todo, esto hay que revisar que unidadMilitar cumpla el " es una unidadMovil"
    protected IEstadoUnidadMilitar estadoUnidad;
    protected int danioUnidad;
    protected int danioEdificio;
    protected int distanciaAtaque;

    public void atacar(Atacable receptorDelAtaque){

        if(this.posicion == null)
            throw new UnidadSinPosicionExceptcion();
        if(distanciaAtaque >= this.posicion.distancia(receptorDelAtaque.getPosicion()))
            receptorDelAtaque.serAtacadoPor(this);
        else
            throw new UnidadFueraDeRangoDeAtaqueException();
    }


    public int getDanioUnidad(){return danioUnidad;}

    public int getDanioEdificio() {return danioEdificio;}

    public int getDistanciaAtaque() { return distanciaAtaque;}
}
