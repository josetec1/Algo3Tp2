package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
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


    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    public int getVidaActual(){
        return this.vidaActual;
    }
    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }

    public void serAtacadoPor(Atacante unAtacante) {
        this.disminuirVida(unAtacante.getDanioGeneradoAUnidad());
    }

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

    public Posicion obtenerPosicionDeAvance( Direccionable direccionable ){
        return this.getPosicion().calcularPosicionSiguiente(direccionable);
    }

    public abstract  void mover(Mapa mapa, Direccionable direccion, Jugador jugador);

    public void setCambio (){this.setChanged();} //esta la uso para que aplique el setChange del observarble pq no se puede desde afuera

    @Override
    public void eliminarMuerto(Jugador jugador, Jugador enemigo, Mapa mapa) {
            throw  new FaltaImplementarException();
    }
}