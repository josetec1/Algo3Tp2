package fiuba.algo3.aoe.modelo.Ubicables.Edificios;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Jugadores.Manipulable;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacante;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;

public abstract class Edificio implements Manipulable {

    private int vidaMaxima;
    private int vidaActual;
    private Posicion posicion;
    private int tamanio;

    public Edificio (int vidaMaxima,Posicion posicion, int tamanio) {
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.posicion = posicion;
        this.tamanio = tamanio;
    }

    protected void setVida (int vida) {this.vidaActual= vida;}

    public abstract  void aumentarVida ( int unaCantidad );

    public abstract void comenzarReparacion(Aldeano aldeano);
    public abstract boolean puedoReparar();
    public abstract void reparar(Aldeano aldeano);
    public abstract boolean puedocrearUnidad();

    /*******************************************************
    // Metodos de Ubicable
    ******************************************************/
    public int getTamanio () {
    return this.tamanio;
}
    public void colocarEn (Posicion posicion) {
        this.posicion = posicion;
    }
    public Posicion getPosicion () {
        return this.posicion;
    }

    /*******************************************************
     // Metodos de Atable
     ******************************************************/
    @Override
    public abstract void disminuirVida(int vida, Jugador miJugador, Mapa mapa);
    @Override
    public int getVidaMaxima () {
        return this.vidaMaxima;
    }
    @Override
    public int getVidaActual () {
        return this.vidaActual;
    }
    @Override
    public void serAtacadoPor(Atacante unAtacante,Jugador miJugador,Mapa mapa) {

        this.disminuirVida(unAtacante.getDanioGeneradoAEdificio(),miJugador,mapa);
    }

}
