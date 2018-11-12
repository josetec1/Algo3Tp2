package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Arquero extends UnidadMovil {

    public Arquero(){
        this.vidaActual = 75;
        this.vidaMaxima = 75;
        this.costo = 75;
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
