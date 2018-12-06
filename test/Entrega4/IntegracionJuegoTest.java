package Entrega4;

import fiuba.algo3.aoe.modelo.Juego.Juego;
import fiuba.algo3.aoe.modelo.Jugadores.Jugador;
import fiuba.algo3.aoe.modelo.Mapa.Mapa;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.Posicion;
import fiuba.algo3.aoe.modelo.Ubicables.posicion.PosicionReal;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class IntegracionJuegoTest {

    @Test
    public void test01ElJuegoSeIniciaCorrectamente (){

        Juego juego = new Juego("Diego", "Maradona",100,100);

        Assert.assertFalse(juego.finalizo());
    }


    @Test
    public void test02ElCastilloNoAtacaALasPiezasQueEstenEnSuRangoCuandoNoEsSuTurno (){
        Juego juego = new Juego("Diego", "Maradona",20,20);
        Mapa mapa = juego.getMapa();

        // primero paso unos turnos para asegurarme no tener problemas con el oro

        for (int i = 0; i < 8; i++) {
            juego.pasarJugada();
        }

        Jugador jugadorActivo = juego.getJugadorActual();


        //me fijo la posicion del castillo para saber con que jugador estoy jugando (el turno es al azar!)

        if  (!jugadorActivo.getCastillo().getPosicion().seSuperponeCon(new PosicionReal(1,1))){

            // es el jugador de arriba a la derecha, lo voy a cambiar
            juego.pasarJugada();
            jugadorActivo = juego.getJugadorActual();
        }

        // el castillo esta en 16:16 de ahi hacia arriba y a la derecha.
        // el rango de ataque es 3.

        //Pongo un aldeano en rango de ataque del otro castillo
        jugadorActivo.getPlazas().get(0).crearAldeano(jugadorActivo,mapa,new PosicionReal(16,13));


        // pongo un cuartel en del rango de ataque del castillo
        jugadorActivo.getAldeanos().get(0).construirEdificio(new Cuartel(),mapa,jugadorActivo,new PosicionReal(17,13));

        //Recupero las piezas colocadas
        Aldeano aldeanoEnRango= jugadorActivo.getAldeanos().get(3);
        Cuartel cuartelEnRango= jugadorActivo.getCuarteles().get(0);

        int vidaAldeano = (new Aldeano()).getVidaMaxima();
        int vidaCuartel = (new Cuartel()).getVidaMaxima();
        int danioCastillo = (new Castillo()).getDanioGeneradoAEdificio();   //es el mismo para las dos

        //Como es mi turno, el castillo enemigo no me va a atacar
        Assert.assertThat(aldeanoEnRango.getVidaActual(),is(vidaAldeano));
        Assert.assertThat(cuartelEnRango.getVidaActual(),is(vidaCuartel));

    }

    @Test
    public void test03ElCastilloAtacaALasPiezasQueEstenEnSuRangoEnSuTurno (){

        Juego juego = new Juego("Diego", "Maradona",20,20);
        Mapa mapa = juego.getMapa();

        // primero paso unos turnos para asegurarme no tener problemas con el oro
        for (int i = 0; i < 8; i++) {
            juego.pasarJugada();
        }


        Jugador jugadorActivo = juego.getJugadorActual();


        //me fijo la posicion del castillo para saber con que jugador estoy jugando (el turno es al azar!)

      if  (!jugadorActivo.getCastillo().getPosicion().seSuperponeCon(new PosicionReal(1,1))){

          // es el jugador de arriba a la derecha, lo voy a cambiar
          juego.pasarJugada();
          jugadorActivo = juego.getJugadorActual();
      }

       // el castillo esta en 16:16 de ahi hacia arriba y a la derecha.
        // el rango de ataque es 3.

        //Pongo un aldeano en rango de ataque del otro castillo
        jugadorActivo.getPlazas().get(0).crearAldeano(jugadorActivo,mapa,new PosicionReal(16,13));

        // pongo un cuartel en del rango de ataque del castillo
        jugadorActivo.getAldeanos().get(0).construirEdificio(new Cuartel(),mapa,jugadorActivo,new PosicionReal(17,13));

        //Recupero las piezas colocadas

        Aldeano aldeanoEnRango= jugadorActivo.getAldeanos().get(3);
        Cuartel cuartelEnRango= jugadorActivo.getCuarteles().get(0);


        int vidaAldeano = (new Aldeano()).getVidaMaxima();
        int vidaCuartel = (new Cuartel()).getVidaMaxima();
        int danioCastillo = (new Castillo()).getDanioGeneradoAEdificio();   //es el mismo para las dos

        //Paso el turno para que ataque
        juego.pasarJugada();

        Assert.assertThat(aldeanoEnRango.getVidaActual(),is(vidaAldeano-danioCastillo));
        Assert.assertThat(cuartelEnRango.getVidaActual(),is(vidaCuartel-danioCastillo));




    }

    @Test
    public void test04ElCastilloNoAtacaALasPiezasQueNoEstenEnSuRangoCuandoNoEsSuTurno (){

        Juego juego = new Juego("Diego", "Maradona",20,20);
        Mapa mapa = juego.getMapa();

        // primero paso unos turnos para asegurarme no tener problemas con el oro
        for (int i = 0; i < 8; i++) {
            juego.pasarJugada();
        }


        Jugador jugadorActivo = juego.getJugadorActual();


        //me fijo la posicion del castillo para saber con que jugador estoy jugando (el turno es al azar!)

        if  (!jugadorActivo.getCastillo().getPosicion().seSuperponeCon(new PosicionReal(1,1))){

            // es el jugador de arriba a la derecha, lo voy a cambiar
            juego.pasarJugada();
            jugadorActivo = juego.getJugadorActual();
        }

        // el castillo esta en 16:16 de ahi hacia arriba y a la derecha.
        // el rango de ataque es 3.



        // pongo un aldeano fuera del rango de ataque del castillo
        jugadorActivo.getPlazas().get(0).crearAldeano(jugadorActivo,mapa,new PosicionReal(16,12));


        // pongo un cuartel fuera del rango de ataque del castillo
        jugadorActivo.getAldeanos().get(1).construirEdificio(new Cuartel(),mapa,jugadorActivo,new PosicionReal(17,9));

        //Recupero las piezas colocadas


        Aldeano aldeanoFueraDeRango=jugadorActivo.getAldeanos().get(3);

        Cuartel cuartelFueraDeRango=jugadorActivo.getCuarteles().get(0);

        int vidaAldeano = (new Aldeano()).getVidaMaxima();
        int vidaCuartel = (new Cuartel()).getVidaMaxima();
        int danioCastillo = (new Castillo()).getDanioGeneradoAEdificio();   //es el mismo para las dos

        //no es su turno y estan fuera del rango, quedan intactas

        Assert.assertThat(aldeanoFueraDeRango.getVidaActual(),is(vidaAldeano));
        Assert.assertThat(cuartelFueraDeRango.getVidaActual(),is(vidaCuartel));
    }

    @Test
    public void test05ElCastilloNoAtacaALasPiezasQueNOEstenEnSuRangoEnSuTurno (){

        Juego juego = new Juego("Diego", "Maradona",20,20);
        Mapa mapa = juego.getMapa();

        // primero paso unos turnos para asegurarme no tener problemas con el oro
        for (int i = 0; i < 8; i++) {
            juego.pasarJugada();
        }


        Jugador jugadorActivo = juego.getJugadorActual();


        //me fijo la posicion del castillo para saber con que jugador estoy jugando (el turno es al azar!)

        if  (!jugadorActivo.getCastillo().getPosicion().seSuperponeCon(new PosicionReal(1,1))){

            // es el jugador de arriba a la derecha, lo voy a cambiar
            juego.pasarJugada();
            jugadorActivo = juego.getJugadorActual();
        }

        // el castillo esta en 16:16 de ahi hacia arriba y a la derecha.
        // el rango de ataque es 3.



        // pongo un aldeano fuera del rango de ataque del castillo
        jugadorActivo.getPlazas().get(0).crearAldeano(jugadorActivo,mapa,new PosicionReal(16,12));


        // pongo un cuartel fuera del rango de ataque del castillo
        jugadorActivo.getAldeanos().get(1).construirEdificio(new Cuartel(),mapa,jugadorActivo,new PosicionReal(17,9));

        //Recupero las piezas colocadas


        Aldeano aldeanoFueraDeRango=jugadorActivo.getAldeanos().get(3);
        Cuartel cuartelFueraDeRango=jugadorActivo.getCuarteles().get(0);

        int vidaAldeano = (new Aldeano()).getVidaMaxima();
        int vidaCuartel = (new Cuartel()).getVidaMaxima();
        int danioCastillo = (new Castillo()).getDanioGeneradoAEdificio();   //es el mismo para las dos

        //paso turno para que ataque, pero como no estan en su rango no hace nada
        juego.pasarJugada();

        Assert.assertThat(aldeanoFueraDeRango.getVidaActual(),is(vidaAldeano));
        Assert.assertThat(cuartelFueraDeRango.getVidaActual(),is(vidaCuartel));
    }






    @Test
    public void test05AlMatarAlCastilloElJuegoTerminaYElGanadorEsElJugadorActivoQueLoMato (){

        Juego juego = new Juego("Diego", "Maradona",20,20);
        Mapa mapa = juego.getMapa();

        // primero paso unos turnos para asegurarme no tener problemas con el oro
        for (int i = 0; i < 100; i++) {
            juego.pasarJugada();
        }


        Jugador jugadorActivo = juego.getJugadorActual();
        Jugador jugadorEnemigo = juego.getJugadorInactivo();


        //me fijo la posicion del castillo para saber con que jugador estoy jugando (el turno es al azar!)

        if  (!jugadorActivo.getCastillo().getPosicion().seSuperponeCon(new PosicionReal(1,1))){

            // es el jugador de arriba a la derecha, lo voy a cambiar
            juego.pasarJugada();
            jugadorActivo = juego.getJugadorActual();
            jugadorEnemigo = juego.getJugadorInactivo();
        }

        // el castillo esta en 16:16 de ahi hacia arriba y a la derecha.
        // el rango de ataque es 3.

        // pongo un cuartel fuera del rango de ataque del castillo
        jugadorActivo.getAldeanos().get(1).construirEdificio(new Cuartel(),mapa,jugadorActivo,new PosicionReal(17,9));

        //Paso 3 turnos para que el cuartel este construido

        for (int i = 0; i < 6; i++) {
            juego.pasarJugada();

        }



        // creo posiciones para ubicar arqueros para atacar el castillo
        PosicionReal posicion1= new PosicionReal(16,15);
        PosicionReal posicion2= new PosicionReal(16,16);
        PosicionReal posicion3= new PosicionReal(16,17);
        PosicionReal posicion4= new PosicionReal(16,18);

        //armo una lista
        ArrayList<PosicionReal> posiciones = new ArrayList<>();
        posiciones.add(posicion1);posiciones.add(posicion2);posiciones.add(posicion3);posiciones.add(posicion4);

        //Recupero el cuartel
        Cuartel cuartelFueraDeRango=jugadorActivo.getCuarteles().get(0);
        // recupero el castillo enemigo
        Castillo castilloEnemigo = juego.getJugadorInactivo().getCastillo();
        int antiLoop = 400;

        //mientras el castillo enemigo tenga vida, trato de colocar unidades y atacarlo
        while (castilloEnemigo.getVidaActual()>0 ||antiLoop==0){

            // los paso aca arriba por que el juego puede terminar en cualquier ataque
            juego.pasarJugada();//el otro
            juego.pasarJugada();//mi turno


            for (PosicionReal posicion : posiciones){
                //si me los mato o no hay nada, creo el arquero y lo coloco
                if(mapa.puedoColocar(posicion,1)){
                    cuartelFueraDeRango.crearArquero(jugadorActivo,mapa,posicion);
                }

            }
            //ataco con todos los arqueros
            for (Arquero arquero : jugadorActivo.getArqueros()){
                arquero.atacar(castilloEnemigo,jugadorActivo,jugadorEnemigo,mapa);
            }



            antiLoop-=1;
        }

        Assert.assertTrue(juego.finalizo());
        Assert.assertThat(juego.getWinner(),is(jugadorActivo));
    }

    @Test
    public void test06EdificioMientrasSeConstruyePuedeSerAtacadoIgual (){

        Juego juego = new Juego("Diego", "Maradona",20,20);
        Mapa mapa = juego.getMapa();

        // primero paso unos turnos para asegurarme no tener problemas con el oro
        for (int i = 0; i < 8; i++) {
            juego.pasarJugada();
        }


        Jugador jugadorActivo = juego.getJugadorActual();


        //me fijo la posicion del castillo para saber con que jugador estoy jugando (el turno es al azar!)

        if  (!jugadorActivo.getCastillo().getPosicion().seSuperponeCon(new PosicionReal(1,1))){

            // es el jugador de arriba a la derecha, lo voy a cambiar
            juego.pasarJugada();
            jugadorActivo = juego.getJugadorActual();
        }

        // el castillo esta en 16:16 de ahi hacia arriba y a la derecha.
        // el rango de ataque es 3.


        // pongo un cuartel en del rango de ataque del castillo
        jugadorActivo.getAldeanos().get(0).construirEdificio(new Cuartel(),mapa,jugadorActivo,new PosicionReal(17,13));

        //Recupero las piezas colocadas


        Cuartel cuartelEnRango= jugadorActivo.getCuarteles().get(0);


        int vidaAldeano = (new Aldeano()).getVidaMaxima();
        int vidaCuartel = (new Cuartel()).getVidaMaxima();
        int danioCastillo = (new Castillo()).getDanioGeneradoAEdificio();   //es el mismo para las dos

        //Paso el turno para que ataque
        juego.pasarJugada();

        //Como el cuartel no esta construido, no puede crear unidades.
        Assert.assertFalse(cuartelEnRango.puedocrearUnidad());

        Assert.assertThat(cuartelEnRango.getVidaActual(),is(vidaCuartel-danioCastillo));
    }

    @Test
    public void test07ElJuegoComienzaCon3Aldeanos1PlazaCentral1CastilloCadaJugador(){

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
    public void test08AlpasarDeTurnoCambiaElJugador(){

        Juego juego = new Juego("Maradona","Messi",500,500);
        Jugador jugadorActual= juego.getJugadorActual();
        Jugador jugadorInactivo= juego.getJugadorInactivo();

        juego.pasarJugada();

        Jugador nuevoJugadorActual = juego.getJugadorActual();

        Assert.assertThat(jugadorInactivo,is(nuevoJugadorActual));
    }

    @Test
    public void test09AlpasarDosVecesDeJugadorElJugadorEsElMismo(){

        Juego juego = new Juego("Maradona","Messi",500,500);
        Jugador jugadorActual= juego.getJugadorActual();
       // Jugador jugadorInactivo= juego.getJugadorInactivo();

        juego.pasarJugada();
        juego.pasarJugada();

        Jugador nuevoJugadorActual = juego.getJugadorActual();

        Assert.assertThat(jugadorActual,is(nuevoJugadorActual));
    }

}
