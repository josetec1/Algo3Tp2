package fiuba.algo3.aoe.Ubicables.Unidades;

public class ArmaDeAsedio extends UnidadMovil{

    private int vida = 150;
    private int costo = 200;

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
