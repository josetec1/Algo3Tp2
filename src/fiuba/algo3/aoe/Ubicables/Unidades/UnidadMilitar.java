package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;


public abstract class UnidadMilitar extends UnidadMovil implements Atacante {

  //
    protected int danioUnidad;
    protected int danioEdificio;
    protected int distanciaAtaque;

    public void atacar(Atacable receptorDelAtaque){

        if(this.posicion == null)
            throw new UnidadSinPosicionException();
        if(distanciaAtaque >= this.posicion.distancia(receptorDelAtaque.getPosicion()))
            receptorDelAtaque.serAtacadoPor(this);
        else
            throw new UnidadFueraDeRangoDeAtaqueException();
    }


    public int getDanioUnidad(){return danioUnidad;}

    public int getDanioEdificio() {return danioEdificio;}

    public int getDistanciaAtaque() { return distanciaAtaque;}
}
