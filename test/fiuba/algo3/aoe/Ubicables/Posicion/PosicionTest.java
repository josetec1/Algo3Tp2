package fiuba.algo3.aoe.Ubicables.Posicion;

import fiuba.algo3.aoe.Ubicables.Direccion.*;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

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
        Cuadrante unCuadrante = new Cuadrante(4,5);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion();

        Assert.assertFalse(unaPosicion.seSuperponeCon(otraPosicion) );

    }

    @Test
    public void test03SeSuperponeConDebeDarTrueSiLaOtraPosicionTieneLaMismaPosicion() {
        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,5);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion();
        otraPosicion.agregar(otroCuadrante);

        Assert.assertTrue(unaPosicion.seSuperponeCon(otraPosicion) );

    }
    @Test
    public void test05AgregarPermiteAgregarCasillerosRepetidos() {
        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,5);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(unCuadrante);
        unaPosicion.agregar(otroCuadrante);

        Assert.assertTrue(unaPosicion.seSuperponeCon(otraPosicion) );

    }

    @Test
    public void test06SiUnaPosicionTieneUnCasilleroQueEstaEnOtraPosicionSeSuperponen() {
        Cuadrante cuadranteUno = new Cuadrante(4,5);
        Cuadrante cuadranteDos = new Cuadrante(3,5);
        Cuadrante cuadranteTres = new Cuadrante(6,6);

        Posicion unaPosicion = new Posicion(cuadranteUno);
        unaPosicion.agregar(cuadranteDos);

        Posicion posicionSuperpuesta = new Posicion(cuadranteDos);  //superpone

        Posicion posicionNoSuperpuesta= new Posicion(cuadranteTres); //no

        Assert.assertTrue(unaPosicion.seSuperponeCon(posicionSuperpuesta) );
        Assert.assertFalse(unaPosicion.seSuperponeCon(posicionNoSuperpuesta) );

    }

    @Test
    public void test07estaDentroDeDebeDarTrueSiCadaUnoDeLosCasillerosEstaDentroDeLosLimites() {
        Cuadrante cuadranteUno = new Cuadrante(1,10);
        Cuadrante cuadranteDos = new Cuadrante(2,5);
        Cuadrante cuadranteTres = new Cuadrante(10,10);

        Posicion unaPosicion = new Posicion(cuadranteUno);
        unaPosicion.agregar(cuadranteDos);
        unaPosicion.agregar(cuadranteTres);


        Assert.assertTrue(unaPosicion.estasDentroDe(10,10) );


    }

    @Test
    public void test08estaDentroDeDebeDarFalseSiAlgunoDeLosCasillerosNoEstaDentroDeLosLimites() {
        Cuadrante cuadranteUno = new Cuadrante(2,10);
        Cuadrante cuadranteFueraDeLimite = new Cuadrante(15,1);
        Cuadrante cuadranteFueraDeLimite2 = new Cuadrante(10,15);

        Posicion unaPosicion = new Posicion(cuadranteUno);
        unaPosicion.agregar(cuadranteFueraDeLimite);
        unaPosicion.agregar(cuadranteFueraDeLimite2);


        Assert.assertFalse(unaPosicion.estasDentroDe(10,10) );


    }


    @Test
    public void test09CalcularPosicionSiguienteConDireccionDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){

        Cuadrante cuadrante = new Cuadrante(3,5);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));

    }


    @Test
    public void test10CalcularPosicionSiguienteConDireccionArribaDebeDevolverPosicionConCasilleroEnX4Y5(){


        Cuadrante cuadrante = new Cuadrante(4,4);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionArriba();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }


    @Test
    public void test11CalcularPosicionSiguienteConDireccionIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(5,5);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionIzquierda();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

       Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
       Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test12CalcularPosicionSiguienteConDireccionAbajoDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(4,6);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionAbajo();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test13CalcularPosicionSiguienteConDireccionArribaDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(3,4);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionArribaDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test14CalcularPosicionSiguienteConDireccionArribaIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(5,4);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionArribaIzquierda();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test15CalcularPosicionSiguienteConDireccionAbajoIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(5,6);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionAbajoIzquierda();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionOriginal));
    }

    @Test
    public void test15CalcularPosicionSiguienteConDireccionAbajoDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(3,6);
        Posicion posicionOriginal = new Posicion(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        Posicion posicionEsperada = new Posicion(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionAbajoDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

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

        Cuadrante cuadrante = new Cuadrante(1,1);
        Cuadrante cuadrante2 = new Cuadrante(2,1);
        Cuadrante cuadrante3 = new Cuadrante(3,1);

        Posicion posicionOriginal = new Posicion(cuadrante);
                 posicionOriginal.agregar(cuadrante2);

        Posicion posicionEsperada = new Posicion(cuadrante2);
        posicionEsperada.agregar(cuadrante3);

        Posicion posicionNoVaAEstar = new Posicion(cuadrante);

        Posicion posicionSiVaAEstar = new Posicion(cuadrante3);
        Posicion posicionSiVaAEstar2 = new Posicion(cuadrante2);

        Direccionable direccionableNueva = new DireccionDerecha();

        Posicion posicionCalculada = posicionOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionSiVaAEstar));
        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionSiVaAEstar2));

        Assert.assertFalse(posicionCalculada.seSuperponeCon(posicionNoVaAEstar));
        Assert.assertTrue(posicionCalculada.seSuperponeCon(posicionEsperada));
    }

    /*@Test
    public void test17DistanciaEntre2PosicionesQueContienenUnCuadranteConIgualCordenadas() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(5,6);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 0);
    }*/

}




