package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class EstadoLibreYRecolectando implements IEstadoUnidadAldeano {


    @Override
    public Edificio construir(Aldeano unAldeano, Edificio unEdificio) {
        unEdificio.construir();
        unAldeano.cambiarAContruyendo();
        return unEdificio;


    }

    @Override
    public Boolean puedoConstruirOReparar() {
        return true;
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
    public Boolean podesMoverte() {
        return true;
    }


    @Override
    public void reparar(Aldeano aldeano, Edificio unEdificio) {
        //TODO refactor la pregunta de abajo
        if (!unEdificio.estaDaniado()||unEdificio.estaEnConstruccion()||unEdificio.estaEnReparacion()) {throw new NoSePuedeRepararException();}
         aldeano.cambiarAReparando(unEdificio);

    }

    @Override
    public void pasarTurno(Aldeano aldeano, Jugador unJugador) {
        aldeano.entregarElOro(unJugador);
    }
}