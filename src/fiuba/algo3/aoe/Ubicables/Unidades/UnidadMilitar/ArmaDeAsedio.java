package fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoEsperandoParaAtacar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovilMilitar;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class ArmaDeAsedio extends UnidadMovilMilitar {

    public ArmaDeAsedio( Jugador jugador ){
        this.vidaMaxima = 150;
        this.vidaActual = 150;
        this.costo = 200;

        this.estadoUnidad = new EstadoEsperandoParaAtacar();
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){
        return this.vidaActual;
    }

    public void disminuirVida( int vida){
        this.vidaActual -= vida;
    }

    @Override
    public void huboUnCambioDeTurno() {

    }

}
