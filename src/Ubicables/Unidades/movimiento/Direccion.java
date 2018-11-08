package Ubicables.Unidades.movimiento;

import fiuba.algo3.aoe.Tablero.Casillero;

public interface Direccion {
    Casillero calcularSiguienteCasillero ( int x, int y );
}