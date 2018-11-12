package fiuba.algo3.aoe.Ubicables.Edificios;

public class PlazaCentral extends EdificioConstruible {

    PlazaCentral(){
        super(450,100, 3);
    }

    @Override
    public void reparar() {
        aumentarVida(25);
    }
}
