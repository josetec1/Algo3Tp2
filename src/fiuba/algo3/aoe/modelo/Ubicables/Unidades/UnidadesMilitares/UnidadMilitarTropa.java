package fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares;


import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Militar.EstadoAtacandoTropa;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Militar.EstadoLibreTropa;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Militar.EstadoMoviendoseTropa;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.Militar.IEstadoUnidadMilitarTropa;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;


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
        return this.estado.estasDisponible(); //todo implementar esto que esta mal  refac001

    }
    public void setMoviendose(){this.estado= new EstadoMoviendoseTropa();}
    public void setAtacando () {this.estado= new EstadoAtacandoTropa();}


    /*******************************************************
     // Metodos de Notificable
    ******************************************************/
        @Override
        public void huboUnCambioDeTurno(Jugador jugador) {
          this.estado = new EstadoLibreTropa();
        }

    /*******************************************************
     // Metodos de Atacante
     ******************************************************/

    public void atacar(Atacable objetivoEnemigo,Jugador miJugador,Jugador jugadorEnemigo, Mapa mapa){

        this.estado.atacar (this, objetivoEnemigo, miJugador, jugadorEnemigo,  mapa);
    }

    //todo refactor
    public boolean puedoAtacar(Atacable objetivoEnemigo, Jugador miJugador,Jugador jugadorEnemigo, Mapa mapa){

        if (this.estado.estasDisponible()) {

            if (!miJugador.esMio(this)) {
                return false;
            }
            if (miJugador.esMio(objetivoEnemigo)) {
                return false;
            }

            if (jugadorEnemigo.esMio(this)) {
                return false;
            }
            if (!jugadorEnemigo.esMio(objetivoEnemigo)) {
                return false;
            }
            //Todo si es una PosicionNula, te va a dar una excepcion aca, hay que hacer un try
            if (!(this.getDistanciaAtaque() >= this.getPosicion().distancia(objetivoEnemigo.getPosicion()))) {
                return false;
            }
            return true;
        }
        return false;

    }
}
