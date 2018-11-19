package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AldeanoTest {

    @Test
    public void test01SeCreaCorrectamenteAldeano(){
        Mapa mapa = new Mapa(10,10);
        Aldeano aldeano = new Aldeano();

        Assert.assertEquals(aldeano.getVidaMaxima(), 50);
        Assert.assertEquals(aldeano.getVidaActual(), 50);
        Assert.assertEquals(aldeano.getCosto(),25);
    }

    @Test
    public void test02AldenoDisminuir25VidaDevuelveVida25(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();
        aldeano.disminuirVida(25);
        Assert.assertEquals(aldeano.getVidaActual(),25);
    }

    @Test
    public void test03AlCrearAldeanoEstePuedeConstruirOReparar(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesConstruirORepar());
    }

    @Test
    public void test04AlCrearAldeanoEsteSePuedeMover(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesMoverte());
    }

/*   ******************************************************************
                       Pruebas de construccion
      ***************************************************************   */


    @Test
    public void test05AldeanoConstruirEdificioDevuelveElEdificioEnEstadoDeConstruccion (){

        Aldeano aldeano = new Aldeano();
        Aldeano aldeano2 = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        Cuartel cuartel = aldeano2.crearCuartel () ;

        //TODO este test hay que verificarlo mandandole el mensaje de construir al edificio y capturando excepcion
        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
        Assert.assertThat (cuartel.estaEnConstruccion(),is(true));
    }



    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AldeanoConstruirEdificioSiEstaConstruyendoDebeLanzarExcepcion (){

        Aldeano aldeano = new Aldeano();
        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;

        thrown.expect(AldeanoOcupadoException.class);
        Cuartel cuartel = aldeano.crearCuartel () ;
    }

    @Test
    public void test07AldeanoAlConstruirEdificiopodesConstruirOReparDebeDarFalse (){

        Aldeano aldeano = new Aldeano();
        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
    }

    @Test
    public void test08AldeanoConstruyendoNecesita3TurnosParaQuedarLibre (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        Assert.assertThat(aldeano.podesConstruirORepar(), is(true));

    }

    @Test
    public void test09AldeanoConstruyendoAlPasar3TurnosNoSumaOro (){

        Jugador  jugador = Mockito.mock (Jugador.class);
        Aldeano aldeano = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        aldeano.huboUnCambioDeTurno(jugador); // turno 3

        verify(jugador, times(0)).sumarOro(anyInt());

    }

     @Test
    public void test10AldeanoConstruyendoAlPasar4TurnosRecolecta20DeOro (){

        Jugador  jugador = Mockito.mock (Jugador.class);
        Aldeano aldeano = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        aldeano.huboUnCambioDeTurno(jugador); // turno 4

        verify(jugador).sumarOro(20);
        verify(jugador, times(1)).sumarOro(anyInt());
    }



    /*  ************************************************************
        TEST MOVIMIENTO
    ************************************************************** */
/*
    @Test
    public void test11PodesMoverteDebeDarFalseSiElAldeanoSeEstaMoviendo(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesMoverte());
    }

    @Test
    public void test12PodesMoverteDebeDarFalseSiElAldeanoEstaConstruyendo(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesMoverte());
    }

    @Test
    public void test13PodesMoverteDebeDarFalseSiElAldeanoEstaReparando(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesMoverte());
    }

    @Test
    public void test14AldeanoEnMovimientoAlPasarTurnoYaSePuedeMover(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesMoverte());
    }

    @Test
    public void test15AldeanoEnMovimientoRecolectaOroIgual(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesMoverte());
    }


    /*
    @Test
    public void test11AldeanoConstruirEdificioSiEstaReparandoDebeLanzarExcepcion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);



        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        Cuartel cuartel = aldeano.crearCuartel () ;
        //TODO este test hay que verificarlo mandandole el mensaje de construir al edificio y capturando excepcion
        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
        Assert.assertThat (cuartel.estaEnConstruccion(),is(false));
    }

    @Test
    public void test12AldeanoConstruirEdificioSiEstaRecolectandoConstruyeElEdificio (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);



        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        Cuartel cuartel = aldeano.crearCuartel () ;
        //TODO este test hay que verificarlo mandandole el mensaje de construir al edificio y capturando excepcion
        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
        Assert.assertThat (cuartel.estaEnConstruccion(),is(false));
    }
*/

}
