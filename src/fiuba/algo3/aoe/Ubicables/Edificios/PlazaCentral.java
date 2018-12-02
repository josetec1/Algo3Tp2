package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoAConstruir;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class PlazaCentral extends Edificio {
// TODO refactor constantes
    private final int TAMANIO = 2;
    private final int TURNOSPARACONSTRUCCION = 3;
    private final int CURACION = 25;
    public PlazaCentral(  ){
        this.costo = 100;
        this.vidaMaxima = 450;
        this.vidaActual = 450;
        this.estado = new EstadoAConstruir ();
        this.tamanio =TAMANIO;
    }

    public void comenzarConstruccion(Aldeano aldeano, Jugador jugador){
        this.estado = new EstadoEnConstruccion (aldeano,TURNOSPARACONSTRUCCION);
        jugador.agregarPieza(this);
    }

    public void comenzarReparacion(Aldeano aldeano){
        this.estado = new EstadoEnReparacion (aldeano);
    }

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }

    @Override
    public void eliminarMuerto(Jugador jugador, Jugador enemigo, Mapa mapa) {
        throw  new FaltaImplementarException();
    }

    public void crearAldeano( Jugador jugadorActivo, Mapa mapa, Posicion posicion){
        Aldeano aldeano= new Aldeano ();
        if(!mapa.puedoColocar ( posicion,aldeano.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (aldeano)){return;}
        jugadorActivo.agregarPieza ( aldeano );
        mapa.colocar ( aldeano,posicion );
    }
}

