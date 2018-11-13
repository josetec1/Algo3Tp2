package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.*;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTest {

    @Test
    public void test01MoverAldeanoArribaMueveCorrectamente(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(2,2);
        Posicion calculada= new Posicion(2,3);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArriba();
        aldeano.mover(tablero,direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada),true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen),false);
    }

    @Test
    public void test02MoverAldeanoALaIzquierdaDePosicionMueveCorrectamente() {
        Tablero tablero = new Tablero(20, 20);
        Jugador jugador = new Jugador("Mauricio", tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(1, 0);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajo();
        aldeano.mover(tablero, direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada), true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen), false);
    }

    @Test
    public void test03MoverAldeanoALaDerechaDePosicionMueveCorrectamente() {
        Tablero tablero = new Tablero(20, 20);
        Jugador jugador = new Jugador("Mauricio", tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(2, 1);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionDerecha();
        aldeano.mover(tablero, direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada), true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen), false);
    }

    @Test
    public void test04MoverAldeanoAbajoDePosicionMueveCorrectamente() {
        Tablero tablero = new Tablero(20, 20);
        Jugador jugador = new Jugador("Mauricio", tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(1, 0);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajo();
        aldeano.mover(tablero, direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada), true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen), false);
    }

    @Test
    public void test05MoverAldeanoArribaDerechaDePosicionMueveCorrectamente() {
        Tablero tablero = new Tablero(20, 20);
        Jugador jugador = new Jugador("Mauricio", tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(2, 2);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArribaDerecha();
        aldeano.mover(tablero, direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada), true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen), false);
    }

    @Test
    public void test06MoverAldeanoArribaIzquierdaDePosicionMueveCorrectamente() {
        Tablero tablero = new Tablero(20, 20);
        Jugador jugador = new Jugador("Mauricio", tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(0, 2);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArribaIzquierda();
        aldeano.mover(tablero, direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada), true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen), false);
    }

    @Test
    public void test07MoverAldeanoAbajoIzquierdaDePosicionMueveCorrectamente() {
        Tablero tablero = new Tablero(20, 20);
        Jugador jugador = new Jugador("Mauricio", tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(0, 0);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajoIzquierda();
        aldeano.mover(tablero, direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada), true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen), false);
    }

    @Test
    public void test08MoverAldeanoAbajoDerechaDePosicionMueveCorrectamente() {
        Tablero tablero = new Tablero(20, 20);
        Jugador jugador = new Jugador("Mauricio", tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(1, 1);
        Posicion calculada = new Posicion(2, 0);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionAbajoDerecha();
        aldeano.mover(tablero, direccion);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada), true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen), false);
    }

}

