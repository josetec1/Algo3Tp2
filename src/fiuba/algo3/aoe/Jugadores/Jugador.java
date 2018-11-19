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
        this.oro = 100;
        this.estado = new JugadorDeshabilitado();
        this.piezas = new ArrayList<>();
        poblacionActual = 0;
        poblacionMaxima=50;
        this.observador = new ObservadorDeJugador(); //TODO esto es.... provisorio, sino hay que cambiar el constructor.

    }

    //TODO REFACTOR A TODOS LOS IF URGENTE

    //TODO refactor!
    public void inicializar (){

            Aldeano aldeano;
            for(int i = 0;i<3;i++){
                 aldeano= new Aldeano();
                 this.agregarNotificable(aldeano);
                 this.mapa.colocar(aldeano,new Posicion(i+1,1));
                 observador.seCreo(aldeano); //notifico
            }

            PlazaCentral plaza = new PlazaCentral();
            plaza.construir();
            plaza.construir();
            plaza.construir();
            Castillo castillo = new Castillo();
            piezas.add (plaza);
            this.mapa.colocar(plaza,new Posicion(20,20));
            piezas.add (castillo);
            this.mapa.colocar(castillo,new Posicion(30,30));
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
    public Boolean esMio( NotificableDeTurno ubicable ) {

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
        if(!this.esMio(unidad)){
            throw new UnidadAgenaException();
        }
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
        if(!this.esMio(aldeano)){
            throw new UnidadAgenaException();
        }
        PlazaCentral plaza = aldeano.crearPlazaCentral();
        if(!mapa.puedoColocar(posicion,plaza.getTamanio())){
            aldeano.cambiarARecolectando();
            throw new PosicionDelMapaOcupadaException();
        }
        this.descontarOro(plaza.getCosto());
        mapa.colocar(plaza,posicion);
        this.agregarNotificable(plaza);
        observador.seCreo(plaza);


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
        if(!this.esMio(aldeano)){
            throw new UnidadAgenaException();
        }
        Cuartel cuartel = aldeano.crearCuartel();
        if(!mapa.puedoColocar(posicion,cuartel.getTamanio())){
            aldeano.cambiarARecolectando();
            throw new PosicionDelMapaOcupadaException();
        }
        this.descontarOro(cuartel.getCosto());
        mapa.colocar(cuartel,posicion);
        this.agregarNotificable(cuartel);
        observador.seCreo(cuartel);
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
        if(!this.esMio(unaPlaza)){
            throw new EdificioAgenoException();
        }
        Aldeano aldeano = unaPlaza.construirAldeano(this);
        if(!mapa.puedoColocar(posicion,aldeano.getTamanio())) {
            this.sumarOro(aldeano.getCosto());
            throw new PosicionDelMapaOcupadaException();
        }
        mapa.colocar(aldeano,posicion);
        this.agregarNotificable(aldeano);
        //coloar aldeano en el tablero
        observador.seCreo(aldeano);

    }

    //EsMio
    public void reclutarArmaDeAsedio (Castillo unCastillo,Posicion posicion){
        if(this.alcanzoLimiteDePoblacion()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        if(!this.esMio(unCastillo)){
            throw new EdificioAgenoException();
        }
        ArmaDeAsedio armaDeAsedio= unCastillo.construirArmaDeAsedio(this);
        if(!mapa.puedoColocar(posicion,armaDeAsedio.getTamanio())) {
            this.sumarOro(armaDeAsedio.getCosto());
            throw new PosicionDelMapaOcupadaException();
        }
        mapa.colocar(armaDeAsedio,posicion);
        this.agregarNotificable(armaDeAsedio);
        observador.seCreo(armaDeAsedio);
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
        if(!this.esMio(unCuartel)){
            throw new EdificioAgenoException();
        }
        Espadachin espadachin = unCuartel.construirEspadachin(this);
        if(!mapa.puedoColocar(posicion,espadachin.getTamanio())) {
            this.sumarOro(espadachin.getCosto());
            throw new PosicionDelMapaOcupadaException();
        }
        mapa.colocar(espadachin,posicion);
        this.agregarNotificable(espadachin);
        observador.seCreo(espadachin);




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
        if(!this.esMio(unCuartel)){
            throw new EdificioAgenoException();
        }
        Arquero arquero = unCuartel.construirArquero(this);
        if(!mapa.puedoColocar(posicion,arquero.getTamanio())) {
            this.sumarOro(arquero.getCosto());
            throw new PosicionDelMapaOcupadaException();
        }
        mapa.colocar(arquero,posicion);
        this.agregarNotificable(arquero);
        observador.seCreo(arquero);
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