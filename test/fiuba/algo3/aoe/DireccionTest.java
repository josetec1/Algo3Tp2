package fiuba.algo3.aoe;


import Ubicables.Unidades.movimiento.*;
import fiuba.algo3.aoe.Tablero.Casillero;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class DireccionTest {




    @Test
    public void test01CalcularSiguienteDireccionDireccionAbajoDeX5Y5DebeDarX5Y4() {

        Direccion direccion = new DireccionAbajo();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 5, 4 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test02CalcularSiguienteDireccionDireccionAbajoDerechaDeX5Y5DebeDarX6Y4() {

        Direccion direccion = new DireccionAbajoDerecha();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 6, 4 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test03CalcularSiguienteDireccionDireccionAbajoIzquierdaDeX5Y5DebeDarX4Y4() {

        Direccion direccion = new DireccionAbajoIzquierda();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 4, 4 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }
    @Test
    public void test04CalcularSiguienteDireccionDireccionArribaDeX5Y5DebeDarX5Y4() {

        Direccion direccion = new DireccionAbajo();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 5, 4 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }
    @Test
    public void test05CalcularSiguienteDireccionDireccionArribaDerechaDeX5Y5DebeDarX6Y6() {

        Direccion direccion = new DireccionArribaDerecha();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 6, 6 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test06CalcularSiguienteDireccionDireccionArribaIzquierdaDeX5Y5DebeDarX4Y6() {

        Direccion direccion = new DireccionArribaIzquierda();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 4, 6 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test07CalcularSiguienteDireccionDireccionDerechaDeX5Y5DebeDarX6Y5() {

        Direccion direccion = new DireccionDerecha();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 6, 5 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }

    @Test
    public void test08CalcularSiguienteDireccionDireccionIzquierdaDeX5Y5DebeDarX4Y5() {

        Direccion direccion = new DireccionIzquierda();
        Casillero Origen = new Casillero( 5, 5 );
        Casillero Esperado = new Casillero( 4, 5 );

        Casillero Calculado = direccion.calcularSiguienteCasillero(Origen);

        Assert.assertThat(Calculado, is(Esperado) );
        Assert.assertThat(Calculado, is( not(Origen) ) );

    }


}
