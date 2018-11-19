package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class UnidadTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test01UnidadGetPosicionDebeLanzarExepcionSiNoTieneUnaPosicion(){

        UnidadMovil aldeano = new Aldeano();

        thrown.expect(UnidadSinPosicionExceptcion.class);
        aldeano.getPosicion();


    }

    @Test
    public void test02UnidadObtenerPosicionDeAvanceDebeLanzarExepcionSiNoTieneUnaPosicion(){

        UnidadMovil arquero = new Arquero();
        Direccionable direccion = new DireccionDerecha();

        thrown.expect(UnidadSinPosicionExceptcion.class);
        arquero.obtenerPosicionDeAvance(direccion);

    }
}
