package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.EstadoReparando;

public class PlazaCentral extends Edificio {
// TODO refactor constantes
    public PlazaCentral(  ){
        this.costo = 100;
        this.vidaMaxima = 450;
        this.vidaActual = 450;
        this.estado = new EstadoEnConstruccion(3);


    }

    public void reparar(){
        if(estado.enConstruccion()){
            throw new EdificioSinDaniarException();
        }
        if(!this.estaDaniado()){
            throw new EdificioSinDaniarException();
        }
        if (estado.enReparacion()){
            estado.reparar(this);
        }else {
            this.aumentarVida(25);
            this.estado = new EstadoEnReparacion(25);
        }
    }

    public Aldeano construirAldeano( Jugador jugador){
        if (!estado.puedoConstruirUnidad()){
            throw new NoSePuedeConstruirEnEsteMomentoException();
        }
        Aldeano aldeano = new Aldeano();
        jugador.descontarOro(aldeano.getCosto());
        return aldeano;
    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }
}

