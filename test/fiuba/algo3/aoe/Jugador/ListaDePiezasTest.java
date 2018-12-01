package fiuba.algo3.aoe.Jugador;

import fiuba.algo3.aoe.Jugadores.ListaDePiezas;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import org.junit.Assert;
import org.junit.Test;
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

        Assert.assertTrue(piezas.getCastillo()==castillo);
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

        Assert.assertTrue(piezas.puedoAgregar());
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

        Assert.assertTrue(piezas.puedoAgregar());

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
        Assert.assertFalse(piezas.puedoAgregar());
    }

    @Test
    public void test06PuedoAgregarDebeDarTrueLuegoDeAgregar50UnidadesYEliminarUna(){

        Castillo castillo = Mockito.mock(Castillo.class);
        ListaDePiezas piezas = new ListaDePiezas(castillo);
        ArmaDeAsedio armaDeAsedio;
        Arquero arquero50 = new Arquero();


        for (int i = 0; i <49 ; i++) {
            armaDeAsedio = new ArmaDeAsedio();
            piezas.agregar(armaDeAsedio);
        }

        piezas.agregar(arquero50);
        Assert.assertFalse(piezas.puedoAgregar());

        piezas.eliminar (arquero50);
        Assert.assertTrue(piezas.puedoAgregar());


    }
/*
    @Test
    public void test07GetCantidadDeUnidadesNoCuentaLosEdificiosQueSeAgreguen(){

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

        Assert.assertTrue(false);
    }

    @Test
    public void test08GetCantidadDeUnidadesDebeDar3LuegoDeAgregar3Unidades(){

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

        Assert.assertTrue(false);
    }

    @Test
    public void test09GetCantidadDeUnidadesDebeDar20LuegoDeAgregar21UnidadesYEliminar1(){

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

        Assert.assertTrue(false);
    }
    */
}
