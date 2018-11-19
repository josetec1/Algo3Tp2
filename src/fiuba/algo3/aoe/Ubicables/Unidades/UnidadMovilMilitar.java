package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoUnidadMilitar;

public abstract class UnidadMovilMilitar extends UnidadMovil {
//Todo, esto hay que revisar que unidadMilitar cumpla el " es una unidadMovil"
    protected EstadoUnidadMilitar estadoUnidad;
    protected int danioUnidad;
    protected int danioEdificio;
    protected int distanciaAtaque;

    public void atacar(Atacable receptorDelAtaque){

        if(distanciaAtaque >= this.posicion.distancia(receptorDelAtaque.getPosicion()))
            receptorDelAtaque.serAtacadoPor(this);
        else
            throw new UnidadFueraDeRangoDeAtaqueException();
    }


    public int getDanioUnidad(){return danioUnidad;}

    public int getDanioEdificio() {return danioEdificio;}

    public int getDistanciaAtaque() { return distanciaAtaque;}
}
