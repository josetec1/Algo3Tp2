package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class TurnoTest {

    @Test
    public void test01CrearTurnoInicializaTurnoConNumero1JugadorActualDevuelveMauricio(){

        List<Jugador> jugadores = new ArrayList <>();
       Mapa mapa = new Mapa(20,20);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        Jugador jugador2 = new Jugador("Jose", mapa);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);

        Assert.assertEquals(turno.getJugadorActual(),jugador1);
    }

    @Test
    public void test02CrearTurnoInicializaTurnoConNumero1DevuelveNumeroActual1(){

        List<Jugador> jugadores = new ArrayList <>();
        Mapa mapa = new Mapa(20,20);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        Jugador jugador2 = new Jugador("Jose", mapa);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        Assert.assertEquals(turno.getNumeroDeTurno(),1);
    }


    @Test
    public void test03SePasaTurnoYRecibeComoJugadorActualAlJugador2(){

        List<Jugador> jugadores = new ArrayList <>();
        Mapa mapa = new Mapa(20,20);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        Jugador jugador2 = new Jugador("Jose", mapa);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        turno.pasarTurno();
        Assert.assertEquals(turno.getJugadorActual(),jugador2);
    }

    @Test
    public void test04LuegoDePasarDosTurnosElJugadorActualVuelveASerConElQueEmpezo(){

        List<Jugador> jugadores = new ArrayList <>();
        Mapa mapa = new Mapa(20,20);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        Jugador jugador2 = new Jugador("Jose", mapa);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        Jugador jugadorConElQueEmpezo = turno.getJugadorActual();

        turno.pasarTurno();
        turno.pasarTurno();
        Assert.assertEquals(turno.getJugadorActual(),jugadorConElQueEmpezo);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test04InicializarTurnoConListaDeJugadoresVaciaLanzajugadoresInvalidosExeption(){

        List<Jugador> jugadores = new ArrayList <>();
        Mapa mapa = new Mapa(20,20);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores);
    }

    @Test
    public void test05InicializarTurnoConListaDeJugadoresConUnJugadorLanzajugadoresInvalidosExeption(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores);
    }

    @Test
    public void test06InicializarTurnoConListaDeJugadoresDeMasDeDosJugadoresLanzajugadoresInvalidosExeption(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        Jugador jugador2 = new Jugador("Maradona", mapa);
        Jugador jugadorQueSobra = new Jugador("Messi", mapa);
        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugadorQueSobra);

        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores);
    }


}
