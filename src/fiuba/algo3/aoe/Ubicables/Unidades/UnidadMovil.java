package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public abstract class UnidadMovil implements Ubicable {
    protected Posicion posicion;
    protected Jugador jugador;
    protected int vidaMaxima;
    protected int costo;
    protected int vidaActual;

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
    public abstract void mover(Mapa mapa, Direccionable direccion);

}