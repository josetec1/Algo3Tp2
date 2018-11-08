package Ubicables.Unidades.movimiento;

import fiuba.algo3.aoe.Tablero.Casillero;

public class DireccionArribaIzquierda implements Direccion {

    public Casillero calcularSiguienteCasillero(int x, int y){
        Casillero casillero = new Casillero(x-1,y+1);
        return casillero;
    }

}
