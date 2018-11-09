package fiuba.algo3.aoe.Ubicables.Edificios;

public class Castillo extends Edificio {

    public Castillo() {
        super(1000);
    }

    @Override
    public void repararse() {
        aumentarVida(15);
    }
}
