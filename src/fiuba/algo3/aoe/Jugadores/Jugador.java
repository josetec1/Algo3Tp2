package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

public class Jugador {

    private String nombre;
    private Mapa mapa;
    private int oro;
    private boolean activo;


    public Jugador(String nombre, Mapa mapa){
        this.nombre = nombre;
        this.mapa = mapa;
        this.oro = 0;
        this.activo = false;
    }


    public String getNombre(){return this.nombre;
    }
    public int getOro(){return this.oro;}

    public void agregarUbicable( Ubicable ubicable, Posicion posicion ) {

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

    public Boolean esTuTurno() { return activo; } //TODO testear esto, y que el jugador arranque inactivo
                                                   // que al pasar el turno este quede activo si es su turno, etc

    public void setActivo (){this.activo = true;}
}
