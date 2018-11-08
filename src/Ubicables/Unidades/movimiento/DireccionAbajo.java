package Ubicables.Unidades.movimiento;

import fiuba.algo3.aoe.Tablero.Casillero;

public class DireccionAbajo implements Direccion {

    public Casillero calcularSiguienteCasillero(int x, int y){
        Casillero casillero = new Casillero(x,y-1);
        return casillero;
    }

}