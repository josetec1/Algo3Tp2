package fiuba.algo3.aoe.Jugador;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.LimiteDePoblacionAlcanzadoException;
import fiuba.algo3.aoe.Jugadores.RecursoInsuficienteException;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.NoSePuedeConstruirEnEsteMomentoException;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.EstadoReparando;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

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
        jugador.agregarNotificable();(espadachin0,posicion);
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
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(1,1));
    }

    @Test
    public void test011JugadorReclutarArqueroConOro25DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArquero(cuartel,new Posicion(2,2));
    }


    @Test
    public void test012JugadorReclutarAldeanoConOro15DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        jugador.sumarOro(15);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarAldeano(plaza,new Posicion(2,2));
    }

    @Test
    public void test013JugadorReclutarArmaDeAsedioConOro25DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Castillo castillo= new Castillo();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(1,1));

    }


    @Test
    public void test014JugadorReclutarArmaDeAsedioConOro25DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Castillo castillo= new Castillo();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(1,1));

    }

    @Test
    public void test015JugadorReclutarAldeanoEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        PlazaCentral plaza = new PlazaCentral();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarAldeano(plaza,mock(Posicion.class));
    }

    @Test
    public void test016JugadorReclutarArqueroEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel= new Cuartel();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArquero(cuartel,new Posicion(1,1));
    }

    @Test
    public void test017JugadorReclutarEspadachinEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel= new Cuartel();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(1,1));
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
        jugador.reclutarAldeano(plaza,mock(Posicion.class));
    }

    @Test
    public void test019JugadorReclutarArqueroEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel = new Cuartel();
        cuartel.disminuirVida(150);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        cuartel.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArquero(cuartel,new Posicion(1,1));
    }

    @Test
    public void test020JugadorReclutarEspadachinEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel = new Cuartel();
        cuartel.disminuirVida(150);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        cuartel.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(1,1));
    }

    @Test
    public void test020JugadorReclutarArmaDeAsedioEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Castillo castillo = new Castillo();
        castillo.disminuirVida(150);
        castillo.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(4,4));
    }

    @Test
    public void testt21JugadorReclutarEspadachinConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(9999999);
        for(int i = 0;i<50;i++){
            jugador.reclutarEspadachin(cuartel,new Posicion(1,i+1));
        }
        Assert.assertEquals(jugador.alcanzoLimiteDePoblacion(),true);
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(90,90));
    }

    @Test
    public void testt22JugadorReclutarArqueroConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(9999999);
        for(int i = 0;i<50;i++){
            jugador.reclutarEspadachin(cuartel,new Posicion(1,i+1));
        }
        Assert.assertEquals(jugador.alcanzoLimiteDePoblacion(),true);
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarArquero(cuartel,new Posicion( 90,90));
    }

    @Test
    public void testt23JugadorReclutarAldeanoConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){

        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        jugador.sumarOro(9999999);
        for(int i = 0;i<50;i++){
            jugador.reclutarAldeano(plaza,mock(Posicion.class));
        }
        Assert.assertEquals(jugador.alcanzoLimiteDePoblacion(),true);
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarAldeano(plaza,mock(Posicion.class));
    }

    @Test
    public void testt24JugadorReclutarArmaDeAsedioConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Castillo castillo = new Castillo();
        jugador.sumarOro(9999999);
        for(int i = 0;i<50;i++){
            jugador.reclutarArmaDeAsedio(castillo,new Posicion(1,i+1));
        }
        Assert.assertEquals(jugador.alcanzoLimiteDePoblacion(),true);
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(70,70));
    }


    @Test
    public void testt25JugadorConLimiteDePoblacionAlcanzadoElininarAldeanoDevuelveLimiteDePoblacionFalse(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        jugador.sumarOro(9999999);
        for(int i = 0;i<49;i++){
            jugador.agregarNotificable(new Arquero());
        }
        Aldeano aldeano = new Aldeano();
        jugador.agregarNotificable(aldeano);
        Assert.assertEquals(jugador.alcanzoLimiteDePoblacion(),true);
        jugador.eliminarUnidad(aldeano);
        Assert.assertEquals(jugador.alcanzoLimiteDePoblacion(),false);
    }

    @Test
    public void test26JugadorCon5TengoOroParaPlazaCentralPorTurnoSiEliminoUnoMasBajaOroPorTurnoYLanzaRecursoInsuficienteException(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();
        mapa.colocar(aldeano1,new Posicion(5,4));
        mapa.colocar(aldeano2,new Posicion(5,5));
        mapa.colocar(aldeano3,new Posicion(5,6));
        jugador.agregarNotificable(aldeano1);
        jugador.agregarNotificable(aldeano2);
        jugador.agregarNotificable(aldeano3);
        jugador.habilitar();
        jugador.reclutarEspadachin(cuartel,new Posicion(1,1));
        jugador.eliminarUnidad(aldeano1);
        jugador.eliminarUnidad(aldeano2);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(2,2));
    }


    @Test
    public void test28ConstruirPlazaConstruyeYUbicaLaPlazaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        jugador.sumarOro(999);
        Aldeano aldeano= new Aldeano();
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Cuadrante(1,2));
        posicion.agregar(new Cuadrante(2,1));
        posicion.agregar(new Cuadrante(2,2));
        jugador.construirPlaza(aldeano,posicion);
        Assert.assertEquals(mapa.puedoColocar(posicion),false);
    }

    @Test
    public void test29ConstruirPlazaSinOroLanzaRecursoInsuficienteException(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Aldeano aldeano= new Aldeano();
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Cuadrante(1,2));
        posicion.agregar(new Cuadrante(2,1));
        posicion.agregar(new Cuadrante(2,2));
        thrown.expect(RecursoInsuficienteException.class);
        jugador.construirPlaza(aldeano,posicion);
    }

    @Test
    public void test30ConstruirPlazaConstruyeYUbicaLaPlazaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        jugador.sumarOro(999);
        Aldeano aldeano= new Aldeano();
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Cuadrante(1,2));
        posicion.agregar(new Cuadrante(2,1));
        posicion.agregar(new Cuadrante(2,2));
        jugador.construirCuartel(aldeano,posicion);
        Assert.assertEquals(mapa.puedoColocar(posicion),false);
    }

    @Test
    public void test31ConstruirCuartelSinOroLanzaRecursoInsuficienteException(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Aldeano aldeano= new Aldeano();
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Cuadrante(1,2));
        posicion.agregar(new Cuadrante(2,1));
        posicion.agregar(new Cuadrante(2,2));
        thrown.expect(RecursoInsuficienteException.class);
        jugador.construirPlaza(aldeano,posicion);
    }

}
