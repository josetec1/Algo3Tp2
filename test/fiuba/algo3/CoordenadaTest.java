package fiuba.algo3;


import org.junit.Assert;
import org.junit.Test;

public class CoordenadaTest {


@Test
    public void test01AlCrearUnaCoordenadaDevuelveLosValoresConQueSeCreo (){

        Coordenada unaCoordenada = new Coordenada (3,4);

        Assert.assertEquals(unaCoordenada.getX(),3);
        Assert.assertEquals(unaCoordenada.getY(),4);

    }


}
