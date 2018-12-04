package fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares;

import fiuba.algo3.aoe.FaltaImplementarException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.EstadoDesmontada;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.EstadoDesmontandose;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.EstadoMontandose;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.IEstadoMaquinariaMilitar;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

public class ArmaDeAsedio extends UnidadMilitar{
    protected IEstadoMaquinariaMilitar estado;

    public ArmaDeAsedio() {
        super(new PosicionNula(), 150, 200, 75, 75, 5);
        this.estado = new EstadoDesmontada();
    }

    @Override
    public void mover ( Mapa mapa, Direccionable direccion , Jugador jugador) {
        this.estado.mover ( mapa,direccion,this );
    }

    public void cambiarEstado ( IEstadoMaquinariaMilitar estado ) {
        this.estado = estado;
    }
    public boolean puedeMoverse(){
        return this.estado.puedeMoverse ();
    }
    public boolean puedeAtacar(){
        return this.estado.puedeAtacar ();
    }
    public void montar(){
        this.cambiarEstado ( new EstadoMontandose () );
    }
    public void desmontar(){
        this.cambiarEstado ( new EstadoDesmontandose () );
    }

    /*******************************************************
     // Metodos de Notificable
     ******************************************************/
    @Override
    public void huboUnCambioDeTurno(Jugador unJugador) {this.estado.nuevoTurno ( this);}

    /*******************************************************
     // Metodos de Atacante
     ******************************************************/

    @Override
    public void atacar(Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa) {
        this.estado.atacar(this,objetivoEnemigo,miJugador,jugadorEnemigo,mapa);

    }

    //todo refactor
    @Override
    public boolean puedoAtacar(Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa) {
        if  (this.estado.puedeAtacar()){

            if (!miJugador.esMio(this)){return false;}
            if (miJugador.esMio(objetivoEnemigo)){return false;}

            if (jugadorEnemigo.esMio(this)){return false;}
            if (!jugadorEnemigo.esMio(objetivoEnemigo)){return false;}


            if(!(this.getDistanciaAtaque() >= this.getPosicion().distancia(objetivoEnemigo.getPosicion()))) {
                return false;
            }
            return true;

        }
        return false;
    }


}

