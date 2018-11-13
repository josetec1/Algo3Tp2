package fiuba.algo3.aoe.Jugadores;

import fiuba.algo3.aoe.Mapa.Mapa;
import fiuba.algo3.aoe.Ubicables.Edificios.Castillo;
import fiuba.algo3.aoe.Ubicables.Edificios.Edificio;
import fiuba.algo3.aoe.Ubicables.Ubicable;
import fiuba.algo3.aoe.Ubicables.Unidades.UnidadMovil;
import fiuba.algo3.aoe.Ubicables.posicion.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Mapa mapa;
    private int oro;
    private List<UnidadMovil> unidades = new ArrayList<UnidadMovil>();
    private List<Edificio> edificios = new ArrayList<Edificio>();


    public Jugador(String nombre, Mapa mapa){
        this.nombre = nombre;
        this.mapa = mapa;
        this.oro = 0;
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


    public void agregarEdificio(Edificio unEdificio) {

        edificios.add(unEdificio);
    }

    public int cantidadEdificios() {
        return edificios.size();
    }

    public void agregarUnidad(UnidadMovil unaUnidad) {

        unidades.add(unaUnidad);
    }

    public int cantidadUnidades() {
        return unidades.size();
    }

    public int cantidadAldeanosDesocupados() {
        int cantidadAldeanos = 0;
        for(int i= 0; i < unidades.size(); i++)
            if(unidades.get(i).esAldeanoDesocupado())cantidadAldeanos++;

        return cantidadAldeanos;
    }

    public void recolectarOro() {

        this.sumarOro(20*cantidadAldeanosDesocupados());
    }

    public void actualizarEdificios(){

        for(int i = 0; i < edificios.size(); i++)
            edificios.get(i).construir();
    }
}
