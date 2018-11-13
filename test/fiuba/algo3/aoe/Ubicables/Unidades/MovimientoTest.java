package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.*;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTest {

    @Test
    public void test01MoverAldeanoArribaMueveCorrectamente(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(2,2);
        Posicion calculada= new Posicion(2,3);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArriba();
        aldeano.mover(mapa,direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test02MoverAldeanoALaIzquierdaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(2, 2);
        Posicion calculada = new Posicion(2, 1);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajo();
        aldeano.mover(mapa, direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test03MoverAldeanoALaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(2, 1);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionDerecha();
        aldeano.mover(mapa, direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test04MoverAldeanoAbajoDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 2);
        Posicion calculada = new Posicion(1, 1);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajo();
        aldeano.mover(mapa, direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test05MoverAldeanoArribaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(2, 2);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArribaDerecha();
        aldeano.mover(mapa, direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test06MoverAldeanoArribaIzquierdaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(2, 1);
        Posicion calculada = new Posicion(1, 2);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArribaIzquierda();
        aldeano.mover(mapa, direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test07MoverAldeanoAbajoIzquierdaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(2, 2);
        Posicion calculada = new Posicion(1, 1);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajoIzquierda();
        aldeano.mover(mapa, direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test08MoverAldeanoAbajoDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 2);
        Posicion calculada = new Posicion(2, 1);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajoDerecha();
        aldeano.mover(mapa, direccion);
        Assert.assertTrue(aldeano.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(aldeano.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test09MoverArqueroArribaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil arquero = new Arquero(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(2, 2);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(arquero,origen);
        Direccionable direccion = new DireccionArribaDerecha();
        arquero.mover(mapa, direccion);
        Assert.assertTrue(arquero.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(arquero.getPosicion().seSuperponeCon(origen));
    }

    @Test
    public void test010MoverEspadachinArribaDerechaDePosicionMueveCorrectamente() {
        Mapa mapa = new Mapa(20, 20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil espadachin = new Espadachin(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(2, 2);
        Assert.assertEquals(mapa.puedoColocar(origen),true);
        mapa.colocar(espadachin,origen);
        Direccionable direccion = new DireccionArribaDerecha();
        espadachin.mover(mapa, direccion);
        Assert.assertTrue(espadachin.getPosicion().seSuperponeCon(calculada));
        Assert.assertFalse(espadachin.getPosicion().seSuperponeCon(origen));
    }

}

