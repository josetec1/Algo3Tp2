package fiuba.algo3.aoe.Jugador;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.RecursoInsuficienteException;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.NoSePuedeConstruirEnEsteMomentoException;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
//import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
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

/*
    @Test
    public void test04JugadorCon200OroAgregarEspadachinDevuelveOro150(){
        Posicion posicion = new Posicion(1,1);
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable espadachin0 = new Espadachin();
        jugador.sumarOro(200);
        jugador.agregarUbicable(espadachin0,posicion);
        Assert.assertEquals(jugador.getOro(),150);
    }
*/

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

    @Test
    public void test09HayOroSuficienteDevuelveFalseSiSeNecesitaOro500YHayOro300(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        jugador1.sumarOro(300);
        Assert.assertFalse(jugador1.hayOroSuficiente(500));
    }

    @Test
    public void test010JugadorReclutarEspadachinConOro25DevuelveRecursoInsuficienteException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarEspadachin(cuartel);
    }

    @Test
    public void test011JugadorReclutarArqueroConOro25DevuelveRecursoInsuficienteException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        jugador.construirCuartel(mock(Aldeano.class),mock(Posicion.class));
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArquero(cuartel);
    }

    @Test
    public void test012JugadorReclutarAldeanoConOro15DevuelveRecursoInsuficienteException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        jugador.sumarOro(15);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarAldeano(plaza);
    }

    @Test
    public void test013JugadorReclutarArmaDeAsedioConOro25DevuelveRecursoInsuficienteException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Castillo castillo= new Castillo();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArmaDeAsedio(castillo);

    }


    @Test
    public void test014JugadorReclutarArmaDeAsedioConOro25DevuelveRecursoInsuficienteException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Castillo castillo= new Castillo();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArmaDeAsedio(castillo);

    }

    @Test
    public void test015JugadorReclutarAldeanoEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        PlazaCentral plaza = new PlazaCentral();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarAldeano(plaza);
    }

    @Test
    public void test016JugadorReclutarArqueroEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Cuartel cuartel= new Cuartel();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArquero(cuartel);
    }

    @Test
    public void test017JugadorReclutarEspadachinEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Cuartel cuartel= new Cuartel();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarEspadachin(cuartel);
    }


    @Test
    public void test018JugadorReclutarAldeanoEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        PlazaCentral plaza = new PlazaCentral();
        plaza.disminuirVida(150);
        plaza.construir();
        plaza.construir();
        plaza.construir();
        plaza.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarAldeano(plaza);
    }

    @Test
    public void test019JugadorReclutarArqueroEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Cuartel cuartel = new Cuartel();
        cuartel.disminuirVida(150);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        cuartel.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArquero(cuartel);
    }

    @Test
    public void test020JugadorReclutarEspadachinEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Cuartel cuartel = new Cuartel();
        cuartel.disminuirVida(150);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        cuartel.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarEspadachin(cuartel);
    }

    @Test
    public void test020JugadorReclutarArmaDeAsedioEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        Castillo castillo = new Castillo();
        castillo.disminuirVida(150);
        castillo.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArmaDeAsedio(castillo);
    }

}
