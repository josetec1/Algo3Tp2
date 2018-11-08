package Ubicables.Unidades.movimiento;

import fiuba.algo3.aoe.Tablero.Casillero;

public class DireccionIzquierda implements Direccion {

    public Casillero calcularSiguienteCasillero(int x, int y){
        Casillero casillero = new Casillero(x-1,y);
        return casillero;
    }

}