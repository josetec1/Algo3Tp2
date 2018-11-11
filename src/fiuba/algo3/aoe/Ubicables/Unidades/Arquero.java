package fiuba.algo3.aoe.Ubicables.Unidades;

public class Arquero extends UnidadMovil {
    private int vidaMaxima;
    private int costo;
    private int vidaActual;

    public Arquero(){
        this.vidaActual = 75;
        this.vidaMaxima = 75;
        this.costo = 75;
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int costo(){
        return this.costo;
    }

    public int getVidaActual(){
        return this.vidaActual;
    }


    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }

}
