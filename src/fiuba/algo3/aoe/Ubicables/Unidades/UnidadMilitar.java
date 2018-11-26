package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacante;


public abstract class UnidadMilitar extends UnidadMovil implements Atacante {

  //
    protected int danioGeneradoAUnidad;
    protected int danioGeneradoAEdificio;
    protected int distanciaAtaque;

    public void atacar(Manipulable receptorDelAtaque, Jugador jugadorAtacante, Jugador jugadorEnemigo, Mapa mapa){

        if(!jugadorAtacante.esMio(this))
            throw new NoEsMiJugadorException(); // TODO reever esta excepcion

        if(!jugadorEnemigo.esMio(receptorDelAtaque))
            throw new NoEsMiJugadorException(); // TODO reveer esta excepcion

        if(this.posicion == null)
            throw new UnidadSinPosicionException();

        if(distanciaAtaque >= this.posicion.distancia(receptorDelAtaque.getPosicion()))
            receptorDelAtaque.serAtacadoPor(this);
        else
            throw new UnidadFueraDeRangoDeAtaqueException();

        if(receptorDelAtaque.getVidaActual() == 0){
            mapa.remover(receptorDelAtaque);
            jugadorEnemigo.eliminarPieza(receptorDelAtaque);
        }
    }


    public int getDanioGeneradoAUnidad(){return danioGeneradoAUnidad;}

    public int getDanioGeneradoAEdificio() {return danioGeneradoAEdificio;}

    public int getDistanciaAtaque() { return distanciaAtaque;}
}
