package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoLibreTropa;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitarTropa;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Arquero extends UnidadMilitarTropa {

    public Arquero(  ){
        this.vidaActual = 75;
        this.vidaMaxima = 75;
        this.costo = 75;
        this.danioEdificio = 10;
        this.danioUnidad = 15;
        this.distanciaAtaque = 3;

        this.estado = new EstadoLibreTropa();
    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }

    @Override  //TODO REVISAR ESTO POR QUE ESTA REPETIDO EN OTROS LADOS Y ALGO TENES QUE HACER SI NO SE PUEDE MOVER
    public void mover(Mapa mapa, Direccionable direccion, Jugador jugador) {
        Posicion destino = this.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino,this.tamanio)) {
            mapa.moverElemento(this, destino);

        }
    }
}