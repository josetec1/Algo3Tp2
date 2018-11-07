package fiuba.algo3.aoe;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;

public class TableroTest {
//TODO: que no se pueda crear con numeros negativos y definir el tamanio minimo, que debe ser para que entren el castillo y la ciudad

    //TODO: falta mover y los metodos cuando uses la dimension

@Test
    public void test01Vacio() {


        Assert.assertThat( true, is( true ) );

    }

/*
    @Test
    public void test01AlCrearElTableroLosCasillerosSeEncuentranVacios() {

        Dimension tamanioTablero= new Dimension(3,5);
        Tablero tablero = new Tablero( tamanioTablero);

        Casillero unaPosicion = new Casillero(1,2);
        Casillero otraPosicion = new Casillero(2,2);
        Dimension tamanioObjeto = new Dimension(1,1);


        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( true ) );
        Assert.assertThat( tablero.puedoColocar(otraPosicion,tamanioObjeto), is( true ) );
    }

    @Test
    public void test02PuedoColocarDebeDarTrueSiElCasilleroNoEstaOcupado() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Casillero unaPosicion = new Casillero(1,2);
        Casillero otraPosicion = new Casillero(2,2);
        Dimension tamanioObjeto = new Dimension(1,1);


        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( true ) );
        Assert.assertThat( tablero.puedoColocar(otraPosicion,tamanioObjeto), is( true ) );
    }

    @Test
    public void test03PuedoColocarDebeDarFalseSiElCasilleroEstaOcupado() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Ubicable unElemento = new UbicableFicticio();
        Casillero unaPosicion = new Casillero(1,2);
        Dimension tamanioObjeto = new Dimension(1,1);
        tablero.agregar(unElemento,unaPosicion,tamanioObjeto);


        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( false ) );
    }

    @Test
    public void test04PuedoColocarDebeDarFalseSiElCasilleroNoPerteneceAlTablero() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero unaPosicion = new Casillero(4,3);
        Casillero otraPosicion = new Casillero(3,4);

        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( false ) );
        Assert.assertThat( tablero.puedoColocar(otraPosicion,tamanioObjeto), is( false ) );

    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarElElementoAnterior() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Ubicable unElemento = new UbicableFicticio();
        Casillero unaPosicion = new Casillero(1,2);
        Dimension tamanioObjeto = new Dimension(1,1);
        tablero.agregar(unElemento,unaPosicion,tamanioObjeto);
        tablero.retirar(unaPosicion,tamanioObjeto);


        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( true ) );
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test06AgregarDebeLanzarExcepcionSiIntentoColocarFueraDelTablero() {

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero posicionFueraDeTablero = new Casillero(3,4);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);

        thrown.expect(FueraDeTableroException.class);
        tablero.agregar(unObjeto,posicionFueraDeTablero, tamanioObjeto);

        }

    @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarEnUnCasilleroOcupado() {

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero unaPosicion = new Casillero(3,3);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);

        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto); //agrego primera vez

        thrown.expect(CasilleroOcupadoException.class);
        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);
    }



    @Test
    public void test08RetirarQuitaDelTableroElElementoAgregadoPreviamente() {

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero unaPosicion = new Casillero(3,3);
        Ubicable unObjeto = new UbicableFicticio();


        Tablero tablero = new Tablero( tamanioTablero);

        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);
        tablero.retirar(unaPosicion,tamanioObjeto);

        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( true ) );


    }

    @Test
    public void test09RetirarDebeLanzarExcepcionSiElCasilleroEstaVacio(){

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Casillero unaPosicion = new Casillero(3,3);

        Tablero tablero = new Tablero( tamanioTablero);



        thrown.expect(CasilleroVacioException.class);
        tablero.retirar(unaPosicion,tamanioObjeto);
    }
    @Test
    public void test10RetirarDebeLanzarExcepcionSiElCasilleroEstaFueraDelTablero(){

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


    //@Test
    //public void test16MoverDebeLanzarExcepcionSiSeIntentaMoverElementosDeDimensionMayorAUno(){
    // }
    */
}



