package Entrega2;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.*;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtaqueTest {

    private Jugador jugadorAtacante;
    private UnidadMilitar arqueroAtacante;
    private UnidadMilitar espadachinAtacante;

    private Atacable arqueroAtacado;
    private Atacable espadachinAtacado;
    private Atacable plazaCentral;
    private Atacable cuartel;
    private Atacable castillo;

    private UnidadMovil aldeano;

    /***************** PRUEBAS ARQUERO ATACANDO *******************************************/

    @Before
    public void setUp(){

        jugadorAtacante = new Jugador("jose");
        jugadorAtacante.sumarOro(3000);
        arqueroAtacante = new Arquero();
        jugadorAtacante.agregarPieza(arqueroAtacante);
        espadachinAtacante = new Espadachin();
        jugadorAtacante.agregarPieza(espadachinAtacante);

        arqueroAtacado = new Arquero();
        espadachinAtacado = new Espadachin();
        plazaCentral = new PlazaCentral();
        cuartel = new Cuartel();
        castillo = new Castillo();

        aldeano = new Aldeano();
    }

    @Test
    public void test01AtacarArqueroDebeDisminuirSuVidaEn15(){

        arqueroAtacante.colocarEn(new Posicion (1,1));
        arqueroAtacado.colocarEn(new Posicion( 3,3));

        arqueroAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test02AtacarEspadachinDebeDisminuirSuVidaEn15(){

        arqueroAtacante.colocarEn(new Posicion (1,1));
        espadachinAtacado.colocarEn(new Posicion( 4,4));

        arqueroAtacante.atacar(espadachinAtacado, jugadorAtacante);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test03AtacarPlazaCentralDebeDisminuirSuVidaEn10(){

        arqueroAtacante.colocarEn(new Posicion(1,1));
        plazaCentral.colocarEn(new Posicion(2,3));

        arqueroAtacante.atacar(plazaCentral, jugadorAtacante);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 10);
    }

    @Test
    public void test04AtacarCastilloDebeDisminuirSuVidaEn10(){

        arqueroAtacante.colocarEn(new Posicion(1,1));
        castillo.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(castillo, jugadorAtacante);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 10);
    }

    @Test
    public void test05AtacarCuartelDebeDisminuirSuVidaEn10(){

        arqueroAtacante.colocarEn(new Posicion(1,1));
        cuartel.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(cuartel, jugadorAtacante);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 10);
    }

    @Test
    public void test06AtacarArqueroEnSuRangoDeAtaque(){

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(2,2));

        arqueroAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test07AtacarArqueroEnElLimiteDelRangoDeAtaque(){

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(4, 4));

        arqueroAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test(expected= UnidadFueraDeRangoDeAtaqueException.class)
    public void test08IntentarAtacarArqueroFueraDelRangoDeAtaque(){

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test09IntentarAtacarUnidadAtacanteSinPosicion(){

        arqueroAtacado.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test10IntentarAtacarAUnidadSinPosicion(){

        arqueroAtacante.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    /***************** PRUEBAS ESPADACHIN ATACANDO *******************************************/

    @Test
    public void test11AtacarArqueroDebeDisminuirSuVidaEn25(){

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(),  arqueroAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test12AtacarEspadachinDebeDisminuirSuVidaEn25(){

        espadachinAtacante.colocarEn(new Posicion(1,1));
        espadachinAtacado.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(espadachinAtacado, jugadorAtacante);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test13AtacarPlazaCentralDebeDisminuirSuVidaEn15(){

        espadachinAtacante.colocarEn(new Posicion(1,1));
        plazaCentral.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(plazaCentral, jugadorAtacante);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 15);
    }

    @Test
    public void test14AtacarCastilloDebeDisminuirSuVidaEn15(){

        espadachinAtacante.colocarEn(new Posicion(1,1));
        castillo.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(castillo, jugadorAtacante);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 15);
    }

    @Test
    public void test15AtacarCuartelDebeDisminuirSuVidaEn15(){

        espadachinAtacante.colocarEn(new Posicion(1,1));
        cuartel.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(cuartel, jugadorAtacante);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 15);
    }

    @Test
    public void test16AtacarArqueroEnSuRangoDeAtaque(){

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(0,0));

        espadachinAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 25);
    }

    @Test(expected=UnidadFueraDeRangoDeAtaqueException.class)
    public void test17IntentarAtacarArqueroFueraDelRangoDeAtaque(){

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test18IntentarAtacarArqueroAtacanteSinPosicion(){

        arqueroAtacado.colocarEn(new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test19IntentarAtacarUnidadSinPosicion(){

        espadachinAtacante.colocarEn(new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroAtacado, jugadorAtacante);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    /***************** PRUEBAS CASTILLO ATACANDO *******************************************/
/*
    @Test
    public void test020CastilloAtacaAldeano(){

        castillo.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(2,2));

        castillo.atacar(aldeano);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima() - 20);
    }

    @Test
    public void test021CastilloAtacaAldeanoEnElLimiteDeSuRango(){
        Castillo castillo = new Castillo();
        UnidadMovil aldeano = new Aldeano();

        castillo.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(4,4));

        castillo.atacar(aldeano);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima() - 20);
    }

    @Test
    public void test022CastilloIntentaAtacarAldeanoFueraDeSuRango(){
        Castillo castillo = new Castillo();
        UnidadMovil aldeano = new Aldeano();

        castillo.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(5,5));

        castillo.atacar(aldeano);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima());
    }
*/
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
