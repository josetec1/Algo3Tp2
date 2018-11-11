package fiuba.algo3.aoe.Ubicables.Unidades;

public class Espadachin extends UnidadMovil{
    private int vidaMaxima;
    private int vidaActual;
    private int costo;


    public Espadachin(){
        this.vidaActual = 100;
        this.vidaMaxima = 100;
        this.costo = 50;
    }

    public int getVidaMaxima(){return this.vidaMaxima;}

    public int getVidaActual(){return this.vidaActual;}

    public int costo(){
        return this.costo;
    }


    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }

}
