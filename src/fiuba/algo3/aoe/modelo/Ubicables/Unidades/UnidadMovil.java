package fiuba.algo3.aoe.modelo.Ubicables.Unidades;


import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Jugadores.Manipulable;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacante;
import fiuba.algo3.aoe.modelo.Ubicables.Costeable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;

public  abstract class UnidadMovil  implements Manipulable, Costeable {
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

    public void serAtacadoPor(Atacante unAtacante,Jugador miJugador,Mapa mapa) {

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

    public Posicion getPosicion() {
       return this.posicion;
    }
    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    /*******************************************************
     // Metodos de Costeable
     ******************************************************/
    public int getCosto(){
        return this.costo;
    }
}