package Entrega1;

import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IntegracionTest {



    @Test
    public void test01AldeanoAlContruirEdificioYpasar3TurnosQuedaLibre(){
        Mapa mapa = new Mapa(500,500);
        Posicion posicion = new Posicion(10,10);
        Castillo castillo = new Castillo();
        Aldeano aldeano = new Aldeano();
        Edificio plaza = new PlazaCentral();
        Jugador jugador = new Jugador("Estambul",castillo);
        jugador.agregarPieza(aldeano);
        jugador.sumarOro(25);

        aldeano.construirEdificio(plaza,mapa,jugador,posicion);

        jugador.esTuTurno(); //turno 1
        Assert.assertFalse( aldeano.estasDisponible());
        jugador.esTuTurno(); //turno 2
        Assert.assertFalse( aldeano.estasDisponible());
        jugador.esTuTurno(); //turno 3
        Assert.assertTrue( aldeano.estasDisponible());

    }
    @Test
    public void test02AldeanoConstruyendoAlPasar3TurnosNoSumaOro(){

        Mapa mapa = new Mapa(500,500);
        Posicion posicion = new Posicion(10,10);
        Castillo castillo = new Castillo();
        Aldeano aldeano = new Aldeano();
        Edificio plaza = new PlazaCentral();
        Jugador jugador = new Jugador("Estambul",castillo);
        jugador.agregarPieza(aldeano);
        jugador.sumarOro(25);
        aldeano.construirEdificio(plaza,mapa,jugador,posicion);

        Aldeano mockAldeano = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano.getCosto()).thenReturn(1);

        Assert.assertFalse(jugador.puedoAgregar(mockAldeano));
        jugador.esTuTurno(); //turno 1
        jugador.esTuTurno(); //turno 2
        jugador.esTuTurno(); //turno 3

        Assert.assertFalse(jugador.puedoAgregar(mockAldeano));

    }
    @Test
    public void test03AldeanoConstruyendoAlPasar4TurnosSumaOro(){

        Mapa mapa = new Mapa(500,500);
        Posicion posicion = new Posicion(10,10);
        Castillo castillo = new Castillo();
        Aldeano aldeano = new Aldeano();
        Edificio plaza = new PlazaCentral();
        Jugador jugador = new Jugador("Estambul",castillo);
        jugador.agregarPieza(aldeano);
        jugador.sumarOro(25);
        aldeano.construirEdificio(plaza,mapa,jugador,posicion);

        Aldeano mockAldeano = Mockito.mock (Aldeano.class);
        Mockito.when(mockAldeano.getCosto()).thenReturn(1);

        jugador.esTuTurno(); //turno 1
        jugador.esTuTurno(); //turno 2
        jugador.esTuTurno(); //turno 3
        jugador.esTuTurno(); //turno 4

        Mockito.when(mockAldeano.getCosto()).thenReturn(20);
        Assert.assertTrue(jugador.puedoAgregar(mockAldeano)); //20 aporta el aldeano

        Mockito.when(mockAldeano.getCosto()).thenReturn(21);
        Assert.assertFalse(jugador.puedoAgregar(mockAldeano));
    }

}
