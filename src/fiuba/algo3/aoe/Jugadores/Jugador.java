package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Tablero.Tablero;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Jugador {

    private String nombre;
    private Tablero tablero;
    private int oro;


    public Jugador(String nombre,Tablero tablero){
        this.nombre = nombre;
        this.tablero = tablero;
        this.oro = 0;
    }


    public String getNombre(){return this.nombre;
    }
    public int getOro(){return this.oro;}

    public void agregarUbicable( Ubicable ubicable, Posicion posicion ) {

        if (this.hayOroSuficiente(ubicable.costo())) {
            if (this.tablero.puedoColocar(posicion)) {
                tablero.colocar(ubicable, posicion);
                this.descontarOro(ubicable.costo());
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
}
