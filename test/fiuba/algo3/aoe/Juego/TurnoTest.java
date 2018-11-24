package fiuba.algo3.aoe.Juego;

import fiuba.algo3.aoe.Juego.Turno.*;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicio;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioEspecifico;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.Jugadores.Jugador;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class TurnoTest {

    @Test
    public void test01CrearTurnoInicializaTurnoConNumero1SiUsoFirstParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        Jugador jugador1 = new Jugador("Mauricio");
        Jugador jugador2 = new Jugador("Jose");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertEquals(turno.getJugadorActual(),jugador1);
    }

    @Test
    public void test02CrearTurnoInicializaTurnoConNumero2SiUsoSecondParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        Jugador jugador1 = new Jugador("Mauricio");
        Jugador jugador2 = new Jugador("Jose");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.SECOND);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertEquals(turno.getJugadorActual(),jugador2);
    }

    @Test
    public void test03CrearTurnoConInicioRandomLuegoDeMuchasIteracionesElJugadorInicialEsElUnoYElDos(){

        List<Jugador> jugadores = new ArrayList <>();
        Jugador jugador1 = new Jugador("Diego");
        Jugador jugador2 = new Jugador("Maradona");
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ModoInicio inicioRandom;
        Turno turno;
        boolean j1Empezo=false;
        boolean j2Empezo=false;


        for (int i = 0; i <100 ; i++) {
            inicioRandom= new ModoInicioRandom();
            turno = new Turno(jugadores,inicioRandom);
            if (turno.getJugadorActual() == jugador1) {j1Empezo= true;}
            if (turno.getJugadorActual() == jugador2) {j2Empezo= true;}
        }

        Assert.assertTrue(j1Empezo && j2Empezo);
     }


    @Test
    public void test04SePasaTurnoYRecibeComoJugadorActualAlJugador2(){

        List<Jugador> jugadores = new ArrayList <>();
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        Jugador jugador1 = new Jugador("Mauricio");
        Jugador jugador2 = new Jugador("Jose");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores,inicioFirst);
        turno.pasarTurno();
        Assert.assertEquals(turno.getJugadorActual(),jugador2);
    }

    @Test
    public void test05LuegoDePasarDosTurnosElJugadorActualVuelveASerConElQueEmpezo(){

        List<Jugador> jugadores = new ArrayList <>();
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        Jugador jugador1 = new Jugador("Mauricio");
        Jugador jugador2 = new Jugador("Jose");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores,inicioFirst);
        Jugador jugadorConElQueEmpezo = turno.getJugadorActual();

        turno.pasarTurno();
        turno.pasarTurno();
        Assert.assertEquals(turno.getJugadorActual(),jugadorConElQueEmpezo);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test06InicializarTurnoConListaDeJugadoresVaciaLanzajugadoresInvalidosExeption(){

        List<Jugador> jugadores = new ArrayList <>();
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores,inicioFirst);
    }

    @Test
    public void test07InicializarTurnoConListaDeJugadoresConUnJugadorLanzajugadoresInvalidosExeption(){
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        Jugador jugador1 = new Jugador("Mauricio");
        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores,inicioFirst);
    }

    @Test
    public void test08InicializarTurnoConListaDeJugadoresDeMasDeDosJugadoresLanzajugadoresInvalidosExeption(){
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        Jugador jugador1 = new Jugador("Mauricio");
        Jugador jugador2 = new Jugador("Maradona");
        Jugador jugadorQueSobra = new Jugador("Messi");
        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugadorQueSobra);

        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores,inicioFirst);
    }







/*
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

    }*/
}
