package fiuba.algo3.aoe;

import fiuba.algo3.aoe.Tablero.*;
import fiuba.algo3.aoe.Ubicable.Ubicable;
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
    public void test04PuedoColocarDebeDarFalseSiLaPosicionEstaOcupada() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Ubicable elemento = new UbicableFicticio(posicion);
        tablero.colocar(elemento);

        Assert.assertThat( tablero.puedoColocar(posicion), is( false ) );
    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarElElementoAnterior() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicion = new Posicion(1,1);
        Ubicable elemento = new UbicableFicticio(posicion);
        tablero.colocar(elemento);
        tablero.remover(elemento);

        Assert.assertThat( tablero.puedoColocar(posicion), is( true ) );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AgregarDebeLanzarExcepcionSiIntentoColocarFueraDelTablero() {

        Tablero tablero = new Tablero( 10,10);
        Posicion posicionFueraDeTablero = new Posicion(11,1);
        Ubicable elemento = new UbicableFicticio(posicionFueraDeTablero);

        thrown.expect(FueraDeTableroException.class);
        tablero.colocar(elemento);

      }

    @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarEnUnaPosicionOcupada() {

        Tablero tablero = new Tablero( 10,10);

        Posicion unaPosicion = new Posicion(3,3);
        unaPosicion.agregar(new Casillero(6,6));

        Posicion posicionSuperpuesta = new Posicion(6,6);


        Ubicable elemento = new UbicableFicticio(unaPosicion);
        Ubicable elementoSuperpuesto = new UbicableFicticio(posicionSuperpuesta);
        tablero.colocar(elemento);

        thrown.expect(PosicionOcupadaException.class);
        tablero.colocar(elementoSuperpuesto);
    }





 /*   @Test
    public void test09RemoverDebeLanzarExcepcionSiLaPosicionEstaVacia(){

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero unaPosicion = new Casillero(3,3);

        Tablero tablero = new Tablero( tamanioTablero);



        thrown.expect(CasilleroVacioException.class);
        tablero.retirar(unaPosicion,tamanioObjeto);
    }
    @Test
    public void test10RemoverDebeLanzarExcepcionSiElLaPosicionEstaFueraDelTablero(){

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero posicionFueraDeTablero = new Casillero(3,4);
        Tablero tablero = new Tablero( tamanioTablero);

        thrown.expect(FueraDeTableroException.class);
        tablero.retirar(posicionFueraDeTablero,tamanioObjeto);
    }

    @Test
    public void test11MoverDebeLanzarExcepcionSiElOrigenEstaFueraDelTablero(){
        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);


        Casillero origenFueraDeTablero = new Casillero(5,5);
        Casillero posicionDestino = new Casillero(3,3);


        thrown.expect(FueraDeTableroException.class);
        tablero.mover(origenFueraDeTablero,posicionDestino);


    }
    @Test
   public void test12MoverDebeLanzarExcepcionSiElDestinoEstaFueraDelTablero(){
       Dimension tamanioTablero= new Dimension(3,3);
       Tablero tablero = new Tablero( tamanioTablero);

       Ubicable unElemento = new UbicableFicticio();
       Dimension tamanioObjeto = new Dimension(1,1);
       Casillero origen = new Casillero(1,1);
       Casillero destinoFueraDeTablero = new Casillero(9,9);
       tablero.agregar(unElemento,origen,tamanioObjeto);

       thrown.expect(FueraDeTableroException.class);
       tablero.mover(origen,destinoFueraDeTablero);
   }

    @Test
    public void test13MoverDebeLanzarExcepcionSiElOrigenEstaVacio(){
        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Ubicable unElemento = new UbicableFicticio();
        Dimension tamanioObjeto = new Dimension(1,1);
        Casillero origenVacio = new Casillero(2,1);
        Casillero destino = new Casillero(2,2);


        thrown.expect(CasilleroVacioException.class);
        tablero.mover(origenVacio,destino);
    }

    @Test
   public void test14MoverDebeLanzarExcepcionSiElDestinoEstaOcupado(){

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Ubicable unElemento = new UbicableFicticio();
        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero origen = new Casillero(2,1);

        Casillero otroOrigen = new Casillero(2,2);
        Casillero destinoOcupado = new Casillero(2,2);

        tablero.agregar(unElemento,origen,tamanioObjeto);
        tablero.agregar(unElemento,otroOrigen,tamanioObjeto);


       thrown.expect(CasilleroOcupadoException.class);
        tablero.mover(origen,destinoOcupado);
    }


    @Test
    public void test15MoverQuitaElElementoDelOrigenYLoDejaEnElDestino(){

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Ubicable unElemento = new UbicableFicticio();
        Casillero posicionOrigen = new Casillero(1,2);
        Casillero posicionDestino = new Casillero(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        tablero.agregar(unElemento,posicionOrigen,tamanioObjeto);

        tablero.mover(posicionOrigen,posicionDestino);

        Assert.assertThat( tablero.puedoColocar(posicionOrigen,tamanioObjeto), is( true ) );
        Assert.assertThat( tablero.puedoColocar(posicionDestino,tamanioObjeto), is( false ) );

    }


*/
}



