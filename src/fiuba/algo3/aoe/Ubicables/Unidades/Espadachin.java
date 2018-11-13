package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Espadachin extends UnidadMovil{

    public Espadachin( Jugador jugador ){
        this.jugador = jugador;
        this.vidaActual = 100;
        this.vidaMaxima = 100;
        this.costo = 50;
    }

    public int getVidaMaxima(){return this.vidaMaxima;}

    public int getVidaActual(){return this.vidaActual;}

    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }

    public void mover(Mapa mapa, Direccionable direccion){
        Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino)){
            mapa.moverElemento(this,destino);
        }
    }

}
