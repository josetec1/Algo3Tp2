package fiuba.algo3.aoe.modelo.Ubicables.Unidades;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;

import fiuba.algo3.aoe.modelo.Ubicables.Direccion.*;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;

import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class MovimientoTest {

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
        jugador = new Jugador("ElDiego",castillo,plaza,aldeanos);
    }





    @Test
    public void test01MoverAldeanoArribaMueveCorrectamente(){
        Mapa mapa = new Mapa(20,20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(2,2);
        PosicionReal calculada= new PosicionReal(2,3);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArriba();

        aldeano.mover(mapa,direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test02MoverAldeanoALaIzquierdaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(2, 2);
        PosicionReal calculada = new PosicionReal(2, 1);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajo();
        aldeano.mover(mapa, direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test03MoverAldeanoALaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(1, 1);
        PosicionReal calculada = new PosicionReal(2, 1);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionDerecha();
        aldeano.mover(mapa, direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test04MoverAldeanoAbajoDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(1, 2);
        PosicionReal calculada = new PosicionReal(1, 1);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajo();
        aldeano.mover(mapa, direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test05MoverAldeanoArribaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(1, 1);
        PosicionReal calculada = new PosicionReal(2, 2);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArribaDerecha();
        aldeano.mover(mapa, direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test06MoverAldeanoArribaIzquierdaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(2, 1);
        PosicionReal calculada = new PosicionReal(1, 2);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArribaIzquierda();
        aldeano.mover(mapa, direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test07MoverAldeanoAbajoIzquierdaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(2, 2);
        PosicionReal calculada = new PosicionReal(1, 1);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajoIzquierda();
        aldeano.mover(mapa, direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test08MoverAldeanoAbajoDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        PosicionReal origen = new PosicionReal(1, 2);
        PosicionReal calculada = new PosicionReal(2, 1);
        Assert.assertEquals(mapa.puedoColocar(origen,aldeano.getTamanio()),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajoDerecha();
        aldeano.mover(mapa, direccion,jugador);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test09MoverArqueroArribaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Arquero arquero = new Arquero();
        jugador.agregarPieza(arquero);
        PosicionReal origen = new PosicionReal(1, 1);
        PosicionReal calculada = new PosicionReal(2, 2);
        Assert.assertEquals(mapa.puedoColocar(origen,arquero.getTamanio()),true);
        mapa.colocar(arquero,origen);
        Direccionable direccion = new DireccionArribaDerecha();
        arquero.mover(mapa, direccion,jugador);
        Assert.assertTrue(arquero.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(arquero.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test010MoverEspadachinArribaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);

        Espadachin espadachin = new Espadachin();
        jugador.agregarPieza(espadachin);
        PosicionReal origen = new PosicionReal(1, 1);
        PosicionReal calculada = new PosicionReal(2, 2);
        Assert.assertEquals(mapa.puedoColocar(origen,espadachin.getTamanio()),true);
        mapa.colocar(espadachin,origen);
        Direccionable direccion = new DireccionArribaDerecha();
        espadachin.mover(mapa, direccion,jugador);
        Assert.assertTrue(espadachin.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(espadachin.getPosicion().seSuperponeCon(origen));
    }

}
