package fiuba.algo3.edificios;

import org.junit.Assert;
import org.junit.Test;

public class EdificioTest {


    @Test
    public void test001CrearUnaPlazaCentral (){

        EdificioConstruible unaPlazaCentral = new PlazaCentral();

        Assert.assertEquals(unaPlazaCentral.vidaTotal(),450);
        Assert.assertEquals(unaPlazaCentral.costo(),100);

    }

    @Test
    public void test002CrearUnCuartel (){

        EdificioConstruible unCuartel = new Cuartel();

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.costo(),50);

    }

    @Test
    public void test003CrearUnCastillo (){

        Edificio unCastillo = new Castillo();

        Assert.assertEquals(unCastillo.vidaTotal(),1000);

    }

    @Test
    public void test004DisminuirVidaDelCuartelUnaVez (){

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),220);

    }

    @Test
    public void test005DisminuirVidaDelCastilloUnaVez (){

        Edificio unCastillo = new Castillo();
        unCastillo.disminuirVida(40);

        Assert.assertEquals(unCastillo.vidaTotal(),1000);
        Assert.assertEquals(unCastillo.vidaActual(),960);
    }

    @Test
    public void test006DisminuirVidaDelCuartelDosVeces (){

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);
        unCuartel.disminuirVida(40);

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),180);
    }

    @Test
    public void test007RepararCuartelSinDanio (){

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.reparar();

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),250);
    }

    @Test
    public void test008RepararCuartelAlMaximoDeVida (){

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.disminuirVida(20);
        unCuartel.reparar();

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),250);
    }

    @Test
    public void test009RepararCuartelMenorAlMaximoDeVida (){

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.disminuirVida(60);
        unCuartel.reparar();

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),240);
    }

    @Test
    public void test010RepararPlazaCentralMenorAlMaximoDeVida (){

        EdificioConstruible unaPlazaCentral = new PlazaCentral();
        unaPlazaCentral.disminuirVida(100);
        unaPlazaCentral.reparar();

        Assert.assertEquals(unaPlazaCentral.vidaTotal(),450);
        Assert.assertEquals(unaPlazaCentral.vidaActual(),375);
    }

    @Test
    public void test011RepararCastilloMenorAlMaximoDeVida (){

        Edificio unCastillo = new Castillo();
        unCastillo.disminuirVida(100);
        unCastillo.reparar();

        Assert.assertEquals(unCastillo.vidaTotal(),1000);
        Assert.assertEquals(unCastillo.vidaActual(),915);
    }

    @Test
    public void test012DestruirCuartelVidaActualSiempreMayorOIgualQueCero (){

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.disminuirVida(500);

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),0);
    }

    @Test
    public void test013CuartelEstaEnConstruccion () {

        EdificioConstruible unCuartel = new Cuartel();

        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Test
    public void test014CuartelEstaEnConstruccionLuegoDeConstruirseUnaVez () {

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.construir();

        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Test
    public void test014CuartelEstaEnConstruccionLuegoDeConstruirseDosVeces () {

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.construir();
        unCuartel.construir();

        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Test
    public void test015CuartelLuegoDeConstruirseYaNoEstaEnConstruccion () {

        EdificioConstruible unCuartel = new Cuartel();
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        Assert.assertFalse(unCuartel.estaEnConstruccion());
    }


}
