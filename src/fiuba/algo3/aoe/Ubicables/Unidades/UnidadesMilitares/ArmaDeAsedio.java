package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.*;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.EstadoDesmontada;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.IEstadoMaquinariaMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoLibreTropa;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class ArmaDeAsedio extends UnidadMilitarMaquinaria {

    public ArmaDeAsedio(  ){
        this.vidaMaxima = 150;
        this.vidaActual = 150;
        this.costo = 200;
        this.estado = new EstadoDesmontada();
        this.distanciaAtaque = 5;
    }

    @Override
    public void mover ( Mapa mapa, Direccionable direccion, Jugador jugador ) {
        this.estado.mover ( mapa,direccion,this );
    }

    public void atacar( Manipulable receptorDelAtaque, Jugador jugadorAtacante, Jugador jugadorEnemigo, Mapa mapa){
        this.estado.atacar (this,distanciaAtaque,receptorDelAtaque,jugadorAtacante,jugadorEnemigo,mapa  );
    }



    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {
        this.estado.nuevoTurno ( this);
    }

    public void cambiarEstado ( IEstadoMaquinariaMilitar estadoAnterior ) {
        this.estado = estadoAnterior;
    }
}

//TODO Refactor unidad MilitarMaquinaria,UnidadMilitarTropaUnidadMilitar
//TODO pruebas armaDeAsedio
//Todo pruebas EstadosArmaDeAsedio