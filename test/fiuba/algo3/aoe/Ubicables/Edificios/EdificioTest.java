package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;

public class EdificioTest {


    @Test
    public void test001CrearUnaPlazaCentral (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        PlazaCentral unaPlazaCentral = new PlazaCentral(mockedJugador);

        Assert.assertEquals(unaPlazaCentral.getVidaMaxima(),450);
        Assert.assertEquals(unaPlazaCentral.getCosto(),100);

    }

    @Test
    public void test002CrearUnCuartel (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getCosto(),50);

    }

    @Test
    public void test003CrearUnCastilloDisMinuirVida50YRepararDevuelvenVida965(){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCastillo = new Castillo(mockedJugador);

        Assert.assertEquals(unCastillo.getVidaMaxima(),1000);
        Assert.assertEquals(unCastillo.getVidaActual(),1000);
        unCastillo.disminuirVida(50);
        Assert.assertEquals(unCastillo.getVidaActual(),950);
        unCastillo.reparar();
        Assert.assertEquals(unCastillo.getVidaActual(),965);
    }


    @Test
    public void test004DisminuirVidaDelCuartelUnaVez (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        unCuartel.disminuirVida(30);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),220);

    }

    @Test
    public void test006DisminuirVidaDelCuartelDosVeces (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        unCuartel.disminuirVida(30);
        unCuartel.disminuirVida(40);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),180);
    }

    @Test
    public void test007RepararCuartelSinDanio (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        thrown.expect(EdificioSinDaniarException.class);
        unCuartel.reparar();
        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),250);
    }


    @Test
    public void test009RepararCuartelMenorAlMaximoDeVida (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        unCuartel.disminuirVida(60);
        unCuartel.construir();
        unCuartel.construir();
        thrown.expect(EdificioConstruidoException.class);
        unCuartel.construir();

        unCuartel.reparar();

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),240);
    }

    @Test
    public void test010RepararPlazaCentralMenorAlMaximoDeVida (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unaPlazaCentral = new PlazaCentral(mockedJugador);
        unaPlazaCentral.construir();
        unaPlazaCentral.construir();
        thrown.expect(EdificioConstruidoException.class);
        unaPlazaCentral.construir();
        unaPlazaCentral.disminuirVida(100);
        unaPlazaCentral.reparar();

        Assert.assertEquals(unaPlazaCentral.getVidaMaxima(),450);
        Assert.assertEquals(unaPlazaCentral.getVidaActual(),375);
    }

    @Test
    public void test012DestruirCuartelgetVidaActualSiempreMayorOIgualQueCero (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        unCuartel.disminuirVida(500);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),0);
    }

    @Test
    public void test013CuartelEstaEnConstruccion () {
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);

        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Test
    public void test014CuartelEstaEnConstruccionLuegoDeConstruirseUnaVez () {
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test016CastilloGetCostoLanzaUnidadNoConstruiBleException () {
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio castillo = new Castillo(mockedJugador);
        thrown.expect(EdificioNoConstruibleSinCostoException.class);
        castillo.getCosto();
    }

    @Test
    public void test017CastilloGetPosicionDevuelvePosicionEsperada() {
        Mapa mapa = new Mapa(20,20);

        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio castillo = new Castillo(jugador);
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Cuadrante(1,2));
        posicion.agregar(new Cuadrante(1,3));
        posicion.agregar(new Cuadrante(1,4));
        posicion.agregar(new Cuadrante(2,2));
        posicion.agregar(new Cuadrante(2,1));
        posicion.agregar(new Cuadrante(2,3));
        posicion.agregar(new Cuadrante(2,4));
        posicion.agregar(new Cuadrante(3,1));
        posicion.agregar(new Cuadrante(3,2));
        posicion.agregar(new Cuadrante(3,3));
        posicion.agregar(new Cuadrante(3,4));
        posicion.agregar(new Cuadrante(4,1));
        posicion.agregar(new Cuadrante(4,2));
        posicion.agregar(new Cuadrante(4,3));
        posicion.agregar(new Cuadrante(4,4));
        mapa.colocar(castillo,posicion);
        Assert.assertEquals(castillo.getPosicion(),posicion);
    }

    @Test
    public void test019CrearCuartelRepararCuartelLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);

        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio cuartel = new Cuartel(jugador);
        thrown.expect(EdificioSinDaniarException.class);
        cuartel.reparar();
    }

    @Test
    public void test020RepararCuartelConstruidoVidaMaximaLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio cuartel = new Cuartel(jugador);
        cuartel.construir();
        cuartel.construir();
        thrown.expect(EdificioConstruidoException.class);
        cuartel.construir();
        cuartel.reparar();
        thrown.expect(EdificioSinDaniarException.class);
        cuartel.reparar();
    }

    @Test
    public void test021ConstruirCuartelConstruccionTerminadaLanzaEdificioConstruidoException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio cuartel = new Cuartel(jugador);
        cuartel.construir();
        cuartel.construir();
        thrown.expect(EdificioConstruidoException.class);
        cuartel.construir();
    }

    @Test
    public void test022CrearPlazaCentralRepararLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio plaza = new PlazaCentral(jugador);
        thrown.expect(EdificioSinDaniarException.class);
        plaza.reparar();
    }

    @Test
    public void test023RepararPlazaConstruidaVidaMaximaLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio plaza = new PlazaCentral(jugador);
        plaza.construir();
        plaza.construir();
        thrown.expect(EdificioConstruidoException.class);
        plaza.construir();
        plaza.reparar();
        thrown.expect(EdificioSinDaniarException.class);
        plaza.reparar();
    }

    @Test
    public void test024ConstruirPlazaConstruccionTerminadaLanzaEdificioConstruidoException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio plaza = new PlazaCentral(jugador);
        plaza.construir();
        plaza.construir();
        thrown.expect(EdificioConstruidoException.class);
        plaza.construir();
        plaza.reparar();
    }


    @Test
    public void test025CrearCastilloRepararLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio castillo = new Castillo(jugador);
        thrown.expect(EdificioSinDaniarException.class);
        castillo.reparar();
    }

    @Test
    public void test026ConstruirEdificioLanzaEdificioNoConstruibleSinCostoException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Edificio castillo = new Castillo(jugador);
        thrown.expect(EdificioNoConstruibleSinCostoException.class);
        castillo.construir();
    }

    @Test
    public void test027EdificioDeJugadorMauricioPerteneceAJugadorMauricio(){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador jugador = new Jugador("Mauricio", mockedMapa);
        Edificio cuartel = new Cuartel(jugador);
        Assert.assertTrue(cuartel.perteneceAJugador(jugador));
    }

    @Test
    public void test028CastilloCreaArmaDeAsedio(){
        Castillo castillo = new Castillo((mock(Jugador.class)));
        Ubicable unidad =  castillo.construirArmaDeAsedio();
        Assert.assertTrue(unidad instanceof ArmaDeAsedio);
    }

    @Test
    public void test029CuartelCreaArquero(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Cuartel cuartel = new Cuartel(jugador);
        Ubicable unidad = cuartel.construirArquero();
        Assert.assertTrue(unidad instanceof Arquero);
    }

    @Test
    public void test030CuartelCreaEspadachin(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Cuartel cuartel = new Cuartel(jugador);
        Ubicable unidad = cuartel.construirEspadachin();
        Assert.assertTrue(unidad instanceof Espadachin);
    }

    @Test
    public void test031PlazaCentralCreaAldeano(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        PlazaCentral plazaCentral = new PlazaCentral(jugador);
        Ubicable unidad = plazaCentral.construirAldeano();
        Assert.assertTrue(unidad instanceof Aldeano);
    }

}

