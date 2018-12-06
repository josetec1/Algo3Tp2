package fiuba.algo3.aoe.modelo.Jugador;
import fiuba.algo3.aoe.modelo.Jugadores.*;
import fiuba.algo3.aoe.modelo.Jugadores.Piezas.NoSePuedeEliminarElCastilloException;
import fiuba.algo3.aoe.modelo.Jugadores.Piezas.PiezaAgenaException;
import fiuba.algo3.aoe.modelo.Jugadores.Piezas.PiezaYaAgregadaException;
import fiuba.algo3.aoe.modelo.Observadores.ObservadorJugador;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.*;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class JugadorTest {

    private Castillo castillo= new Castillo();
    private ArrayList<Aldeano> aldeanos = new ArrayList<>();
    private PlazaCentral plaza;
    private Jugador jugador1;

    @Before
    public void setUp(){
        plaza = new PlazaCentral();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());

    }

    @Test
    public void test01CrearJugadorCreaJugadorConNombreMauricio(){
        jugador1 = new Jugador("ElDiego",castillo,plaza,aldeanos);
        Assert.assertEquals(jugador1.getNombre(), "ElDiego");

    }

    @Test
    public void test02CrearJugadorCreaJugadorCon100DeOro(){
        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.agregarPieza(unidad);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test03CrearJugadorCreaJugadorCon100DeOroYNoPuedeAgregarAlgoQueCueste101(){
        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test04CrearJugadorCreaJugadorCon3UnidadesYElMaximoQuePuedeTenerSon50(){
        Aldeano unidad;
        Aldeano unidad50 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad50.getCosto()).thenReturn(0);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        for (int i = 0; i <47 ; i++) {

            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(0);
            jugador1.agregarPieza(unidad);
        }

        thrown.expect((NoSePuedeAgregarPiezaException.class));
        jugador1.agregarPieza(unidad50);
    }


    @Test
    public void test05CrearJugadorDebeLanzarExcepcionSiLeEnvioMasDeTresAldeanos(){
        PlazaCentral plaza = new PlazaCentral();
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano()); //4

        thrown.expect(CantidadIncorrectaAldeanosException.class);
        Jugador jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos );
    }

    @Test
    public void test06CrearJugadorDebeLanzarExcepcionSiLeEnvioMenosDeTresAldeanos(){


        PlazaCentral plaza = new PlazaCentral();
        ArrayList<Aldeano> aldeanos = new ArrayList<>();

        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());//2


        thrown.expect(CantidadIncorrectaAldeanosException.class);
        Jugador jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos );
    }

    @Test
    public void test07CrearJugadorDebeLanzarExcepcionSiLeEnvioAldeanosRepetidos(){
        PlazaCentral plaza = new PlazaCentral();
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        Aldeano aldeanoRepetido= new Aldeano();

        aldeanos.add(new Aldeano());
        aldeanos.add(aldeanoRepetido);
        aldeanos.add(aldeanoRepetido);

        thrown.expect(PiezaYaAgregadaException.class);
        Jugador jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos );
    }


    @Test
    public void test08AlCrearJugadorContieneLosElementosConLosQueSeConstruyo(){

        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        PlazaCentral plaza = new PlazaCentral();
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();
        aldeanos.add(aldeano1);
        aldeanos.add(aldeano2);
        aldeanos.add(aldeano3);
        Jugador jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos );

        Assert.assertTrue(jugador1.esMio(aldeano1));
        Assert.assertTrue(jugador1.esMio(aldeano2));
        Assert.assertTrue(jugador1.esMio(aldeano3));
        Assert.assertTrue(jugador1.esMio(plaza));
        Assert.assertTrue( jugador1.esMio(castillo));
    }

    @Test
    public void test09LosEdificiosNoCuentanComoLimiteDePoblacion(){

        Aldeano unidad;
        Aldeano unidad50 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad50.getCosto()).thenReturn(0);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        for (int i = 0; i <47 ; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(0);
            jugador1.agregarPieza(unidad);
        }

        for (int i = 0; i <1500 ; i++) {
            PlazaCentral edificio = Mockito.mock (PlazaCentral.class);
            Mockito.when(edificio.getCosto()).thenReturn(0);
            jugador1.agregarPieza(edificio);
        }

        thrown.expect((NoSePuedeAgregarPiezaException.class));
        jugador1.agregarPieza(unidad50);
    }




    @Test
    public void test10PuedoAgregarDebeDarTrueCuandoLaUnidadNoFueAgregadaPreviamente(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(0);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertTrue( jugador1.puedoAgregar(unidad));

    }

    @Test
    public void test11PuedoAgregarDebeDarFalseCuandoLaUnidadFueAgregadaPreviamente(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(0);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.puedoAgregar(unidad);

        Assert.assertTrue( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test12PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorCon100DeOroQuieroAgregarUnidadQueVale100(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertTrue( jugador1.puedoAgregar(unidad));


    }

    @Test
    public void test13PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorCon100DeOroQuieroAgregarUnidadQueVale101(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertFalse( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test14PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregaUnaUnidad(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Aldeano otraUnidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(unidad);

        Assert.assertTrue( jugador1.puedoAgregar(otraUnidad));

    }

    @Test
    public void test15PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorSeAgregan47Unidades(){

        Aldeano unidad;
        Aldeano unidad48 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad48.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        for (int i = 0; i < 47; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }
        Assert.assertFalse( jugador1.puedoAgregar(unidad48));
    }

    @Test
    public void test16PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregan46Unidades(){

        Aldeano unidad;
        Aldeano unidad50 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad50.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        for (int i = 0; i < 46; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }

        Assert.assertTrue( jugador1.puedoAgregar(unidad50));
    }

    @Test
    public void test17PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregan47UnidadesYSeAgreganEdificios(){

        Aldeano unidad;
        EdificioConstruible edificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        for (int i = 0; i < 47; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }

        Assert.assertTrue(jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test18PuedoAgregarDebeDarTrueCuandoElEdificioNoFueAgregadaPreviamente(){

        EdificioConstruible edificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertTrue( jugador1.puedoAgregar(edificio));


    }

    @Test
    public void test19PuedoAgregarDebeDarFalseCuandoElEdificioFueAgregadaPreviamente(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(edificio);

        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test20PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorCon100DeOroQuieroAgregarEdificioQueVale100(){

        EdificioConstruible edificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(edificio.getCosto()).thenReturn(100);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);



        Assert.assertTrue( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test21PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorCon100DeOroQuieroAgregarEdificioQueVale101(){

        EdificioConstruible edificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(edificio.getCosto()).thenReturn(101);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);



        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test22PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregaUnEdificio(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        EdificioConstruible otroEdificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(otroEdificio.getCosto()).thenReturn(1);
        UnidadMovil unidad = Mockito.mock (UnidadMovil.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(edificio);

        Assert.assertTrue( jugador1.puedoAgregar(otroEdificio));
        Assert.assertTrue( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test23AgregarPiezaAgregaLaUnidad(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(unidad);


        Assert.assertFalse( jugador1.puedoAgregar(unidad));

    }


    @Test
    public void test24AgregarPiezaDebeLanzarExcepcionCuandoNoHayOroSuficiente(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test25AgregarPiezaDebeLanzarExcepcionCuandoLaUnidadFueAgregadaPreviamente(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(unidad);

        thrown.expect(NoSePuedeAgregarPiezaException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test26AgregarPiezaDebeLanzarExcepcionCuandoSeAgregaronPreviamente47Unidades(){

        Aldeano unidad;
        Aldeano unidad48 = Mockito.mock(Aldeano.class);
        Mockito.when(unidad48.getCosto()).thenReturn(1);

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        for (int i = 0; i < 47; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }

        thrown.expect(NoSePuedeAgregarPiezaException.class);
        jugador1.agregarPieza(unidad48);
    }

    @Test
    public void test27AgregarPiezaAgregaElEdificio(){

        PlazaCentral edificio = Mockito.mock (PlazaCentral.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(edificio);


        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test28AgregarPiezaDebeLanzarExcepcionCuandoNoHayOroSuficienteParaElEdificio(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(101);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(edificio);

    }

    @Test
    public void test29AgregarPiezaDebeLanzarExcepcionCuandoElEdificioFueAgregadaPreviamente(){

        PlazaCentral edificio = Mockito.mock (PlazaCentral.class);
        Mockito.when(edificio.getCosto()).thenReturn(100);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(edificio);

        thrown.expect(NoSePuedeAgregarPiezaException.class);
        jugador1.agregarPieza(edificio);
    }

    @Test
    public void test30EliminarPiezaEliminaLaPieza(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(edificio);
        jugador1.eliminarPieza(edificio);

        Assert.assertTrue( jugador1.puedoAgregar(edificio));

    }

    @Test
    public void test31EliminarPiezaDebeLanzarExcepcionSiLaPiezaNoFueAgregadaPreviamente(){

        EdificioConstruible edificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        thrown.expect(PiezaAgenaException.class);
        jugador1.eliminarPieza(edificio);
    }

    @Test
    public void test32EliminarPiezaCuandoSeAgregaron47unidadesYEliminoUnaUnidadPermiteQueSePuedaVolverAAgregarOtraUnidad(){

        Aldeano unidad;
        Aldeano unidad47 = Mockito.mock(Aldeano.class);
        Mockito.when(unidad47.getCosto()).thenReturn(1);

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        for (int i = 0; i < 46; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }
        jugador1.agregarPieza(unidad47);
        jugador1.eliminarPieza(unidad47);
        Assert.assertTrue(jugador1.puedoAgregar(unidad47));
    }

    @Test
    public void test33EsMioDebeDarFalseSiNoSeAgregoPreviamenteLaUnidad(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(500000000);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);


        Assert.assertFalse( jugador1.esMio(unidad));
    }
    @Test
    public void test34EsMioDebeDarTrueSiSeAgregoPreviamenteLaUnidad(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.agregarPieza(unidad);


        Assert.assertTrue( jugador1.esMio(unidad));
    }

    @Test
    public void test35EsMioDebeDarFalseLuegoDeEliminarLaUnidadPreviamenteAgregada(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.agregarPieza(unidad);
        jugador1.eliminarPieza(unidad);


        Assert.assertFalse( jugador1.esMio(unidad));
    }

    @Test
    public void test36EsMioDebeDarFalseSiNoSeAgregoPreviamenteElEdificio(){

        EdificioConstruible edificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertFalse( jugador1.esMio(edificio));
    }
    @Test
    public void test37EsMioDebeDarTrueSiSeAgregoPreviamenteElEdificio(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.agregarPieza(edificio);


        Assert.assertTrue( jugador1.esMio(edificio));
    }

    @Test
    public void test38EsMioDebeDarFalseLuegoDeEliminarElEdificioPreviamenteAgregada(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.agregarPieza(edificio);

        jugador1.eliminarPieza(edificio);
        Assert.assertFalse( jugador1.esMio(edificio));
    }

    @Test
    public void test39SumarOro50PermiteAgregarPiezaQueCuesta150AlCrearseElAldeanoCon100DeOro(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(150);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertFalse( jugador1.puedoAgregar(unidad));

        jugador1.sumarOro(50);
        Assert.assertTrue( jugador1.puedoAgregar(unidad));

    }

    @Test
    public void test40SumarOro50YAgregarPiezaDe150ConLos100DelJugadorYaNoPermiteAgregarMasPiezasDeValorMayorACero(){

        Aldeano unidad150 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad150.getCosto()).thenReturn(150);

        UnidadMovil unidadVale1 = Mockito.mock (Aldeano.class);
        Mockito.when(unidadVale1.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.sumarOro(50);
        jugador1.agregarPieza(unidad150);

        Assert.assertFalse( jugador1.puedoAgregar(unidadVale1));

    }

    @Test
    public void test41SumarOroDebeLanzarExcepcionSiSeSumaUnNumeroNegativo(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        thrown.expect(OroNegativoException.class);
        jugador1.sumarOro(-1);

    }

    @Test
    public void test42puedoAgregarDebeDarFalseSiLaUnidadTieneCostoNegativo(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(-1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertFalse( jugador1.puedoAgregar(unidad));


    }
    @Test
    public void test43puedoAgregarDebeDarFalseSiElEdificioTieneCostoNegativo(){

        EdificioConstruible edificio = Mockito.mock (EdificioConstruible.class);
        Mockito.when(edificio.getCosto()).thenReturn(-1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        Assert.assertFalse( jugador1.puedoAgregar(edificio));


    }

    @Test
    public void test44AgregarDebeLanzarExcepcionSiAgregoUnidadDeCostoNegativo(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(-1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        thrown.expect(CostoNegativoExeption.class);
        jugador1.agregarPieza(unidad);


    }

    @Test
    public void test45AgregarDebeLanzarExcepcionSiAgregoEdificioDeCostoNegativo(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(-1);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        thrown.expect(CostoNegativoExeption.class);
        jugador1.agregarPieza(edificio);


    }


    @Test
    public void test46GetAtacablesDevuelveTodasLasPiezasPreviamenteAgregadasEdificiosYUnidades(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Aldeano otraUnidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Aldeano unidadNoIncluida = Mockito.mock (Aldeano.class);

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Edificio edificioNoIncluido = Mockito.mock (Edificio.class);

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);

        jugador1.agregarPieza(unidad);
        jugador1.agregarPieza(otraUnidad);
        jugador1.agregarPieza(edificio);

         List<Atacable> lista = jugador1.getAtacables();


        Assert.assertTrue( lista.contains(unidad));
        Assert.assertTrue( lista.contains(otraUnidad));
        Assert.assertTrue( lista.contains(edificio));
        Assert.assertFalse( lista.contains(edificioNoIncluido));
        Assert.assertFalse( lista.contains(unidadNoIncluida));
    }

    @Test
    public void test47EsTuTurnoAvisaATodasSusPiezas(){

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);

        jugador1.agregarPieza(unidad);
        jugador1.agregarPieza(edificio);

        jugador1.esTuTurno();

        verify(unidad, times(1)).huboUnCambioDeTurno(jugador1);
        verify(edificio, times(1)).huboUnCambioDeTurno(jugador1);
    }


    @Test
    public void test48EliminarPiezaAlEnviarElCastilloDebeLanzarExcepcion(){

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        ArrayList<Aldeano> aldeanos = new ArrayList<>();

        thrown.expect(NoSePuedeEliminarElCastilloException.class);
        jugador1.eliminarPieza(castillo);
    }

    @Test
    public void test49EliminarPiezaAlEnviarElCastilloAgenoDebeLanzarExcepcion(){

        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        Castillo castilloAgeno = new Castillo();

        thrown.expect(PiezaAgenaException.class);
        jugador1.eliminarPieza(castilloAgeno);
    }

    @Test
    public void test50AgregarPiezaNotificaAObservadores(){

        ObservadorJugador unObservador = Mockito.mock (ObservadorJugador.class);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.agregarObservadores(unObservador);

        Aldeano aldeano = Mockito.mock(Aldeano.class);
        Arquero arquero = Mockito.mock(Arquero.class);
        Espadachin espadachin = Mockito.mock(Espadachin.class);
        ArmaDeAsedio arma = Mockito.mock(ArmaDeAsedio.class);
        PlazaCentral plaza = Mockito.mock(PlazaCentral.class);
        Cuartel cuartel = Mockito.mock(Cuartel.class);

        jugador1.agregarPieza(aldeano);
        jugador1.agregarPieza(arquero);
        jugador1.agregarPieza(espadachin);
        jugador1.agregarPieza(arma);
        jugador1.agregarPieza(plaza);
        jugador1.agregarPieza(cuartel);

        verify(unObservador, times(6)).actualizar();
    }

    @Test
    public void test51eliminarPiezaNotificaAObservadores(){

        ObservadorJugador unObservador = Mockito.mock (ObservadorJugador.class);
        jugador1 = new Jugador("Maradona",castillo,plaza,aldeanos);
        jugador1.agregarObservadores(unObservador);

        Aldeano aldeano = Mockito.mock(Aldeano.class);


        jugador1.agregarPieza(aldeano); //1
        jugador1.eliminarPieza(aldeano); //2


        verify(unObservador, times(2)).actualizar();
    }

}
