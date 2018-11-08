package Ubicables.Unidades.movimiento;


import fiuba.algo3.aoe.Tablero.*;
import fiuba.algo3.aoe.Ubicable.Ubicable;

public class UnidadMovil implements Ubicable {
    private Posicion posicion;
    private Movimiento movimiento;


    public Posicion getPosicion() {
        return this.posicion;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion obtenerPosicionSiguiente(Direccion direccion){

        return this.movimiento.calcularPosicionSiguiente(this.posicion, direccion);
    }
}