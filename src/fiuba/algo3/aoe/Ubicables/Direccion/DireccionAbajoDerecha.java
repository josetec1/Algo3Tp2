package fiuba.algo3.aoe.Ubicables.Direccion;

import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;

public class DireccionAbajoDerecha implements Direccionable {

    public Casillero calcularSiguienteCasillero(Casillero unCasillero){
        int x=unCasillero.getX();
        int y = unCasillero.getY();
        return new Casillero(x+1,y-1);

    }

}
