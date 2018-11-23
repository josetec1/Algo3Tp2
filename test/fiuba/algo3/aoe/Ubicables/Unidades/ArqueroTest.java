package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArqueroTest {
    @Test
    public void test01SeCreaCorrectamenteArquero(){

        Arquero arquero1 = new Arquero();

        Assert.assertEquals(arquero1.getVidaMaxima(), 75);
        Assert.assertEquals(arquero1.getVidaActual(), 75);
        Assert.assertEquals(arquero1.getCosto(),75);
        Assert.assertEquals(arquero1.getDanioUnidad(),15);
        Assert.assertEquals(arquero1.getDanioEdificio(),10);
        Assert.assertEquals(arquero1.getDistanciaAtaque(),3);
    }


    @Test
    public void test02Disminuir50VidaArmaDeAsedioDevuelve25DeVida(){
      //  Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio");
        Arquero arquero = new Arquero();
        arquero.disminuirVida(50);

        Assert.assertEquals(arquero.getVidaActual(), 25);
    }

    @Test
    public void test03AtacarArqueroDebeDisminuirSuVidaEn15(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test04AtacarEspadachinDebeDisminuirSuVidaEn15(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable espadachinAtacado = new Espadachin();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        espadachinAtacado.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(espadachinAtacado);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test05AtacarPlazaCentralDebeDisminuirSuVidaEn10(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable plazaCentral = new PlazaCentral();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        plazaCentral.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(plazaCentral);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 10);
    }

    @Test
    public void test06AtacarCastilloDebeDisminuirSuVidaEn10(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable castillo = new Castillo();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        castillo.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(castillo);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 10);
    }

    @Test
    public void test07AtacarCuartelDebeDisminuirSuVidaEn10(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable cuartel = new Cuartel();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        cuartel.colocarEn(new Posicion(2, 2));

        arqueroAtacante.atacar(cuartel);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 10);
    }

    @Test
    public void test08AtacarArqueroEnSuRangoDeAtaque(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(2,2));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test09AtacarArqueroEnElLimiteDelRangoDeAtaque(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(4, 4));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test(expected=UnidadFueraDeRangoDeAtaqueException.class)
    public void test10IntentarAtacarArqueroFueraDelRangoDeAtaque(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test11IntentarAtacarUnidadAtacanteSinPosicion(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacado.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

    @Test(expected= UnidadSinPosicionException.class)
    public void test12IntentarAtacarAUnidadSinPosicion(){
        UnidadMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();

        arqueroAtacante.colocarEn(new Posicion(5, 5));

        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }
}
