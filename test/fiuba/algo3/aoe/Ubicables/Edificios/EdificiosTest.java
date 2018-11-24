package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EdificioNoPuedeRepararseEnEsteMomentoException;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EdificioYaConstruidoException;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;

public class EdificiosTest {

    @Test
    public void test01CrearPlazaCentralPuedoConstruirPeroNoReparar(){
        PlazaCentral plazaCentral = new PlazaCentral();
        Assert.assertFalse(plazaCentral.puedoReparar());
        Assert.assertTrue(plazaCentral.puedoConstruir());
    }

    @Test
    public void test02CrearCuartelPuedoConstruirPeroNoReparar(){
        Cuartel cuartel = new Cuartel ();
        Assert.assertFalse(cuartel.puedoReparar());
        Assert.assertTrue(cuartel.puedoConstruir());
    }

    @Test
    public void test03CrearCastilloNoPuedoConstruirNoPuedoReparar(){
        Castillo castillo = new Castillo ();
        Assert.assertFalse(castillo.puedoReparar());
        Assert.assertFalse (castillo.puedoConstruir());
    }

    @Test
    public void test04PlazaCentralComenzarConstruccionNoPuedoRepararNoPuedoConstruir(){
        PlazaCentral plazaCentral = new PlazaCentral();
        plazaCentral.comenzarConstruccion ( new Aldeano () );
        Assert.assertFalse(plazaCentral.puedoReparar());
        Assert.assertFalse (plazaCentral.puedoConstruir());
    }

    @Test
    public void test05CuartelComenzarConstruccionNoPuedoRepararNoPuedoConstruir(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano () );
        Assert.assertFalse(cuartel.puedoReparar());
        Assert.assertFalse (cuartel.puedoConstruir());
    }

    @Rule
    public  ExpectedException thrown = ExpectedException.none ();

    @Test
    public void test06CastilloComenzarConstruccionLanzaEdificioNoConstruibleException(){
        Castillo castillo = new Castillo ();
        thrown.expect (EdificioNoConstruibleSinCostoException.class);
        castillo.comenzarConstruccion ( new Aldeano () );
    }

    @Test
    public void test07CuartelComenzarConstruccionEn3TurnospuedoCrearUnidad(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano () );
        cuartel.huboUnCambioDeTurno ( mock( Jugador.class ) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertTrue ( cuartel.puedocrearUnidad () );
    }

    @Test
    public void test08CrearCuartelNoPuedoCrearUnidad(){
        Cuartel cuartel = new Cuartel ();
        Assert.assertFalse ( cuartel.puedocrearUnidad () );
    }

    @Test
    public void test09PlazaComenzarConstruccionEn3TurnospuedoCrearUnidad(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        plazaCentral.comenzarConstruccion ( new Aldeano () );
        plazaCentral.huboUnCambioDeTurno ( mock( Jugador.class ) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertTrue ( plazaCentral.puedocrearUnidad () );
    }

    @Test
    public void test09CrearPlazaCentralNoPuedoCrearUnidad(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        Assert.assertFalse ( plazaCentral.puedocrearUnidad () );
    }

    @Test
    public void test10CrearCastilloPuedoCrearUnidad(){
        Castillo castillo = new Castillo ();
        Assert.assertTrue ( castillo.puedocrearUnidad () );
    }

    @Test
    public void test11PlazaConstruidaRepararLanzaEdificioSinDaniarException(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        plazaCentral.comenzarConstruccion ( new Aldeano () );
        plazaCentral.huboUnCambioDeTurno ( mock( Jugador.class ) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        thrown.expect ( EdificioSinDaniarException.class );
        plazaCentral.reparar ( new Aldeano () );
    }

    @Test
    public void test12CuartelConstruidaRepararLanzaEdificioSinDaniarException(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano () );
        cuartel.huboUnCambioDeTurno ( mock( Jugador.class ) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        thrown.expect ( EdificioSinDaniarException.class );
        cuartel.reparar ( new Aldeano () );
    }

    @Test
    public void test13CastilloConstruidoRepararLanzaEdificioSinDaniarException(){
        Castillo castillo = new Castillo ();
        thrown.expect ( EdificioSinDaniarException.class );
        castillo.reparar ( new Aldeano () );
    }

    @Test
    public void test14CuartelConstruidoDisminuirVidaPuedoRepararNoPuedoConstruir(){
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        cuartel.disminuirVida ( 30 );
        Assert.assertTrue ( cuartel.puedoReparar () );
        Assert.assertFalse ( cuartel.puedoConstruir () );
    }

    @Test
    public void test15CuartelConstruidoDisminuirVidaAumentarVidaHastaTotalNoPuedoConstruirNoPuedoReparar(){
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        cuartel.disminuirVida ( 30 );
        cuartel.aumentarVida ( 30 );
        Assert.assertFalse ( cuartel.puedoReparar ());
        Assert.assertFalse ( cuartel.puedoConstruir () );

    }

    @Test
    public void test16CuartelConstruidoDisminuirVida450DejaUnidadConVida0(){
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        cuartel.disminuirVida ( 430 );
        Assert.assertTrue (cuartel.getVidaActual ()== 0);

    }

    @Test
    public void test17InicializarCuartel(){
        Cuartel cuartel = new Cuartel ();
        Assert.assertTrue ( cuartel.getVidaActual () == 250 );
        Assert.assertTrue ( cuartel.getVidaMaxima () == 250 );
        Assert.assertTrue ( cuartel.getCosto () == 50);
    }

    @Test
    public void test18InicializarPlaza(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        Assert.assertTrue ( plazaCentral.getVidaActual () == 450 );
        Assert.assertTrue ( plazaCentral.getVidaMaxima () == 450 );
        Assert.assertTrue ( plazaCentral.getCosto () == 100);
    }

    @Test
    public void test19InicializarCastilloGetCostoLanzaEdificioNoConstruibleSinCostroException(){
        Castillo castillo = new Castillo ();
        Assert.assertTrue ( castillo.getVidaActual () == 1000 );
        Assert.assertTrue ( castillo.getVidaMaxima () == 1000 );
        Assert.assertTrue ( castillo.getDanioEdificio () == 20 );
        Assert.assertTrue ( castillo.getDanioUnidad () == 20 );
        thrown.expect ( EdificioNoConstruibleSinCostoException.class );
        castillo.getCosto ();
    }

    @Test
    public void test20CuartelConstruirNoPuedoConstruirDeNuevoNoPuedoReparar(){
        Cuartel cuartel = new Cuartel ();
        cuartel.construir ( new Aldeano () );
        Assert.assertFalse ( cuartel.puedoConstruir () );
        Assert.assertFalse ( cuartel.puedoReparar () );
    }


    @Test
    public void test21CuartelConstruirRepararLanzaExcepcionEdificioNoPuedeRepararseEnEsteMomentoException(){
        Cuartel cuartel = new Cuartel ();
        cuartel.construir ( new Aldeano () );
        thrown.expect ( EdificioNoPuedeRepararseEnEsteMomentoException.class );
        cuartel.reparar ( new Aldeano () );
    }

    @Test
    public void test22CuartelRepararConstruirLanzaExcepcionEdificioYaConstruidoException(){
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        cuartel.disminuirVida ( 50);
        cuartel.reparar ( new Aldeano () );
        thrown.expect ( EdificioYaConstruidoException.class );
        cuartel.construir (new Aldeano ()  );
    }


    @Test
    public void test23CastilloRepararDespuesde3TurnosTieneVida645(){
        Castillo castillo = new Castillo ();
        castillo.disminuirVida ( 400 );
        castillo.reparar ( new Aldeano () );
        castillo.huboUnCambioDeTurno ( mock( Jugador.class ) );
        castillo.huboUnCambioDeTurno ( mock(Jugador.class) );
        castillo.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertEquals ( castillo.getVidaActual (),645 );
    }

    @Test
    public void test24PlazaRepararDespuesde3TurnosTieneVida245(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        plazaCentral.disminuirVida ( 250 );
        plazaCentral.reparar ( new Aldeano () );
        plazaCentral.huboUnCambioDeTurno ( mock( Jugador.class ) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertEquals ( plazaCentral.getVidaActual (),275 );
    }

    @Test
    public void test25CuartelRepararDespuesde3TurnosTieneVida245(){
        Cuartel cuartel = new Cuartel ();
        cuartel.disminuirVida ( 200 );
        cuartel.reparar ( new Aldeano () );
        cuartel.huboUnCambioDeTurno ( mock( Jugador.class ) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertEquals ( cuartel.getVidaActual (),200 );
    }


    @Test
    public void test26CuartelCrearEspadachinCreaSeagregaEspadachinAJugadorYSeColocaEnElMapa(){
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        Mapa mapa = new Mapa ( 200,200 );
        Jugador jugador = new Jugador ( "Mauricio" );
        Posicion posicion = new Posicion ( 2,2 );
        cuartel.crearEspadachin ( jugador,mapa,posicion );

        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );

    }

    @Test
    public void test27CuartelCrearArqueroCreaSeagregaArqueroAJugadorYSeColocaEnElMapa(){
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        Mapa mapa = new Mapa ( 200,200 );
        Jugador jugador = new Jugador ( "Mauricio" );
        Posicion posicion = new Posicion ( 2,2 );
        cuartel.crearArquero ( jugador,mapa,posicion );

        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );
    }

    @Test
    public void test28PlazaCrearAldeanoCreaSeagregaAldeanoAJugadorYSeColocaEnElMapa(){
        PlazaCentral plazaCentral= new PlazaCentral ();
        plazaCentral.finalizarConstruccion ();
        Mapa mapa = new Mapa ( 200,200 );
        Jugador jugador = new Jugador ( "Mauricio" );
        Posicion posicion = new Posicion ( 2,2 );
        plazaCentral.crearAldeano ( jugador,mapa,posicion);
        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );
    }

    @Test
    public void test29PlazaCrearArmaDeASedioCreaSeagregaArmaDeAsedioAJugadorYSeColocaEnElMapa(){
        Castillo castillo= new Castillo ();
        Mapa mapa = new Mapa ( 200,200 );
        Jugador jugador = new Jugador ( "Mauricio" );
        jugador.sumarOro ( 100 );
        Posicion posicion = new Posicion ( 2,2 );
        castillo.crearArmaDeAsedio (jugador,mapa,posicion);
        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );
    }
}
