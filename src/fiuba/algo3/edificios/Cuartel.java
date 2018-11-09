package fiuba.algo3.edificios;

public class Cuartel extends Edificio {

    Cuartel(){
        super(250,50);
    }

    @Override
    public void repararse(){
        aumentarVida(50);
    }
}
