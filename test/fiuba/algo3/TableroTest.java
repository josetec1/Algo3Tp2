package fiuba.algo3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

public class TableroTest {
//TODO: que no se pueda crear con numeros negativos y definir el tamaniominimo, que debe ser para que entre el castillo y la ciudad

/*
    @Test
    public void test00AlCrearElTableroLosCasillerosSeEncuentranVacios() {

        Dimension tamanioTablero= new Dimension(3,3);

        Coordenada unaPosicion = new Coordenada(1,2);
        Coordenada otraPosicion = new Coordenada(2,2);
        Dimension tamanioObjeto = new Dimension(1,1);

        Tablero tablero = new Tablero( tamanioTablero);
        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( true ) );
        Assert.assertThat( tablero.puedoColocar(otraPosicion,tamanioObjeto), is( true ) );
    }
*/
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test01AgregarDebeLanzarExcepcionSiIntentoColocarFueraDelTablero() {

        Dimension tamanioTablero= new Dimension(3,3);
        Dimension tamanioObjeto = new Dimension(1,1);

        Coordenada posicionFueraDeTablero = new Coordenada(3,4);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);

        thrown.expect(FueraDeTableroException.class);
        tablero.agregar(unObjeto,posicionFueraDeTablero, tamanioObjeto);

        }

/*
    @Test
    public void test03AlAgregarUnObjetoEnUnCasilleroVacioNoSePuedeVolverAAgregar() {

        Dimension tamanioTablero= new Dimension(3,3);
        Coordenada unaPosicion = new Coordenada(1,2);
        Dimension tamanioObjeto = new Dimension(1,1);
        Ubicable unObjeto = new UbicableFicticio();

        Tablero tablero = new Tablero( tamanioTablero);
        tablero.puedoColocar(unaPosicion,tamanioObjeto);
        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);
        Assert.assertThat( tablero.puedoColocar(unaPosicion,tamanioObjeto), is( false ) );

    }
    @Test
    public void test04AgregarNoColocaElObjetoSiElCasilleroEstaOcupado() {
        Dimension tamanioTablero= new Dimension(3,3);
        Coordenada unaPosicion = new Coordenada(3,4);
        Dimension tamanioObjeto = new Dimension(1,1);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);


        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);

    }
    @Test
    public void test05PuedoColocarDevuelveTrueSiElCasilleroEstaDisponible() {
        Dimension tamanioTablero= new Dimension(3,3);
        Coordenada unaPosicion = new Coordenada(3,4);
        Dimension tamanioObjeto = new Dimension(1,1);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);


        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);

    }
    @Test
    public void test06PuedoColocarDevuelveFalseSiElCasilleroEstaOcupado() {
        Dimension tamanioTablero= new Dimension(3,3);
        Coordenada unaPosicion = new Coordenada(3,4);
        Dimension tamanioObjeto = new Dimension(1,1);
        Ubicable unObjeto = new UbicableFicticio();
        Tablero tablero = new Tablero( tamanioTablero);


        tablero.agregar(unObjeto,unaPosicion, tamanioObjeto);

    }


*/
}



