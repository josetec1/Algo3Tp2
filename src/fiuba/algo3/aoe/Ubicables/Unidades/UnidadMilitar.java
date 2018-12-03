package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;


public abstract class UnidadMilitar extends UnidadMovil implements Atacante {


    protected int danioGeneradoAUnidad;
    protected int danioGeneradoAEdificio;
    protected int distanciaAtaque;




    public int getDanioGeneradoAUnidad(){return danioGeneradoAUnidad;}

    public int getDanioGeneradoAEdificio() {return danioGeneradoAEdificio;}

    public int getDistanciaAtaque() { return distanciaAtaque;}



}
