package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;

public class AldeanoTest {

    @Test
    public void test01SeCreaCorrectamenteAldeano(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertEquals(aldeano.getVidaMaxima(), 50);
        Assert.assertEquals(aldeano.getVidaActual(), 50);
        Assert.assertEquals(aldeano.getCosto(),25);
    }

    @Test
    public void test02AlCrearAldeanoEstePuedeConstruirOReparar(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.podesConstruirORepar());


    }


    @Test
    public void test03AldenoDisminuir25VidaDevuelveVida25(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();
        aldeano.disminuirVida(25);
        Assert.assertEquals(aldeano.getVidaActual(),25);
    }



    @Test
    public void test04AldeanoConstruirEdificioDevuelveElEdificioEnEstadoDeConstruccion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);

        Jugador  jugador2 = new Jugador("Maradona",mapa);
        Aldeano aldeano2 = new Aldeano();
        Posicion posicion2 = Mockito.mock(Posicion.class);


        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;

        Cuartel cuartel = aldeano2.crearCuartel () ;

        //TODO este test hay que verificarlo mandandole el mensaje de construir al edificio y capturando excepcion
        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
       // Assert.assertThat (cuartel.estaEnConstruccion(),is(true));
    }



    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test05AldeanoConstruirEdificioSiEstaConstruyendoDebeLanzarExcepcion (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);



        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;

        thrown.expect(AldeanoOcupadoException.class);
        Cuartel cuartel = aldeano.crearCuartel () ;

    }

    @Test
    public void test06AldeanoAlConstruirEdificiopodesConstruirOReparDebeDarFalse (){

        Mapa mapa =  Mockito.mock(Mapa.class);

        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);
        Posicion posicion2 = Mockito.mock(Posicion.class);



        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;

        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));

    }

    @Test
    public void test09AldeanoConstruyendoNecesita3TurnosParaQuedarLibre (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);




        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        Assert.assertThat(aldeano.podesConstruirORepar(), is(true));

    }

    @Test
    public void test10AldeanoConstruyendoAlPasar4TurnosQuedaLibre (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);




        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        Assert.assertThat(aldeano.podesConstruirORepar(), is(true));

    }
/*
    @Test
    public void test11AldeanoConstruyendoAlPasar4TurnosRecolectaOro (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);




        PlazaCentral unaPlaza = aldeano.crearPlazaCentral (posicion, mapa) ;
        aldeano.huboUnCambioDeTurno(); // turno 1
        aldeano.huboUnCambioDeTurno(); // turno 2
        aldeano.huboUnCambioDeTurno(); // turno 3
        aldeano.huboUnCambioDeTurno(); // turno 4

        Assert.assertThat(jugador.getOro()==20, is(true));

    }
*/
    @Test
    public void test12AldeanoConstruyendoAlPasar3TurnosNoSumaOro (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = Mockito.mock(Posicion.class);



        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        aldeano.huboUnCambioDeTurno(jugador); // turno 3


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
