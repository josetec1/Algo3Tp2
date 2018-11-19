package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.EstadoJugador;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorDeshabilitado;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorHabilitado;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Mapa.PosicionDelMapaOcupadaException;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.NotificableDeTurno;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.AldeanoOcupadoException;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.ArmaDeAsedio;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements ObservableJugador{

    private String nombre;
    private Mapa mapa;
    private int oro;
    private EstadoJugador estado;
    private List<NotificableDeTurno> piezas;
    private ObservadorJugador observador;
    private int poblacionActual;
    private int poblacionMaxima;

    public Jugador(String nombre, Mapa mapa){
        this.nombre = nombre;
        this.mapa = mapa;
        this.oro = 0;
        this.estado = new JugadorDeshabilitado();
        this.piezas = new ArrayList<>();
        poblacionActual = 0;
        poblacionMaxima=50;


    }

    //TODO refactor!
    public void inicializar (){

            Aldeano aldeano;
            Posicion posicion;
            for(int i = 0;i<3;i++){
                 aldeano= new Aldeano();
                 piezas.add(aldeano);
                 this.mapa.colocar(aldeano,new Posicion(i+1,i+2));
                 observador.seCreo(aldeano); //notifico
            }

            PlazaCentral plaza = new PlazaCentral();
            Castillo castillo = new Castillo();
            piezas.add (plaza);
            this.mapa.colocar(plaza,new Posicion(6,6));
            piezas.add (castillo);
            this.mapa.colocar(castillo,new Posicion(11,11));
            observador.seCreo(plaza);
            observador.seCreo(castillo);

        }

    public String getNombre(){return this.nombre;
    }

    public int getOro(){return this.oro;} //Todo es necesario?


    //pre: tiene que haber oro.
    //lo tiene que poder colocar
    //pos: tiene que descontar el oro
    //
    public void agregarNotificable( NotificableDeTurno notificable) {

        poblacionActual +=1;
        piezas.add(notificable);

        /*
        if (this.hayOroSuficiente(ubicable.getCosto())) {
            if (this.mapa.puedoColocar(posicion)) {
                mapa.colocar(ubicable, posicion);
                this.descontarOro(ubicable.getCosto());
            }
        }
        */
    }
    public Boolean esMio( Ubicable ubicable ) {

        return piezas.contains(ubicable);

        /*
        if (this.hayOroSuficiente(ubicable.getCosto())) {
            if (this.mapa.puedoColocar(posicion)) {
                mapa.colocar(ubicable, posicion);
                this.descontarOro(ubicable.getCosto());
            }
        }
        */
    }


    public boolean hayOroSuficiente(int costo) {
        return (costo <= this.oro);
    }


    public void descontarOro ( int costo ) throws RecursoInsuficienteException{

        if(this.hayOroSuficiente(costo)){this.oro -= costo;}
        else throw new RecursoInsuficienteException();
    }

    public void sumarOro(int oro) {
        this.oro += oro;
    }



    public void habilitar (){
        this.estado = new JugadorHabilitado();
        for(int i = 0;i<piezas.size();i++){
            piezas.get(i).huboUnCambioDeTurno(this);
        }
        //TODO notificar a mis elementos  hubouncambiode turno

    }

    public void deshabilitar() { this.estado = new JugadorDeshabilitado();   }


    //mueve la unidad en la direccion especificada
    //chequeos, que la unidad sea mia
    // que es mi turno
    public void mover (UnidadMovil unidad, Direccionable direccion){

        unidad.mover(mapa,direccion);
    }

    // estoy activo
    //origen es mio,  destino no es mio
    //derivados de unidad, ataque fuera de rango
    //public void atacar (Ubicable miUbicable, Ubicable ubicableEnemigo){}

    // estoy activo
    // que sea mio
    // que este disponible el aldeano
    // que haya plata
    // derivados de tablero, fuera de rango, no se puede colocar
    // TODO quien va a crear la posicion de la plaza????
    public void construirPlaza ( Aldeano aldeano, Posicion posicion){  //TODO esto sale con Factory simple
        if(!aldeano.podesConstruirORepar()) {
            throw new AldeanoOcupadoException();
        }
        if(!mapa.puedoColocar(posicion)){
            throw new PosicionDelMapaOcupadaException();
            // this.observador.seCreo(plaza);
        }
        PlazaCentral plaza = aldeano.crearPlazaCentral();
        this.descontarOro(plaza.getCosto());
        mapa.colocar(plaza,posicion);


      //  this.observador.seCreo(plaza);

    }

    // estoy activo
    // que sea mio
    // que este disponible el aldeano
    // que haya plata
    // derivados de tablero, fuera de rango, no se puede colocar
    // TODO quien va a crear la posicion de la plaza????
    public void construirCuartel ( Aldeano aldeano, Posicion posicion){  //TODO esto sale con Factory simple
        if(!aldeano.podesConstruirORepar()) {
            throw new AldeanoOcupadoException();
        }
        if(!mapa.puedoColocar(posicion)){
            throw new PosicionDelMapaOcupadaException();
            // this.observador.seCreo(plaza);
        }
        Cuartel cuartel = aldeano.crearCuartel();
        this.descontarOro(cuartel.getCosto());
        mapa.colocar(cuartel,posicion);
    }

    public boolean alcanzoLimiteDePoblacion(){
        return poblacionActual == poblacionMaxima;
    }

    // EsMio
    // estoy activo
    // que sea mia la plaza
    // Limites poblacionales
    // derivados de tablero, no se puede colocar
    // TODO como obtengo la posicion donde colocarlo?
    public void reclutarAldeano (PlazaCentral unaPlaza,Posicion posicion){
        if(this.alcanzoLimiteDePoblacion()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        Aldeano aldeano = unaPlaza.construirAldeano(this);
        mapa.colocar(aldeano,posicion);
        this.agregarNotificable(aldeano);
        //coloar aldeano en el tablero

    }

    //EsMio
    public void reclutarArmaDeAsedio (Castillo unCastillo,Posicion posicion){
        if(this.alcanzoLimiteDePoblacion()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        if(!mapa.puedoColocar(posicion)) {
            throw new PosicionDelMapaOcupadaException();
        }
        ArmaDeAsedio armaDeAsedio= unCastillo.construirArmaDeAsedio(this);
        mapa.colocar(armaDeAsedio,posicion);
        this.agregarNotificable(armaDeAsedio);
        //coloar aldeano en el tablero

    }
    // EsMIo
    // estoy activo
    // que sea mia la plaza
    // Limites poblacionales
    // derivados de tablero, no se puede colocar
    // TODO como obtengo la posicion donde colocarlo?
    public void reclutarEspadachin (Cuartel unCuartel,Posicion posicion){
        if(this.alcanzoLimiteDePoblacion()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        if(!mapa.puedoColocar(posicion)) {
            throw new PosicionDelMapaOcupadaException();
        }
        Espadachin espadachin = unCuartel.construirEspadachin(this);
        mapa.colocar(espadachin,posicion);
        this.agregarNotificable(espadachin);




    }
    // EsMIo
    // estoy activo
    // que sea mia la plaza
    // Limites poblacionales
    // derivados de tablero, no se puede colocar
    // TODO como obtengo la posicion donde colocarlo?
    public void reclutarArquero ( Cuartel unCuartel, Posicion posicion ){  // TODO esto sale con factory simple
        if(this.alcanzoLimiteDePoblacion()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        if(!mapa.puedoColocar(posicion)) {
            throw new PosicionDelMapaOcupadaException();
        }
        Arquero arquero = unCuartel.construirArquero(this);
        mapa.colocar(arquero,posicion);
        this.agregarNotificable(arquero);
    }

    // yo tengo que estar inactivo
    // el castillo no tiene que ser mio
    // TODO como obtengo la posicion donde colocarlo?
    public void RecibirAtaque (Castillo castillo){

        // para cada uno de mis elementos aplicar   castillo.atacar (elemento)

    }


    public void agregarObservador(ObservadorJugador unObservador) {
        this.observador= unObservador;
    }

    public void eliminarUnidad ( UnidadMovil unidadMovil) {
        if(!this.esMio(unidadMovil)){
            throw new UnidadAgenaException();
        }
        piezas.remove(unidadMovil);
        mapa.remover(unidadMovil);
        poblacionActual-=1;
    }
}