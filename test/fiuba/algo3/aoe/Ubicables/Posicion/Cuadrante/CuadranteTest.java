package fiuba.algo3.aoe.Ubicables.Posicion.Cuadrante;


import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class CuadranteTest {


@Test
    public void test01AlCrearUnCasilleroDevuelveLosValoresConQueSeCreo (){

        Cuadrante unaCuadrante = new Cuadrante(3,4);

      Assert.assertEquals(unaCuadrante.getX(),3);
      Assert.assertEquals(unaCuadrante.getY(),4);

    }
    @Test
    public void test02DDosCacillerosConLasMismasComponentesSonElMismoCasillero() {
        Cuadrante cuadrante1 = new Cuadrante( 2, 2 );
        Cuadrante cuadrante2 = new Cuadrante( 2, 2 );
        Cuadrante cuadranteConXDistinta = new Cuadrante( 3, 2 );  // != x
        Cuadrante cuadranteConYDistinta = new Cuadrante( 2, 3 );  // != y

        Assert.assertThat(cuadrante1, is(cuadrante2) );
        Assert.assertThat(cuadrante1, is( not(cuadranteConXDistinta) ) );
        Assert.assertThat(cuadrante1, is( not(cuadranteConYDistinta) ) );
    }

    @Test
    public void test03EqualsDeUnMismoCasilleroDebeDarTrue() {
        Cuadrante cuadrante1 = new Cuadrante( 2, 2 );


        Assert.assertEquals(cuadrante1,(cuadrante1));
    }

    @Test
    public void test04EqualsDeUnCasilleroConNullDebeDarFalse() {
        Cuadrante cuadrante1 = new Cuadrante( 2, 2 );
        Assert.assertNotSame(cuadrante1,null);
    }

    @Test
    public void test05EqualsDeUnCasilleroConOtroTipoDeObjetosDebeDarFalse() {
        Cuadrante cuadrante1 = new Cuadrante( 2, 2 );
        String otroTipoDeObjeto = "Maradona" ;
        Assert.assertNotSame(cuadrante1,otroTipoDeObjeto);
    }


    @Test
    public void test06estaDentroDeDebeDarFalseSiElCasilleroTieneValoresNegativos() {
        Cuadrante cuadrante1 = new Cuadrante( -1, 0 );
        Cuadrante cuadrante2 = new Cuadrante( 0,-1);
        Cuadrante cuadrante3 = new Cuadrante( -1,-1);

       Assert.assertFalse(cuadrante1.estaDentroDe(10,15));
       Assert.assertFalse(cuadrante2.estaDentroDe(10,15));
       Assert.assertFalse(cuadrante3.estaDentroDe(10,15));
    }

    @Test
    public void test07estaDentroDeDebeDarFalseSiElCasilleroTieneValoresCero() {
        Cuadrante cuadrante1 = new Cuadrante( 0, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 1, 0 );
        Cuadrante cuadrante3 = new Cuadrante( 0, 0 );

        Assert.assertFalse(cuadrante1.estaDentroDe(10,15));
        Assert.assertFalse(cuadrante2.estaDentroDe(10,15));
        Assert.assertFalse(cuadrante3.estaDentroDe(10,15));

    }
    @Test
    public void test08estaDentroDeDebeDarTrueSiEstaLosLimitesSuperioresDeLosValoresPasados() {
        Cuadrante cuadrante1 = new Cuadrante( 10, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 1, 15 );
        Cuadrante cuadrante3 = new Cuadrante( 10, 15 );

        Assert.assertTrue(cuadrante1.estaDentroDe(10,15));
        Assert.assertTrue(cuadrante2.estaDentroDe(10,15));
        Assert.assertTrue(cuadrante3.estaDentroDe(10,15));

    }

    @Test
    public void test09estaDentroDeDebeDarTrueSiEstaLosLimitesinferioresDeLosValoresPasados() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 2 );
        Cuadrante cuadrante2 = new Cuadrante( 2, 1 );
        Cuadrante cuadrante3 = new Cuadrante( 1, 1 );

        Assert.assertTrue(cuadrante1.estaDentroDe(10,15));
        Assert.assertTrue(cuadrante2.estaDentroDe(10,15));
        Assert.assertTrue(cuadrante3.estaDentroDe(10,15));

    }

    @Test
    public void test10estaDentroDeDebeDarFalseSiElCasilleroTieneAlgunaComponenteFueraDeLosLimites() {
        Cuadrante cuadrante1 = new Cuadrante( 11, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 1, 16 );
        Cuadrante cuadrante3 = new Cuadrante( 11, 16 );

        Assert.assertFalse(cuadrante1.estaDentroDe(10,15));
        Assert.assertFalse(cuadrante2.estaDentroDe(10,15));
        Assert.assertFalse(cuadrante3.estaDentroDe(10,15));

    }

    @Test
    public void test11estaDentroDeDebeDarFalseSiAlgunoDeLosLimitesVale0() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante3 = new Cuadrante( 1, 1 );

        Assert.assertFalse(cuadrante1.estaDentroDe(0,15));
        Assert.assertFalse(cuadrante2.estaDentroDe(10,0));
        Assert.assertFalse(cuadrante3.estaDentroDe(0,0));

    }

    @Test
    public void test12estaDentroDeDebeDarTrueParaValoresUno() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante3 = new Cuadrante( 1, 1 );

        Assert.assertTrue(cuadrante1.estaDentroDe(1,1));
        Assert.assertTrue(cuadrante2.estaDentroDe(1,1));
        Assert.assertTrue(cuadrante3.estaDentroDe(1,1));

    }



}
