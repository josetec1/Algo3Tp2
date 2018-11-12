package fiuba.algo3.aoe.Ubicables.Direccion;

import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;

public class DireccionArriba implements Direccionable {

    public Casillero calcularSiguienteCasillero(Casillero unCasillero){
        int x=unCasillero.getX();
        int y = unCasillero.getY();
        return new Casillero(x,y+1);

    }

}