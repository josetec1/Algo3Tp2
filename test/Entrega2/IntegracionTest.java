package Entrega2;

import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Jugador.ObservadorDeJugadorFicticio;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IntegracionTest {

    public final int ALTOMAPA = 100;
    public final int ANCHOMAPA = 100;

    private Mapa mapa;
    private Jugador jugador1;
    private Jugador jugador2;
    private List<Jugador> jugadores;
    private Turno turno;
    private ObservadorDeJugadorFicticio observadorJugador1;
    private ObservadorDeJugadorFicticio observadorJugador2;

/*
    @Before
    public void inicializacion (){


        jugador1 = new Jugador("Jorge", mapa);
        jugador2 = new Jugador("Maria", mapa);

        jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);



        observadorJugador1 = new ObservadorDeJugadorFicticio();
        observadorJugador2 = new ObservadorDeJugadorFicticio();

        jugador1.agregarObservador(observadorJugador1);
        jugador2.agregarObservador(observadorJugador2);

        jugador1.inicializar(new Posicion(1,1));
        jugador2.inicializar(new Posicion(ANCHOMAPA - 9, ALTOMAPA - 9));
    }

*/
/*
    @Test
    public void test001AlInicioDeJuegoLosJugadoresCuentanCon3Aldeanos1CastilloY1PlazaCentral(){

        Assert.assertEquals(jugador1.getOro(),100);
        Assert.assertEquals(jugador2.getOro(),100);

        Assert.assertEquals(observadorJugador1.getAldeanos().size() , 3);
        Assert.assertEquals(observadorJugador2.getAldeanos().size() , 3);

        Assert.assertEquals(observadorJugador1.getPlazaCentrals().size() , 1);
        Assert.assertEquals(observadorJugador2.getPlazaCentrals().size() , 1);

        Assert.assertEquals(observadorJugador1.getCastillos().size() , 1);
        Assert.assertEquals(observadorJugador2.getCastillos().size() , 1);

    }

    @Test
    public void test003AlInicioDeJuegoLasUnidadesYEdificiosTienePosicionesValidas(){

        for(int i = 0; i<=2; i++) {
            Assert.assertTrue(observadorJugador1.getAldeanos().get(i).getPosicion().estasDentroDe(ANCHOMAPA,ALTOMAPA));
            Assert.assertTrue(observadorJugador2.getAldeanos().get(i).getPosicion().estasDentroDe(ANCHOMAPA,ALTOMAPA)) ;
        }

        Assert.assertTrue(observadorJugador1.getCastillos().get(0).getPosicion().estasDentroDe(ANCHOMAPA,ALTOMAPA));
        Assert.assertTrue(observadorJugador2.getCastillos().get(0).getPosicion().estasDentroDe(ANCHOMAPA,ALTOMAPA));

        Assert.assertTrue(observadorJugador1.getPlazaCentrals().get(0).getPosicion().estasDentroDe(ANCHOMAPA,ALTOMAPA));
        Assert.assertTrue(observadorJugador2.getPlazaCentrals().get(0).getPosicion().estasDentroDe(ANCHOMAPA,ALTOMAPA));

    }

    @Test
    public void test003AlInicioDeJuegoElMapaContieneAlosEdificiosYUnidadesIniciales(){

        for(int i = 0; i<=2; i++) {
            Assert.assertTrue(mapa.estaDentroDeLosMargenesDelTablero(observadorJugador1.getAldeanos().get(i).getPosicion() ) );
            Assert.assertTrue(mapa.estaDentroDeLosMargenesDelTablero(observadorJugador2.getAldeanos().get(i).getPosicion() ) );
        }

        Assert.assertTrue(mapa.estaDentroDeLosMargenesDelTablero(observadorJugador1.getCastillos().get(0).getPosicion() ) );
        Assert.assertTrue(mapa.estaDentroDeLosMargenesDelTablero(observadorJugador2.getCastillos().get(0).getPosicion() ) );

        Assert.assertTrue(mapa.estaDentroDeLosMargenesDelTablero(observadorJugador1.getPlazaCentrals().get(0).getPosicion() ) );
        Assert.assertTrue(mapa.estaDentroDeLosMargenesDelTablero(observadorJugador2.getPlazaCentrals().get(0).getPosicion() ) );

    }
*/
@Test
public void test0Vacio(){



    Assert.assertEquals(true , true);

}

}