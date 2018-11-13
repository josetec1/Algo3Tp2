package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class EspadachinTest {
    @Test
    public void test01SeCreaCorrectamenteEspadachin(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Espadachin espadachin1 = new Espadachin(jugador);

        Assert.assertEquals(espadachin1.getVidaMaxima(), 100);
        Assert.assertEquals(espadachin1.getVidaActual(), 100);
        Assert.assertEquals(espadachin1.getCosto(),50);
    }

/*
    @Test
    public void test200AlColocarUnaPiezaEnelTableroCambiaLaPosicionDeLaPiezaYEnElTablero(){
        Mapa tablero = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Ubicable espadachin1 = new Espadachin(jugador);
        Posicion origen = new Posicion(2,5);
        tablero.colocar(espadachin1,origen);
        Assert.assertThat(tablero.puedoColocar(origen), is(false) );
        Assert.assertThat(espadachin1.getPosicion(), is(origen) );

    }


    @Test
    public void test201MoverCambiaLaPosicionEnElTableroYLaUnidadQuedaConLaNuevaPosicion(){
        Mapa tablero = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        UnidadMovil espadachin1 = new Espadachin(jugador);
        Direccionable direccion = new DireccionDerecha();

        Posicion origen = new Posicion(2,5);
        Posicion calculada = origen.calcularPosicionSiguiente(direccion);
        tablero.colocar(espadachin1,origen);

        // le digo que se mueva y le paso la direccion
        espadachin1.mover(tablero, direccion);
        Assert.assertThat(espadachin1.getPosicion().seSuperponeCon(calculada), is(true) );
        Assert.assertThat(espadachin1.getPosicion().seSuperponeCon(origen), is(false) ); // tiene la nueva posicion
        Assert.assertThat(tablero.puedoColocar(calculada), is(false) ); // la posicion en el tablero esta ocupada
        Assert.assertThat(tablero.puedoColocar(origen), is(true) ); // el origen esta libre


    }
*/
    @Test
    public void test02Disminuir50VidaEspadachinDevuelve50DeVida(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Espadachin espadachin = new Espadachin(jugador);
        espadachin.disminuirVida(50);
        Assert.assertEquals(espadachin.getVidaActual(), 50);
    }

}
