package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Costeable;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.*;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract  class EdificioConstruible extends Edificio implements Costeable {
    protected final int  TURNOSPARACONSTRUCCION = 3;
    private int costo;
    protected EstadoEdificioConstruible estado ;

    public EdificioConstruible(int vidaMaxima, Posicion posicion, int tamanio, int costo) {
        super(vidaMaxima, posicion, tamanio);
        this.costo = costo;
        this.estado = new EstadoAConstruir();
    }


    /*******************************************************
     // Metodos de su estado
     ******************************************************/
    public abstract void comenzarConstruccion(Aldeano aldeano, Jugador jugador);

    public void construir(Aldeano aldeano, Jugador jugador){
        this.estado.construir ( this,aldeano, jugador );
    }
    public void finalizarConstruccion (){
        this.estado = new EstadoNormal();
    }
    public boolean puedoConstruir(){
        return this.estado.puedoConstruir ();
    }
    public boolean puedoReparar(){
        return this.estado.puedoReparar();
    }
    public boolean puedocrearUnidad(){
        return this.estado.puedoCrearUnidad();
    }
    public void reparar(Aldeano aldeano){
        this.estado.reparar ( this,aldeano );
    }
    public void comenzarReparacion(Aldeano aldeano){
        this.estado = new EstadoEnReparacion(aldeano);
    }





    public void aumentarVida ( int unaCantidad ) {
        int vidaAux = this.getVidaActual() + unaCantidad;

        if (vidaAux >= this.getVidaMaxima()) {
            this.setVida(this.getVidaMaxima());
            this.estado = new EstadoNormal();
        }else{ this.setVida(vidaAux);}
    }
    @Override
    public void disminuirVida(int vida, Jugador miJugador, Mapa mapa) {

        int vidaAux = this.getVidaActual() - vida;
        if (vidaAux <= 0) {
            // el edificio murio
            vidaAux=0;
            mapa.remover(this);
            miJugador.eliminarPieza(this);

        }
        else{
            this.estado = new EstadoDaniado();
        }
        this.setVida(vidaAux);
    }


    /*******************************************************
     // Metodos de Costeable
     ******************************************************/
    @Override
    public int getCosto() { return this.costo; }


}
