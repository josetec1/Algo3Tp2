package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class UnidadMovil implements Ubicable {
    private Posicion posicion;


    public Posicion getPosicion() {
        return this.posicion;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion obtenerPosicionSiguiente( Direccionable direccionable ){

        return this.posicion.calcularPosicionSiguiente(direccionable);
    }
}