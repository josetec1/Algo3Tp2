package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;

public class Cuartel extends Edificio {


    public Cuartel( ){
        this.costo = 50;
        this.vidaMaxima = 250;
        this.vidaActual = 250;

        this.estado = new EstadoEnConstruccion(3);
      //  jugador.agregarEdificio(this);
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
            this.aumentarVida(50);
            this.estado = new EstadoEnReparacion(50);
        }
    }

    public Espadachin construirEspadachin(){
        return new Espadachin();

    }

    public Arquero construirArquero(){
        return new Arquero();

    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }
}
