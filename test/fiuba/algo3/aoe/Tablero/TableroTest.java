package fiuba.algo3.aoe.Tablero;

import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Casillero.Casillero;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;

public class TableroTest {
//TODO: que no se pueda crear con numeros negativos y definir el tamanio minimo, que debe ser para que entren el castillo y la ciudad



    @Test
    public void test01AlCrearElTableroPuedoColocarDeberiaDarTrueSiLaPosicionPerteneceAlTablero() {

         Tablero tablero = new Tablero( 10,10);
         Posicion posicionDentroDeTablero = new Posicion(1,1);

        Assert.assertThat( tablero.puedoColocar(posicionDentroDeTablero), is( true ) );
   }

    @Test
    public void test02AlCrearElTableroPuedoColocarDeberiaDarFalseSiLaPosicionNoPerteneceAlTablero() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Assert.assertFalse( tablero.puedoColocar(posicionFueraDeTablero) );
    }

    @Test
    public void test03PuedoColocarDebeDarTrueSiLaPosicionNoEstaOcupada() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Assert.assertThat( tablero.puedoColocar(posicion), is( true ) );
    }

    @Test
    public void test04PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorUnidad()  {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicion);

        Assert.assertThat( tablero.puedoColocar(posicion), is( false ) );
    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarUnidadAnterior()  {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Ubicable elemento = new UnidadMovil();
        Assert.assertEquals( tablero.puedoColocar(posicion), true );
        tablero.colocar(elemento,posicion);
        Assert.assertEquals(tablero.puedoColocar(posicion), false);
        tablero.remover(elemento);
        Assert.assertEquals( tablero.puedoColocar(posicion),  true  );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AgregarDebeLanzarExcepcionSiIntentoColocarUnidadFueraDelTablero() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Ubicable elemento = new UnidadMovil();
        elemento.colocarEn(posicionFueraDeTablero);
        thrown.expect(FueraDeTableroException.class);
        tablero.colocar(elemento,posicionFueraDeTablero);
      }

   @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarUnidadEnUnaPosicionOcupada(){

        Tablero tablero = new Tablero( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        unaPosicion.agregar(new Casillero(6,6));

        Posicion posicionSuperpuesta = new Posicion(6,6);


        Ubicable elemento = new UnidadMovil();
        elemento.colocarEn(unaPosicion);
        Ubicable elementoSuperpuesto = new UnidadMovil();
        elementoSuperpuesto.colocarEn(posicionSuperpuesta);
        tablero.colocar(elemento,unaPosicion);

        thrown.expect(Posicion.PosicionOcupadaException.class);
        tablero.colocar(elementoSuperpuesto,posicionSuperpuesta);
    }

    @Test
    public void test08PuedoColocarDebeDarFalseSiLaPosicionEstaOcupadaPorPosicionVariosCasilleros()  {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        posicion.agregar(new Casillero(1,2));
        posicion.agregar(new Casillero(2,2));
        posicion.agregar(new Casillero(2,1));
        Ubicable elemento = new UnidadMovil();
        tablero.colocar(elemento,posicion);

        Assert.assertThat( tablero.puedoColocar(posicion), is( false ) );
    }



/*
    @Test
    public void test09RemoverDebeLanzarExcepcionSiLaPosicionEstaVacia(){

        thrown.expect(CasilleroVacioException.class);
        tablero.retirar(unaPosicion,tamanioObjeto);
    }


  /*
    @Test
    public void test10RemoverDebeLanzarExcepcionSiElLaPosicionEstaFueraDelTablero(){



        thrown.expect(FueraDeTableroException.class);
        tablero.retirar(posicionFueraDeTablero,tamanioObjeto);
    }

    @Test
    public void test11MoverDebeLanzarExcepcionSiElOrigenEstaFueraDelTablero(){

        thrown.expect(FueraDeTableroException.class);
        tablero.mover(origenFueraDeTablero,posicionDestino);


    }
    @Test
   public void test12MoverDebeLanzarExcepcionSiElDestinoEstaFueraDelTablero(){


       thrown.expect(FueraDeTableroException.class);
       tablero.mover(origen,destinoFueraDeTablero);
   }

    @Test
    public void test13MoverDebeLanzarExcepcionSiElOrigenEstaVacio(){


        thrown.expect(CasilleroVacioException.class);
        tablero.mover(origenVacio,destino);
    }

    @Test
   public void test14MoverDebeLanzarExcepcionSiElDestinoEstaOcupado(){

        thrown.expect(CasilleroOcupadoException.class);
        tablero.mover(origen,destinoOcupado);
    }


    @Test
    public void test15MoverQuitaElElementoDelOrigenYLoDejaEnElDestino(){


        Assert.assertThat( tablero.puedoColocar(posicionOrigen,tamanioObjeto), is( true ) );
        Assert.assertThat( tablero.puedoColocar(posicionDestino,tamanioObjeto), is( false ) );

    }


*/
}



