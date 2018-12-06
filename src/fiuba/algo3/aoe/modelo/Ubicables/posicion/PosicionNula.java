package fiuba.algo3.aoe.modelo.Ubicables.posicion;

import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;

import java.util.ArrayList;

public class PosicionNula extends Posicion {
    @Override
    public ArrayList<Cuadrante> getCasilleros() {
        throw new PosicionNulaException();
    }

    @Override
    public boolean seSuperponeCon(Posicion otraPosicion) {
        throw new PosicionNulaException();
    }

    @Override
    public void agregar(Cuadrante unCuadrante) {
        throw new PosicionNulaException();
    }

    @Override
    public boolean estasDentroDe(int ancho, int alto) {
        throw new PosicionNulaException();
    }

    @Override
    public Posicion calcularPosicionSiguiente(Direccionable direccion) {
        throw new PosicionNulaException();
    }

    @Override
    public Posicion expandir(int tamanio) {
        throw new PosicionNulaException();
    }

    @Override
    public int distancia(Posicion otraPosicion) {
        throw new PosicionNulaException();
    }
}
