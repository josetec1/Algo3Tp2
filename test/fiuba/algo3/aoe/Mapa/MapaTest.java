package fiuba.algo3.aoe.Mapa;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.EstadoReparando;
import fiuba.algo3.aoe.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;

public class MapaTest {
//TODO: que no se pueda crear con numeros negativos y definir el tamanio minimo, que debe ser para que entren el castillo y la ciudad



    @Test
    public void test01AlCrearElTableroPuedoColocarDeberiaDarTrueSiLaPosicionPerteneceAlTablero() {

         Mapa mapa = new Mapa( 10,10);
         Posicion posicionDentroDeTablero = new Posicion(1,1);

        Assert.assertThat( mapa.puedoColocar(posicionDentroDeTablero), is( true ) );
   }

    @Test
    public void test02AlCrearElTableroPuedoColocarDeberiaDarFalseSiLaPosicionNoPerteneceAlTablero() {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Assert.assertFalse( mapa.puedoColocar(posicionFueraDeTablero) );
    }

    @Test
    public void test03PuedoColocarDebeDarTrueSiLaPosicionNoEstaOcupada() {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(1,1);
        Assert.assertThat( mapa.puedoColocar(posicion), is( true ) );
    }

    @Test
    public void test04PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorUnidad()  {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicion);

        Assert.assertThat( mapa.puedoColocar(posicion), is( false ) );
    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarUnidadAnterior()  {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento = new Aldeano();
        Assert.assertEquals( mapa.puedoColocar(posicion), true );
        mapa.colocar(elemento,posicion);
        Assert.assertEquals(mapa.puedoColocar(posicion), false);
        mapa.remover(elemento);
        Assert.assertEquals( mapa.puedoColocar(posicion),  true  );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AgregarDebeLanzarExcepcionSiIntentoColocarUnidadFueraDelTablero() {

        Mapa mapa = new Mapa( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento = new Aldeano();
        //elemento.colocarEn(posicionFueraDeTablero);
        thrown.expect(FueraDelMapaException.class);
        mapa.colocar(elemento,posicionFueraDeTablero);
      }

   @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarUnidadEnUnaPosicionOcupada(){

        Mapa mapa = new Mapa( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        unaPosicion.agregar(new Cuadrante(6,6));

        Posicion posicionSuperpuesta = new Posicion(6,6);

       Jugador jugador = new Jugador("Mauricio", mapa);
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

        Jugador jugador = new Jugador("Mauricio", mapa);
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
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicion);

        Assert.assertThat( mapa.puedoColocar(posicion), is( false ) );
    }

    @Test
    public void test10RemoverDebeLanzarExcepcionSiElElementoNoFueColocadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento= new Aldeano();


        thrown.expect(NoExisteElementoException.class);
        mapa.remover(elemento);

    }

    @Test
    public void test11RemoverRemueveElElementoColocadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Posicion unaPosicion = new Posicion(3,3);
        Ubicable elemento= new Aldeano();

        mapa.colocar(elemento,unaPosicion);

        mapa.remover(elemento);
        Assert.assertThat( mapa.puedoColocar(unaPosicion), is( true ) );

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
        Jugador jugador = new Jugador("Mauricio", mapa);


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
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicionInicial);


        mapa.moverElemento(elemento,posicionDestino);

        Assert.assertThat( mapa.puedoColocar(posicionInicial), is( true ) );
        Assert.assertThat( mapa.puedoColocar(posicionDestino), is( false ) );

    }

    @Test
    public void test14MoverDebeLanzarExcepcionSiElElementoNoFueAgregadoPreviamente(){
        Mapa mapa = new Mapa( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento= new Aldeano();



        thrown.expect(NoExisteElementoException.class);
        mapa.moverElemento(elemento, unaPosicion);

    }

   @Test
   public void test15MoverDebeLanzarExcepcionSiElDestinoEstaOcupado(){
        Mapa mapa = new Mapa( 10,10);


        Posicion posicionInicial = new Posicion(9,10);
        Posicion posicionDestino = new Posicion(10,10);
       Jugador jugador = new Jugador("Mauricio", mapa);
        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento,posicionInicial);

        Ubicable elemento2 = new Aldeano();
        mapa.colocar(elemento2,posicionDestino);

        thrown.expect(PosicionDelMapaOcupadaException.class);
        mapa.moverElemento(elemento,posicionDestino);
   }

   @Test
   public void test16EstaEnTableroDevuelveTrueSiUbicableEstaEnElTablero(){

       Mapa mapa = new Mapa(10,10);
       Posicion posicion = new Posicion(1,1);
       Jugador jugador = new Jugador("Mauricio", mapa);
       Ubicable aldeano = new Aldeano();
       aldeano.colocarEn(posicion);
       Assert.assertThat(mapa.estaDentroDeTablero(posicion),is(true));

   }

}



