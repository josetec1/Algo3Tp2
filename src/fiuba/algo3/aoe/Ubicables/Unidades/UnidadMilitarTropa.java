package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoMoviendoseTropa;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.IEstadoUnidadMilitarTropa;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.beans.InvalidationListener;

public abstract class UnidadMilitarTropa extends UnidadMilitar{

    protected IEstadoUnidadMilitarTropa estado;

    @Override
    public void mover(Mapa mapa, Direccionable direccion, Jugador jugador) {
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.mover (this, mapa, direccion);
    }

    public boolean estasDisponible() {
        return false;
    }

    @Override
    public void huboUnCambioDeTurno(Jugador jugador) {

    }
    public void setMoviendose(){this.estado= new EstadoMoviendoseTropa();}


}
