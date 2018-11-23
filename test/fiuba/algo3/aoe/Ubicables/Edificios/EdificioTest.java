package fiuba.algo3.aoe.Ubicables.Edificios;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
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
        PlazaCentral unaPlazaCentral = new PlazaCentral();

        Assert.assertEquals(unaPlazaCentral.getVidaMaxima(),450);
        Assert.assertEquals(unaPlazaCentral.getCosto(),100);

    }
/*
    @Test
    public void test002CrearUnCuartel (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel();

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getCosto(),50);

    }

    @Test
    public void test003CrearUnCastilloDisMinuirVida50YRepararDevuelvenVida965(){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCastillo = new Castillo();

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
        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),220);

    }

    @Test
    public void test006DisminuirVidaDelCuartelDosVeces (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(30);
        unCuartel.disminuirVida(40);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),180);
    }

    @Test
    public void test007RepararCuartelSinDanio (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel();
        thrown.expect(EdificioSinDaniarException.class);
        unCuartel.reparar();
        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),250);
    }


    @Test
    public void test009RepararCuartelMenorAlMaximoDeVida (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(60);
        unCuartel.construir();
        unCuartel.construir();
        unCuartel.construir();

        unCuartel.reparar();

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),240);
    }

    @Test
    public void test010RepararPlazaCentralMenorAlMaximoDeVida (){
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unaPlazaCentral = new PlazaCentral();
        unaPlazaCentral.construir();
        unaPlazaCentral.construir();
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
        Edificio unCuartel = new Cuartel();
        unCuartel.disminuirVida(500);

        Assert.assertEquals(unCuartel.getVidaMaxima(),250);
        Assert.assertEquals(unCuartel.getVidaActual(),0);
    }

    @Test
    public void test013CuartelEstaEnConstruccion () {
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel();

        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Test
    public void test014CuartelEstaEnConstruccionLuegoDeConstruirseUnaVez () {
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio unCuartel = new Cuartel();
        Assert.assertTrue(unCuartel.estaEnConstruccion());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test016CastilloGetCostoLanzaUnidadNoConstruiBleException () {
        Mapa mockedMapa = mock(Mapa.class);
        Jugador mockedJugador = mock(Jugador.class);
        Edificio castillo = new Castillo();
        thrown.expect(EdificioNoConstruibleSinCostoException.class);
        castillo.getCosto();
    }

    @Test
    public void test017CastilloGetPosicionDevuelvePosicionEsperada() {
        Mapa mapa = new Mapa(100,100);

        Jugador jugador = new Jugador("Mauricio");
        Edificio castillo = new Castillo();
        Posicion posicion = new Posicion(1,1);
        mapa.colocar(castillo,posicion);

        Posicion posicionNueva = new Posicion(1,1);
        posicionNueva.agregar(new Cuadrante(1,2));
        posicionNueva.agregar(new Cuadrante(1,3));
        posicionNueva.agregar(new Cuadrante(1,4));
        posicionNueva.agregar(new Cuadrante(2,1));
        posicionNueva.agregar(new Cuadrante(2,2));
        posicionNueva.agregar(new Cuadrante(2,3));
        posicionNueva.agregar(new Cuadrante(2,4));
        posicionNueva.agregar(new Cuadrante(3,1));
        posicionNueva.agregar(new Cuadrante(3,2));
        posicionNueva.agregar(new Cuadrante(3,3));
        posicionNueva.agregar(new Cuadrante(3,4));
        posicionNueva.agregar(new Cuadrante(4,1));
        posicionNueva.agregar(new Cuadrante(4,2));
        posicionNueva.agregar(new Cuadrante(4,3));
        posicionNueva.agregar(new Cuadrante(4,4));

        Assert.assertEquals(castillo.getPosicion().seSuperponeCon(posicionNueva),true);
    }

    @Test
    public void test019CrearCuartelRepararCuartelLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);

        Jugador jugador = new Jugador("Mauricio");
        Edificio cuartel = new Cuartel();
        thrown.expect(EdificioSinDaniarException.class);
        cuartel.reparar();
    }

    @Test
    public void test020RepararCuartelConstruidoVidaMaximaLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio");
        Edificio cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        thrown.expect(EdificioSinDaniarException.class);
        cuartel.reparar();
    }

    @Test
    public void test021ConstruirCuartelConstruccionTerminadaNoEstaEnReparacionNiConstruccion(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio");
        Edificio cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        Assert.assertEquals(cuartel.estaEnConstruccion(),false);
        Assert.assertEquals(cuartel.estaEnReparacion(),false);
    }

    @Test
    public void test022CrearPlazaCentralRepararLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio");
        Edificio plaza = new PlazaCentral();
        thrown.expect(EdificioSinDaniarException.class);
        plaza.reparar();
    }

    @Test
    public void test023RepararPlazaConstruidaVidaMaximaLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio");
        Edificio plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        thrown.expect(EdificioSinDaniarException.class);
        plaza.reparar();
    }


    @Test
    public void test025CrearCastilloRepararLanzaEdificioSinDaniarException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio");
        Edificio castillo = new Castillo();
        thrown.expect(EdificioSinDaniarException.class);
        castillo.reparar();
    }

    @Test
    public void test026ConstruirEdificioLanzaEdificioNoConstruibleSinCostoException(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio");
        Edificio castillo = new Castillo();
        thrown.expect(EdificioNoConstruibleSinCostoException.class);
        castillo.construir();
    }



    @Test
    public void test028CastilloCreaArmaDeAsedio(){
        Castillo castillo = new Castillo();
        Ubicable unidad =  castillo.construirArmaDeAsedio(mock(Jugador.class));
        Assert.assertTrue(unidad instanceof ArmaDeAsedio);
    }

    @Test
    public void test029CuartelCreaArquero(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio");
        jugador.sumarOro(100);
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        Ubicable unidad = cuartel.construirArquero(jugador);
        Assert.assertTrue(unidad instanceof Arquero);
    }

    @Test
    public void test030CuartelCreaEspadachin(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio");
        jugador.sumarOro(100);
        Cuartel cuartel = new Cuartel();
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        Ubicable unidad = cuartel.construirEspadachin(jugador);
        Assert.assertTrue(unidad instanceof Espadachin);
    }

    @Test
    public void test031PlazaCentralCreaAldeano(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio");
        jugador.sumarOro(100);
        PlazaCentral plazaCentral = new PlazaCentral();
        plazaCentral.construir();
        plazaCentral.construir();
        plazaCentral.construir();
        Ubicable unidad = plazaCentral.construirAldeano(jugador);
        Assert.assertTrue(unidad instanceof Aldeano);
    }

    @Test
    public void test032CastilloAtacaAldeano(){
        Castillo castillo = new Castillo();
        UnidadMovil aldeano = new Aldeano();

        castillo.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(2,2));

        castillo.atacar(aldeano);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima() - 20);
    }

    @Test
    public void test033CastilloAtacaAldeanoEnElLimiteDeSuRango(){
        Castillo castillo = new Castillo();
        UnidadMovil aldeano = new Aldeano();

        castillo.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(4,4));

        castillo.atacar(aldeano);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima() - 20);
    }

    @Test
    public void test034CastilloIntentaAtacarAldeanoFueraDeSuRango(){
        Castillo castillo = new Castillo();
        UnidadMovil aldeano = new Aldeano();

        castillo.colocarEn(new Posicion(1,1));
        aldeano.colocarEn(new Posicion(5,5));

        castillo.atacar(aldeano);

        Assert.assertEquals(aldeano.getVidaActual(), aldeano.getVidaMaxima());
    }
*/
}

