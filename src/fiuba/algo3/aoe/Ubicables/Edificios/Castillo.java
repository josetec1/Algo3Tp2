package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.RecursoInsuficienteException;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEnReparacion;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionInvalidaException;

public class Castillo extends Edificio implements Atacante {
    private final int TAMANIO = 4;
    private int distanciaAtaque = 3;
    private int danio = 20;
    private final int CURACION = 15;
    //TODO implementar multiton

    public Castillo( ){
       costo = 0;
       vidaActual = 1000;
       vidaMaxima = 1000;
       this.tamanio = TAMANIO;
       this.estado = new EstadoNormal ();
    }

    public int getCosto(){
        throw new EdificioNoConstruibleSinCostoException();
    }

    public void comenzarConstruccion(Aldeano aldeano){
        throw new EdificioNoConstruibleSinCostoException ();
    }

    public void comenzarReparacion(Aldeano aldeano){
        this.estado = new EstadoEnReparacion (aldeano);
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

    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }

    public void crearArmaDeAsedio( Jugador jugadorActivo, Mapa mapa, Posicion posicion){
        ArmaDeAsedio armaDeAsedio= new ArmaDeAsedio ();
        if(!mapa.puedoColocar ( posicion,armaDeAsedio.getTamanio ())){return;}
        if(!jugadorActivo.puedoAgregar (armaDeAsedio)){return; }
        jugadorActivo.agregarPieza ( armaDeAsedio );
        mapa.colocar ( armaDeAsedio,posicion );
    }
}
