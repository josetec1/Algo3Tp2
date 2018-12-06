package fiuba.algo3.aoe.modelo.Ubicables.Edificios;


import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Observadores.ObservableCastillo;
import fiuba.algo3.aoe.modelo.Observadores.ObservadorCastillo;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Atacante;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoCastillo.EstadoDaniadoCastillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoCastillo.EstadoEnReparacionCastillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoCastillo.EstadoNormalCastillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoCastillo.IEstadoCastillo;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EnemigoSinJugadorException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstoyEnDosJugadoresException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.FuegoAmigoException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.UnidadFueraDeRangoDeAtaqueException;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;

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
        int vidaAux = this.getVidaActual() + unaCantidad;

        if (vidaAux >= this.getVidaMaxima()) {
            this.setVida(this.getVidaMaxima());
            this.estado = new EstadoNormalCastillo();
        }else{ this.setVida(vidaAux);}
    }

    public void comenzarReparacion(Aldeano aldeano){
        this.estado = new EstadoEnReparacionCastillo(aldeano);
    }

    @Override
    public boolean puedoReparar() {
        return this.estado.puedoReparar();
    }

    @Override
    public void reparar(Aldeano aldeano) {
        this.estado.reparar(this,aldeano);
    }


    @Override
    public boolean puedocrearUnidad() {
        return this.estado.puedoCrearUnidad();
    }


    public void crearArmaDeAsedio(Jugador jugadorActivo, Mapa mapa, PosicionReal posicionReal){
        ArmaDeAsedio armaDeAsedio= new ArmaDeAsedio ();


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
        if (!miJugador.esMio(this)){throw new NoEsMiJugadorException();}
        if (miJugador.esMio(objetivoEnemigo)){throw new FuegoAmigoException();}

        if (jugadorEnemigo.esMio(this)){throw new EstoyEnDosJugadoresException();}
        if (!jugadorEnemigo.esMio(objetivoEnemigo)){throw new EnemigoSinJugadorException();}


        if(!(this.getDistanciaAtaque() >= this.getPosicion().distancia(objetivoEnemigo.getPosicion()))) {
            throw new UnidadFueraDeRangoDeAtaqueException();
        }
        objetivoEnemigo.serAtacadoPor(this,jugadorEnemigo,mapa);
    }

    @Override
    public boolean puedoAtacar(Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa) {

        if (!miJugador.esMio(this)){return false;}
        if (miJugador.esMio(objetivoEnemigo)){return false;}

        if (jugadorEnemigo.esMio(this)){return false;}
        if (!jugadorEnemigo.esMio(objetivoEnemigo)){return false;}


        if(!(this.getDistanciaAtaque() >= this.getPosicion().distancia(objetivoEnemigo.getPosicion()))) {
            return false;
        }
        return true;
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
     // propios
     * *****************************************************/

    public void atacarAlJugador(Jugador miJugador, Jugador enemigo,Mapa mapa){

        if (!miJugador.esMio(this)) {throw  new NoEsMiJugadorException();}
        if (enemigo.esMio(this)) {throw new FuegoAmigoException();}
        for (Atacable atacable : enemigo.getAtacables()){

            if (this.puedoAtacar(atacable,miJugador,enemigo,mapa)){
                this.atacar(atacable,miJugador,enemigo,mapa);
            }
        }
   }
}
