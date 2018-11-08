package fiuba.algo3.aoe;

import Ubicables.Unidades.movimiento.*;
import fiuba.algo3.aoe.Tablero.Casillero;
import fiuba.algo3.aoe.Tablero.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

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

    @Test
    public void test09CalcularPosicionSiguienteDireccionDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(3,5);
        Posicion posicion = new Posicion(casillero);
        DireccionDerecha direccionNueva = new DireccionDerecha();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }

    @Test
    public void test10CalcularPosicionSiguienteDireccionArribaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(4,4);
        Posicion posicion = new Posicion(casillero);
        DireccionArriba direccionNueva = new DireccionArriba();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }

    @Test
    public void test11CalcularPosicionSiguienteDireccionIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(4,6);
        Posicion posicion = new Posicion(casillero);
        DireccionAbajo direccionNueva = new DireccionAbajo();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }

    @Test
    public void test12CalcularPosicionSiguienteDireccionAbajoDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(4,6);
        Posicion posicion = new Posicion(casillero);
        DireccionAbajo direccionNueva = new DireccionAbajo();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }

    @Test
    public void test13CalcularPosicionSiguienteDireccionArribaDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(3,4);
        Posicion posicion = new Posicion(casillero);
        DireccionArribaDerecha direccionNueva = new DireccionArribaDerecha();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }

    @Test
    public void test14CalcularPosicionSiguienteDireccionArribaIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(5,4);
        Posicion posicion = new Posicion(casillero);
        DireccionArribaIzquierda direccionNueva = new DireccionArribaIzquierda();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }

    @Test
    public void test15CalcularPosicionSiguienteDireccionAbajoIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(5,6);
        Posicion posicion = new Posicion(casillero);
        DireccionAbajoIzquierda direccionNueva = new DireccionAbajoIzquierda();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }

    @Test
    public void test15CalcularPosicionSiguienteDireccionAbajoDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(3,6);
        Posicion posicion = new Posicion(casillero);
        DireccionAbajoDerecha direccionNueva = new DireccionAbajoDerecha();
        Posicion posicionNueva = posicion.calcularPosicionSiguiente(direccionNueva);

        List<Casillero> casillerosNuevos = posicionNueva.getCasilleros();
        for (Casillero casilleroActual : casillerosNuevos) {
            Assert.assertEquals(casilleroActual.getY(), 5);
            Assert.assertEquals(casilleroActual.getX(), 4);
        }
    }
}




