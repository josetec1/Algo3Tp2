package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Ubicables.Direccion.DireccionDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNula;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionNulaException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UnidadTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void test02UnidadObtenerPosicionDeAvanceDebeLanzarExepcionSiNoTieneUnaPosicion(){

        UnidadMovil arquero = new Arquero();
        Direccionable direccion = new DireccionDerecha();

        thrown.expect(PosicionNulaException.class); // es la NullObjet implementada!
        arquero.obtenerPosicionDeAvance(direccion);

    }
}
