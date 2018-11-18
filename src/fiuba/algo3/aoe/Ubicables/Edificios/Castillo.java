package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.ArmaDeAsedio;

public class Castillo extends Edificio{

    //TODO implementar multiton
    public Castillo( ){
       costo = 0;
       vidaActual = 1000;
       vidaMaxima = 1000;

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

    public ArmaDeAsedio construirArmaDeAsedio(Jugador jugador){
        if (!estado.puedoConstruirUnidad()){
            throw new NoSePuedeConstruirEnEsteMomentoException();
        }
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        jugador.descontarOro(armaDeAsedio.getCosto());
        return armaDeAsedio;
    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }
}
