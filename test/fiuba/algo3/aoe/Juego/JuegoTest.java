package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Juego.estadoJuego.JuegoNoIniciadoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JuegoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
/*
    @Test
    public void test01PasarJugadaDebeLanzarExcepcionSiNoEmpezoElJuego(){

        Juego juego = new Juego("Maradona","Messi",500,500);
        thrown.expect(JuegoNoIniciadoException.class);
        juego.pasarJugada();
    }
*/
    @Test  //TODO OJO CON LOS MINIMOS DEL MAPA
    public void test02EmpiezaElJuegoCorrectamente(){

        Juego juego = new Juego("Maradona","Messi",500,500);

       // thrown.expect(JuegoNoIniciadoException.class);
        //juego.e();
    }
/*
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
