package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;

public interface ObservadorJugador {

     void seCreo(Aldeano unaldeano);
     void seCreo(Espadachin espadachin);
     void seCreo(Arquero arquero);
     void seCreo(ArmaDeAsedio arma);
     void seCreo(PlazaCentral plaza);
     void seCreo(Cuartel cuartel);
     void seCreo(Castillo castillo);

}
