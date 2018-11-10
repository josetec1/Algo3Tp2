package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Ubicables.Unidades.ArmaDeAsedio;
import org.junit.Assert;
import org.junit.Test;

public class ArmaDeAsedioTest {

    @Test
    public void test01SeCreaCorrectamenteArmaDeAsedio(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        Assert.assertEquals(armaDeAsedio.vidaTotal(), 150);
        Assert.assertEquals(armaDeAsedio.costo(),200);
    }

    @Test
    public void test02Disminuir50VidaArmaDeAsedioDevuelve100DeVida(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.vidaTotal(), 100);
    }

    @Test
    public void test03Disminuir50VidaArmaDeAsedioCrearNuevaArmaDeAsedioDevuelve150DeVida(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.vidaTotal(), 100);

        ArmaDeAsedio admaDeAsedioSecundaria = new ArmaDeAsedio();
        Assert.assertEquals(armaDeAsedio.vidaTotal(), 100);
        Assert.assertEquals(admaDeAsedioSecundaria.vidaTotal(), 150);

    }

}
