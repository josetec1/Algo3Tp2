package fiuba.algo3.aoe.Ubicables.Edificios;

public class Castillo extends Edificio {
    private int costo = 0;

    public Castillo() {
        super(1000);
    }

    @Override
    public void reparar() {
        aumentarVida(15);
    }
}
