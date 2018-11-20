package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.*;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.NoSePuedeRepararException;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

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


// pruebas de oro recolectando y moviendose.  construyendo y reparando estan mas abajo
    @Test
    public void test05AlCrearAldeanoYCambiarDeTurnoEsteSumaORO(){

        Jugador jugador = Mockito.mock(Jugador.class);
        Aldeano aldeano = new Aldeano();

        aldeano.huboUnCambioDeTurno(jugador);

        verify(jugador, times(1)).sumarOro(anyInt());
        verify(jugador, times(1)).sumarOro(20);
    }

    @Test
    public void test06AlMoverAldeanoYCambiarDeTurnoEsteSumaORO(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = Mockito.mock(Jugador.class);
        Aldeano aldeano = new Aldeano();
        Direccionable direccion = new DireccionDerecha();
        mapa.colocar(aldeano,new Posicion(10,10));
        aldeano.mover(mapa,direccion);

        aldeano.huboUnCambioDeTurno(jugador);

        verify(jugador, times(1)).sumarOro(anyInt());
        verify(jugador, times(1)).sumarOro(20);
    }

/*   ******************************************************************
                       PRUEBAS DE CONSTRUCCION
      ***************************************************************   */


    @Test
    public void test07ConstruirEdificioDevuelveElEdificioEnEstadoDeConstruccion (){

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
    public void test08ConstruirEdificioSiEstaConstruyendoDebeLanzarExcepcion (){

        Aldeano aldeano = new Aldeano();
        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;

        thrown.expect(AldeanoOcupadoException.class);
        Cuartel cuartel = aldeano.crearCuartel () ;
    }




    @Test
    public void test09PodesConstruirOReparDebeDarFalseAlConstruirEdificio (){

        Aldeano aldeano = new Aldeano();
        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));
    }

    @Test
    public void test10AldeanoConstruyendoNecesita3TurnosParaQuedarLibre (){

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
    public void test11AldeanoConstruyendoAlPasar3TurnosNoSumaOro (){

        Jugador  jugador = Mockito.mock (Jugador.class);
        Aldeano aldeano = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        aldeano.huboUnCambioDeTurno(jugador); // turno 3

        verify(jugador, times(0)).sumarOro(anyInt());

    }

     @Test
    public void test12AldeanoConstruyendoAlPasar4TurnosRecolecta20DeOro (){

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
        Pruebas de  MOVIMIENTO
    ************************************************************** */


//TODO ojo, esta prueba tiene que aplicarse a todas las unidades Moviles
    @Test
    public void test13MoverAldeanoDebeLanzarExepcionSiNoTieneUnaPosicionPrevia(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Aldeano aldeano = new Aldeano();

        thrown.expect(UnidadSinPosicionExceptcion.class);
        aldeano.mover(mapa,direccion);
    }



    //Mover Con movimiento
    @Test
    public void test14PodesMoverteDebeDarFalseSiElAldeanoSeEstaMoviendo(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();
        mapa.colocar(aldeano,new Posicion(5,5));
        aldeano.mover(mapa,direccion);

        Assert.assertFalse(aldeano.podesMoverte());
    }

    @Test
    public void test15PodesMoverteDebeDarTrueSiElAldeanoSeEstabaMoviendoYSeCambioElTurno(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();
        mapa.colocar(aldeano,new Posicion(5,5));
        aldeano.mover(mapa,direccion);

        aldeano.huboUnCambioDeTurno(jugador);

        Assert.assertTrue(aldeano.podesMoverte());
    }

    @Test
    public void test16MoverteDebeLanzarExepcionSiIntentoMoverAldeanoEnMovimiento(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();
        mapa.colocar(aldeano,new Posicion(5,5));
        aldeano.mover(mapa,direccion);


        thrown.expect(AldeanoOcupadoException.class);
        aldeano.mover(mapa,direccion);
    }

    @Test
    public void test17MoverMueveAlAldeanoQueSeEstabaMoviendoLuegoDeUnCambioDeTurno(){

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Posicion origen = new Posicion(5,5);
        Posicion primerMovimiento = origen.calcularPosicionSiguiente(direccion);
        Posicion posicionFinal = primerMovimiento.calcularPosicionSiguiente(direccion);

        mapa.colocar(aldeano,origen);
        aldeano.mover(mapa,direccion);
        aldeano.huboUnCambioDeTurno(jugador);

        aldeano.mover(mapa,direccion);

        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(posicionFinal));

    }
            //MoverConConstruccion
    @Test
    public void test18PodesMoverteDebeDarFalseSiElAldeanoEstaConstruyendo(){

        Aldeano aldeano = new Aldeano();
        aldeano.crearPlazaCentral();

        Assert.assertFalse(aldeano.podesMoverte());
    }

    @Test
    public void test19PodesMoverteDebeDarTrueLuegoDeDejarDeConstruir(){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        Assert.assertThat(aldeano.podesMoverte(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        Assert.assertThat(aldeano.podesMoverte(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        Assert.assertThat(aldeano.podesMoverte(), is(true));

    }

    @Test
    public void test20MoverteDebeLanzarExepcionSiIntentoMoverAldeanoEnConstruccion(){

        Mapa mapa =  Mockito.mock(Mapa.class);
      // Jugador  jugador = new Jugador("Maradona",mapa);
        Aldeano aldeano = new Aldeano();
        Direccionable direccion = new DireccionDerecha();
        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        thrown.expect(AldeanoOcupadoException.class);
        aldeano.mover(mapa,direccion);
    }

    @Test
    public void test21MoverMueveAlAldeanoQueEstabaConstruyendoLuegoDeTresCambiosDeTurno(){

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Posicion origen = new Posicion(5,5);
        Posicion posicionFinal = origen.calcularPosicionSiguiente(direccion);

        mapa.colocar(aldeano,origen);
        aldeano.crearPlazaCentral();

        aldeano.huboUnCambioDeTurno(jugador); //1
        aldeano.huboUnCambioDeTurno(jugador); //2
        aldeano.huboUnCambioDeTurno(jugador); //3

        aldeano.mover(mapa,direccion);

        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(posicionFinal));

    }

    //MoverConReparacion
    @Test
    public void test22PodesMoverteDebeDarFalseSiElAldeanoEstaReparando(){
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);

        aldeano.reparar(unEdificio);
        Assert.assertFalse(aldeano.podesMoverte());
    }

    @Test
    public void test23PodesMoverteDebeDarTrueCuandoElAldeanoTerminaDeReparar(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Aldeano aldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        //El edificio al repararse, libera al aldeano enviandole el siguiente mensaje
        aldeano.cambiarARecolectando();
        Assert.assertTrue(aldeano.podesMoverte());
    }

    @Test
    public void test24MoverteDebeLanzarExepcionSiIntentoMoverAldeanoCuandoEstaReparando(){

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.mover(mapa,direccion);
    }

    @Test
    public void test25MoverMueveAlAldeanoCuandoTerminoDeReparar(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();

        Posicion origen = new Posicion(5,5);
        Posicion posicionFinal = origen.calcularPosicionSiguiente(direccion);
        Edificio unEdificio = Mockito.mock (Castillo.class);
        mapa.colocar(aldeano,origen);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        aldeano.cambiarARecolectando(); //mensaje enviado por el edificio
        aldeano.mover(mapa,direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(posicionFinal));
    }


  /*  ************************************************************
        Pruebas de  Reparacion
    ************************************************************** */



    @Test
    public void test26RepararEdificioSanoDebeLanzarExcepcion (){


        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(false);

        thrown.expect(NoSePuedeRepararException.class);
        aldeano.reparar(unEdificio);
    }


    @Test
    public void test27RepararEdificioSiEstaReparandoDebeLanzarExcepcion (){


        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.reparar(otroEdificio);

    }

    @Test
    public void test28ContruirEdificioSiEstaReparandoDebeLanzarExcepcion (){


        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.crearPlazaCentral();

    }

    @Test
    public void test29PodesConstruirOReparDebeDarFalseAlRepararEdificio (){


        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);


        Assert.assertThat(aldeano.podesConstruirORepar(), is(false));

    }
    @Test
    public void test30PodesConstruirOReparDebeDarTrueAlTerminarDeRepararElEdificio (){

        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        aldeano.cambiarARecolectando(); //mensaje enviado por el edificio
        Assert.assertThat(aldeano.podesConstruirORepar(), is(true));
    }



    @Test
    public void test31AldeanoMientrasReparaNoSumaOro (){


        Aldeano aldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);
        Jugador  jugador = Mockito.mock (Jugador.class);

        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        verify(jugador, times(0)).sumarOro(anyInt());

    }

    @Test
    public void test32AldeanoAlTerminarDeRepararYPasarTurnoSumaOro (){

        Aldeano aldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);
        Jugador  jugador = Mockito.mock (Jugador.class);

        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        aldeano.cambiarARecolectando();
        aldeano.huboUnCambioDeTurno(jugador);

        verify(jugador).sumarOro(20);
        verify(jugador, times(1)).sumarOro(anyInt());
    }

    @Test
    public void test33DosAldeanosNoPuedenRepararElMismoEdificio (){

        Aldeano aldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);
        Jugador  jugador = Mockito.mock (Jugador.class);

        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        when(unEdificio.estaEnReparacion()).thenReturn(true);
        thrown.expect(NoSePuedeRepararException.class);
        otroAldeano.reparar(unEdificio);

    }

    @Test
    public void test34RepararEdificioEnConstruccionDebeLanzarExcepcion (){

        Aldeano aldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

        Edificio unEdificio = otroAldeano.crearPlazaCentral();


        thrown.expect(NoSePuedeRepararException.class);
        aldeano.reparar(unEdificio);


    }

    @Test
    public void test35ConstruirSiAldeanoSeEstaMoviendoDebeLanzarExcepcion (){


        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(5,5);

        mapa.colocar(aldeano,origen);
        aldeano.mover(mapa,direccion);
        thrown.expect(AldeanoOcupadoException.class);
        aldeano.crearPlazaCentral();
    }

    @Test
    public void test36RepararSiAldeanoSeEstaMoviendoDebeLanzarExcepcion (){

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(5,5);

        Edificio unEdificio = Mockito.mock (Castillo.class);
        mapa.colocar(aldeano,origen);
        aldeano.mover(mapa,direccion);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.reparar(unEdificio);
    }

    @Test
    public void test37RepararSiAldeanoEstaConstruyendoDebeLanzarExcepcion (){

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio", mapa);
        Aldeano aldeano = new Aldeano();
        aldeano.crearPlazaCentral();
        Edificio unEdificio = Mockito.mock (Castillo.class);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.reparar(unEdificio);

    }













}
