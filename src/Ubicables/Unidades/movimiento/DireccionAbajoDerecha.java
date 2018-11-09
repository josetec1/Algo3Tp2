package Ubicables.Unidades.movimiento;

import fiuba.algo3.aoe.Tablero.Casillero;

public class DireccionAbajoDerecha implements Direccion {

    public Casillero calcularSiguienteCasillero(Casillero unCasillero){
        int x=unCasillero.getX();
        int y = unCasillero.getY();
        return new Casillero(x+1,y-1);

    }

}
