package fiuba.algo3.edificios;

public class PlazaCentral extends Edificio {

    PlazaCentral(){
        super(450,100);
    }

    @Override
    public void repararse() {
        aumentarVida(25);
    }
}
