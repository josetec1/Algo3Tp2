package fiuba.algo3.aoe.Jugador;
import fiuba.algo3.aoe.Jugadores.*;
import fiuba.algo3.aoe.Jugadores.Piezas.LimiteDePoblacionAlcanzadoException;
import fiuba.algo3.aoe.Jugadores.Piezas.NoSePuedeEliminarElCastilloException;
import fiuba.algo3.aoe.Jugadores.Piezas.PiezaAgenaException;
import fiuba.algo3.aoe.Jugadores.Piezas.PiezaYaAgregadaException;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.*;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import org.junit.Assert;
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

private Castillo castillo= new Castillo ();

    @Test
    public void test01CrearJugadorCreaJugadorConNombreMauricio(){
        Jugador jugador1 = new Jugador("Mauricio", castillo );
        Assert.assertEquals(jugador1.getNombre(), "Mauricio");

    }

    @Test
    public void test02CrearJugadorCreaJugadorCon100DeOro(){
        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona",castillo );
        jugador1.agregarPieza(unidad);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test03CrearJugadorCreaJugadorCon100DeOroYNoPuedeAgregarAlgoQueCueste101(){
        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Diego",castillo );

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test04CrearJugadorCreaJugadorCon3UnidadesYElMaximoQuePuedeTenerSon50(){
        Aldeano unidad;
        Aldeano unidad50 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad50.getCosto()).thenReturn(0);
        Jugador jugador1 = new Jugador("D10S",castillo );

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
        Jugador jugador1 = new Jugador("Maradona",castillo );

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
        Jugador jugador1 = new Jugador("Armando",castillo );

        Assert.assertTrue( jugador1.puedoAgregar(unidad));

    }

    @Test
    public void test11PuedoAgregarDebeDarFalseCuandoLaUnidadFueAgregadaPreviamente(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(0);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.puedoAgregar(unidad);

        Assert.assertTrue( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test12PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorCon100DeOroQuieroAgregarUnidadQueVale100(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        Assert.assertTrue( jugador1.puedoAgregar(unidad));


    }

    @Test
    public void test13PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorCon100DeOroQuieroAgregarUnidadQueVale101(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        Assert.assertFalse( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test14PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregaUnaUnidad(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Aldeano otraUnidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(unidad);

        Assert.assertTrue( jugador1.puedoAgregar(otraUnidad));

    }

    @Test
    public void test15PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorSeAgregan47Unidades(){

        Aldeano unidad;
        Aldeano unidad48 = Mockito.mock (Aldeano.class);
        Mockito.when(unidad48.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

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
        Jugador jugador1 = new Jugador("Maradona",castillo );

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
        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        for (int i = 0; i < 47; i++) {
            unidad = Mockito.mock (Aldeano.class);
            Mockito.when(unidad.getCosto()).thenReturn(1);
            jugador1.agregarPieza(unidad);
        }

        Assert.assertTrue(jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test18PuedoAgregarDebeDarTrueCuandoElEdificioNoFueAgregadaPreviamente(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        Assert.assertTrue( jugador1.puedoAgregar(edificio));


    }

    @Test
    public void test19PuedoAgregarDebeDarFalseCuandoElEdificioFueAgregadaPreviamente(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(edificio);

        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test20PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorCon100DeOroQuieroAgregarEdificioQueVale100(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona",castillo );



        Assert.assertTrue( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test21PuedoAgregarDebeDarFalseCuandoAlCrearseJugadorCon100DeOroQuieroAgregarEdificioQueVale101(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona",castillo );



        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test22PuedoAgregarDebeDarTrueCuandoAlCrearseJugadorSeAgregaUnEdificio(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Edificio otroEdificio = Mockito.mock (Edificio.class);
        Mockito.when(otroEdificio.getCosto()).thenReturn(1);
        UnidadMovil unidad = Mockito.mock (UnidadMovil.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(edificio);

        Assert.assertTrue( jugador1.puedoAgregar(otroEdificio));
        Assert.assertTrue( jugador1.puedoAgregar(unidad));
    }

    @Test
    public void test23AgregarPiezaAgregaLaUnidad(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(unidad);


        Assert.assertFalse( jugador1.puedoAgregar(unidad));

    }


    @Test
    public void test24AgregarPiezaDebeLanzarExcepcionCuandoNoHayOroSuficiente(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test25AgregarPiezaDebeLanzarExcepcionCuandoLaUnidadFueAgregadaPreviamente(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(unidad);

        thrown.expect(NoSePuedeAgregarPiezaException.class);
        jugador1.agregarPieza(unidad);
    }

    @Test
    public void test26AgregarPiezaDebeLanzarExcepcionCuandoSeAgregaronPreviamente47Unidades(){

        Aldeano unidad;
        Aldeano unidad48 = Mockito.mock(Aldeano.class);
        Mockito.when(unidad48.getCosto()).thenReturn(1);

        Jugador jugador1 = new Jugador("Maradona",castillo );

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
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(edificio);


        Assert.assertFalse( jugador1.puedoAgregar(edificio));
    }

    @Test
    public void test28AgregarPiezaDebeLanzarExcepcionCuandoNoHayOroSuficienteParaElEdificio(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(101);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        thrown.expect(RecursoInsuficienteException.class);
        jugador1.agregarPieza(edificio);

    }

    @Test
    public void test29AgregarPiezaDebeLanzarExcepcionCuandoElEdificioFueAgregadaPreviamente(){

        PlazaCentral edificio = Mockito.mock (PlazaCentral.class);
        Mockito.when(edificio.getCosto()).thenReturn(100);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(edificio);

        thrown.expect(NoSePuedeAgregarPiezaException.class);
        jugador1.agregarPieza(edificio);
    }

    @Test
    public void test30EliminarPiezaEliminaLaPieza(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        jugador1.agregarPieza(edificio);
        jugador1.eliminarPieza(edificio);

        Assert.assertTrue( jugador1.puedoAgregar(edificio));

    }

    @Test
    public void test31EliminarPiezaDebeLanzarExcepcionSiLaPiezaNoFueAgregadaPreviamente(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        thrown.expect(PiezaAgenaException.class);
        jugador1.eliminarPieza(edificio);
    }

    @Test
    public void test32EliminarPiezaCuandoSeAgregaron47unidadesYEliminoUnaUnidadPermiteQueSePuedaVolverAAgregarOtraUnidad(){

        Aldeano unidad;
        Aldeano unidad47 = Mockito.mock(Aldeano.class);
        Mockito.when(unidad47.getCosto()).thenReturn(1);

        Jugador jugador1 = new Jugador("Maradona",castillo );

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
        Jugador jugador1 = new Jugador("Maradona",castillo );


        Assert.assertFalse( jugador1.esMio(unidad));
    }
    @Test
    public void test34EsMioDebeDarTrueSiSeAgregoPreviamenteLaUnidad(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );
        jugador1.agregarPieza(unidad);


        Assert.assertTrue( jugador1.esMio(unidad));
    }

    @Test
    public void test35EsMioDebeDarFalseLuegoDeEliminarLaUnidadPreviamenteAgregada(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );
        jugador1.agregarPieza(unidad);
        jugador1.eliminarPieza(unidad);


        Assert.assertFalse( jugador1.esMio(unidad));
    }

    @Test
    public void test36EsMioDebeDarFalseSiNoSeAgregoPreviamenteElEdificio(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        Assert.assertFalse( jugador1.esMio(edificio));
    }
    @Test
    public void test37EsMioDebeDarTrueSiSeAgregoPreviamenteElEdificio(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );
        jugador1.agregarPieza(edificio);


        Assert.assertTrue( jugador1.esMio(edificio));
    }

    @Test
    public void test38EsMioDebeDarFalseLuegoDeEliminarElEdificioPreviamenteAgregada(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );
        jugador1.agregarPieza(edificio);

        jugador1.eliminarPieza(edificio);
        Assert.assertFalse( jugador1.esMio(edificio));
    }

    @Test
    public void test39SumarOro50PermiteAgregarPiezaQueCuesta150AlCrearseElAldeanoCon100DeOro(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(150);
        Jugador jugador1 = new Jugador("Maradona",castillo );

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
        Jugador jugador1 = new Jugador("Maradona",castillo );
        jugador1.sumarOro(50);
        jugador1.agregarPieza(unidad150);

        Assert.assertFalse( jugador1.puedoAgregar(unidadVale1));

    }

    @Test
    public void test41SumarOroDebeLanzarExcepcionSiSeSumaUnNumeroNegativo(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        thrown.expect(OroNegativoException.class);
        jugador1.sumarOro(-1);

    }

    @Test
    public void test42puedoAgregarDebeDarFalseSiLaUnidadTieneCostoNegativo(){

        UnidadMovil unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        Assert.assertFalse( jugador1.puedoAgregar(unidad));


    }
    @Test
    public void test43puedoAgregarDebeDarFalseSiElEdificioTieneCostoNegativo(){

        Edificio edificio = Mockito.mock (Edificio.class);
        Mockito.when(edificio.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        Assert.assertFalse( jugador1.puedoAgregar(edificio));


    }

    @Test
    public void test44AgregarDebeLanzarExcepcionSiAgregoUnidadDeCostoNegativo(){

        Aldeano unidad = Mockito.mock (Aldeano.class);
        Mockito.when(unidad.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

        thrown.expect(CostoNegativoExeption.class);
        jugador1.agregarPieza(unidad);


    }

    @Test
    public void test45AgregarDebeLanzarExcepcionSiAgregoEdificioDeCostoNegativo(){

        Cuartel edificio = Mockito.mock (Cuartel.class);
        Mockito.when(edificio.getCosto()).thenReturn(-1);
        Jugador jugador1 = new Jugador("Maradona",castillo );

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

        Jugador jugador1 = new Jugador("Maradona",castillo );

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

        Jugador jugador1 = new Jugador("Maradona",castillo );
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

        Jugador jugador1 = new Jugador("Maradona",castillo );
        ArrayList<Aldeano> aldeanos = new ArrayList<>();

        thrown.expect(NoSePuedeEliminarElCastilloException.class);
        jugador1.eliminarPieza(castillo);
    }

    @Test
    public void test49EliminarPiezaAlEnviarElCastilloAgenoDebeLanzarExcepcion(){

        Jugador jugador1 = new Jugador("Maradona",castillo );
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        Castillo castilloAgeno = new Castillo();

        thrown.expect(PiezaAgenaException.class);
        jugador1.eliminarPieza(castilloAgeno);
    }

}
