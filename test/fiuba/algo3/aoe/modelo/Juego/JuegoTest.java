package fiuba.algo3.aoe.modelo.Juego;

import fiuba.algo3.aoe.modelo.Juego.estadoJuego.JuegoEnCursoException;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Observadores.ObservadorJuego;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class JuegoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test

    public void test01JuegoCrearSeCreaCorrectamenteconTamanioMenor13x12(){

        Juego juego = new Juego("Maradona","Messi",13,12);
        Assert.assertFalse(juego.finalizo());

    }

    @Test
    public void test02JuegoCrearDebeLanzarExcepcionSiSeIndicaAnchoMenorA13(){

        thrown.expect(TamanioJuegoInvalidoException.class);
        Juego juego = new Juego("Maradona","Messi",11,12);
    }

    @Test
    public void test03JuegoCrearDebeLanzarExcepcionSiSeIndicaTamanioAltoMenorA12(){

        thrown.expect(TamanioJuegoInvalidoException.class);
        Juego juego = new Juego("Maradona","Messi",13,11);
    }

    @Test
    public void test04AlCrearJuegoDe100x150ElMapaEsDe100x150(){
        Juego juego = new Juego("Maradona","Messi",100,150);

        Mapa mapa = juego.getMapa();

        Assert.assertThat(mapa.getAncho(),is(100));
        Assert.assertThat(mapa.getAlto(),is(150));

    }


    @Test
    public void test05JuegoNoFinalizadoDebeLanzarExcepcionSiSePideElGanador(){

        Juego juego = new Juego("Maradona","Messi",13,15);

        thrown.expect(JuegoEnCursoException.class);
        juego.getWinner();

    }
    @Test
    public void test06FinalizoDebeDarFalseSiElJuegoNoFinalizo(){
        Juego juego = new Juego("Maradona","Messi",13,15);

        Assert.assertFalse(juego.finalizo());

    }
    @Test
    public void test06FinalizoDebeDarTrueSiElJuegoFinalizo(){
        Juego juego = new Juego("Maradona","Messi",13,15);
        juego.castilloEliminado();
        Assert.assertTrue(juego.finalizo());

    }

    @Test
    public void test07PasarJugadaDevuelveUnJugadorActivoDistinto(){

        Juego juego = new Juego("Maradona","Messi",13,15);
        Jugador jugador = juego.getJugadorActual();

        juego.pasarJugada();

        Assert.assertNotSame( jugador , juego.getJugadorActual() );

    }

    @Test
     public void test08CastilloEliminadoFinalizaEljuego(){
        Juego juego = new Juego("Maradona","Messi",13,15);

        juego.castilloEliminado();

        Assert.assertTrue(juego.finalizo());
    }

    @Test
     public void test09AlFinalizarElJuegoElGanadorEsElJugadorActivo(){

        Juego juego = new Juego("Maradona","Messi",13,15);
        Jugador jugador = juego.getJugadorActual();
        juego.castilloEliminado();

        Assert.assertThat(jugador,is(juego.getWinner()));
     }

    @Test
    public void test10PasarJugadaNotificaAObservadores(){

        Juego juego = new Juego("Maradona","Messi",13,15);

        ObservadorJuego unObservador = Mockito.mock(ObservadorJuego.class);
        juego.agregarObservador(unObservador);
        juego.pasarJugada();

        verify(unObservador, times(1)).actualizar();
    }

    @Test
    public void test11CastilloEliminadoNotificaAObservadores(){

        Juego juego = new Juego("Maradona","Messi",13,15);
        ObservadorJuego unObservador = Mockito.mock(ObservadorJuego.class);
        juego.agregarObservador(unObservador);

        juego.castilloEliminado();

        verify(unObservador, times(1)).actualizar();
    }
}
