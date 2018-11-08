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
    public void test007DisminuirVidaDelCuartelYRepararlo (){

        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);
        unCuartel.disminuirVida(40);

        Assert.assertEquals(unCuartel.vidaTotal(),250);
        Assert.assertEquals(unCuartel.vidaActual(),180);
    }

}
