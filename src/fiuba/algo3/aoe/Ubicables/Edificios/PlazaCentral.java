package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoAConstruir;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoDaniado;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

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




    public void crearAldeano( Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        Aldeano aldeano= new Aldeano ();
        if(!mapa.puedoColocar (posicionReal,aldeano.getTamanio () )){return;}
        if(!jugadorActivo.puedoAgregar (aldeano)){return;}
        mapa.colocar ( aldeano, posicionReal);
        jugadorActivo.agregarPieza ( aldeano );

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

