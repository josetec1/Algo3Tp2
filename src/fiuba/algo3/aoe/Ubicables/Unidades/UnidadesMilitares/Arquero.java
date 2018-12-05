package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public class Arquero extends UnidadMilitarTropa {


    public Arquero() {
        super(new PosicionNula(), 75, 75, 15, 10, 3);
    }



    public Arquero( int vidaMaxima, int costo, int danioUnidad, int danioEdificio, int distanciaAtaque) {
        super(new PosicionNula(), vidaMaxima, costo, danioUnidad, danioEdificio, distanciaAtaque);
    }
}