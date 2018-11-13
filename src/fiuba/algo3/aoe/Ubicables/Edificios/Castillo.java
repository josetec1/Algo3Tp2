package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.ArmaDeAsedio;

public class Castillo extends Edificio{

    //TODO implementar multiton
    public Castillo( Jugador jugador){
       costo = 0;
       vidaActual = 1000;
       vidaMaxima = 1000;
       this.jugador = jugador;
       this.estado = new EstadoNormal();

    }

    public int getCosto(){
        throw new EdificioNoConstruibleSinCostoException();
    }


    public void reparar(){
        if(!this.estaDaniado()){
            throw new EdificioSinDaniarException();
        }
        if (estado.enReparacion()){
            estado.reparar(this);
        }else {
            this.aumentarVida(15);
            this.estado = new EstadoEnReparacion(15);
        }
    }

    @Override
    public void construir(){
        throw new EdificioNoConstruibleSinCostoException();
    }

    public Ubicable construirArmaDeAsedio(){
        Ubicable armaDeAsedio = new ArmaDeAsedio(this.jugador);
        return armaDeAsedio;
    }

    @Override
    public void huboUnCambioDeTurno() {

    }
}
