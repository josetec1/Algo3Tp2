package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnConstruccion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;

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

}
