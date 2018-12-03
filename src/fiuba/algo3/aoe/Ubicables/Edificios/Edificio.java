package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacante;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoEdificio;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EstadoNormal;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.FuegoAmigoException;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public abstract class Edificio implements Manipulable {
    protected int vidaMaxima;
    protected int vidaActual;
    protected Posicion posicionReal;
    protected int costo;
    protected int tamanio;
    protected EstadoEdificio estado ;

    public int getCosto () {
        return this.costo;
    }

    public int getTamanio () {
        return this.tamanio;
    }

    public void colocarEn (Posicion posicion) {
        this.posicionReal = posicion;
    }

    public Posicion getPosicion () {
        return this.posicionReal;
    }

    public int getVidaMaxima () {
        return this.vidaMaxima;
    }

    public int getVidaActual () {
        return this.vidaActual;
    }



    @Override
    public abstract void disminuirVida(int vida, Jugador miJugador, Mapa mapa);

    public void aumentarVida ( int unaCantidad ) {
        vidaActual += unaCantidad;
        if (vidaActual >= vidaMaxima) {
            vidaActual = vidaMaxima;
            this.estado = new EstadoNormal ();

        }
    }

    public void serAtacadoPor(Atacante unAtacante, Jugador jugadorAtacante, Jugador miJugador,Mapa mapa) {
        if (jugadorAtacante.esMio(this)){throw new FuegoAmigoException();}
        this.disminuirVida(unAtacante.getDanioGeneradoAEdificio(),miJugador,mapa);
    }



    public abstract void comenzarConstruccion(Aldeano aldeano, Jugador jugador); //TODO este metodo es el que tendria que notificar la creacion a la vista

    public abstract void comenzarReparacion(Aldeano aldeano);

    public boolean puedoReparar(){
        return this.estado.puedoReparar();
    }

    public boolean puedoConstruir(){
        return this.estado.puedoConstruir ();
    }

    public boolean puedocrearUnidad(){
        return this.estado.puedoCrearUnidad();
    }


    public void finalizarConstruccion (){
        this.estado = new EstadoNormal ();
    }

    public void reparar(Aldeano aldeano){
        this.estado.reparar ( this,aldeano );
    }

    public void construir(Aldeano aldeano, Jugador jugador){
        this.estado.construir ( this,aldeano, jugador );
    }



}
