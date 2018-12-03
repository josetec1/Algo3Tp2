package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.NoSePuedeConstruir;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public class EstadoLibreYRecolectando implements IEstadoUnidadAldeano {


    @Override
    public void construir(Aldeano unAldeano, Edificio edificio, Mapa mapa, PosicionReal posicionReal, Jugador jugador) {
        //Chequeos
        if (!jugador.puedoAgregar(edificio) || (!mapa.puedoColocar(posicionReal,edificio.getTamanio()))
                || (!edificio.puedoConstruir()) ) {
            throw new NoSePuedeConstruir();
        }

        mapa.colocar(edificio, posicionReal);
        edificio.construir (unAldeano,jugador);


        unAldeano.cambiarAContruyendo();
    }

    @Override
    //TODO si no se puede mover por que la posicion esta ocupada, deberia responder algo!
    public void mover(Aldeano aldeano, Mapa mapa, Direccionable direccion) {
        Posicion destino = aldeano.obtenerPosicionDeAvance(direccion);
       if (mapa.puedoColocar(destino,aldeano.getTamanio())) {
            mapa.moverElemento(aldeano, destino);
            aldeano.cambiarAMoviendose();

       }
    }

    @Override
    public boolean estasDisponible() {
        return true;
    }


    @Override
    public void reparar(Aldeano aldeano, Edificio unEdificio) {

        if (!unEdificio.puedoReparar()) {throw new NoSePuedeRepararException();}
        unEdificio.reparar(aldeano);
        aldeano.cambiarAReparando(unEdificio);


    }

    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unJugador) {
        aldeano.entregarElOro(unJugador);
    }
}