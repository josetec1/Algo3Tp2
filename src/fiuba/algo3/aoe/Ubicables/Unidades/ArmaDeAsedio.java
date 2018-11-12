package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class ArmaDeAsedio extends UnidadMovil{

    public ArmaDeAsedio(){
        this.vidaMaxima = 150;
        this.vidaActual = 150;
        this.costo = 200;

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

    public void mover( Tablero tablero, Direccionable direccion){
        Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (tablero.puedoColocar(destino)){
            tablero.moverElemento(this,destino);
        }
    }
}
