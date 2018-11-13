package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;

import fiuba.algo3.aoe.Ubicables.ObservadorTurno;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.EstadoUnidad;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class UnidadMovil implements Ubicable, ObservadorTurno {
    protected Posicion posicion;
    protected Jugador jugador;
    protected int vidaMaxima;
    protected int costo;
    protected int vidaActual;
    protected int cuentaRegresiva ; // TODO , esto lo uso para los cambios de estado que dependen de turnos ver si amerita en unidad militar

    public int getCosto(){
        return this.costo;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void colocarEn(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion obtenerPosicionDeAvance( Direccionable direccionable ){

        return this.posicion.calcularPosicionSiguiente(direccionable);
    }

    public boolean perteneceAJugador(Jugador jugador){
        return (this.jugador == jugador);
    }

    //TODO: si no se puede mover por que la posicion esta ocupada, tendria que hacer algo, retornar un bool
    // y usar eso para volvera intentar otra cosa, o enviar un mensaje "ahi no me puedo mover"
    public  void mover(Mapa mapa, Direccionable direccion) {
        Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino)) {
            mapa.moverElemento(this, destino);
        }
    }

    // es para los estados.
    public void establecerCuentaRegresiva( int numero ){

        this.cuentaRegresiva= numero;
    }

    public int getCuentaRegresiva( ){

        return this.cuentaRegresiva;
    }
}