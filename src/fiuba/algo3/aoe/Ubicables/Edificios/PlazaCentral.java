package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoAConstruir;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

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

    public void comenzarConstruccion(Aldeano aldeano){
        this.estado = new EstadoEnConstruccion (aldeano,TURNOSPARACONSTRUCCION);
    }

    public void comenzarReparacion(Aldeano aldeano){
        this.estado = new EstadoEnReparacion (aldeano);
    }

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }
}

