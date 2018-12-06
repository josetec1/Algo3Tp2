package fiuba.algo3.aoe.modelo.Ubicables.Direccion;

import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;

public interface Direccionable {
    Cuadrante calcularSiguienteCasillero (Cuadrante unCuadrante);
}