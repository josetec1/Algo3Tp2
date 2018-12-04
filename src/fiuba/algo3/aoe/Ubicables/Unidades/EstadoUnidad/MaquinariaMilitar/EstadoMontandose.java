package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;

public class EstadoMontandose implements IEstadoMaquinariaMilitar{

    public void mover( Mapa mapa, Direccionable direccionable , ArmaDeAsedio armaDeAsedio){
        throw new DebeDesmontarsePrimeroException ();
    }


    public void nuevoTurno( ArmaDeAsedio armaDeAsedio ){
        armaDeAsedio.cambiarEstado ( new EstadoMontada () );
    }

    public void atacar (ArmaDeAsedio armaDeAsedio, Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa ) {
        throw new DebeMontarsePrimeroException ();
    }

    public boolean puedeMoverse(){
        return false;
    }

    public boolean puedeAtacar () {
        return false;
    }
}
