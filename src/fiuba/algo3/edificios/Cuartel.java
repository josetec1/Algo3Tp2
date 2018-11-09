package fiuba.algo3.edificios;

public class Cuartel extends EdificioConstruible {

    Cuartel(){
        super(250,50, 3);
    }

    @Override
    public void repararse(){
        aumentarVida(50);
    }

}
