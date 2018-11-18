package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
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
    }

    @Test
    public void test02Disminuir50VidaEspadachinDevuelve50DeVida(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Espadachin espadachin = new Espadachin();
        espadachin.disminuirVida(50);
        Assert.assertEquals(espadachin.getVidaActual(), 50);
    }

}