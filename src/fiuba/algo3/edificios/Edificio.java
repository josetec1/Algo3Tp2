package fiuba.algo3.edificios;

import fiuba.algo3.aoe.Ubicable.Ubicable;

public abstract class Edificio {

    private int vidaTotal;
    private int vidaActual;


    public Edificio(int unaVida) {
        vidaTotal = unaVida;
        vidaActual = unaVida;
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

    public abstract void repararse();
}
