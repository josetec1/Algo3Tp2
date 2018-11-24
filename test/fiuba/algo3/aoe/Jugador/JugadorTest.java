package fiuba.algo3.aoe.Jugador;
import fiuba.algo3.aoe.Jugadores.*;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.*;
import fiuba.algo3.aoe.Ubicables.NotificableDeTurno;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//Todo esto vuela.
public class JugadorTest {

    @Test
    public void test01CrearJugadorCreaJugadorConNombreMauricio(){
      //  Mapa mapa = new Mapa(10,20);

        Jugador jugador1 = new Jugador("Mauricio");
        Assert.assertEquals(jugador1.getNombre(), "Mauricio");

    }

    @Test
    public void test02CrearJugadorCreaJugadorCon100DeOro(){
       // Mapa mapa = new Mapa(10,20);

        UnidadMovil unidad = Mockito.mock (Aldeano.class);

        Mockito.when(unidad.getCosto()).thenReturn(100);

        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(unidad);

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test03CrearJugadorCreaJugadorCon100DeOroYNoPuedeAgregarAlgoQueCueste101(){
        // Mapa mapa = new Mapa(10,20);
        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona");

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test04CrearJugadorCreaJugadorCon0UnidadesYElMaximoQuePuedeTenerSon50(){
        // Mapa mapa = new Mapa(10,20);

        UnidadMovil unidad;
        UnidadMovil unidad50 = Mockito.mock (UnidadMovil.class);
        Mockito.when(unidad50.getCosto()).thenReturn(0);


        Jugador jugador1 = new Jugador("Maradona");

        for (int i = 0; i <50 ; i++) {

            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(0);
            jugador1.agregarPieza(unidad);
        }

        thrown.expect((LimiteDePoblacionAlcanzadoException.class));
        jugador1.agregarPieza(unidad50);


    }


    @Test
    public void test05LosEdificiosNoCuentanComoLimiteDePoblacion(){
        // Mapa mapa = new Mapa(10,20);

        UnidadMovil unidad;
        UnidadMovil unidad50 = Mockito.mock (UnidadMovil.class);
        Mockito.when(unidad50.getCosto()).thenReturn(0);


        Jugador jugador1 = new Jugador("Maradona");

        for (int i = 0; i <50 ; i++) {

            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(0);
            jugador1.agregarPieza(unidad);
        }

        for (int i = 0; i <1500 ; i++) {

            Edificio edificio = Mockito.mock (Edificio.class);
            Mockito.when(edificio.getCosto()).thenReturn(0);
            jugador1.agregarPieza(edificio);
        }

        thrown.expect((LimiteDePoblacionAlcanzadoException.class));
        jugador1.agregarPieza(unidad50);


    }




    @Test
    public void test06PuedoAgregarDebeDarTrueCuandoLaUnidadNoFueAgregadaPreviamente(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(0);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertTrue( jugador1.puedoAgregar(unidad));

    }

    @Test
    public void test07PuedoAgregarDebeDarFalseCuandoLaUnidadFueAgregadaPreviamente(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(0);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.puedoAgregar(unidad);

        Assert.assertTrue( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test08PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorCon100DeOroQuieroAgregarUnidadQueVale100(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertTrue( jugador1.puedoAgregar(unidad));


    }

    @Test
    public void test09PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorCon100DeOroQuieroAgregarUnidadQueVale101(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertFalse( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test10PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregaUnaUnidad(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        UnidadMovil otraUnidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(unidad);

        Assert.assertTrue( jugador1.puedoAgregar(otraUnidad));

    }

    @Test
    public void test11PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorSeAgregan50Unidades(){

        UnidadMovil unidad;
        UnidadMovil unidad51 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad51.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        for (int i = 0; i < 50; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }


        Assert.assertFalse( jugador1.puedoAgregar(unidad51));
    }

    @Test
    public void test12PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregan49Unidades(){

        UnidadMovil unidad;
        UnidadMovil unidad50 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad50.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        for (int i = 0; i < 49; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }


        Assert.assertTrue( jugador1.puedoAgregar(unidad50));
    }

    @Test
    public void test13PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregan50UnidadesYSeAgreganEdificios(){

        UnidadMovil unidad;
        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        for (int i = 0; i < 50; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }

        Assert.assertTrue(jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test14PuedoAgregarDebeDarTrueCuandoElEdificioNoFueAgregadaPreviamente(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertTrue( jugador1.puedoAgregar(edificio));


    }

    @Test
    public void test15PuedoAgregarDebeDarFalseCuandoElEdificioFueAgregadaPreviamente(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(edificio);

        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test16PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorCon100DeOroQuieroAgregarEdificioQueVale100(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona");



        Assert.assertTrue( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test17PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorCon100DeOroQuieroAgregarEdificioQueVale101(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona");



        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test18PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregaUnEdificio(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Edificio otroEdificio = Mockito.mock (Edificio.class);
        Mockito.when(otroEdificio.getCosto()).thenReturn(1);
        UnidadMovil unidad = Mockito.mock (UnidadMovil.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(edificio);

        Assert.assertTrue( jugador1.puedoAgregar(otroEdificio));
        Assert.assertTrue( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test19AgregarPiezaAgregaLaUnidad(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(unidad);


        Assert.assertFalse( jugador1.puedoAgregar(unidad));

    }


    @Test
    public void test20AgregarPiezaDebeLanzarExcepcionCuandoNoHayOroSuficiente(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona");

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test21AgregarPiezaDebeLanzarExcepcionCuandoLaUnidadFueAgregadaPreviamente(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(unidad);

        thrown.expect(PiezaYaAgregadaException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test22AgregarPiezaDebeLanzarExcepcionCuandoSeAgregaronPreviamente50Unidades(){

        UnidadMovil unidad;
        UnidadMovil unidad51 = Mockito.mock(Aldeano.class);
        Mockito.when(unidad51.getCosto()).thenReturn(1);

        Jugador jugador1 = new Jugador("Maradona");

        for (int i = 0; i < 50; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }

        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador1.agregarPieza(unidad51);
    }

    @Test
    public void test23AgregarPiezaAgregaElEdificio(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(edificio);


        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test24AgregarPiezaDebeLanzarExcepcionCuandoNoHayOroSuficienteParaElEdificio(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona");

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(edificio);

    }

    @Test
    public void test25AgregarPiezaDebeLanzarExcepcionCuandoElEdificioFueAgregadaPreviamente(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(edificio);

        thrown.expect(PiezaYaAgregadaException.class);
        jugador1.agregarPieza(edificio);
    }

    @Test
    public void test26EliminarPiezaEliminaLaPieza(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(edificio);
        jugador1.eliminarPieza(edificio);

        Assert.assertTrue( jugador1.puedoAgregar(edificio));

    }

    @Test
    public void test27EliminarPiezaDebeLanzarExcepcionSiLaPiezaNoFueAgregadaPreviamente(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        thrown.expect(PiezaAgenaException.class);
        jugador1.eliminarPieza(edificio);
    }

    @Test
    public void test28EliminarPiezaCuandoSeAgregaron50unidadesYEliminoUnaUnidadPermiteQueSePuedaVolverAAgregarOtraUnidad(){

        UnidadMovil unidad;
        UnidadMovil unidad50 = Mockito.mock(Aldeano.class);
        Mockito.when(unidad50.getCosto()).thenReturn(1);

        Jugador jugador1 = new Jugador("Maradona");

        for (int i = 0; i < 49; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }
        jugador1.agregarPieza(unidad50);
        jugador1.eliminarPieza(unidad50);
        Assert.assertTrue(jugador1.puedoAgregar(unidad50));
    }

    @Test
    public void test29EsMioDebeDarFalseSiNoSeAgregoPreviamenteLaUnidad(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(500000000);
        Jugador jugador1 = new Jugador("Maradona");


        Assert.assertFalse( jugador1.esMio(unidad));
    }
    @Test
    public void test30EsMioDebeDarTrueSiSeAgregoPreviamenteLaUnidad(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");
        jugador1.agregarPieza(unidad);


        Assert.assertTrue( jugador1.esMio(unidad));
    }

    @Test
    public void test31EsMioDebeDarFalseLuegoDeEliminarLaUnidadPreviamenteAgregada(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");
        jugador1.agregarPieza(unidad);
        jugador1.eliminarPieza(unidad);


        Assert.assertFalse( jugador1.esMio(unidad));
    }

    @Test
    public void test32EsMioDebeDarFalseSiNoSeAgregoPreviamenteElEdificio(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertFalse( jugador1.esMio(edificio));
    }
    @Test
    public void test33EsMioDebeDarTrueSiSeAgregoPreviamenteElEdificio(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");
        jugador1.agregarPieza(edificio);


        Assert.assertTrue( jugador1.esMio(edificio));
    }

    @Test
    public void test34EsMioDebeDarFalseLuegoDeEliminarElEdificioPreviamenteAgregada(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");
        jugador1.agregarPieza(edificio);

        jugador1.eliminarPieza(edificio);
        Assert.assertFalse( jugador1.esMio(edificio));
    }

    @Test
    public void test35SumarOro50PermiteAgregarPiezaQueCuesta150AlCrearseElAldeanoCon100DeOro(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(150);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertFalse( jugador1.puedoAgregar(unidad));

        jugador1.sumarOro(50);
        Assert.assertTrue( jugador1.puedoAgregar(unidad));

    }

    @Test
    public void test36SumarOro50YAgregarPiezaDe150ConLos100DelJugadorYaNoPermiteAgregarMasPiezasDeValorMayorACero(){

        UnidadMovil unidad150 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad150.getCosto()).thenReturn(150);

        UnidadMovil unidadVale1 = Mockito.mock (Aldeano.class);
        Mockito.when(unidadVale1.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");
        jugador1.sumarOro(50);
        jugador1.agregarPieza(unidad150);

        Assert.assertFalse( jugador1.puedoAgregar(unidadVale1));

    }

    @Test
    public void test37SumarOroDebeLanzarExcepcionSiSeSumaUnNumeroNegativo(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona");

        thrown.expect(OroNegativoException.class);
        jugador1.sumarOro(-1);

    }

    @Test
    public void test38puedoAgregarDebeDarFalseSiLaUnidadTieneCostoNegativo(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertFalse( jugador1.puedoAgregar(unidad));


    }
    @Test
    public void test39puedoAgregarDebeDarFalseSiElEdificioTieneCostoNegativo(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona");

        Assert.assertFalse( jugador1.puedoAgregar(edificio));


    }

    @Test
    public void test40AgregarDebeLanzarExcepcionSiAgregoUnidadDeCostoNegativo(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona");

        thrown.expect(CostoNegativoExeption.class);
        jugador1.agregarPieza(unidad);


    }

    @Test
    public void test41AgregarDebeLanzarExcepcionSiAgregoEdificioDeCostoNegativo(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona");

        thrown.expect(CostoNegativoExeption.class);
        jugador1.agregarPieza(edificio);


    }


    @Test
    public void test42GetPiezasDevuelveTodasLasPiezasPreviamenteAgregadasEdificiosYUnidades(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        UnidadMovil otraUnidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        UnidadMovil unidadNoIncluida = Mockito.mock (Aldeano.class);

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Edificio edificioNoIncluido = Mockito.mock (Edificio.class);

        Jugador jugador1 = new Jugador("Maradona");

        jugador1.agregarPieza(unidad);
        jugador1.agregarPieza(otraUnidad);
        jugador1.agregarPieza(edificio);

       ArrayList<Atacable> lista = jugador1.getPiezas();


        Assert.assertTrue( lista.contains(unidad));
        Assert.assertTrue( lista.contains(otraUnidad));
        Assert.assertTrue( lista.contains(edificio));
        Assert.assertFalse( lista.contains(edificioNoIncluido));
        Assert.assertFalse( lista.contains(unidadNoIncluida));
    }

    @Test
    public void test43EsTuTurnoAvisaATodasSusPiezas(){

        Jugador jugador1 = new Jugador("Maradona");
        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);

        jugador1.agregarPieza(unidad);
        jugador1.agregarPieza(edificio);

        jugador1.esTuTurno();

        verify(unidad, times(1)).huboUnCambioDeTurno(jugador1);
        verify(edificio, times(1)).huboUnCambioDeTurno(jugador1);
    }

}
