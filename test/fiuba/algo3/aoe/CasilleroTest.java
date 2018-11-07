package fiuba.algo3.aoe;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class CasilleroTest {


@Test
    public void test01AlCrearUnCasilleroDevuelveLosValoresConQueSeCreo (){

        Casillero unaCasillero = new Casillero(3,4);

        Assert.assertEquals(unaCasillero.getX(),3);
        Assert.assertEquals(unaCasillero.getY(),4);

    }
    @Test
    public void test02DDosCacillerosConLasMismasComponentesSonElMismoCasillero() {
        Casillero casillero1 = new Casillero( 2, 2 );
        Casillero casillero2 = new Casillero( 2, 2 );
        Casillero casillero3 = new Casillero( 3, 2 );  // != x
        Casillero casillero4 = new Casillero( 2, 3 );  // != y

        Assert.assertThat(casillero1, is(casillero2) );
        Assert.assertThat(casillero1, is( not(casillero3) ) );
        Assert.assertThat(casillero1, is( not(casillero4) ) );
    }

    @Test
    public void test03EqualsDeUnMismoCasilleroDebeDarTrue() {
        Casillero casillero1 = new Casillero( 2, 2 );


        Assert.assertEquals(casillero1,(casillero1));
    }

    @Test
    public void test04EqualsDeUnCasilleroConNullDebeDarFalse() {
        Casillero casillero1 = new Casillero( 2, 2 );
        Assert.assertNotEquals(casillero1,null);
    }


}
