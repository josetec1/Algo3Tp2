package fiuba.algo3.aoe.Ubicables.Unidades;

public class Espadachin extends UnidadMovil{
    private int vida = 100;
    private int costo = 50;

    public int vidaTotal(){
        return this.vida;
    }

    public int costo(){
        return this.costo;
    }
    public void disminuirVida( int vida){
        this.vida -= vida;
    }

}
