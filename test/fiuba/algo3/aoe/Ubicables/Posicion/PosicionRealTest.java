package fiuba.algo3.aoe.Ubicables.Posicion;

import fiuba.algo3.aoe.Ubicables.Direccion.*;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class PosicionRealTest {


    @Test
    public void test01DosPosicionesVaciasNoSeSuperponen() {
            PosicionReal unaPosicionReal = new PosicionReal();
            PosicionReal otraPosicionReal = new PosicionReal();

        Assert.assertFalse(unaPosicionReal.seSuperponeCon(otraPosicionReal) );

    }

    @Test
    public void test02SeSuperponeConDebeDarFalseSiLaOtraPosicionEstaVacia() {
        Cuadrante unCuadrante = new Cuadrante(4,5);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal();

        Assert.assertFalse(unaPosicionReal.seSuperponeCon(otraPosicionReal) );

    }

    @Test
    public void test03SeSuperponeConDebeDarTrueSiLaOtraPosicionTieneLaMismaPosicion() {
        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,5);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal();
        otraPosicionReal.agregar(otroCuadrante);

        Assert.assertTrue(unaPosicionReal.seSuperponeCon(otraPosicionReal) );

    }
    @Test
    public void test05AgregarPermiteAgregarCasillerosRepetidos() {
        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,5);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(unCuadrante);
        unaPosicionReal.agregar(otroCuadrante);

        Assert.assertTrue(unaPosicionReal.seSuperponeCon(otraPosicionReal) );

    }

    @Test
    public void test06SiUnaPosicionTieneUnCasilleroQueEstaEnOtraPosicionSeSuperponen() {
        Cuadrante cuadranteUno = new Cuadrante(4,5);
        Cuadrante cuadranteDos = new Cuadrante(3,5);
        Cuadrante cuadranteTres = new Cuadrante(6,6);

        PosicionReal unaPosicionReal = new PosicionReal(cuadranteUno);
        unaPosicionReal.agregar(cuadranteDos);

        PosicionReal posicionRealSuperpuesta = new PosicionReal(cuadranteDos);  //superpone

        PosicionReal posicionRealNoSuperpuesta = new PosicionReal(cuadranteTres); //no

        Assert.assertTrue(unaPosicionReal.seSuperponeCon(posicionRealSuperpuesta) );
        Assert.assertFalse(unaPosicionReal.seSuperponeCon(posicionRealNoSuperpuesta) );

    }

    @Test
    public void test07estaDentroDeDebeDarTrueSiCadaUnoDeLosCasillerosEstaDentroDeLosLimites() {
        Cuadrante cuadranteUno = new Cuadrante(1,10);
        Cuadrante cuadranteDos = new Cuadrante(2,5);
        Cuadrante cuadranteTres = new Cuadrante(10,10);

        PosicionReal unaPosicionReal = new PosicionReal(cuadranteUno);
        unaPosicionReal.agregar(cuadranteDos);
        unaPosicionReal.agregar(cuadranteTres);


        Assert.assertTrue(unaPosicionReal.estasDentroDe(10,10) );


    }

    @Test
    public void test08estaDentroDeDebeDarFalseSiAlgunoDeLosCasillerosNoEstaDentroDeLosLimites() {
        Cuadrante cuadranteUno = new Cuadrante(2,10);
        Cuadrante cuadranteFueraDeLimite = new Cuadrante(15,1);
        Cuadrante cuadranteFueraDeLimite2 = new Cuadrante(10,15);

        PosicionReal unaPosicionReal = new PosicionReal(cuadranteUno);
        unaPosicionReal.agregar(cuadranteFueraDeLimite);
        unaPosicionReal.agregar(cuadranteFueraDeLimite2);


        Assert.assertFalse(unaPosicionReal.estasDentroDe(10,10) );


    }


    @Test
    public void test09CalcularPosicionSiguienteConDireccionDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){

        Cuadrante cuadrante = new Cuadrante(3,5);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionDerecha();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));

    }


    @Test
    public void test10CalcularPosicionSiguienteConDireccionArribaDebeDevolverPosicionConCasilleroEnX4Y5(){


        Cuadrante cuadrante = new Cuadrante(4,4);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionArriba();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));
    }


    @Test
    public void test11CalcularPosicionSiguienteConDireccionIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(5,5);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionIzquierda();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

       Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
       Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));
    }

    @Test
    public void test12CalcularPosicionSiguienteConDireccionAbajoDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(4,6);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionAbajo();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));
    }

    @Test
    public void test13CalcularPosicionSiguienteConDireccionArribaDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(3,4);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionArribaDerecha();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));
    }

    @Test
    public void test14CalcularPosicionSiguienteConDireccionArribaIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(5,4);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionArribaIzquierda();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));
    }

    @Test
    public void test15CalcularPosicionSiguienteConDireccionAbajoIzquierdaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(5,6);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionAbajoIzquierda();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));
    }

    @Test
    public void test15CalcularPosicionSiguienteConDireccionAbajoDerechaDebeDevolverPosicionConCasilleroEnX4Y5(){
        Cuadrante cuadrante = new Cuadrante(3,6);
        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);

        Cuadrante cuadranteSiguiente = new Cuadrante(4,5);
        PosicionReal posicionRealEsperada = new PosicionReal(cuadranteSiguiente);

        Direccionable direccionableNueva = new DireccionAbajoDerecha();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealOriginal));
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

        PosicionReal posicionRealOriginal = new PosicionReal(cuadrante);
                 posicionRealOriginal.agregar(cuadrante2);

        PosicionReal posicionRealEsperada = new PosicionReal(cuadrante2);
        posicionRealEsperada.agregar(cuadrante3);

        PosicionReal posicionRealNoVaAEstar = new PosicionReal(cuadrante);

        PosicionReal posicionRealSiVaAEstar = new PosicionReal(cuadrante3);
        PosicionReal posicionRealSiVaAEstar2 = new PosicionReal(cuadrante2);

        Direccionable direccionableNueva = new DireccionDerecha();

        Posicion posicionRealCalculada = posicionRealOriginal.calcularPosicionSiguiente(direccionableNueva);

        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealSiVaAEstar));
        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealSiVaAEstar2));

        Assert.assertFalse(posicionRealCalculada.seSuperponeCon(posicionRealNoVaAEstar));
        Assert.assertTrue(posicionRealCalculada.seSuperponeCon(posicionRealEsperada));
    }

    @Test
    public void test17DistanciaEntre2PosicionesQueContienenUnCuadranteConIgualCordenadas() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,5);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 0);
    }

    @Test
    public void test18DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnX() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(6,5);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 2);
    }

    @Test
    public void test19DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnY() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 3);
    }

    @Test
    public void test20DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnXeY() {

        Cuadrante unCuadrante = new Cuadrante(3,6);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 2);
    }

    @Test
    public void test21DistanciaEntrePosicionesQueContienenDosCuadrantesCercanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(3, 7);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        PosicionReal unaPosicionReal = new PosicionReal(cuadrante1);
        unaPosicionReal.agregar(cuadrante2);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 1);
    }

    @Test
    public void test22DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(2, -1);
        Cuadrante otroCuadrante = new Cuadrante(4,8);

        PosicionReal unaPosicionReal = new PosicionReal(cuadrante1);
        unaPosicionReal.agregar(cuadrante2);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 2);
    }

    @Test
    public void test23DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConDosCuadrantes() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(2, -1);
        Cuadrante otroCuadrante1 = new Cuadrante(7,9);
        Cuadrante otroCuadrante2 = new Cuadrante(2,11);

        PosicionReal unaPosicionReal = new PosicionReal(cuadrante1);
        unaPosicionReal.agregar(cuadrante2);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante1);
        otraPosicionReal.agregar(otroCuadrante2);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 4);
    }

    @Test
    public void test24DistanciaEntrePosicionesQueContienenCuatroCuadrantesCercanosCadaUno() {

        Cuadrante cuadrante1 = new Cuadrante(1,1);
        Cuadrante cuadrante2 = new Cuadrante(1, 2);
        Cuadrante cuadrante3 = new Cuadrante(2, 1);
        Cuadrante cuadrante4 = new Cuadrante(2, 2);

        Cuadrante otroCuadrante1 = new Cuadrante(7,7);
        Cuadrante otroCuadrante2 = new Cuadrante(7,8);
        Cuadrante otroCuadrante3 = new Cuadrante(8,7);
        Cuadrante otroCuadrante4 = new Cuadrante(8,8);

        PosicionReal unaPosicionReal = new PosicionReal(cuadrante1);
        unaPosicionReal.agregar(cuadrante2);
        unaPosicionReal.agregar(cuadrante3);
        unaPosicionReal.agregar(cuadrante4);

        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante1);
        otraPosicionReal.agregar(otroCuadrante2);
        otraPosicionReal.agregar(otroCuadrante3);
        otraPosicionReal.agregar(otroCuadrante4);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 5);
    }

    @Test
    public void test25DistanciaEntrePosicionesUna16CuadrantesOtra1CuadranteDistanciaDeveDevolver3() {

        PosicionReal posicionReal = new PosicionReal();
        for(int i =1;i<9;i++){
            for(int j = 1;j<9;j++){
                posicionReal.agregar(new Cuadrante(i,j));
            }
        }

        PosicionReal comparada = new PosicionReal(new Cuadrante(10,10));
        Assert.assertEquals(posicionReal.distancia(comparada), 2);
    }


    @Test

    public void test26DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve4(){

        PosicionReal posicionReal = new PosicionReal();
        for(int i =1;i<4;i++){
            for(int j = 1;j<4;j++){
                posicionReal.agregar(new Cuadrante(i,j));
            }
        }

        PosicionReal comparada = new PosicionReal(new Cuadrante(6,1));

        Assert.assertEquals(posicionReal.distancia(comparada),3);
    }

    @Test
    public void test028DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve20(){

        PosicionReal posicionReal = new PosicionReal();
        for(int i =1;i<4;i++){
            for(int j = 1;j<4;j++){
                posicionReal.agregar(new Cuadrante(i,j));
            }
        }

        PosicionReal comparada = new PosicionReal(new Cuadrante(23,1));
        Assert.assertEquals(posicionReal.distancia(comparada),20);
    }

    @Test
    public void test029ExpandirPosicionUnitariaATamanio4DevuelvePosicionEsperada(){
        PosicionReal posicionRealInicial = new PosicionReal(1,1);

        Posicion posicionRealEsperada = posicionRealInicial.expandir(4);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1,1)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1,2)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1,3)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1,4)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2,1)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2,2)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2,3)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2,4)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(3,1)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(3,2)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(3,3)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(3,4)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(4,1)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(4,2)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(4,3)),true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(4,4)),true);
    }

    @Test
    public void test030ExpandirPosicionUnitariaATamanio2DevuelvePosicionEsperada() {
        PosicionReal posicionRealInicial = new PosicionReal(1, 1);

        Posicion posicionRealEsperada = posicionRealInicial.expandir(2);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1, 1)), true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1, 2)), true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2, 1)), true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2, 2)), true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1, 3)), false);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1, 3)), false);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(3, 1)), false);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(3, 2)), false);
    }

    @Test
    public void test031ExpandirPosicionUnitariaATamanio1DevuelvePosicionEsperada() {
        PosicionReal posicionRealInicial = new PosicionReal(1, 1);
        Posicion posicionRealEsperada = posicionRealInicial.expandir(1);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1, 1)), true);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(1, 2)), false);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2, 2)), false);
        Assert.assertEquals(posicionRealEsperada.seSuperponeCon(new PosicionReal(2, 1)), false);

    }

    @Test
    public void test32DistanciaEntrePosicionesQueContienenNueveCuadrantesCercanosCadaUno() {

        PosicionReal posicionReal1 = new PosicionReal(0,0);
        PosicionReal posicionReal2 = new PosicionReal(12,15);

        for(int i = 1 ; i <= 9; i++)
            for(int j = 1 ; j <= 9; j++)
                posicionReal1.agregar(new Cuadrante(i,j));

        for(int i = 1 ; i <= 9; i++)
            for(int j = 1 ; j <= 9; j++)
                posicionReal2.agregar(new Cuadrante(i+12,j+15));


        Assert.assertEquals(posicionReal1.distancia(posicionReal2), 6);
    }


}




