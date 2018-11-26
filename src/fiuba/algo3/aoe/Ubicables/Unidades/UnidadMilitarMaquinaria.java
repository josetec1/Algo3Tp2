package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.IEstadoMaquinariaMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;

public abstract class UnidadMilitarMaquinaria extends UnidadMilitar {

    protected IEstadoMaquinariaMilitar estado;


    public abstract void mover(Mapa mapa, Direccionable direccion);


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
