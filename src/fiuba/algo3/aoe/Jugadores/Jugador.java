package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.EstadoJugador;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorDeshabilitado;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorHabilitado;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Mapa.PosicionDelMapaOcupadaException;
import fiuba.algo3.aoe.Ubicables.Atacable;
import fiuba.algo3.aoe.Ubicables.Direccion.DireccionArribaDerecha;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
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
    private Mapa mapa;  //Todo es necesario?
    private int oro;
    private EstadoJugador estado; // todo sacar
    private List<Manipulable> unidades;
    private List<Manipulable> edificios;
    private ArrayList<ObservadorJugador> observadores;

    private final int POBLACION_MAXIMA = 50;

    public Jugador(String nombre, Mapa mapa){
        this.nombre = nombre;
        this.mapa = mapa;
        this.oro = 100;
        this.estado = new JugadorDeshabilitado();
        this.unidades = new ArrayList<>();
        this.edificios = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    //TODO REFACTOR A TODOS LOS IF URGENTE
/*
    //TODO refactor!
    public void inicializar (){

            Aldeano aldeano;
            for(int i = 0;i<3;i++){
                 aldeano= new Aldeano();
                 this.agregarPieza(aldeano);
                 this.mapa.colocar(aldeano,new Posicion(i+1,1));

                for(ObservadorJugador unObservador : this.observadores){
                    unObservador.seCreo(aldeano);
                }
            }

            PlazaCentral plaza = new PlazaCentral();
            plaza.construir();
            plaza.construir();
            plaza.construir();
            Castillo castillo = new Castillo();
            this.agregarPieza (plaza);
            this.mapa.colocar(plaza,new Posicion(20,20));
            edificios.add (castillo);
            this.mapa.colocar(castillo,new Posicion(30,30));

            for(ObservadorJugador unObservador : this.observadores){
                unObservador.seCreo(plaza);
                unObservador.seCreo(castillo);
             }

        }

    public void inicializar (Posicion unaPosicion){

        Posicion posicionAuxiliar = unaPosicion;

        Castillo castillo = new Castillo();
        agregarPieza (castillo);
        for(ObservadorJugador unObservador : this.observadores){
            unObservador.seCreo(castillo);
        }

        this.mapa.colocar(castillo,posicionAuxiliar);

        for(int i = 1; i<= 8; i++)
            posicionAuxiliar = posicionAuxiliar.calcularPosicionSiguiente(new DireccionArribaDerecha());

        PlazaCentral plaza = new PlazaCentral();
        plaza.construir();
        plaza.construir();
        plaza.construir();
        this.edificios.add (plaza);
        for(ObservadorJugador unObservador : this.observadores){
            unObservador.seCreo(plaza);
        }
        this.mapa.colocar(plaza, posicionAuxiliar);
        //la plaza se crea a 8 unidades distancia diagonal respecto a la posicion

        posicionAuxiliar = unaPosicion;

        for(int i = 1; i<= 3; i++)
            posicionAuxiliar = posicionAuxiliar.calcularPosicionSiguiente(new DireccionArribaDerecha());

        // los aldeanos se crean a 4, 5 y 6 unidades de distancia diagonal respecto a la posicion
        Aldeano aldeano;
        for(int i = 0;i<3;i++){
            aldeano= new Aldeano();
            this.agregarPieza(aldeano);
            posicionAuxiliar = posicionAuxiliar.calcularPosicionSiguiente(new DireccionArribaDerecha());
            this.mapa.colocar(aldeano,posicionAuxiliar);
            for(ObservadorJugador unObservador : this.observadores){
                unObservador.seCreo(aldeano);
            }
        }


    }
*/
    public String getNombre(){return this.nombre;
    }

    private int getOro(){return this.oro;} //Todo es necesario?


    //pre: tiene que haber oro.
    //lo tiene que poder colocar
    //pos: tiene que descontar el oro
    //
    private void agregarPieza(UnidadMovil pieza) {

        if(this.alcanzoLimiteDePoblacion()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        this.unidades.add(pieza);


        /*
        if (this.hayOroSuficiente(ubicable.getCosto())) {
            if (this.mapa.puedoColocar(posicion)) {
                mapa.colocar(ubicable, posicion);
                this.descontarOro(ubicable.getCosto());
            }
        }
        */
    }

    private void agregarPieza(Edificio pieza) {


        this.edificios.add(pieza);


        /*
        if (this.hayOroSuficiente(ubicable.getCosto())) {
            if (this.mapa.puedoColocar(posicion)) {
                mapa.colocar(ubicable, posicion);
                this.descontarOro(ubicable.getCosto());
            }
        }
        */
    }



    public Boolean esMio( Manipulable pieza) {
        return ((this.unidades.contains(pieza)) ||(this.edificios.contains(pieza)));

    }


    private boolean hayOroSuficiente(int costo) {
        return (costo <= this.oro);
    }


    private void descontarOro ( int costo ) throws RecursoInsuficienteException{

        if(this.hayOroSuficiente(costo)){this.oro -= costo;}
        else throw new RecursoInsuficienteException();
    }

    public void sumarOro(int oro) {
        this.oro += oro;
    }


/*
    public void habilitar (){

        this.estado = new JugadorHabilitado();
        for (Manipulable pieza : this.piezas){
             pieza.huboUnCambioDeTurno(this);
        }
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
*/
  /*
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
        this.agregarPieza(plaza);

        for(ObservadorJugador unObservador : this.observadores) {
            unObservador.seCreo(plaza);
        }



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
        this.agregarPieza(cuartel);
        for(ObservadorJugador unObservador : this.observadores){
        unObservador.seCreo(cuartel);}
    }
*/
    private boolean alcanzoLimiteDePoblacion(){

        return  (this.unidades.size() == POBLACION_MAXIMA);
    }
/*
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
        this.agregarPieza(aldeano);
        //coloar aldeano en el tablero
        for(ObservadorJugador unObservador : this.observadores){unObservador.seCreo(aldeano);}


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
        this.agregarPieza(armaDeAsedio);
        for(ObservadorJugador unObservador : this.observadores){unObservador.seCreo(armaDeAsedio);}

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
        this.agregarPieza(espadachin);
        for(ObservadorJugador unObservador : this.observadores){unObservador.seCreo(espadachin);}





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
        this.agregarPieza(arquero);
        for(ObservadorJugador unObservador : this.observadores){unObservador.seCreo(arquero);}

    }
*/
    // yo tengo que estar inactivo
    // el castillo no tiene que ser mio
    // TODO como obtengo la posicion donde colocarlo?

    /*
    public void RecibirAtaque (Castillo castillo){

        // para cada uno de mis elementos aplicar   castillo.atacar (elemento)

    }
*/

    public void agregarObservador(ObservadorJugador unObservador) {
        this.observadores.add(unObservador);
    }



    public void eliminarPieza ( Manipulable pieza) {
      /*
        if(!this.esMio(pieza)){
            throw new UnidadAgenaException();
        }
        piezas.remove(unidadMovil);
        mapa.remover(unidadMovil);
        poblacionActual-=1;
        */
    }



    public ArrayList<Atacable> getPiezas (){return new ArrayList<>();}

    /*
    public void recibirAtaqueCastillo (Castillo unCastilloEnemigo){

        if(!this.esMio(unCastilloEnemigo)){
            //ataca a todos
            for ( Atacable enemigo : piezas ) {
                //aca decidir que hacer, un try por si vuelve excepcion fuera de rango
                //2 optar por que castillo no haga nada si los tiene fuera de rango

                unCastilloEnemigo.atacar (enemigo);
            }
        }


    }

*/

    public Boolean puedoAgregar(UnidadMovil pieza){return true;}
    public Boolean puedoAgregar(Edificio pieza){return true;}

}