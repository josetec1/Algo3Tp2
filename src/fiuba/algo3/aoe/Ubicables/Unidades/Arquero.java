package fiuba.algo3.aoe.Ubicables.Unidades;

public class Arquero extends UnidadMovil {
    private int vida = 75;
    private int costo = 75;

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
