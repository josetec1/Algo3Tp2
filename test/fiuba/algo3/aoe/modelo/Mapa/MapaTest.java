package fiuba.algo3.aoe.modelo.Mapa;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Cuadrante.Cuadrante;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import fiuba.algo3.aoe.modelo.Ubicables.Ubicable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class MapaTest {
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
    public void test01AlCrearElTableroPuedoColocarDeberiaDarTrueSiLaPosicionPerteneceAlTablero() {

         Mapa mapa = new Mapa( 10,10);
         PosicionReal posicionRealDentroDeTablero = new PosicionReal(1,1);

        Assert.assertThat( mapa.puedoColocar(posicionRealDentroDeTablero,1), is( true ) );
   }



    @Test
    public void test02AlCrearElTableroPuedoColocarDeberiaDarFalseSiLaPosicionNoPerteneceAlTablero() {

        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionRealFueraDeTablero = new PosicionReal(11,1);
        Assert.assertFalse( mapa.puedoColocar(posicionRealFueraDeTablero,1) );
    }

    @Test
    public void test03PuedoColocarDebeDarTrueSiLaPosicionNoEstaOcupada() {

        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionReal = new PosicionReal(1,1);
        Assert.assertThat( mapa.puedoColocar(posicionReal,1), is( true ) );
    }

    @Test
    public void test04PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorUnidad()  {

        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionReal = new PosicionReal(1,1);

        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento, posicionReal);

        Assert.assertThat( mapa.puedoColocar(posicionReal,elemento.getTamanio()), is( false ) );
    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarUnidadAnterior()  {

        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionReal = new PosicionReal(1,1);

        Ubicable elemento = new Aldeano();
        Assert.assertEquals( mapa.puedoColocar(posicionReal,elemento.getTamanio()), true );
        mapa.colocar(elemento, posicionReal);
        Assert.assertEquals(mapa.puedoColocar(posicionReal,elemento.getTamanio()), false);
        mapa.remover(elemento);
        Assert.assertEquals( mapa.puedoColocar(posicionReal,elemento.getTamanio()),  true  );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AgregarDebeLanzarExcepcionSiIntentoColocarUnidadFueraDelTablero() {

        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionRealFueraDeTablero = new PosicionReal(11,1);

        Ubicable elemento = new Aldeano();
        thrown.expect(FueraDelMapaException.class);
        mapa.colocar(elemento, posicionRealFueraDeTablero);
      }

   @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarUnidadEnUnaPosicionOcupada(){

        Mapa mapa = new Mapa( 100,11000);

        PosicionReal unaPosicionReal = new PosicionReal(60,66);

        PosicionReal posicionRealSuperpuesta = new PosicionReal(60,66);


        Ubicable elemento = new Aldeano();
        Ubicable elementoSuperpuesto = new Aldeano();
        mapa.colocar(elemento, unaPosicionReal);

        thrown.expect(PosicionDelMapaOcupadaException.class);
        mapa.colocar(elementoSuperpuesto, posicionRealSuperpuesta);
    }

    @Test
    public void test08AgregarDebeLanzarExcepcionSiIntentoColocarUnUbicableAgregadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);

        PosicionReal unaPosicionReal = new PosicionReal(3,3);
        PosicionReal otraPosicionReal = new PosicionReal(4,4);


        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento, unaPosicionReal);

        thrown.expect(ElElementoYaExisteException.class);
        mapa.colocar(elemento, otraPosicionReal);
    }
    @Test
    public void test09PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorPosicionVariosCasilleros()  {

        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionReal = new PosicionReal(1,1);
        posicionReal.agregar(new Cuadrante(1,2));
        posicionReal.agregar(new Cuadrante(2,2));
        posicionReal.agregar(new Cuadrante(2,1));

        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento, posicionReal);

        Assert.assertThat( mapa.puedoColocar(posicionReal,elemento.getTamanio()), is( false ) );
    }

    @Test
    public void test10RemoverDebeLanzarExcepcionSiElElementoNoFueColocadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);

        Ubicable elemento= new Aldeano();


        thrown.expect(NoExisteElementoException.class);
        mapa.remover(elemento);

    }

    @Test
    public void test11RemoverRemueveElElementoColocadoPreviamente(){

        Mapa mapa = new Mapa( 10,10);

        PosicionReal unaPosicionReal = new PosicionReal(3,3);
        Ubicable elemento= new Aldeano();

        mapa.colocar(elemento, unaPosicionReal);

        mapa.remover(elemento);
        Assert.assertThat( mapa.puedoColocar(unaPosicionReal,elemento.getTamanio()), is( true ) );

    }

    @Test
    public void test12MoverDebeLanzarExcepcionSiElDestinoEstaFueraDelTablero(){
        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionReal = new PosicionReal(10,10);



        PosicionReal posicionRealFueraDeMapa =new PosicionReal(11,10);

        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento, posicionReal);

        thrown.expect(NoSePuedeMoverElElementoException.class);
        mapa.moverElemento(elemento, posicionRealFueraDeMapa);
    }

    @Test
    public void test13AlMoverLaPosicionOriginalQuedaLibreYElDestinoOcupado(){
        Mapa mapa = new Mapa( 10,10);
        PosicionReal posicionRealInicial = new PosicionReal(9,10);

        PosicionReal posicionRealDestino = new PosicionReal(10,10);

        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento, posicionRealInicial);


        mapa.moverElemento(elemento, posicionRealDestino);

        Assert.assertThat( mapa.puedoColocar(posicionRealInicial,elemento.getTamanio()), is( true ) );
        Assert.assertThat( mapa.puedoColocar(posicionRealDestino,elemento.getTamanio()), is( false ) );

    }

    @Test
    public void test14MoverDebeLanzarExcepcionSiElElementoNoFueAgregadoPreviamente(){
        Mapa mapa = new Mapa( 10,10);

        PosicionReal unaPosicionReal = new PosicionReal(3,3);

        Ubicable elemento= new Aldeano();



        thrown.expect(NoExisteElementoException.class);
        mapa.moverElemento(elemento, unaPosicionReal);

    }

   @Test
   public void test15MoverDebeLanzarExcepcionSiElDestinoEstaOcupado(){
        Mapa mapa = new Mapa( 10,10);


        PosicionReal posicionRealInicial = new PosicionReal(9,10);
        PosicionReal posicionRealDestino = new PosicionReal(10,10);

        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento, posicionRealInicial);

        Ubicable elemento2 = new Aldeano();
        mapa.colocar(elemento2, posicionRealDestino);

        thrown.expect(NoSePuedeMoverElElementoException.class);
        mapa.moverElemento(elemento, posicionRealDestino);
   }

    @Test
    public void test16MoverNoRetiraElElementoSiNoPuedeMoverlo(){

        Mapa mapa = new Mapa( 20,20);
        PosicionReal posicionRealInicial = new PosicionReal(5,5);
        PosicionReal posicionRealDestino = new PosicionReal(10,10);
        PosicionReal posicionRealLibre = new PosicionReal(7,7);

        Ubicable elemento = new Aldeano();
        mapa.colocar(elemento, posicionRealInicial);

        Ubicable elemento2 = new Aldeano();
        mapa.colocar(elemento2, posicionRealDestino);

        try {
            mapa.moverElemento(elemento, posicionRealDestino);
        }catch (Exception e){
            //nada

        }

        Assert.assertFalse(mapa.puedoColocar(posicionRealInicial,1));
        thrown.expect(ElElementoYaExisteException.class);
        mapa.colocar(elemento, posicionRealLibre);
    }



   @Test
    public void test17MapaColocarPlazaColocaEnPosicionCorrecta(){
       PlazaCentral plaza = new PlazaCentral();
       Mapa mapa = new Mapa(200,200);
       PosicionReal posicionReal = new PosicionReal(1,1);
       mapa.colocar(plaza, posicionReal);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new PosicionReal(1,2)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new PosicionReal(2,2)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new PosicionReal(2,1)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new PosicionReal(1,1)),true);
       Assert.assertEquals(plaza.getPosicion().seSuperponeCon(new PosicionReal(3,2)),false);
    }


    @Test
    public void test18MapaPuedoColocarPlazaEnPosicion12DevuelveFalse(){
        PlazaCentral plaza = new PlazaCentral();
        Mapa mapa = new Mapa(200,200);
        PosicionReal posicionReal = new PosicionReal(1,1);
        mapa.puedoColocar(posicionReal,plaza.getTamanio());
        Assert.assertEquals( mapa.puedoColocar(posicionReal,plaza.getTamanio()),true);
        mapa.colocar(plaza, posicionReal);
        Assert.assertEquals( mapa.puedoColocar(posicionReal,plaza.getTamanio()),false);
        Assert.assertEquals( mapa.puedoColocar(new PosicionReal(1,2),plaza.getTamanio()),false);
        Assert.assertEquals( mapa.puedoColocar(new PosicionReal(1,3),plaza.getTamanio()),true);


    }

}



