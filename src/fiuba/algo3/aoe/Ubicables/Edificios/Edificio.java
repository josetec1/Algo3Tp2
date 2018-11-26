package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoDaniado;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class Edificio implements Manipulable {
    protected int vidaMaxima;
    protected int vidaActual;
    protected Posicion posicion;
    protected int costo;
    protected int tamanio;
    protected EstadoEdificio estado ;

    public int getCosto () {
        return this.costo;
    }

    public int getTamanio () {
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
        this.estado = new EstadoDaniado ();
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public void aumentarVida ( int unaCantidad ) {
        vidaActual += unaCantidad;
        if (vidaActual >= vidaMaxima) {
            vidaActual = vidaMaxima;
            this.estado = new EstadoNormal ();

        }
    }

    public void serAtacadoPor ( Atacante unAtacante ) {

        this.disminuirVida(unAtacante.getDanioEdificio());
    }

    public abstract void comenzarConstruccion(Aldeano aldeano); //TODO este metodo es el que tendria que notificar la creacion a la vista

    public abstract void comenzarReparacion(Aldeano aldeano);

    public boolean puedoReparar(){
        return this.estado.puedoReparar();
    }

    public boolean puedoConstruir(){
        return this.estado.puedoConstruir ();
    }

    public boolean puedocrearUnidad(){
        return this.estado.puedoCrearUnidad();
    }


    public void finalizarConstruccion (){
        this.estado = new EstadoNormal ();
    }

    public void reparar(Aldeano aldeano){
        this.estado.reparar ( this,aldeano );
    }

    public void construir(Aldeano aldeano){
        this.estado.construir ( this,aldeano );
    }
}
