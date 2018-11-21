package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;

public class Cuartel extends Edificio {
    private final int TAMANIO = 2;

    public Cuartel( ){
        this.costo = 50;
        this.vidaMaxima = 250;
        this.vidaActual = 250;
        this.tamanio = TAMANIO;
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
            this.aumentarVida(50);
            this.estado = new EstadoEnReparacion(50);
        }
    }

    @Override
    public void repararCon(Aldeano aldeano) {
        //todo
    }

    public Espadachin construirEspadachin(Jugador jugador){
        if (!estado.puedoConstruirUnidad()){
            throw new NoSePuedeConstruirEnEsteMomentoException();
        }
        Espadachin espadachin =  new Espadachin();
        //jugador.descontarOro(espadachin.getCosto());
        return espadachin;
    }

    public Arquero construirArquero(Jugador jugador){
        if (!estado.puedoConstruirUnidad()){
            throw new NoSePuedeConstruirEnEsteMomentoException();
        }
        Arquero arquero = new Arquero();
       // jugador.descontarOro(arquero.getCosto());
        return arquero;

    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }
}
