package fiuba.algo3.aoe.Ubicables.Direccion;


import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class DireccionableTest {




    @Test
    public void test01CalcularSiguienteDireccionDireccionAbajoDeX5Y5DebeDarX5Y4() {

        Direccionable direccionable = new DireccionAbajo();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 5, 4 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test02CalcularSiguienteDireccionDireccionAbajoDerechaDeX5Y5DebeDarX6Y4() {

        Direccionable direccionable = new DireccionAbajoDerecha();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 6, 4 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test03CalcularSiguienteDireccionDireccionAbajoIzquierdaDeX5Y5DebeDarX4Y4() {

        Direccionable direccionable = new DireccionAbajoIzquierda();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 4, 4 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }
    @Test
    public void test04CalcularSiguienteDireccionDireccionArribaDeX5Y5DebeDarX5Y4() {

        Direccionable direccionable = new DireccionAbajo();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 5, 4 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }
    @Test
    public void test05CalcularSiguienteDireccionDireccionArribaDerechaDeX5Y5DebeDarX6Y6() {

        Direccionable direccionable = new DireccionArribaDerecha();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 6, 6 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test06CalcularSiguienteDireccionDireccionArribaIzquierdaDeX5Y5DebeDarX4Y6() {

        Direccionable direccionable = new DireccionArribaIzquierda();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 4, 6 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test07CalcularSiguienteDireccionDireccionDerechaDeX5Y5DebeDarX6Y5() {

        Direccionable direccionable = new DireccionDerecha();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 6, 5 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test08CalcularSiguienteDireccionDireccionIzquierdaDeX5Y5DebeDarX4Y5() {

        Direccionable direccionable = new DireccionIzquierda();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 4, 5 );

        Casillero Calculado = direccionable.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }


}
