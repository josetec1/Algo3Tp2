package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Aldeano extends UnidadMovil {

    public Aldeano(){
        this.vidaMaxima = 50;
        this.vidaActual = 50;
        this.costo = 25;
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){return this.vidaActual;}

    public void mover( Tablero tablero, Direccionable direccion){
    Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (tablero.puedoColocar(destino)){
            tablero.moverElemento(this,destino);
        }
    }

    public void disminuirVida( int vida){
        this.vidaActual-= vida;
    }
}
