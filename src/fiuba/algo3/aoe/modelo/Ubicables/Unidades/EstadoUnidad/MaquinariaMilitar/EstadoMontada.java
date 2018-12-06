package fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EnemigoSinJugadorException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstoyEnDosJugadoresException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.FuegoAmigoException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.NoEsMiJugadorException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.UnidadFueraDeRangoDeAtaqueException;

public class EstadoMontada implements IEstadoMaquinariaMilitar{

    public void mover (Mapa mapa, Direccionable direccion, ArmaDeAsedio armaDeAsedio ) {
        throw new DebeDesmontarsePrimeroException ();
    }

    @Override
    public void nuevoTurno ( ArmaDeAsedio unidadMaquinaria ) { }

    public void atacar (ArmaDeAsedio armaDeAsedio,Atacable objetivoEnemigo, Jugador miJugador, Jugador jugadorEnemigo, Mapa mapa ) {


        if (!miJugador.esMio(armaDeAsedio)){throw new NoEsMiJugadorException();}
        if (miJugador.esMio(objetivoEnemigo)){throw new FuegoAmigoException();}

        if (jugadorEnemigo.esMio(armaDeAsedio)){throw new EstoyEnDosJugadoresException();}
        if (!jugadorEnemigo.esMio(objetivoEnemigo)){throw new EnemigoSinJugadorException();}

        if(!(armaDeAsedio.getDistanciaAtaque() >= armaDeAsedio.getPosicion().distancia(objetivoEnemigo.getPosicion()))) {
            throw new UnidadFueraDeRangoDeAtaqueException();
        }

        objetivoEnemigo.serAtacadoPor(armaDeAsedio,jugadorEnemigo,mapa);

    }

    @Override
    public boolean puedeMoverse () {
        return false;
    }

    @Override
    public boolean puedeAtacar () {
        return true;
    }


}
