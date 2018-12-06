package Entrega2;

import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Test;

public class DistanciaTest {

    /************************ PRUEBAS DE DISTANCIA DE CUADRANTES *************************************/

    @Test
    public void test01distanciaDeDosCuadrantesConMismaPosicion() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 1, 1 );

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 0);
    }

    @Test
    public void test02distanciaDeDosCuadrantesConDistintaPosicionEnY() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 1, 5 );

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 4);
    }

    @Test
    public void test03distanciaDeDosCuadrantesConDistintaPosicionEnX() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 6, 1 );

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 5);
    }

    @Test
    public void test04distanciaDeDosCuadrantesConDistintaPosicionConXIgualAY() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 7, 7 );

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 6);
    }

    @Test
    public void test05distanciaDeDosCuadrantesConDistintaPosicionConXDistintoDeY() {
        Cuadrante cuadrante1 = new Cuadrante( 1, 1 );
        Cuadrante cuadrante2 = new Cuadrante( 2, 4 );

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 3);
    }

    @Test
    public void test06distanciaDeDosCuadrantesConCoordenadasNegativas() {
        Cuadrante cuadrante1 = new Cuadrante( -1, -1);
        Cuadrante cuadrante2 = new Cuadrante( -1, -4 );

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 3);
    }

    @Test
    public void test07distanciaDeDosCuadrantesConCoordenadasPositivaYNegativas() {
        Cuadrante cuadrante1 = new Cuadrante( -1, -1);
        Cuadrante cuadrante2 = new Cuadrante( 1, 4 );

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 5);
    }

    @Test
    public void test08distanciaDeDosCuadrantesConCoordenadasIgualA0() {
        Cuadrante cuadrante1 = new Cuadrante( 0, 0);
        Cuadrante cuadrante2 = new Cuadrante( 0, 0);

        Assert.assertEquals(cuadrante1.distancia(cuadrante2), 0);
    }

    /************************ PRUEBAS DE DISTANCIA DE POSICIONES *************************************/


    @Test
    public void test09DistanciaEntre2PosicionesQueContienenUnCuadranteConIgualCordenadas() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,5);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 0);
    }

    @Test
    public void test10DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnX() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(6,5);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 2);
    }

    @Test
    public void test11DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnY() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 3);
    }

    @Test
    public void test12DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnXeY() {

        Cuadrante unCuadrante = new Cuadrante(3,6);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        PosicionReal unaPosicionReal = new PosicionReal(unCuadrante);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 2);
    }

    @Test
    public void test13DistanciaEntrePosicionesQueContienenDosCuadrantesCercanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(3, 7);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        PosicionReal unaPosicionReal = new PosicionReal(cuadrante1);
        unaPosicionReal.agregar(cuadrante2);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 1);
    }

    @Test
    public void test14DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(2, -1);
        Cuadrante otroCuadrante = new Cuadrante(4,8);

        PosicionReal unaPosicionReal = new PosicionReal(cuadrante1);
        unaPosicionReal.agregar(cuadrante2);
        PosicionReal otraPosicionReal = new PosicionReal(otroCuadrante);

        Assert.assertEquals(unaPosicionReal.distancia(otraPosicionReal), 2);
    }

    @Test
    public void test15DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConDosCuadrantes() {

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
    public void test16DistanciaEntrePosicionesQueContienenCuatroCuadrantesCercanosCadaUno() {

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
    public void test17DistanciaEntrePosicionesUna16CuadrantesOtra1CuadranteDistanciaDeveDevolver3() {

        PosicionReal posicionReal = new PosicionReal(1,1);
        for(int i =1;i<9;i++){
            for(int j = 1;j<9;j++){

                if (!((i==1)&(j==1))){posicionReal.agregar(new Cuadrante(i,j));}

            }
        }

        PosicionReal comparada = new PosicionReal(new Cuadrante(10,10));
        Assert.assertEquals(posicionReal.distancia(comparada), 2);
    }


    @Test

    public void test18DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve4(){

        PosicionReal posicionReal = new PosicionReal(1,1);
        for(int i =1;i<4;i++){
            for(int j = 1;j<4;j++){
                if (!((i==1)&(j==1))){posicionReal.agregar(new Cuadrante(i,j));}
            }
        }

        PosicionReal comparada = new PosicionReal(new Cuadrante(6,1));

        Assert.assertEquals(posicionReal.distancia(comparada),3);
    }

    @Test
    public void test019DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve20(){

        PosicionReal posicionReal = new PosicionReal(1,1);
        for(int i =1;i<4;i++){
            for(int j = 1;j<4;j++){
                if (!((i==1)&(j==1))){posicionReal.agregar(new Cuadrante(i,j));}
            }
        }

        PosicionReal comparada = new PosicionReal(new Cuadrante(23,1));
        Assert.assertEquals(posicionReal.distancia(comparada),20);
    }

    @Test
    public void test20DistanciaEntrePosicionesQueContienenNueveCuadrantesCercanosCadaUno() {

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
