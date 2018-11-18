package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArqueroTest {
    @Test
    public void test01SeCreaCorrectamenteArquero(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Arquero arquero1 = new Arquero();

        Assert.assertEquals(arquero1.getVidaMaxima(), 75);
        Assert.assertEquals(arquero1.getVidaActual(), 75);
        Assert.assertEquals(arquero1.getCosto(),75);
    }


    @Test
    public void test04Disminuir50VidaArmaDeAsedioDevuelve25DeVida(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        Arquero arquero = new Arquero();
        arquero.disminuirVida(50);
        Assert.assertEquals(arquero.getVidaActual(), 25);
    }


}
