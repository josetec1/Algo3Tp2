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
    public void test01AlCrearElTableroLosCasillerosSeEncuentranVacios() {

        Dimension tamanioTablero= new Dimension(3,5);
        Tablero tablero = new Tablero( tamanioTablero);

        Coordenada unaPosicion = new Coordenada(1,2);
        Coordenada otraPosicion = new Coordenada(2,2);
        Dimension tamanioObjeto = new Dimension(1,1);


        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( true ) );
        Assert.assertThat( tablero.puedoColocar(otraPosicion,tamanioObjeto), is( true ) );
    }

    @Test
    public void test02PuedoColocarDebeDarTrueSiElCasilleroNoEstaOcupado() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Coordenada unaPosicion = new Coordenada(1,2);
        Coordenada otraPosicion = new Coordenada(2,2);
        Dimension tamanioObjeto = new Dimension(1,1);


        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( true ) );
        Assert.assertThat( tablero.puedoColocar(otraPosicion,tamanioObjeto), is( true ) );
    }

    @Test
    public void test03PuedoColocarDebeDarFalseSiElCasilleroEstaOcupado() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Ubicable unElemento = new UbicableFicticio();
        Coordenada unaPosicion = new Coordenada(1,2);
        Dimension tamanioObjeto = new Dimension(1,1);
        tablero.agregar(unElemento,unaPosicion,tamanioObjeto);


        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( false ) );
    }

    @Test
    public void test04PuedoColocarDebeDarFalseSiElCasilleroNoPerteneceAlTablero() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Dimension tamanioObjeto = new Dimension(1,1);

        Coordenada unaPosicion = new Coordenada(4,3);
        Coordenada otraPosicion = new Coordenada(3,4);

        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( false ) );
        Assert.assertThat( tablero.puedoColocar(otraPosicion,tamanioObjeto), is( false ) );

    }

    @Test
    public void test05PuedoColocarDebeDarTrueLuegoDeQuitarElElementoAnterior() {

        Dimension tamanioTablero= new Dimension(3,3);
        Tablero tablero = new Tablero( tamanioTablero);

        Ubicable unElemento = new UbicableFicticio();
        Coordenada unaPosicion = new Coordenada(1,2);
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

        Coordenada posicionFueraDeTablero = new Coordenada(3,4);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);

        thrown.expect(FueraDeTableroException.class);
        tablero.agregar(unObjeto,posicionFueraDeTablero, tamanioObjeto);

        }

    @Test
    public void test07AgregarDebeLanzarExcepcionSiIntentoColocarEnUnCasilleroOcupado() {

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Coordenada unaPosicion = new Coordenada(3,3);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);

        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto); //agrego primera vez

        thrown.expect(CasilleroOcupadoException.class);
        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);
    }



    @Test
    public void test08RetirarDevuelveElElementoAgregadoPreviamente() {

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Coordenada unaPosicion = new Coordenada(3,3);
        Ubicable unObjeto = new UbicableFicticio();
        Ubicable otroObjeto = new UbicableFicticio();
        Ubicable objetoRecuperado;
        Tablero tablero = new Tablero( tamanioTablero);

        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);
        objetoRecuperado = tablero.retirar(unaPosicion,tamanioObjeto);

        Assert.assertSame(unObjeto, objetoRecuperado  );
        Assert.assertNotSame(otroObjeto, objetoRecuperado );

    }

    @Test
    public void test09RetirarDebeLanzarExcepcionSiElCasilleroEstaVacio(){

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Coordenada unaPosicion = new Coordenada(3,3);

        Tablero tablero = new Tablero( tamanioTablero);



        thrown.expect(CasilleroVacioException.class);
        tablero.retirar(unaPosicion,tamanioObjeto);
    }
    @Test
    public void test10RetirarDebeLanzarExcepcionSiElCasilleroEstaFueraDelTablero(){

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Coordenada posicionFueraDeTablero = new Coordenada(3,4);
        Tablero tablero = new Tablero( tamanioTablero);

        thrown.expect(FueraDeTableroException.class);
        tablero.retirar(posicionFueraDeTablero,tamanioObjeto);
    }

    //@Test
    //public void test11MoverDebeLanzarExcepcionSiElOrigenEstaFueraDelTablero(){}
   // public void test12MoverDebeLanzarExcepcionSiElDestinoEstaFueraDelTablero(){}
   // public void test13MoverDebeLanzarExcepcionSiElOrigenEstaVacio(){}
   // public void test14MoverDebeLanzarExcepcionSiElDestinoEstaOcupado(){}

   // public void test15MoverQuitaElElementoDelOrigenYLoDejaEnElDestino(){}

}



