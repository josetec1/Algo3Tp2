package fiuba.algo3.aoe.Ubicables.Direccion;


import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class DireccionableTest {




    @Test
    public void test01CalcularSiguienteDireccionDireccionAbajoDeX5Y5DebeDarX5Y4() {

        Direccionable direccionable = new DireccionAbajo();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 5, 4 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test02CalcularSiguienteDireccionDireccionAbajoDerechaDeX5Y5DebeDarX6Y4() {

        Direccionable direccionable = new DireccionAbajoDerecha();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 6, 4 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test03CalcularSiguienteDireccionDireccionAbajoIzquierdaDeX5Y5DebeDarX4Y4() {

        Direccionable direccionable = new DireccionAbajoIzquierda();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 4, 4 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }
    @Test
    public void test04CalcularSiguienteDireccionDireccionArribaDeX5Y5DebeDarX5Y4() {

        Direccionable direccionable = new DireccionAbajo();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 5, 4 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }
    @Test
    public void test05CalcularSiguienteDireccionDireccionArribaDerechaDeX5Y5DebeDarX6Y6() {

        Direccionable direccionable = new DireccionArribaDerecha();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 6, 6 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test06CalcularSiguienteDireccionDireccionArribaIzquierdaDeX5Y5DebeDarX4Y6() {

        Direccionable direccionable = new DireccionArribaIzquierda();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 4, 6 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test07CalcularSiguienteDireccionDireccionDerechaDeX5Y5DebeDarX6Y5() {

        Direccionable direccionable = new DireccionDerecha();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 6, 5 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test08CalcularSiguienteDireccionDireccionIzquierdaDeX5Y5DebeDarX4Y5() {

        Direccionable direccionable = new DireccionIzquierda();
        Cuadrante Origen = new Cuadrante( 5, 5 );
        Cuadrante Esperado = new Cuadrante( 4, 5 );

        Cuadrante Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }


}
