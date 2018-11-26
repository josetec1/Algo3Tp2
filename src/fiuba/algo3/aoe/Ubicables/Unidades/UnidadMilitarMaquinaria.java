package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;

import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.IEstadoMaquinariaMilitar;

//TODO esta clase hay que eliminarla por que solo sirve para el arma de asedio, que lo implemente directamente
public abstract class UnidadMilitarMaquinaria extends UnidadMilitar {

    protected IEstadoMaquinariaMilitar estado;

    public abstract void huboUnCambioDeTurno(Jugador jugador);

    public boolean puedeMoverse(){
        return this.estado.puedeMoverse ();
    }

    public boolean puedeAtacar(){
        return this.estado.puedeAtacar ();
    }


    public abstract void atacar(Manipulable receptorDelAtaque, Jugador jugadorAtacante, Jugador jugadorEnemigo, Mapa mapa);
    public void cambiarEstado ( IEstadoMaquinariaMilitar estado ) {
        this.estado = estado;
    }
}
