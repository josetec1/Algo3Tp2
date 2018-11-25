package Entrega2;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.*;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtaqueTest {

    private Mapa mapa;
    private Jugador jugadorAtacante;
    private Jugador jugadorEnemigo;

    private UnidadMilitar arqueroAtacante;
    private UnidadMilitar espadachinAtacante;

    private UnidadMilitar arqueroEnemigo;
    private UnidadMilitar espadachinEnemigo;
    private Edificio plazaCentralEnemiga;
    private Edificio cuartelEnemigo;
    private UnidadMovil aldeanoEnemigo;

    /***************** PRUEBAS ARQUERO ATACANDO *******************************************/

    @Before
    public void setUp(){

        mapa = new Mapa(50, 50);
        jugadorAtacante = new Jugador("Jose");
        jugadorEnemigo = new Jugador ("Maria");

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

        mapa.colocar(arqueroAtacante, new Posicion(1,1));
        mapa.colocar(arqueroEnemigo, new Posicion (3,3));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test02AtacarEspadachinDebeDisminuirSuVidaEn15(){

        mapa.colocar(arqueroAtacante, new Posicion(1,1));
        mapa.colocar(espadachinEnemigo, new Posicion (4,4));

        arqueroAtacante.atacar(espadachinEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(espadachinEnemigo.getVidaActual(), espadachinEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test03AtacarPlazaCentralDebeDisminuirSuVidaEn10(){

        mapa.colocar(arqueroAtacante, new Posicion(1,1));
        mapa.colocar(plazaCentralEnemiga, new Posicion (2,3));

        arqueroAtacante.atacar(plazaCentralEnemiga, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(plazaCentralEnemiga.getVidaActual(), plazaCentralEnemiga.getVidaMaxima() - 10);
    }

    /*@Test // Observer del Castillo Enemigo
    public void test04AtacarCastilloDebeDisminuirSuVidaEn10(){

        mapa.colocar(arqueroAtacante, new Posicion(1,1));
        mapa.colocar(castilloEn, new Posicion (2,3));

        arqueroAtacante.colocarEn(new Posicion(1,1));
        castillo.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(castillo, jugadorAtacante);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 10);
    }*/

    @Test
    public void test05AtacarCuartelDebeDisminuirSuVidaEn10(){


        mapa.colocar(arqueroAtacante, new Posicion(1,1));
        mapa.colocar(cuartelEnemigo, new Posicion (2,2));

        arqueroAtacante.atacar(cuartelEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(cuartelEnemigo.getVidaActual(), cuartelEnemigo.getVidaMaxima() - 10);
    }

    @Test
    public void test06AtacarArqueroEnSuRangoDeAtaque(){


        mapa.colocar(arqueroAtacante, new Posicion(1,1));
        mapa.colocar(arqueroEnemigo, new Posicion (2,2));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test07AtacarArqueroEnElLimiteDelRangoDeAtaque(){

        mapa.colocar(arqueroAtacante, new Posicion(1,1));
        mapa.colocar(arqueroEnemigo, new Posicion (4,4));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 15);
    }

    @Test(expected= UnidadFueraDeRangoDeAtaqueException.class)
    public void test08IntentarAtacarArqueroFueraDelRangoDeAtaque(){

        mapa.colocar(arqueroAtacante,new Posicion(1,1));
        mapa.colocar(arqueroEnemigo,new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test09IntentarAtacarUnidadAtacanteSinPosicion(){

        mapa.colocar(arqueroEnemigo,new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test10IntentarAtacarAUnidadSinPosicion(){

        mapa.colocar(arqueroAtacante ,new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    /***************** PRUEBAS ESPADACHIN ATACANDO *******************************************/

    @Test
    public void test11AtacarArqueroDebeDisminuirSuVidaEn25(){

        mapa.colocar(espadachinAtacante, new Posicion(1,1));
        mapa.colocar(arqueroEnemigo, new Posicion(1,2));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(),  arqueroEnemigo.getVidaMaxima() - 25);
    }

    @Test
    public void test12AtacarEspadachinDebeDisminuirSuVidaEn25(){

        mapa.colocar(espadachinAtacante, new Posicion(1,1));
        mapa.colocar(espadachinEnemigo, new Posicion(1,2));

        espadachinAtacante.atacar(espadachinEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(espadachinEnemigo.getVidaActual(), espadachinEnemigo.getVidaMaxima() - 25);
    }

    @Test
    public void test13AtacarPlazaCentralDebeDisminuirSuVidaEn15(){

        mapa.colocar(espadachinAtacante, new Posicion(1,1));
        mapa.colocar(plazaCentralEnemiga, new Posicion(1,2));

        espadachinAtacante.atacar(plazaCentralEnemiga, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(plazaCentralEnemiga.getVidaActual(), plazaCentralEnemiga.getVidaMaxima() - 15);
    }
/*
    @Test
    public void test14AtacarCastilloDebeDisminuirSuVidaEn15(){

        mapa.colocar(espadachinAtacante, new Posicion(1,1));
        castillo.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(castillo, , jugadorEnemigo, mapa);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 15);
    }
*/ // TODO como agregar castillo
    @Test
    public void test15AtacarCuartelDebeDisminuirSuVidaEn15(){

        mapa.colocar(espadachinAtacante, new  Posicion(1,1));
        mapa.colocar(cuartelEnemigo, new Posicion(1,2));

        espadachinAtacante.atacar(cuartelEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(cuartelEnemigo.getVidaActual(), cuartelEnemigo.getVidaMaxima() - 15);
    }

    @Test
    public void test16AtacarArqueroEnSuRangoDeAtaque(){

        mapa.colocar(espadachinAtacante, new Posicion(1,1));
        mapa.colocar(arqueroEnemigo, new Posicion(1,2));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima() - 25);
    }

    @Test(expected=UnidadFueraDeRangoDeAtaqueException.class)
    public void test17IntentarAtacarArqueroFueraDelRangoDeAtaque(){

        mapa.colocar(espadachinAtacante, new Posicion(1,1));
        mapa.colocar(arqueroEnemigo, new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test18IntentarAtacarArqueroAtacanteSinPosicion(){

        mapa.colocar(arqueroEnemigo, new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test19IntentarAtacarUnidadSinPosicion(){

        mapa.colocar(espadachinAtacante, new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(arqueroEnemigo.getVidaActual(), arqueroEnemigo.getVidaMaxima());
    }

    @Test
    public void test20EspadachinMataArqueroEnemigoSeDebeEliminarDelMapaYDelJugador(){

        mapa.colocar(espadachinAtacante,new Posicion(4,4));
        mapa.colocar(arqueroEnemigo, new Posicion(3,4));

        int cantidadPiezasEnemigas = jugadorEnemigo.getPiezas().size();

        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);
        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);
        espadachinAtacante.atacar(arqueroEnemigo, jugadorAtacante, jugadorEnemigo, mapa);


        Assert.assertEquals(arqueroEnemigo.getVidaActual(), 0);
        Assert.assertTrue(mapa.puedoColocar(new Posicion(3,4), 1));
        Assert.assertEquals(cantidadPiezasEnemigas - 1 , jugadorEnemigo.getPiezas().size());

    }

    @Test
    public void test21EspadachinDestruyeCuartelEnemigoSeDebeEliminarDelMapaYDelJugador(){

        mapa.colocar(espadachinAtacante,new Posicion(4,4));
        mapa.colocar(cuartelEnemigo, new Posicion(5,5));

        int cantidadPiezasEnemigas = jugadorEnemigo.getPiezas().size();

        while (cuartelEnemigo.getVidaActual()>0)
            espadachinAtacante.atacar(cuartelEnemigo, jugadorAtacante, jugadorEnemigo, mapa);


        Assert.assertEquals(cuartelEnemigo.getVidaActual(), 0);
        Assert.assertTrue(mapa.puedoColocar(new Posicion(5,5), 2));
        Assert.assertEquals(cantidadPiezasEnemigas - 1 , jugadorEnemigo.getPiezas().size());

    }

    /***************** PRUEBAS CASTILLO ATACANDO *******************************************/
/*
    @Test
    public void test020CastilloAtacaAldeano(){

        castilloAtacante.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(2,2));

        castilloAtacante.atacar(aldeano,jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima() - 20);
    }

    @Test
    public void test021CastilloAtacaAldeanoEnElLimiteDeSuRango(){

        castilloAtacante.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(4,4));

        castilloAtacante.atacar(aldeano,jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima() - 20);
    }

    @Test
    public void test022CastilloIntentaAtacarAldeanoFueraDeSuRango(){

        castilloAtacante.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(5,5));

        castilloAtacante.atacar(aldeano, jugadorAtacante, jugadorEnemigo, mapa);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima());
    }

    /***************** PRUEBAS JUGADOR RECIBE ATAQUE DE CASTILLO *******************************************/
/*//TODO A Eliminar como implementamos ataque de castillo
    @Test
    public void test23JugadorRecibeAtaqueDeCastilloEnemigoDebeAtacarAlaPlazaUnicamente(){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar(new Posicion(1,1));

        Castillo castilloEnemigo = new Castillo();
        mapa.colocar(castilloEnemigo,new Posicion(11,11));

        jugador.recibirAtaqueCastillo(castilloEnemigo);

        PlazaCentral plazaCentral = espia.getPlazaCentrals().get(0); //en pos (9,9) a (10,10)
        Aldeano aldeano = espia.getAldeanos().get(2); // pos (7,7)

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima()-20);

        Assert.assertEquals(aldeano.getVidaActual(),aldeano.getVidaMaxima());
    }

    @Test
    public void test24JugadorRecibeAtaqueDeCastilloEnemigoDebeAtacarAPlazaCentralYAldeanosUnicamente(){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar(new Posicion(1,1));

        Castillo castilloEnemigo = new Castillo();
        mapa.colocar(castilloEnemigo,new Posicion(5,8));//pos (5,8)a (8,11)

        jugador.recibirAtaqueCastillo(castilloEnemigo);

        PlazaCentral plazaCentral = espia.getPlazaCentrals().get(0); //en pos (9,9) a (10,10)
        Aldeano aldeano = espia.getAldeanos().get(2); // pos (7,7)
        Aldeano aldeano2 = espia.getAldeanos().get(1); // pos (6,6)
        Aldeano aldeano3 = espia.getAldeanos().get(0); // pos (5,5)
        Castillo castillo = espia.getCastillos().get(0); // pos (1,1) a (4,4)

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima()-20);
        Assert.assertEquals(aldeano.getVidaActual(),aldeano.getVidaMaxima()-20);
        Assert.assertEquals(aldeano2.getVidaActual(),aldeano2.getVidaMaxima()-20);
        Assert.assertEquals(aldeano3.getVidaActual(),aldeano3.getVidaMaxima()-20);

        Assert.assertEquals(castillo.getVidaActual(),castillo.getVidaMaxima());

    }

    @Test
    public void test25JugadorIntentaRecibirAtaqueDeSuPropioCastillo(){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar(new Posicion(1,1));

        PlazaCentral plazaCentral = espia.getPlazaCentrals().get(0); //en pos (9,9) a (10,10)
        Aldeano aldeano = espia.getAldeanos().get(2); // pos (7,7)
        Aldeano aldeano2 = espia.getAldeanos().get(1); // pos (6,6)
        Aldeano aldeano3 = espia.getAldeanos().get(0); // pos (5,5)
        Castillo castillo = espia.getCastillos().get(0); // pos (1,1) a (4,4)

        jugador.recibirAtaqueCastillo(castillo);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima());
        Assert.assertEquals(aldeano.getVidaActual(),aldeano.getVidaMaxima());
        Assert.assertEquals(aldeano2.getVidaActual(),aldeano2.getVidaMaxima());
        Assert.assertEquals(aldeano3.getVidaActual(),aldeano3.getVidaMaxima());
        Assert.assertEquals(castillo.getVidaActual(),castillo.getVidaMaxima());

    }
    */
}
