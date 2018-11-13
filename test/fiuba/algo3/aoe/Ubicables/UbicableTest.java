package fiuba.algo3.aoe.Ubicables;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class UbicableTest {

    @Test
    public void test01AlColocarUnUbicableEnelTableroCambiaLaPosicionDelUbicableYEnElTablero(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable lanzaPiedras = new ArmaDeAsedio(jugador);
        Posicion origen = new Posicion(2,5);
        mapa.colocar(lanzaPiedras,origen);
        Assert.assertThat(mapa.puedoColocar(origen), is(false) );
        Assert.assertThat(lanzaPiedras.getPosicion(), is(origen) );


    }


    @Test
    public void test02MoverCambiaLaPosicionEnElTableroYElUbicableQuedaConLaNuevaPosicion(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        UnidadMovil lanzaPiedras = new ArmaDeAsedio(jugador);
        Direccionable direccion = new DireccionDerecha();

        Posicion origen = new Posicion(2,5);
        Posicion calculada = origen.calcularPosicionSiguiente(direccion);
        mapa.colocar(lanzaPiedras,origen);

        // le digo que se mueva y le paso la direccion
        lanzaPiedras.mover(mapa, direccion);
        Assert.assertThat(lanzaPiedras.getPosicion().seSuperponeCon(calculada), is(true) );
        Assert.assertThat(lanzaPiedras.getPosicion().seSuperponeCon(origen), is(false) ); // tiene la nueva posicion
        Assert.assertThat(mapa.puedoColocar(calculada), is(false) ); // la posicion en el tablero esta ocupada
        Assert.assertThat(mapa.puedoColocar(origen), is(true) ); // el origen esta libre


    }
}
