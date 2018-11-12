package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class Edificio implements Ubicable {
    private int costo;
    private int vidaTotal;
    private int vidaActual;
    private Posicion posicion;

    public Edificio(int unaVida) {
        vidaTotal = unaVida;
        vidaActual = unaVida;
    }

    public int costo(){
        return this.costo;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public int vidaTotal() {
        return vidaTotal;
    }

    public int vidaActual() {
        return vidaActual;
    }

    public void disminuirVida(int unaCantidad) {
        vidaActual -= unaCantidad;
        if(vidaActual<0) vidaActual = 0;
    }

    protected void aumentarVida(int unaCantidad) {
        vidaActual += unaCantidad;
        if(vidaActual > vidaTotal) vidaActual = vidaTotal;
    }

    public abstract void reparar();
}
