package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;

public interface IEstadoMaquinariaMilitar {

    void mover (Mapa mapa, Direccionable direccion, ArmaDeAsedio armaDeAsedio );

    void nuevoTurno( ArmaDeAsedio unidadMaquinaria);

    boolean puedeMoverse ();

    boolean puedeAtacar();

    void atacar (ArmaDeAsedio armaDeAsedio, Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa );

}
