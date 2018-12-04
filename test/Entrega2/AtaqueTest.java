package Entrega2;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.*;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.UnidadFueraDeRangoDeAtaqueException;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNulaException;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;

public class AtaqueTest {

    private Mapa mapa;
    private Jugador jugadorAtacante;
    private Jugador jugadorEnemigo;

    private Arquero arqueroAtacante;
    private Espadachin espadachinAtacante;

    private Arquero arqueroEnemigo;
    private Espadachin espadachinEnemigo;
    private PlazaCentral plazaCentralEnemiga;
    private Cuartel cuartelEnemigo;
    private Aldeano aldeanoEnemigo;
    private Castillo castilloAtacante;
    private Castillo castilloEnemigo;

    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private ArrayList<Aldeano> aldeanosEnemigos = new ArrayList<>();
    private PlazaCentral plaza;
    private PlazaCentral plazaEnemiga;

    /***************** PRUEBAS ARQUERO ATACANDO *******************************************/

    @Before
    public void setUp(){
        castilloAtacante = new Castillo();
        castilloEnemigo = new Castillo();
        mapa = new Mapa(50, 50);

        plaza = new PlazaCentral();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());

        plazaEnemiga = new PlazaCentral();
        aldeanosEnemigos.add(new Aldeano());
        aldeanosEnemigos.add(new Aldeano());
        aldeanosEnemigos.add(new Aldeano());

        jugadorAtacante = new Jugador("Diego",castilloAtacante, plaza,aldeanos);
        jugadorEnemigo = new Jugador ("Maradona",castilloEnemigo,plazaEnemiga,aldeanosEnemigos );

        jugadorAtacante.sumarOro(3000);
        jugadorEnemigo.sumarOro(3000);

        arqueroAtacante = new Arquero();
        jugadorAtacante.agregarPieza(arqueroAtacante);
        espadachinAtacante = new Espadachin();
        jugadorAtacante.agregarPieza(espadachinAtacante);

        arqueroEnemigo = new Arquero();
        jugadorEnemigo.agregarPieza(arqueroEnemigo);
        espadachinEnemigo = new Espadachin();
        jugadorEnemigo.agregarPieza(espadachinEnemigo);
        plazaCentralEnemiga = new PlazaCentral();
        jugadorEnemigo.agregarPieza(plazaCentralEnemiga);
        cuartelEnemigo = new Cuartel();
        jugadorEnemigo.agregarPieza(cuartelEnemigo);
        aldeanoEnemigo = new Aldeano();
        jugadorEnemigo.agregarPieza(aldeanoEnemigo);

    }

    @Test
    public void test01AtacarArqueroDebeDisminuirSuVidaEn15(){

        mapa.colocar(arqueroAtacante, new PosicionReal(1,1));
        mapa.colocar(arqueroEnemigo, new PosicionReal(3,3));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test02AtacarEspadachinDebeDisminuirSuVidaEn15(){

        mapa.colocar(arqueroAtacante, new PosicionReal(1,1));
        mapa.colocar(espadachinEnemigo, new PosicionReal(4,4));

        arqueroAtacante.atacar(espadachinEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(espadachinEnemigo.getVidaActual(), espadachinEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test03AtacarPlazaCentralDebeDisminuirSuVidaEn10(){

        mapa.colocar(arqueroAtacante, new PosicionReal(1,1));
        mapa.colocar(plazaCentralEnemiga, new PosicionReal(2,3));

        arqueroAtacante.atacar(plazaCentralEnemiga, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(plazaCentralEnemiga.getVidaActual(), plazaCentralEnemiga.getVidaMaxima() - 10);
    }

    @Test
    public void test04AtacarCastilloDebeDisminuirSuVidaEn10(){

        mapa.colocar(arqueroAtacante, new PosicionReal(1,1));
        mapa.colocar(castilloEnemigo, new PosicionReal(2,2));



        arqueroAtacante.atacar(castilloEnemigo,jugadorAtacante,jugadorEnemigo,mapa);


        Assert.assertEquals(castilloEnemigo.getVidaActual(), (castilloEnemigo.getVidaMaxima() - 10));
    }

    @Test
    public void test05AtacarCuartelDebeDisminuirSuVidaEn10(){


        mapa.colocar(arqueroAtacante, new PosicionReal(1,1));
        mapa.colocar(cuartelEnemigo, new PosicionReal(2,2));

        arqueroAtacante.atacar(cuartelEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(cuartelEnemigo.getVidaActual(), cuartelEnemigo.getVidaMaxima() - 10);
    }

    @Test
    public void test06AtacarArqueroEnSuRangoDeAtaque(){


        mapa.colocar(arqueroAtacante, new PosicionReal(1,1));
        mapa.colocar(arqueroEnemigo, new PosicionReal(2,2));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test07AtacarArqueroEnElLimiteDelRangoDeAtaque(){

        mapa.colocar(arqueroAtacante, new PosicionReal(1,1));
        mapa.colocar(arqueroEnemigo, new PosicionReal(4,4));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 15);
    }

    @Test(expected= UnidadFueraDeRangoDeAtaqueException.class)
    public void test08IntentarAtacarArqueroFueraDelRangoDeAtaque(){

        mapa.colocar(arqueroAtacante,new PosicionReal(1,1));
        mapa.colocar(arqueroEnemigo,new PosicionReal(5, 5));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= PosicionNulaException.class)
    public void test09IntentarAtacarUnidadAtacanteSinPosicion(){

        mapa.colocar(arqueroEnemigo,new PosicionReal(5, 5));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= PosicionNulaException.class)
    public void test10IntentarAtacarAUnidadSinPosicion(){

        mapa.colocar(arqueroAtacante ,new PosicionReal(5, 5));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    /***************** PRUEBAS ESPADACHIN ATACANDO *******************************************/

    @Test
    public void test11AtacarArqueroDebeDisminuirSuVidaEn25(){

        mapa.colocar(espadachinAtacante, new PosicionReal(1,1));
        mapa.colocar(arqueroEnemigo, new PosicionReal(1,2));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(),  arqueroEnemigo.getVidaMaxima() - 25);
    }

    @Test
    public void test12AtacarEspadachinDebeDisminuirSuVidaEn25(){

        mapa.colocar(espadachinAtacante, new PosicionReal(1,1));
        mapa.colocar(espadachinEnemigo, new PosicionReal(1,2));

        espadachinAtacante.atacar(espadachinEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(espadachinEnemigo.getVidaActual(), espadachinEnemigo.getVidaMaxima() - 25);
    }

    @Test
    public void test13AtacarPlazaCentralDebeDisminuirSuVidaEn15(){

        mapa.colocar(espadachinAtacante, new PosicionReal(1,1));
        mapa.colocar(plazaCentralEnemiga, new PosicionReal(1,2));

        espadachinAtacante.atacar(plazaCentralEnemiga, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(plazaCentralEnemiga.getVidaActual(), plazaCentralEnemiga.getVidaMaxima() - 15);
    }

    @Test
    public void test14AtacarCastilloDebeDisminuirSuVidaEn15(){

        mapa.colocar(espadachinAtacante, new PosicionReal(1,1));
        castilloEnemigo.colocarEn(new PosicionReal(1,2));

        espadachinAtacante.atacar(castilloEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(castilloEnemigo.getVidaActual(), castilloEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test15AtacarCuartelDebeDisminuirSuVidaEn15(){

        mapa.colocar(espadachinAtacante, new PosicionReal(1,1));
        mapa.colocar(cuartelEnemigo, new PosicionReal(1,2));

        espadachinAtacante.atacar(cuartelEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(cuartelEnemigo.getVidaActual(), cuartelEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test16AtacarArqueroEnSuRangoDeAtaque(){

        mapa.colocar(espadachinAtacante, new PosicionReal(1,1));
        mapa.colocar(arqueroEnemigo, new PosicionReal(1,2));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 25);
    }

    @Test(expected=UnidadFueraDeRangoDeAtaqueException.class)
    public void test17IntentarAtacarArqueroFueraDelRangoDeAtaque(){

        mapa.colocar(espadachinAtacante, new PosicionReal(1,1));
        mapa.colocar(arqueroEnemigo, new PosicionReal(3, 3));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= PosicionNulaException.class)
    public void test18IntentarAtacarArqueroAtacanteSinPosicion(){

        mapa.colocar(arqueroEnemigo, new PosicionReal(3, 3));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= PosicionNulaException.class)
    public void test19IntentarAtacarUnidadSinPosicion(){

        mapa.colocar(espadachinAtacante, new PosicionReal(3, 3));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test
    public void test20EspadachinMataArqueroEnemigoSeDebeEliminarDelMapaYDelJugador(){

        mapa.colocar(espadachinAtacante,new PosicionReal(4,4));
        mapa.colocar(arqueroEnemigo, new PosicionReal(3,4));

        int cantidadPiezasEnemigas = jugadorEnemigo.getAtacables().size();

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);
        espadachinAtacante.huboUnCambioDeTurno(jugadorAtacante);
        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);
        espadachinAtacante.huboUnCambioDeTurno(jugadorAtacante);
        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);


        Assert.assertEquals(arqueroEnemigo.getVidaActual(), 0);
        Assert.assertTrue(mapa.puedoColocar(new PosicionReal(3,4), 1));
        Assert.assertEquals(cantidadPiezasEnemigas - 1 , jugadorEnemigo.getAtacables().size());

    }
// test jose *********************************************
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test89AlAtacarAUnAmigoDebeLanzarExcepcion(){

        Arquero arqueroAmigo = arqueroAtacante;

        mapa.colocar(espadachinAtacante,new PosicionReal(4,4));
        mapa.colocar(arqueroAmigo, new PosicionReal(3,4));


        thrown.expect(FuegoAmigoException.class);
        espadachinAtacante.atacar(arqueroAmigo, jugadorAtacante, jugadorEnemigo, mapa);
    }

    @Test
    public void test90SiAlAtacarElJugadorAtacanteYEnemigoEsElMismoDebeLanzarExcepcion(){

       Mapa miMapa = new Mapa(100,100);

        Jugador mijugadorAtacante = new Jugador("Diego", castilloAtacante,plaza,aldeanos);
        mijugadorAtacante.sumarOro(3000);

        Arquero miArqueroAtacante = new Arquero();
        mijugadorAtacante.agregarPieza(miArqueroAtacante);

        Espadachin miEspadachinEnemigo = new Espadachin();

        miMapa.colocar(miArqueroAtacante,new PosicionReal(5,5));
        miMapa.colocar(miEspadachinEnemigo,new PosicionReal(6,6));

        thrown.expect(EstoyEnDosJugadoresException.class);
        miArqueroAtacante.atacar(miEspadachinEnemigo,mijugadorAtacante,mijugadorAtacante,mapa);

    }

    @Test
    public void test91SiAlAtacarElObjetivoEnemigoNoEsDelJugadorEnemigoDebeLanzarExcepcion(){

        Mapa miMapa = new Mapa(100,100);

        Jugador mijugadorAtacante = new Jugador("Diego", castilloAtacante,plaza,aldeanos);
        Jugador mijugadorEnemigo = new Jugador("Diego", castilloEnemigo,plazaEnemiga,aldeanosEnemigos);
        mijugadorAtacante.sumarOro(3000);

        Arquero miArqueroAtacante = new Arquero();
        mijugadorAtacante.agregarPieza(miArqueroAtacante);

        Espadachin miEspadachinEnemigo = new Espadachin();

        miMapa.colocar(miArqueroAtacante,new PosicionReal(5,5));
        miMapa.colocar(miEspadachinEnemigo,new PosicionReal(6,6));

        thrown.expect(EnemigoSinJugadorException.class);
        miArqueroAtacante.atacar(miEspadachinEnemigo,mijugadorAtacante,mijugadorEnemigo,mapa);

    }
/*******************************
 *
 *  testeo los puedo atacar de la unidad militar
 */

    @Test
    public void test92PuedoAtacarDebeDarFalseAlAtacarAUnAmigo(){

        Arquero arqueroAmigo = arqueroAtacante;
        mapa.colocar(espadachinAtacante,new PosicionReal(4,4));
        mapa.colocar(arqueroAmigo, new PosicionReal(3,4));

        Assert.assertFalse(espadachinAtacante.puedoAtacar(arqueroAmigo, jugadorAtacante, jugadorEnemigo, mapa));
    }

    @Test
    public void test93PuedoAtacarDebeDarFalseSiAlAtacarElJugadorAtacanteYEnemigoEsElMismo(){

        Mapa miMapa = new Mapa(100,100);

        Jugador mijugadorAtacante = new Jugador("Diego", castilloAtacante,plaza,aldeanos);
        mijugadorAtacante.sumarOro(3000);

        Arquero miArqueroAtacante = new Arquero();
        mijugadorAtacante.agregarPieza(miArqueroAtacante);

        Espadachin miEspadachinEnemigo = new Espadachin();

        miMapa.colocar(miArqueroAtacante,new PosicionReal(5,5));
        miMapa.colocar(miEspadachinEnemigo,new PosicionReal(6,6));

        Assert.assertFalse(miArqueroAtacante.puedoAtacar(miEspadachinEnemigo,mijugadorAtacante,mijugadorAtacante,mapa));


    }

    @Test
    public void test94PuedoAtacarDebeDarFalseSiAlAtacarElObjetivoEnemigoNoEsDelJugadorEnemigo(){

        Mapa miMapa = new Mapa(100,100);


        Jugador mijugadorAtacante = new Jugador("Diego", castilloAtacante,plaza,aldeanos);
        Jugador mijugadorEnemigo = new Jugador("Diego", castilloEnemigo,plazaEnemiga,aldeanosEnemigos);
        mijugadorAtacante.sumarOro(3000);

        Arquero miArqueroAtacante = new Arquero();
        mijugadorAtacante.agregarPieza(miArqueroAtacante);

        Espadachin miEspadachinEnemigo = new Espadachin();

        miMapa.colocar(miArqueroAtacante,new PosicionReal(5,5));
        miMapa.colocar(miEspadachinEnemigo,new PosicionReal(6,6));


        Assert.assertFalse(miArqueroAtacante.puedoAtacar(miEspadachinEnemigo,mijugadorAtacante,mijugadorEnemigo,mapa));

    }

    @Test
    public void test95PuedoAtacarDebeDarTrueConJugadoresDistintosYPosicionEnRangoDeAtaque(){

        mapa.colocar(espadachinAtacante,new PosicionReal(4,4));
        mapa.colocar(arqueroEnemigo, new PosicionReal(3,4));

        Assert.assertTrue(espadachinAtacante.puedoAtacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa));



    }

    @Test
    public void test96AtacarDebeDarLanzarExcepcionCuandoLaPosicionDelAtacanteEsNula(){


        mapa.colocar(arqueroEnemigo, new PosicionReal(3,4));

        thrown.expect(PosicionNulaException.class);
        Assert.assertTrue(espadachinAtacante.puedoAtacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa));

    }

    @Test
    public void test97test96AtacarDebeDarLanzarExcepcionCuandoLaPosicionDelAtacableEsNula(){

        mapa.colocar(espadachinAtacante,new PosicionReal(4,4));


        thrown.expect(PosicionNulaException.class);
        Assert.assertTrue(espadachinAtacante.puedoAtacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa));

    }




// fin test jose *********************************************


    @Test
    public void test21EspadachinDestruyeCuartelEnemigoSeDebeEliminarDelMapaYDelJugador(){

        mapa.colocar(espadachinAtacante,new PosicionReal(4,4));
        mapa.colocar(cuartelEnemigo, new PosicionReal(5,5));

        int cantidadPiezasEnemigas = jugadorEnemigo.getAtacables().size();

        while (cuartelEnemigo.getVidaActual()>0) {
            espadachinAtacante.atacar(cuartelEnemigo, jugadorAtacante, jugadorEnemigo, mapa);
            espadachinAtacante.huboUnCambioDeTurno(jugadorAtacante);

        }


        Assert.assertEquals(cuartelEnemigo.getVidaActual(), 0);
        Assert.assertTrue(mapa.puedoColocar(new PosicionReal(5,5), 2));
        Assert.assertEquals(cantidadPiezasEnemigas - 1 , jugadorEnemigo.getAtacables().size());

    }

    /***************** PRUEBAS CASTILLO ATACANDO *******************************************/

    @Test
    public void test020CastilloAtacaAldeano(){

        castilloAtacante.colocarEn(new PosicionReal(1,1));
        aldeanoEnemigo.colocarEn(new PosicionReal(2,2));

        castilloAtacante.atacar(aldeanoEnemigo,jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(aldeanoEnemigo.getVidaActual(), aldeanoEnemigo.getVidaMaxima() - 20);
    }

    @Test
    public void test021CastilloAtacaAldeanoEnElLimiteDeSuRango(){

        castilloAtacante.colocarEn(new PosicionReal(1,1));
        aldeanoEnemigo.colocarEn(new PosicionReal(4,4));

        castilloAtacante.atacar(aldeanoEnemigo,jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(aldeanoEnemigo.getVidaActual(), aldeanoEnemigo.getVidaMaxima() - 20);
    }

    @Test
    public void test022CastilloIntentaAtacarAldeanoFueraDeSuRangoDebeLanzarExcepcion(){

        castilloAtacante.colocarEn(new PosicionReal(1,1));
        aldeanoEnemigo.colocarEn(new PosicionReal(5,5));

        thrown.expect(UnidadFueraDeRangoDeAtaqueException.class);
        castilloAtacante.atacar(aldeanoEnemigo, jugadorAtacante, jugadorEnemigo, mapa);
    }

    @Test
    public void test022PuedoAtacarDebeDarFalseCuandoCastilloIntentaAtacarAldeanoFueraDeSuRango(){

        castilloAtacante.colocarEn(new PosicionReal(1,1));
        aldeanoEnemigo.colocarEn(new PosicionReal(5,5));

        Assert.assertFalse(castilloAtacante.puedoAtacar(aldeanoEnemigo, jugadorAtacante, jugadorEnemigo, mapa));
    }

    /***************** PRUEBAS JUGADOR RECIBE ATAQUE DE CASTILLO *******************************************/

    @Test
    public void test23CastilloAtacaATodasLasUnidadesDelJugadorEnemigoDentroDeSuRango(){
        Castillo castilloObjetivo = new Castillo();
        Mapa mapa = new Mapa(100,100);

        PlazaCentral plazaRango = new PlazaCentral();
        PlazaCentral plazaFueraRango = new PlazaCentral();
        Aldeano aldeanoObjetivo = new Aldeano();
        Aldeano aldeanoFueraRango = new Aldeano();
        Aldeano aldeanoFueraRango2 = new Aldeano();

        ArrayList<Aldeano> aldeanosEnemigos = new ArrayList<>();
        aldeanosEnemigos.add(aldeanoObjetivo);
        aldeanosEnemigos.add(aldeanoFueraRango);
        aldeanosEnemigos.add(aldeanoFueraRango2);

        Jugador jugadorObjetivo = new Jugador("D10S", castilloObjetivo,plazaRango,aldeanosEnemigos);
        jugadorObjetivo.sumarOro(100000);
        jugadorObjetivo.agregarPieza(plazaFueraRango);

        Castillo castilloAtacante = new Castillo();
        Jugador jugadorAtacante = new Jugador("Maradona", castilloAtacante,plaza,aldeanos);

        mapa.colocar(castilloAtacante,new PosicionReal(90,90));
        mapa.colocar(plazaRango,new PosicionReal(90,87));
        mapa.colocar(plazaFueraRango,new PosicionReal(98,98));
        mapa.colocar(aldeanoObjetivo, new PosicionReal(90,94));
        mapa.colocar(aldeanoFueraRango, new PosicionReal(80,94));
        mapa.colocar(aldeanoFueraRango2, new PosicionReal(79,94));
        mapa.colocar(castilloObjetivo, new PosicionReal(10,10));

        castilloAtacante.atacarAlJugador(jugadorAtacante,jugadorObjetivo,mapa);

        Assert.assertThat(plazaRango.getVidaActual(),is(plazaRango.getVidaMaxima()-20));
        Assert.assertThat(plazaFueraRango.getVidaActual(),is(plazaFueraRango.getVidaMaxima()));
        Assert.assertThat(aldeanoObjetivo.getVidaActual(),is(aldeanoObjetivo.getVidaMaxima()-20));
    }

    @Test
    public void test24CastilloAtacaATodasLasUnidadesDelJugadorDebeLanzarExcepcionCuandoEsSuPropioJugador(){
        Castillo castilloObjetivo = new Castillo();
        Mapa mapa = new Mapa(100,100);

        PlazaCentral plazaRango = new PlazaCentral();
        PlazaCentral plazaFueraRango = new PlazaCentral();
        Aldeano aldeanoObjetivo = new Aldeano();
        Aldeano aldeanoFueraRango = new Aldeano();
        Aldeano aldeanoFueraRango2 = new Aldeano();

        ArrayList<Aldeano> aldeanosEnemigos = new ArrayList<>();
        aldeanosEnemigos.add(aldeanoObjetivo);
        aldeanosEnemigos.add(aldeanoFueraRango);
        aldeanosEnemigos.add(aldeanoFueraRango2);

        Jugador jugadorObjetivo = new Jugador("D10S", castilloObjetivo,plazaRango,aldeanosEnemigos);
        jugadorObjetivo.sumarOro(100000);
        jugadorObjetivo.agregarPieza(plazaFueraRango);

        Castillo castilloAtacante = new Castillo();
        Jugador jugadorAtacante = new Jugador("Maradona", castilloAtacante,plaza,aldeanos);

        mapa.colocar(castilloAtacante,new PosicionReal(90,90));
        mapa.colocar(plazaRango,new PosicionReal(90,87));
        mapa.colocar(plazaFueraRango,new PosicionReal(98,98));
        mapa.colocar(aldeanoObjetivo, new PosicionReal(90,94));
        mapa.colocar(aldeanoFueraRango, new PosicionReal(75,94));
        mapa.colocar(aldeanoFueraRango2, new PosicionReal(80,94));
        mapa.colocar(castilloObjetivo, new PosicionReal(10,10));

        thrown.expect(FuegoAmigoException.class);
        castilloAtacante.atacarAlJugador(jugadorAtacante,jugadorAtacante,mapa);

    }

    @Test
    public void test25CastilloAtacaATodasLasUnidadesDelJugadorDebeLanzarExcepcionCuandoNoEsSuJugador(){
        Castillo castilloObjetivo = new Castillo();
        Mapa mapa = new Mapa(100,100);

        PlazaCentral plazaRango = new PlazaCentral();
        PlazaCentral plazaFueraRango = new PlazaCentral();
        Aldeano aldeanoObjetivo = new Aldeano();
        Aldeano aldeanoFueraRango = new Aldeano();
        Aldeano aldeanoFueraRango2 = new Aldeano();

        ArrayList<Aldeano> aldeanosEnemigos = new ArrayList<>();
        aldeanosEnemigos.add(aldeanoObjetivo);
        aldeanosEnemigos.add(aldeanoFueraRango);
        aldeanosEnemigos.add(aldeanoFueraRango2);

        Jugador jugadorObjetivo = new Jugador("D10S", castilloObjetivo,plazaRango,aldeanosEnemigos);
        jugadorObjetivo.sumarOro(100000);
        jugadorObjetivo.agregarPieza(plazaFueraRango);

        Castillo castilloAtacante = new Castillo();
        Jugador jugadorAtacante = new Jugador("Maradona", castilloAtacante,plaza,aldeanos);

        mapa.colocar(castilloAtacante,new PosicionReal(90,90));
        mapa.colocar(plazaRango,new PosicionReal(90,87));
        mapa.colocar(plazaFueraRango,new PosicionReal(98,98));
        mapa.colocar(aldeanoObjetivo, new PosicionReal(90,94));
        mapa.colocar(aldeanoFueraRango, new PosicionReal(73,94));
        mapa.colocar(aldeanoFueraRango2, new PosicionReal(80,94));
        mapa.colocar(castilloObjetivo, new PosicionReal(10,10));

        thrown.expect(NoEsMiJugadorException.class);
        castilloAtacante.atacarAlJugador(jugadorObjetivo,jugadorObjetivo,mapa);

    }

}
