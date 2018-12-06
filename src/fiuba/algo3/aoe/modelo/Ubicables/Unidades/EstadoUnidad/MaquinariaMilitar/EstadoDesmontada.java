package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;

public class EstadoDesmontada implements IEstadoMaquinariaMilitar {


    public void mover (Mapa mapa, Direccionable direccion , ArmaDeAsedio armaDeAsedio ) {
        Posicion destino = armaDeAsedio.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino,armaDeAsedio.getTamanio ())) {
            mapa.moverElemento(armaDeAsedio, destino);


        }
        armaDeAsedio.cambiarEstado ( new EstadoMoviendose (this) );
    }

    public void nuevoTurno ( ArmaDeAsedio unidadMaquinaria ) {}


    public void atacar (ArmaDeAsedio armaDeAsedio, Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa) {
        throw new DebeMontarsePrimeroException ();
    }


    public boolean puedeMoverse () {
    return true;
    }


    public boolean puedeAtacar () {
        return false;
    }
}
