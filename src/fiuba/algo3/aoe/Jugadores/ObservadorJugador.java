package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.EstadoReparando;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;

public interface ObservadorJugador {

     void seCreo( Aldeano unaldeano);
     void seCreo(Espadachin espadachin);
     void seCreo(Arquero arquero);
     void seCreo(ArmaDeAsedio arma);
     void seCreo(PlazaCentral plaza);
     void seCreo(Cuartel cuartel);

}
