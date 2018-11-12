package fiuba.algo3.edificios;

public class Castillo extends Edificio {

    public Castillo() {
        super(1000);
    }

    @Override
    public void reparar() {
        aumentarVida(15);
    }
}
