package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EdificioYaConstruidoException;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.*;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionInvalidaException;

public class Aldeano extends UnidadMovil  {

    private IEstadoUnidadAldeano estado;
    private final int VIDA_MAXIMA = 50;
    private final int COSTO = 25;
    private final int ORO_PRODUCIDO = 20;

    public Aldeano( ){
        this.vidaMaxima = VIDA_MAXIMA;
        this.vidaActual = VIDA_MAXIMA;
        this.costo = COSTO;
        this.estado = new EstadoLibreYRecolectando();
    }


    public boolean estasDisponible (){return this.estado.estasDisponible();}

    @Override
    public void mover(Mapa mapa, Direccionable direccion, Jugador jugador) {
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.mover(this, mapa,direccion);
    }

    public void construirEdificio (Edificio edificio, Mapa mapa, Jugador jugador, Posicion posicion){
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.construir(this,edificio, mapa, posicion,jugador);
    }
    public void reparar (Edificio unEdificio, Jugador jugador){
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.reparar(this,unEdificio); }

    // no usar desde afuera.
    public void cambiarAContruyendo(){
        this.estado= new EstadoConstruyendo();
    }
    public void cambiarARecolectando(){this.estado= new EstadoLibreYRecolectando();}
    public void cambiarAMoviendose() {
        this.estado = new EstadoMoviendoseYRecolectando();
    }
    public void cambiarAReparando(Edificio unEdificio) {
        this.estado = new EstadoReparando(this, unEdificio);}

    @Override
    public void huboUnCambioDeTurno(Jugador jugador) {
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.pasarTurno(this, jugador);
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    public int getVidaActual(){return this.vidaActual;}
    public void disminuirVida( int vida){
        this.vidaActual-= vida;
    }
    public void entregarElOro (Jugador jugador){jugador.sumarOro(ORO_PRODUCIDO);}

}
