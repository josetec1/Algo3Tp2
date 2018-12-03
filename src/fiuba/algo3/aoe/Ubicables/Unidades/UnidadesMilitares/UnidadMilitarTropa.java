package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoLibreTropa;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.EstadoMoviendoseTropa;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Militar.IEstadoUnidadMilitarTropa;
import fiuba.algo3.aoe.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;


public abstract class UnidadMilitarTropa extends UnidadMilitar {

    protected IEstadoUnidadMilitarTropa estado;

    public UnidadMilitarTropa(Posicion posicion, int vidaMaxima, int costo, int danioUnidad, int danioEdificio, int distanciaAtaque) {
        super(posicion, vidaMaxima, costo, danioUnidad, danioEdificio, distanciaAtaque);
        this.estado = new EstadoLibreTropa();
    }

    @Override
    public void mover(Mapa mapa, Direccionable direccion, Jugador jugador) {
        if (!jugador.esMio(this)) {throw new NoEsMiJugadorException();}
        this.estado.mover (this, mapa, direccion);

    }

    public boolean estasDisponible() {
        return false;
    }
    public void setMoviendose(){this.estado= new EstadoMoviendoseTropa();}



    /*******************************************************
     // Metodos de Notificable
    ******************************************************/
        @Override
        public void huboUnCambioDeTurno(Jugador jugador) {
         // TODO IMPLEMENTAR throw  new FaltaImplementarException();
        }

    /*******************************************************
     // Metodos de Atacante
     ******************************************************/
    @Override
    public void atacar(Atacable objetivoEnemigo,Jugador miJugador,Jugador jugadorEnemigo, Mapa mapa){
        if (!miJugador.esMio(this)){throw new NoEsMiJugadorException();}
        if(!(this.getDistanciaAtaque() >= this.getPosicion().distancia(objetivoEnemigo.getPosicion()))) {
            throw new UnidadFueraDeRangoDeAtaqueException();
        }
        objetivoEnemigo.serAtacadoPor(this,miJugador,jugadorEnemigo,mapa);
    }
}
