package fiuba.algo3.Tablero;

import fiuba.algo3.Ubicable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TableroTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test01ColocarDebeLanzarExepcionSiIntentoColocarFueraDelTablero() {
        Dimension tamanio= new Dimension(3,3);
        Coordenada posicion = new Coordenada(3,4);
        Ubicable unObjeto = new Ubicable();

        Tablero tablero = new Tablero( tamanio);
        thrown.expect(CasilleroInexistenteException.class);
        tablero.colocar (unObjeto,posicion );

        }




}



