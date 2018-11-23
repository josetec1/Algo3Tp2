package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;

public class Castillo extends Edificio implements Atacante {
    private final int TAMANIO = 4;
    private int distanciaAtaque = 3;
    private int danio = 20;
    //TODO implementar multiton
    public Castillo( ){
       costo = 0;
       vidaActual = 1000;
       vidaMaxima = 1000;
       this.tamanio = TAMANIO;
       this.estado = new EstadoNormal();

    }

    public int getCosto(){
        throw new EdificioNoConstruibleSinCostoException();
    }


    public void reparar( Aldeano aldeano){
        if(!this.estaDaniado()){
            throw new EdificioSinDaniarException();
        }
        if (estado.enReparacion()){
            estado.reparar(this, aldeano);
        }else {
            this.aumentarVida(15);
            this.estado = new EstadoEnReparacion(15);
        }
    }

    @Override
    public void construir( Aldeano aldeano){
        throw new EdificioNoConstruibleSinCostoException();
    }

    @Override
    public void repararCon(Aldeano aldeano) {
        //todo
    }

    public ArmaDeAsedio construirArmaDeAsedio(Jugador jugador){
        if (!estado.puedoConstruirUnidad()){
            throw new NoSePuedeConstruirEnEsteMomentoException();
        }
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
       // jugador.descontarOro(armaDeAsedio.getCosto());
        return armaDeAsedio;
    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }

    public void atacar(Atacable unAtacable) {
        if(distanciaAtaque >= posicion.distancia(unAtacable.getPosicion()))
            unAtacable.serAtacadoPor(this);
    }

    @Override
    public int getDanioUnidad() {
        return danio;
    }

    @Override
    public int getDanioEdificio() {
        return danio;
    }
}
