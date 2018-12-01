package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.EstadoJugador;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorIniciado;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorSinIniciar;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorYaIniciadoException;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Jugador extends Observable implements Observer {

    private String nombre;
    private int oro;
    private EstadoJugador estadoInicial;
    private List<Manipulable> unidades;
    private List<Manipulable> edificios;


    private final int POBLACION_MAXIMA = 50;
    private final int ORO_INICIAL = 100;
    private final int ALDEANOS_INICIALES = 3;


    public Jugador(String nombre, Castillo castillo){
        this.nombre = nombre;
        this.oro = ORO_INICIAL;
        this.unidades = new ArrayList<>();
        this.edificios = new ArrayList<>();
        this.estadoInicial = new JugadorSinIniciar();

        this.edificios.add(castillo);

    }

    public void inicializar (PlazaCentral plaza , ArrayList<Aldeano> listaAldeanos){
       if (this.estadoInicial.iniciado()) {throw new JugadorYaIniciadoException();}
       if (!(listaAldeanos.size()==ALDEANOS_INICIALES)){throw new CantidadIncorrectaAldeanosException();}
       if (esMio(plaza)) {throw new PiezaYaAgregadaException();}

         for (Aldeano aldeano: listaAldeanos){
             if (esMio(aldeano)) {throw new PiezaYaAgregadaException();}
             this.unidades.add(aldeano);

             aldeano.addObserver(this); //agrego el observador que me va a avisar cambios en la unidad

         }
        this.edificios.add(plaza);
        this.estadoInicial = new JugadorIniciado();
    }

    public String getNombre(){return this.nombre;}

    public Boolean puedoAgregar(UnidadMovil pieza){
        return (this.hayOroSuficiente(pieza.getCosto()) &&
                !this.esMio(pieza) && !this.alcanzoLimiteDePoblacion()&& (pieza.getCosto()>=0) );

        }

    public Boolean puedoAgregar(Edificio pieza){
        return (this.hayOroSuficiente(pieza.getCosto()) &&
                !this.esMio(pieza) && (pieza.getCosto()>=0) );
    }


    public void agregarPieza(UnidadMovil pieza) {

        if(this.alcanzoLimiteDePoblacion()){throw new LimiteDePoblacionAlcanzadoException();}
        if (this.esMio(pieza)) {throw new PiezaYaAgregadaException();}
        this.descontarOro(pieza.getCosto()); //este lanza excepcion si no hay oro

        this.unidades.add(pieza);
         pieza.addObserver(this);


    }
    public void agregarPieza(Edificio pieza) {

        if (this.esMio(pieza)) {throw new PiezaYaAgregadaException();}
        this.descontarOro(pieza.getCosto()); //este lanza excepcion si no hay oro
        this.edificios.add(pieza);
    }

    public void eliminarPieza ( Manipulable pieza) {

        if(!this.esMio(pieza)){ throw new PiezaAgenaException();}

        this.unidades.remove(pieza);
        this.edificios.remove(pieza);

    }

    public boolean esMio( Manipulable pieza) {
        return ((this.unidades.contains(pieza)) ||(this.edificios.contains(pieza)));

    }

    public void sumarOro(int oro) {
        if (oro<0) {throw new OroNegativoException();}
        this.oro += oro;
    }

    public ArrayList<Atacable> getPiezas (){

        ArrayList<Atacable> lista= new ArrayList<>();
        lista.addAll(this.unidades);
        lista.addAll(this.edificios);
        return lista;

    }

    private boolean alcanzoLimiteDePoblacion(){ return  (this.unidades.size() == POBLACION_MAXIMA);    }
    private boolean hayOroSuficiente(int costo) {
        return (costo <= this.oro);
    }
    private void descontarOro ( int costo ) throws RecursoInsuficienteException{
        if (costo<0) {throw new CostoNegativoExeption();}
        if(!this.hayOroSuficiente(costo)){throw new RecursoInsuficienteException();}

        this.oro -= costo;
    }

    public void esTuTurno(){

        for (Manipulable pieza : this.unidades){
            pieza.huboUnCambioDeTurno(this);
        }
        for (Manipulable pieza : this.edificios){
            pieza.huboUnCambioDeTurno(this);
        }
    }

    //XXSentinela
    public ArrayList<Aldeano> getAldeanos(){


        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        Aldeano aldeanoxxx= (Aldeano)this.unidades.get(0);
        aldeanos.add(aldeanoxxx);
         aldeanoxxx= (Aldeano)this.unidades.get(1);
        aldeanos.add(aldeanoxxx);
         aldeanoxxx= (Aldeano)this.unidades.get(2);
        aldeanos.add(aldeanoxxx);


        return aldeanos;

    }

    //XXSentinela
    public Castillo getCastillo(){

        Castillo castillo = (Castillo)this.edificios.get(0);
        return castillo;

    }

    //XXSentinela
    public PlazaCentral getPlaza(){

        PlazaCentral Plaza = (PlazaCentral) this.edificios.get(1);
        return Plaza;

    }


    @Override
    public void update(Observable o, Object arg) {
        this.setChanged(); //esto es propio del Observer, si no llamas a esto no notifica.
        this.notifyObservers(); //le notifico a la vista que hubo un cambio
    }
}