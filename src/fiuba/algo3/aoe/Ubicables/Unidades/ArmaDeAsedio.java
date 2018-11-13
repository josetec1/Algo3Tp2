package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class ArmaDeAsedio extends UnidadMovil{

    public ArmaDeAsedio( Jugador jugador ){
        this.vidaMaxima = 150;
        this.vidaActual = 150;
        this.costo = 200;
        this.jugador = jugador;
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){
        return this.vidaActual;
    }

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
