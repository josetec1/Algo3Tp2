package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public  abstract class UnidadMovil  implements Manipulable {
    private final int TAMANIO = 1;

    private Posicion posicion;
    private int vidaMaxima;
    private int vidaActual;
    private int costo;
    private int tamanio;


    public UnidadMovil (Posicion posicion, int vidaMaxima, int costo){
        this.posicion = posicion;
        this.vidaMaxima= vidaMaxima;
        this.vidaActual=vidaMaxima;
        this.costo = costo;
        this.tamanio= TAMANIO;
    }


    public abstract  void mover(Mapa mapa, Direccionable direccion, Jugador jugador);
    public Posicion obtenerPosicionDeAvance(Direccionable direccionable ){
        return this.getPosicion().calcularPosicionSiguiente(direccionable);
    }

    /*******************************************************
    // Metodos de Atacable
    ******************************************************/

    public void serAtacadoPor(Atacante unAtacante, Jugador jugadorAtacante, Jugador miJugador,Mapa mapa) {
        if (jugadorAtacante.esMio(this)){throw new FuegoAmigoException();}
        this.disminuirVida(unAtacante.getDanioGeneradoAUnidad(),miJugador,mapa);
    }

    public void disminuirVida( int vida, Jugador miJugador, Mapa mapa ){
        this.vidaActual -= vida;
        if (this.vidaActual <= 0) {
            // me quito del mapa
            mapa.remover(this);
            // me saco de mi jugador
            miJugador.eliminarPieza(this);
        }
    }

    public int getVidaMaxima(){return this.vidaMaxima;}
    public int getVidaActual(){return this.vidaActual;}

    /*******************************************************
     // Metodos de Notificable
     ******************************************************/
    public abstract  void huboUnCambioDeTurno (Jugador jugador);

    /*******************************************************
     // Metodos de Ubicable
     ******************************************************/
    public int getTamanio(){
        return this.tamanio;
    }
    public int getCosto(){
        return this.costo;
    }
    public Posicion getPosicion() {
       return this.posicion;
    }
    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }
}