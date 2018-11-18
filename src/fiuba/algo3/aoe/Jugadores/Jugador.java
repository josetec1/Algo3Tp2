package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.EstadoJugador;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorDeshabilitado;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorHabilitado;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Direccion.Direccionable;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Cuartel;
import fiuba.algo3.aoe.Ubicables.Edificios.PlazaCentral;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.Aldeano;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Arquero;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMilitar.Espadachin;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Mapa mapa;
    private int oro;
    private EstadoJugador estado;
    private List<Ubicable> piezas;


    public Jugador(String nombre, Mapa mapa){
        this.nombre = nombre;
        this.mapa = mapa;
        this.oro = 0;
        this.estado = new JugadorDeshabilitado();
        this.piezas = new ArrayList<>();
    }


    public String getNombre(){return this.nombre;
    }

    public int getOro(){return this.oro;} //Todo es necesario?


    //pre: tiene que haber oro.
    //lo tiene que poder colocar
    //pos: tiene que descontar el oro
    //
    private void agregarUbicable( Ubicable ubicable, Posicion posicion ) {

        piezas.add(ubicable);

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
        //TODO notificar a mis elementos  hubouncambiode turno

    }

    public void deshabilitar() { this.estado = new JugadorDeshabilitado();   }


    //mueve la unidad en la direccion especificada
    //chequeos, que la unidad sea mia
    // que es mi turno
    //derivados del tablero.  ocupado fuera de limite
    public void mover (UnidadMovil unidad, Direccionable direccion){

    }

    // estoy activo
    //origen es mio,  destino no es mio
    //derivados de unidad, ataque fuera de rango
    public void atacar (Ubicable miUbicable, Ubicable ubicableEnemigo){}

    // estoy activo
    // que sea mio
    // que este disponible el aldeano
    // que haya plata
    // derivados de tablero, fuera de rango, no se puede colocar
    // TODO quien va a crear la posicion de la plaza????
    public void construirPlaza (Aldeano aldeano, Posicion posicion){  //TODO esto sale con Factory simple

        aldeano.podesConstruirORepar();
        PlazaCentral plaza = aldeano.crearPlazaCentral();
        //colocar la plaza


    }

    // estoy activo
    // que sea mio
    // que este disponible el aldeano
    // que haya plata
    // derivados de tablero, fuera de rango, no se puede colocar
    // TODO quien va a crear la posicion de la plaza????
    public void construirCuartel (Aldeano aldeano, Posicion posicion){

        aldeano.podesConstruirORepar();
        Cuartel cuartel = aldeano.crearCuartel();
        //colocar la plaza


    }

    // estoy activo
    // que sea mia la plaza
    // Limites poblacionales
    // que haya plata
    // derivados de tablero, no se puede colocar
    // TODO como obtengo la posicion donde colocarlo?
    public void reclutarAldeano (PlazaCentral unaPlaza){

        Aldeano aldeano = unaPlaza.construirAldeano();
        //agregar aldeano
        //coloar aldeano en el tablero

    }

    // estoy activo
    // que sea mia la plaza
    // Limites poblacionales
    // que haya plata
    // derivados de tablero, no se puede colocar
    // TODO como obtengo la posicion donde colocarlo?
    public void reclutarEspadacion (Cuartel unCuartel){

        Espadachin espadachin = unCuartel.construirEspadachin();
        //agregar aldeano
        //coloar aldeano en el tablero

    }

    // estoy activo
    // que sea mia la plaza
    // Limites poblacionales
    // que haya plata
    // derivados de tablero, no se puede colocar
    // TODO como obtengo la posicion donde colocarlo?
    public void reclutarArquero (Cuartel unCuartel){  // TODO esto sale con factory simple

        Arquero arquero = unCuartel.construirArquero();
        //agregar aldeano
        //coloar aldeano en el tablero

    }

    // yo tengo que estar inactivo
    // el castillo no tiene que ser mio
    // TODO como obtengo la posicion donde colocarlo?
    public void RecibirAtaque (Castillo castillo){

        // para cada uno de mis elementos aplicar   castillo.atacar (elemento)

    }

}