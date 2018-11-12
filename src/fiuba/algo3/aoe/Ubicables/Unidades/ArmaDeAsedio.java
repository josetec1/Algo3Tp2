package fiuba.algo3.aoe.Ubicables.Unidades;

public class ArmaDeAsedio extends UnidadMovil{

    private int vidaMaxima;
    private int costo ;
    private int vidaActual;

    public ArmaDeAsedio(){
        this.vidaMaxima = 150;
        this.vidaActual = 150;
        this.costo = 200;

    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){
        return this.vidaActual;
    }

    public int costo(){
        return this.costo;
    }

    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }

}
