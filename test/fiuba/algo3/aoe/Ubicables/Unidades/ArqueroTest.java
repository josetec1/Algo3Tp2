package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import org.junit.Assert;
import org.junit.Test;

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
    public void test02Disminuir50VidaArmaDeAsedioDevuelve25DeVida() {

        Arquero arquero = new Arquero();
        arquero.disminuirVida(50);

        Assert.assertEquals(arquero.getVidaActual(), arquero.getVidaMaxima() - 50);
    }
}
