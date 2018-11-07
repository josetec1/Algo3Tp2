package fiuba.algo3.aoe;

public abstract class Unidad {

    private int vidaTotal;
    private int vidaActual;
    private int costo;

    protected Unidad(int vida, int unCosto){

        this.vidaTotal = vida;
        this.vidaActual = vida;
        this.costo = unCosto;
    }

    public int vidaTotal(){
        return vidaTotal;

    }

    public int costo(){
        return  costo;
    }
}
