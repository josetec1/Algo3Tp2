package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EnemigoSinJugadorException;
import fiuba.algo3.aoe.Ubicables.Unidades.EstoyEnDosJugadoresException;
import fiuba.algo3.aoe.Ubicables.Unidades.FuegoAmigoException;
import fiuba.algo3.aoe.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadFueraDeRangoDeAtaqueException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadMilitar;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadMilitarTropa;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public class EstadoLibreTropa implements IEstadoUnidadMilitarTropa {


    @Override
    public void pasarTurno(UnidadMilitar unidad) {
        //no hacer nada
    }

    @Override
    public void mover(UnidadMilitarTropa unidad, Mapa mapa, Direccionable direccion) {
        Posicion destino = unidad.obtenerPosicionDeAvance(direccion);
        if (mapa.puedoColocar(destino,unidad.getTamanio())) {
            mapa.moverElemento(unidad, destino);
            unidad.setMoviendose();


        }
    }

    public void atacar(UnidadMilitarTropa unidad, Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa){

        if (!miJugador.esMio(unidad)){throw new NoEsMiJugadorException();}
        if (miJugador.esMio(objetivoEnemigo)){throw new FuegoAmigoException();}

        if (jugadorEnemigo.esMio(unidad)){throw new EstoyEnDosJugadoresException();}
        if (!jugadorEnemigo.esMio(objetivoEnemigo)){throw new EnemigoSinJugadorException();}


        if(!(unidad.getDistanciaAtaque() >= unidad.getPosicion().distancia(objetivoEnemigo.getPosicion()))) {
            throw new UnidadFueraDeRangoDeAtaqueException();
        }
        objetivoEnemigo.serAtacadoPor(unidad,jugadorEnemigo,mapa);

        unidad.setAtacando();

    }

    @Override
    public boolean estasDisponible() {
        return true;
    }
}
