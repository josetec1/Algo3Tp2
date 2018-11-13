package fiuba.algo3.aoe.Ubicables.Direccion;

import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;

public class DireccionArriba implements Direccionable {

    public Cuadrante calcularSiguienteCasillero(Cuadrante unCuadrante){
        int x= unCuadrante.getX();
        int y = unCuadrante.getY();
        return new Cuadrante(x,y+1);

    }

}