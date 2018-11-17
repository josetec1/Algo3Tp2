package fiuba.algo3.aoe.Ubicables.Unidades;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.ArmaDeAsedio;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArmaDeAsedioTest {

    @Test
    public void test01SeCreaCorrectamenteArmaDeAsedio(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        Assert.assertEquals(armaDeAsedio.getVidaMaxima(), 150);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 150);
        Assert.assertEquals(armaDeAsedio.getCosto(),200);
    }

    @Test
    public void test02Disminuir50VidaArmaDeAsedioDevuelve100DeVida(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 100);
    }

    @Test
    public void test03Disminuir50VidaArmaDeAsedioCrearNuevaArmaDeAsedioDevuelve150DeVida(){
        Mapa mapa = new Mapa(10,10);
        Jugador jugador = new Jugador("Mauricio", mapa);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.disminuirVida(50);
        Assert.assertEquals(armaDeAsedio.getVidaActual(), 100);
        ArmaDeAsedio armaDeAsedioSecundaria = new ArmaDeAsedio();
        Assert.assertEquals(armaDeAsedioSecundaria.getVidaActual(), 150);

    }


}
