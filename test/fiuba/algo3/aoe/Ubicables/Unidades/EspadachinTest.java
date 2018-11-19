package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class EspadachinTest {
    @Test
    public void test01SeCreaCorrectamenteEspadachin(){
        Espadachin espadachin1 = new Espadachin();

        Assert.assertEquals(espadachin1.getVidaMaxima(), 100);
        Assert.assertEquals(espadachin1.getVidaActual(), 100);
        Assert.assertEquals(espadachin1.getCosto(),50);
        Assert.assertEquals(espadachin1.getDanioUnidad(),25);
        Assert.assertEquals(espadachin1.getDanioEdificio(),15);
        Assert.assertEquals(espadachin1.getDistanciaAtaque(),1);
    }

    @Test
    public void test02Disminuir50VidaEspadachinDevuelve50DeVida(){
        Espadachin espadachin = new Espadachin();
        espadachin.disminuirVida(50);
        Assert.assertEquals(espadachin.getVidaActual(), 50);
    }

    @Test
    public void test03AtacarArqueroDebeDisminuirSuVidaEn25(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(),  arqueroAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test04AtacarEspadachinDebeDisminuirSuVidaEn25(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable espadachinAtacado = new Espadachin();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        espadachinAtacado.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(espadachinAtacado);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test05AtacarPlazaCentralDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable plazaCentral = new PlazaCentral();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        plazaCentral.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(plazaCentral);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 15);
    }

    @Test
    public void test06AtacarCastilloDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable castillo = new Castillo();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        castillo.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(castillo);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 15);
    }

    @Test
    public void test07AtacarCuartelDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable cuartel = new Cuartel();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        cuartel.colocarEn(new Posicion(1,2));

        espadachinAtacante.atacar(cuartel);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 15);
    }

    @Test
    public void test08AtacarArqueroEnSuRangoDeAtaque(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(0,0));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 25);
    }

    @Test(expected=UnidadFueraDeRangoDeAtaqueException.class)
    public void test09IntentarAtacarArqueroFueraDelRangoDeAtaque(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();

        espadachinAtacante.colocarEn(new Posicion(1,1));
        arqueroAtacado.colocarEn(new Posicion(3, 3));

        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima());
    }

}