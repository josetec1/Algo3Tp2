package fiuba.algo3.aoe;

import fiuba.algo3.aoe.Tablero.Casillero;
import fiuba.algo3.aoe.Tablero.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

public class PosicionTest {


    @Test
    public void test01DosPosicionesVaciasNoSeSuperponen() {
            Posicion unaPosicion = new Posicion();
            Posicion otraPosicion = new Posicion();

        Assert.assertFalse(unaPosicion.seSuperponeCon(otraPosicion) );

    }

    @Test
    public void test02SeSuperponeConDebeDarFalseSiLaOtraPosicionEstaVacia() {
        Casillero unCasillero = new Casillero(4,5);
        Posicion unaPosicion = new Posicion(unCasillero);
        Posicion otraPosicion = new Posicion();

        Assert.assertFalse(unaPosicion.seSuperponeCon(otraPosicion) );

    }

    @Test
    public void test03SeSuperponeConDebeDarTrueSiLaOtraPosicionTieneLaMismaPosicion() {
        Casillero unCasillero = new Casillero(4,5);
        Casillero otroCasillero = new Casillero (4,5);
        Posicion unaPosicion = new Posicion(unCasillero);
        Posicion otraPosicion = new Posicion();
        otraPosicion.agregar(otroCasillero);

        Assert.assertTrue(unaPosicion.seSuperponeCon(otraPosicion) );

    }
    @Test
    public void test05AgregarPermiteAgregarCasillerosRepetidos() {
        Casillero unCasillero = new Casillero(4,5);
        Casillero otroCasillero = new Casillero (4,5);
        Posicion unaPosicion = new Posicion(unCasillero);
        Posicion otraPosicion = new Posicion(unCasillero);
        unaPosicion.agregar(otroCasillero);

        Assert.assertTrue(unaPosicion.seSuperponeCon(otraPosicion) );

    }

    @Test
    public void test06SiUnaPosicionTieneUnCasilleroQueEstaEnOtraPosicionSeSuperponen() {
        Casillero casilleroUno = new Casillero(4,5);
        Casillero casilleroDos = new Casillero (3,5);
        Casillero casilleroTres = new Casillero (6,6);

        Posicion unaPosicion = new Posicion(casilleroUno);
        unaPosicion.agregar(casilleroDos);

        Posicion posicionSuperpuesta = new Posicion(casilleroDos);  //superpone

        Posicion posicionNoSuperpuesta= new Posicion(casilleroTres); //no

        Assert.assertTrue(unaPosicion.seSuperponeCon(posicionSuperpuesta) );
        Assert.assertFalse(unaPosicion.seSuperponeCon(posicionNoSuperpuesta) );

    }

    @Test
    public void test07estaDentroDeDebeDarTrueSiCadaUnoDeLosCasillerosEstaDentroDeLosLimites() {
        Casillero casilleroUno = new Casillero(1,10);
        Casillero casilleroDos = new Casillero (2,5);
        Casillero casilleroTres = new Casillero (10,10);

        Posicion unaPosicion = new Posicion(casilleroUno);
        unaPosicion.agregar(casilleroDos);
        unaPosicion.agregar(casilleroTres);


        Assert.assertTrue(unaPosicion.estasDentroDe(10,10) );


    }

    @Test
    public void test08estaDentroDeDebeDarFalseSiAlgunoDeLosCasillerosNoEstaDentroDeLosLimites() {
        Casillero casilleroUno = new Casillero(2,10);
        Casillero casilleroFueraDeLimite = new Casillero (15,1);
        Casillero casilleroFueraDeLimite2 = new Casillero (10,15);

        Posicion unaPosicion = new Posicion(casilleroUno);
        unaPosicion.agregar(casilleroFueraDeLimite);
        unaPosicion.agregar(casilleroFueraDeLimite2);


        Assert.assertFalse(unaPosicion.estasDentroDe(10,10) );


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


