package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.ObservableCastillo;
import fiuba.algo3.aoe.Jugadores.ObservadorCastillo;
import fiuba.algo3.aoe.Jugadores.ObservadorJugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.Observer;

public class Castillo extends Edificio implements Atacante, ObservableCastillo {
    private final int TAMANIO = 4;
    private int distanciaAtaque = 3;
    private int danio = 20;
    private final int CURACION = 15;
    private ArrayList<ObservadorCastillo> observadores;
    //TODO implementar multiton

    public Castillo( ){
       vidaActual = 1000;
       vidaMaxima = 1000;
       this.tamanio = TAMANIO;
       this.estado = new EstadoNormal ();
       this.observadores = new ArrayList<>();

    }

    public int getCosto(){
       // return this.costo;
        throw new EdificioNoConstruibleSinCostoException(); //TODO esto hay que refactorizarlo
    } // TODO necesito que devuelva 0
      //TODO esto esta mal, si el castillo no tiene costo entonces no se cumple  "es un" edificio que tiene costo"

    public void comenzarConstruccion(Aldeano aldeano, Jugador jugador){
        throw new EdificioNoConstruibleSinCostoException ();
    }

    public void comenzarReparacion(Aldeano aldeano){
        this.estado = new EstadoEnReparacion (aldeano);
    }


    public void atacar(Atacable unAtacable, Jugador jugadorAtacante) {

        if(!jugadorAtacante.esMio(this))
            throw new NoEsMiJugadorException(); //TODO reeveer excepcion

        if(distanciaAtaque >= posicion.distancia(unAtacable.getPosicion()))
            unAtacable.serAtacadoPor(this);
    }

    @Override
    public int getDanioGeneradoAUnidad() {
        return danio;
    }

    @Override
    public int getDanioGeneradoAEdificio() {
        return danio;
    }

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }

    @Override
    public void eliminarMuerto(Jugador jugador, Jugador enemigo, Mapa mapa) {
        if (this.vidaActual <= 0){
            //el tipo murio.
            //me saco del tablero
            mapa.remover(this);
            for (ObservadorCastillo observador : this.observadores){ //le aviso a mi observador, que es el juego.
                observador.gano(enemigo);
            }
        }
    }

    public void crearArmaDeAsedio( Jugador jugadorActivo, Mapa mapa, Posicion posicion){
        ArmaDeAsedio armaDeAsedio= new ArmaDeAsedio ();
        if(!mapa.puedoColocar ( posicion,armaDeAsedio.getTamanio ())){return;}
        if(!jugadorActivo.puedoAgregar (armaDeAsedio)){return; }
        jugadorActivo.agregarPieza ( armaDeAsedio );
        mapa.colocar ( armaDeAsedio,posicion );
    }

    @Override
    public void agregarObservador(ObservadorCastillo unObservador) {
        this.observadores.add(unObservador);
    }


}
