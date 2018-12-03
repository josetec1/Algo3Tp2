package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;


public abstract class UnidadMilitar extends UnidadMovil implements Atacante {

    private int danioGeneradoAUnidad;
    private int danioGeneradoAEdificio;
    private int distanciaAtaque;

    public UnidadMilitar(Posicion posicion, int vidaMaxima, int costo, int danioUnidad, int danioEdificio, int distanciaAtaque) {
        super(posicion, vidaMaxima, costo);
        this.danioGeneradoAEdificio= danioEdificio;
        this.danioGeneradoAUnidad= danioUnidad;
        this.distanciaAtaque = distanciaAtaque;
    }

    /*******************************************************
     // Metodos de Atacante
     ******************************************************/
    public int getDanioGeneradoAUnidad(){return danioGeneradoAUnidad;}
    public int getDanioGeneradoAEdificio() {return danioGeneradoAEdificio;}
    public int getDistanciaAtaque() { return distanciaAtaque;}
    public abstract void atacar(Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa);

}
