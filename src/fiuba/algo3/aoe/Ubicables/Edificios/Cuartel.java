package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoAConstruir;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;

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

    public void comenzarConstruccion(Aldeano aldeano){
        estado = new EstadoEnConstruccion (aldeano,this.TURNOSPARACONSTRUCCION);
    }

    public void comenzarReparacion(Aldeano aldeano){
        this.estado = new EstadoEnReparacion (aldeano);
    }

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }
}
