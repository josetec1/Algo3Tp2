package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionArriba;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.MaquinariaMilitar.UnidadYaRealizoMovimientoEsteTurnoException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import static org.mockito.Matchers.any;


import java.util.Map;

import static org.hamcrest.core.Is.is;

public class ArmaDeAsedioTest {
    private Castillo castillo= new Castillo();
    @Test
    public void test01SeCreaCorrectamenteArmaDeAsedio(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",castillo );
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        Assert.assertEquals(armaDeAsedio.getVidaMaxima(), 150);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 150);
        Assert.assertEquals(armaDeAsedio.getCosto(),200);
    }

    @Test
    public void test02Disminuir50VidaArmaDeAsedioDevuelve100DeVida(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",castillo );
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 100);
    }

    @Test
    public void test03Disminuir50VidaArmaDeAsedioCrearNuevaArmaDeAsedioDevuelve150DeVida(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",castillo );
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 100);
        ArmaDeAsedio armaDeAsedioSecundaria = new ArmaDeAsedio();
        Assert.assertEquals(armaDeAsedioSecundaria.getVidaActual(), 150);

    }

    @Test
    public void test04MoverArmaDeAsedioRecienCreadaMueveALaPosicionCorrecta(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.puedoAgregar(any(UnidadMovil.class))).thenReturn(true);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        Posicion origen = new Posicion ( 1,1 );
        Posicion deseada = new Posicion ( 1,2 );
        mapa.colocar ( armaDeAsedio,origen );
        DireccionArriba direccionArriba = new DireccionArriba ();
        armaDeAsedio.mover ( mapa,direccionArriba,jugador);
        Assert.assertTrue ( armaDeAsedio.getPosicion ().seSuperponeCon ( deseada ) );
        Assert.assertFalse ( armaDeAsedio.getPosicion ().seSuperponeCon ( origen) );
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none ();

    @Test
    public void test05MoverArmaDeAsedioYaMovidaLanzaUnidadYaRealizoMovimientosEsteTurnoException(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.puedoAgregar(any(UnidadMovil.class))).thenReturn(true);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        Posicion origen = new Posicion ( 1,1 );
        Posicion movimiento1= new Posicion ( 1,3);
        mapa.colocar ( armaDeAsedio,origen );
        DireccionArriba direccionArriba = new DireccionArriba ();
        armaDeAsedio.mover ( mapa,direccionArriba,jugador);
        thrown.expect ( UnidadYaRealizoMovimientoEsteTurnoException.class );
        armaDeAsedio.mover ( mapa,direccionArriba ,jugador);
    }

    @Test
    public void test06ArmaDeAsedioInicializadaNoPuedeMoverseNoPuedeAtacar(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Assert.assertFalse ( armaDeAsedio.puedeAtacar () );
        Assert.assertTrue ( armaDeAsedio.puedeMoverse ());
    }

    @Test
    public void test07ArmaDeAsedioMovidaNoPuedeMoverseNoPuedeAtacar(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.puedoAgregar(any(UnidadMovil.class))).thenReturn(true);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
        Mapa mapa = new Mapa ( 200,200 );
        Posicion origen = new Posicion ( 1,1 );

        mapa.colocar ( armaDeAsedio,origen );
        DireccionArriba direccionArriba = new DireccionArriba ();
        armaDeAsedio.mover (mapa,direccionArriba,jugador );
        Assert.assertFalse ( armaDeAsedio.puedeMoverse () );
        Assert.assertFalse ( armaDeAsedio.puedeAtacar () );
    }

}
