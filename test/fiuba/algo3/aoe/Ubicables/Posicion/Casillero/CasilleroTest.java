package fiuba.algo3.aoe.Ubicables.Posicion.Casillero;


import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class CasilleroTest {


@Test
    public void test01AlCrearUnCasilleroDevuelveLosValoresConQueSeCreo (){

        Casillero unaCasillero = new Casillero(3,4);

       // Assert.assertEquals(unaCasillero.getX(),3);
        //Assert.assertEquals(unaCasillero.getY(),4);

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
        Assert.assertNotSame(casillero1,null);
    }


    @Test
    public void test05estaDentroDeDebeDarFalseSiElCasilleroTieneValoresNegativos() {
        Casillero casillero1 = new Casillero( -1, 0 );
        Casillero casillero2 = new Casillero( 0,-1);
        Casillero casillero3 = new Casillero( -1,-1);

       Assert.assertFalse(casillero1.estaDentroDe(10,15));
       Assert.assertFalse(casillero2.estaDentroDe(10,15));
       Assert.assertFalse(casillero3.estaDentroDe(10,15));
    }

    @Test
    public void test06estaDentroDeDebeDarFalseSiElCasilleroTieneValoresCero() {
        Casillero casillero1 = new Casillero( 0, 1 );
        Casillero casillero2 = new Casillero( 1, 0 );
        Casillero casillero3 = new Casillero( 0, 0 );

        Assert.assertFalse(casillero1.estaDentroDe(10,15));
        Assert.assertFalse(casillero2.estaDentroDe(10,15));
        Assert.assertFalse(casillero3.estaDentroDe(10,15));

    }

    @Test
    public void test07estaDentroDeDebeDarTrueSiEstaLosLimitesSuperioresDeLosValoresPasados() {
        Casillero casillero1 = new Casillero( 10, 1 );
        Casillero casillero2 = new Casillero( 1, 15 );
        Casillero casillero3 = new Casillero( 10, 15 );

        Assert.assertTrue(casillero1.estaDentroDe(10,15));
        Assert.assertTrue(casillero2.estaDentroDe(10,15));
        Assert.assertTrue(casillero3.estaDentroDe(10,15));

    }

    @Test
    public void test08estaDentroDeDebeDarTrueSiEstaLosLimitesinferioresDeLosValoresPasados() {
        Casillero casillero1 = new Casillero( 1, 2 );
        Casillero casillero2 = new Casillero( 2, 1 );
        Casillero casillero3 = new Casillero( 1, 1 );

        Assert.assertTrue(casillero1.estaDentroDe(10,15));
        Assert.assertTrue(casillero2.estaDentroDe(10,15));
        Assert.assertTrue(casillero3.estaDentroDe(10,15));

    }

    @Test
    public void test09estaDentroDeDebeDarFalseSiElCasilleroTieneAlgunaComponenteFueraDeLosLimites() {
        Casillero casillero1 = new Casillero( 11, 1 );
        Casillero casillero2 = new Casillero( 1, 16 );
        Casillero casillero3 = new Casillero( 11, 16 );

        Assert.assertFalse(casillero1.estaDentroDe(10,15));
        Assert.assertFalse(casillero2.estaDentroDe(10,15));
        Assert.assertFalse(casillero3.estaDentroDe(10,15));

    }

    @Test
    public void test10estaDentroDeDebeDarFalseSiAlgunoDeLosLimitesVale0() {
        Casillero casillero1 = new Casillero( 1, 1 );
        Casillero casillero2 = new Casillero( 1, 1 );
        Casillero casillero3 = new Casillero( 1, 1 );

        Assert.assertFalse(casillero1.estaDentroDe(0,15));
        Assert.assertFalse(casillero2.estaDentroDe(10,0));
        Assert.assertFalse(casillero3.estaDentroDe(0,0));

    }

    @Test
    public void test11estaDentroDeDebeDarTrueParaValoresUno() {
        Casillero casillero1 = new Casillero( 1, 1 );
        Casillero casillero2 = new Casillero( 1, 1 );
        Casillero casillero3 = new Casillero( 1, 1 );

        Assert.assertTrue(casillero1.estaDentroDe(1,1));
        Assert.assertTrue(casillero2.estaDentroDe(1,1));
        Assert.assertTrue(casillero3.estaDentroDe(1,1));

    }



}
