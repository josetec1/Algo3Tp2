package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.EstadoJugador;

import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorDeshabilitado;
import fiuba.algo3.aoe.Jugadores.EstadoJugador.JugadorHabilitado;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Jugador {

    private String nombre;
    private Mapa mapa;
    private int oro;
    private EstadoJugador estado;


    public Jugador(String nombre, Mapa mapa){
        this.nombre = nombre;
        this.mapa = mapa;
        this.oro = 0;
        this.estado = new JugadorDeshabilitado();
    }


    public String getNombre(){return this.nombre;
    }
    public int getOro(){return this.oro;}

    public void agregarUbicable( Ubicable ubicable, Posicion posicion ) { //TODO este metodo no es necesario. edificios y unidades las crea el jugador

        if (this.hayOroSuficiente(ubicable.getCosto())) {
            if (this.mapa.puedoColocar(posicion)) {
                mapa.colocar(ubicable, posicion);
                this.descontarOro(ubicable.getCosto());
            }
        }
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
}
