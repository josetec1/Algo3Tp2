package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Militar;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.UnidadYaRealizoMovimientoEsteTurnoException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.UnidadMilitar;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.UnidadMilitarTropa;

public class EstadoAtacandoTropa implements IEstadoUnidadMilitarTropa {




    @Override
    public void pasarTurno(UnidadMilitar unidad) {

    }

    @Override
    public void mover(UnidadMilitarTropa unidad, Mapa mapa, Direccionable direccion) {
        throw new UnidadYaRealizoMovimientoEsteTurnoException();

    }


    public void atacar(UnidadMilitarTropa unidad, Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa){
        throw new UnidadYaRealizoMovimientoEsteTurnoException ();}

    @Override
    public boolean estasDisponible() {
        return false;
    }
}
