package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.*;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.*;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Test;


public class MovimientoTest {
    private Castillo castillo = new Castillo();
    @Test
    public void test01MoverAldeanoArribaMueveCorrectamente(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
        Jugador jugador = new Jugador("Mauricio",castillo );
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
