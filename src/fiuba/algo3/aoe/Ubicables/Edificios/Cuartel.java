package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.Espadachin;

public class Cuartel extends Edificio {


    public Cuartel( Jugador jugador ){
        this.costo = 50;
        this.vidaMaxima = 250;
        this.vidaActual = 250;
        this.jugador = jugador;
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

    public Ubicable construirEspadachin(){
        Ubicable espadachin = new Espadachin(this.jugador);
        return espadachin;
    }

    public Ubicable construirArquero(){
        Ubicable arquero = new Arquero(this.jugador);
        return arquero;
    }

}
