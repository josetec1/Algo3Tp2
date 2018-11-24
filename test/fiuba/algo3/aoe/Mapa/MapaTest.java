package fiuba.algo3.aoe.Mapa;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;

public class MapaTest {


    @Test
    public void test01AlCrearElTableroPuedoColocarDeberiaDarTrueSiLaPosicionPerteneceAlTablero() {

         Mapa mapa = new Mapa( 10,10);
         Posicion posicionDentroDeTablero = new Posicion(1,1);

        Assert.assertThat( mapa.puedoColocar(posicionDentroDeTablero,1), is( true ) );
   }

   @Test
   public void testprueba(){
       ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio ();
       Mapa mapa = new Mapa ( 200,200 );
       Posicion posicion = new Posicion ( 2,2 );
       mapa.colocar ( armaDeAsedio,posicion );
       Assert.assertFalse (mapa.puedoColocar ( posicion,1 ));
   }

    @Test
    public void test02AlCrearElTableroPuedoColocarDeberiaDarFalseSiLaPosicionNoPerteneceAlTablero() {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Assert.assertFalse( mapa.puedoColocar(posicionFueraDeTablero,1) );
    }

    @Test
    public void test03PuedoColocarDebeDarTrueSiLaPosicionNoEstaOcupada() {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(1,1);
        Assert.assertThat( mapa.puedoColocar(posicion,1), is( true ) );
    }

    @Test
    public void test04PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorUnidad()  {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicion);

        Assert.assertThat( mapa.puedoColocar(posicion,elemento.getTamanio()), is( false ) );
    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarUnidadAnterior()  {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        Assert.assertEquals( mapa.puedoColocar(posicion,elemento.getTamanio()), true );
        mapa.colocar(elemento,posicion);
        Assert.assertEquals(mapa.puedoColocar(posicion,elemento.getTamanio()), false);
        mapa.remover(elemento);
        Assert.assertEquals( mapa.puedoColocar(posicion,elemento.getTamanio()),  true  );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AgregarDebeLanzarExcepcionSiIntentoColocarUnidadFueraDelTablero() {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        thrown.expect(FueraDelMapaException.class);
        mapa.colocar(elemento,posicionFueraDeTablero);
      }

   @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarUnidadEnUnaPosicionOcupada(){

        Mapa mapa = new Mapa( 100,11000);

        Posicion unaPosicion = new Posicion(60,66);

        Posicion posicionSuperpuesta = new Posicion(60,66);

        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        Ubicable elementoSuperpuesto = new Aldeano();
        mapa.colocar(elemento,unaPosicion);

        thrown.expect(PosicionDelMapaOcupadaException.class);
        mapa.colocar(elementoSuperpuesto,posicionSuperpuesta);
    }

    @Test
    public void test08AgregarDebeLanzarExcepcionSiIntentoColocarUnUbicableAgregadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        Posicion otraPosicion = new Posicion(4,4);

        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,unaPosicion);

        thrown.expect(ElElementoYaExisteException.class);
        mapa.colocar(elemento,otraPosicion);
    }
    @Test
    public void test09PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorPosicionVariosCasilleros()  {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Cuadrante(1,2));
        posicion.agregar(new Cuadrante(2,2));
        posicion.agregar(new Cuadrante(2,1));
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicion);

        Assert.assertThat( mapa.puedoColocar(posicion,elemento.getTamanio()), is( false ) );
    }

    @Test
    public void test10RemoverDebeLanzarExcepcionSiElElementoNoFueColocadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento= new Aldeano();


        thrown.expect(NoExisteElementoException.class);
        mapa.remover(elemento);

    }

    @Test
    public void test11RemoverRemueveElElementoColocadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);
        Jugador jugador = new Jugador("Mauricio");
        Posicion unaPosicion = new Posicion(3,3);
        Ubicable elemento= new Aldeano();

        mapa.colocar(elemento,unaPosicion);

        mapa.remover(elemento);
        Assert.assertThat( mapa.puedoColocar(unaPosicion,elemento.getTamanio()), is( true ) );

    }


/*
    @Test
   public void test12MoverDebeLanzarExcepcionSiElDestinoEstaFueraDelTablero(){
        Mapa tablero = new Mapa( 10,10);
        Posicion posicion = new Posicion(10,10);


        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicion);
        Direccionable derecha = new DireccionDerecha();



       thrown.expect(FueraDeTableroException.class);
       tablero.moverElemento(elemento,derecha);
   }
*/

    @Test
    public void test12MoverDebeLanzarExcepcionSiElDestinoEstaFueraDelTablero(){
        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(10,10);
        Jugador jugador = new Jugador("Mauricio");


        Posicion posicionDestino =new Posicion (11,10);

        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicion);

        thrown.expect(FueraDelMapaException.class);
        mapa.moverElemento(elemento,posicionDestino);
    }

    @Test
    public void test13AlMoverLaPosicionOriginalQuedaLibreYElDestinoOcupado(){
        Mapa mapa = new Mapa( 10,10);
        Posicion posicionInicial = new Posicion(9,10);

        Posicion posicionDestino = new Posicion(10,10);
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicionInicial);


        mapa.moverElemento(elemento,posicionDestino);

        Assert.assertThat( mapa.puedoColocar(posicionInicial,elemento.getTamanio()), is( true ) );
        Assert.assertThat( mapa.puedoColocar(posicionDestino,elemento.getTamanio()), is( false ) );

    }

    @Test
    public void test14MoverDebeLanzarExcepcionSiElElementoNoFueAgregadoPreviamente(){
        Mapa mapa = new Mapa( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento= new Aldeano();



        thrown.expect(NoExisteElementoException.class);
        mapa.moverElemento(elemento, unaPosicion);

    }

   @Test
   public void test15MoverDebeLanzarExcepcionSiElDestinoEstaOcupado(){
        Mapa mapa = new Mapa( 10,10);


        Posicion posicionInicial = new Posicion(9,10);
        Posicion posicionDestino = new Posicion(10,10);
        Jugador jugador = new Jugador("Mauricio");
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicionInicial);

        Ubicable elemento2 = new Aldeano();
        mapa.colocar(elemento2,posicionDestino);

        thrown.expect(PosicionDelMapaOcupadaException.class);
        mapa.moverElemento(elemento,posicionDestino);
   }



   @Test
    public void test17MapaColocarPlazaColocaEnPosicionCorrecta(){
       PlazaCentral plaza = new PlazaCentral();
       Mapa mapa = new Mapa(200,200);
       Posicion posicion = new Posicion(1,1);
       mapa.colocar(plaza,posicion);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new Posicion(1,2)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new Posicion(2,2)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new Posicion(2,1)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new Posicion(1,1)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new Posicion(3,2)),false);
    }


    @Test
    public void test18MapaPuedoColocarPlazaEnPosicion12DevuelveFalse(){
        PlazaCentral plaza = new PlazaCentral();
        Mapa mapa = new Mapa(200,200);
        Posicion posicion = new Posicion(1,1);
        mapa.puedoColocar(posicion,plaza.getTamanio());
        Assert.assertEquals( mapa.puedoColocar(posicion,plaza.getTamanio()),true);
        mapa.colocar(plaza,posicion);
        Assert.assertEquals( mapa.puedoColocar(posicion,plaza.getTamanio()),false);
        Assert.assertEquals( mapa.puedoColocar(new Posicion(1,2),plaza.getTamanio()),false);
        Assert.assertEquals( mapa.puedoColocar(new Posicion(1,3),plaza.getTamanio()),true);


    }

}



