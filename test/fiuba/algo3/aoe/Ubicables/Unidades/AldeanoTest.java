package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.*;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.NoSePuedeRepararException;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
        Jugador jugador = new Jugador("Mauricio");
        Aldeano aldeano = new Aldeano();
        aldeano.disminuirVida(25);
        Assert.assertEquals(aldeano.getVidaActual(),25);
    }

    @Test
    public void test03AlCrearAldeanoEsteEstaDisponible(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio");
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.estasDisponible());
    }

    @Test
    public void test04AlCrearAldeanoEsteSePuedeMover(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio");
        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.estasDisponible());
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

/*
    @Test
    public void test07ConstruirEdificioDevuelveElEdificioEnEstadoDeConstruccion (){

        Aldeano aldeano = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        PlazaCentral unaPlaza = new PlazaCentral();
        aldeano.construirEdificio(unaPlaza,mapa,jugador,posicion);

        Cuartel cuartel = aldeano2.crearCuartel () ;


        Assert.assertThat (unaPlaza.estaEnConstruccion(),is(true));
        Assert.assertThat (cuartel.estaEnConstruccion(),is(true));
    }

*/


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test08ConstruirEdificioSiEstaConstruyendoDebeLanzarExcepcion (){
        Mapa mapa = Mockito.mock(Mapa.class);
        Jugador jugador = Mockito.mock(Jugador.class);

        Posicion posicion = new Posicion(2,2);
        PlazaCentral unaPlaza = Mockito.mock(PlazaCentral.class);
        Mockito.when(unaPlaza.getTamanio()).thenReturn(1);
        Aldeano aldeano = new Aldeano();

        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(Edificio.class))).thenReturn(true);
        Mockito.when(mapa.puedoColocar(posicion,1)).thenReturn(true);

        aldeano.construirEdificio(unaPlaza,mapa,jugador,posicion);

        Cuartel cuartel = Mockito.mock(Cuartel.class);
        Mockito.when(cuartel.getTamanio()).thenReturn(1);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.construirEdificio(cuartel,mapa,jugador,posicion);
    }



/*
    @Test
    public void test09EstasDisponibleDebeDarFalseAlConstruirEdificio (){

        Aldeano aldeano = new Aldeano();
        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        Assert.assertThat(aldeano.estasDisponible(), is(false));
    }

    @Test
    public void test10AldeanoConstruyendoNecesita3TurnosParaQuedarLibre (){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona");
        Aldeano aldeano = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        Assert.assertThat(aldeano.estasDisponible(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        Assert.assertThat(aldeano.estasDisponible(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        Assert.assertThat(aldeano.estasDisponible(), is(true));

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

/*
//TODO ojo, esta prueba tiene que aplicarse a todas las unidades Moviles
    @Test
    public void test13MoverAldeanoDebeLanzarExepcionSiNoTieneUnaPosicionPrevia(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Aldeano aldeano = new Aldeano();

        thrown.expect(UnidadSinPosicionException.class);
        aldeano.mover(mapa,direccion);
    }



    //Mover Con movimiento
    @Test
    public void test14EstasDisponibleDebeDarFalseSiElAldeanoSeEstaMoviendo(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio");
        Aldeano aldeano = new Aldeano();
        mapa.colocar(aldeano,new Posicion(5,5));
        aldeano.mover(mapa,direccion);

        Assert.assertFalse(aldeano.estasDisponible());
    }

    @Test
    public void test15EstasDisponibleDebeDarTrueSiElAldeanoSeEstabaMoviendoYSeCambioElTurno(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio");
        Aldeano aldeano = new Aldeano();
        mapa.colocar(aldeano,new Posicion(5,5));
        aldeano.mover(mapa,direccion);

        aldeano.huboUnCambioDeTurno(jugador);

        Assert.assertTrue(aldeano.estasDisponible());
    }

    @Test
    public void test16MoverteDebeLanzarExepcionSiIntentoMoverAldeanoEnMovimiento(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio");
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
        Jugador jugador = new Jugador("Mauricio");
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
    public void test18EstasDisponibleDebeDarFalseSiElAldeanoEstaConstruyendo(){

        Aldeano aldeano = new Aldeano();
        aldeano.crearPlazaCentral();

        Assert.assertFalse(aldeano.estasDisponible());
    }

    @Test
    public void test19EstasDisponibleDebeDarTrueLuegoDeDejarDeConstruir(){

        Mapa mapa =  Mockito.mock(Mapa.class);
        Jugador  jugador = new Jugador("Maradona");
        Aldeano aldeano = new Aldeano();

        PlazaCentral unaPlaza = aldeano.crearPlazaCentral () ;
        aldeano.huboUnCambioDeTurno(jugador); // turno 1
        Assert.assertThat(aldeano.estasDisponible(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 2
        Assert.assertThat(aldeano.estasDisponible(), is(false));
        aldeano.huboUnCambioDeTurno(jugador); // turno 3
        Assert.assertThat(aldeano.estasDisponible(), is(true));

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
        Jugador jugador = new Jugador("Mauricio");
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
    public void test22EstasDisponibleDebeDarFalseSiElAldeanoEstaReparando(){
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);

        aldeano.reparar(unEdificio);
        Assert.assertFalse(aldeano.estasDisponible());
    }

    @Test
    public void test23EstasDisponibleDebeDarTrueCuandoElAldeanoTerminaDeReparar(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Aldeano aldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        //El edificio al repararse, libera al aldeano enviandole el siguiente mensaje
        aldeano.cambiarARecolectando();
        Assert.assertTrue(aldeano.estasDisponible());
    }

    @Test
    public void test24MoverteDebeLanzarExepcionSiIntentoMoverAldeanoCuandoEstaReparando(){

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = new Jugador("Mauricio");
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
        Jugador jugador = new Jugador("Mauricio");
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

/*

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
    public void test29EstasDisponibleDebeDarFalseAlRepararEdificio (){


        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);


        Assert.assertThat(aldeano.estasDisponible(), is(false));

    }
    @Test
    public void test30EstasDisponibleDebeDarTrueAlTerminarDeRepararElEdificio (){

        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.estaDaniado()).thenReturn(true);
        aldeano.reparar(unEdificio);

        aldeano.cambiarARecolectando(); //mensaje enviado por el edificio
        Assert.assertThat(aldeano.estasDisponible(), is(true));
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
        Jugador jugador = new Jugador("Mauricio");
        Aldeano aldeano = new Aldeano();
        aldeano.crearPlazaCentral();
        Edificio unEdificio = Mockito.mock (Castillo.class);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.reparar(unEdificio);

    }









*/



}
