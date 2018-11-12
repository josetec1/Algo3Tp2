package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import fiuba.algo3.aoe.Juego.JugadoresInvalidosException;
public class TurnoTest {

    @Test
    public void test01CrearTurnoInicializaTurnoConNumero1JugadorActualDevuelveMauricio(){

        List<Jugador> jugadores = new ArrayList <>();
        Tablero tablero = new Tablero(20,20);
        Jugador jugador1 = new Jugador("Mauricio",tablero);
        Jugador jugador2 = new Jugador("Jose",tablero);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        Assert.assertEquals(turno.getJugadorActual().getNombre(),"Mauricio");
        Assert.assertEquals(turno.getJugadorActual(),jugador1);
    }

    @Test
    public void test03CrearTurnoInicializaTurnoConNumero1DevuelveNumeroActual1(){

        List<Jugador> jugadores = new ArrayList <>();
        Tablero tablero = new Tablero(20,20);
        Jugador jugador1 = new Jugador("Mauricio",tablero);
        Jugador jugador2 = new Jugador("Jose",tablero);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        Assert.assertEquals(turno.getNumeroDeTurno(),1);
    }


    @Test
    public void test02SePasaTurnoYRecibeComoJugadorActualJose(){

        List<Jugador> jugadores = new ArrayList <>();
        Tablero tablero = new Tablero(20,20);
        Jugador jugador1 = new Jugador("Mauricio",tablero);
        Jugador jugador2 = new Jugador("Jose",tablero);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        turno.pasarTurno();
        Assert.assertEquals(turno.getJugadorActual().getNombre(),"Jose");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test04InicializarTurnoConListaDeJugadoresVaciaLanzajugadoresInvalidosExeption(){

        List<Jugador> jugadores = new ArrayList <>();
        Tablero tablero = new Tablero(20,20);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores);
    }

    @Test
    public void test05InicializarTurnoConListaDeJugadoresConUnJugadorLanzajugadoresInvalidosExeption(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador1 = new Jugador("Mauricio",tablero);
        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores);
    }

    @Test
    public void test06InicializarTurnoConListaDeJugadoresDeMasDeDosJugadoresLanzajugadoresInvalidosExeption(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador1 = new Jugador("Mauricio",tablero);
        Jugador jugador2 = new Jugador("Maradona",tablero);
        Jugador jugadorQueSobra = new Jugador("Messi",tablero);
        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugadorQueSobra);

        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores);
    }


}
