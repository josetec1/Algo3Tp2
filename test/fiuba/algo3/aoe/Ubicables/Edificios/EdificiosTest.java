package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.EdificioSinDaniarException;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;

public class EdificiosTest {

    @Test
    public void test01CrearPlazaCentralPuedoConstruirPeroNoReparar(){
        PlazaCentral plazaCentral = new PlazaCentral();
        Assert.assertFalse(plazaCentral.puedoReparar());
        Assert.assertTrue(plazaCentral.puedoConstruir());
    }

    @Test
    public void test02CrearCuartelPuedoConstruirPeroNoReparar(){
        Cuartel cuartel = new Cuartel ();
        Assert.assertFalse(cuartel.puedoReparar());
        Assert.assertTrue(cuartel.puedoConstruir());
    }

    @Test
    public void test03CrearCastilloNoPuedoConstruirNoPuedoReparar(){
        Castillo castillo = new Castillo ();
        Assert.assertFalse(castillo.puedoReparar());
        Assert.assertFalse (castillo.puedoConstruir());
    }

    @Test
    public void test04PlazaCentralComenzarConstruccionNoPuedoRepararNoPuedoConstruir(){
        PlazaCentral plazaCentral = new PlazaCentral();
        plazaCentral.comenzarConstruccion ( new Aldeano () );
        Assert.assertFalse(plazaCentral.puedoReparar());
        Assert.assertFalse (plazaCentral.puedoConstruir());
    }

    @Test
    public void test05CuartelComenzarConstruccionNoPuedoRepararNoPuedoConstruir(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano () );
        Assert.assertFalse(cuartel.puedoReparar());
        Assert.assertFalse (cuartel.puedoConstruir());
    }

    @Rule
    public  ExpectedException thrown = ExpectedException.none ();

    @Test
    public void test06CastilloComenzarConstruccionLanzaEdificioNoConstruibleException(){
        Castillo castillo = new Castillo ();
        thrown.expect (EdificioNoConstruibleSinCostoException.class);
        castillo.comenzarConstruccion ( new Aldeano () );
    }

    @Test
    public void test07CuartelComenzarConstruccionEn3TurnospuedoCrearUnidad(){
        Cuartel cuartel = new Cuartel ();
        cuartel.comenzarConstruccion ( new Aldeano () );
        cuartel.huboUnCambioDeTurno ( mock( Jugador.class ) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        cuartel.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertTrue ( cuartel.puedocrearUnidad () );
    }

    @Test
    public void test08CrearCuartelNoPuedoCrearUnidad(){
        Cuartel cuartel = new Cuartel ();
        Assert.assertFalse ( cuartel.puedocrearUnidad () );
    }

    @Test
    public void test09PlazaComenzarConstruccionEn3TurnospuedoCrearUnidad(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        plazaCentral.comenzarConstruccion ( new Aldeano () );
        plazaCentral.huboUnCambioDeTurno ( mock( Jugador.class ) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        Assert.assertTrue ( plazaCentral.puedocrearUnidad () );
    }

    @Test
    public void test09CrearPlazaCentralNoPuedoCrearUnidad(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        Assert.assertFalse ( plazaCentral.puedocrearUnidad () );
    }

    @Test
    public void test10CrearCastilloPuedoCrearUnidad(){
        Castillo castillo = new Castillo ();
        Assert.assertTrue ( castillo.puedocrearUnidad () );
    }

    @Test
    public void test11PlazaConstruidaRepararLanzaEdificioSinDaniarException(){
        PlazaCentral plazaCentral = new PlazaCentral ();
        plazaCentral.comenzarConstruccion ( new Aldeano () );
        plazaCentral.huboUnCambioDeTurno ( mock( Jugador.class ) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        plazaCentral.huboUnCambioDeTurno ( mock(Jugador.class) );
        thrown.expect ( EdificioSinDaniarException.class );
        plazaCentral.reparar ( new Aldeano () );
    }


}
