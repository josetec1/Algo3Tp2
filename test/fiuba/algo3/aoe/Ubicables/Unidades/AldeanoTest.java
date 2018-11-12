package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import javafx.scene.control.Tab;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class AldeanoTest {

    @Test
    public void test01SeCreaCorrectamenteAldeano(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Aldeano aldeano = new Aldeano(jugador);

        Assert.assertEquals(aldeano.getVidaMaxima(), 50);
        Assert.assertEquals(aldeano.getVidaActual(), 50);
        Assert.assertEquals(aldeano.getCosto(),25);
    }

/*
    @Test
    public void test02AlColocarUnaPiezaEnelTableroCambiaLaPosicionDeLaPiezaYEnElTablero(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Ubicable aldeano1 = new Aldeano(jugador);
        Posicion origen = new Posicion(2,5);
        tablero.colocar(aldeano1,origen);
        Assert.assertThat(tablero.puedoColocar(origen), is(false) );
        Assert.assertThat(aldeano1.getPosicion(), is(origen) );


    }

    @Test
    public void test03MoverCambiaLaPosicionEnElTableroYLaUnidadQuedaConLaNuevaPosicion(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        UnidadMovil aldeano1 = new Aldeano(jugador);
        Direccionable direccion = new DireccionDerecha();

        Posicion origen = new Posicion(2,5);
        Posicion calculada = origen.calcularPosicionSiguiente(direccion);
        tablero.colocar(aldeano1,origen);

        // le digo que se mueva y le paso la direccion
        aldeano1.mover(tablero, direccion);
        Assert.assertThat(aldeano1.getPosicion().seSuperponeCon(calculada), is(true) );
        Assert.assertThat(aldeano1.getPosicion().seSuperponeCon(origen), is(false) ); // tiene la nueva posicion
        Assert.assertThat(tablero.puedoColocar(calculada), is(false) ); // la posicion en el tablero esta ocupada
        Assert.assertThat(tablero.puedoColocar(origen), is(true) ); // el origen esta libre


    }
*/
    @Test
    public void test04AldenoDisminuir25VidaDevuelveVida25(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Aldeano aldeano = new Aldeano(jugador);
        aldeano.disminuirVida(25);
        Assert.assertEquals(aldeano.getVidaActual(),25);
    }

    @Test
    public void test06AldeanoPerteneceAJugadorJuanDevuelveFalse(){
        Tablero tablero = new Tablero(10,10);
        Jugador jugador = new Jugador("Mauricio",tablero);
        Jugador jugador2 = new Jugador("Juan",tablero);
        Aldeano aldeano = new Aldeano(jugador);
        Assert.assertThat (aldeano.perteneceAJugador(jugador2),is(false));

    }

}
