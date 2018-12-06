package fiuba.algo3.aoe.modelo.Ubicables.Edificios;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;

import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable.*;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;




public class EstadoEdificiosTestConstruible {

    private Castillo castillo = new Castillo();

    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private PlazaCentral plaza;
    private Jugador jugador;

    @Before
    public void setUp(){
        plaza = new PlazaCentral();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        jugador = new Jugador("ElDiego",castillo,plaza,aldeanos);
    }






    @Test
    public void test01EstadoEdificioAConstruirPuedoConstruirNoPuedoReparar(){
        EstadoEdificioConstruible estado = new EstadoAConstruir();
        Assert.assertTrue ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none ();

    @Test
    public void test02EstadoEdificioAConstruirConstruirLlamaCorrectamenteAEdificioIniciarConstruccion(){
        EstadoEdificioConstruible estado = new EstadoAConstruir();
        PlazaCentral plaza = new PlazaCentral ();
        estado.construir ( plaza,new Aldeano (),jugador );
        thrown.expect ( EdificioEnConstruccionException.class );
        plaza.construir ( new Aldeano (),jugador );
    }

    @Test
    public void test03EstadoEdificioAConstruirRepararLanzaEdificioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificioConstruible estado = new EstadoAConstruir();
        thrown.expect ( EdificioNoPuedeRepararseEnEsteMomentoException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test04EstadoEdificioAConstruirLiberarAldeanoLanzaEdificioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificioConstruible estado = new EstadoAConstruir();
        thrown.expect ( EdificioNoEstaSiendoConstruidoOReparadoException.class );
        estado.liberarAldeano ();
    }

    @Test
    public void test05EstadoEdificioAConstruirNuevoTurnoNoCambia(){
        EstadoEdificioConstruible estado = new EstadoAConstruir();
        estado.nuevoTurno ( new PlazaCentral (),1 );
        Assert.assertFalse ( estado.puedoReparar () );
        Assert.assertTrue ( estado.puedoConstruir ());
    }

    @Test
    public void test06EstadoEdificioDaniadoNoPuedoConstruirPuedoReparar(){
        EstadoEdificioConstruible estado = new EstadoDaniado();
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertTrue ( estado.puedoReparar () );
    }

    @Test
    public void test07EstadoEdificioDaniadoConstruirLanzaEdificioYaConstruidoException(){
        EstadoEdificioConstruible estado = new EstadoDaniado();
        thrown.expect ( EdificioYaConstruidoException.class );
        estado.construir ( new PlazaCentral (),new Aldeano (),jugador );
    }

    @Test
    public void test08EstadoEdificioAConstruirNuevoTurnoNoCambia(){
        EstadoEdificioConstruible estado = new EstadoDaniado();
        estado.nuevoTurno ( new PlazaCentral (),1 );
        Assert.assertTrue ( estado.puedoReparar () );
        Assert.assertFalse ( estado.puedoConstruir ());
    }

    @Test
    public void test09EstadoEdificioDaniadoPuedoConstruirUnidadTrue(){
        EstadoEdificioConstruible estado = new EstadoDaniado();

        Assert.assertTrue ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test11EstadoEdificioDaniadoLiberarAldeanoEdifcioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificioConstruible estado = new EstadoDaniado();
        thrown.expect ( EdificioNoEstaSiendoConstruidoOReparadoException.class );
        estado.liberarAldeano ();
    }

    @Test
    public void test12EstadoEdificioAConstruirPuedoConstruirUnidadFalse(){
        EstadoEdificioConstruible estado = new EstadoAConstruir();

        Assert.assertFalse ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test13EstadoEdificioEnConstruccionNoPuedoConstruirNoPuedoReparar(){
        EstadoEdificioConstruible estado = new EstadoEnConstruccion(new Aldeano (),1);
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }


    @Test
    public void test14EstadoEdificioEnConstruccionRepararLanzaEdificioNoPuedeRepararseEnEsteMomento(){
        EstadoEdificioConstruible estado = new EstadoEnConstruccion(new Aldeano (),1);
        thrown.expect ( EdificioNoPuedeRepararseEnEsteMomentoException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test15EstadoEdificioEnConstruccionConstruirLanzaEdificioEnConstruccionException(){
        EstadoEdificioConstruible estado = new EstadoEnConstruccion(new Aldeano (),1);
        thrown.expect ( EdificioEnConstruccionException.class );
        estado.construir ( new PlazaCentral (),new Aldeano (),jugador );

    }

   @Test
    public void test16EstadoEdificioEnConstruccionLiberarAldeanoAldeanoPuedeRepararYConstruir(){
        Aldeano aldeano = new Aldeano ();
        EstadoEdificioConstruible estado = new EstadoEnConstruccion(aldeano,1);
        estado.liberarAldeano ();
        Assert.assertTrue ( aldeano.estasDisponible () );
    }

    @Test
    public void test17EstadoEdificioEnConstruccion1TurnoCambiaAEdificioNormal(){
        Aldeano aldeano = new Aldeano ();
        EstadoEdificioConstruible estado = new EstadoEnConstruccion(aldeano,1);
        PlazaCentral plaza = new PlazaCentral();
        estado.nuevoTurno (plaza,1 );
        Assert.assertTrue ( plaza.puedocrearUnidad () );
    }

    @Test
    public void test18EstadoEdificioEnConstruccionPuedoConstruirUnidadDevuelveFalse(){
        EstadoEdificioConstruible estado = new EstadoEnConstruccion(new Aldeano (),1);
        Assert.assertFalse ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test19EstadoEdificioEnReparacionNoPuedoConstruirNoPuedoReparar(){
        EstadoEdificioConstruible estado = new EstadoEnReparacion(new Aldeano ());
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }


    @Test
    public void test20EstadoEdificioEnReparacionRepararLanzaEdificioNoPuedeRepararseEnEsteMomento(){
        EstadoEdificioConstruible estado = new EstadoEnReparacion(new Aldeano ());
        thrown.expect ( EdificioEnReparacionException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test21EstadoEdificioEnReparacionConstruirLanzaEdificioEnConstruccionException(){
        EstadoEdificioConstruible estado = new EstadoEnReparacion(new Aldeano ());
        thrown.expect ( EdificioYaConstruidoException.class );
        estado.construir ( new PlazaCentral (),new Aldeano (),jugador );

    }

    @Test
    public void test22EstadoEdificioEnReparacionLiberarAldeanoAldeanoPuedeRepararYConstruir(){
        Aldeano aldeano = new Aldeano ();
        EstadoEdificioConstruible estado = new EstadoEnReparacion(aldeano);
        estado.liberarAldeano ();
        Assert.assertTrue ( aldeano.estasDisponible () );
    }

    @Test
    public void test23EstadoEdificioEnReparacion1TurnoCambiaAEdificioNormal(){
        Mapa mapa = Mockito.mock(Mapa.class);
        Aldeano aldeano = new Aldeano ();
        EstadoEdificioConstruible estado = new EstadoEnReparacion (aldeano);
        PlazaCentral plaza = new PlazaCentral();
        plaza.finalizarConstruccion ();
        plaza.disminuirVida ( 25 ,jugador,mapa);
        estado.nuevoTurno (plaza,25 );
        Assert.assertFalse ( plaza.puedoReparar ());
    }

    @Test
    public void test24EstadoEdificioReparacionPuedoConstruirUnidadDevuelveFalse(){
        EstadoEdificioConstruible estado = new EstadoEnReparacion(new Aldeano ());
        Assert.assertFalse ( estado.puedoCrearUnidad () );
    }

    @Test
    public void test25EstadoEdificioNormalNoPuedoConstruirNoPuedoReparar(){
        EstadoEdificioConstruible estado = new EstadoNormal();
        Assert.assertFalse ( estado.puedoConstruir () );
        Assert.assertFalse ( estado.puedoReparar () );
    }



    @Test
    public void test26EstadoEdificioNormalConstruirLanzaEdificioConstruidoException(){
        EstadoEdificioConstruible estado = new EstadoNormal();
        PlazaCentral plaza = new PlazaCentral ();
        thrown.expect ( EdificioYaConstruidoException.class );
        estado.construir ( plaza,new Aldeano (),jugador );
    }

    @Test
    public void test27EstadoEdificioNormalRepararLanzaEdificioSinDaniarException(){
        EstadoEdificioConstruible estado = new EstadoNormal();
        thrown.expect ( EdificioSinDaniarException.class );
        estado.reparar ( new PlazaCentral (),new Aldeano () );

    }

    @Test
    public void test28EstadoEdificioNormalLiberarAldeanoLanzaEdificioNoEstaSiendoConstruidoOReparadoException(){
        EstadoEdificioConstruible estado = new EstadoNormal();
        thrown.expect ( EdificioNoEstaSiendoConstruidoOReparadoException.class );
        estado.liberarAldeano ();
    }

    @Test
    public void test29EstadoEdificioNormalNuevoTurnoNoCambia(){
        EstadoEdificioConstruible estado = new EstadoNormal();
        estado.nuevoTurno ( new PlazaCentral (),1 );
        Assert.assertFalse ( estado.puedoReparar () );
        Assert.assertFalse ( estado.puedoConstruir ());
    }

}
