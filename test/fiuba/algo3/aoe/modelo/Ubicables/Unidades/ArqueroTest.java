package fiuba.algo3.aoe.modelo.Ubicables.Unidades;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ArqueroTest {

    @Test
    public void test01SeCreaCorrectamenteArquero(){

        Arquero arquero1 = new Arquero();

        Assert.assertEquals(arquero1.getVidaMaxima(), 75);
        Assert.assertEquals(arquero1.getVidaActual(), 75);
        Assert.assertEquals(arquero1.getCosto(),75);
        Assert.assertEquals(arquero1.getDanioGeneradoAUnidad(),15);
        Assert.assertEquals(arquero1.getDanioGeneradoAEdificio(),10);
        Assert.assertEquals(arquero1.getDistanciaAtaque(),3);
    }

    @Test
    public void test02Disminuir50VidaEspadachinDevuelve50DeVida(){
        Mapa mapa = Mockito.mock(Mapa.class);
        Jugador jugador =Mockito.mock(Jugador.class);
        Arquero arquero = new Arquero();
        arquero.disminuirVida(50,jugador,mapa);
        Assert.assertEquals(arquero.getVidaActual(), 25);
    }

}
