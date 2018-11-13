package fiuba.algo3.aoe.Ubicables.Unidades;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Direccion.*;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTest {

    @Test
    public void test01MoverAldeanoArribaMueveCorrectamente(){
        Tablero tablero = new Tablero(20,20);
        Jugador jugador = new Jugador("Mauricio",tablero);
        UnidadMovil aldeano = new Aldeano(jugador);
        Posicion origen = new Posicion(2,0);
        Posicion calculada= new Posicion(2,1);
        Assert.assertEquals(tablero.puedoColocar(origen),true);
        tablero.colocar(aldeano,origen);
        Direccionable direccion = new DireccionArriba();
        aldeano.mover(tablero,direccion);

        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(calculada),true);
        Assert.assertEquals(aldeano.getPosicion().seSuperponeCon(origen),false);
    }

    }
