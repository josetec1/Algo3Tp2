package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;

public class EstadoAtacando {

    IEstadoMaquinariaMilitar estadoAnterior;

    public  EstadoAtacando(IEstadoMaquinariaMilitar estadoAnterior){
        this.estadoAnterior = estadoAnterior;
    }
    public void mover(Mapa mapa, Direccionable direccionable , ArmaDeAsedio armaDeAsedio){
        throw new UnidadYaRealizoMovimientoEsteTurnoException ();
    }


    public void nuevoTurno( ArmaDeAsedio armaDeAsedio ){
        armaDeAsedio.cambiarEstado ( estadoAnterior );
    }

    public void atacar (ArmaDeAsedio armaDeAsedio, Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa ) {
        throw new UnidadYaRealizoMovimientoEsteTurnoException ();
    }

    public boolean puedeMoverse(){
        return false;
    }

    public boolean puedeAtacar () {
        return false;
    }
}
