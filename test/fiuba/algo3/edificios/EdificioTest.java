package fiuba.algo3.edificios;

import org.junit.Assert;
import org.junit.Test;

public class EdificioTest {


    @Test
    public void test001CrearUnaPlazaCentral (){

        Edificio unaPlazaCentral = new PlazaCentral();

        Assert.assertEquals(unaPlazaCentral.vidaTotal(),450);
        Assert.assertEquals(unaPlazaCentral.costo(),100);

    }

    @Test
    public void test002CrearUnCuartel (){

        Edificio unCuartel = new Cuartel();

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

        Edificio unCuartel = new Cuartel();
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

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);
        unCuartel.disminuirVida(40);

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),180);
    }

    @Test
    public void test007RepararCuartelSinDanio (){

        Edificio unCuartel = new Cuartel();
        unCuartel.repararse();

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),250);
    }

    @Test
    public void test008RepararCuartelAlMaximoDeVida (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(20);
        unCuartel.repararse();

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),250);
    }

    @Test
    public void test009RepararCuartelMenorAlMaximoDeVida (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(60);
        unCuartel.repararse();

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),240);
    }

    @Test
    public void test010RepararPlazaCentralMenorAlMaximoDeVida (){

        Edificio unaPlazaCentral = new PlazaCentral();
        unaPlazaCentral.disminuirVida(100);
        unaPlazaCentral.repararse();

        Assert.assertEquals(unaPlazaCentral.vidaTotal(),450);
        Assert.assertEquals(unaPlazaCentral.vidaActual(),375);
    }

    @Test
    public void test011RepararCastilloMenorAlMaximoDeVida (){

        Edificio unCastillo = new Castillo();
        unCastillo.disminuirVida(100);
        unCastillo.repararse();

        Assert.assertEquals(unCastillo.vidaTotal(),1000);
        Assert.assertEquals(unCastillo.vidaActual(),915);
    }

    @Test
    public void test012DestruirCuartelVidaActualSiempreMayorOIgualQueCero (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(500);

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),0);
    }

}
