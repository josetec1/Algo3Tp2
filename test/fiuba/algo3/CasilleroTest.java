package fiuba.algo3;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

public class CasilleroTest {

    @Test
    public void test01ElCasilleroSeCreaConEstadoVacio() {

        Casillero unCasillero = new Casillero();
        Assert.assertThat( unCasillero.estaVacio(), is( true ) );

    }

    @Test
    public void test02estaVacioDebeDarFalseLuegoDeColocarUnElemento() {

        Casillero unCasillero = new Casillero();
        Ubicable unElemento = new UbicableFicticio();

        unCasillero.colocar(unElemento);

        Assert.assertThat( unCasillero.estaVacio(), is( false ) );

    }

    @Test
    public void test03estaVacioDebeDarTrueLuegoDeQuitarUnElementoPreviamenteColocado() {

        Casillero unCasillero = new Casillero();
        Ubicable unElemento = new UbicableFicticio();

        unCasillero.colocar(unElemento);
        unCasillero.quitar();
        Assert.assertThat( unCasillero.estaVacio(), is( true ) );

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test04AlColocarDebeLanzarExcepcionSiElCasilleroEstaOcupado() {

        Casillero unCasillero = new Casillero();
        Ubicable unElemento = new UbicableFicticio();
        unCasillero.colocar(unElemento);

        thrown.expect(CasilleroOcupadoException.class);
        unCasillero.colocar(unElemento);

    }


    @Test
    public void test05QuitarDebeLanzarExcepcionSiElCasilleroEstaVacio() {

        Casillero unCasillero = new Casillero();

        thrown.expect(CasilleroVacioException.class);
        unCasillero.quitar();
    }

    @Test
    public void test06QuitarDevuelveElElementoPreviamenteColocado() {

        Casillero unCasillero = new Casillero();
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

        Casillero unCasillero = new Casillero();
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
}


