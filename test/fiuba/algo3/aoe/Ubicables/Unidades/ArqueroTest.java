package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
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
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Arquero arquero = new Arquero();
        arquero.disminuirVida(50);
        Assert.assertEquals(arquero.getVidaActual(), 25);
    }

    @Test
    public void test03AtacarArqueroDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable arqueroAtacado = new Arquero();
        arqueroAtacante.atacar(arqueroAtacado);

        Assert.assertEquals(arqueroAtacado.getVidaActual(), arqueroAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test04AtacarEspadachinDebeDisminuirSuVidaEn15(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable espadachinAtacado = new Espadachin();

        arqueroAtacante.atacar(espadachinAtacado);

        Assert.assertEquals(espadachinAtacado.getVidaActual(), espadachinAtacado.getVidaMaxima() - 15);
    }

    @Test
    public void test05AtacarPlazaCentralDebeDisminuirSuVidaEn10(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable plazaCentral = new PlazaCentral();

        arqueroAtacante.atacar(plazaCentral);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima() - 10);
    }

    @Test
    public void test06AtacarCastilloDebeDisminuirSuVidaEn10(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable castillo = new Castillo();

        arqueroAtacante.atacar(castillo);

        Assert.assertEquals(castillo.getVidaActual(), castillo.getVidaMaxima() - 10);
    }

    @Test
    public void test07AtacarCuartelDebeDisminuirSuVidaEn10(){
        UnidadMovilMilitar arqueroAtacante = new Arquero();
        Atacable cuartel = new Cuartel();

        arqueroAtacante.atacar(cuartel);

        Assert.assertEquals(cuartel.getVidaActual(), cuartel.getVidaMaxima() - 10);
    }
}
