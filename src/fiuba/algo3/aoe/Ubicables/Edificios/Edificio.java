package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class Edificio implements Ubicable {
    protected int vidaMaxima;
    protected int vidaActual;
    protected Posicion posicion;
    protected int costo;
    protected String estado;
    protected int turnosParaLaConstruccion;

    public int getCosto () {
        return this.costo;
    }

    public void colocarEn ( Posicion posicion ) {
        this.posicion = posicion;
    }

    public Posicion getPosicion () {
        return this.posicion;
    }

    public int getVidaMaxima () {
        return this.vidaMaxima;
    }

    public int getVidaActual () {
        return this.vidaActual;
    }

    public void disminuirVida ( int unaCantidad ) {
        this.vidaActual = this.vidaActual - unaCantidad;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public abstract void reparar ();

    public boolean estaEnConstruccion (){
        return this.estado == "En Construccion";
    }

    public boolean estaDaniado () {
        return (this.vidaActual < this.vidaMaxima && this.vidaActual > 0);
    }


}
