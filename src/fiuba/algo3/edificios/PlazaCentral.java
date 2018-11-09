package fiuba.algo3.edificios;

public class PlazaCentral extends EdificioConstruible {

    PlazaCentral(){
        super(450,100, 3);
    }

    @Override
    public void repararse() {
        aumentarVida(25);
    }
}
