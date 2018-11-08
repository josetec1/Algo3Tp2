package Ubicables.Unidades.movimiento;


import fiuba.algo3.aoe.Tablero.*;

class Movimiento {


    public Posicion calcularPosicionSiguiente(Posicion posicion, Direccion direccion) {
        return direccion.calcularPosicionSiguente(posicion);
    }
}
