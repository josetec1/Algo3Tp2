package fiuba.algo3.aoe.Jugador;

import fiuba.algo3.aoe.Jugadores.*;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;

public class ListaDePiezasTest {

    @Test
    public void test01getCantidadDeUnidadesEsCeroAlCrearLaListaDePiezas(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Assert.assertThat(piezas.getCantidadDeUnidades(), is(0));

    }

    @Test
    public void test02getCastilloMeDevuelveElCastilloConElQueSeCreoLaListaDePiezas(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Assert.assertSame(piezas.getCastillo(),castillo);
    }

    @Test
    public void test03PuedoAgregarDebeDarTruePorQueLosEdificiosNoTienenLimite(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        PlazaCentral plaza;
        Cuartel cuartel;

        for (int i = 0; i <100 ; i++) {

            plaza = new PlazaCentral();
            cuartel = new Cuartel();
            piezas.agregar(plaza);
            piezas.agregar(cuartel);
        }

        Assert.assertTrue(piezas.puedoAgregar(new PlazaCentral()));
    }

    @Test
    public void test04PuedoAgregarDebeDarTrueLuegoDeAgregar49Unidades(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Espadachin espadachin;

        for (int i = 0; i <49 ; i++) {
           espadachin = new Espadachin();
           piezas.agregar(espadachin);
        }

        Assert.assertTrue(piezas.puedoAgregar(new Espadachin()));

    }

    @Test
    public void test05PuedoAgregarDebeDarFalseLuegoDeAgregar50Unidades(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Aldeano aldeano;
        Espadachin espadachin50 = new Espadachin();


        for (int i = 0; i <49 ; i++) {
            aldeano = new Aldeano();
            piezas.agregar(aldeano);
        }

        piezas.agregar(espadachin50);
        Assert.assertFalse(piezas.puedoAgregar(espadachin50));
    }

    @Test
    public void test06PuedoAgregarDebeDarTrueLuegoDeAgregar50UnidadesYQuererAgregarUnEdificio(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Aldeano aldeano;
        Espadachin espadachin50 = new Espadachin();
        PlazaCentral plaza = new PlazaCentral();

        for (int i = 0; i <50 ; i++) {
            aldeano = new Aldeano();
            piezas.agregar(aldeano);
        }


        Assert.assertTrue(piezas.puedoAgregar(plaza));
    }


    @Test
    public void test07PuedoAgregarDebeDarTrueLuegoDeAgregar50UnidadesYEliminarUna(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        ArmaDeAsedio armaDeAsedio;
        Arquero arquero50 = new Arquero();
        Arquero arquero51 = new Arquero();


        for (int i = 0; i <49 ; i++) {
            armaDeAsedio = new ArmaDeAsedio();
            piezas.agregar(armaDeAsedio);
        }

        piezas.agregar(arquero50);
        Assert.assertFalse(piezas.puedoAgregar(arquero51));

        piezas.eliminar (arquero50);
        Assert.assertTrue(piezas.puedoAgregar(arquero50));


    }


    @Test
    public void test08GetCantidadDeUnidadesNoCuentaLosEdificiosQueSeAgreguen(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        PlazaCentral plaza;
        Cuartel cuartel;
        Aldeano unSoloAldeano = new Aldeano();

        for (int i = 0; i <100 ; i++) {

            plaza = new PlazaCentral();
            cuartel = new Cuartel();
            piezas.agregar(plaza);
            piezas.agregar(cuartel);

        }
        piezas.agregar(unSoloAldeano);

        Assert.assertThat(piezas.getCantidadDeUnidades(),is(1));
    }

    @Test
    public void test09GetCantidadDeUnidadesDebeDar3LuegoDeAgregar3Unidades(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Arquero arquero;
        for (int i = 0; i <3 ; i++) {
            arquero = new Arquero();
            piezas.agregar(arquero);
        }

        Assert.assertThat(piezas.getCantidadDeUnidades(),is(3));
    }

    @Test
    public void test10GetCantidadDeUnidadesDebeDar20LuegoDeAgregar21UnidadesYEliminar1(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Espadachin espadachin21 = new Espadachin();
        Arquero arquero;
        for (int i = 0; i <20 ; i++) {
            arquero = new Arquero();
            piezas.agregar(arquero);
        }
        piezas.agregar(espadachin21);

        piezas.eliminar(espadachin21);
        Assert.assertThat(piezas.getCantidadDeUnidades(),is(20));
    }

    @Test
    public void test11ExisteDebeDarTrueCuandoSeCreaLaListaDePiezasYSePreguntaPorElCastillo(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);


        Assert.assertTrue(piezas.existe(castillo));

    }

    @Test
    public void test12ExisteDebeDarFalseSiLaPiezaNOSeAgregoPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Aldeano aldeano = new Aldeano();
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        ArmaDeAsedio arma = new ArmaDeAsedio();
        PlazaCentral plaza = new PlazaCentral();
        Cuartel cuartel = new Cuartel();

        Assert.assertFalse(piezas.existe(aldeano));
        Assert.assertFalse(piezas.existe(espadachin));
        Assert.assertFalse(piezas.existe(arquero));
        Assert.assertFalse(piezas.existe(arma));
        Assert.assertFalse(piezas.existe(plaza));
        Assert.assertFalse(piezas.existe(cuartel));

    }
    @Test
    public void test13ExisteDebeDarTrueCuandoLaPiezaSeAgregoPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Aldeano aldeano = new Aldeano();
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        ArmaDeAsedio arma = new ArmaDeAsedio();
        PlazaCentral plaza = new PlazaCentral();
        Cuartel cuartel = new Cuartel();

        piezas.agregar(aldeano);
        piezas.agregar(espadachin);
        piezas.agregar(arquero);
        piezas.agregar(arma);
        piezas.agregar(plaza);
        piezas.agregar(cuartel);

        Assert.assertTrue(piezas.existe(aldeano));
        Assert.assertTrue(piezas.existe(espadachin));
        Assert.assertTrue(piezas.existe(arquero));
        Assert.assertTrue(piezas.existe(arma));
        Assert.assertTrue(piezas.existe(plaza));
        Assert.assertTrue(piezas.existe(cuartel));

    }

    @Test
    public void test14ExisteDebeDarFalseLuegoDeEliminarLaPieza(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Aldeano aldeano = new Aldeano();
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        ArmaDeAsedio arma = new ArmaDeAsedio();
        PlazaCentral plaza = new PlazaCentral();
        Cuartel cuartel = new Cuartel();

        piezas.agregar(aldeano);
        piezas.agregar(espadachin);

        piezas.eliminar(espadachin);
        Assert.assertTrue(piezas.existe(aldeano));
        Assert.assertFalse(piezas.existe(espadachin));

    }

    /*************************************************************
            Agregar para cada metodo hay que probar Aldeano
     *************************************/

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test15AgregarAldeanoDebeLanzarExcepcionSiIntentoAgregarAlgoPreviamenteAgregado(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Aldeano aldeano = new Aldeano();
        piezas.agregar(aldeano);



        thrown.expect(PiezaYaAgregadaException.class);
        piezas.agregar(aldeano);
    }

    @Test
    public void test16AgregarAldeanoDebeLanzarExcepcionSiIntentoAgregarMasDe50Unidades(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Aldeano aldeano;
        Aldeano aldeano51 = new Aldeano();
        for (int i = 0; i <50 ; i++) {
            aldeano = new Aldeano();
            piezas.agregar(aldeano);
        }


        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        piezas.agregar(aldeano51);

    }

    @Test
    public void test17AgregarAldeanoPermiteAgregarCualquierCantidadDeEdificios(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        PlazaCentral plaza;
        for (int i = 0; i <100 ; i++) {

            plaza = new PlazaCentral();

            piezas.agregar(plaza);

        }

        Assert.assertThat(piezas.getPlazas().size(), is(100));
    }

    @Test
    public void test18AgregarAldeanoAgregaLaUnidadIndependientementeDeLaCantidadDeEdificios(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        PlazaCentral plaza;
        for (int i = 0; i <100 ; i++) {

            plaza = new PlazaCentral();

            piezas.agregar(plaza);

        }
        Aldeano aldeano = new Aldeano();
        piezas.agregar(aldeano);
        Assert.assertTrue(piezas.existe(aldeano));

    }

    /*************************************************************
     Agregar Espadachin
     *************************************/



    @Test
    public void test19AgregarEspadachinDebeLanzarExcepcionSiIntentoAgregarAlgoPreviamenteAgregado(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Espadachin espadachin = new Espadachin();
        piezas.agregar(espadachin);

        thrown.expect(PiezaYaAgregadaException.class);
        piezas.agregar(espadachin);
    }

    @Test
    public void test20AgregarEspadachinDebeLanzarExcepcionSiIntentoAgregarMasDe50Unidades(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Espadachin espadachin;
        Espadachin espadachin51 = new Espadachin();
        for (int i = 0; i <50 ; i++) {
            espadachin = new Espadachin();
            piezas.agregar(espadachin);
        }


        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        piezas.agregar(espadachin51);

    }



    @Test
    public void test21AgregarEspadachinAgregaLaUnidadIndependientementeDeLaCantidadDeEdificios(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        PlazaCentral plaza;
        for (int i = 0; i <100 ; i++) {

            plaza = new PlazaCentral();

            piezas.agregar(plaza);

        }
        Espadachin espadachin = new Espadachin();
        piezas.agregar(espadachin);
        Assert.assertTrue(piezas.existe(espadachin));

    }

    /*************************************************************
     Agregar Arquero
     *************************************/



    @Test
    public void test22AgregarArqueroDebeLanzarExcepcionSiIntentoAgregarAlgoPreviamenteAgregado(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Arquero arquero = new Arquero();
        piezas.agregar(arquero);



        thrown.expect(PiezaYaAgregadaException.class);
        piezas.agregar(arquero);
    }

    @Test
    public void test23AgregarArqueroDebeLanzarExcepcionSiIntentoAgregarMasDe50Unidades(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Arquero arquero;
        Arquero arquero51 = new Arquero();
        for (int i = 0; i <50 ; i++) {
            arquero = new Arquero();
            piezas.agregar(arquero);
        }


        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        piezas.agregar(arquero51);

    }



    @Test
    public void test24AgregarArqueroAgregaLaUnidadIndependientementeDeLaCantidadDeEdificios(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        PlazaCentral plaza;
        for (int i = 0; i <100 ; i++) {

            plaza = new PlazaCentral();

            piezas.agregar(plaza);

        }
        Arquero arquero = new Arquero();
        piezas.agregar(arquero);
        Assert.assertTrue(piezas.existe(arquero));

    }

    /*************************************************************
     Agregar Arma De Asedio
     *************************************/



    @Test
    public void test25AgregarAsedioDebeLanzarExcepcionSiIntentoAgregarAlgoPreviamenteAgregado(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        piezas.agregar(armaDeAsedio);



        thrown.expect(PiezaYaAgregadaException.class);
        piezas.agregar(armaDeAsedio);
    }

    @Test
    public void test26AgregarAsedioDebeLanzarExcepcionSiIntentoAgregarMasDe50Unidades(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        ArmaDeAsedio armaDeAsedio;
        ArmaDeAsedio armaDeAsedio51 = new ArmaDeAsedio();
        for (int i = 0; i <50 ; i++) {
            armaDeAsedio = new ArmaDeAsedio();
            piezas.agregar(armaDeAsedio);
        }


        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        piezas.agregar(armaDeAsedio51);

    }



    @Test
    public void test27AgregarAsedioAgregaLaUnidadIndependientementeDeLaCantidadDeEdificios(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        PlazaCentral plaza;
        for (int i = 0; i <100 ; i++) {

            plaza = new PlazaCentral();

            piezas.agregar(plaza);

        }
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        piezas.agregar(armaDeAsedio);
        Assert.assertTrue(piezas.existe(armaDeAsedio));

    }

    /*************************************************************
     Agregar Plaza
     *************************************/



    @Test
    public void test28AgregarPlazaDebeLanzarExcepcionSiIntentoAgregarAlgoPreviamenteAgregado(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        PlazaCentral plaza = new PlazaCentral();
        piezas.agregar(plaza);



        thrown.expect(PiezaYaAgregadaException.class);
        piezas.agregar(plaza);
    }


    /*************************************************************
     Agregar Cuartel
     *************************************/



    @Test
    public void test29AgregarCuartelDebeLanzarExcepcionSiIntentoAgregarAlgoPreviamenteAgregado(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        Cuartel cuartel = new Cuartel();
        piezas.agregar(cuartel);



        thrown.expect(PiezaYaAgregadaException.class);
        piezas.agregar(cuartel);
    }



    @Test
    public void test30AgregarCuartelPermiteAgregarCualquierCantidadDeEdificios(){
        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Cuartel cuartel;
        for (int i = 0; i <100 ; i++) {

            cuartel = new Cuartel();

            piezas.agregar(cuartel);

        }

        Assert.assertThat(piezas.getCuarteles().size(), is(100));
    }



    /*********************************************************************
     ************************GETTERS *****************************
    ***********************************************************************/

    //*******************  ALDEANOS   ****************************************

    @Test
    public void test31GetAldeanosDevuelveLosAldeanosAgregadosPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Aldeano pieza1 = new Aldeano();
        Aldeano pieza2 = new Aldeano();
        Aldeano pieza3 = new Aldeano();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getAldeanos().size(), is(3));
        Assert.assertTrue(piezas.getAldeanos().contains(pieza1));
        Assert.assertTrue(piezas.getAldeanos().contains(pieza2));
        Assert.assertTrue(piezas.getAldeanos().contains(pieza3));

    }
    @Test

    public void test32GetAldeanosDevuelveLosAldeanosAgregadosPreviamenteSinLosAldeanosEliminados(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Aldeano pieza1 = new Aldeano();
        Aldeano pieza2 = new Aldeano();
        Aldeano pieza3 = new Aldeano();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getAldeanos().size(), is(3));
        Assert.assertTrue(piezas.getAldeanos().contains(pieza1));
        Assert.assertTrue(piezas.getAldeanos().contains(pieza2));

        piezas.eliminar(pieza3);
        Assert.assertFalse(piezas.getAldeanos().contains(pieza3));


    }
//*******************  ESPADACHIN   ****************************************

    @Test
    public void test33GetEspadachinsDevuelveLosEspadachinesAgregadosPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Espadachin pieza1 = new Espadachin();
        Espadachin pieza2 = new Espadachin();
        Espadachin pieza3 = new Espadachin();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getEspadachines().size(), is(3));
        Assert.assertTrue(piezas.getEspadachines().contains(pieza1));
        Assert.assertTrue(piezas.getEspadachines().contains(pieza2));
        Assert.assertTrue(piezas.getEspadachines().contains(pieza3));

    }
    @Test

    public void test34GetEspadachinesDevuelveLosEspadachinesAgregadosPreviamenteSinLosEspadachinesEliminados(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Espadachin pieza1 = new Espadachin();
        Espadachin pieza2 = new Espadachin();
        Espadachin pieza3 = new Espadachin();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getEspadachines().size(), is(3));
        Assert.assertTrue(piezas.getEspadachines().contains(pieza1));
        Assert.assertTrue(piezas.getEspadachines().contains(pieza2));

        piezas.eliminar(pieza3);
        Assert.assertFalse(piezas.getEspadachines().contains(pieza3));


    }
    //*******************  ARQUEROS   ****************************************

    @Test
    public void test35GetArquerosDevuelveLosArquerosAgregadosPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Arquero pieza1 = new Arquero();
        Arquero pieza2 = new Arquero();
        Arquero pieza3 = new Arquero();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getArqueros().size(), is(3));
        Assert.assertTrue(piezas.getArqueros().contains(pieza1));
        Assert.assertTrue(piezas.getArqueros().contains(pieza2));
        Assert.assertTrue(piezas.getArqueros().contains(pieza3));

    }
    @Test

    public void test36GetArquerosDevuelveLosArquerosAgregadosPreviamenteSinLosArquerosEliminados(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Arquero pieza1 = new Arquero();
        Arquero pieza2 = new Arquero();
        Arquero pieza3 = new Arquero();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getArqueros().size(), is(3));
        Assert.assertTrue(piezas.getArqueros().contains(pieza1));
        Assert.assertTrue(piezas.getArqueros().contains(pieza2));

        piezas.eliminar(pieza3);
        Assert.assertFalse(piezas.getArqueros().contains(pieza3));


    }
    //*******************  ASEDIOS   ****************************************

    @Test
    public void test37GetArmasDeAsedioDevuelveLaArmasDeAsedioAgregadosPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        ArmaDeAsedio pieza1 = new ArmaDeAsedio();
        ArmaDeAsedio pieza2 = new ArmaDeAsedio();
        ArmaDeAsedio pieza3 = new ArmaDeAsedio();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getArmasDeAsedio().size(), is(3));
        Assert.assertTrue(piezas.getArmasDeAsedio().contains(pieza1));
        Assert.assertTrue(piezas.getArmasDeAsedio().contains(pieza2));
        Assert.assertTrue(piezas.getArmasDeAsedio().contains(pieza3));

    }
    @Test

    public void test38GetArmasDeAsedioDevuelveLasArmasDeAsedioAgregadosPreviamenteSinLasArmasDeAsedioEliminadas(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        ArmaDeAsedio pieza1 = new ArmaDeAsedio();
        ArmaDeAsedio pieza2 = new ArmaDeAsedio();
        ArmaDeAsedio pieza3 = new ArmaDeAsedio();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getArmasDeAsedio().size(), is(3));
        Assert.assertTrue(piezas.getArmasDeAsedio().contains(pieza1));
        Assert.assertTrue(piezas.getArmasDeAsedio().contains(pieza2));

        piezas.eliminar(pieza3);
        Assert.assertFalse(piezas.getArmasDeAsedio().contains(pieza3));


    }
    //*******************  PLAZAS   ****************************************

    @Test
    public void test39GetPlazasCentralesDevuelveLasPlazasCentralesAgregadasPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        PlazaCentral pieza1 = new PlazaCentral();
        PlazaCentral pieza2 = new PlazaCentral();
        PlazaCentral pieza3 = new PlazaCentral();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getPlazas().size(), is(3));
        Assert.assertTrue(piezas.getPlazas().contains(pieza1));
        Assert.assertTrue(piezas.getPlazas().contains(pieza2));
        Assert.assertTrue(piezas.getPlazas().contains(pieza3));

    }
    @Test

    public void test40GetPlazasCentralesDevuelveLasPlazasCentralesAgregadosPreviamenteSinLasPlazasCentralesEliminadas(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        PlazaCentral pieza1 = new PlazaCentral();
        PlazaCentral pieza2 = new PlazaCentral();
        PlazaCentral pieza3 = new PlazaCentral();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getPlazas().size(), is(3));
        Assert.assertTrue(piezas.getPlazas().contains(pieza1));
        Assert.assertTrue(piezas.getPlazas().contains(pieza2));

        piezas.eliminar(pieza3);
        Assert.assertFalse(piezas.getPlazas().contains(pieza3));


    }
    //*******************  CUARTELES   ****************************************

    @Test
    public void test41GetCuartelesDevuelveLosCuartelesAgregadosPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Cuartel pieza1 = new Cuartel();
        Cuartel pieza2 = new Cuartel();
        Cuartel pieza3 = new Cuartel();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getCuarteles().size(), is(3));
        Assert.assertTrue(piezas.getCuarteles().contains(pieza1));
        Assert.assertTrue(piezas.getCuarteles().contains(pieza2));
        Assert.assertTrue(piezas.getCuarteles().contains(pieza3));

    }
    @Test

    public void test42GetCuartelesDevuelveLosCuartelesAgregadosPreviamenteSinLosCuartelesEliminados(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Cuartel pieza1 = new Cuartel();
        Cuartel pieza2 = new Cuartel();
        Cuartel pieza3 = new Cuartel();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);

        Assert.assertThat(piezas.getCuarteles().size(), is(3));
        Assert.assertTrue(piezas.getCuarteles().contains(pieza1));
        Assert.assertTrue(piezas.getCuarteles().contains(pieza2));

        piezas.eliminar(pieza3);
        Assert.assertFalse(piezas.getCuarteles().contains(pieza3));


    }
    //*******************  TODAS LAS PIEZAS   ****************************************

    @Test
    public void test43GetPiezasDevuelveLasPiezasAgregadasPreviamente(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Aldeano pieza1 = new Aldeano();
        Arquero pieza2 = new Arquero();
        Espadachin pieza3 = new Espadachin();
        ArmaDeAsedio pieza4 = new ArmaDeAsedio();
        PlazaCentral pieza5 = new PlazaCentral();
        Cuartel pieza6 = new Cuartel();


        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);
        piezas.agregar(pieza4);
        piezas.agregar(pieza5);
        piezas.agregar(pieza6);

        Assert.assertThat(piezas.getPiezas().size(), is(7));
        Assert.assertTrue(piezas.getPiezas().contains(pieza1));
        Assert.assertTrue(piezas.getPiezas().contains(pieza2));
        Assert.assertTrue(piezas.getPiezas().contains(pieza3));
        Assert.assertTrue(piezas.getPiezas().contains(pieza4));
        Assert.assertTrue(piezas.getPiezas().contains(pieza5));
        Assert.assertTrue(piezas.getPiezas().contains(pieza6));
        Assert.assertTrue(piezas.getPiezas().contains(castillo));

    }

    @Test
    public void test44GetPiezasDevuelveLasPiezasAgregadasPreviamenteSinLasPiezasEliminadas(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        Aldeano pieza1 = new Aldeano();
        Arquero pieza2 = new Arquero();
        Espadachin pieza3 = new Espadachin();
        ArmaDeAsedio pieza4 = new ArmaDeAsedio();
        PlazaCentral pieza5 = new PlazaCentral();
        Cuartel pieza6 = new Cuartel();

        piezas.agregar(pieza1);
        piezas.agregar(pieza2);
        piezas.agregar(pieza3);
        piezas.agregar(pieza4);
        piezas.agregar(pieza5);
        piezas.agregar(pieza6);

        Assert.assertThat(piezas.getPiezas().size(), is(7));
        Assert.assertTrue(piezas.getPiezas().contains(pieza1));
        Assert.assertTrue(piezas.getPiezas().contains(pieza2));
        Assert.assertTrue(piezas.getPiezas().contains(pieza3));
        Assert.assertTrue(piezas.getPiezas().contains(pieza4));
        Assert.assertTrue(piezas.getPiezas().contains(pieza5));
        Assert.assertTrue(piezas.getPiezas().contains(castillo));

        piezas.eliminar(pieza6);
        Assert.assertFalse(piezas.getPiezas().contains(pieza6));


    }

    @Test
    public void test45EliminarDebeLanzarExcepcionSiLaPiezaNoExiste(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
       /* Aldeano pieza1 = new Aldeano();
        Arquero pieza2 = new Arquero();
        Espadachin pieza3 = new Espadachin();
        ArmaDeAsedio pieza4 = new ArmaDeAsedio();
        PlazaCentral pieza5 = new PlazaCentral();*/
        Cuartel pieza6 = new Cuartel();

        thrown.expect(PiezaAgenaException.class);
         piezas.eliminar(pieza6);
    }
    @Test
    public void test46EliminarDebeLanzarExcepcionSiIntentoEliminarElCastillo(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);

        thrown.expect(NoSePuedeEliminarElCastilloException.class);
        piezas.eliminar(castillo);
    }

}
