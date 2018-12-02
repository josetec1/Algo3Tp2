package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoAConstruir;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Cuartel extends Edificio {
    private final int TAMANIO = 2;
    private final int  TURNOSPARACONSTRUCCION = 3;
    private final int CURACION = 50;

    public Cuartel( ){
        this.costo = 50;
        this.vidaMaxima = 250;
        this.vidaActual = 250;
        this.tamanio = TAMANIO;
        this.estado = new EstadoAConstruir ();

    }

    public void comenzarConstruccion(Aldeano aldeano, Jugador jugador){
        estado = new EstadoEnConstruccion (aldeano,this.TURNOSPARACONSTRUCCION);
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

    public void crearArquero( Jugador jugadorActivo, Mapa mapa, Posicion posicion){
        Arquero arquero= new  Arquero ();
        if(!mapa.puedoColocar ( posicion,arquero.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (arquero)){return;}
        jugadorActivo.agregarPieza ( arquero );
        mapa.colocar ( arquero,posicion );
    }

    public void crearEspadachin( Jugador jugadorActivo, Mapa mapa, Posicion posicion){
        Espadachin espadachin= new  Espadachin ();
        if(!mapa.puedoColocar ( posicion,espadachin.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (espadachin)){return;}
        jugadorActivo.agregarPieza ( espadachin );
        mapa.colocar ( espadachin,posicion );
    }


}
