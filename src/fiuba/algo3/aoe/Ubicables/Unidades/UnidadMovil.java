package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class UnidadMovil implements Ubicable {
    private Posicion posicion;
    private String jugador;


    public abstract int costo();

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion obtenerPosicionDeAvance( Direccionable direccionable ){

        return this.posicion.calcularPosicionSiguiente(direccionable);
    }

    //TODO: si no se puede mover por que la posicion esta ocupada, tendria que hacer algo, retornar un bool
    // y usar eso para volvera intentar otra cosa, o enviar un mensaje "ahi no me puedo mover"
    public void mover( Tablero tablero, Direccionable direccion){
        Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (tablero.puedoColocar(destino)){
            tablero.moverElemento(this,destino);
        }
    }
}