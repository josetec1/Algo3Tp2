package fiuba.algo3.aoe.Ubicables;

import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovilMilitar;

public interface Atacable  extends Ubicable{

    int getVidaActual();

    void serAtacadoPor(UnidadMovilMilitar unidadMovilMilitar);

    int getVidaMaxima();


}
