package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.*;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoCastillo.EstadoDaniadoCastillo;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoCastillo.EstadoNormalCastillo;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoCastillo.IEstadoCastillo;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

import java.util.ArrayList;

public class Castillo extends Edificio implements Atacante, ObservableCastillo {

    private final int DISTANCIA_ATAQUE = 3;
    private final int DANIO = 20;
    private final int CURACION = 15;
    private ArrayList<ObservadorCastillo> observadores;
    private IEstadoCastillo estado;

    public Castillo() {
        super(1000, new PosicionNula(), 4);
        this.observadores = new ArrayList<>();
        this.estado = new EstadoNormalCastillo();
    }



    @Override
    public void aumentarVida(int unaCantidad) {
        throw  new FaltaImplementarException();
    }

    public void comenzarReparacion(Aldeano aldeano){
        throw  new FaltaImplementarException();
       // this.estado = new EstadoEnReparacion (aldeano);
    }

    @Override
    public boolean puedoReparar() {
        throw  new FaltaImplementarException();
    }

    @Override
    public void reparar(Aldeano aldeano) {
        throw  new FaltaImplementarException();
    }

    @Override
    public boolean puedocrearUnidad() {
        throw  new FaltaImplementarException();
    }





    public void crearArmaDeAsedio( Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        ArmaDeAsedio armaDeAsedio= new ArmaDeAsedio ();
        if(!mapa.puedoColocar (posicionReal,armaDeAsedio.getTamanio ())){return;}
        if(!jugadorActivo.puedoAgregar (armaDeAsedio)){return; }

        mapa.colocar ( armaDeAsedio, posicionReal);
        jugadorActivo.agregarPieza ( armaDeAsedio );
    }


    @Override
    public void huboUnCambioDeTurno ( Jugador jugador ) {
        this.estado.nuevoTurno(this,CURACION);
    }
    @Override
    public void agregarObservador(ObservadorCastillo unObservador) {
        this.observadores.add(unObservador);
    }

    /*******************************************************
     // Metodos de Atacante
     ******************************************************/
    @Override
    public int getDanioGeneradoAUnidad() {
        return DANIO;
    }
    @Override
    public int getDanioGeneradoAEdificio() {
        return DANIO;
    }
    @Override
    public int getDistanciaAtaque() {
        return DISTANCIA_ATAQUE;
    }

    @Override
    public void atacar(Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa) {
     throw  new FaltaImplementarException();
    }










    @Override
    public void disminuirVida(int vida, Jugador miJugador, Mapa mapa) {

        int vidaAux = this.getVidaActual() - vida;

        if (vidaAux <= 0) {
            // el edificio murio
            mapa.remover(this);
            //notifica a observadores
            for (ObservadorCastillo observador : this.observadores){ observador.castilloEliminado();}
        }
        else{
            this.estado = new EstadoDaniadoCastillo();
        }
        this.setVida(vidaAux);
    }

    /*******************************************************
     // Metodos de
     ******************************************************/


}
