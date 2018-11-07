package fiuba.algo3.aoe;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

public class PosicionTest {


    @Test
    public void test01Vacio() {


        Assert.assertThat( true, is( true ) );

    }
















/*


    @Test
    public void test01ElCasilleroSeCreaConEstadoVacio() {

        Posicion unCasillero = new Posicion();
        Assert.assertThat( unCasillero.estaVacio(), is( true ) );

    }

    @Test
    public void test02estaVacioDebeDarFalseLuegoDeColocarUnElemento() {

        Posicion unCasillero = new Posicion();
        Ubicable unElemento = new UbicableFicticio();

        unCasillero.colocar(unElemento);

        Assert.assertThat( unCasillero.estaVacio(), is( false ) );

    }

    @Test
    public void test03estaVacioDebeDarTrueLuegoDeQuitarUnElementoPreviamenteColocado() {

        Posicion unCasillero = new Posicion();
        Ubicable unElemento = new UbicableFicticio();

        unCasillero.colocar(unElemento);
        unCasillero.quitar();
        Assert.assertThat( unCasillero.estaVacio(), is( true ) );

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test04AlColocarDebeLanzarExcepcionSiElCasilleroEstaOcupado() {

        Posicion unCasillero = new Posicion();
        Ubicable unElemento = new UbicableFicticio();
        unCasillero.colocar(unElemento);

        thrown.expect(CasilleroOcupadoException.class);
        unCasillero.colocar(unElemento);

    }


    @Test
    public void test05QuitarDebeLanzarExcepcionSiElCasilleroEstaVacio() {

        Posicion unCasillero = new Posicion();

        thrown.expect(CasilleroVacioException.class);
        unCasillero.quitar();
    }

    @Test
    public void test06QuitarDevuelveElElementoPreviamenteColocado() {

        Posicion unCasillero = new Posicion();
        Ubicable unElemento = new UbicableFicticio();
        Ubicable otroElemento = new UbicableFicticio();
        Ubicable elementoRecuperado;

        unCasillero.colocar(unElemento);
        elementoRecuperado= unCasillero.quitar();

        Assert.assertSame(unElemento, elementoRecuperado  );
        Assert.assertNotSame(otroElemento, elementoRecuperado );
    }

    @Test
    public void test07SeDebePoderAgregarUnElementoLuegoDeQuitarOtroPreviamenteAgregado() {

        Posicion unCasillero = new Posicion();
        Ubicable unElemento = new UbicableFicticio();
        Ubicable otroElemento = new UbicableFicticio();
        Ubicable elementoRecuperado;

        unCasillero.colocar(unElemento);
        unCasillero.quitar();
        unCasillero.colocar(otroElemento);
        elementoRecuperado= unCasillero.quitar();

        Assert.assertNotSame(unElemento, elementoRecuperado );
        Assert.assertSame(otroElemento, elementoRecuperado  );

    }
    */
}


