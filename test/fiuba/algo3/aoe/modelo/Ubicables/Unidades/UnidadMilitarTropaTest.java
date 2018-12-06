package fiuba.algo3.aoe.modelo.Ubicables.Unidades;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionNulaException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class UnidadMilitarTropaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01MoverDebeLanzarExepcionSiNoTieneUnaPosicionPrevia(){
        Jugador jugador = Mockito.mock (Jugador.class);

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Arquero arquero = new Arquero();
        Mockito.when(jugador.esMio(arquero)).thenReturn(true);
        thrown.expect(PosicionNulaException.class);
        arquero.mover(mapa,direccion,jugador);

    }

    @Test
    public void test02MoverDebeLanzarExepcionSiNoTieneUnaPosicionPrevia(){
        Jugador jugador = Mockito.mock (Jugador.class);

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Espadachin espadachin = new Espadachin();
        Mockito.when(jugador.esMio(espadachin)).thenReturn(true);
        thrown.expect(PosicionNulaException.class);
        espadachin.mover(mapa,direccion,jugador);

    }
}
