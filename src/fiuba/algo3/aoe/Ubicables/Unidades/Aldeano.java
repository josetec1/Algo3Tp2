package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Aldeano extends UnidadMovil {

    boolean ocupado = false;

    public Aldeano( Jugador jugador ){
        this.vidaMaxima = 50;
        this.vidaActual = 50;
        this.costo = 25;
        this.jugador = jugador;
        jugador.agregarUnidad(this);
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){return this.vidaActual;}

    public void mover(Mapa mapa, Direccionable direccion){
    Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino)){
            mapa.moverElemento(this,destino);
        }
    }

    @Override
    public boolean esAldeanoDesocupado() {
        return !ocupado;
    }

    public void disminuirVida( int vida){
        this.vidaActual-= vida;
    }

    public void construirCastillo(Posicion posicion) {
        new Castillo(this.jugador);
    }
}
