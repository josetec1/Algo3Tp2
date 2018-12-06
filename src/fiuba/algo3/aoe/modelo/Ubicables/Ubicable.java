package fiuba.algo3.aoe.modelo.Ubicables;


import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;

public interface Ubicable{

     Posicion getPosicion ();

     void colocarEn(Posicion posicion);

     int getTamanio ();
}
