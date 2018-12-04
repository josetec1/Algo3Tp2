package Entrega4;

import fiuba.algo3.aoe.Juego.Juego;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class IntegracionJuegoTest {

    @Test
    public void test01ElJuegoSeIniciaCorrectamente (){

        Juego juego = new Juego("Diego", "Maradona",100,100);

        Assert.assertFalse(juego.finalizo());
    }

    @Test
    public void test02AlMatarAlCastilloElJuegoTerminaYElGanadorEsElJugadorActivoQueLoMato (){

        Juego juego = new Juego("Diego", "Maradona",100,100);

        Mapa mapa = juego.getMapa();
        Cuartel superCuartel = new SuperCuartelFicticio();
        Jugador jugadorActual = juego.getJugadorActual();

        jugadorActual.getAldeanos().get(0).construirEdificio(superCuartel,mapa,jugadorActual, new PosicionReal(5,5));

        //paso 3 turnos para que el cuartel este construido
        juego.pasarJugada();
        juego.pasarJugada(); //1
        juego.pasarJugada();
        juego.pasarJugada(); //2
        juego.pasarJugada();
        juego.pasarJugada(); //3

        jugadorActual.getCuarteles().get(0).crearArquero(jugadorActual,mapa,new PosicionReal(9,9));

        // ahora con mi super arquero liquido al castillo
        Jugador jEnemigo = juego.getJugadorInactivo();
        Castillo castilloEnemigo = jEnemigo.getCastillo();

        jugadorActual.getArqueros().get(0).atacar(castilloEnemigo,jugadorActual,jEnemigo,mapa);

        Assert.assertTrue(juego.finalizo());
        Assert.assertThat(juego.getWinner(),is(jugadorActual));
    }

    @Test
    public void test03ElJuegoCominzaCon3Aldeanos1PlazaCentral1CastilloCadaJugador(){

        Juego juego = new Juego("Maradona","Messi",500,500);

        Jugador jugador1= juego.getJugadorActual();
        Jugador jugador2= juego.getJugadorInactivo();

        Assert.assertThat(jugador1.getAtacables().size(),is(5));
        Assert.assertThat(jugador2.getAtacables().size(),is(5));

        Assert.assertThat(jugador1.getPlazas().size(),is(1));
        Assert.assertThat(jugador2.getPlazas().size(),is(1));

        Assert.assertThat(jugador1.getAldeanos().size(),is(3));
        Assert.assertThat(jugador2.getAldeanos().size(),is(3));
    }

    @Test
    public void test04AlpasarDeTurnoCambiaElJugador(){

        Juego juego = new Juego("Maradona","Messi",500,500);
        Jugador jugadorActual= juego.getJugadorActual();
        Jugador jugadorInactivo= juego.getJugadorInactivo();

        juego.pasarJugada();

        Jugador nuevoJugadorActual = juego.getJugadorActual();

        Assert.assertThat(jugadorInactivo,is(nuevoJugadorActual));
    }

    @Test
    public void test05AlpasarDosVecesDeJugadorElJugadorEsElMismo(){

        Juego juego = new Juego("Maradona","Messi",500,500);
        Jugador jugadorActual= juego.getJugadorActual();
        Jugador jugadorInactivo= juego.getJugadorInactivo();

        juego.pasarJugada();
        juego.pasarJugada();

        Jugador nuevoJugadorActual = juego.getJugadorActual();

        Assert.assertThat(jugadorActual,is(nuevoJugadorActual));
    }

}
