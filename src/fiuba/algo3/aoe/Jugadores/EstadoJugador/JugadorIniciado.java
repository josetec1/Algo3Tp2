package fiuba.algo3.aoe.Jugadores.EstadoJugador;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;

import java.util.ArrayList;

public class  JugadorIniciado implements EstadoJugador{

    @Override
    public boolean iniciado() {
        return true;
    }
}

