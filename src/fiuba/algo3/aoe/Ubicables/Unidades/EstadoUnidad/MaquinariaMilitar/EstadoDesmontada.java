package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class EstadoDesmontada implements IEstadoMaquinariaMilitar {


    public void mover ( Mapa mapa, Direccionable direccion , ArmaDeAsedio armaDeAsedio ) {
        Posicion destino = armaDeAsedio.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino,armaDeAsedio.getTamanio ())) {
            mapa.moverElemento(armaDeAsedio, destino);
            //armaDeAsedio.notifyObservers();

        }
        armaDeAsedio.cambiarEstado ( new EstadoMoviendose (this) );
    }

    public void nuevoTurno ( ArmaDeAsedio unidadMaquinaria ) {}


    public void atacar ( ArmaDeAsedio armaDeAsedio, int distanciaAtaque,
                         Manipulable receptorDelAtaque, Jugador atacante, Jugador jugadorEnemigo, Mapa mapa ) {
        throw new DebeMontarsePrimeroException ();
    }


    public boolean puedeMoverse () {
    return true;
    }


    public boolean puedeAtacar () {
        return false;
    }
}
