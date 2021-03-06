package fiuba.algo3.aoe.modelo.Jugadores;


import fiuba.algo3.aoe.modelo.Jugadores.Piezas.ListaDePiezas;
import fiuba.algo3.aoe.modelo.Jugadores.Piezas.PiezaAgenaException;
import fiuba.algo3.aoe.modelo.Observadores.ObservableJugador;
import fiuba.algo3.aoe.modelo.Observadores.ObservadorJugador;
import fiuba.algo3.aoe.modelo.Ubicables.Atacable;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadAldeano.Aldeano;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.ArmaDeAsedio;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Arquero;
import fiuba.algo3.aoe.modelo.Ubicables.Unidades.UnidadesMilitares.Espadachin;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.EdificioConstruible;
import fiuba.algo3.aoe.modelo.Ubicables.Edificios.PlazaCentral;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Jugador implements ObservableJugador {

    private String nombre;
    private int oro;
    private ListaDePiezas piezas;
    private ArrayList<ObservadorJugador>observadores;
    private final int ORO_INICIAL = 100;
    private final int ALDEANOS_INICIALES = 3;


    public Jugador(String nombre, Castillo castillo, PlazaCentral plaza, ArrayList<Aldeano> aldeanos){
        this.nombre = nombre;
        this.oro = ORO_INICIAL;
        this.piezas = new ListaDePiezas(castillo);
        this.inicializar(plaza, aldeanos);
        this.observadores= new ArrayList<>();
    }

    private void inicializar (PlazaCentral plaza, ArrayList<Aldeano> listaAldeanos){

       if (!(listaAldeanos.size()==ALDEANOS_INICIALES)){throw new CantidadIncorrectaAldeanosException();}

        for (Aldeano aldeano: listaAldeanos){
             this.piezas.agregar(aldeano);    //si agregas repetidos salta aca

         }
         this.piezas.agregar(plaza);
    }

    public String getNombre(){return this.nombre;}

    public Boolean puedoAgregar(UnidadMovil pieza){  //revisa poblacion y que no este, costo negativo y oro
        return (this.hayOroSuficiente(pieza.getCosto()) &&
                this.piezas.puedoAgregar(pieza)&& (pieza.getCosto()>=0) );

        }
    public Boolean puedoAgregar(EdificioConstruible pieza){
        return (this.hayOroSuficiente(pieza.getCosto()) &&
                this.piezas.puedoAgregar(pieza) && (pieza.getCosto()>=0) );
    }

    //Seters
    public void agregarPieza(Aldeano pieza) {

        //poblacion y que no este repetida
       if (!this.piezas.puedoAgregar(pieza)){throw new NoSePuedeAgregarPiezaException();}

        //este lanza excepcion si no hay oro o es negativo
        this.descontarOro(pieza.getCosto());

         this.piezas.agregar(pieza);

         this.notificarObservadores();

    }
    public void agregarPieza(Arquero pieza) {

        //poblacion y que no este repetida
        if (!this.piezas.puedoAgregar(pieza)){throw new NoSePuedeAgregarPiezaException();}

        //este lanza excepcion si no hay oro o es negativo
        this.descontarOro(pieza.getCosto());

        this.piezas.agregar(pieza);

        this.notificarObservadores();

    }
    public void agregarPieza(Espadachin pieza) {

        //poblacion y que no este repetida
        if (!this.piezas.puedoAgregar(pieza)){throw new NoSePuedeAgregarPiezaException();}

        //este lanza excepcion si no hay oro o es negativo
        this.descontarOro(pieza.getCosto());

        this.piezas.agregar(pieza);
        this.notificarObservadores();

    }
    public void agregarPieza(ArmaDeAsedio pieza) {

        //poblacion y que no este repetida
        if (!this.piezas.puedoAgregar(pieza)){throw new NoSePuedeAgregarPiezaException();}

        //este lanza excepcion si no hay oro o es negativo
        this.descontarOro(pieza.getCosto());

        this.piezas.agregar(pieza);
        this.notificarObservadores();

    }
    public void agregarPieza(Cuartel cuartel) {
        //que no este repetida
        if (!this.piezas.puedoAgregar(cuartel)){throw new NoSePuedeAgregarPiezaException();}
        this.descontarOro(cuartel.getCosto()); //este lanza excepcion si no hay oro
        this.piezas.agregar(cuartel);
        this.notificarObservadores();

    }
    public void agregarPieza(PlazaCentral plaza) {
        //que no este repetida
        if (!this.piezas.puedoAgregar(plaza)){throw new NoSePuedeAgregarPiezaException();}
        this.descontarOro(plaza.getCosto()); //este lanza excepcion si no hay oro
        this.piezas.agregar(plaza);
        this.notificarObservadores();
    }

    public void eliminarPieza ( Manipulable pieza) {
        if(!this.esMio(pieza)){ throw new PiezaAgenaException();}
            this.piezas.eliminar(pieza);

        this.notificarObservadores();
     }

    public boolean esMio( Atacable pieza) {
       return this.piezas.existe(pieza);
     }

    private boolean hayOroSuficiente(int costo) {
        return (costo <= this.oro);
    }
    public void sumarOro(int oro) {
        if (oro<0) {throw new OroNegativoException();}
        this.oro += oro;
    }
    private void descontarOro ( int costo ) throws RecursoInsuficienteException{
        if (costo<0) {throw new CostoNegativoExeption();}
        if(!this.hayOroSuficiente(costo)){throw new RecursoInsuficienteException();}
        this.oro -= costo;
    }

    public void esTuTurno(){this.piezas.cambioDeTurno(this);}



    public Castillo getCastillo(){
        return this.piezas.obtenerCastle();
    }
    public List<PlazaCentral> getPlazas(){
        return this.piezas.obtenerPlazas();
    }
    public List<Cuartel> getCuarteles(){
        return this.piezas.obtenerCuartels();
    }
    public List<Atacable> getAtacables (){ return this.piezas.obtenerAtacables();}
    public List<Aldeano> getAldeanos(){
        return this.piezas.obtenerAldeanos();
    }
    public List<Espadachin> getEspadachines(){
        return this.piezas.obtenerEspadachins();
    }
    public List<Arquero> getArqueros(){
        return this.piezas.obtenerArquers();
    }
    public List<ArmaDeAsedio> getArmasDeAsedio(){
        return this.piezas.obtenerArmasDeAsedio();
    }


    public int getOro() {
        return this.oro;
    }
    public int getPoblacionActual() {
        return this.piezas.getCantidadDeUnidades();

    }


    @Override
    public void agregarObservadores(ObservadorJugador unObservador) {
        this.observadores.add(unObservador);
    }

    private void notificarObservadores(){
        for (ObservadorJugador unObservador : this.observadores){
            unObservador.actualizar();
        }

    }
}