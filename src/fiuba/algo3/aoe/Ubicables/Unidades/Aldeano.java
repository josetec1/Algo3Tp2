package fiuba.algo3.aoe.Ubicables.Unidades;


import fiuba.algo3.aoe.Jugadores.Jugador;
import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;

import fiuba.algo3.aoe.Ubicables.Unidades.EstadoUnidad.Aldeano.*;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Aldeano extends UnidadMovil  {

    private IEstadoUnidadAldeano estado;

    private final int VIDA_MAXIMA = 50;
    private final int COSTO = 25;

    public Aldeano( ){
        this.vidaMaxima = VIDA_MAXIMA;
        this.vidaActual = VIDA_MAXIMA;
        this.costo = COSTO;
        this.estado = new EstadoLibreYRecolectando();
    }

    public int getVidaMaxima(){
        return this.vidaMaxima;
    }

    public int getVidaActual(){return this.vidaActual;}

    public void disminuirVida( int vida){
        this.vidaActual-= vida;
    }

    public void entregarElOro (Jugador jugador){jugador.sumarOro(20);}


    //TODO si no se puede mover por que la posicion esta ocupada, deberia responder algo!
    @Override
    public void mover(Mapa mapa, Direccionable direccion) {

        this.estado.mover(this, mapa,direccion);

    }

    @Override
    public void huboUnCambioDeTurno(Jugador jugador) {
        this.estado.pasarTurno(this, jugador);

    }




    //Antes de llamar a este metodo hay que preguntar si el aldeano esta disponible!
    //Pos devuelve el edificio en construccion y el aldeano queda en estado construyendo
    public PlazaCentral crearPlazaCentral() {

        PlazaCentral unaPlaza =new PlazaCentral();
        unaPlaza = (PlazaCentral) this.estado.construir(this,unaPlaza);

        //colocar el edificio en construccion en el mapa.
        //TODO coloco el edificio enel mapa o lo coloca otro?
         return unaPlaza;
    }

    public Cuartel crearCuartel() {

        Cuartel cuartel =new Cuartel();
        cuartel = (Cuartel) this.estado.construir(this,cuartel);

        //colocar el edificio en construccion en el mapa.
        //TODO coloco el edificio enel mapa o lo coloca otro?
        return cuartel;
    }

    //TODO verificar que el edificio se tenga que reparar
    public void reparar (Edificio unEdificio){
       this.estado.reparar(this,unEdificio);
    }



    // no usar desde afuera.
    public void cambiarAContruyendo(){
        this.estado= new EstadoConstruyendo();
    }

    public void cambiarARecolectando(){this.estado= new EstadoLibreYRecolectando();}
    public void cambiarAMoviendose() {
        this.estado = new EstadoMoviendoseYRecolectando();
    }

    public void cambiarAReparando(Edificio unEdificio) {
        this.estado = new EstadoReparando(this, unEdificio);
    }

    //Siempre usar este metodo antes de llamar a reparar o construir
    public Boolean podesConstruirORepar() {
        return this.estado.puedoConstruirOReparar();
    }
    public boolean podesMoverte() {
        return this.estado.podesMoverte();
    }



}
