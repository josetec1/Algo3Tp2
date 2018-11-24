package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Ubicables.Edificios.EstadoEdificable.*;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EstadoEdificiosTest {

    @Test
    public void test01EstadoEdificioAConstruirPuedoConstruirNoPuedoReparar(){
        EstadoEdificio estado = new EstadoAConstruir ();
        Assert.assertTrue ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none ();

    @Test
    public void test02EstadoEdificioAConstruirConstruirLlamaCorrectamenteAEdificioIniciarConstruccion(){
        EstadoEdificio estado = new EstadoAConstruir ();
        PlazaCentral plaza = new PlazaCentral ();
        estado.construir ( plaza,new Aldeano () );
        thrown.expect ( EdificioEnConstruccionException.class );
        plaza.construir ( new Aldeano () );
    }

    @Test
    public void test03EstadoEdificioAConstruirRepararLanzaEdificioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificio estado = new EstadoAConstruir ();
        thrown.expect ( EdificioNoPuedeRepararseEnEsteMomentoException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test04EstadoEdificioAConstruirLiberarAldeanoLanzaEdificioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificio estado = new EstadoAConstruir ();
        thrown.expect ( EdificioNoEstaSiendoConstruidoOReparadoException.class );
        estado.liberarAldeano ();
    }

    @Test
    public void test05EstadoEdificioAConstruirNuevoTurnoNoCambia(){
        EstadoEdificio estado = new EstadoAConstruir ();
        estado.nuevoTurno ( new PlazaCentral (),1 );
        Assert.assertFalse ( estado.puedoReparar () );
        Assert.assertTrue ( estado.puedoConstruir ());
    }

    @Test
    public void test06EstadoEdificioDaniadoNoPuedoConstruirPuedoReparar(){
        EstadoEdificio estado = new EstadoDaniado ();
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertTrue ( estado.puedoReparar () );
    }

    @Test
    public void test07EstadoEdificioDaniadoConstruirLanzaEdificioYaConstruidoException(){
        EstadoEdificio estado = new EstadoDaniado ();
        thrown.expect ( EdificioYaConstruidoException.class );
        estado.construir ( new PlazaCentral (),new Aldeano () );
    }

    @Test
    public void test08EstadoEdificioAConstruirNuevoTurnoNoCambia(){
        EstadoEdificio estado = new EstadoDaniado ();
        estado.nuevoTurno ( new PlazaCentral (),1 );
        Assert.assertTrue ( estado.puedoReparar () );
        Assert.assertFalse ( estado.puedoConstruir ());
    }

    @Test
    public void test09EstadoEdificioDaniadoPuedoConstruirUnidadTrue(){
        EstadoEdificio estado = new EstadoDaniado ();

        Assert.assertTrue ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test11EstadoEdificioDaniadoLiberarAldeanoEdifcioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificio estado = new EstadoDaniado ();
        thrown.expect ( EdificioNoEstaSiendoConstruidoOReparadoException.class );
        estado.liberarAldeano ();
    }

    @Test
    public void test12EstadoEdificioAConstruirPuedoConstruirUnidadFalse(){
        EstadoEdificio estado = new EstadoAConstruir ();

        Assert.assertFalse ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test13EstadoEdificioEnConstruccionNoPuedoConstruirNoPuedoReparar(){
        EstadoEdificio estado = new EstadoEnConstruccion (new Aldeano (),1);
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }


    @Test
    public void test14EstadoEdificioEnConstruccionRepararLanzaEdificioNoPuedeRepararseEnEsteMomento(){
        EstadoEdificio estado = new EstadoEnConstruccion (new Aldeano (),1);
        thrown.expect ( EdificioNoPuedeRepararseEnEsteMomentoException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test15EstadoEdificioEnConstruccionConstruirLanzaEdificioEnConstruccionException(){
        EstadoEdificio estado = new EstadoEnConstruccion (new Aldeano (),1);
        thrown.expect ( EdificioEnConstruccionException.class );
        estado.construir ( new PlazaCentral (),new Aldeano () );

    }

   @Test
    public void test16EstadoEdificioEnConstruccionLiberarAldeanoAldeanoPuedeRepararYConstruir(){
        Aldeano aldeano = new Aldeano ();
        EstadoEdificio estado = new EstadoEnConstruccion (aldeano,1);
        estado.liberarAldeano ();
        Assert.assertTrue ( aldeano.estasDisponible () );
    }

    @Test
    public void test17EstadoEdificioEnConstruccion1TurnoCambiaAEdificioNormal(){
        Aldeano aldeano = new Aldeano ();
        EstadoEdificio estado = new EstadoEnConstruccion (aldeano,1);
        PlazaCentral plaza = new PlazaCentral();
        estado.nuevoTurno (plaza,1 );
        Assert.assertTrue ( plaza.puedocrearUnidad () );
    }

    @Test
    public void test18EstadoEdificioEnConstruccionPuedoConstruirUnidadDevuelveFalse(){
        EstadoEdificio estado = new EstadoEnConstruccion (new Aldeano (),1);
        Assert.assertFalse ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test19EstadoEdificioEnReparacionNoPuedoConstruirNoPuedoReparar(){
        EstadoEdificio estado = new EstadoEnReparacion (new Aldeano ());
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }


    @Test
    public void test20EstadoEdificioEnReparacionRepararLanzaEdificioNoPuedeRepararseEnEsteMomento(){
        EstadoEdificio estado = new EstadoEnReparacion (new Aldeano ());
        thrown.expect ( EdificioEnReparacionException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test21EstadoEdificioEnReparacionConstruirLanzaEdificioEnConstruccionException(){
        EstadoEdificio estado = new EstadoEnReparacion (new Aldeano ());
        thrown.expect ( EdificioYaConstruidoException.class );
        estado.construir ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test22EstadoEdificioEnReparacionLiberarAldeanoAldeanoPuedeRepararYConstruir(){
        Aldeano aldeano = new Aldeano ();
        EstadoEdificio estado = new EstadoEnReparacion (aldeano);
        estado.liberarAldeano ();
        Assert.assertTrue ( aldeano.estasDisponible () );
    }

    @Test
    public void test23EstadoEdificioEnReparacion1TurnoCambiaAEdificioNormal(){
        Aldeano aldeano = new Aldeano ();
        EstadoEdificio estado = new EstadoEnReparacion (aldeano);
        PlazaCentral plaza = new PlazaCentral();
        plaza.finalizarConstruccion ();
        plaza.disminuirVida ( 25 );
        estado.nuevoTurno (plaza,25 );
        Assert.assertFalse ( plaza.puedoReparar ());
    }

    @Test
    public void test24EstadoEdificioReparacionPuedoConstruirUnidadDevuelveFalse(){
        EstadoEdificio estado = new EstadoEnReparacion (new Aldeano ());
        Assert.assertFalse ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test25EstadoEdificioNormalNoPuedoConstruirNoPuedoReparar(){
        EstadoEdificio estado = new EstadoNormal ();
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }



    @Test
    public void test26EstadoEdificioNormalConstruirLanzaEdificioConstruidoException(){
        EstadoEdificio estado = new EstadoNormal ();
        PlazaCentral plaza = new PlazaCentral ();
        thrown.expect ( EdificioYaConstruidoException.class );
        estado.construir ( plaza,new Aldeano () );
    }

    @Test
    public void test27EstadoEdificioNormalRepararLanzaEdificioSinDaniarException(){
        EstadoEdificio estado = new EstadoNormal ();
        thrown.expect ( EdificioSinDaniarException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test28EstadoEdificioNormalLiberarAldeanoLanzaEdificioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificio estado = new EstadoNormal ();
        thrown.expect ( EdificioNoEstaSiendoConstruidoOReparadoException.class );
        estado.liberarAldeano ();
    }

    @Test
    public void test29EstadoEdificioNormalNuevoTurnoNoCambia(){
        EstadoEdificio estado = new EstadoNormal ();
        estado.nuevoTurno ( new PlazaCentral (),1 );
        Assert.assertFalse ( estado.puedoReparar () );
        Assert.assertFalse ( estado.puedoConstruir ());
    }

}
