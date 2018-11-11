package fiuba.algo3.aoe.Ubicables;


import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public interface Ubicable {

     Posicion getPosicion ();

     int costo();

     void colocarEn(Posicion posicion);

}
