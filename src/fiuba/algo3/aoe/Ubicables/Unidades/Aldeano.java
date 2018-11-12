package fiuba.algo3.aoe.Ubicables.Unidades;


public class Aldeano extends UnidadMovil {

    private int vidaMaxima;
    private int costo;
    private int vidaActual;

    public Aldeano(){
        this.vidaMaxima = 50;
        this.vidaActual = 50;
        this.costo = 25;
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){return this.vidaActual;}

    public int costo(){
        return this.costo;
    }

    public void disminuirVida( int vida){
        this.vidaActual-= vida;
    }
}
