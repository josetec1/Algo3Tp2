package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EdificioTest {


    @Test
    public void test001CrearUnaPlazaCentral (){

        PlazaCentral unaPlazaCentral = new PlazaCentral();

        Assert.assertEquals(unaPlazaCentral.getVidaMaxima(),450);
        Assert.assertEquals(unaPlazaCentral.getCosto(),100);

    }

    @Test
    public void test002CrearUnCuartel (){

        Edificio unCuartel = new Cuartel();

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getCosto(),50);

    }

    @Test
    public void test003CrearUnCastilloDisMinuirVida50YRepararDevuelvenVida965(){

        Edificio unCastillo = Castillo.getInstancia();

        Assert.assertEquals(unCastillo.getVidaMaxima(),1000);
        Assert.assertEquals(unCastillo.getVidaActual(),1000);
        unCastillo.disminuirVida(50);
        Assert.assertEquals(unCastillo.getVidaActual(),950);
        unCastillo.reparar();
        Assert.assertEquals(unCastillo.getVidaActual(),965);
    }


    @Test
    public void test004DisminuirVidaDelCuartelUnaVez (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),220);

    }

    /*@Test
    public void test005DisminuirVidaDelCastilloUnaVez (){

        Edificio unCastillo = Castillo.getInstancia();
        Assert.assertEquals(unCastillo.getVidaActual(),1000);
        unCastillo.disminuirVida(40);

        Assert.assertEquals(unCastillo.getVidaMaxima(),1000);
        Assert.assertEquals(unCastillo.getVidaActual(),960);
    }
*/
    @Test
    public void test006DisminuirVidaDelCuartelDosVeces (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);
        unCuartel.disminuirVida(40);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),180);
    }

    @Test
    public void test007RepararCuartelSinDanio (){

        Edificio unCuartel = new Cuartel();
        thrown.expect(EdificioSinDaniarException.class);
        unCuartel.reparar();
        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),250);
    }


    @Test
    public void test009RepararCuartelMenorAlMaximoDeVida (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(60);

        unCuartel.reparar();

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),240);
    }

    @Test
    public void test010RepararPlazaCentralMenorAlMaximoDeVida (){

        Edificio unaPlazaCentral = new PlazaCentral();
        unaPlazaCentral.disminuirVida(100);
        unaPlazaCentral.reparar();

        Assert.assertEquals(unaPlazaCentral.getVidaMaxima(),450);
        Assert.assertEquals(unaPlazaCentral.getVidaActual(),375);
    }

    @Test
    public void test012DestruirCuartelgetVidaActualSiempreMayorOIgualQueCero (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(500);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),0);
    }

    @Test
    public void test013CuartelEstaEnConstruccion () {

        Edificio unCuartel = new Cuartel();

        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Test
    public void test014CuartelEstaEnConstruccionLuegoDeConstruirseUnaVez () {

        Edificio unCuartel = new Cuartel();
        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }


    /*@Test
    public void test015CuartelLuegoDeConstruirseYaNoEstaEnConstruccion () {

        Edificio unCuartel = new Cuartel();
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Assert.assertFalse(unCuartel.estaEnConstruccion());
    }*/

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test016CastilloGetCostoLanzaUnidadNoConstruiBleException () {

        Edificio castillo = Castillo.getInstancia();
        thrown.expect(EdificioNoConstruibleSinCostoException.class);
        castillo.getCosto();
    }

    @Test
    public void test017CastilloGetPosicionDevuelvePosicionEsperada() {
        Tablero tablero = new Tablero(20,20);
        Edificio castillo = Castillo.getInstancia();
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Casillero(1,2));
        posicion.agregar(new Casillero(1,3));
        posicion.agregar(new Casillero(1,4));
        posicion.agregar(new Casillero(2,2));
        posicion.agregar(new Casillero(2,1));
        posicion.agregar(new Casillero(2,3));
        posicion.agregar(new Casillero(2,4));
        posicion.agregar(new Casillero(3,1));
        posicion.agregar(new Casillero(3,2));
        posicion.agregar(new Casillero(3,3));
        posicion.agregar(new Casillero(3,4));
        posicion.agregar(new Casillero(4,1));
        posicion.agregar(new Casillero(4,2));
        posicion.agregar(new Casillero(4,3));
        posicion.agregar(new Casillero(4,4));
        tablero.colocar(castillo,posicion);
        Assert.assertEquals(castillo.getPosicion(),posicion);
    }

}
