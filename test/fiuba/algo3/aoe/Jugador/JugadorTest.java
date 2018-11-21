package fiuba.algo3.aoe.Jugador;
import fiuba.algo3.aoe.Jugadores.*;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.NoSePuedeConstruirEnEsteMomentoException;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.mockito.Mockito.mock;
//Todo esto vuela.
public class JugadorTest {

    @Test
    public void test01CrearJugadorCreaJugadorConNombreMauricioOro0Test(){
        Mapa mapa = new Mapa(10,20);

        Jugador jugador1 = new Jugador("Mauricio", mapa);
        Assert.assertEquals(jugador1.getNombre(), "Mauricio");
       // Assert.assertEquals(jugador1.getOro(), 100);
    }

/*
    @Test
    public void test02JugadorSumarOro200Suma200DeOro(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        jugador.sumarOro(200);
        jugador.descontarOro(100);
        Assert.assertEquals(jugador.getOro(),200);
    }

    @Test
    public void test03JugadorSumarOro200DescontarOro100Devuelve200DeOro(){
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        jugador.sumarOro(200);

        jugador.descontarOro(100);
        Assert.assertEquals(jugador.getOro(),200);
    }


    @Test
    public void test04JugadorCon200OroAgregarEspadachinDevuelveOro150(){
        Posicion posicion = new Posicion(1,1);
        Mapa mapa = new Mapa(20,20);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable espadachin0 = new Espadachin();
        jugador.sumarOro(200);
        jugador.agregarPieza();(espadachin0,posicion);
        Assert.assertEquals(jugador.getOro(),150);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test06DescontarOro500CuandoOroActualEs300LanzaRecursoInsuficienteExeption(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        jugador1.sumarOro(300);
        thrown.expect(RecursoInsuficienteException.class);
        jugador1.descontarOro(500);
    }

    @Test
    public void test07HayOroSuficienteDevuelveTrueSiSeQuiereGastar500YSeTieneOro600(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        jugador1.sumarOro(600);
        Assert.assertTrue(jugador1.hayOroSuficiente(500));
    }

    @Test
    public void test08HayOroSuficienteDevuelveFalseSiSeQuiereGastar500YSeTieneOro300(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        jugador1.sumarOro(300);
        Assert.assertFalse(jugador1.hayOroSuficiente(500));
    }

    @Test
    public void test09HayOroSuficienteDevuelveFalseSiSeNecesitaOro500YHayOro300(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador1 = new Jugador("Mauricio", mapa);
        jugador1.sumarOro(300);
        Assert.assertFalse(jugador1.hayOroSuficiente(500));
    }

    @Test
    public void test010JugadorReclutarEspadachinConOro25DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.sumarOro(50);
        jugador.descontarOro(100);
        jugador.construirCuartel(espia.getAldeanos().get(0),new Posicion(new Cuadrante(2,2)));
        Cuartel cuartel = espia.getCuartels().get(0);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(50,50));
    }

    @Test
    public void test011JugadorReclutarArqueroConOro25DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.descontarOro(100);
        jugador.sumarOro(75);
        List<Aldeano> aldeanos = espia.getAldeanos();
        jugador.construirCuartel(aldeanos.get(0),new Posicion(new Cuadrante(9,9)));
        Cuartel cuartel = espia.getCuartels().get(0);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArquero(cuartel,new Posicion(20,20));
    }


    @Test
    public void test012JugadorReclutarAldeanoConOro15DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.descontarOro(100);
        PlazaCentral plaza = espia.getPlazaCentrals().get(0);
        plaza.construir();
        plaza.construir();
        plaza.construir();
        jugador.sumarOro(15);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarAldeano(plaza,new Posicion(2,2));
    }

    @Test
    public void test013JugadorReclutarArmaDeAsedioConOro25DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        Castillo castillo = espia.getCastillos().get(0);
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(90,90));

    }


    @Test
    public void test014JugadorReclutarArmaDeAsedioConOro25DevuelveRecursoInsuficienteException(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        Castillo castillo= espia.getCastillos().get(0);
        jugador.sumarOro(25);
        thrown.expect(RecursoInsuficienteException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(1,1));

    }

    @Test
    public void test015JugadorReclutarArqueroEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",new Mapa(90,90));
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        Aldeano aldeano = espia.getAldeanos().get(0);
        jugador.sumarOro(50);
        jugador.construirCuartel(aldeano,new Posicion(new Cuadrante(50,50)));
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArquero(espia.getCuartels().get(0),new Posicion(new Cuadrante(60,60)));
    }

    @Test
    public void test016JugadorReclutarArqueroEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.sumarOro(50);
        jugador.construirCuartel(espia.getAldeanos().get(0),new Posicion(new Cuadrante(9,9)));
        Cuartel cuartel = espia.getCuartels().get(0);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArquero(cuartel,new Posicion(78,78));
    }

    @Test
    public void test017JugadorReclutarEspadachinEdificioEnConstruccionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.sumarOro(50);
        jugador.construirCuartel(espia.getAldeanos().get(0),new Posicion(new Cuadrante(19,18)));
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarEspadachin(espia.getCuartels().get(0),new Posicion(50,50));
    }


    @Test
    public void test018JugadorReclutarAldeanoEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Jugador jugador = new Jugador("Mauricio",mock(Mapa.class));
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        PlazaCentral plaza = espia.getPlazaCentrals().get(0);
        plaza.construir();
        plaza.construir();
        plaza.construir();
        plaza.disminuirVida(150);
        plaza.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarAldeano(plaza,mock(Posicion.class));
    }

    @Test
    public void test019JugadorReclutarArqueroEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(90,90);
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
        cuartel.disminuirVida(15);
        cuartel.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArquero(cuartel,new Posicion(13,13));
    }

    @Test
    public void test020JugadorReclutarEspadachinEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(100,1000);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        jugador.sumarOro(50);
        jugador.construirCuartel(espia.getAldeanos().get(0),new Posicion(new Cuadrante(2,2)));
        Cuartel cuartel = espia.getCuartels().get(0);
        cuartel.disminuirVida(150);
        cuartel.construir();
        cuartel.construir();
        cuartel.construir();
        cuartel.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarEspadachin(cuartel,new Posicion(45,45));
    }

    @Test
    public void test020JugadorReclutarArmaDeAsedioEdificioEnReparacionDevuelveEdificioEnConstruccionException(){
        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        Castillo castillo= espia.getCastillos().get(0);
        castillo.disminuirVida(150);
        castillo.reparar();
        jugador.sumarOro(50);
        thrown.expect(NoSePuedeConstruirEnEsteMomentoException.class);
        jugador.reclutarArmaDeAsedio(castillo,new Posicion(40,50));
    }

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


    @Test
    public void testt25JugadorConLimiteDePoblacionAlcanzadoElininarAldeanoDevuelveLimiteDePoblacionFalse(){
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


    @Test
    public void test28ConstruirPlazaConstruyeYUbicaLaPlazaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        jugador.sumarOro(999);

        Posicion posicion = new Posicion(12,12);
        posicion.agregar(new Cuadrante(12,13));
        posicion.agregar(new Cuadrante(13,12));
        posicion.agregar(new Cuadrante(13,13));
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        Aldeano aldeano = espia.getAldeanos().get(0);
        jugador.construirPlaza(aldeano,posicion);
        Assert.assertEquals(mapa.puedoColocar(posicion,espia.getPlazaCentrals().get(1).getTamanio()),false);
    }

    @Test
    public void test29ConstruirPlazaSinOroLanzaRecursoInsuficienteException(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.descontarOro(100);
        jugador.inicializar();
        Aldeano aldeano = espia.getAldeanos().get(0);
        Posicion posicion = new Posicion(12,12);
        posicion.agregar(new Cuadrante(12,13));
        posicion.agregar(new Cuadrante(13,12));
        posicion.agregar(new Cuadrante(13,13));
        thrown.expect(RecursoInsuficienteException.class);
        jugador.construirPlaza(aldeano,posicion);
    }

    @Test
    public void test30ConstruirPlazaConstruyeYUbicaLaPlazaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        jugador.sumarOro(999);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        Aldeano aldeano= espia.getAldeanos().get(0);
        Posicion posicion = new Posicion(12,12);
        posicion.agregar(new Cuadrante(12,13));
        posicion.agregar(new Cuadrante(13,12));
        posicion.agregar(new Cuadrante(13,13));
        jugador.construirPlaza(aldeano,posicion);
        Assert.assertEquals(mapa.puedoColocar(posicion,espia.getPlazaCentrals().get(1).getTamanio()),false);
    }

    @Test
    public void test31ConstruirCuartelSinOroLanzaRecursoInsuficienteException(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador("Mauricio",mapa);
        Posicion posicion = new Posicion(12,12);
        posicion.agregar(new Cuadrante(12,13));
        posicion.agregar(new Cuadrante(13,12));
        posicion.agregar(new Cuadrante(13,13));
        jugador.descontarOro(100);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);
        jugador.inicializar();
        thrown.expect(RecursoInsuficienteException.class);
        jugador.construirCuartel(espia.getAldeanos().get(0),new Posicion(new Cuadrante(2,2)));
    }

    @Test
    public void test32ChequeQueAlInicializarSeEncuentrenLosObjetosDentroDelJugador(){

        Mapa mapa = new Mapa(90,90);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();

        List<Aldeano> aldeanos = espia.getAldeanos();

        Aldeano aldeano = aldeanos.get(0);
        Aldeano aldeano2 = aldeanos.get(1);
        Aldeano aldeano3 = aldeanos.get(2);

        jugador.mover(aldeano, new DireccionDerecha());
        jugador.mover(aldeano2, new DireccionDerecha());
        jugador.mover(aldeano3, new DireccionDerecha());
    }

    @Test
    public void test33ConstruirCuartelConAldeanoQueNoEsDelJugadorDevuelveUnidadAgenaException(){

        Mapa mapa = new Mapa(90,90);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();
        jugador.sumarOro(999);

        Aldeano aldeano4 = new Aldeano();
        thrown.expect(UnidadAgenaException.class);
        jugador.construirCuartel(aldeano4,new Posicion(new Cuadrante(1,1)));
    }

    @Test
    public void test34ConstruirPlazaConAldeanoQueNoEsDelJugadorDevuelveUnidadAgenaException(){

        Mapa mapa = new Mapa(90,90);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();
        jugador.sumarOro(999);

        Aldeano aldeano4 = new Aldeano();
        thrown.expect(UnidadAgenaException.class);
        jugador.construirPlaza(aldeano4,new Posicion(new Cuadrante(1,1)));
    }

    @Test
    public void test35ReclutarAldeanoConPlazaNoPropiaLanzaEdificioAgenoException() {

        Mapa mapa = new Mapa(90, 90);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();
        jugador.sumarOro(999);
        thrown.expect(EdificioAgenoException.class);
        jugador.reclutarAldeano(new PlazaCentral(), new Posicion(new Cuadrante(1, 1)));

    }

    @Test
    public void test36ReclutarEspadachinConCuartelNoPropi0LanzaEdificioAgenoException() {

        Mapa mapa = new Mapa(90, 90);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();
        jugador.sumarOro(999);
        thrown.expect(EdificioAgenoException.class);
        jugador.reclutarEspadachin(new Cuartel(), new Posicion(new Cuadrante(1, 1)));

    }

    @Test
    public void test37ReclutarArqueroConCuartelNoPropi0LanzaEdificioAgenoException() {

        Mapa mapa = new Mapa(90, 90);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();
        jugador.sumarOro(999);
        thrown.expect(EdificioAgenoException.class);
        jugador.reclutarArquero(new Cuartel(), new Posicion(new Cuadrante(1, 1)));

    }

    @Test
    public void test37ReclutarArmaAsedioConCastilloNoPropi0LanzaEdificioAgenoException() {

        Mapa mapa = new Mapa(90, 90);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();
        jugador.sumarOro(999);
        thrown.expect(EdificioAgenoException.class);
        jugador.reclutarArmaDeAsedio(new Castillo(), new Posicion(new Cuadrante(1, 1)));

    }

    @Test
    public void test39JugadorMoverUnidadNoPropiaLanzaUnidadAgenaException(){

        Mapa mapa = new Mapa(200,200);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar();

        List<Aldeano> aldeanos = espia.getAldeanos();

        Aldeano aldeano = aldeanos.get(0);
        Aldeano aldeano2 = aldeanos.get(1);
        Aldeano aldeano3 = new Aldeano();

        jugador.mover(aldeano, new DireccionDerecha());
        jugador.mover(aldeano2, new DireccionDerecha());
        thrown.expect(UnidadAgenaException.class);
        jugador.mover(aldeano3, new DireccionDerecha());
    }

    @Test
    public void test40JugadorRecibeAtaqueDeCastilloEnemigoDebeAtacarAlaPlazaUnicamente(){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar(new Posicion(1,1));

        Castillo castilloEnemigo = new Castillo();
        mapa.colocar(castilloEnemigo,new Posicion(11,11));

        jugador.recibirAtaqueCastillo(castilloEnemigo);

        PlazaCentral plazaCentral = espia.getPlazaCentrals().get(0); //en pos (9,9) a (10,10)
        Aldeano aldeano = espia.getAldeanos().get(2); // pos (7,7)

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima()-20);

        Assert.assertEquals(aldeano.getVidaActual(),aldeano.getVidaMaxima());
    }

    @Test
    public void test41JugadorRecibeAtaqueDeCastilloEnemigoDebeAtacarAPlazaCentralYAldeanosUnicamente(){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar(new Posicion(1,1));

        Castillo castilloEnemigo = new Castillo();
        mapa.colocar(castilloEnemigo,new Posicion(5,8));//pos (5,8)a (8,11)

        jugador.recibirAtaqueCastillo(castilloEnemigo);

        PlazaCentral plazaCentral = espia.getPlazaCentrals().get(0); //en pos (9,9) a (10,10)
        Aldeano aldeano = espia.getAldeanos().get(2); // pos (7,7)
        Aldeano aldeano2 = espia.getAldeanos().get(1); // pos (6,6)
        Aldeano aldeano3 = espia.getAldeanos().get(0); // pos (5,5)
        Castillo castillo = espia.getCastillos().get(0); // pos (1,1) a (4,4)

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima()-20);
        Assert.assertEquals(aldeano.getVidaActual(),aldeano.getVidaMaxima()-20);
        Assert.assertEquals(aldeano2.getVidaActual(),aldeano2.getVidaMaxima()-20);
        Assert.assertEquals(aldeano3.getVidaActual(),aldeano3.getVidaMaxima()-20);

        Assert.assertEquals(castillo.getVidaActual(),castillo.getVidaMaxima());

    }

    @Test
    public void test42JugadorIntentaRecibirAtaqueDeSuPropioCastillo(){

        Mapa mapa = new Mapa(100,100);
        Jugador jugador = new Jugador("D10S", mapa);
        ObservadorDeJugadorFicticio espia = new ObservadorDeJugadorFicticio();
        jugador.agregarObservador(espia);

        jugador.inicializar(new Posicion(1,1));

        PlazaCentral plazaCentral = espia.getPlazaCentrals().get(0); //en pos (9,9) a (10,10)
        Aldeano aldeano = espia.getAldeanos().get(2); // pos (7,7)
        Aldeano aldeano2 = espia.getAldeanos().get(1); // pos (6,6)
        Aldeano aldeano3 = espia.getAldeanos().get(0); // pos (5,5)
        Castillo castillo = espia.getCastillos().get(0); // pos (1,1) a (4,4)

        jugador.recibirAtaqueCastillo(castillo);

        Assert.assertEquals(plazaCentral.getVidaActual(), plazaCentral.getVidaMaxima());
        Assert.assertEquals(aldeano.getVidaActual(),aldeano.getVidaMaxima());
        Assert.assertEquals(aldeano2.getVidaActual(),aldeano2.getVidaMaxima());
        Assert.assertEquals(aldeano3.getVidaActual(),aldeano3.getVidaMaxima());
        Assert.assertEquals(castillo.getVidaActual(),castillo.getVidaMaxima());

    }

*/

}
