package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.NotificableDeTurno;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovilMilitar;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class Edificio implements Manipulable {
    protected int vidaMaxima;
    protected int vidaActual;
    protected Posicion posicion;
    protected int costo;
    protected EstadoEdificio estado;
    protected int tamanio;

    public int getCosto () {
        return this.costo;
    }

    public int getTamanio (){
        return this.tamanio;
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
    public void aumentarVida(int unaCantidad){
        if (vidaActual>=vidaMaxima){
            vidaActual = vidaMaxima;
            this.estado = new EstadoNormal();
            return;
        }
        vidaActual += unaCantidad;
    }

    public abstract void reparar ();

    public void construir(){
        try {
            this.estado.construir(this);
        }catch (EdificioConstruidoException e){
            this.estado = new EstadoNormal();
        }
    }

    public boolean estaEnConstruccion (){
        return this.estado.enConstruccion();
    }
    public boolean estaEnReparacion (){
        return this.estado.enReparacion();
    }

    public boolean estaDaniado () {
        return (this.vidaActual < this.vidaMaxima && this.vidaActual > 0);
    }

    public void serAtacadoPor(Atacante unAtacante) {

        this.disminuirVida(unAtacante.getDanioEdificio());
    }
}
