package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoAConstruir;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoDaniado;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

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


    public void crearArquero( Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        Arquero arquero= new  Arquero ();
        if(!mapa.puedoColocar (posicionReal,arquero.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (arquero)){return;}

        mapa.colocar ( arquero, posicionReal);
        jugadorActivo.agregarPieza ( arquero );
    }

    public void crearEspadachin( Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        Espadachin espadachin= new  Espadachin ();
        if(!mapa.puedoColocar (posicionReal,espadachin.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (espadachin)){return;}
        mapa.colocar ( espadachin, posicionReal);
        jugadorActivo.agregarPieza ( espadachin );
    }


    @Override
    public void disminuirVida(int vida, Jugador miJugador, Mapa mapa) {

        this.vidaActual = this.vidaActual - vida;
        if (this.vidaActual <= 0) {
            // el edificio murio
            mapa.remover(this);
            miJugador.eliminarPieza(this);
        }
        else{
            this.estado = new EstadoDaniado();
        }
    }


}
