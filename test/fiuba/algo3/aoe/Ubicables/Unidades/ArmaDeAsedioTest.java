package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArmaDeAsedioTest {

    @Test
    public void test01SeCreaCorrectamenteArmaDeAsedio(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugador);

        Assert.assertEquals(armaDeAsedio.getVidaMaxima(), 150);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 150);
        Assert.assertEquals(armaDeAsedio.getCosto(),200);
    }

    @Test
    public void test02Disminuir50VidaArmaDeAsedioDevuelve100DeVida(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugador);
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 100);
    }

    @Test
    public void test03Disminuir50VidaArmaDeAsedioCrearNuevaArmaDeAsedioDevuelve150DeVida(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugador);
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 100);
        ArmaDeAsedio armaDeAsedioSecundaria = new ArmaDeAsedio(jugador);
        Assert.assertEquals(armaDeAsedioSecundaria.getVidaActual(), 150);

    }

/*
    @Test
    public void test200AlColocarUnaPiezaEnelTableroCambiaLaPosicionDeLaPiezaYEnElTablero(){
        Mapa tablero = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Ubicable lanzaPiedras = new ArmaDeAsedio(jugador);
        Posicion origen = new Posicion(2,5);
        tablero.colocar(lanzaPiedras,origen);
        Assert.assertThat(tablero.puedoColocar(origen), is(false) );
        Assert.assertThat(lanzaPiedras.getPosicion(), is(origen) );


    }


    @Test
    public void test201MoverCambiaLaPosicionEnElTableroYLaUnidadQuedaConLaNuevaPosicion(){
        Mapa tablero = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        UnidadMovil lanzaPiedras = new ArmaDeAsedio(jugador);
        Direccionable direccion = new DireccionDerecha();

        Posicion origen = new Posicion(2,5);
        Posicion calculada = origen.calcularPosicionSiguiente(direccion);
        tablero.colocar(lanzaPiedras,origen);

        // le digo que se mueva y le paso la direccion
        lanzaPiedras.mover(tablero, direccion);
        Assert.assertThat(lanzaPiedras.getPosicion().seSuperponeCon(calculada), is(true) );
        Assert.assertThat(lanzaPiedras.getPosicion().seSuperponeCon(origen), is(false) ); // tiene la nueva posicion
        Assert.assertThat(tablero.puedoColocar(calculada), is(false) ); // la posicion en el tablero esta ocupada
        Assert.assertThat(tablero.puedoColocar(origen), is(true) ); // el origen esta libre


    }
*/
}
