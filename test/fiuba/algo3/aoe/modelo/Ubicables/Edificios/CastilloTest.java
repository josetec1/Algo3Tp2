package fiuba.algo3.aoe.modelo.Ubicables.Edificios;

import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EstadoEdificable.EdificioSinDaniarException;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class CastilloTest {

    //los test de ataque del castillo quedaron en la entregaga2 de "ataqueTest"
    // aunque esto no cumple con los principios de mantener los test cerca de la clase que se esta probando
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01RepararDebeLanzarExcepcionCuandoElCastilloNoEstaDanieado(){
        Castillo castillo = new Castillo();

        thrown.expect(EdificioSinDaniarException.class);
        castillo.reparar(new Aldeano());
    }

    @Test
    public void test02PuedoCrearUnidadDebeDarFalseSiElCastilloEstaDaniado(){
        Mapa mapa = Mockito.mock(Mapa.class);
        Jugador jugador = Mockito.mock(Jugador.class);

        Castillo castillo = new Castillo();
        Mockito.when(jugador.esMio(castillo)).thenReturn(true);

        castillo.disminuirVida(50,jugador,mapa);
        Assert.assertFalse(castillo.puedocrearUnidad());
    }
}
