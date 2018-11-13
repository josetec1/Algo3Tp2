package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.Espadachin;
import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;

public class EdificioTest {


    @Test
    public void test001CrearUnaPlazaCentral (){
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        PlazaCentral unaPlazaCentral = new PlazaCentral(mockedJugador);

        Assert.assertEquals(unaPlazaCentral.getVidaMaxima(),450);
        Assert.assertEquals(unaPlazaCentral.getCosto(),100);

    }

    @Test
    public void test002CrearUnCuartel (){
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getCosto(),50);

    }

    @Test
    public void test003CrearUnCastilloDisMinuirVida50YRepararDevuelvenVida965(){
        Tablero mockedTablero = mock(Tablero.class);
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
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        unCuartel.disminuirVida(30);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),220);

    }

    @Test
    public void test006DisminuirVidaDelCuartelDosVeces (){
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        unCuartel.disminuirVida(30);
        unCuartel.disminuirVida(40);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),180);
    }

    @Test
    public void test007RepararCuartelSinDanio (){
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        thrown.expect(EdificioSinDaniarException.class);
        unCuartel.reparar();
        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),250);
    }


    @Test
    public void test009RepararCuartelMenorAlMaximoDeVida (){
        Tablero mockedTablero = mock(Tablero.class);
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
        Tablero mockedTablero = mock(Tablero.class);
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
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        unCuartel.disminuirVida(500);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),0);
    }

    @Test
    public void test013CuartelEstaEnConstruccion () {
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);

        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Test
    public void test014CuartelEstaEnConstruccionLuegoDeConstruirseUnaVez () {
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel(mockedJugador);
        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test016CastilloGetCostoLanzaUnidadNoConstruiBleException () {
        Tablero mockedTablero = mock(Tablero.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio castillo = new Castillo(mockedJugador);
        thrown.expect(EdificioNoConstruibleSinCostoException.class);
        castillo.getCosto();
    }

    @Test
    public void test017CastilloGetPosicionDevuelvePosicionEsperada() {
        Tablero tablero = new Tablero(20,20);

        Jugador jugador = new Jugador("Mauricio",tablero);
        Edificio castillo = new Castillo(jugador);
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Casillero(1,2));
        posicion.agregar(new Casillero(1,3));
        posicion.agregar(new Casillero(1,4));
        posicion.agregar(new Casillero(2,2));
        posicion.agregar(new Casillero(2,1));
        posicion.agregar(new Casillero(2,3));
        posicion.agregar(new Casillero(2,4));
        posicion.agregar(new Casillero(3,1));
        posicion.agregar(new Casillero(3,2));
        posicion.agregar(new Casillero(3,3));
        posicion.agregar(new Casillero(3,4));
        posicion.agregar(new Casillero(4,1));
        posicion.agregar(new Casillero(4,2));
        posicion.agregar(new Casillero(4,3));
        posicion.agregar(new Casillero(4,4));
        tablero.colocar(castillo,posicion);
        Assert.assertEquals(castillo.getPosicion(),posicion);
    }

    @Test
    public void test019CrearCuartelRepararCuartelLanzaEdificioSinDaniarException(){
        Tablero tablero = new Tablero(20,20);

        Jugador jugador = new Jugador("Mauricio",tablero);
        Edificio cuartel = new Cuartel(jugador);
        thrown.expect(EdificioSinDaniarException.class);
        cuartel.reparar();
    }

    @Test
    public void test020RepararCuartelConstruidoVidaMaximaLanzaEdificioSinDaniarException(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
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
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Edificio cuartel = new Cuartel(jugador);
        cuartel.construir();
        cuartel.construir();
        thrown.expect(EdificioConstruidoException.class);
        cuartel.construir();
    }

    @Test
    public void test022CrearPlazaCentralRepararLanzaEdificioSinDaniarException(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Edificio plaza = new PlazaCentral(jugador);
        thrown.expect(EdificioSinDaniarException.class);
        plaza.reparar();
    }

    @Test
    public void test023RepararPlazaConstruidaVidaMaximaLanzaEdificioSinDaniarException(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
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
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Edificio plaza = new PlazaCentral(jugador);
        plaza.construir();
        plaza.construir();
        thrown.expect(EdificioConstruidoException.class);
        plaza.construir();
        plaza.reparar();
    }


    @Test
    public void test0252CrearCastilloRepararLanzaEdificioSinDaniarException(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Edificio castillo = new Castillo(jugador);
        thrown.expect(EdificioSinDaniarException.class);
        castillo.reparar();
    }

    @Test
    public void test026ConstruirEdificioLanzaEdificioNoConstruibleSinCostoException(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Edificio castillo = new Castillo(jugador);
        thrown.expect(EdificioNoConstruibleSinCostoException.class);
        castillo.construir();
    }

    @Test
    public void test26EdificioDeJugadorMauricioPerteneceAJugadorMauricio(){
        Tablero mockedTablero = mock(Tablero.class);
        Jugador jugador = new Jugador("Mauricio",mockedTablero);
        Edificio cuartel = new Cuartel(jugador);
        Assert.assertEquals(cuartel.perteneceAJugador(jugador),true);
    }

    @Test
    public void test27CastilloCreaArmaDeAsedio(){
        Castillo castillo = new Castillo((mock(Jugador.class)));
        Ubicable unidad =  castillo.construirArmaDeAsedio();
        Assert.assertEquals(unidad instanceof ArmaDeAsedio,true);
    }

    @Test
    public void test27CuartelCreaArquero(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Cuartel cuartel = new Cuartel(jugador);
        Ubicable unidad = cuartel.construirArquero();
        Assert.assertEquals(unidad instanceof Arquero,true);
    }

    @Test
    public void test27CuartelCreaEspadachin(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Cuartel cuartel = new Cuartel(jugador);
        Ubicable unidad = cuartel.construirEspadachin();
        Assert.assertEquals(unidad instanceof Espadachin,true);
    }

}

