package Entrega2;

import fiuba.algo3.aoe.Jugador.ObservadorDeJugadorFicticio;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.*;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class AtaqueTest {

    /***************** PRUEBAS ARQUERO ATACANDO *******************************************/
    @Test
    public void test01AtacarArqueroDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test02AtacarEspadachinDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable espadachinAtacado = new Espadachin();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        espadachinAtacado.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(espadachinAtacado);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test03AtacarPlazaCentralDebeDisminuirSuVidaEn10(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable plazaCentral = new PlazaCentral();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        plazaCentral.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(plazaCentral);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 10);
    }

    @Test
    public void test04AtacarCastilloDebeDisminuirSuVidaEn10(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable castillo = new Castillo();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        castillo.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(castillo);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 10);
    }

    @Test
    public void test05AtacarCuartelDebeDisminuirSuVidaEn10(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable cuartel = new Cuartel();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        cuartel.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(cuartel);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 10);
    }

    @Test
    public void test06AtacarArqueroEnSuRangoDeAtaque(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(2,2));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test07AtacarArqueroEnElLimiteDelRangoDeAtaque(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(4, 4));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test(expected= UnidadFueraDeRangoDeAtaqueException.class)
    public void test08IntentarAtacarArqueroFueraDelRangoDeAtaque(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionExceptcion.class)
    public void test09IntentarAtacarUnidadAtacanteSinPosicion(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacado.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected=UnidadSinPosicionExceptcion.class)
    public void test10IntentarAtacarAUnidadSinPosicion(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    /***************** PRUEBAS ESPADACHIN ATACANDO *******************************************/

    @Test
    public void test11AtacarArqueroDebeDisminuirSuVidaEn25(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(),  arqueroAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test12AtacarEspadachinDebeDisminuirSuVidaEn25(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable espadachinAtacado = new Espadachin();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        espadachinAtacado.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(espadachinAtacado);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test13AtacarPlazaCentralDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable plazaCentral = new PlazaCentral();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        plazaCentral.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(plazaCentral);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 15);
    }

    @Test
    public void test14AtacarCastilloDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable castillo = new Castillo();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        castillo.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(castillo);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 15);
    }

    @Test
    public void test15AtacarCuartelDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable cuartel = new Cuartel();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        cuartel.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(cuartel);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 15);
    }

    @Test
    public void test16AtacarArqueroEnSuRangoDeAtaque(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(0,0));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 25);
    }

    @Test(expected=UnidadFueraDeRangoDeAtaqueException.class)
    public void test17IntentarAtacarArqueroFueraDelRangoDeAtaque(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected=UnidadSinPosicionExceptcion.class)
    public void test18IntentarAtacarArqueroAtacanteSinPosicion(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacado.colocarEn(new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected=UnidadSinPosicionExceptcion.class)
    public void test19IntentarAtacarUnidadSinPosicion(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        espadachinAtacante.colocarEn(new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    /***************** PRUEBAS CASTILLO ATACANDO *******************************************/

    @Test
    public void test020CastilloAtacaAldeano(){
        Castillo castillo = new Castillo();
        UnidadMovil aldeano = new Aldeano();

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

    /***************** PRUEBAS JUGADOR RECIBE ATAQUE DE CASTILLO *******************************************/
/*
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
