package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class AldeanoTest {
    @Test
    public void test01SeCreaCorrectamenteAldeano(){
        Aldeano aldeano = new Aldeano();

        Assert.assertEquals(aldeano.vidaTotal(), 150);
        Assert.assertEquals(aldeano.costo(),200);
    }


    @Test
    public void test200AlColocarUnaPiezaEnelTableroCambiaLaPosicionDeLaPiezaYEnElTablero(){
        Tablero tablero = new Tablero(10,10);
        Ubicable aldeano1 = new Aldeano();
        Posicion origen = new Posicion(2,5);
        tablero.colocar(aldeano1,origen);
        Assert.assertThat(tablero.puedoColocar(origen), is(false) );
        Assert.assertThat(aldeano1.getPosicion(), is(origen) );


    }


    @Test
    public void test201MoverCambiaLaPosicionEnElTableroYLaUnidadQuedaConLaNuevaPosicion(){
        Tablero tablero = new Tablero(10,10);
        UnidadMovil aldeano1 = new Aldeano();
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

}
