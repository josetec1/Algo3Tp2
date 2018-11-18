package fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoEsperandoParaAtacar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovilMilitar;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Espadachin extends UnidadMovilMilitar {

    public Espadachin(  ){

        this.vidaActual = 100;
        this.vidaMaxima = 100;
        this.costo = 50;
        this.estadoUnidad = new EstadoEsperandoParaAtacar();
    }

    public int getVidaMaxima(){return this.vidaMaxima;}

    public int getVidaActual(){return this.vidaActual;}

    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }

    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {

    }
}