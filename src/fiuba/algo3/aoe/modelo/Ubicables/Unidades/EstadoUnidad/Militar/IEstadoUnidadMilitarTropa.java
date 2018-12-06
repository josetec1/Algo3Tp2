package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Militar;


import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.UnidadMilitar;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.UnidadMilitarTropa;

public interface IEstadoUnidadMilitarTropa {

    void pasarTurno (UnidadMilitar unidad);

    void mover(UnidadMilitarTropa unidad, Mapa mapa, Direccionable direccion);

    void atacar(UnidadMilitarTropa unidad, Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa);

    boolean estasDisponible ();
}
