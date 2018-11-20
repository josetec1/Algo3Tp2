package Entrega2;

import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
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
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 0);
    }

    @Test
    public void test10DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnX() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(6,5);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 2);
    }

    @Test
    public void test11DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnY() {

        Cuadrante unCuadrante = new Cuadrante(4,5);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 3);
    }

    @Test
    public void test12DistanciaEntre2PosicionesQueContienenUnCuadranteConDistintasCordenadasEnXeY() {

        Cuadrante unCuadrante = new Cuadrante(3,6);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        Posicion unaPosicion = new Posicion(unCuadrante);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 2);
    }

    @Test
    public void test13DistanciaEntrePosicionesQueContienenDosCuadrantesCercanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(3, 7);
        Cuadrante otroCuadrante = new Cuadrante(4,8);
        Posicion unaPosicion = new Posicion(cuadrante1);
        unaPosicion.agregar(cuadrante2);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 1);
    }

    @Test
    public void test14DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConUnCuadrante() {

        Cuadrante cuadrante1 = new Cuadrante(3,6);
        Cuadrante cuadrante2 = new Cuadrante(2, -1);
        Cuadrante otroCuadrante = new Cuadrante(4,8);

        Posicion unaPosicion = new Posicion(cuadrante1);
        unaPosicion.agregar(cuadrante2);
        Posicion otraPosicion = new Posicion(otroCuadrante);

        Assert.assertEquals(unaPosicion.distancia(otraPosicion), 2);
    }

    @Test
    public void test15DistanciaEntrePosicionesQueContienenDosCuadrantesLejanosYOtraConDosCuadrantes() {

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
    public void test16DistanciaEntrePosicionesQueContienenCuatroCuadrantesCercanosCadaUno() {

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
    public void test17DistanciaEntrePosicionesUna16CuadrantesOtra1CuadranteDistanciaDeveDevolver3() {

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

    public void test18DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve4(){

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
    public void test019DistanciaEntrePosicionesUna9CuadrantesOtra1Devuelve20(){

        Posicion posicion = new Posicion();
        for(int i =1;i<4;i++){
            for(int j = 1;j<4;j++){
                posicion.agregar(new Cuadrante(i,j));
            }
        }

        Posicion comparada = new Posicion(new Cuadrante(23,1));
        Assert.assertEquals(posicion.distancia(comparada),20);
    }

    @Test
    public void test20DistanciaEntrePosicionesQueContienenNueveCuadrantesCercanosCadaUno() {

        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(12,15);

        for(int i = 1 ; i <= 9; i++)
            for(int j = 1 ; j <= 9; j++)
                posicion1.agregar(new Cuadrante(i,j));

        for(int i = 1 ; i <= 9; i++)
            for(int j = 1 ; j <= 9; j++)
                posicion2.agregar(new Cuadrante(i+12,j+15));


        Assert.assertEquals(posicion1.distancia(posicion2), 6);
    }
}
