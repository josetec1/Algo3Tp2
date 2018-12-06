package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.*;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.NoSePuedeRepararException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.AldeanoOcupadoException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.NoSePuedeConstruir;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNulaException;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class AldeanoTest {



    private Castillo castillo= new Castillo();
    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private PlazaCentral plaza;
    private Jugador jugador;

    @Before
    public void setUp(){
        plaza = new PlazaCentral();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        jugador = new Jugador("Pelusa",castillo,plaza,aldeanos);

    }

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

        Aldeano aldeano = new Aldeano();
        aldeano.disminuirVida(25,jugador,mapa);
        Assert.assertEquals(aldeano.getVidaActual(),25);
    }

    @Test
    public void test03AlCrearAldeanoEsteEstaDisponible(){
        Mapa mapa = new Mapa(10,10);

        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.estasDisponible());
    }

    @Test
    public void test04AlCrearAldeanoEsteSePuedeMover(){
        Mapa mapa = new Mapa(10,10);

        Aldeano aldeano = new Aldeano();

        Assert.assertTrue(aldeano.estasDisponible());
    }


// pruebas de oro recolectando y moviendose.  construyendo y reparando estan mas abajo
    @Test
    public void test05AlCrearAldeanoYCambiarDeTurnoEsteSumaORO(){

        Jugador jugador = Mockito.mock(Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();

        aldeano.huboUnCambioDeTurno(jugador);

        verify(jugador, times(1)).sumarOro(anyInt());
        verify(jugador, times(1)).sumarOro(20);
    }

    @Test
    public void test06AlMoverAldeanoYCambiarDeTurnoEsteSumaORO(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = Mockito.mock(Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Direccionable direccion = new DireccionDerecha();
        mapa.colocar(aldeano,new PosicionReal(10,10));
        aldeano.mover(mapa,direccion,jugador);

        aldeano.huboUnCambioDeTurno(jugador);

        verify(jugador, times(1)).sumarOro(anyInt());
        verify(jugador, times(1)).sumarOro(20);
    }

/*   ******************************************************************
                       PRUEBAS DE CONSTRUCCION
      ***************************************************************   */

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test08ConstruirEdificioSiEstaElAldeanoConstruyendoDebeLanzarExcepcion (){
        Mapa mapa = Mockito.mock(Mapa.class);
        Jugador jugador = Mockito.mock(Jugador.class);

        PosicionReal posicionReal = new PosicionReal(2,2);
        PlazaCentral unaPlaza = Mockito.mock(PlazaCentral.class);
        Mockito.when(unaPlaza.getTamanio()).thenReturn(1);
        Mockito.when(unaPlaza.puedoConstruir()).thenReturn(true);
        Aldeano aldeano = new Aldeano();

        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        Mockito.when(mapa.puedoColocar(posicionReal,1)).thenReturn(true);

        aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);

        Cuartel cuartel = Mockito.mock(Cuartel.class);
        Mockito.when(cuartel.getTamanio()).thenReturn(1);
        Mockito.when(cuartel.puedoConstruir()).thenReturn(true);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.construirEdificio(cuartel,mapa,jugador, posicionReal);
    }




    @Test
    public void test09EstasDisponibleDebeDarFalseAlConstruirEdificio (){
        Mapa mapa = Mockito.mock(Mapa.class);
        Jugador jugador = Mockito.mock(Jugador.class);

        PosicionReal posicionReal = new PosicionReal(2,2);
        PlazaCentral unaPlaza = Mockito.mock(PlazaCentral.class);
        Mockito.when(unaPlaza.getTamanio()).thenReturn(1);
        Mockito.when(unaPlaza.puedoConstruir()).thenReturn(true);
        Aldeano aldeano = new Aldeano();

        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        Mockito.when(mapa.puedoColocar(posicionReal,1)).thenReturn(true);

        aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);

        Assert.assertThat(aldeano.estasDisponible(), is(false));
    }

    @Test
    public void test10AldeanoConstruyendoAlRecibirElMensajeCambiarALibreYRecolectandoQuedaLibre (){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = Mockito.mock(Jugador.class);

        PosicionReal posicionReal = new PosicionReal(2,2);
        PlazaCentral unaPlaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);


        aldeano.huboUnCambioDeTurno(jugador);
        Assert.assertThat(aldeano.estasDisponible(), is(false));
        aldeano.cambiarARecolectando();
        Assert.assertThat(aldeano.estasDisponible(), is(true));

    }


    @Test
    public void test11AldeanoConstruyendoAlPasarTerminarDeConstruirNoSumaOro (){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = Mockito.mock(Jugador.class);

        PosicionReal posicionReal = new PosicionReal(2,2);
        PlazaCentral unaPlaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);

        aldeano.cambiarARecolectando();
        verify(jugador, times(0)).sumarOro(anyInt());

    }

     @Test
    public void test12AldeanoConstruyendoAlCambiarARecolectandoYPasarUnTurnoRecolecta20DeOro (){

         Mapa mapa = new Mapa(100,100);
         Jugador jugador = Mockito.mock(Jugador.class);

         PosicionReal posicionReal = new PosicionReal(2,2);
         PlazaCentral unaPlaza = new PlazaCentral();
         Aldeano aldeano = new Aldeano();
         Mockito.when(jugador.esMio(any())).thenReturn(true);
         Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
         aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);

         aldeano.cambiarARecolectando();
         aldeano.huboUnCambioDeTurno(jugador);

        verify(jugador).sumarOro(20);
        verify(jugador, times(1)).sumarOro(anyInt());
    }



    /*  ************************************************************
        Pruebas de  MOVIMIENTO
    ************************************************************** */

    @Test
    public void test13MoverAldeanoDebeLanzarExepcionSiNoTieneUnaPosicionPrevia(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        thrown.expect(PosicionNulaException.class);
        aldeano.mover(mapa,direccion,jugador);

    }



    //Mover Con movimiento
    @Test
    public void test14EstasDisponibleDebeDarFalseSiElAldeanoSeEstaMoviendo(){
        Castillo castillo = new Castillo();
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
       jugador.agregarPieza(aldeano);
        mapa.colocar(aldeano,new PosicionReal(5,5));
        aldeano.mover(mapa,direccion,jugador);

        Assert.assertFalse(aldeano.estasDisponible());
    }

    @Test
    public void test15EstasDisponibleDebeDarTrueSiElAldeanoSeEstabaMoviendoYSeCambioElTurno(){
        Castillo castillo = new Castillo();
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        mapa.colocar(aldeano,new PosicionReal(5,5));
        aldeano.mover(mapa,direccion,jugador);

        aldeano.huboUnCambioDeTurno(jugador);

        Assert.assertTrue(aldeano.estasDisponible());
    }

    @Test
    public void test16MoverteDebeLanzarExepcionSiIntentoMoverAldeanoEnMovimiento(){
        Castillo castillo = new Castillo();
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        mapa.colocar(aldeano,new PosicionReal(5,5));
        aldeano.mover(mapa,direccion,jugador);


        thrown.expect(AldeanoOcupadoException.class);
        aldeano.mover(mapa,direccion,jugador);
    }

    @Test
    public void test17MoverMueveAlAldeanoQueSeEstabaMoviendoLuegoDeUnCambioDeTurno(){
        Castillo castillo = new Castillo();
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(5,5);
        Posicion primerMovimiento = origen.calcularPosicionSiguiente(direccion);
        Posicion posicionRealFinal = primerMovimiento.calcularPosicionSiguiente(direccion);

        mapa.colocar(aldeano,origen);
        aldeano.mover(mapa,direccion,jugador);
        aldeano.huboUnCambioDeTurno(jugador);

        aldeano.mover(mapa,direccion,jugador);

        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(posicionRealFinal));

    }
            //MoverConConstruccion
    @Test
    public void test18EstasDisponibleDebeDarFalseSiElAldeanoEstaConstruyendo(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = Mockito.mock(Jugador.class);

        PosicionReal posicionReal = new PosicionReal(2,2);
        PlazaCentral unaPlaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);

        Assert.assertFalse(aldeano.estasDisponible());
    }

    @Test
    public void test19EstasDisponibleDebeDarTrueLuegoDeDejarDeConstruir(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = Mockito.mock(Jugador.class);

        PosicionReal posicionReal = new PosicionReal(2,2);
        PlazaCentral unaPlaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);

       aldeano.cambiarARecolectando();
       Assert.assertThat(aldeano.estasDisponible(), is(true));

    }

    @Test
    public void test20MoverteDebeLanzarExepcionSiIntentoMoverAldeanoEnConstruccion(){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = Mockito.mock(Jugador.class);

        PosicionReal posicionReal = new PosicionReal(2,2);
        Direccionable direccion = new DireccionDerecha();
        PlazaCentral unaPlaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        aldeano.construirEdificio(unaPlaza,mapa,jugador, posicionReal);



        thrown.expect(AldeanoOcupadoException.class);
        aldeano.mover(mapa,direccion,jugador);
    }

    @Test
    public void test21MoverMueveAlAldeanoQueEstabaConstruyendoLuegoDeCambiarARecolectando(){
        Castillo castillo = new Castillo();
        Mapa mapa = new Mapa(101,101);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        jugador.sumarOro(500);

        Posicion origen = new PosicionReal(5,5);
        Posicion posicionRealFinal = origen.calcularPosicionSiguiente(direccion);

        mapa.colocar(aldeano,origen);
        PlazaCentral plaza = new PlazaCentral();
        PosicionReal posicionRealPlaza = new PosicionReal(50,5);
        aldeano.construirEdificio(plaza,mapa,jugador, posicionRealPlaza);

        aldeano.cambiarARecolectando();

        aldeano.mover(mapa,direccion,jugador);

        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(posicionRealFinal));

    }

    //MoverConReparacion
    @Test
    public void test22EstasDisponibleDebeDarFalseSiElAldeanoEstaReparando(){
        Jugador jugador = Mockito.mock(Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(true);

        aldeano.reparar(unEdificio, jugador);
        Assert.assertFalse(aldeano.estasDisponible());
    }

    @Test
    public void test23EstasDisponibleDebeDarTrueCuandoElAldeanoTerminaDeReparar(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

        //El edificio al repararse, libera al aldeano enviandole el siguiente mensaje
        aldeano.cambiarARecolectando();
        Assert.assertTrue(aldeano.estasDisponible());
    }

    @Test
    public void test24MoverteDebeLanzarExepcionSiIntentoMoverAldeanoCuandoEstaReparando(){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.mover(mapa,direccion,jugador);
    }

    @Test
    public void test25MoverMueveAlAldeanoCuandoTerminoDeReparar(){
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();

        PosicionReal origen = new PosicionReal(5,5);
        Posicion posicionRealFinal = origen.calcularPosicionSiguiente(direccion);
        Edificio unEdificio = Mockito.mock (Castillo.class);
        mapa.colocar(aldeano,origen);
        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

        aldeano.cambiarARecolectando(); //mensaje enviado por el edificio
        aldeano.mover(mapa,direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(posicionRealFinal));
    }


  /*  ************************************************************
        Pruebas de  Reparacion
    ************************************************************** */



    @Test
    public void test26RepararEdificioSanoDebeLanzarExcepcion (){

        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(false);

        thrown.expect(NoSePuedeRepararException.class);
        aldeano.reparar(unEdificio,jugador);
    }


    @Test
    public void test27RepararEdificioSiEstaReparandoDebeLanzarExcepcion (){

        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.reparar(otroEdificio,jugador);

    }

    @Test
    public void test28ContruirEdificioSiEstaReparandoDebeLanzarExcepcion (){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

        thrown.expect(AldeanoOcupadoException.class);

        aldeano.construirEdificio(new PlazaCentral(),mapa,jugador,new PosicionReal(10,10));

    }

    @Test
    public void test29EstasDisponibleDebeDarFalseAlRepararEdificio (){

        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);


        Assert.assertThat(aldeano.estasDisponible(), is(false));

    }
    @Test
    public void test30EstasDisponibleDebeDarTrueAlTerminarDeRepararElEdificio (){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Edificio unEdificio = Mockito.mock (Castillo.class);
        Edificio otroEdificio = Mockito.mock (Castillo.class);
        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

        aldeano.cambiarARecolectando(); //mensaje enviado por el edificio
        Assert.assertThat(aldeano.estasDisponible(), is(true));
    }



    @Test
    public void test31AldeanoMientrasReparaNoSumaOro (){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);

        Aldeano aldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);


        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);
        aldeano.huboUnCambioDeTurno(jugador);
        aldeano.huboUnCambioDeTurno(jugador);
        aldeano.huboUnCambioDeTurno(jugador);
        aldeano.huboUnCambioDeTurno(jugador);

        verify(jugador, times(0)).sumarOro(anyInt());

    }

    @Test
    public void test32AldeanoAlTerminarDeRepararYPasarTurnoSumaOro (){

        Aldeano aldeano = new Aldeano();

        Edificio unEdificio = Mockito.mock (Castillo.class);
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);

        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

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
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);

        when(unEdificio.puedoReparar()).thenReturn(true);
        aldeano.reparar(unEdificio,jugador);

        when(unEdificio.puedoReparar()).thenReturn(false);
        thrown.expect(NoSePuedeRepararException.class);
        otroAldeano.reparar(unEdificio,jugador);

    }

    @Test
    public void test34RepararEdificioEnConstruccionDebeLanzarExcepcion (){
        Mapa mapa = new Mapa(500,500);
        PlazaCentral plaza= new PlazaCentral();
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(plaza)).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

       otroAldeano.construirEdificio(plaza,mapa,jugador,new PosicionReal(3,3));


        thrown.expect(NoSePuedeRepararException.class);
        aldeano.reparar(plaza,jugador);


    }

    @Test
    public void test35ConstruirSiAldeanoSeEstaMoviendoDebeLanzarExcepcion (){

        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        PosicionReal origen = new PosicionReal(5,5);

        mapa.colocar(aldeano,origen);
        aldeano.mover(mapa,direccion,jugador);
        thrown.expect(AldeanoOcupadoException.class);
        aldeano.construirEdificio(new PlazaCentral(),mapa,jugador,new PosicionReal(3,3));
    }

    @Test
    public void test36RepararSiAldeanoSeEstaMoviendoDebeLanzarExcepcion (){
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Aldeano aldeano = new Aldeano();
        PosicionReal origen = new PosicionReal(5,5);

        Edificio unEdificio = Mockito.mock (Castillo.class);
        mapa.colocar(aldeano,origen);
        aldeano.mover(mapa,direccion,jugador);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.reparar(unEdificio,jugador);
    }

    @Test
    public void test37RepararSiAldeanoEstaConstruyendoDebeLanzarExcepcion (){

        Mapa mapa = new Mapa(10,10);
        Direccionable direccion = new DireccionDerecha();
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);
        Aldeano aldeano = new Aldeano();
        aldeano.construirEdificio(new PlazaCentral(),mapa,jugador,new PosicionReal(3,3));
        Edificio unEdificio = Mockito.mock (Castillo.class);

        thrown.expect(AldeanoOcupadoException.class);
        aldeano.reparar(unEdificio,jugador);

    }

    // NUEVOS TEST DE CONSTRUIR
    @Test
    public void test38ConstruirEdificioDebeLanzarExcepcionSiNoSePuedeConstruirElEdificio (){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);

        Aldeano unAldeano = Mockito.mock(Aldeano.class);
        PlazaCentral plaza =new PlazaCentral();
        plaza.comenzarConstruccion(unAldeano, jugador);
        plaza.finalizarConstruccion();

       Assert.assertFalse(plaza.puedoConstruir());
       Aldeano otroAldeano = new Aldeano();

       thrown.expect(NoSePuedeConstruir.class);
       otroAldeano.construirEdificio(plaza,mapa,jugador,new PosicionReal(3,3));
    }

    @Test
    public void test39ConstruirEdificioDebeLanzarExcepcionSiNoSePuedeColocarElEdificioEnEsaPosicion (){

        Mapa mapa = new Mapa(10,10);
        Jugador jugador = Mockito.mock (Jugador.class);
        Mockito.when(jugador.esMio(any())).thenReturn(true);
        Mockito.when(jugador.puedoAgregar(any(EdificioConstruible.class))).thenReturn(true);


        PlazaCentral plaza =new PlazaCentral();

        Aldeano otroAldeano = new Aldeano();

        thrown.expect(NoSePuedeConstruir.class);
        otroAldeano.construirEdificio(plaza,mapa,jugador,new PosicionReal(30,30));

    }

    @Test
    public void test40ConstruirEdificioDebeLanzarExcepcionSiNoSePuedeAgregarElEdificioPorFaltaDeOro (){

        Mapa mapa = new Mapa(10,10);

        PlazaCentral plaza =new PlazaCentral();
        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano); //se queda con 75 de oro y la plaza vale 100

        thrown.expect(NoSePuedeConstruir.class);
        aldeano.construirEdificio(plaza,mapa,jugador,new PosicionReal(3,3));
    }

    // TEST DE JUGADOR NO PROPIO

    @Test
    public void test41ConstruirEdificioDebeLanzarExcepcionSiLaUnidadNoEsDelJugadorPasado (){

        Mapa mapa = new Mapa(10,10);

        PlazaCentral plaza =new PlazaCentral();
        Aldeano aldeano = new Aldeano();


        thrown.expect(NoEsMiJugadorException.class);
        aldeano.construirEdificio(plaza,mapa,jugador,new PosicionReal(3,3));

    }

    @Test
    public void test42MoverDebeLanzarExcepcionSiLaUnidadNoEsDelJugadorPasado (){

        Mapa mapa = new Mapa(100,100);
        Direccionable direccion = new DireccionDerecha();

        Aldeano aldeano = new Aldeano();
        mapa.colocar(aldeano,new PosicionReal(5,5));

        thrown.expect(NoEsMiJugadorException.class);
        aldeano.mover(mapa,direccion, jugador);
    }

    @Test
    public void test42RepararDebeLanzarExcepcionSiLaUnidadNoEsDelJugadorPasado (){

        Mapa mapa = new Mapa(10,10);

        PlazaCentral plaza =new PlazaCentral();
        Aldeano aldeano = new Aldeano();

        thrown.expect(NoEsMiJugadorException.class);
        aldeano.reparar(plaza,jugador);
    }

    @Test
    public void test43HuboUnCambioDeTurnoDebeLanzarExcepcionSiLaUnidadNoEsDelJugadorPasado (){

        Castillo castillo = Mockito.mock (Castillo.class);
        Aldeano aldeano = new Aldeano();


        thrown.expect(NoEsMiJugadorException.class);
        aldeano.huboUnCambioDeTurno(jugador);
    }













}
