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

public class AldeanoTest {

    @Test
    public void test01SeCreaCorrectamenteAldeano(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano(jugador);

        Assert.assertEquals(aldeano.getVidaMaxima(), 50);
        Assert.assertEquals(aldeano.getVidaActual(), 50);
        Assert.assertEquals(aldeano.getCosto(),25);
    }

    @Test
    public void test01BISSeCreaCorrectamenteAldeano(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano(jugador);

        Assert.assertTrue(aldeano.podesConstruirORepar());


    }


    @Test
    public void test02AldenoDisminuir25VidaDevuelveVida25(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano(jugador);
        aldeano.disminuirVida(25);
        Assert.assertEquals(aldeano.getVidaActual(),25);
    }

    @Test
    public void test03AldeanoPerteneceAJugadorJuanDevuelveFalse(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Jugador jugador2 = new Jugador("Juan", mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Assert.assertThat (aldeano.perteneceAJugador(jugador2),is(false));

    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //TODO arreglar estas 2 pruebas, la 4 y la 5
    /*
    @Test
    public void test04AldeanoConstruirPlazaCentralEnTurnoNoPropioDebeLanzarExepcion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
         Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);
        thrown.expect(NoEsTuTurnoException.class);
        aldeano.crearPlazaCentral (posicion, mapa) ;   //Todo aldeano tiene que tener el mapa o se lo pasan? . el jugador para que lo tiene al mapa?
    }

    @Test
    public void test05AldeanoConstruirCuartelEnTurnoNoPropioDebeLanzarExepcion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);
        thrown.expect(NoEsTuTurnoException.class);
        aldeano.crearCuartel (posicion, mapa) ;
    }
*/
    @Test
    public void test06AldeanoConstruirEdificioEnTurnoPropioDevuelveElEdificioEnEstadoDeConstruccion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);

        Jugador  jugador2 = new Jugador("Maradona",mapa);
        Aldeano aldeano2 = new Aldeano(jugador2);
        Posicion posicion2 = Mockito.mock(Posicion.class);

        jugador.setActivo();
        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        jugador2.setActivo();
        Cuartel cuartel = aldeano2.crearCuartel (posicion2, mapa) ;

        //TODO este test hay que verificarlo mandandole el mensaje de construir al edificio y capturando excepcion
        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
       // Assert.assertThat (cuartel.estaEnConstruccion(),is(true));
    }

    @Test
    public void test07AldeanoConstruirEdificioSiEstaConstruyendoDebeLanzarExcepcion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);

        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;

        thrown.expect(AldeanoOcupadoException.class);
        Cuartel cuartel = aldeano.crearCuartel (posicion2, mapa) ;

    }

    @Test
    public void test08AldeanoAlConstruirEdificiopodesConstruirOReparDebeDarFalse (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);

        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;

        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));

    }

    @Test
    public void test09AldeanoConstruyendoNecesita3TurnosParaQuedarLibre (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);


        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        aldeano.huboUnCambioDeTurno(); // turno 1
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
        aldeano.huboUnCambioDeTurno(); // turno 2
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
        aldeano.huboUnCambioDeTurno(); // turno 3
        Assert.assertThat(aldeano.podesConstruirORepar(), is(true));

    }

    @Test
    public void test10AldeanoConstruyendoAlPasar4TurnosQuedaLibre (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);


        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        aldeano.huboUnCambioDeTurno(); // turno 1
        aldeano.huboUnCambioDeTurno(); // turno 2
        aldeano.huboUnCambioDeTurno(); // turno 3
        aldeano.huboUnCambioDeTurno(); // turno 3
        Assert.assertThat(aldeano.podesConstruirORepar(), is(true));

    }

    @Test
    public void test11AldeanoConstruyendoAlPasar4TurnosRecolectaOro (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);


        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        aldeano.huboUnCambioDeTurno(); // turno 1
        aldeano.huboUnCambioDeTurno(); // turno 2
        aldeano.huboUnCambioDeTurno(); // turno 3
        aldeano.huboUnCambioDeTurno(); // turno 4

        Assert.assertThat(jugador.getOro()==20, is(true));

    }

    @Test
    public void test12AldeanoConstruyendoAlPasar3TurnosNoSumaOro (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);

        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        aldeano.huboUnCambioDeTurno(); // turno 1
        aldeano.huboUnCambioDeTurno(); // turno 2
        aldeano.huboUnCambioDeTurno(); // turno 3


        Assert.assertThat(jugador.getOro()==0, is(true));

    }
/*
    @Test
    public void test11AldeanoConstruirEdificioSiEstaReparandoDebeLanzarExcepcion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);

        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        Cuartel cuartel = aldeano.crearCuartel (posicion2, mapa) ;
        //TODO este test hay que verificarlo mandandole el mensaje de construir al edificio y capturando excepcion
        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
        Assert.assertThat (cuartel.estaEnConstruccion(),is(false));
    }

    @Test
    public void test12AldeanoConstruirEdificioSiEstaRecolectandoConstruyeElEdificio (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano(jugador);
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);

        jugador.setActivo();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        Cuartel cuartel = aldeano.crearCuartel (posicion2, mapa) ;
        //TODO este test hay que verificarlo mandandole el mensaje de construir al edificio y capturando excepcion
        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
        Assert.assertThat (cuartel.estaEnConstruccion(),is(false));
    }

*/
}
