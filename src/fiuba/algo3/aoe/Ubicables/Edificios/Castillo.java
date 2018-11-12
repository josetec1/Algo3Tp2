package fiuba.algo3.aoe.Ubicables.Edificios;

public class Castillo extends Edificio{

    private static Castillo INSTANCE = new Castillo();

    private Castillo(){
       costo = 0;
       vidaActual = 1000;
       vidaMaxima = 1000;
       String estado = "En Construccion";

    }

    public static Castillo getInstancia(){
        return INSTANCE;
    }

    public int getCosto(){
        throw new EdificioNoConstruibleSinCostoException();
    }


    public void reparar(){
        if(this.estaDaniado()){
            this.vidaActual += 15;
        }
        if (this.vidaActual > vidaMaxima){
            vidaActual = vidaMaxima;
        }

    };

}
