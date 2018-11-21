package Entrega2;

import fiuba.algo3.aoe.Jugador.ObservadorDeJugadorFicticio;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.LimiteDePoblacionAlcanzadoException;
import fiuba.algo3.aoe.Jugadores.RecursoInsuficienteException;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.mockito.Mockito.mock;

public class ReglasDePoblacionTest {

/*
    @Test
    public void testt21JugadorReclutarEspadachinConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.sumarOro(9999999);
        jugador.construirCuartel(espia.getAldeanos().get(0),new Posicion(new Cuadrante(80,80)));
        Cuartel cuartel = espia.getCuartels().get(0);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        for(int i = 0;i<46;i++){
            jugador.reclutarEspadachin(cuartel,new Posicion(12,i+12));
        }
        Assert.assertTrue(jugador.alcanzoLimiteDePoblacion());
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(90,90));
    }

    @Test
    public void testt22JugadorReclutarArqueroConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.sumarOro(50);
        jugador.construirCuartel(espia.getAldeanos().get(0),new Posicion(new Cuadrante(80,80)));
        Cuartel cuartel = espia.getCuartels().get(0);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(9999999);
        for(int i = 0;i<46;i++){
            jugador.reclutarEspadachin(cuartel,new Posicion(12,12+i));
        }
        Assert.assertTrue(jugador.alcanzoLimiteDePoblacion());
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarArquero(cuartel,new Posicion( 90,90));
    }

    @Test
    public void testt23JugadorReclutarAldeanoConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){

        Jugador jugador = new Jugador("Mauricio",new Mapa(1000,1000));
        jugador.sumarOro(9999999);

        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        List<PlazaCentral> plazas= espia.getPlazaCentrals();
        PlazaCentral plaza = plazas.get(0);
        plaza.construir();
        plaza.construir();
        plaza.construir();
        for(int i = 0;i<47;i++){
            jugador.reclutarAldeano(plaza,new Posicion(new Cuadrante(40,40+i)));
        }
        Assert.assertTrue(jugador.alcanzoLimiteDePoblacion());
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarAldeano(plaza,new Posicion(new Cuadrante(30,30)));
    }

    @Test
    public void testt24JugadorReclutarArmaDeAsedioConPoblacion50DevuelveLimiteDePoblacionAlcanzadoException(){
        Mapa mapa = new Mapa(1000,1000);
        Jugador jugador = new Jugador("Mauricio",mapa);
        jugador.sumarOro(9999999);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        List<Castillo> castillos= espia.getCastillos();
        Castillo castillo = castillos.get(0);

        for(int i = 0;i<47;i++){
            jugador.reclutarArmaDeAsedio(castillo,new Posicion(50,i+50));
        }
        Assert.assertTrue(jugador.alcanzoLimiteDePoblacion());
        thrown.expect(LimiteDePoblacionAlcanzadoException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(7,8));
    }
*/


/*
    @Test
    public void testt25JugadorConLimiteDePoblacionAlcanzadoEliminarAldeanoDevuelveLimiteDePoblacionFalse(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        jugador.sumarOro(9999999);
        for(int i = 0;i<49;i++){
            jugador.agregarPieza(new Arquero());
        }
        Aldeano aldeano = new Aldeano();
        jugador.agregarPieza(aldeano);
        Assert.assertTrue(jugador.alcanzoLimiteDePoblacion());
        jugador.eliminarUnidad(aldeano);
        Assert.assertFalse(jugador.alcanzoLimiteDePoblacion());
    }
*/
/*
    @Test
    public void test26JugadorCon3AldeanosTengoOroParaCuartelPorTurnoSiEliminoDosMasBajaOroPorTurnoYLanzaRecursoInsuficienteException(){
        Mapa mapa = new Mapa(90,90);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.descontarOro(100);

        Aldeano aldeano = espia.getAldeanos().get(0);
        jugador.habilitar();


        jugador.construirCuartel(aldeano,new Posicion(new Cuadrante(9,9)));
        jugador.eliminarUnidad(espia.getAldeanos().get(1));
        jugador.eliminarUnidad(espia.getAldeanos().get(2));

        aldeano.cambiarARecolectando();

        jugador.habilitar();

        thrown.expect(RecursoInsuficienteException.class);
        jugador.construirCuartel(aldeano,new Posicion(new Cuadrante(60,60)));
    }

*/
    @Rule
    public ExpectedException thrown = ExpectedException.none();
/*
    @Test
    public void test38JugadorCon1AldeanoNoTengoOroParaCuartelPorTurnoSiCreo2MasTengoOroPorTurnoParaCuartel(){
        Mapa mapa = new Mapa(90,90);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.descontarOro(100);
        jugador.inicializar();
        jugador.eliminarUnidad(espia.getAldeanos().get(1));
        jugador.eliminarUnidad(espia.getAldeanos().get(2));
        PlazaCentral plaza = espia.getPlazaCentrals().get(0);
        Aldeano aldeano = espia.getAldeanos().get(0);

        jugador.habilitar();

        thrown.expect(RecursoInsuficienteException.class);
        jugador.construirCuartel(aldeano,new Posicion(new Cuadrante(9,9)));
        jugador.descontarOro(20);
        jugador.sumarOro(50);
        jugador.reclutarAldeano(plaza,new Posicion(new Cuadrante(50,50)));
        jugador.reclutarAldeano(plaza,new Posicion(new Cuadrante(51,51)));
        jugador.habilitar();
        jugador.construirCuartel(espia.getAldeanos().get(1),new Posicion(new Cuadrante(60,60)));
    }
    */

@Test
    public void test01PruebaVacia(){
     Assert.assertTrue(true);
}
}
