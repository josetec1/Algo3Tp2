package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArmaDeAsedioTest {

    @Test
    public void test01SeCreaCorrectamenteArmaDeAsedio(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        Assert.assertEquals(armaDeAsedio.vidaTotal(), 150);
        Assert.assertEquals(armaDeAsedio.costo(),200);
    }

    @Test
    public void test02Disminuir50VidaArmaDeAsedioDevuelve100DeVida(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.vidaTotal(), 100);
    }

    @Test
    public void test03Disminuir50VidaArmaDeAsedioCrearNuevaArmaDeAsedioDevuelve150DeVida(){
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.vidaTotal(), 100);

        ArmaDeAsedio admaDeAsedioSecundaria = new ArmaDeAsedio();
        Assert.assertEquals(armaDeAsedio.vidaTotal(), 100);
        Assert.assertEquals(admaDeAsedioSecundaria.vidaTotal(), 150);

    }


    @Test
    public void test200AlColocarUnaPiezaEnelTableroCambiaLaPosicionDeLaPiezaYEnElTablero(){
        Tablero tablero = new Tablero(10,10);
        Ubicable lanzaPiedas = new ArmaDeAsedio();
        Posicion origen = new Posicion(2,5);
        tablero.colocar(lanzaPiedas,origen);
        Assert.assertThat(tablero.puedoColocar(origen), is(false) );
        Assert.assertThat(lanzaPiedas.getPosicion(), is(origen) );


    }


    @Test
    public void test201MoverCambiaLaPosicionEnElTableroYLaUnidadQuedaConLaNuevaPosicion(){
        Tablero tablero = new Tablero(10,10);
        UnidadMovil lanzaPiedas = new ArmaDeAsedio();
        Direccionable direccion = new DireccionDerecha();

        Posicion origen = new Posicion(2,5);
        Posicion calculada = origen.calcularPosicionSiguiente(direccion);
        tablero.colocar(lanzaPiedas,origen);

        // le digo que se mueva y le paso la direccion
        lanzaPiedas.mover(tablero, direccion);
        Assert.assertThat(lanzaPiedas.getPosicion().seSuperponeCon(calculada), is(true) );
        Assert.assertThat(lanzaPiedas.getPosicion().seSuperponeCon(origen), is(false) ); // tiene la nueva posicion
        Assert.assertThat(tablero.puedoColocar(calculada), is(false) ); // la posicion en el tablero esta ocupada
        Assert.assertThat(tablero.puedoColocar(origen), is(true) ); // el origen esta libre


    }

}
