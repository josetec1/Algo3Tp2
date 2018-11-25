package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Jugadores.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JuegoAoETest {

    private Jugador jugador1;
    private Jugador jugador2;
    private JuegoAoE juego;

    @Before
    public void setUp(){

        jugador1 = new Jugador("pepe");
        jugador2 = new Jugador("Maria");

        juego = new JuegoAoE(jugador1, jugador2);

    }

    @Test
    public void test01JuegoCreado(){

        juego = new JuegoAoE(jugador1, jugador2);

        Assert.assertTrue(juego.contieneJugadores());
    }

    @Test
    public void test02InicializarJuegoLosJugadoresComienzanCon5Piezas(){

        juego.inicializar(50, 50);

        Assert.assertEquals(jugador1.getPiezas().size(), 5);
        Assert.assertEquals(jugador2.getPiezas().size(), 5);
    }

    @Test
    public void test03AlpasarDeTurnoCambiaElJugador(){

        juego.inicializar(50,50);
        Jugador jugador = juego.jugadorActual();

        juego.pasarJugada();

        Jugador otroJugador = juego.jugadorActual();

        Assert.assertNotEquals(jugador,otroJugador);
    }

    @Test
    public void test04AlpasarDosVecesDeJugadorElJugadorEsElMismo(){

        juego.inicializar(50,50);
        Jugador jugador = juego.jugadorActual();

        juego.pasarJugada();
        juego.pasarJugada();

        Jugador otroJugador = juego.jugadorActual();

        Assert.assertEquals(jugador,otroJugador);
    }

}
