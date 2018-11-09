package Ubicables.Unidades.movimiento;

import fiuba.algo3.aoe.Tablero.Casillero;

public class DireccionAbajo implements Direccion {

    public Casillero calcularSiguienteCasillero(Casillero unCasillero){
        int x=unCasillero.getX();
        int y = unCasillero.getY();

        return new Casillero(x,y-1);

    }

}