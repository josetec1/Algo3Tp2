package fiuba.algo3.aoe;

import fiuba.algo3.aoe.Tablero.Posicion;
import fiuba.algo3.aoe.Ubicable.Ubicable;

// Objeto ficticio utilizado para implementar el Tablero
public class UbicableFicticio implements Ubicable {

private Posicion posicion;

    public UbicableFicticio (Posicion unaPosicion){
        this.posicion = unaPosicion;
    }


    @Override
    public Posicion getPosicion() {return posicion;}
}
