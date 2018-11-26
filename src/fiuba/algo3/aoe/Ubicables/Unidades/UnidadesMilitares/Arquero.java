package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoLibreTropa;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitarTropa;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Arquero extends UnidadMilitarTropa {

    public Arquero(  ){
        this.vidaActual = 75;
        this.vidaMaxima = 75;
        this.costo = 75;
        this.danioGeneradoAEdificio = 10;
        this.danioGeneradoAUnidad = 15;
        this.distanciaAtaque = 3;
        this.estado = new EstadoLibreTropa();
    }

}