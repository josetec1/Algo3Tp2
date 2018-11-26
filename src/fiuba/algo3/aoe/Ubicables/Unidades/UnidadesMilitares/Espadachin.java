package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoLibreTropa;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitarTropa;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Espadachin extends UnidadMilitarTropa {

    public Espadachin(  ){

        this.vidaActual = 100;
        this.vidaMaxima = 100;
        this.costo = 50;
        this.danioGeneradoAEdificio = 15;
        this.danioGeneradoAUnidad = 25;
        this.distanciaAtaque = 1;
        this.estado = new EstadoLibreTropa();
    }


}
