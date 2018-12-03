package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public  abstract class UnidadMovil extends Observable implements Manipulable {
    private final int TAMANIO = 1;

    protected Posicion posicion; //TODO esto Privado y con metos protegidos se cambia.
    protected int vidaMaxima;
    protected int vidaActual;
    protected int costo;
    protected int tamanio = TAMANIO;
    protected ArrayList<Observer> observadores =new ArrayList<>();




    public abstract  void mover(Mapa mapa, Direccionable direccion, Jugador jugador);
    public Posicion obtenerPosicionDeAvance( Direccionable direccionable ){
        return this.getPosicion().calcularPosicionSiguiente(direccionable);
    }


    public void setCambio (){this.setChanged();} //esta la uso para que aplique el setChange del observarble pq no se puede desde afuera


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
    public  void eliminarSiEstasMuerto (Jugador jugador){throw  new FaltaImplementarException();}

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
        if (this.posicion==null){throw new UnidadSinPosicionException();}
        return this.posicion;
    }
    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }
}