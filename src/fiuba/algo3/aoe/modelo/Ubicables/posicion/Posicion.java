package fiuba.algo3.aoe.modelo.Ubicables.posicion;

import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Posicion {
    protected ArrayList<Cuadrante> cuadrantes =new ArrayList<>();

    public abstract ArrayList <Cuadrante> getCasilleros();
    public abstract boolean seSuperponeCon (Posicion otraPosicion) ;
    public abstract void agregar (Cuadrante unCuadrante);
    public abstract boolean estasDentroDe (int ancho, int alto);
    public abstract Posicion calcularPosicionSiguiente(Direccionable direccion );
    public abstract Posicion expandir(int tamanio);
    public abstract int distancia(Posicion otraPosicion);

    protected Iterator<Cuadrante> getIterador(){return cuadrantes.iterator();}


}
