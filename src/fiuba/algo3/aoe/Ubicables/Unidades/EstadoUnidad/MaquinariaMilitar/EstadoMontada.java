package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadFueraDeRangoDeAtaqueException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadSinPosicionException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;

public class EstadoMontada implements IEstadoMaquinariaMilitar{

    public void mover ( Mapa mapa, Direccionable direccion, ArmaDeAsedio armaDeAsedio ) {
        throw new DebeDesmontarsePrimeroException ();
    }

    @Override
    public void nuevoTurno ( ArmaDeAsedio unidadMaquinaria ) { }
/*
    public void atacar ( ArmaDeAsedio armaDeAsedio, int distanciaAtaque,
                         Manipulable receptorDelAtaque, Jugador jugadorAtacante, Jugador jugadorEnemigo, Mapa mapa ) {

        if(!jugadorAtacante.esMio(armaDeAsedio))
            throw new NoEsMiJugadorException(); // TODO reever esta excepcion

        if(!jugadorEnemigo.esMio(receptorDelAtaque))
            throw new NoEsMiJugadorException(); // TODO reveer esta excepcion

        if(distanciaAtaque >= armaDeAsedio.getPosicion ().distancia(receptorDelAtaque.getPosicion()))
            receptorDelAtaque.serAtacadoPor(armaDeAsedio);

        else
            throw new UnidadFueraDeRangoDeAtaqueException();

        if(receptorDelAtaque.getVidaActual() == 0){
            mapa.remover(receptorDelAtaque);
            jugadorEnemigo.eliminarPieza(receptorDelAtaque);
        }
    }
*/
    @Override
    public boolean puedeMoverse () {
        return false;
    }

    @Override
    public boolean puedeAtacar () {
        return true;
    }

    @Override
    public void atacar(ArmaDeAsedio armaDeAsedio, int distanciaAtaque, Manipulable receptorDelAtaque, Jugador atacante, Jugador jugadorAtacante, Mapa mapa) {

    }
}
