package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TurnoTest {

    @Test
    public void test01CrearTurnoInicializaTurnoConNumero1JugadorActual(){

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
    public void test02SePasaTurnoYRecibeComoJugadorActualAlJugador2(){

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
    public void test03LuegoDePasarDosTurnosElJugadorActualVuelveASerConElQueEmpezo(){

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


    @Test
    public void test07CrearTurnoNotificaAlJugadorUnoQueEstaHabilitado(){

        List<Jugador> jugadores = new ArrayList <>();


        Jugador jugador1 = Mockito.mock(Jugador.class);
        Jugador jugador2 = Mockito.mock(Jugador.class);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);

        verify(jugador1, times(1)).habilitar();
        verify(jugador2, times(0)).habilitar();

    }

    @Test
    public void test08PasarTurnoNotificaAlJugadorAnteriorComoDeshabilitadoYHabilitadoAlSiguiente(){

        List<Jugador> jugadores = new ArrayList <>();


        Jugador jugador1 = Mockito.mock(Jugador.class);
        Jugador jugador2 = Mockito.mock(Jugador.class);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        turno.pasarTurno();

        verify(jugador1, times(1)).deshabilitar();
        verify(jugador2, times(1)).habilitar();

    }

    @Test
    public void test09PasarDosTurnosNotificaAlPrimerJugadorDosVecesHabilitadoYUnaVezDeshabilitado(){

        List<Jugador> jugadores = new ArrayList <>();


        Jugador jugador1 = Mockito.mock(Jugador.class);
        Jugador jugador2 = Mockito.mock(Jugador.class);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores);
        turno.pasarTurno();
        turno.pasarTurno();

        verify(jugador1, times(1)).deshabilitar();
        verify(jugador1, times(2)).habilitar();

        verify(jugador2, times(1)).habilitar();
        verify(jugador2, times(1)).deshabilitar();

    }
}
