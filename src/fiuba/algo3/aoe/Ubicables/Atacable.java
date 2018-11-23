package fiuba.algo3.aoe.Ubicables;

public interface Atacable  extends Ubicable{

    int getVidaActual();

    void serAtacadoPor(Atacante unidadMovilMilitar);

    int getVidaMaxima();

}
