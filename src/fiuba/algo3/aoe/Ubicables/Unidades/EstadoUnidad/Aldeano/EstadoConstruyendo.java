package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.AldeanoOcupadoException;

public class EstadoConstruyendo implements IEstadoUnidadAldeano {

    private final int TURNOS_DE_CONSTRUCCION = 3;

    private int turnosRestantes;

    public EstadoConstruyendo(){
        this.turnosRestantes = TURNOS_DE_CONSTRUCCION;
    }

    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unJugador) {
        this.turnosRestantes -=1;
        if( this.turnosRestantes ==0) {aldeano.cambiarARecolectando();}
    }

    @Override
    public void construir(Aldeano unAldeano, Edificio unEdificio) {
        throw new AldeanoOcupadoException();
    }
/*
    @Override
    public Boolean puedoConstruirOReparar() {
        return false;
    }
*/
    @Override
    public void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion) {
        throw new AldeanoOcupadoException();
    }

    @Override
    public boolean estasDisponible() {
        return false;
    }
/*
    @Override

    public Boolean podesMoverte() {
        return false;
    }
*/
    @Override
    public void reparar(Aldeano unidad, Edificio unEdificio) {
        throw new AldeanoOcupadoException();
    }


}
