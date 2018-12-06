package fiuba.algo3.aoe.modelo.Juego;

import fiuba.algo3.aoe.modelo.Juego.Turno.ModosDeInicio.ModoInicio;
import fiuba.algo3.aoe.modelo.Juego.Turno.ModosDeInicio.ModoInicioEspecifico;
import fiuba.algo3.aoe.modelo.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.modelo.Juego.Turno.TipoOrden;
import fiuba.algo3.aoe.modelo.Juego.Turno.Turno;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TurnoTest {

    private Castillo castillo= new Castillo();
    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private PlazaCentral plaza;
    private Jugador jugador1;
    private Jugador jugador2;

    @Before
    public void setUp(){
        plaza = new PlazaCentral();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());

    }




    @Test
    public void test01CrearTurnoInicializaTurnoConNumero1SiUsoFirstParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertEquals(turno.getJugadorActual(),jugador1);
    }

    @Test
    public void test02CrearTurnoInicializaTurnoConNumero2SiUsoSecondParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.SECOND);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertEquals(turno.getJugadorActual(),jugador2);
    }

    @Test
    public void test03CrearTurnoConInicioRandomLuegoDeMuchasIteracionesElJugadorInicialEsElUnoYElDos(){

        List<Jugador> jugadores = new ArrayList <>();
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
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
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
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
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
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
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores,inicioFirst);
    }

    @Test
    public void test08InicializarTurnoConListaDeJugadoresDeMasDeDosJugadoresLanzajugadoresInvalidosExeption(){
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);

        Jugador jugadorQueSobra = new Jugador("Messi",castillo,plaza,aldeanos);

        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugadorQueSobra);

        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores,inicioFirst);
    }

    @Test
    public void test09InicializarTurnoConListaDeJugadoresConDosJugadoresIgualesDebeLanzajugadoresInvalidosExeption(){
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        List<Jugador> jugadores = new ArrayList <>();
        jugadores.add(jugador1);
        jugadores.add(jugador1);
        thrown.expect(JugadoresInvalidosException.class);
        Turno turno = new Turno(jugadores,inicioFirst);
    }

    @Test
        public void test10GetJugadorInactivoDebeDevolverAlSegundoJugadorAlCrearTurnoConFirstParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertEquals(turno.getJugadorInactivo(),jugador2);
    }

    @Test
    public void test11GetJugadorInactivoDebeDevolverAlPrimerJugadorAlCrearTurnoConSecondParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.SECOND);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertEquals(turno.getJugadorInactivo(),jugador1);
    }

    @Test
    public void test12GetJugadorInactivoNoEsIgualAlJugadorActivoAlCrearTurnoConSecondParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.SECOND);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertThat(turno.getJugadorInactivo(),is(not(turno.getJugadorActual())));
    }

    @Test
    public void test13GetJugadorInactivoNoEsIgualAlJugadorActivoAlCrearTurnoConFirstParaArrancar(){

        List<Jugador> jugadores = new ArrayList <>();

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);

        Turno turno = new Turno(jugadores,inicioFirst);

        Assert.assertThat(turno.getJugadorInactivo(),is(not(turno.getJugadorActual())));
    }

    @Test
    public void test14GetJugadorInactivoCambiaAlPasarTurno(){

        List<Jugador> jugadores = new ArrayList <>();
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Diego",castillo,plaza,aldeanos);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Turno turno = new Turno(jugadores,inicioFirst);

         turno.pasarTurno();

        Assert.assertThat(turno.getJugadorActual(),is(jugador2));
        Assert.assertThat(turno.getJugadorInactivo(),is (jugador1));

        Assert.assertThat(turno.getJugadorActual(),is(not(jugador1)));
        Assert.assertThat(turno.getJugadorInactivo(),is(not(jugador2)));

    }


    @Test
    public void test15CrearTurnoNONotificaAlJugadorUnoQueEstaHabilitado(){

        List<Jugador> jugadores = new ArrayList <>();

        Jugador jugador1 = Mockito.mock(Jugador.class);
        Jugador jugador2 = Mockito.mock(Jugador.class);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioSecond= new ModoInicioEspecifico(TipoOrden.SECOND);

        Turno turno = new Turno(jugadores,inicioSecond);

        verify(jugador1, never()).esTuTurno();

        verify(jugador2, never()).esTuTurno();

    }

    @Test
    public void test16PasarTurnoNotificaAlJugadorSiguienteComoHabilitado(){

        List<Jugador> jugadores = new ArrayList <>();

        Jugador jugador1 = Mockito.mock(Jugador.class);
        Jugador jugador2 = Mockito.mock(Jugador.class);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        Turno turno = new Turno(jugadores,inicioFirst);

        turno.pasarTurno();

        verify(jugador1, never()).esTuTurno();
        verify(jugador2, times(1)).esTuTurno();


    }

    @Test
    public void test17PasarDosTurnosNotificaAlPrimerJugadorUnaVecesHabilitadoYUnaVezAlJugador2(){

        List<Jugador> jugadores = new ArrayList <>();

        Jugador jugador1 = Mockito.mock(Jugador.class);
        Jugador jugador2 = Mockito.mock(Jugador.class);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioFirst= new ModoInicioEspecifico(TipoOrden.FIRST);
        Turno turno = new Turno(jugadores,inicioFirst);

        turno.pasarTurno();
        turno.pasarTurno();

        verify(jugador1, times(1)).esTuTurno();
        verify(jugador2, times(1)).esTuTurno();

    }

    @Test
    public void test18PasarTurnoInicioSecondNotificaAlJugadorSiguienteComoHabilitado(){

        List<Jugador> jugadores = new ArrayList <>();

        Jugador jugador1 = Mockito.mock(Jugador.class);
        Jugador jugador2 = Mockito.mock(Jugador.class);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ModoInicio inicioSecond= new ModoInicioEspecifico(TipoOrden.SECOND);
        Turno turno = new Turno(jugadores,inicioSecond);

        turno.pasarTurno();

        verify(jugador2, never()).esTuTurno();
        verify(jugador1, times(1)).esTuTurno();


    }

}
