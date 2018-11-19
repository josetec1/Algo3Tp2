package fiuba.algo3.aoe.Ubicables;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovilMilitar;

public interface Atacable  extends Ubicable{

    int getVidaActual();

    void serAtacadoPor(Atacante unidadMovilMilitar);

    int getVidaMaxima();

}
