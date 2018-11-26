package fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.Manipulable;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;

public class EstadoDesmontandose implements IEstadoMaquinariaMilitar{

    public void mover( Mapa mapa, Direccionable direccionable , ArmaDeAsedio armaDeAsedio){
        throw new UnidadYaRealizoMovimientoEsteTurnoException ();
    }


    public void nuevoTurno( ArmaDeAsedio armaDeAsedio ){
        armaDeAsedio.cambiarEstado ( new EstadoDesmontada () );
    }

    public void atacar ( ArmaDeAsedio armaDeAsedio, int distanciaAtaque,
                         Manipulable receptorDelAtaque, Jugador atacante, Jugador jugadorAtacante, Mapa mapa ) {
        throw new UnidadYaRealizoMovimientoEsteTurnoException ();
    }

    public boolean puedeMoverse(){
        return false;
    }

    public boolean puedeAtacar () {
        return false;
    }
}
