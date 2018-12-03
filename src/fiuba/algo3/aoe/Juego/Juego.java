package fiuba.algo3.aoe.Juego;
import fiuba.algo3.aoe.Juego.Turno.ModosDeInicio.ModoInicioRandom;
import fiuba.algo3.aoe.Juego.Turno.Turno;
import fiuba.algo3.aoe.Juego.estadoJuego.EnCurso;
import fiuba.algo3.aoe.Juego.estadoJuego.Ijuego;

import fiuba.algo3.aoe.Juego.estadoJuego.JuegoFinalizadoException;
import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Jugadores.ObservadorCastillo;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.Ubicables.posicion.PosicionReal;

import java.util.ArrayList;
import java.util.Observable;

public class Juego extends Observable implements ObservadorCastillo {

    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa mapa;
    private Turno turno;
    private Ijuego juego;

    public Juego(String jugador1, String jugador2, int anchoMapa, int altoMapa) {
                //TODO chequear minimos
        this.inicializar(jugador1, jugador2,anchoMapa,altoMapa) ;


    }

    private void inicializar ( String jugador1, String jugador2, int anchoMapa, int altoMapa) {
        Mapa mapa= new Mapa(anchoMapa, altoMapa);


        //Variables auxiliares
        ArrayList<Jugador> jugadores= new ArrayList<>();
        ArrayList<Aldeano> aldeanos ;
        Aldeano aldeano;
        Castillo castillo;
        PlazaCentral plazaCentral;
        Jugador j1;
        Jugador j2;

        //Inicializo jugador 1
        castillo = new Castillo();
        mapa.colocar(castillo,new PosicionReal(1,1));
        castillo.agregarObservador(this);

        //agrego plaza central
        plazaCentral = new PlazaCentral();
        plazaCentral.finalizarConstruccion();
        mapa.colocar(plazaCentral,new PosicionReal(5,1));


        //agrego aldeanos
        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            mapa.colocar(aldeano,new PosicionReal(7 + (i*3), (i*2+3)));
            aldeanos.add(aldeano);
        }



        j1= new Jugador(jugador1,castillo, plazaCentral, aldeanos);
        this.jugador1 = j1;
        jugadores.add (j1);

        //Prueba vista con arquero colocado
        //Arquero arquero = new Arquero();
       // mapa.colocar(arquero,new Posicion(new Cuadrante(8,8)));
      //  j1.agregarPieza(arquero);

        //Inicializo jugador 2
        castillo = new Castillo();
        castillo.agregarObservador(this);
        mapa.colocar(castillo,new PosicionReal(anchoMapa- 4, altoMapa - 4));


        plazaCentral = new PlazaCentral();
        plazaCentral.finalizarConstruccion();
        mapa.colocar(plazaCentral,new PosicionReal(anchoMapa -7, altoMapa - 4));


        aldeanos = new ArrayList<>();
        for(int i = 0; i<3; i++){
            aldeano= new Aldeano();
            mapa.colocar(aldeano,new PosicionReal(anchoMapa - (10 + i), altoMapa -(4+i)));
            aldeanos.add(aldeano);

        }

        j2= new Jugador(jugador2,castillo, plazaCentral,aldeanos);
        this.jugador2=j2;
        jugadores.add (j2);


        this.mapa = mapa;
        this.turno = new Turno(jugadores, new ModoInicioRandom());
        this.juego = new EnCurso();


    }

    public void pasarJugada() {

        if (this.juego.juegoTerminado()) { throw new JuegoFinalizadoException();}
           //1) paso turno y cada unidad del jugador activo hace lo que tiene que hacer
        this.juego.cambiarTurno(this.turno);
        // 2) chequeo muertos para que se eliminen,
        // //aca salta si es fin de juego por que el castillo me va a mandar un mensaje y ahi me cambio a juego finalizado
        // y le notifico a la vista.
        // la vista siempre ante una notificacion hace  juego.finalizado()  si le da true muetra al ganador  y fin
       // jugador1.revisarMuertos(jugador2, this.mapa);
       // jugador2.revisarMuertos(jugador1,this.mapa);
        //3) ahora notifico a observadores, osea la vista vuelve a cargar las cosas devuelta.
        this.setChanged();
        this.notifyObservers();

    }

    public Jugador getJugadorActual() {
        return this.juego.getJugadorActivo(this.turno);
    }
    public Jugador getJugadorUno (){return this.jugador1;}
    public   Jugador getJugadorDos (){return this.jugador2;}
    public Mapa getMapa(){
        return mapa;
    }

    // el controlador antes de hacer pasar jugada tiene que preguntar.
    // si el juego finalizo, no tiene que pasar turno
    // tiene que evitar cargar el castillo y mostrar el ganador (recordemos que el castillo no se elimina del modelo)
    // osea jugador.getCastillo ... va a seguir estando
    public boolean finalizo(){
        return this.juego.juegoTerminado();
    }



    @Override
    public void gano(Jugador victorioso) {//aca me avisa el castillo que murio
        //tengo que cambiar a estado finalizado.
        // estado finalizado se deberia crearse con el jugador victorioso
        // this.juego= new Finalizado (o.);

        //me parece que aca no hace falta actualizar, por que la llamada de esto viene en pasar jugada
        // y despues de esta llamada, en pasar juegada, viene la notificacion a observadores

    }
}
