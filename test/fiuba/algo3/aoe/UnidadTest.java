package fiuba.algo3.aoe;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnidadTest {

    @Test
    public void test01AlCrearUnCasilleroDevuelveLosValoresConQueSeCreo (){

        Unidad unAldeano = new Aldeano();

        assertEquals(unAldeano.vidaTotal(),50);
        assertEquals(unAldeano.costo(),25);

    }

}
