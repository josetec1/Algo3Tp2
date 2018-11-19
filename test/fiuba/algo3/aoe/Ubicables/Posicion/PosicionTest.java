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

    @Test
    public void test17DistanciaEntre2PosicionesQueContienenUnCuadranteConIgualCordenadas() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,5);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 0);
    }

    @Test
    public void test18DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnX() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(6,5);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 2);
    }

    @Test
    public void test19DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnY() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 3);
    }

    @Test
    public void test20DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnXeY() {

        Cuadrante unCuadrante = new Cuadrante(3,6);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 2);
    }

    @Test
    public void test21DistanciaEntrePosicionesQueContienenDosCuadrantesCercanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(3, 7);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        Posicion unaPosicion = new Posicion(cuadrante1);
        unaPosicion.agregar(cuadrante2);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 1);
    }

    @Test
    public void test22DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(2, -1);
        Cuadrante otroCuadrante = new Cuadrante(4,8);

        Posicion unaPosicion = new Posicion(cuadrante1);
        unaPosicion.agregar(cuadrante2);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 2);
    }

    @Test
    public void test23DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConDosCuadrantes() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(2, -1);
        Cuadrante otroCuadrante1 = new Cuadrante(7,9);
        Cuadrante otroCuadrante2 = new Cuadrante(2,11);

        Posicion unaPosicion = new Posicion(cuadrante1);
        unaPosicion.agregar(cuadrante2);
        Posicion otraPosicion = new Posicion(otroCuadrante1);
        otraPosicion.agregar(otroCuadrante2);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 4);
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

        Posicion unaPosicion = new Posicion(cuadrante1);
        unaPosicion.agregar(cuadrante2);
        unaPosicion.agregar(cuadrante3);
        unaPosicion.agregar(cuadrante4);

        Posicion otraPosicion = new Posicion(otroCuadrante1);
        otraPosicion.agregar(otroCuadrante2);
        otraPosicion.agregar(otroCuadrante3);
        otraPosicion.agregar(otroCuadrante4);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 5);
    }

    @Test
    public void test25DistanciaEntrePosicionesUna16CuadrantesOtra1CuadranteDistanciaDeveDevolver3() {

        Posicion posicion = new Posicion();
        for(int i =1;i<9;i++){
            for(int j = 1;j<9;j++){
                posicion.agregar(new Cuadrante(i,j));
            }
        }

        Posicion comparada = new Posicion(new Cuadrante(10,10));
        Assert.assertEquals(posicion.distancia(comparada), 2);
    }


    @Test

    public void test26DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve4(){

        Posicion posicion = new Posicion();
        for(int i =1;i<4;i++){
            for(int j = 1;j<4;j++){
                posicion.agregar(new Cuadrante(i,j));
            }
        }

        Posicion comparada = new Posicion(new Cuadrante(6,1));

        Assert.assertEquals(posicion.distancia(comparada),3);
    }

    @Test
    public void test028DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve20(){

        Posicion posicion = new Posicion();
        for(int i =1;i<4;i++){
            for(int j = 1;j<4;j++){
                posicion.agregar(new Cuadrante(i,j));
            }
        }

        Posicion comparada = new Posicion(new Cuadrante(23,1));
        Assert.assertEquals(posicion.distancia(comparada),20);
    }

    /*@Test
    public void test29DistanciaEntrePosicionesQueContienenNueveCuadrantesCercanosCadaUno() {

        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(12,15);

        for(int i = 1 ; i <= 9; i++)
            for(int j = 1 ; j <= 9; j++)
                posicion1.agregar(new Cuadrante(i,j));

        for(int i = 1 ; i <= 9; i++)
            for(int j = 1 ; j <= 9; j++)
                posicion1.agregar(new Cuadrante(i+12,j+15));


        Assert.assertEquals(posicion1.distancia(posicion2), 6);
    }*/


}




