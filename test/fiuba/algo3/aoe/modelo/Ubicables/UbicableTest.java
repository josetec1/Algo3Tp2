package fiuba.algo3.aoe.modelo.Ubicables;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.modelo.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;

public class UbicableTest {
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
        jugador = new Jugador("Pelusa",castillo,plaza,aldeanos);

    }


    @Test
    public void test01AlColocarUnUbicableEnelTableroCambiaLaPosicionDelUbicableYEnElTablero(){
        Mapa mapa = new Mapa(10,10);

        Ubicable lanzaPiedras = new ArmaDeAsedio();
        PosicionReal origen = new PosicionReal(2,5);
        mapa.colocar(lanzaPiedras,origen);
        Assert.assertThat(mapa.puedoColocar(origen,lanzaPiedras.getTamanio()), is(false) );
        Assert.assertEquals(lanzaPiedras.getPosicion().seSuperponeCon(origen),true);


    }


    @Test
    public void test02MoverCambiaLaPosicionEnElTableroYElUbicableQuedaConLaNuevaPosicion(){
        Mapa mapa = new Mapa(10,10);

        UnidadMovil lanzaPiedras = new ArmaDeAsedio();
        Direccionable direccion = new DireccionDerecha();

        Posicion origen = new PosicionReal(2,5);
        Posicion calculada = origen.calcularPosicionSiguiente(direccion);
        mapa.colocar(lanzaPiedras,origen);

        // le digo que se mueva y le paso la direccion
        lanzaPiedras.mover(mapa, direccion,jugador);
        Assert.assertThat(lanzaPiedras.getPosicion().seSuperponeCon(calculada), is(true) );
        Assert.assertThat(lanzaPiedras.getPosicion().seSuperponeCon(origen), is(false) ); // tiene la nueva posicion
        Assert.assertThat(mapa.puedoColocar(calculada,lanzaPiedras.getTamanio()), is(false) ); // la posicion en el tablero esta ocupada
        Assert.assertThat(mapa.puedoColocar(origen,lanzaPiedras.getTamanio()), is(true) ); // el origen esta libre


    }


}
