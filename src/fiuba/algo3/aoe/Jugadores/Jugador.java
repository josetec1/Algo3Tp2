package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.EstadoJugador;

import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements ObservableJugador{

    private String nombre;
    private int oro;
    private EstadoJugador estado; // todo sacar
    private List<Manipulable> unidades;
    private List<Manipulable> edificios;
    private ArrayList<ObservadorJugador> observadores;

    private final int POBLACION_MAXIMA = 50;
    private final int ORO_INICIAL = 100;

    public Jugador(String nombre){  //TODO constructor sin mapa... me parece que el mapa no va
        this.nombre = nombre;
        this.oro = ORO_INICIAL;
        this.unidades = new ArrayList<>();
        this.edificios = new ArrayList<>();
        this.observadores = new ArrayList<>();

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
    public void agregarObservador(ObservadorJugador unObservador) {
        this.observadores.add(unObservador);
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


}