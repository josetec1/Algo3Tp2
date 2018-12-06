package fiuba.algo3.aoe.modelo.Ubicables.Unidades;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.UnidadYaRealizoMovimientoEsteTurnoException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionNulaException;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
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

    @Test
    public void test03estasDisponibleDebeDarFalseLuegoDeRealizarUnaAccion(){
        Jugador jugador = Mockito.mock (Jugador.class);

        Mapa mapa = new Mapa(10,10);

        Direccionable direccion = new DireccionDerecha();
        Espadachin espadachin = new Espadachin();
        Mockito.when(jugador.esMio(espadachin)).thenReturn(true);
        mapa.colocar(espadachin,new PosicionReal(2,2));
        espadachin.mover(mapa,direccion,jugador);

       Assert.assertFalse(espadachin.estasDisponible());
     }

    @Test
    public void test04estasDisponibleDebeDarTrueLuegoDeRealizarUnaAccionYCambiarDeTurno(){
        Jugador jugador = Mockito.mock (Jugador.class);

        Mapa mapa = new Mapa(10,10);

        Direccionable direccion = new DireccionDerecha();
        Espadachin espadachin = new Espadachin();
        Mockito.when(jugador.esMio(espadachin)).thenReturn(true);
        mapa.colocar(espadachin,new PosicionReal(2,2));
        espadachin.mover(mapa,direccion,jugador);

        espadachin.huboUnCambioDeTurno(jugador);
        Assert.assertTrue(espadachin.estasDisponible());
    }

    @Test
    public void test05estasDisponibleDebeDarFalseLuegoDeRealizarUnAtaque(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Jugador jugador2 = Mockito.mock (Jugador.class);
        Mapa mapa = new Mapa(10,10);

        Direccionable direccion = new DireccionDerecha();
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        Mockito.when(jugador.esMio(espadachin)).thenReturn(true);
        Mockito.when(jugador2.esMio(arquero)).thenReturn(true);
        Mockito.when(jugador.esMio(arquero)).thenReturn(false);
        Mockito.when(jugador2.esMio(espadachin)).thenReturn(false);

        mapa.colocar(espadachin,new PosicionReal(2,2));
        mapa.colocar(arquero,new PosicionReal(2,3));

        espadachin.atacar(arquero,jugador,jugador2,mapa);

        Assert.assertFalse(espadachin.estasDisponible());
    }

    @Test
    public void test06estasDisponibleDebeDarTrueLuegoDeRealizarUnAtaqueYPasarUnTurno(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Jugador jugador2 = Mockito.mock (Jugador.class);
        Mapa mapa = new Mapa(10,10);

        Direccionable direccion = new DireccionDerecha();
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        Mockito.when(jugador.esMio(espadachin)).thenReturn(true);
        Mockito.when(jugador2.esMio(arquero)).thenReturn(true);
        Mockito.when(jugador.esMio(arquero)).thenReturn(false);
        Mockito.when(jugador2.esMio(espadachin)).thenReturn(false);

        mapa.colocar(espadachin,new PosicionReal(2,2));
        mapa.colocar(arquero,new PosicionReal(2,3));

        espadachin.atacar(arquero,jugador,jugador2,mapa);

         espadachin.huboUnCambioDeTurno(jugador);
        Assert.assertTrue(espadachin.estasDisponible());
    }

    @Test
    public void test07AtacarDebeLanzarExcepcionLuegoDeRealizarUnAtaqueYQuererHacerOtroSinPasarTurno(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Jugador jugador2 = Mockito.mock (Jugador.class);
        Mapa mapa = new Mapa(10,10);

        Direccionable direccion = new DireccionDerecha();
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        Mockito.when(jugador.esMio(espadachin)).thenReturn(true);
        Mockito.when(jugador2.esMio(arquero)).thenReturn(true);
        Mockito.when(jugador.esMio(arquero)).thenReturn(false);
        Mockito.when(jugador2.esMio(espadachin)).thenReturn(false);

        mapa.colocar(espadachin,new PosicionReal(2,2));
        mapa.colocar(arquero,new PosicionReal(2,3));

        espadachin.atacar(arquero,jugador,jugador2,mapa);

        thrown.expect(UnidadYaRealizoMovimientoEsteTurnoException.class);
        espadachin.atacar(arquero,jugador,jugador2,mapa);
    }
}
