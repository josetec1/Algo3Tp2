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
    public void test09CalcularPosicionSiguienteConDireccionDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){

        Casillero casillero = new Casillero(3,5);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));

    }


    @Test
    public void test10CalcularPosicionSiguienteConDireccionArribaDebeDevolverPosicionConCasilleroEnX4Y5(){


        Casillero casillero = new Casillero(4,4);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionArriba();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }


    @Test
    public void test11CalcularPosicionSiguienteConDireccionIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(5,5);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionIzquierda();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

       Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
       Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test12CalcularPosicionSiguienteConDireccionAbajoDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(4,6);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionAbajo();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test13CalcularPosicionSiguienteConDireccionArribaDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(3,4);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionArribaDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test14CalcularPosicionSiguienteConDireccionArribaIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(5,4);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionArribaIzquierda();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test15CalcularPosicionSiguienteConDireccionAbajoIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(5,6);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionAbajoIzquierda();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test15CalcularPosicionSiguienteConDireccionAbajoDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Casillero casillero = new Casillero(3,6);
        Posicion posicionOriginal = new Posicion(casillero);

        Casillero casilleroSiguiente = new Casillero(4,5);
        Posicion posicionEsperada = new Posicion(casilleroSiguiente);

        Direccion direccionNueva = new DireccionAbajoDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test16CalcularPosicionSiguienteConVariosElementosSeAplicaACadaUno(){
        // Ejemplo
        // posicion  1.1  y 2.1  al desplzarlas deberia quedar
        // posicion  2.1 y 3.1
        // 1.1 no superpone.
        // 2.1 y 3.1 si

        Casillero casillero = new Casillero(1,1);
        Casillero casillero2 = new Casillero(2,1);
        Casillero casillero3 = new Casillero(3,1);

        Posicion posicionOriginal = new Posicion(casillero);
                 posicionOriginal.agregar(casillero2);

        Posicion posicionEsperada = new Posicion(casillero2);
        posicionEsperada.agregar(casillero3);

        Posicion posicionNoVaAEstar = new Posicion(casillero);

        Posicion posicionSiVaAEstar = new Posicion(casillero3);
        Posicion posicionSiVaAEstar2 = new Posicion(casillero2);

        Direccion direccionNueva = new DireccionDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionSiVaAEstar));
        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionSiVaAEstar2));

        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionNoVaAEstar));
        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
    }

}




