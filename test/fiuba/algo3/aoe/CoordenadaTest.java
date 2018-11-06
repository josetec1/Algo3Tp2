package fiuba.algo3.aoe;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class CoordenadaTest {


@Test
    public void test01AlCrearUnaCoordenadaDevuelveLosValoresConQueSeCreo (){

        Coordenada unaCoordenada = new Coordenada (3,4);

        Assert.assertEquals(unaCoordenada.getX(),3);
        Assert.assertEquals(unaCoordenada.getY(),4);

    }
    @Test
    public void test02DosCoordenadasConLasMismasComponentesSonLaMismaCoordenada() {
        Coordenada coordenada1 = new Coordenada( 2, 2 );
        Coordenada coordenada2 = new Coordenada( 2, 2 );
        Coordenada coordenada3 = new Coordenada( 3, 2 );  // != x
        Coordenada coordenada4 = new Coordenada( 2, 3 );  // != y

        Assert.assertThat(coordenada1, is(coordenada2 ) );
        Assert.assertThat(coordenada1, is( not( coordenada3 ) ) );
        Assert.assertThat(coordenada1, is( not( coordenada4 ) ) );
    }

    @Test
    public void test03EqualsDeUnaMismaCoordenadaDebeDarTrue() {
        Coordenada coordenada1 = new Coordenada( 2, 2 );


        Assert.assertTrue(coordenada1.equals(coordenada1));
    }

    @Test
    public void test04EqualsDeUnaCoordenadaConNullDebeDarFalse() {
        Coordenada coordenada1 = new Coordenada( 2, 2 );
        Assert.assertFalse(coordenada1.equals(null));
    }


}
