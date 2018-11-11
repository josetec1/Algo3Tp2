package fiuba.algo3.aoe.Ubicables.Unidades;


public class Aldeano extends UnidadMovil {

    private int vida = 50;
    private int costo = 25;

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
