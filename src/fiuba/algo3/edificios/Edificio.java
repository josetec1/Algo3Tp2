package fiuba.algo3.edificios;

public abstract class Edificio {

    private int costo;
    private int vidaTotal;
    private int vidaActual;


    public Edificio(int unaVida, int unCosto) {
        this.vidaTotal = unaVida;
        this.vidaActual = unaVida;
        this.costo = unCosto;
    }

    public int vidaTotal() {
        return vidaTotal;
    }

    public int costo() {
        return costo;
    }

    public int vidaActual() {
        return vidaActual;
    }

    public void disminuirVida(int unaCantidad) {
        vidaActual -= unaCantidad;
        if(vidaActual<0) vidaActual = 0;
    }

    public void aumentarVida(int unaCantidad) {
        vidaActual += unaCantidad;
        if(vidaActual > vidaTotal) vidaActual = vidaTotal;
        ;
    }

    public abstract void repararse();
}
