package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EspadachinTest {


    @Test
    public void test01SeCreaCorrectamenteEspadachin(){
        Espadachin espadachin1 = new Espadachin();

        Assert.assertEquals(espadachin1.getVidaMaxima(), 100);
        Assert.assertEquals(espadachin1.getVidaActual(), 100);
        Assert.assertEquals(espadachin1.getCosto(),50);
        Assert.assertEquals(espadachin1.getDanioGeneradoAUnidad(),25);
        Assert.assertEquals(espadachin1.getDanioGeneradoAEdificio(),15);
        Assert.assertEquals(espadachin1.getDistanciaAtaque(),1);
    }

    @Test
    public void test02Disminuir50VidaEspadachinDevuelve50DeVida(){
        Mapa mapa =Mockito.mock(Mapa.class);
        Jugador jugador =Mockito.mock(Jugador.class);
        Espadachin espadachin = new Espadachin();
        espadachin.disminuirVida(50,jugador,mapa);
        Assert.assertEquals(espadachin.getVidaActual(), 50);
    }

}