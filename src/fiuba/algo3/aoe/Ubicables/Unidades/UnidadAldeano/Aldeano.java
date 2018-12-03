package fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.*;
import fiuba.algo3.aoe.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public class Aldeano extends UnidadMovil {

    private IEstadoUnidadAldeano estado;
    private final int ORO_PRODUCIDO = 20;

    public Aldeano( ){
        super (new PosicionNula(),50,25);
        this.estado = new EstadoLibreYRecolectando();
    }

    public boolean estasDisponible (){return this.estado.estasDisponible();}

    @Override
    public void mover(Mapa mapa, Direccionable direccion, Jugador jugador) {
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.mover(this, mapa,direccion);
    }

    public void construirEdificio (EdificioConstruible edificio, Mapa mapa, Jugador jugador, PosicionReal posicionReal){
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.construir(this,edificio, mapa, posicionReal,jugador);
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

    public void entregarElOro (Jugador jugador){jugador.sumarOro(ORO_PRODUCIDO);}





}
