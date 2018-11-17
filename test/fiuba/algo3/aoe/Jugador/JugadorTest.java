package fiuba.algo3.aoe.Jugador;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.RecursoInsuficienteException;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;

public class JugadorTest {

     @Test
     public void test01CrearJugadorCreaJugadorConNombreMauricioOro0Test(){
         Mapa mapa = new Mapa(10,20);
         Jugador jugador1 = new Jugador("Mauricio", mapa);
         Assert.assertEquals(jugador1.getNombre(), "Mauricio");
         Assert.assertEquals(jugador1.getOro(), 0);
     }

     @Test
     public void test02JugadorSumarOro200Suma200DeOro(){
         Mapa mapa = new Mapa(20,20);
         Jugador jugador = new Jugador("Mauricio", mapa);
         jugador.sumarOro(200);
         Assert.assertEquals(jugador.getOro(),200);
     }

    @Test
    public void test03JugadorSumarOro300DescontarOro100Devuelve200DeOro(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        jugador.sumarOro(300);
        jugador.descontarOro(100);
        Assert.assertEquals(jugador.getOro(),200);
    }


    @Test
    public void test04JugadorCon200OroAgregarEspadachinDevuelveOro150(){
        Posicion posicion = new Posicion(1,1);
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable espadachin0 = new Espadachin(jugador);
        jugador.sumarOro(200);
        jugador.agregarUbicable(espadachin0,posicion);
        Assert.assertEquals(jugador.getOro(),150);
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test06DescontarOro500CuandoOroActualEs300LanzaRecursoInsuficienteExeption(){
         Mapa mapa = new Mapa(10,10);
         Jugador jugador1 = new Jugador("Mauricio", mapa);
         jugador1.sumarOro(300);
         thrown.expect(RecursoInsuficienteException.class);
         jugador1.descontarOro(500);
    }

    @Test
    public void test07HayOroSuficienteDevuelveTrueSiSeQuiereGastar500YSeTieneOro600(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        jugador1.sumarOro(600);
        Assert.assertTrue(jugador1.hayOroSuficiente(500));
    }

    @Test
    public void test08HayOroSuficienteDevuelveFalseSiSeQuiereGastar500YSeTieneOro300(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        jugador1.sumarOro(300);
        Assert.assertFalse(jugador1.hayOroSuficiente(500));
    }



}
