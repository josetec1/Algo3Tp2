package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JuegoAoETest {
    private Castillo castillo= new Castillo();
    private Jugador jugador1;
    private Jugador jugador2;
    private JuegoAoE juego;
/*
    @Before
    public void setUp(){

        jugador1 = new Jugador("pepe",castillo );
        jugador2 = new Jugador("Maria",castillo );

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
        Jugador jugador = juego.getJugadorActivo();

        juego.pasarJugada();

        Jugador otroJugador = juego.getJugadorActivo();

        Assert.assertNotEquals(jugador,otroJugador);
    }

    @Test
    public void test04AlpasarDosVecesDeJugadorElJugadorEsElMismo(){

        juego.inicializar(50,50);
        Jugador jugador = juego.getJugadorActivo();

        juego.pasarJugada();
        juego.pasarJugada();

        Jugador otroJugador = juego.getJugadorActivo();

        Assert.assertEquals(jugador,otroJugador);
    }
*/
}
