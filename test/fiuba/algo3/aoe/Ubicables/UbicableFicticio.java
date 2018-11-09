package fiuba.algo3.aoe.Ubicables;

import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.Ubicable;

// Objeto ficticio utilizado para implementar el Tablero
public class UbicableFicticio implements Ubicable {

private Posicion posicion;

    public UbicableFicticio (Posicion unaPosicion){
        this.posicion = unaPosicion;
    }


    @Override
    public Posicion getPosicion() {return posicion;}
}
