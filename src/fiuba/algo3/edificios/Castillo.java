package fiuba.algo3.edificios;

public class Castillo extends Edificio {

    public Castillo() {
        super(1000, 0);
    }

    @Override
    public void repararse() {
        aumentarVida(15);
    }
}
