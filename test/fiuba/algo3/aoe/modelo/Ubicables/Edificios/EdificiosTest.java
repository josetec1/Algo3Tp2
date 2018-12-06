package fiuba.algo3.aoe.modelo.Ubicables.Edificios;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable.*;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class EdificiosTest {

    private Castillo castillo= new Castillo();
    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private ArrayList<Aldeano> aldeanos2 = new ArrayList<>();
    private PlazaCentral plaza;
    private Jugador jugador;
    private Jugador jugador2;

    @Before
    public void setUp(){
        plaza = new PlazaCentral();
        for (int i = 0; i < 3; i++) {
            aldeanos.add(new Aldeano());
            aldeanos2.add(new Aldeano());
        }
        jugador = new Jugador("ElDiego",castillo,plaza,aldeanos);
        jugador2 = new Jugador("Maradona",new Castillo(),new PlazaCentral(),aldeanos2);
    }




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
    public void test03CrearCastilloNoPuedoReparar(){
        Castillo castillo = new Castillo ();
        Assert.assertFalse(castillo.puedoReparar());

    }


    @Test
    public void test04PlazaCentralComenzarConstruccionNoPuedoRepararNoPuedoConstruir(){
        PlazaCentral plazaCentral = new PlazaCentral();
        plazaCentral.comenzarConstruccion ( new Aldeano (),jugador );
        Assert.assertFalse(plazaCentral.puedoReparar());
        Assert.assertFalse (plazaCentral.puedoConstruir());
    }

    @Test
    public void test05CuartelComenzarConstruccionNoPuedoRepararNoPuedoConstruir(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano (),jugador );
        Assert.assertFalse(cuartel.puedoReparar());
        Assert.assertFalse (cuartel.puedoConstruir());
    }

    @Rule
    public  ExpectedException thrown = ExpectedException.none ();



    @Test
    public void test07CuartelComenzarConstruccionEn3TurnospuedoCrearUnidad(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano (),jugador );
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
        plazaCentral.comenzarConstruccion ( new Aldeano (),jugador );
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
        plazaCentral.comenzarConstruccion ( new Aldeano () ,jugador);
        plazaCentral.huboUnCambioDeTurno ( mock( Jugador.class ) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        thrown.expect ( EdificioSinDaniarException.class );
        plazaCentral.reparar ( new Aldeano () );
    }

    @Test
    public void test12CuartelConstruidoRepararLanzaEdificioSinDaniarException(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano () ,jugador);
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
        Mapa mapa = Mockito.mock (Mapa.class);
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();


        cuartel.disminuirVida ( 30,jugador,mapa );

        Assert.assertTrue ( cuartel.puedoReparar () );
        Assert.assertFalse ( cuartel.puedoConstruir () );
    }

    @Test
    public void test15CuartelConstruidoDisminuirVidaAumentarVidaHastaTotalNoPuedoConstruirNoPuedoReparar(){
        Mapa mapa = Mockito.mock (Mapa.class);
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        cuartel.disminuirVida ( 30,jugador,mapa );
        cuartel.aumentarVida ( 30 );
        Assert.assertFalse ( cuartel.puedoReparar ());
        Assert.assertFalse ( cuartel.puedoConstruir () );

    }

    @Test
    public void test16CuartelConstruidoDisminuirVida450DejaUnidadConVida0(){
        Mapa mapa = Mockito.mock (Mapa.class);

        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        jugador.agregarPieza(cuartel);
        cuartel.disminuirVida ( 430,jugador,mapa );
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
    public void test20CuartelConstruirNoPuedoConstruirDeNuevoNoPuedoReparar(){
        Cuartel cuartel = new Cuartel ();
        cuartel.construir ( new Aldeano () ,jugador);
        Assert.assertFalse ( cuartel.puedoConstruir () );
        Assert.assertFalse ( cuartel.puedoReparar () );
    }


    @Test
    public void test21CuartelConstruirRepararLanzaExcepcionEdificioNoPuedeRepararseEnEsteMomentoException(){
        Cuartel cuartel = new Cuartel ();
        cuartel.construir ( new Aldeano (),jugador );
        thrown.expect ( EdificioNoPuedeRepararseEnEsteMomentoException.class );
        cuartel.reparar ( new Aldeano () );
    }

    @Test
    public void test22CuartelRepararConstruirLanzaExcepcionEdificioYaConstruidoException(){
        Mapa mapa = Mockito.mock (Mapa.class);
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        cuartel.disminuirVida ( 50,jugador,mapa );
        cuartel.reparar ( new Aldeano () );
        thrown.expect ( EdificioYaConstruidoException.class );
        cuartel.construir (new Aldeano () ,jugador );
    }


    @Test
    public void test23CastilloRepararDespuesde3TurnosTieneVida645(){
        Mapa mapa = Mockito.mock (Mapa.class);
        Castillo castillo = new Castillo ();
        castillo.disminuirVida ( 400,jugador,mapa );
        castillo.reparar ( new Aldeano () );
        castillo.huboUnCambioDeTurno ( mock( Jugador.class ) );
        castillo.huboUnCambioDeTurno ( mock(Jugador.class) );
        castillo.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertEquals ( castillo.getVidaActual (),645 );
    }

    @Test
    public void test24PlazaRepararDespuesde3TurnosTieneVida245(){
        Mapa mapa = Mockito.mock (Mapa.class);
        PlazaCentral plazaCentral = new PlazaCentral ();
        plazaCentral.disminuirVida ( 250,jugador,mapa );
        plazaCentral.reparar ( new Aldeano () );
        plazaCentral.huboUnCambioDeTurno ( mock( Jugador.class ) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertEquals ( plazaCentral.getVidaActual (),275 );
    }

    @Test
    public void test25CuartelRepararDespuesde3TurnosTieneVida245(){
        Mapa mapa = Mockito.mock (Mapa.class);
        Cuartel cuartel = new Cuartel ();
        cuartel.disminuirVida ( 200,jugador,mapa );
        cuartel.reparar ( new Aldeano () );
        cuartel.huboUnCambioDeTurno ( mock( Jugador.class ) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertEquals ( cuartel.getVidaActual (),200 );
    }


    @Test
    public void test26CuartelCrearEspadachinCreaSeagregaEspadachinAJugadorYSeColocaEnElMapa(){
        Castillo castillo = new Castillo();
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        Mapa mapa = new Mapa ( 200,200 );

        PosicionReal posicion = new PosicionReal ( 2,2 );
        cuartel.crearEspadachin ( jugador,mapa,posicion );


        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );

    }

    @Test
    public void test27CuartelCrearArqueroCreaSeagregaArqueroAJugadorYSeColocaEnElMapa(){
        Castillo castillo = new Castillo();
        Cuartel cuartel = new Cuartel ();
        cuartel.finalizarConstruccion ();
        Mapa mapa = new Mapa ( 200,200 );

        PosicionReal posicion = new PosicionReal ( 2,2 );
        cuartel.crearArquero ( jugador,mapa,posicion );

        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );
    }

    @Test
    public void test28PlazaCrearAldeanoCreaSeagregaAldeanoAJugadorYSeColocaEnElMapa(){
        Castillo castillo = new Castillo();
        PlazaCentral plazaCentral= new PlazaCentral ();
        plazaCentral.finalizarConstruccion ();
        Mapa mapa = new Mapa ( 200,200 );

        PosicionReal posicion = new PosicionReal ( 2,2 );
        plazaCentral.crearAldeano ( jugador,mapa,posicion);
        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );
    }

    @Test
    public void test29PlazaCrearArmaDeASedioCreaSeagregaArmaDeAsedioAJugadorYSeColocaEnElMapa(){

        Castillo castillo= new Castillo ();
        Mapa mapa = new Mapa ( 200,200 );

        jugador.sumarOro ( 100 );
        PosicionReal posicion = new PosicionReal ( 2,2 );
        castillo.crearArmaDeAsedio (jugador,mapa,posicion);
        Assert.assertFalse (mapa.puedoColocar ( posicion,1 ) );
    }

    @Test
    public void test30EdificioAConstruirDebeLanzarExcepcionAlIntentarCrearUnidades(){

        PlazaCentral plaza= new PlazaCentral ();
        Mapa mapa = new Mapa ( 200,200 );

        jugador.sumarOro ( 100 );
        PosicionReal posicion = new PosicionReal ( 2,2 );
        thrown.expect( NoSePuedeCrearUnidadException.class);
        plaza.crearAldeano (jugador,mapa,posicion);

    }

    @Test
    public void test31EdificioEnConstruccionDebeLanzarExcepcionAlIntentarCrearUnidades(){

        PlazaCentral plaza= new PlazaCentral ();
        Mapa mapa = new Mapa ( 200,200 );
        Aldeano aldeano = new Aldeano();
        jugador.sumarOro ( 100 );
        jugador.agregarPieza(aldeano);
        PosicionReal posicion = new PosicionReal ( 2,2 );
        aldeano.construirEdificio(plaza,mapa,jugador,new PosicionReal(6,6));
        thrown.expect( NoSePuedeCrearUnidadException.class);
        plaza.crearAldeano (jugador,mapa,posicion);

    }

    @Test
    public void test32EdificioEnConstruccionDebeLanzarExcepcionSiIntentoConstruirlo(){

        PlazaCentral plaza= new PlazaCentral ();
        Mapa mapa = new Mapa ( 200,200 );
        Aldeano aldeano = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        jugador.sumarOro ( 1000 );
        jugador.agregarPieza(aldeano);
        jugador.agregarPieza(aldeano2);
        PosicionReal posicion = new PosicionReal ( 2,2 );
        aldeano.construirEdificio(plaza,mapa,jugador,new PosicionReal(6,6));
        thrown.expect(EdificioEnConstruccionException.class);
        plaza.construir(aldeano2,jugador2);

    }

    @Test
    public void test33EdificioEnReparacionDebeLanzarExcepcionSiIntentoRepararlo(){

        PlazaCentral plaza= new PlazaCentral ();
        plaza.finalizarConstruccion();

        Mapa mapa = new Mapa ( 200,200 );
        Aldeano aldeano = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        jugador.sumarOro ( 1000 );
        jugador.agregarPieza(aldeano);
        jugador.agregarPieza(aldeano2);
        PosicionReal posicion = new PosicionReal ( 2,2 );
        plaza.disminuirVida(50,jugador,mapa);
        plaza.reparar(aldeano);
        thrown.expect(EdificioEnReparacionException.class);
        plaza.reparar(aldeano);

    }






   }


