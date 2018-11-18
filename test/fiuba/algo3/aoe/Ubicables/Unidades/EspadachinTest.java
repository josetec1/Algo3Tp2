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
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class EspadachinTest {
    @Test
    public void test01SeCreaCorrectamenteEspadachin(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
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
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Espadachin espadachin = new Espadachin();
        espadachin.disminuirVida(50);
        Assert.assertEquals(espadachin.getVidaActual(), 50);
    }

    @Test
    public void test03AtacarArqueroDebeDisminuirSuVidaEn25(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable arqueroAtacado = new Arquero();
        espadachinAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(),  arqueroAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test04AtacarEspadachinDebeDisminuirSuVidaEn25(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable espadachinAtacado = new Espadachin();

        espadachinAtacante.atacar(espadachinAtacado);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 25);
    }

    @Test
    public void test05AtacarPlazaCentralDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable plazaCentral = new PlazaCentral();

        espadachinAtacante.atacar(plazaCentral);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 15);
    }

    @Test
    public void test06AtacarCastilloDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable castillo = new Castillo();

        espadachinAtacante.atacar(castillo);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 15);
    }

    @Test
    public void test07AtacarCuartelDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar espadachinAtacante = new Espadachin();
        Atacable cuartel = new Cuartel();

        espadachinAtacante.atacar(cuartel);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 15);
    }

}